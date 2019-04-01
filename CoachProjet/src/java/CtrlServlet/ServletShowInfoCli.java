
package CtrlServlet;

import Bd.Client;
import Bd.Objectif;
import Module.HibernateMethode;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletShowInfoCli", urlPatterns = {"/ServletShowInfoCli"})
public class ServletShowInfoCli extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            response.setContentType("application/xml;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) 
            {
                //write the page XML
                out.println("<?xml version=\"1.0\"?>");
                out.println("<donnees>");
                //get the param
                String idCli = request.getParameter("idc");
                   
                try{
                    //get the result
                    Client c = HibernateMethode.showInfoClient(Integer.parseInt(idCli));
                    out.println("<nom>"+c.getNomc()+"</nom>");
                    out.println("<prenom>"+c.getPrenomc()+"</prenom>");
                    out.println("<sexe>"+c.getSexec()+"</sexe>");
                    out.println("<tele>"+c.getTelc()+"</tele>");
                    out.println("<email>"+c.getEmailc()+"</email>");
                    out.println("<image>"+c.getPhotoc()+"</image>");
                    out.println("<liste_obj>");
                    ArrayList<Objectif> l_obj = HibernateMethode.showObjectifCli(Integer.parseInt(idCli));
                    for (Objectif o : l_obj)
                    {
                        out.println("<lib>"+o.getLibobj()+"</lib>");
                    }
                    out.println("</liste_obj>"); 
                }
                catch (Exception ex)
		{
                    out.println("<erreur>ServletShowInfoCli Erreur - " + ex.getMessage() + "</erreur>");
		}
            out.println("</donnees>");
        }
    }


   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
