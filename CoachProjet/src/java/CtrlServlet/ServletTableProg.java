/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CtrlServlet;

import Bd.Programmeperso;
import Bd.Seanceperso;
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
 * @author Fei
 */
public class ServletTableProg extends HttpServlet {
//the servelet to get all infomations of a programmePerso to show in other sites
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("application/xml;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*----- Ecriture de la page XML -----*/
            out.println("<?xml version=\"1.0\"?>");
            out.println("<programme>");

            /*----- Récupération des paramètres -----*/
            //String nom = request.getParameter("idProg");

            try {
		/*----- Lecture de infomation dece prog -----*/
                Programmeperso pp = new Programmeperso();
                pp = HibernateMethode.consultProgramIdPro(1);
                
                out.println("<libPP>"+pp.getLibpp()+"</libPP>");
		out.println("<descripPP>"+pp.getDescrippp()+"</descripPP>");
                
                /*----Lecture de liste de seances de ce prog----*/
                HashMap<Integer,Seanceperso> msp = HibernateMethode.consultSeancesIdProgPerso(1);
                out.println("<l_seancesPerso>");
                for(int ordre: msp.keySet()){
                    out.println("<seancePerso>");
                    out.println("<ordreSP>"+ordre+"</ordreSP>");
                    out.println("<libSP>"+msp.get(ordre).getLibsea()+"</libSP>");
                    out.println("<descripSP>"+msp.get(ordre).getDescrisea()+"</descripSP>");
                    out.println("</seancePerso>");
                }
                out.println("</l_seancesPerso>");
		}
            catch (Exception ex)
		{
		out.println("<libPP>Erreur - " + ex.getMessage() + "</libPP>");
		}
            out.println("</programme>");
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
