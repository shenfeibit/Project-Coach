
package CtrlServlet;

import Module.HibernateMethode;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 21511708
 */
public class ServletMens extends HttpServlet {

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

        {
            String idSea = request.getParameter("idSea");
            String idBras = request.getParameter("idBras");
            String idPoitrine = request.getParameter("idPoitrine");
            String idTaille = request.getParameter("idTaille");
            String idHanches = request.getParameter("idHanches");
            String idCuisses = request.getParameter("idCuisses");

            //create session
            HttpSession ses = request.getSession(true);
            ses.setAttribute("idSea", idSea);
            String avertissement="";

            if(idBras.isEmpty()||idPoitrine.isEmpty()||idTaille.isEmpty()||idHanches.isEmpty()||idCuisses.isEmpty()){
                avertissement = "Veuillez saisir vos informations";
            }else{
                try{
                    HibernateMethode.insertMensBilan(
                        Integer.parseInt(idSea),
                        Double.parseDouble(idBras),
                        Double.parseDouble(idPoitrine),
                        Double.parseDouble(idTaille),
                        Double.parseDouble(idHanches),
                        Double.parseDouble(idCuisses));
                    response.sendRedirect("BeginSeaPer");
                }catch (Exception ex){
                        RequestDispatcher rd = request.getRequestDispatcher("BeginSeancesBilan");
                        request.setAttribute("erreurReq", ex.getMessage()) ;
                        rd.forward(request, response);
                }
            }

            if (!avertissement.isEmpty()){
                //On retourne sur la page de saisie. On délègue à la ressource accueil
                RequestDispatcher rd = request.getRequestDispatcher("BeginSeancesBilan");
                request.setAttribute("avrtMensuration", avertissement);
                rd.forward(request, response);
            }
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
