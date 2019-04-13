
package CtrlServlet;

import Bd.Client;
import Bd.Objectif;
import Module.HibernateMethode;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 21511708
 */
public class ServletClientNonPgrm extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
response.setContentType("application/xml;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<?xml version=\"1.0\"?>");
            out.println("<list_idNonPgrm>");
            ArrayList<Client> listid = HibernateMethode.consultClientNonPgrm();

            for(Client l : listid){
                out.println("<client>");
                    out.print("<id>"+l.getIdc()+"</id>");
                    out.println("<nom>"+l.getNomc()+"</nom>");
                    out.println("<prenom>"+l.getPrenomc()+"</prenom>");
                    out.println("<sexe>"+l.getSexec()+"</sexe>");
                    out.println("<image>"+l.getPhotoc()+"</image>");
                    out.println("<liste_obj>");
                        ArrayList<Objectif> l_obj;
                        l_obj = HibernateMethode.showObjectifCli(l.getIdc());
                        for (Objectif o : l_obj)
                        {
                            out.println("<lib>"+o.getLibobj()+"</lib>");
                        }
                        out.println("</liste_obj>");
                    String datecli = HibernateMethode.showDateDemande(l.getIdc());
                    out.println("<date>"+datecli+"</date>");
                    out.println("</client>");
            }

            out.println("</list_idNonPgrm>");
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
