<jsp:useBean id="contato" scope="page" class="tadeu.agenda.ContatoBean" />
<jsp:useBean id="dados" scope="request" class="tadeu.agenda.DadosBean" />

<%
    contato.setNome(request.getParameter("nome"));
    contato.setTelefone(request.getParameter("telefone"));
    contato.setEmail(request.getParameter("email"));

    if(contato.getNome() == null) {
%>

    <form action="adicionar.jsp" method="post">
        <fieldset>
            <legend>Adicionar Contato</legend>
            <label>Nome: </label><input type="text" name="nome" /> <br/>
            <label>Telefone: </label><input type="text" name="telefone" /> <br/>
            <label>E-mail: </label><input type="text" name="email" /> <br/>

            <br />
            <input type="submit" value="Cadastrar" />
        </fieldset>
    </form>

<%
    } else {
        dados.adicionarContato(contato);
%>

    <h2>Contato cadastrado com sucesso!</h2>

<%
    }
%>