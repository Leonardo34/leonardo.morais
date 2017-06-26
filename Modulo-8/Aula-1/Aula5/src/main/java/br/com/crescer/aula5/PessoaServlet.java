package br.com.crescer.aula5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PessoaServlet extends HttpServlet {
    private List<String> nomes = new ArrayList<>();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (final PrintWriter out = response.getWriter()) {
            out.append("<!DOCTYPE html>");
            out.append("<html>");
            out.append("<head>");
            out.append("<title>Java - aula5</title>");
            out.append("<meta charset=\"UTF-8\">");
            out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.append("</head>");
            out.append("<body>");
            out.append("<h1>Betinha</h1>");
            out.append("<form method=\"post\" action=\"/Aula5/pessoa\">");
            out.append("<input type=\"text\" name=\"nome\" value=\"Mickey\"><br>");
            out.append("<input type=\"submit\" value=\"Submit\"");
            out.append("</form>");
            out.append("<ul>");
            for (String nome : nomes) {
                out.append("<li>" + nome + "</li>");
            }
            out.append("</ul>");
            out.append("</body>");
            out.append("</html>");
        }       
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        nomes.add(request.getParameterMap().get("nome")[0]);
        response.sendRedirect("/Aula5/pessoa");
    }
}
