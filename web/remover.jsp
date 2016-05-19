<jsp:useBean id="dados" scope="request" class="tadeu.agenda.DadosBean" />

<%
    String id = request.getParameter("id");

    if(id == null || id.isEmpty()) {
%>

<form action="remover.jsp" method="post">
    <fieldset>
        <legend>Remover Contato</legend>
        <label>Id: </label><input type="text" name="id" /> <br/>

        <br />
        <input type="submit" value="Remover" />
    </fieldset>
</form>

<%
} else {
    dados.removerContato(Integer.parseInt(id));
%>

<h2>Contato removido!</h2>

<%
    }
%>