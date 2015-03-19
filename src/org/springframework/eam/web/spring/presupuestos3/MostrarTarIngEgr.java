package org.springframework.eam.web.spring.presupuestos3;

///*PDF
//pdf*/
import Ajayu_orm.orm_bd;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.gen;
import org.springframework.eam.domain.Comprometido;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.eam.web.spring.supervisor.CreatePie;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MostrarTarIngEgr implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    /*Descripcion
     * Esta funcion permita sacar la matriz ingresos y egresos de los presupuestos de cualquier tarea segun el parametro de entrada
     * relaciona montos presupuestados, ejecutados ,saldos, montos comprometidos
     * y montos no presupuestados como de los ingresos y egresos
     *
     * matriz de porcentajes de ejecucion de ingresos y egresos
     *
     * relaciona a la matriz tanto de ingreso como egreso
     *
     * totales por partida, fuente y saldos por fuente
     */
    //Parametros de entrada:
    /* Los parametros de entrada son el codigo de la tarea
     * y la activiadad
     */
    /* Como Resultado
     * saca dos matrices ingresos egresos
     * los cuales tienen la partida Vs Fuente economica
     * relacionados con los montos del presupuesto asi como tambien los montos comprometidos
     * matriz de porcentajes de ejecucion
     * saldos totales Reales y mas el comprometido
     *
     */

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String codtar = request.getParameter("codtar");
        modelo.put("codtar", codtar);
        String descripcion = request.getParameter("descripcion");
        modelo.put("descripcion", descripcion);

        System.out.println("Cod tar---" + codtar);
        System.out.println("descri---" + descripcion);

        // codacti = "DC";
        // codtar = "ta1";
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros

        DecimalFormat df2 = new DecimalFormat("###,###,###,##0.00");

        DecimalFormat df3 = new DecimalFormat("###,###,#####0.000000");
        //System.out.println(c.FormatoPer("###.#", f));

        //

        int Coe = 0;
        int fito = 0;
        int coto = 0;
        /*Sacando Datos generales */
        gen tarr = new gen();
        tarr.setCodtar(codtar);

        List ff = orm.ejecutarLista("gral", "codtar", tarr, new gen()); //llamano al _orm la consulta
        modelo.put("grl", ff);
        /*FIN FIN FIN Sacando Datos generales */



        /*Sacando  todo de la actividad en consultas anidadas */
        ProActTar tare = new ProActTar();
        tare.setCodtar(codtar);
        orm.ejecutarObjeto("gral", "selec", tare, tare);
        modelo.put("actividad", tare);

        /*FIN FIN FIN FIN */

        ProActTar tar = new ProActTar();
        tar.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar", "codtar", tar, tar);
        modelo.put("tarea", tar);
        //matriz para el comprometido en porcentajes
        String COM[][] = new String[1000][1000];

        for (int rf = 0; rf < 20; rf++) {
            for (int gu = 0; gu <= 20; gu++) {
                COM[rf][gu] = "0.00";
            }
        }

        String COM2[][] = new String[500][500];
        String MCM[][] = new String[1000][1000];
        String MCMP[][] = new String[500][500];

        int filcom = 0;
        int colcom = 0;
        double supre = 0;
        double sueje = 0;
        int sp = 0;
        int se = 0;

        COM[0][colcom] = "Fuente Economica";
        COM[1][colcom] = "Ingresos";
        COM[2][colcom] = "Egresos";
        colcom++;
        //matriz para el comprometido en porcentajes

        /* Sancando Informes a Ingresos Presupuestados Ejecutados Sados e historial a ejecutados*/

        List mon = orm.ejecutarLista("montosingreso", "mostrar_montos_presupuestados", null, new MosPresuIng());

        /*ALGORITMOOOO*/

        List orden = new ArrayList();
        String M[][] = new String[1000][1000];

        int f = 0;
        int c = 0;
        int Ccl = 2;
        int Fcl = 0;
        int swc = 0;
        int swfe = 0;

        String aa;

        if (mon != null) {//if_1
            for (int i = 0; i < mon.size(); i++) {//for 1

                //System.out.println("SACANDO de la lista");
                MosPresuIng ki = (MosPresuIng) mon.get(i);


                if (codtar.equals(ki.getCodtar())) {//if_2
                    System.out.println("Comparando tarea" + ki.getCodtar());
                    if (f == 0 && c == 0) {//if_3

                        M[0][0] = "-";
                        M[0][1] = "-";
                        M[0][Ccl] = ki.getCodfueneco();
                        M[0][Ccl + 1] = ki.getDesfe();
                        M[0][Ccl + 2] = "-";

                        M[1][0] = "Codigo";
                        M[1][1] = "Partida";

                        M[1][2] = "Presupuestado";
                        M[1][3] = "Ejecutado";
                        M[1][4] = "Saldo";

                        M[2][0] = ki.getCodmoning();
                        M[2][1] = ki.getDescla();

                        M[2][2] = ki.getMonto();
                        M[2][3] = ki.getMoneje();
                        M[2][4] = ki.getSaldo();

                        f = 1;
                        c = 1;
                        Fcl = 3;
                        Ccl = 5;

                    }//if_3
                    else {//else if_3
                        //Existe el clasificador y la cuenta
                        swc = 0;
                        swfe = 0;

                        for (int p = 2; p < Fcl; p++) {//for2
                            System.out.println("VUELTA DOS");
                            String hh = M[p][0];
                            System.out.println("MAT---" + hh + "----" + ki.getCodmoning());

                            if (hh.equals(ki.getCodmoning())) {//if_4System.out.println("MAT---"+hh);
                                System.out.println("Entre");
                                for (int k = 2; k < Ccl; k = k + 3) {//for3
                                    aa = M[0][k];
                                    if (aa.equals(ki.getCodfueneco())) {//if_5
                                        swc = 1;
                                        swfe = 1;

                                        M[p][k] = ki.getMonto();
                                        M[p][k + 1] = ki.getMoneje();
                                        M[p][k + 2] = ki.getSaldo();

                                        k = Ccl;
                                        p = Fcl;

                                    }//if_5
                                }//for3

                            }//if_4

                        }//for2



                        if (swfe == 0) {//if_6
                            for (int iy = 2; iy < Fcl; iy++) {//for_4

                                String fw = M[iy][0];
                                System.out.println("Ex Clasi---" + fw + "----" + ki.getCodmoning());
                                System.out.println("El Fcl---" + Fcl);
                                if (fw.equals(ki.getCodmoning())) //Existe clasificador
                                {//if_7
                                    M[0][Ccl] = ki.getCodfueneco();
                                    M[0][Ccl + 1] = ki.getDesfe();
                                    M[0][Ccl + 2] = "-";

                                    M[1][Ccl] = "Presupuestado";
                                    M[1][Ccl + 1] = "Ejecutado";
                                    M[1][Ccl + 2] = "Saldo";

                                    M[iy][Ccl] = ki.getMonto();
                                    M[iy][Ccl + 1] = ki.getMoneje();
                                    M[iy][Ccl + 2] = ki.getSaldo();

                                    Ccl = Ccl + 3;
                                    swc = 1;
                                    iy = Fcl;

                                }//if_7
                            }//for_4
                        }//if_6

                        ///Existe Fuente Economica
                        if (swc == 0) {//if_8

                            for (int jy = 2; jy < Ccl; jy = jy + 3) {//for_5
                                String qa = M[0][jy];
                                System.out.println("ExisFE---" + qa + "----" + ki.getCodmoning());


                                if (qa.equals(ki.getCodfueneco())) {//if_9
                                    System.out.println("REENTREEE");
                                    M[Fcl][0] = ki.getCodmoning();
                                    M[Fcl][1] = ki.getDescla();

                                    M[Fcl][jy] = ki.getMonto();
                                    M[Fcl][jy + 1] = ki.getMoneje();
                                    M[Fcl][jy + 2] = ki.getSaldo();

                                    Fcl = Fcl + 1;
                                    swfe = 1;
                                    jy = Ccl;

                                }//if_9

                            }//for_5

                        }//if_8

                        //No existe ninguno de los dos
                        if (swfe == 0 && swc == 0) {//if_10
                            M[0][Ccl] = ki.getCodfueneco();
                            M[0][Ccl + 1] = ki.getDesfe();
                            M[0][Ccl + 2] = "-";

                            M[1][Ccl] = "Presupuestado";
                            M[1][Ccl + 1] = "Ejecutado";
                            M[1][Ccl + 2] = "Saldo";

                            M[Fcl][0] = ki.getCodmoning();
                            M[Fcl][1] = ki.getDescla();

                            M[Fcl][Ccl] = ki.getMonto();
                            M[Fcl][Ccl + 1] = ki.getMoneje();
                            M[Fcl][Ccl + 2] = ki.getSaldo();

                            Fcl = Fcl + 1;
                            Ccl = Ccl + 3;
                        }//if_10



                    }//else if_3
                    }//if_2


            }//for 1


        }//if_1




        /*FIN FIN FIN FIN FIN ALGORITMOOOO*/





        /*55555555555555
        List mon_=new ArrayList();
        if(mon != null) {


        for(int i = 0;i< mon.size();i++) {

        //Controlar la ki.getCodtar()==codtar para el reporte Final
        //Llenado la lista nueva
        MosPresuIng ki=(MosPresuIng) mon.get(i);

        float tmpi = new Float(ki.getMonto()).floatValue();
        ki.setMonto(df2.format(tmpi).toString());

        float tmpi2 = new Float(ki.getMoneje()).floatValue();
        ki.setMoneje(df2.format(tmpi2).toString());

        float tmpi3 = new Float(ki.getSaldo()).floatValue();
        ki.setSaldo(df2.format(tmpi3).toString());

        mon_.add(ki);
        }


        //modelo.put("mosz",mmz2);

        modelo.put("mosmoneje",mon_);
        } else {

        modelo.put("mosmoneje",mon);

        }


        55555555555555555555555*/



        //total montospresupuesados  ingresos
        ProActTar to = new ProActTar();
        to.setCodtar(codtar);


        //Sacando la suma del total de montos presupuestados
        String too = new String();
        too = orm.ejecutarObjeto("montosingreso", "tot_presu", to, new String());
        float num1 = 0;
        if (too != null) {
            num1 = new Float(too).floatValue();
        }

        modelo.put("too", df2.format(num1).toString());



        String too1 = new String();
        too1 = orm.ejecutarObjeto("montosingreso", "tot_saldo", to, new String());
        float num2 = 0;
        if (too1 != null) {
            num2 = new Float(too1).floatValue();
        }
        modelo.put("too1", df2.format(num2).toString());


        String too2 = new String();
        too2 = orm.ejecutarObjeto("montosingreso", "tot_ejec", to, new String());
        float nu3 = 0;
        if (too2 != null) {
            nu3 = new Float(too2).floatValue();

        }


        /*3333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333*/
        /*Mostrar lo noprespuestados ejecutados */
        List mm = orm.ejecutarLista("cuentanopresuing", "mostrar_ejecutados", null, new MosPresuIng());

        if (mm != null) {//if_1

            /* for(int s=2;s<Ccl;s++)
            {
            M[Fcl][s]=" ";
            }
            Fcl++;*/
            int Nfcl = Fcl;
            int Nccl = Ccl;
            int sfe = 0;
            int scl = 0;
            int gh = 0;
            for (int io = 0; io < mm.size(); io++) {//for 1
                System.out.println("SACANDO de la lista");
                MosPresuIng kii = (MosPresuIng) mm.get(io);

                if (codtar.equals(kii.getCodtar())) {//if_2
                    sfe = 0;
                    scl = 0;

                    if (gh == 0) {
                        M[Fcl][0] = "Cuentas";
                        M[Fcl][1] = "No Presupuestarias";
                        //M[Fcl][2]="1";
                        Fcl++;
                        gh++;
                    }



                    ///////////////////////////////////////////////////////////////////////////////
                    //existe fuente economica y clasificador no presupuestario

                    for (int ic = Nfcl; ic < Fcl; ic++) {//for22
                        if (M[ic][0].equals(kii.getCodmonnopreing())) {//if_3n
                            for (int kc = 2; kc < Nccl; kc = kc + 3) {
                                if (M[0][kc].equals(kii.getCodfueneco())) {
                                    M[ic][kc + 1] = kii.getMonejenopre();
                                    sfe = 1;
                                    scl = 1;
                                }
                            }
                        }//if_3n
                    }//for22
                    ////////////////////////////////////////////////////////////////////
                    //Existe Fuente Economica no exis clasificadorno PRESU
                    if (sfe == 0) {//if4n
                        for (int fe = 2; fe < Ccl; fe = fe + 3) {
                            if (M[0][fe].equals(kii.getCodfueneco())) {//if5n
                                M[Fcl][0] = kii.getCodmonnopreing();
                                M[Fcl][1] = kii.getDescla();

                                M[Fcl][fe + 1] = kii.getMonejenopre();
                                scl = 1;
                                Fcl++;
                            }//if5n
                        }
                    }//if4n
                               /*
                    //Existe Clasificador no exis fuente
                    if(scl==0)
                    {//if6n
                    for(int cla=Nfcl;cla<Fcl;cla++)
                    {
                    if(M[cla][0].equals(kii.getCodmonnopreing()))
                    {//if7n
                    M[0][Ccl]=kii.getCodfueneco();
                    M[0][Ccl+1]=kii.getDesfe();

                    M[1][Ccl]="Presupuestado";
                    M[1][Ccl+1]="Ejecutado";
                    M[1][Ccl+2]="Saldo";

                    M[cla][Ccl+1]=kii.getMonejenopre();
                    Ccl=Ccl+3;
                    }//if7n
                    }
                    }//if6n
                     */
                }
            }//for 1

        }//if_1


        int gg = 1;
        String MB[][] = new String[100][1000];
        /*MOSS*/
        /*Buscano null a cero La matriz*/
        System.out.println("FOR1");
        for (int z = 0; z < Fcl; z++) {
            for (int zz = 0; zz < Ccl; zz++) {

                if (M[z][zz] == null) {
                    M[z][zz] = "0";
                }

            }

        }

        /*FIN FINN FIN Buscano null a cero La matriz*/





        /*Sacando Totales INGRESOS*/
        double Sum = 0;
        double Sum2 = 0;
        double SS = 0;
        int co = 2;
        if (mon != null) {
            /*Total por filas*/
            M[0][Ccl] = " ";
            M[1][Ccl] = "Totales";

            for (int t = 2; t < Fcl; t++) {
                for (int w = 2; w < Ccl; w = w + 3) {
                    double tnm = new Double(M[t][w]).doubleValue();
                    SS = SS + tnm;

                }

                M[t][Ccl] = df2.format(SS).toString();

                SS = 0;
            }
            /*FIN FIN FIN FIN FIN FIN Total por filas*/


            System.out.println("FOR2------------------------------------------------------------------------------------------------------------------------------------------------------*********");
            for (int u = 0; u < Fcl; u++) {
                for (int uu = 0; uu < Ccl; uu++) {
                    System.out.print(M[u][uu] + "     ");

                }
                System.out.println(" ");
                System.out.println(" ");
            }


            //creando matriz para los saldos disponibles por fuentes

            int col = 0;
            int cmb = 2;

            MB[0][0] = "-";
            MB[1][0] = "Total Ejecutado Ingresos";
            MB[2][0] = "Total Ejecutado Egresos";
            MB[3][0] = "Saldos Disponibles";
            MB[4][0] = "Saldos real menos el Comprometido en Gastos";
            for (col = 1; col < Ccl; col = col + 2) {
                MB[0][col] = M[0][cmb];
                MB[0][col + 1] = M[0][cmb + 1];
                cmb = cmb + 3;
            }
            Coe = col - 2;

            M[Fcl][0] = " Ingresos ";
            M[Fcl][1] = "Totales";
            double Sie = 0;

            for (int uv = 2; uv < Ccl; uv++) {
                for (int uuv = 2; uuv < Fcl; uuv++) {
                    double tmpi = new Double(M[uuv][uv]).doubleValue();
                    Sum = Sum + tmpi;


                    M[uuv][uv] = df2.format(tmpi).toString();

                }






                /*Para los comprometidos para el porcentaje total*/
                if (M[1][uv].equals("Presupuestado")) {

                    System.out.println("  " + M[1][uv] + "   " + Sum);
                    //indices para la matriz de porcentajes filcom;:::colcom
                    //System.out.println("  "+M[1][uv]+"   "+Sum);
                    //System.out.println("**************************************************************************************  "+M[0][uv]);
                    //System.out.println("**************************************************************************************  "+M[0][uv]);

                    COM[0][colcom] = M[0][uv];
                    //colcom++;
                    supre = Sum;
                    sp = 1;


                    MB[1][gg] = String.valueOf(Sum);
                    System.out.println("ff" + MB[1][gg]);
                    // 456546546546465465465465465465465465465465465464654
                    System.out.println("ff2" + MB[1][gg + 1]);
                    MB[1][gg + 1] = " ";


                    //gg=gg+2;
                    //coto=gg;


                }
                /*Fin fin para los comprometidos p�arta el porcentaje*/

                //insertando a la matriz de saldos
                if (M[1][uv].equals("Ejecutado")) {
                    System.out.println("EEEEEEEEEEEEEEEE" + Sum);
                    System.out.println("  " + M[1][uv] + "   " + Sum);
                    MB[1][gg] = String.valueOf(Sum);
                    System.out.println("ff" + MB[1][gg]);
                    // 456546546546465465465465465465465465465465465464654
                    System.out.println("ff2" + MB[1][gg + 1]);
                    MB[1][gg + 1] = " ";
                    gg = gg + 2;
                    coto = gg;
                    sueje = Sum;
                    se = 1;

                }


                if (se == 1 && sp == 1) {



                    if (supre != 0) {
                        COM[1][colcom] = Double.toString((sueje / supre) * 100);
                    }//por la divicion entre cero del presupuestado
                    else {
                        COM[1][colcom] = "0";
                    }

                    colcom++;
                    se = 0;
                    sp = 0;
                }










                M[Fcl][co] = df2.format(Sum).toString();
                co++;
                Sum = 0;
            }






        }
        //coto=Ccl;
        Fcl++;
        Ccl++;//por los totales
        /*FIN FI FIN FIN FIN FIN FINSacando Totales INGRESOS*/

        /*Mostrando La matriz*/
        //99 System.out.println("FOR2------------------------------------------------------------------------------------------------------------------------------------------------------*********");
        for (int u = 0; u < Fcl; u++) {
            for (int uu = 0; uu < Ccl; uu++) {
                //99 System.out.print(M[u][uu]+"     ");
            }
            //99   System.out.println(" ");
            //99   System.out.println(" ");
        }

        modelo.put("Ccl", String.valueOf(Ccl));
        modelo.put("Fcl", String.valueOf(Fcl));
        modelo.put("M", M);

        /*Mostrando La matriz*/

        /*FIN FIN FIN FIN MOSS*/
        /*
        List mm_=new ArrayList();

        if(mm != null){
        for(int i = 0;i< mm.size();i++) {
        MosPresuIng km=(MosPresuIng) mm.get(i);

        float tmpm = new Float(km.getMonejenopre()).floatValue();
        km.setMonejenopre(df2.format(tmpm).toString());

        mm_.add(km);
        }


        modelo.put("mos",mm_);
        } else{
        modelo.put("mos",mm);
        }

         */
        //



        String too3 = new String();
        too3 = orm.ejecutarObjeto("cuentasnopresuing", "tot_ejec", to, new String());


        float nu4 = 0;
        if (too3 != null) {
            nu4 = new Float(too3).floatValue();
        }
        float nu5 = nu3 + nu4;

        modelo.put("too3", df2.format(nu5).toString());


        /*FIN FIN FIN FIN Sancando Informes a Ingresos Presupuestados Ejecutados Sados e historial a ejecutados*/













        /* Sancando Informes a EGRESOS Presupuestados Ejecutados Sados e historial a ejecutados*/







        ///A TODOS Z PARA EGRESOS
        List monz = orm.ejecutarLista("montosegreso", "mostrar_montos_presupuestados", null, new MosPresuIng());

        /*555555555555555555555555555555555555555Egreeee*/
        String EM[][] = new String[1000][1000];

        int Ef = 0;
        int Ec = 0;
        int ECcl = 2;
        int EFcl = 0;
        int Eswc = 0;
        int Eswfe = 0;

        String Eaa;

        if (monz != null) {//if_1
            for (int i = 0; i < monz.size(); i++) {//for 1

                //99     System.out.println("SACANDO de la lista");
                MosPresuIng ki = (MosPresuIng) monz.get(i);


                if (codtar.equals(ki.getCodtar())) {//if_2
                    //99     System.out.println("Comparando tarea"+ki.getCodtar());
                    if (Ef == 0 && Ec == 0) {//if_3

                        EM[0][0] = "-";
                        EM[0][1] = "-";
                        EM[0][ECcl] = ki.getCodfueneco();
                        EM[0][ECcl + 1] = ki.getDesfe();
                        EM[0][ECcl + 2] = "-";

                        EM[1][0] = "Codigo";
                        EM[1][1] = "Partida";

                        EM[1][2] = "Presupuestado";
                        EM[1][3] = "Ejecutado";
                        EM[1][4] = "Saldo";

                        EM[2][0] = ki.getCodmoning();
                        EM[2][1] = ki.getDescla();

                        EM[2][2] = ki.getMonto();
                        EM[2][3] = ki.getMoneje();
                        EM[2][4] = ki.getSaldo();

                        Ef = 1;
                        Ec = 1;
                        EFcl = 3;
                        ECcl = 5;

                    }//if_3
                    else {//else if_3
                        //Existe el clasificador y la Fuente
                        Eswc = 0;
                        Eswfe = 0;

                        for (int p = 2; p < EFcl; p++) {//for2
                            //99  System.out.println("VUELTA DOS");
                            String hh = EM[p][0];
                            //99  System.out.println("MAT---"+hh+"----"+ki.getCodmoning());

                            if (hh.equals(ki.getCodmoning())) {//if_4System.out.println("MAT---"+hh);
                                //99   System.out.println("Entre");
                                for (int k = 2; k < ECcl; k = k + 3) {//for3
                                    Eaa = EM[0][k];
                                    if (Eaa.equals(ki.getCodfueneco())) {//if_5
                                        Eswc = 1;
                                        Eswfe = 1;

                                        EM[p][k] = ki.getMonto();
                                        EM[p][k + 1] = ki.getMoneje();
                                        EM[p][k + 2] = ki.getSaldo();

                                        k = ECcl;
                                        p = EFcl;

                                    }//if_5
                                }//for3

                            }//if_4

                        }//for2



                        if (Eswfe == 0) {//if_6
                            for (int iy = 2; iy < EFcl; iy++) {//for_4

                                String fw = EM[iy][0];
                                //99 System.out.println("Ex Clasi---"+fw+"----"+ki.getCodmoning());
                                //99 System.out.println("El Fcl---"+EFcl);
                                if (fw.equals(ki.getCodmoning())) //Existe clasificador
                                {//if_7
                                    EM[0][ECcl] = ki.getCodfueneco();
                                    EM[0][ECcl + 1] = ki.getDesfe();
                                    EM[0][ECcl + 2] = "-";

                                    EM[1][ECcl] = "Presupuestado";
                                    EM[1][ECcl + 1] = "Ejecutado";
                                    EM[1][ECcl + 2] = "Saldo";

                                    EM[iy][ECcl] = ki.getMonto();
                                    EM[iy][ECcl + 1] = ki.getMoneje();
                                    EM[iy][ECcl + 2] = ki.getSaldo();

                                    ECcl = ECcl + 3;
                                    Eswc = 1;
                                    iy = EFcl;

                                }//if_7
                            }//for_4
                        }//if_6

                        ///Existe Fuente Economica
                        if (Eswc == 0) {//if_8

                            for (int jy = 2; jy < ECcl; jy = jy + 3) {//for_5
                                String qa = EM[0][jy];
                                //99 System.out.println("ExisFE---"+qa+"----"+ki.getCodmoning());


                                if (qa.equals(ki.getCodfueneco())) {//if_9
                                    //99 System.out.println("REENTREEE");
                                    EM[EFcl][0] = ki.getCodmoning();
                                    EM[EFcl][1] = ki.getDescla();

                                    EM[EFcl][jy] = ki.getMonto();
                                    EM[EFcl][jy + 1] = ki.getMoneje();
                                    EM[EFcl][jy + 2] = ki.getSaldo();

                                    EFcl = EFcl + 1;
                                    Eswfe = 1;
                                    jy = Ccl;

                                }//if_9

                            }//for_5

                        }//if_8

                        //No existe ninguno de los dos
                        if (Eswfe == 0 && Eswc == 0) {//if_10
                            EM[0][ECcl] = ki.getCodfueneco();
                            EM[0][ECcl + 1] = ki.getDesfe();
                            EM[0][ECcl + 2] = "-";

                            EM[1][ECcl] = "Presupuestado";
                            EM[1][ECcl + 1] = "Ejecutado";
                            EM[1][ECcl + 2] = "Saldo";

                            EM[EFcl][0] = ki.getCodmoning();
                            EM[EFcl][1] = ki.getDescla();

                            EM[EFcl][ECcl] = ki.getMonto();
                            EM[EFcl][ECcl + 1] = ki.getMoneje();
                            EM[EFcl][ECcl + 2] = ki.getSaldo();

                            EFcl = EFcl + 1;
                            ECcl = ECcl + 3;
                        }//if_10



                    }//else if_3
                    }//if_2


            }//for 1


        }//if_1

























        se = 0;
        sp = 0;


        /*FIN FIN FIN FIN Egreeee555555555555555555555555555555*/


        /*
        List monz_=new ArrayList();
        if(monz != null) {

        for(int i = 0;i< monz.size();i++) {
        MosPresuIng kii=(MosPresuIng) monz.get(i);

        float tmpii = new Float(kii.getMonto()).floatValue();
        kii.setMonto(df2.format(tmpii).toString());

        float tmpii2 = new Float(kii.getMoneje()).floatValue();
        kii.setMoneje(df2.format(tmpii2).toString());

        float tmpii3 = new Float(kii.getSaldo()).floatValue();
        kii.setSaldo(df2.format(tmpii3).toString());

        monz_.add(kii);
        }

        modelo.put("mosmonejez",monz_);
        } else {
        modelo.put("mosmonejez",monz);
        }


         */
        DecimalFormat df1 = new DecimalFormat("#,###,###,##0.00");
        //total montospresupuesados  ingresos
        ProActTar toz = new ProActTar();
        toz.setCodtar(codtar);

        //Sacando la suma del total de montos presupuestados
        String tooz = new String();
        tooz = orm.ejecutarObjeto("montosegreso", "tot_presu", toz, new String());
        float num = 0;
        if (tooz != null) {
            num = new Float(tooz).floatValue();
        }
        modelo.put("tooz", df1.format(num).toString());

        String too1z = new String();
        too1z = orm.ejecutarObjeto("montosegreso", "tot_saldo", toz, new String());
        float nu7 = 0;
        if (too1z != null) {
            nu7 = new Float(too1z).floatValue();
        }
        modelo.put("too1z", df2.format(nu7).toString());




        /*88888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888*/
        String too2z = new String();
        too2z = orm.ejecutarObjeto("montosegreso", "tot_ejec", to, new String());

        float nu8 = 0;
        if (too2z != null) {
            nu8 = new Float(too2z).floatValue();
        }




        /*Mostrar lo noprespuestados ejecutados */
        List mmz = orm.ejecutarLista("cuentanopresuegr", "mostrar_ejecutados", null, new MosPresuIng());


        /*nOPRE eGRE*/
        if (mmz != null) {//if_1

            /* for(int s=2;s<Ccl;s++)
            {
            M[Fcl][s]=" ";
            }
            Fcl++;*/
            int Nfcl = EFcl;//55
            int Nccl = ECcl;//55
            int Esfe = 0;
            int Escl = 0;
            int Egh = 0;


            //99   System.out.println("************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************* ");
            //99    System.out.println("************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************* ");
            //99   System.out.println("************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************* ");
            //99    System.out.println("************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************* ");
            //99    System.out.println("************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************* ");

            for (int io = 0; io < mmz.size(); io++) {//for 1
                //99      System.out.println("SACANDO de la lista");
                MosPresuIng kii = (MosPresuIng) mmz.get(io);

                if (codtar.equals(kii.getCodtar())) {//if_2
                    Esfe = 0;
                    Escl = 0;


                    //99         System.out.println("JESUS codtar-----------------------"+codtar);
                    //99         System.out.println("kii.getcodtar----------------"+kii.getCodtar());


                    if (Egh == 0) {
                        EM[EFcl][0] = "Cuentas";
                        EM[EFcl][1] = "No Presupuestarias";
                        //M[Fcl][2]="1";
                        EFcl++;
                        Egh++;
                    }



                    ///////////////////////////////////////////////////////////////////////////////
                    //existe fuente economica y clasificador no presupuestario

                    for (int ic = Nfcl; ic < EFcl; ic++) {//for22
                        //99        System.out.println("EM[][]-----------------------"+EM[ic+1][0]);
                        //99        System.out.println("comncom PARAR----------------"+kii.getCodmonnopreegr());
                        //99        System.out.println();

                        //if(kii.getCodmonnopreegr()!=null) {
                        if (kii.getCodmonnopreegr().equals(EM[ic][0])) {//if_3n
                            for (int kc = 2; kc < Nccl; kc = kc + 3) {
                                if (EM[0][kc].equals(kii.getCodfueneco())) {
                                    EM[ic][kc + 1] = kii.getMonejenopre();
                                    Esfe = 1;
                                    Escl = 1;
                                }
                            }
                        } //}//if_3n
                    }//for22
                    ////////////////////////////////////////////////////////////////////
                    //Existe Fuente Economica no exis clasificadorno PRESU
                    if (Esfe == 0) {//if4n
                        for (int fe = 2; fe < ECcl; fe = fe + 3) {
                            if (EM[0][fe].equals(kii.getCodfueneco())) {//if5n
                                EM[EFcl][0] = kii.getCodmonnopreegr();
                                EM[EFcl][1] = kii.getDescla();

                                EM[EFcl][fe + 1] = kii.getMonejenopre();
                                Escl = 1;
                                EFcl++;
                            }//if5n
                        }
                    }//if4n

                }
            }//for 1

        }//if_1


        /*55555555555555555*/
        int ffco;
        /*MOSS*/
        /*Buscano null a cero La matriz*/
        //99  System.out.println("FOR1");
        for (int z = 0; z < EFcl; z++) {
            for (int zz = 0; zz < ECcl; zz++) {

                if (EM[z][zz] == null) {
                    EM[z][zz] = "0";
                }

            }

        }

        /*FIN FINN FIN Buscano null a cero La matriz*/
        //99  System.out.println("FOR2  EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE------------------------------------------------------------------------------------------------------------------------------------------------------*********");
        for (int u = 0; u < Fcl; u++) {
            for (int uu = 0; uu < Ccl; uu++) {
                //99     System.out.print(EM[u][uu]+"     ");
            }
            //99   System.out.println(" ");
            //99   System.out.println(" ");
        }
        /*Sacando Totales INGRESOS*/
        //float Sum=0;
        // float Sum2=0;
        int coo = 2;
        int ggl = 1;
        if (monz != null) {
            double ESS = 0;
            /*Total por filas*/
            EM[0][ECcl] = " ";
            EM[1][ECcl] = "Totales";

            for (int t = 2; t < EFcl; t++) {
                for (int w = 2; w < ECcl; w = w + 3) {
                    double tnmn = new Double(EM[t][w]).doubleValue();
                    ESS = ESS + tnmn;

                }

                EM[t][ECcl] = df2.format(ESS).toString();

                ESS = 0;
            }



            EM[EFcl][0] = " Egresos ";
            EM[EFcl][1] = "Totales";
            ffco = EFcl;
            for (int uv = 2; uv < ECcl; uv++) {
                Sum = 0;
                for (int uuv = 2; uuv < EFcl; uuv++) {
                    double tmpi = new Double(EM[uuv][uv]).doubleValue();
                    Sum = Sum + tmpi;
                    //99          System.out.println("haaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+tmpi);
                    EM[uuv][uv] = df2.format(tmpi).toString();

                }

                /**comprometido************/
                /*Para los comprometidos para el porcentaje total*/
                //   System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
                //   System.out.println(M[1][uv]);
                if (M[1][uv] != null) {
                    if (M[1][uv].equals("Presupuestado")) {

                        //System.out.println("  "+EM[1][uv]+"   "+Sum);
                        //indices para la matriz de porcentajes filcom;:::colcom


                        for (int cd = 0; cd < colcom; cd++) {
                            if (COM[0][cd].equals(EM[0][uv]))//comprobando si existe la fuente economica en la matriz de comprometido
                            {
                                System.out.print(" ");
                            } else {
                                COM[0][colcom] = EM[0][uv];
                            }
                        }

                        supre = Sum;
                        sp = 1;

                    }
                }
                /*Fin fin para los comprometidos p�arta el porcentaje*/

                /*Comprometido*/                    /*99999999999*/
                if (EM[1][uv].equals("Ejecutado")) {

                    //99       System.out.println("  "+EM[1][uv]+"   "+Sum);

                    for (int gf = 1; gf < coto; gf = gf + 2) {
                        //System.out.println("CONTA       "+ggl);
                        for (int gco = 1; gco < coto; gco = gco + 2) {
                            if (EM[0][uv - 1].equals(MB[0][gco])) {
                                //MB[2][ggl]=String.valueOf(Sum);
                                MB[2][gco] = String.valueOf(Sum);
                                //System.out.println("entra suma egresos 99999999999999999999999999999999999999999999999999999999"+MB[2][ggl]);
                                MB[2][gco + 1] = " ";

                                sueje = Sum;
                                se = 1;


                            }
                        }
                    }



                    ggl = ggl + 2;
                    //99         System.out.println("ff2"+MB[1][ggl+1]);

                }
                /*FIN FIN999999999999*/

                if (se == 1 && sp == 1) {

                    for (int cd = 0; cd < colcom; cd++) {    //System.out.println("comparando para comproooo     ---------     "+COM[0][cd]+" con "+ EM[0][uv-1]);
                        System.out.println("AQUIIIIIIIIIIII     "+COM[0][cd]);
                        if (COM[0][cd].equals(EM[0][uv - 1]))//comprobando si existe la fuente economica en la matriz de comprometido para incertar el porcentaje
                        {
                            //System.out.println(" vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv " + sueje);

                            if (Double.toString(supre).equals(null)) {
                                supre = 0;
                            }


                            if (supre != 0) {
                                COM[2][cd] = Double.toString((sueje / supre) * 100);
                                MCMP[0][cd] = COM[0][cd];//fuente economica
                                MCMP[1][cd] = Double.toString(supre);//monto ejecutado
                                MCMP[2][cd] = Double.toString(sueje);//monto ejecutado
                                }//por la divicion entre cero del presupuestado
                            else {
                                COM[2][cd] = "0";
                            }

                            /*   System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"+Double.toString((sueje/supre)*100));


                            System.out.println("--------------------------------------------------");
                            System.out.println("--------------------------------------------------");
                            System.out.println("--------------------------------------------------");
                            System.out.println("--------------------------------------------------");
                            System.out.println("--------------------------------------------------");
                            System.out.println("--------------------------------------------------");
                            System.out.println("--------------------------------------------------");
                            System.out.println("--------------------------------------------------");
                            System.out.println("--------------------------------------------------");
                            System.out.println("--------------------------------------------------");
                            System.out.println("--------------------------------------------------");
                            System.out.println("--------------------------------------------------");
                            System.out.println("--------------------------------------------------");
                            System.out.println("--------------------------------------------------");
                            System.out.println("--------------------------------------------------");
                            System.out.println(" presupuestado     "+supre);
                            System.out.println(" ejecutado     "+sueje);
                             */

                        } else {
                            // COM[2][cd]=Double.toString((sueje/supre)*100);
                            // colcom++;
                        }
                    }



                    se = 0;
                    sp = 0;
                }



                EM[EFcl][coo] = df2.format(Sum).toString();
                //EM[EFcl][coo]=Float.toString(Sum); //float a string

                //99    System.out.println("TOtal                                                "+EM[EFcl][coo]);
                coo++;

            }
        }



//ffffffffffffffffffffff



        ffco = EFcl;
        EFcl++;
        ECcl++;//por los totales
        /*FIN FI FIN FIN FIN FIN FINSacando Totales INGRESOS*/






        int fini;
        /////coomprometidoooooooooooo

        //99 System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq SACANDO de la Comprometidoooo");
        int inicol = ECcl;
        int ECcll = ECcl;
        int inifil = EFcl;
        int swcom = 0;
        //ECcl;
        //EFcl;
        /////             COMPROMETIDOOOOOOOOOOO
        //////////****************
        Comprometido gr = new Comprometido();
        gr.setCodtar(codtar);
        List cmon = orm.ejecutarLista("comproegr", "mostrar_compro", gr, new Comprometido());
        if (cmon != null) {//if_1
            for (int i = 0; i < cmon.size(); i++) {//for 1

                Comprometido ki = (Comprometido) cmon.get(i);
                //99    System.out.println("Sacanto Comprometido para comparar ---> "+ki.getCodmonegr());

                if (swcom == 0)//primera vez que entra
                {
                    swcom = 1;
                    //99     System.out.println("primera vez");
                    EM[0][ECcll] = ki.getCodfueneco();
                    EM[1][ECcll] = " Monto Comprometido ";
                    for (int Fc = 2; Fc < EFcl; Fc++)//no exite fuente fuente
                    {//for2

                        String hh = EM[Fc][0];
                        //99           System.out.println("comparando Primeravez---"+hh+"----"+ki.getCodmonegr());
                        if (hh.equals(ki.getCodmonegr())) {



                            //double gty = Double.parseDouble(ki.getMonto());
                            //df2.format(gty).toString();
                            EM[Fc][ECcll] = ki.getMonto();
                            ECcll++;
                        }
                    }
                } else {//iffggggg
                    int swcex = 0;

                    //99       System.out.println("Existe Fuente y Partida");
                    for (int Cc = inicol; Cc < ECcll; Cc++)//exite fuente y partida Comprometidos
                    {//for222222222
                        String hh = EM[0][Cc];
                        //99         System.out.println("existen ambos---"+hh+"----"+ki.getCodfueneco());
                        if (hh.equals(ki.getCodfueneco())) {//ifgt
                            for (int fc = 2; fc < EFcl; fc++) {//forrr
                                String ch = EM[fc][0];
                                //99                    System.out.println("existen ambos 22 ---"+ch+"----"+ki.getCodmonegr());
                                if (ch.equals(ki.getCodmonegr())) {//ifttr
                                    swcex = 1;


                                    EM[fc][Cc] = ki.getMonto();
                                    //99                        System.out.println("Se insertoooo ---"+EM[fc][ECcll]);
                                }//ifttr
                            }//forrr
                        }//ifgt

                    }//for222222222


                    if (swcex == 0)//No existe Fuente Economica
                    { //99 System.out.println("No existe Existe Fuente");
                        EM[0][ECcll] = ki.getCodfueneco();
                        EM[1][ECcll] = " Monto Comprometido ";
                        for (int Fc = 2; Fc < EFcl; Fc++)//no exite fuente fuente
                        {//for2
                            //99      //System.out.println("VUELTA DOS");
                            String hh = EM[Fc][0];
                            //99      System.out.println("No existe fuente---"+hh+"----"+ki.getCodmonegr());
                            if (hh.equals(ki.getCodmonegr())) {


                                EM[Fc][ECcll] = ki.getMonto();
                                ECcll++;
                            }
                        }


                    }



                }//iffggggg
            }//for 1
        }//if_1


        ///coompro

        //Sacando los totales para los comprometidos

        double csu = 0;
        for (int cco = inicol; cco < ECcll; cco++) {
            for (int cfi = 2; cfi < ffco; cfi++) {

                if (EM[cfi][cco] != null) {


                    double gty = Double.parseDouble(EM[cfi][cco]);
                    csu = csu + gty;
                    //EM[cfi][cco]=df2.format(gty).toString();
                }
                //
            }
            // EM[ffco][cco]=df2.format(csu).toString();
            //System.out.println("fila "+ffco);
            // System.out.println("Columna "+cco);
            // System.out.println("Matriz "+EM[ffco][cco]);
            // System.out.println("Montoooo "+ csu);
            EM[ffco][cco] = Double.toString(csu);
            csu = 0;
        }

        //FIN FIN FIN Sacando los totales para los comprometidos







        /*Mostrando La matriz*/
        //98 System.out.println("FOR2");
        for (int u = 0; u < EFcl; u++) {
            for (int uu = 0; uu < ECcl; uu++) {
                //98    System.out.print(EM[u][uu]+"     ");
            }
            //98  System.out.println(" ");
            //98  System.out.println(" ");
        }

        /*Saldo diponible ejecutados*/
        /* float tmpii = new Float(M[Fcl-1][Ccl+3]).floatValue();
        float tmpiz = new Float(EM[EFcl-1][ECcl+3]).floatValue();
        float da = tmpii-tmpiz;
        String sall=df2.format(da).toString();

        modelo.put("sall",sall); */
        ECcl = ECcll;
        modelo.put("ECcl", String.valueOf(ECcl));
        modelo.put("EFcl", String.valueOf(EFcl));
        modelo.put("EM", EM);

        /*Mostrando La matriz*/



        String too3z = new String();
        too3z = orm.ejecutarObjeto("cuentasnopresuegr", "tot_ejec", toz, new String());


        float nu9 = 0;
        if (too3z != null) {
            nu9 = new Float(too3z).floatValue();
        }
        float nu10 = nu8 + nu9;

        modelo.put("too3z", df2.format(nu10).toString());


        for (int uf = 0; uf < EFcl; uf++) {
            for (int uuf = 0; uuf < ECcl; uuf++) {
                //99        System.out.print(EM[uf][uuf]+"  c   "+uf);
                //99
            }
            //99      System.out.println("  ");
            //99      System.out.println(" f ");
        }
        //creando la matriz para los saldos comprometidos

        String CM[][] = new String[100][1000];

        //
        /*total de los ejecutados*/
        float nu90 = nu5 - nu10;
        modelo.put("toto", df2.format(nu90).toString());

        double sumi = 0;
        double ja = 0;
        double jb = 0;
        /*Sacando totales de los ejecutados*/
        for (int vc = 1; vc < coto; vc = vc + 2) {
            //98  System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"+MB[1][vc]);
            if (MB[1][vc] == null) {
                MB[1][vc] = "0";

            }

            if (MB[2][vc] == null) {

                //98   System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+MB[2][vc]);
                MB[2][vc] = "0";
                MB[2][vc + 1] = " ";
            }
            //98 System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+MB[2][vc]);

            //98  System.out.println("xxCEEEEEEEEERO       --------->  "+MB[0][vc]);
            ja = Double.parseDouble(MB[1][vc]);

            jb = Double.parseDouble(MB[2][vc]);

            sumi = ja - jb;
            MB[3][vc] = String.valueOf(sumi);
            MB[3][vc + 1] = " ";
            MB[4][vc] = "0";
            MB[4][vc + 1] = " ";
            /*comprometido*/
            /*Buscando total para la fuente */



            System.out.println("ddddddddddddddddddddddddddddddddddddddddd f ");
            System.out.println("ddddddddddddddddddddddddddddddddddddddddd f ");
            System.out.println("ddddddddddddddddddddddddddddddddddddddddd f ");
            System.out.println("ddddddddddddddddddddddddddddddddddddddddd f ");
            System.out.println("ddddddddddddddddddddddddddddddddddddddddd f ");
            System.out.println("ddddddddddddddddddddddddddddddddddddddddd f ");
            System.out.println("ddddddddddddddddddddddddddddddddddddddddd f ");
            System.out.println("ddddddddddddddddddddddddddddddddddddddddd f ");
            System.out.println("ddddddddddddddddddddddddddddddddddddddddd f ");
            System.out.println("ddddddddddddddddddddddddddddddddddddddddd f ");
            System.out.println("ddddddddddddddddddddddddddddddddddddddddd f ");
            System.out.println("ddddddddddddddddddddddddddddddddddddddddd f ");

            for (int com = inicol; com < ECcll; com++) {
                if (EM[0][com].equals(MB[0][vc]))//.equals(
                {
                    //99         System.out.println("Monto comprometido       --------->  "+EM[EFcl-1][com]);
                    jb = jb + Double.parseDouble(EM[EFcl - 1][com]);
                    sumi = ja - jb;
                    MB[4][vc] = String.valueOf(sumi);
                    MB[4][vc + 1] = " ";

                    System.out.println("ja " + ja);
                    System.out.println("jb " + jb);//es mi monto ejecutado real mas el monto comprometido
                    System.out.println("sumi " + sumi);//es mi saldo real restado con el monto comprometido del qiu se tiene que sacar porcentaje en proceso

                    System.out.println("Fuente " + MB[0][vc]);
                    System.out.println("Fuente comparando " + EM[0][com]);
                    System.out.println("MCMP[0][vc] " + MCMP[0][vc]);
                    System.out.println("MCMP[0][vc] " + MCMP[0][vc]);
                    System.out.println("MCMP[0][vc] " + MCMP[0][vc]);
                    System.out.println("sss ss dd dd dd MB[0][vc] " + MB[0][vc]);

                    if (MCMP[0][1] != null) {
                        for (int hg = 1; hg < colcom; hg++) {
                            if (MCMP[0][vc] != null) {
                                if (MCMP[0][hg] != null) {
                                    System.out.println("AAA  "+MCMP[0][hg]);
                                    System.out.println("BBB  "+MB[0][vc]);
                                    if (MCMP[0][hg].equals(MB[0][vc])) {
                                        MCMP[2][hg] = String.valueOf(jb);
                                    }
                                }
                            }
                        }
                    }
                    System.out.println("Columna " + vc);
                    System.out.println("Saldo monto comprometido " + sumi);

                    System.out.println("En Matriz Final " + MB[4][vc]);
                    com = ECcll;
                } else {
                    MB[4][vc] = "0";
                    MB[4][vc + 1] = " ";
                }
            }
            /*Buscando total para la fuente */


        }

        /*

         */

        for (int uf = 0; uf < 5; uf++) {
            for (int vc = 1; vc < coto; vc++) {
                System.out.print(MB[uf][vc]);

            }
            System.out.println("  ");
            System.out.println(" f ");
        }




        //////****************************************


        //////*******************************************



        //transformando la matriz a formato

        if (mon != null) {
            //System.out.println()



            for (int cg = 1; cg < coto; cg = cg + 2) {


                double tmpi = new Double(MB[1][cg]).doubleValue();
                MB[1][cg] = df2.format(tmpi).toString();
                //99      System.out.println(" CEROOOO  -- "+MB[0][cg]);


                double tmpiu = new Double(MB[2][cg]).doubleValue();
                MB[2][cg] = df2.format(tmpiu).toString();

                double tmpic = new Double(MB[3][cg]).doubleValue();
                MB[3][cg] = df2.format(tmpic).toString();

                double tmpico = new Double(MB[4][cg]).doubleValue();
                MB[4][cg] = df2.format(tmpico).toString();
            }
        }
        //FIN FIN FIN FIN FIN transformando la matriz a formato

        /*******dando formato a los comprometidos egresos******/
        for (int cco = inicol; cco < ECcll; cco++) {
            for (int cfi = 2; cfi < ffco + 1; cfi++) {

                if (EM[cfi][cco] != null) {
                    double gty = Double.parseDouble(EM[cfi][cco]);

                    EM[cfi][cco] = df2.format(gty).toString();
                }
                //
            }
            // EM[ffco][cco]=df2.format(csu).toString();
            // EM[ffco][cco]=Double.toString(csu);
            // csu=0;
        }




        /*******************/
        String MT[][] = new String[100][1000];
        int df = 0;
        int dc = 0;
        int coto2 = 0;
        MT[0][0] = MB[0][0];
        MT[1][0] = MB[1][0];
        MT[2][0] = MB[2][0];
        MT[3][0] = MB[3][0];
        MT[4][0] = MB[4][0];



        //Uniendo Letras de las fuentes economicas
        int gs = 1;
        for (dc = 1; dc <= coto; dc = dc + 2) {

            MT[0][gs] = MB[0][dc] + " " + MB[0][dc + 1];
            System.out.print("MT[0]  "+MT[0][gs]);
            MT[1][gs] = MB[1][dc] + " " + MB[1][dc + 1];
            System.out.print("MT[1]  "+MT[1][gs]);
            MT[2][gs] = MB[2][dc] + " " + MB[2][dc + 1];
            System.out.print("MT[2]  "+MT[2][gs]);
            MT[3][gs] = MB[3][dc] + " " + MB[3][dc + 1];
            System.out.print("MT[3]  "+MT[3][gs]);
            MT[4][gs] = MB[4][dc] + " " + MB[4][dc + 1];
            coto2 = coto2 + 1;
            gs++;
        }


        // modelo.put("coto",String.valueOf(coto));
        // modelo.put("MB",MB);

        if (coto2 == 0) {
            coto2 = 1;
        }
        modelo.put("coto", String.valueOf(coto2));
        modelo.put("MBT", MT);


        /**/
        /****�*/
        // System.out.println(" Saldoooooooooooooooooooos");
        // System.out.println(" Saldoooooooooooooooooooos");
        // System.out.println(" Saldoooooooooooooooooooos");
        for (int g = 0; g < 3; g++) {
            for (int gv = 0; gv < colcom; gv++) {
                COM2[g][gv] = COM[g][gv];
            }
        }
        //System.out.println(" pppppppppppppppppppppppppppppppppp");
        for (int uf = 1; uf < 3; uf++) {
            for (int uuf = 1; uuf < colcom; uuf++) {
                //98 System.out.print(COM[uf][uuf]+"    ");

                if (COM[uf][uuf] != null) {

                    double gty = Double.parseDouble(COM[uf][uuf]);
                    //.substring(0,5)

                    if (gty >= 100 && COM[uf][uuf] != null) {

                        String h = df3.format(gty).toString();
                        if (h.length() > 6) {
                            COM2[uf][uuf] = df3.format(gty).toString().substring(0, 6);
                            COM[uf][uuf] = df3.format(gty).toString().substring(0, 6) + " %";
                        } else {
                            COM2[uf][uuf] = df3.format(gty).toString();
                            COM[uf][uuf] = df3.format(gty).toString() + " %";
                        }




                    } else {
                        if (gty < 1) {
                            COM2[uf][uuf] = df3.format(gty).toString().substring(0, 4);
                            COM[uf][uuf] = df3.format(gty).toString().substring(0, 4) + " %";
                        } else {
                            COM2[uf][uuf] = df3.format(gty).toString().substring(0, 5);
                            COM[uf][uuf] = df3.format(gty).toString().substring(0, 5) + " %";
                        }
                    }

                }

                //System.out.print(COM[0][0]+"  c   ");
            } //98 System.out.println("  ");
            //98  System.out.println(" f ");
        }
        /****�*/
        for (int gh = 0; gh < 3; gh++) {
            for (int ty = 0; ty < colcom; ty++) {
                MCM[gh][ty] = COM[gh][ty];
            }
        }



        /*Sacando la tarea*/
        ProActTar tarw = new ProActTar();
        tarw.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar", "codtar", tarw, tarw);
        modelo.put("fech", tarw);

        modelo.put("colcom", String.valueOf(colcom));
        modelo.put("COM", COM);
        modelo.put("COM2", COM2);



        // System.out.println("AAAA************************************************************************** ");
        for (int g = 1; g < 3; g++) {
            for (int gv = 1; gv < colcom; gv++) {
                // System.out.println(" "+COM2[g][gv]);

                if (COM2[g][gv] != null) {
                    COM2[g][gv] = COM2[g][gv].replace(",", ".");
                }


            }
            // System.out.println(" ");
        }




        /*NUEVA MATRIZ CON LOS PORCENTAJES DE EJECUCION */
        //de double a cadena
        //cadena = String.valueOf(valor);

        //de cadena a valor
        // doubledd=Double.parseDouble(cadena);
//  MCMP   matriz en la que se almacena los montos presupuestatos totales por fuentes y los ejecutados + los comprometidos
        //System.out.println("MATRIIIIIIIZ");
        // System.out.println("MATRIIIIIIIZ");
        // System.out.println("MATRIIIIIIIZ");
        // System.out.println("MATRIIIIIIIZ");
        for (int gdg = 1; gdg < colcom; gdg++) {

            double sab;
            double ac;
            double bc;
            if (MCMP[1][gdg] != null) {
                ac = Double.parseDouble(MCMP[1][gdg]);
                bc = Double.parseDouble(MCMP[2][gdg]);
                sab = ((bc / ac) * 100);
            } else {
                sab = 0;
            }

            MCMP[3][gdg] = df2.format(sab).toString() + " % ";
            //        System.out.println("----------");

        }
        /*
        for(int oo=1;oo<4;oo++){
        for(int gdg=0;gdg<colcom;gdg++){

        System.out.print(" "+MCMP[oo][gdg]);
        }

        }
         */

        /////////////////////////
        //llenando los nuevos montos de porcentajes
        System.out.print("kkkkkkkkkkkkkkk5555555555 ");
        for (int gdg = 1; gdg < colcom; gdg++) {

            System.out.print(" " + MCM[1][gdg]);
            for (int hj = 1; hj < colcom; hj++) {
                if (MCM[0][gdg].equals(MCMP[0][hj])) {
                    MCM[2][gdg] = MCMP[3][hj];
                }
            }
        }
        //  System.out.print("kkkkkkkkkkkkkkk ");

        //////////////////////////////////////////////////////
        modelo.put("MCM", MCM);
        /*
        for(int oo=0;oo<3;oo++){
        for(int gdg=0;gdg<colcom;gdg++){

        System.out.print(" "+MCM[oo][gdg]);

        }
        System.out.println("----------");
        }
         * /
        ///////////////****************SSSSSSSSSSSS
        /*FIN FIN FIN FINF INF FIN FINF INF INF NUEVA MATRIZ CON LOS PORCENTAJES DE EJECUCION */












//oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
        List direc = new ArrayList();
        String In = "";
        for (int uf = 1; uf < 3; uf++) {
            for (int uuf = 1; uuf < colcom; uuf++) {

                if (uf == 1) {
                    In = "Ingresos";
                } else {
                    if (uf == 2) {
                        In = "Egresos";
                    }
                }
                CreatePie p = new CreatePie();
                p.setTitulo(In + "  Fuente Economica " + COM2[0][uuf]);
                p.setTitulovalor1("Ejecutado " + COM2[uf][uuf] + "%");//df2.format(tmpi2).toString()



                p.setTitulovalor2("No ejecutado " + df2.format(100 - Double.valueOf(COM2[uf][uuf]).doubleValue()) + "%");

                p.setValor1(new Double(Double.valueOf(COM2[uf][uuf]).doubleValue()));

                p.setValor2(new Double(100 - Double.valueOf(COM2[uf][uuf]).doubleValue()));
                String file = System.currentTimeMillis() + ".png";//p.setArchivo("c:\jju.jpg");
                System.out.println("-----------------------------------------------ingresoooooo sarita-----------------------------");
                p.setArchivo(System.getenv("AQUILESHOME7") + "/imagenes/porcentajes_pr/" + file);
                //p.setArchivo("c:/"+file);
                direc.add(file);
                p.getPie();

            }
        }
        modelo.put("dicecciones", direc);

        String swed = tare.getCodacti();
        String swed2 = tare.getDescripcion();
        System.out.println("AAAA " + swed + " - " + swed2);

        orm.cerrar();//cerrar la conexion         ahora vamos a jsp


        return new ModelAndView("presupuestos3/pat/MuestraPatEgrIng", modelo);
    }
}
