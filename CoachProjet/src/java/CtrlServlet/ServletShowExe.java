
package CtrlServlet;

import Bd.Exerciseperso;
import Module.HibernateMethode;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 21611945
 */
public class ServletShowExe extends HttpServlet {

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
            out.println("<exercise>");
            String idExe = request.getParameter("idExe");
            try
            {
                Exerciseperso ep = HibernateMethode.showExe(Integer.parseInt(idExe));
                out.println("<libexe>"+ep.getLibexe()+"</libexe>");
                out.println("<descripexe>"+ep.getDescripexe()+"</descripexe>");
                String photo;
                if(ep.getPhotoexe().equals("")){
                    photo = "Bon Courage";
                }else{
                    photo = ep.getPhotoexe();
                }
                out.println("<photoexe>"+photo+"</photoexe>");
            }
            catch (Exception ex)
            {
                out.println("<erreur>ServletShowExe Erreur - " + ex.getMessage() + "</erreur>");
            }
            out.println("</exercise>");
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
