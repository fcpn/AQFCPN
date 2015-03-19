<%
  out.write("<?xml version='1.0' encoding='ISO-8859-1'?>");
  response.setContentType("text/xml");
  response.setHeader("Cache-Control", "no-cache");
  out.write("<root><respuesta>"+(String)request.getAttribute("mensaje")+"</respuesta></root>"); 
%>
