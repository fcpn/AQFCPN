<%
    String opcion = "ERROR DE CONEXION";
    response.setContentType("text/xml");
    response.setHeader("Cache-Control", "no-cache");
    // for plain text response:
    //response.getWriter().write("_,Doe");
    // Or for XML formatted response:
    //response.getWriter().write("<root><pais>Bolivia</pais><pais>Peru</pais><pais>Argentina</pais></root>");    
    out.write("<root><respuesta>"+opcion+"</respuesta></root>");
    //System.out.println("after sending response");         
    //nothing to show
 %>

