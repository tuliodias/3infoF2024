<%@page import="modelo.Cidade"%>
<%@page import="modelo.DAOCidade"%>
<%
String nome = request.getParameter("nomeCidade");
String uf = request.getParameter("ufCidade");
String mensagem="";

Cidade objCidade = new Cidade();
objCidade.setNomeCidade(nome);
objCidade.setUfCifade(uf);


DAOCidade objDAOCidade = new DAOCidade();
mensagem = objDAOCidade.inserirCidade(objCidade);

%>
<%= mensagem%>
