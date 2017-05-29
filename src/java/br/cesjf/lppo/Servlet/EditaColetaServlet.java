/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo.Servlet;

import br.cesjf.lppo.DAO.LeituraDAO;
import br.cesjf.lppo.Leitura;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alunoces
 */
@WebServlet(name = "EditaColetaServlet", urlPatterns = {"/EditaColeta.html"})
public class EditaColetaServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          try {
            int id = Integer.parseInt(request.getParameter("id"));

            LeituraDAO dao = new LeituraDAO();
            Leitura leitura = dao.getByLeitura(id);

            request.setAttribute("leitura", leitura);

            request.getRequestDispatcher("WEB-INF/edita-leitura.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            response.sendRedirect("listaLeituraDaColeta.html");
        } catch (Exception ex) {
            Logger.getLogger(EditaColetaServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("listaLeituraDaColeta.html");
        }
        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }



}
