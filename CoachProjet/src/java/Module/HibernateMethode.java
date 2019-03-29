/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import Bd.*;
import java.util.ArrayList;
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
//        Client c = (Client)ses.load(Client.class, 1);
        Query q = ses.createQuery ("from Programmeperso as pp where pp.client = "+idClient);
        List<Programmeperso> lpp = (List<Programmeperso>) q.list();
        Programmeperso pp = lpp.get(lpp.size()-1);
        tc.commit();
        return pp;
    }

    public static Client shoxInfoClient (int idClient) {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction() ;
        Client c = (Client)ses.load(Client.class, idClient);
        //tc.commit();
        return c;
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


      public static ArrayList<Client> consultClientPgrm() {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction() ;

        Query q = ses.createQuery ("from Client as c where c.idc in (select client from Programmeperso)");
        List<Client> clt = (List<Client>) q.list();
        ArrayList<Client> cliId = new ArrayList();
        for(Client c : clt){
            cliId.add(c);
        }
        tc.commit();
        return cliId;
    }

 public static ArrayList<Client> consultClientNonPgrm() {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction() ;

        Query q = ses.createQuery ("from Client as c where c.idc not in (select client from Programmeperso)");
        List<Client> clt = (List<Client>) q.list();
        ArrayList<Client> cliId = new ArrayList();
        for(Client c : clt){
            cliId.add(c);
        }
        tc.commit();
        return cliId;
    }




}
