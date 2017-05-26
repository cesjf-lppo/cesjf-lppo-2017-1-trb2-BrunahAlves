package br.cesjf.lppo.Servlet;

import br.cesjf.lppo.Coleta;
import br.cesjf.lppo.DAO.ColetaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruna Alves
 */
@WebServlet(name = "NovaColetaServlet", urlPatterns = {"/NovaColeta.html"})
public class NovaColetaServlet extends HttpServlet {
    
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/nova-coleta.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Coleta novaColeta = new Coleta();

        novaColeta.setDescricao(request.getParameter("descricao"));
        try {
            novaColeta.setData(df.parse(request.getParameter("data")));
        } catch (ParseException ex) {
            Logger.getLogger(NovaColetaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ColetaDAO dao = new ColetaDAO();
            dao.cria(novaColeta);
        } catch (Exception ex) {
            request.setAttribute("mensagem", ex);
            request.getRequestDispatcher("WEB-INF/nova-coleta.jsp").forward(request, response);
            return;
        }

        response.sendRedirect("NovaLeitura.html");

    }

}
