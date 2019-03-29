/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import Bd.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        List<Programmeperso> lpp = new ArrayList<Programmeperso>();
        lpp = (List<Programmeperso>) q.list();
        Programmeperso pp = new Programmeperso();
        pp = lpp.get(lpp.size()-1);
        tc.commit();
        return pp;
    }

    public static Client showInfoClient (int idClient) {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction() ;
        Query q  =ses.createQuery ("from Client as c where c.idc = "+idClient);
        Client c = new Client();
        c = (Client) q.list().get(0);
        tc.commit();
        return c;
    }

    public static ArrayList<Objectif> showObjectifCli (int idClient) {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction();
        Query q = ses.createQuery ("from Choisir as c where c.client = " + idClient);
        List<Choisir> l_cho = new ArrayList<>();
        l_cho = (List<Choisir>) q.list();
        ArrayList<Objectif> l_obj = new ArrayList<>();
        for (Choisir ch : l_cho){
            l_obj.add(ch.getObjectif());
            ch.getObjectif().getLibobj();
        }
        tc.commit();
        return l_obj;
    }

    public static Programmeperso seeProgrammeCli(int idClient) {
            Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tc = ses.beginTransaction() ;

            Query q = ses.createQuery ("from Programmeperso as pp where pp.client = " + idClient);
            List<Programmeperso> lpp = new ArrayList<>();
            lpp = (List<Programmeperso>) q.list();
            Programmeperso pp = new Programmeperso();
            pp = lpp.get(0);
            tc.commit();
            return pp;
        }


    public static HashMap<Integer,Seanceperso> consultSeancesIdProgPerso(int idPro){
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction() ;
        Query q = ses.createQuery ("from Seanceperso as sp where sp.programmeperso = "+idPro);
        List<Seanceperso> lsp = new ArrayList<>();
        lsp = (List<Seanceperso>) q.list();
        HashMap<Integer,Seanceperso> msp;
        msp = new HashMap<>();
        for(Seanceperso sp: lsp){
           msp.put(sp.getOrdresea(), sp);
        }
        tc.commit();
        return msp;
    }

    public static HashMap<Integer,Seancestandard> consultSeancesIdProgStand(int idPS){
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction() ;
        Query q1 = ses.createQuery ("from Possederps as psp where psp.programmestandard = "+idPS);
        List<Possederps> lpsp = (List<Possederps>) q1.list();
        HashMap<Integer,Seancestandard> mss;
        mss = new HashMap<>();
        for(Possederps psp : lpsp){
            mss.put(psp.getOrdredefaut(), psp.getSeancestandard());
            psp.getSeancestandard().getLibseas();
        }
        tc.commit();
        return mss;
    }
    /**
     * Method that return all names of programs.
     * @return return all name of programs
     */
    public static ArrayList<Programmestandard> consultProgramSt() {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction() ;

        Query q = ses.createQuery ("from Programmestandard as ps");

        List<Programmestandard> lps = (List<Programmestandard>) q.list();
        ArrayList<Programmestandard> lpss = new ArrayList<Programmestandard>();

        for(Programmestandard p : lps){
            lpss.add(p);
        }
        tc.commit();
        return lpss;
    }
    /**
     * Method that return all name of objectives.
     * @return list of name of objectives
     */
    public static ArrayList<String> consultType() {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction() ;

        Query q = ses.createQuery ("from Objectif");
        List<Objectif> lobj = new ArrayList<>();
        lobj = (List<Objectif>) q.list();
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
        List<Objectif> lobj = new ArrayList<>();
        lobj = (List<Objectif>) q.list();
        ArrayList<Objectif> nomlo = new ArrayList<Objectif>();
        for(Objectif o : lobj){
            nomlo.add(o);
        }
        tc.commit();
        return nomlo;
    }



     public static ArrayList<Programmestandard> lireProgObj(String objectif) {
         if(objectif.equals(null)){

            return consultProgramSt();

         }else{
            ArrayList<Objectif> obj = consultTypePs();
            for(Objectif o : obj){
                if(o.getLibobj().equals(objectif)){
           Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
           Transaction tc = ses.beginTransaction() ;
           Query q = ses.createQuery ("from Programmestandard");

           List<Programmestandard> lps = (List<Programmestandard>) q.list();
           ArrayList<Programmestandard> lpss = new ArrayList<Programmestandard>();
           for(Programmestandard p : lps){
               if( p.getObjectifs().contains(o)){
                lpss.add(p);
               }
           }
           tc.commit();
           return lpss;
                }
            }
         }
        return null;
    }

        public static float seeProgressionProg(int idClient) {
            Programmeperso pp = new Programmeperso();
            pp = seeProgrammeCli(idClient);
            Session ses2 = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tc2 = ses2.beginTransaction() ;
            Query q = ses2.createQuery ("from Programmeperso as pp where pp.idpp=" + pp.getIdpp());
            Programmeperso pp2 = new Programmeperso();
            pp2 = (Programmeperso) q.list().get(0);

            Set<Seanceperso> listesp = new HashSet<Seanceperso>();
            listesp = pp2.getSeancepersos();

            int i=0;
            int j=0;

            for(Seanceperso sp : listesp){
                i+=1;
                if(sp.getDatesea()!=null){
                    j+=1;
                }
            }

            float k = 0;
            k = (float)j/i;
            tc2.commit();
            return k;
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
