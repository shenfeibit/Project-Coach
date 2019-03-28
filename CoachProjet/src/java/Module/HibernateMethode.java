/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import Bd.*;
import java.util.ArrayList;
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
        Transaction tc = ses.beginTransaction();
        Query q = ses.createQuery ("from Programmeperso as pp where pp.client = "+idClient);
        List<Programmeperso> lpp = (List<Programmeperso>) q.list();
        Programmeperso pp = lpp.get(lpp.size()-1);
        tc.commit();
        return pp;
    }
    
    public static Client showInfoClient (int idClient) {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction() ;
        Query q  =ses.createQuery ("from Client as c where c.idc = "+idClient);
        Client c = (Client) q.list().get(0);
        tc.commit();
        return c;
    }
    
    public static ArrayList<Objectif> showObjectifCli (int idClient) {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction();
        Query q = ses.createQuery ("from Choisir as c where c.client = " + idClient);
        List<Choisir> l_cho = (List<Choisir>) q.list();
        ArrayList<Objectif> l_obj = new ArrayList<>();
        for (Choisir ch : l_cho){
            System.out.print(l_cho.get(0).getObjectif().getLibobj());
            l_obj.add(ch.getObjectif());
        }        
        tc.commit();
        return l_obj;
    }
    
    public static Programmeperso seeProgrammeCli(int idClient) {
            Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tc = ses.beginTransaction() ;

            Query q = ses.createQuery ("from Programmeperso as pp where pp.client = " + idClient);
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

    /**
     * Method that return all names of programs.
     * @return return all name of programs
     */
    public static ArrayList<String> consultProgramSt() {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction() ;

        Query q = ses.createQuery ("from Programmestandard as ps");
        List<Programmestandard> lps = (List<Programmestandard>) q.list();
        ArrayList<String> nomps = new ArrayList<String>();
        for(Programmestandard p : lps){

            String nomp = p.getLibps();
            nomps.add(nomp);
        }
        tc.commit();
        return nomps;
    }
    /**
     * Method that return all name of objectives.
     * @return list of name of objectives
     */
    public static ArrayList<String> consultType() {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction() ;

        Query q = ses.createQuery ("from Objectif");
        List<Objectif> lobj = (List<Objectif>) q.list();
        ArrayList<String> nomlo = new ArrayList<String>();
        for(Objectif o : lobj){
            String nomo = o.getLibobj();
            nomlo.add(nomo);
        }
        tc.commit();
        return nomlo;
    }

    public static ArrayList<Objectif> consultTypePs() {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction() ;

        Query q = ses.createQuery ("from Objectif");
        List<Objectif> lobj = (List<Objectif>) q.list();
        ArrayList<Objectif> nomlo = new ArrayList<Objectif>();
        for(Objectif o : lobj){
            nomlo.add(o);
        }
        tc.commit();
        return nomlo;
    }



     public static ArrayList<String> lireProgObj(String objectif) {
         if(objectif.equals(null)){
             Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
             Transaction tc = ses.beginTransaction() ;
                Query q = ses.createQuery ("from Programmestandard");
                List<Programmestandard> lps = (List<Programmestandard>) q.list();
                ArrayList<String> nomps = new ArrayList<String>();
                for(Programmestandard p : lps){
                    String nomp = p.getLibps();
                    nomps.add(nomp);
                    }

                tc.commit();
                return nomps;
         }else{
            ArrayList<Objectif> obj = consultTypePs();
            for(Objectif o : obj){
                if(o.getLibobj().equals(objectif)){
           Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
           Transaction tc = ses.beginTransaction() ;
           Query q = ses.createQuery ("from Programmestandard");
           List<Programmestandard> lps = (List<Programmestandard>) q.list();
           ArrayList<String> nomps = new ArrayList<String>();
           for(Programmestandard p : lps){
               if( p.getObjectifs().contains(o)){
                   String nomp = p.getLibps();
               nomps.add(nomp);
               }
           }
           tc.commit();
           return nomps;
                }
            }
         }
        return null;
    }
     
        public static String seeProgressionProg(int idClient) {
            seeProgrammeCli(idClient);
            Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tc = ses.beginTransaction() ;

            Query q = ses.createQuery ("from Objectif");
            List<Objectif> lobj = (List<Objectif>) q.list();
            ArrayList<Objectif> nomlo = new ArrayList<Objectif>();
            for(Objectif o : lobj){
                nomlo.add(o);
            }
            String res = null;
            tc.commit();
            return res;
        }




}
