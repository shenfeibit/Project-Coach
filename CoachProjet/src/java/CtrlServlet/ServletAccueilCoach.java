/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CtrlServlet;

import Module.HibernateMethode;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Toky
 */
public class ServletAccueilCoach extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

         {
        //Catch informations
        String idCo = request.getParameter("idCoachAccueil");
        String nomCo = request.getParameter("nameCoach");

        //create session
        HttpSession ses = request.getSession(true);
        ses.setAttribute("idCoach", idCo);
        ses.setAttribute("nameCoach", nomCo);


        String avertissement="";

        //verify that information send are not empty
        if(idCo.isEmpty())
        {
            avertissement="Veuillez saisir votre ID";
        }
        else
        {
            try{
                //vérification
                boolean c = HibernateMethode.verifCoach(Integer.parseInt(idCo),nomCo);
                if(c)
                {
                    response.sendRedirect("TableauBordCo");
                }
                else
                {
                    avertissement="Veuillez saisir votre nom correct";
                }
            }
            catch (Exception ex)
            {
                RequestDispatcher rd = request.getRequestDispatcher("AccueilJd");
                request.setAttribute("erreurIdentif", ex.getMessage()); //Changer la clé pour celle la (erreur) notamment pour les styles css
                rd.forward(request, response);
            }
        }

            if (!avertissement.isEmpty())
            {
                //On retourne sur la page de saisie. On délègue à la ressource accueil
                RequestDispatcher rd = request.getRequestDispatcher("AccueilJd");
                request.setAttribute("id", idCo);
//                request.setAttribute("name", nomCo);
                request.setAttribute("avrt", avertissement);
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
