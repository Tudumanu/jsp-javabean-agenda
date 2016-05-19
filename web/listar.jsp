<%@ page import="java.util.*" %>
<%@ page import="tadeu.agenda.*" %>
<jsp:useBean id="dados" scope="request" class="tadeu.agenda.DadosBean" />

<%
    List lista = dados.listarTodosContatos();
    Iterator it = lista.iterator();
    ContatoBean contato;

    if(lista.size() > 0) {
%>

    <h2>Listagem geral dos contatos</h2>

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

    <h2>Não existem contatos cadastrados...</h2>

<%
    }
%>