package br.cesjf.lppo.Servlet;

import br.cesjf.lppo.Coleta;
import br.cesjf.lppo.DAO.ColetaDAO;
import br.cesjf.lppo.DAO.LeituraDAO;
import br.cesjf.lppo.Leitura;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ListaDadosServlet", urlPatterns = {"/listaColeta.html", "/listaLeituraDaColeta.html", "/listaPorLocal.html"})
public class ListaDadosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getRequestURI().contains("/listaColeta.html")) {
            List<Coleta> coleta;

            try {
                ColetaDAO dao = new ColetaDAO();
                coleta = dao.listByColeta();

            } catch (Exception ex) {
                Logger.getLogger(ListaDadosServlet.class.getName()).log(Level.SEVERE, null, ex);
                coleta = new ArrayList<>();
                request.setAttribute("mensagem", ex.getLocalizedMessage());
            }

            request.setAttribute("coletas", coleta);
            request.getRequestDispatcher("WEB-INF/lista-porcoleta.jsp").forward(request, response);
        } else if (request.getRequestURI().contains("/listaLeituraDaColeta.html")) {

            List<Leitura> leituraColeta;

            try {
                LeituraDAO dao = new LeituraDAO();
                int coleta = Integer.parseInt(request.getParameter("coleta")); //pega o ID da Coleta
                leituraColeta = dao.listByLeituradaColeta(coleta);
          request.setAttribute("leituracoleta", leituraColeta);
            } catch (Exception ex) {
                Logger.getLogger(ListaDadosServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("mensagem", ex.getLocalizedMessage());
            }
                  
            request.getRequestDispatcher("WEB-INF/lista-leituraporcoleta.jsp").forward(request, response);
        } else if (request.getRequestURI().contains("/listaPorLocal.html")) {
            List<Leitura> local;

            try {
                LeituraDAO dao = new LeituraDAO();
                local = dao.listByLocal();

            } catch (Exception ex) {
                Logger.getLogger(ListaDadosServlet.class.getName()).log(Level.SEVERE, null, ex);
                local = new ArrayList<>();
                request.setAttribute("mensagem", ex.getLocalizedMessage());
            }

            request.setAttribute("local", local);
            request.getRequestDispatcher("WEB-INF/lista-porlocal.jsp").forward(request, response);
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     

    }

}
