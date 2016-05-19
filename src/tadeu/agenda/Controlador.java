package tadeu.agenda;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "Controlador",
        urlPatterns = {"/Controlador"}
)
public class Controlador extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcao = request.getParameter("opcao");

        switch (opcao) {
            case "add":
                response.sendRedirect("adicionar.jsp");
                break;

            case "remove":
                response.sendRedirect("remover.jsp");
                break;

            case "list":
                response.sendRedirect("listar.jsp");
                break;

            case "search":
                response.sendRedirect("buscar.jsp");
                break;

            default:
                response.sendRedirect("index.jsp");
                break;
        }
    }
}
