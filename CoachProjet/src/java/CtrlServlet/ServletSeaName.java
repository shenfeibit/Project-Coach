
package CtrlServlet;

import Module.HibernateMethode;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 21611945
 */
public class ServletSeaName extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<?xml version=\"1.0\"?>");
            out.println("<seance>");
            String idSea = request.getParameter("idSea");

            try
            {
                String name = HibernateMethode.showNameSea(Integer.parseInt(idSea));
                out.println("<name>"+name+"</name>");
                HashMap<Integer,Integer> listexe = HibernateMethode.getOrderExe(Integer.parseInt(idSea));
                out.println("<listexe>");
                for(Integer order : listexe.keySet()){
                    out.println("<exercise>");
                    out.println("<order>"+order+"</order>");
                    out.println("<idexe>"+listexe.get(order)+"</idexe>");
                    out.println("</exercise>");
                }
                out.println("</listexe>");
            }
            catch (Exception ex)
            {
                out.println("<erreur>ServletSeaName Erreur - " + ex.getMessage() + "</erreur>");
            }
            out.println("</seance>");
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
