<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="tadeu.agenda.*" %>
<jsp:useBean id="dados" scope="request" class="tadeu.agenda.DadosBean" />

<h2>Buscar contato:</h2>

<form action="buscar.jsp" method="post">
    <label>Nome: </label><input type="text" name="nome" />
    <br />

    <br />
    <input type="submit" value="buscar" />
</form>

<%
    String nome = request.getParameter("nome");
    if (nome != null && !nome.isEmpty())  {
        List lista = dados.buscarContatos(nome);
        Iterator it = lista.iterator();
        ContatoBean contato;

        if (lista.size() > 0) {
%>

        <table>

            <thead>
            <tr>
                <td>Id</td>
                <td>Nome</td>
                <td>Telefone</td>
                <td>E-mail</td>
            </tr>
            </thead>

            <tbody>
            <%
                while (it.hasNext()) {
                    contato = (ContatoBean) it.next();
            %>
            <tr>
                <td><%= contato.getId() %></td>
                <td><%= contato.getNome() %></td>
                <td><%= contato.getTelefone() %></td>
                <td><%= contato.getEmail() %></td>
            </tr>
            <%
                }
            %>
            </tbody>

        </table>

        <%
            } else {
        %>

            <h2>Nenhum contato encontrado...</h2>

<%
        }
    }
%>