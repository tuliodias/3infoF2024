<%-- 
    Document   : CadastroCidade
    Created on : 05/03/2024, 14:32:47
    Author     : tulio
--%>
<%
    String nomeCidade = request.getParameter("nomeCidade");// vem do ListarCidade.jsp
    String ufCidade = request.getParameter("ufCidade");
    String codigoCidade = request.getParameter("codigoCidade");
    String opcao = request.getParameter("opcao");
    String mensagem = request.getParameter("mensagem");// vem do CAECidade
    if (opcao == null) {
        opcao = "cadastrar";
    }
    if (codigoCidade == null) {
        codigoCidade = "0";
    }

%>

<%@page contentType="text/html" pageEncoding="Latin1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Latin1">
        <title>Cadastro de Cidade</title>
    </head>
    <body>
        <h1>Cadastro Cidade</h1>
        <form name="cadastro" method="get" action="CAECidade.jsp">

            <p>  
                <label>Cidade:</label>
                <input type="text" name="nomeCidade" value="<%= (nomeCidade == null) ? "" : nomeCidade%>" size="40" />
            </p>
            <p>  
                <label>UF:</label>
                <input type="text" name="ufCidade" value="<%= (ufCidade == null) ? "" : ufCidade%>" size="5" />
            </p>
            <%if (opcao.equals("cadastrar")) {%>
            <input type="submit" value="Cadastrar" name="Cadastrar" />
            <% }%>
            <%if (opcao.equals("alterar")) {%>
            <input type="submit" value="Alterar" name="Alterar" />
            <% }%>
            <%if (opcao.equals("excluir")) {%>
            <input type="submit" value="Excluir" name="Excluir" />
            <% }%>
            <input type="hidden" name="codigoCidade" value="<%= codigoCidade%>">
            <input type="hidden" name="opcao" value="<%= opcao%>">
        </form>
        <br> <%= (mensagem == null) ? "" : mensagem%>

        <%@include file="ListarCidade.jsp" %>

    </body>
</html>
