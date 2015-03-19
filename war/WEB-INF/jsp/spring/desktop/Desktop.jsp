<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Jiwasana Desktop Version (BETA) :: By _</title>

    <link rel="stylesheet" type="text/css" href="desktop/resources/css/ext-all.css" />
    <link rel="stylesheet" type="text/css" href="desktop/resources/css/xtheme-gray.css" />
    
    <script type="text/javascript" src="desktop/adapter/ext/ext-base.js"></script>
    <script type="text/javascript" src="desktop/ext-all.js"></script>

    <!-- DESKTOP -->
    <script type="text/javascript" src="desktop/js/StartMenu.js"></script>
    <script type="text/javascript" src="desktop/js/TaskBar.js"></script>
    <script type="text/javascript" src="desktop/js/Desktop.js"></script>
    <script type="text/javascript" src="desktop/js/App.js"></script>
    <script type="text/javascript" src="desktop/js/Module.js"></script>    

<script type="text/javascript">
function AjaxHttp() {
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();		
    }
    else if(window.ActiveXObject) {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xmlhttp;    
}    


MyDesktop = new Ext.app.App({
    init :function(){
		Ext.QuickTips.init();
    },
    getModules : function(){
	return [
            <c:forEach var="lst"  items="${categorias}"  varStatus="i">
              <c:if test="${i.index != 0}"><c:out value=","/></c:if>  
              new MyDesktop.BogusMenuModuleC<c:out value="${lst.id_categoria}"/>()
            </c:forEach>
	       ];
    },
    getStartConfig : function(){
        return {
            title: '<c:out value="${nombres}"/> [<c:out value="${id_rol}"/>]',
            iconCls: 'user',
            toolItems: [{
                text:'Opciones',
                iconCls:'settings',
                scope:this
            },'-',{
                text:'Vista Clasica',
                iconCls:'mi_window',
                handler: this.setFinish,
                scope:this              
            },'-',{
                text:'Salir',
                iconCls:'logout',
                handler: this.setLogout,
                scope:this              
            }]
        };
    },
    setFinish : function() {       
       document.getElementById('classicview').submit();
    },
    setLogout : function() {       
       document.getElementById('logoutview').submit();
    }    
});        
    
// for example purposes
var windowIndex = 0;

MyDesktop.BogusModule = Ext.extend(Ext.app.Module, {
    init : function(){
        this.launcher = {
            text: 'Window '+(++windowIndex),
            iconCls:'',
            handler : this.createWindow,
            scope: this,
            windowId:windowIndex
        }
    },

    createWindow : function(src){
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow('bogus'+src.windowId);
        if(!win){
            win = desktop.createWindow({
                id: 'bogus'+src.windowId,
                title:src.text,
                width:790,
                height:450,
                html : '<iframe src="'+ src.ruta +'" height="100%" width="100%" frameborder="0"></iframe>',
                iconCls: 'mi_window',
                shim:false,
                animCollapse:false,
                constrainHeader:true
            });
        }
        win.show();
    }
});

MyDesktop.BogusMenuModuleCrep = Ext.extend(MyDesktop.BogusModule, {
    init : function(){
        this.launcher = {
            text: 'REPORTES',
            iconCls: 'mi_categoria',
            handler: function() { return false; },
            menu: {
                items:[
                    
                    {
                    text: 'Reportes',
                    iconCls:'mi_enlace',
                    handler : this.createWindow,
                    scope: this,
                    windowId: 'rep-3008',
                    ruta: '/cp/reportes.do'
                    }
                    
                    ]
            }
        }
    }
});

<c:forEach var="lst" items="${categorias}">
    
MyDesktop.BogusMenuModuleC<c:out value="${lst.id_categoria}"/> = Ext.extend(MyDesktop.BogusModule, {
    init : function(){
        this.launcher = {
            text: '<c:out value="${lst.categoria}"/>',
            iconCls: 'mi_categoria',
            handler: function() { return false; },
            menu: {
                items:[
                    <c:forEach var="lste" items="${lst.enlaces}"  varStatus="i">
                    <c:if test="${i.index != 0}"><c:out value=","/></c:if>    
                    {
                        text: '<c:out value="${lste.nombre_enlace}"/>',
                        iconCls:'mi_enlace',
                        handler : this.createWindow,
                        scope: this,
                        windowId: '<c:out value="${lst.id_categoria}"/>-<c:out value="${lste.id_enlace}"/>',
                        ruta: '<c:url value="${lste.ruta_enlace}"/>'
                    }
                    </c:forEach>
                    ]
            }
        }
    }
});

</c:forEach>



</script>
<script type="text/javascript" src="desktop/sample.js"></script>
    <link rel="stylesheet" type="text/css" href="desktop/css/desktop.css" />
</head>
<body scroll="no">

<div id="x-desktop">
    <a href="http://extjs.com" target="_blank" style="margin:5px; float:right;"><img src="desktop/images/powered.gif" /></a>

    <dl id="x-shortcuts">
        <dt id="grid-win-shortcut">
            <a href="#"><img src="desktop/images/s.gif" />
            <div>Grid Window</div></a>
        </dt>
        <dt id="acc-win-shortcut">
            <a href="#"><img src="desktop/images/s.gif" />
            <div>Accordion Window</div></a>
        </dt>
    </dl>
</div>

<div id="ux-taskbar">
	<div id="ux-taskbar-start"></div>
	<div id="ux-taskbuttons-panel"></div>
	<div class="x-clear"></div>
</div>
<form id="classicview" action="<c:url value="/"/>" method="post"></form>
<form id="logoutview" action="<c:url value="/logoutUsuario.do"/>" method="post"></form>
</body>
</html>
