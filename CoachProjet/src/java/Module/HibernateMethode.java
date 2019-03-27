/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import Bd.*;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author 21611943
 */
public class HibernateMethode {
    
    public static Programmeperso consultProgramClient(int idClient) {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction() ;
        Query q = ses.createQuery ("from Programmeperso as pp where pp.client = "+idClient);
        List<Programmeperso> lpp = (List<Programmeperso>) q.list();
        Programmeperso pp = lpp.get(lpp.size()-1);
        tc.commit();
        return pp;
    }
    
    public static Programmeperso consultProgramIdPro(int idPP){
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction() ;
        Query q = ses.createQuery ("from Programmeperso as pp where pp.idpp = "+idPP);
        List<Programmeperso> lpp = (List<Programmeperso>) q.list();
        Programmeperso pp = lpp.get(0);
        tc.commit();
        return pp;
    }
    
    public static HashMap<Integer,Seanceperso> consultSeancesIdProgPerso(int idPro){
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction() ;
        Query q = ses.createQuery ("from Seanceperso as sp where sp.programmeperso = "+idPro);
        List<Seanceperso> lsp = (List<Seanceperso>) q.list();
        HashMap<Integer,Seanceperso> msp;
        msp = new HashMap<>();
        for(Seanceperso sp: lsp){
           msp.put(sp.getOrdresea(), sp);
        }
        tc.commit();
        return msp;
    }
   
}
