/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestSerl;

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
public class TestServletTableProg extends HttpServlet {
//the servelet to get all infomations of a programmePerso to show in other sites
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/xml;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*----- Ecriture de la page XML -----*/
            out.println("<?xml version=\"1.0\"?>");
            out.println("<programme>");

            /*----- Récupération des paramètres -----*/
            String nom = request.getParameter("idProg");

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
                    out.println("<descripSP>"+ordre+"</descripSP>");
                    out.println("</seancePerso>");
                }
                out.println("</l_seancesPerso>");
		}
            catch (Exception ex)
		{
		out.println("<seances>Erreur - " + ex.getMessage() + "</seances>");
		}
            out.println("</programme>");
	}
    }

}
