
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CtrlServlet;

import Bd.Exerciseperso;
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
                //write the page XML
                out.println("<?xml version=\"1.0\"?>");
                out.println("<programme>");
                //get the param
                String idCli = request.getParameter("idc");

            try {
		/*----- Lecture de infomation dece prog -----*/
                Programmeperso pp = new Programmeperso();
                pp = HibernateMethode.seeProgrammeCli(Integer.parseInt(idCli));
                
                out.println("<libPP>"+pp.getLibpp()+"</libPP>");
		out.println("<descripPP>"+pp.getDescrippp()+"</descripPP>");
                
                /*----Lecture de liste de seances de ce prog----*/
                HashMap<Integer,Seanceperso> msp = HibernateMethode.consultSeancesIdProgPerso(pp.getIdpp());
                out.println("<l_seancesPerso>");
                int i=1;
                for(int ordre: msp.keySet()){
                    out.println("<seancePerso>");
                    out.println("<ordreSP>"+ordre+"</ordreSP>");
                    out.println("<libSP>"+msp.get(ordre).getLibsea()+"</libSP>");
                    out.println("<descripSP>"+msp.get(ordre).getDescrisea()+"</descripSP>");
                    out.println("<dateSP>"+msp.get(ordre).getDatesea()+"</dateSP>");
                    if (msp.get(ordre).getDatesea()!=null){
                        i += 1;
                    }
                    out.println("<l_exp>");
                    HashMap<Integer,Exerciseperso> mexp = HibernateMethode.showExePersoBySea(msp.get(ordre).getIdsea());
                    for(int ordEx: mexp.keySet()){
                        out.println("<libexe>"+mexp.get(ordEx).getLibexe()+"</libexe>");
                    }
                    out.println("</l_exp>");
                    out.println("<idSP>"+msp.get(ordre).getIdsea()+"</idSP>");
                    out.println("</seancePerso>");
                }
                out.println("<encours>"+i+"</encours>");
                out.println("</l_seancesPerso>");
            }
                catch (Exception ex)
                    {
                        out.println("<erreur>ServletTableProg Erreur - " + ex.getMessage() + "</erreur>");
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

