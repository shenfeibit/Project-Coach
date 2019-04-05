

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import Bd.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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

//    public static Programmeperso consultProgramClient(int idClient) {
//        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
//        Transaction tc = ses.beginTransaction();
//        Query q = ses.createQuery ("from Programmeperso as pp where pp.client = "+idClient);
//        List<Programmeperso> lpp = new ArrayList<Programmeperso>();
//        lpp = (List<Programmeperso>) q.list();
//        Programmeperso pp = new Programmeperso();
//        pp = lpp.get(lpp.size()-1);
//        tc.commit();
//        return pp;
//    }

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
        System.out.println(lpsp.size());
        HashMap<Integer,Seancestandard> mss;
        mss = new HashMap<>();
        for(int i=0;i<lpsp.size();i++){
            mss.put(lpsp.get(i).getId().getOrdredefaut(), lpsp.get(i).getSeancestandard());
            lpsp.get(i).getSeancestandard().getLibseas();
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

        Query q = ses.createQuery ("from Programmeperso as pp order by pp.idpp desc");
        List<Programmeperso> lpro = (List<Programmeperso>) q.list();
        ArrayList<Client> l_cli = new ArrayList();
        for(Programmeperso p : lpro){
            l_cli.add(p.getClient());
            p.getClient().getNomc();
        }
        tc.commit();
        return l_cli;
    }

 public static ArrayList<Client> consultClientNonPgrm() {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction() ;

        Query q = ses.createQuery ("from Choisir as c where c.client not in (select client from Programmeperso as pp where pp.etatpp='en cours') order by c.datedemande desc");
        List<Choisir> l_choix = (List<Choisir>) q.list();
        ArrayList<Client> l_cli = new ArrayList();
        for(Choisir c : l_choix){
            l_cli.add(c.getClient());
            c.getClient().getNomc();
        }
        tc.commit();
        return l_cli;
    }

  public static String showDateDemande(int idClient) {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction() ;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Query q = ses.createQuery ("from Choisir as c where c.client ="+idClient+" order by c.datedemande desc");
        Choisir choixCli = new Choisir();
        choixCli = (Choisir)q.list().get(0);
        String dateCli = sf.format(choixCli.getDatedemande());
        tc.commit();
        return dateCli;
    }

public static void affecter(int idps, int idc){
            Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tc = ses.beginTransaction();

            //enregistrer dans programmeperso
            Query qCli = ses.createQuery("from Client as c where c.idc= " + idc);
            Client c = (Client) qCli.list().get(0);
            Date date = new Date();
            Query qProg = ses.createQuery("from Possederps as pp where pp.programmestandard=" + idps);
            List<Possederps> listpossederps = (List<Possederps>) qProg.list();
            Programmestandard ss = listpossederps.get(0).getProgrammestandard();
            Set<Seancestandard> setSes = new HashSet<>();
            for(Possederps ps : listpossederps){
               setSes.add(ps.getSeancestandard());
            }
            Set<Objectif> setObj = new HashSet<Objectif>();
            for( Object o : ss.getObjectifs()){
                setObj.add((Objectif) o);
            }
            Programmeperso programmeperso = new Programmeperso(c, ss.getLibps(), ss.getDescripps(), ss.getDureeps(), "en cours", date, setSes, setObj );
            ses.save(programmeperso);

            //enregistrer dans seanceperso
            for(Possederps ps : listpossederps){
                Seancestandard sesncest = ps.getSeancestandard();
                Query qListPossedersea = ses.createQuery("from Possedersea as p where p.seancestandard= " + sesncest.getIdseas());
                List<Possedersea> listpossedersea = qListPossedersea.list();
                Set<Exercisestandard> setExe = new HashSet<Exercisestandard>();
                for(Possedersea psea : listpossedersea){
                    setExe.add((Exercisestandard) psea.getExercisestandard());
                }


                Seanceperso seanceperso = new Seanceperso(programmeperso, ps.getSeancestandard().getLibseas(), ps.getSeancestandard().getDescripseas(), ps.getSeancestandard().getTypeseas(), ps.getId().getOrdredefaut(),ps.getSemainesea(),null,null, null, null, null, null, setExe );
                ses.save(seanceperso);

                //enregistrer dans exerciseperso
                for(Exercisestandard exeSt : setExe){

                    Query qOrdreExe = ses.createQuery("from Possedersea as p where p.seancestandard= " + ps.getSeancestandard().getIdseas() + "and p.exercisestandard = " +exeSt.getIdexes());
                    Possedersea pse = (Possedersea) qOrdreExe.list().get(0);
                    int orderExe =  pse.getId().getOrdreExo();

                    Exerciseperso exerciseperso = new Exerciseperso(seanceperso,exeSt.getLibexes(), exeSt.getDescripexes(), exeSt.getDureeexes(), exeSt.getNbrepets(), exeSt.getPhotoexe(), exeSt.getVideoexe(), orderExe, null, null, null,exeSt.getMateriel());
                    ses.save(exerciseperso);
                }


            }
            tc.commit();
}
public static HashMap<Integer,Exerciseperso> showExePersoBySea(int idSea){
            HashMap<Integer,Exerciseperso> l_exep= new HashMap();

            Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tc = ses.beginTransaction() ;
//             as ex where ex.seanceperso="+idSea
            Query q = ses.createQuery("from Exerciseperso as ex where ex.seanceperso="+idSea);
            List<Exerciseperso> lexe = (List<Exerciseperso>) q.list();
            for(Exerciseperso exe: lexe){
                l_exep.put(exe.getOrdreexe(), exe);
            }
            tc.commit();
            return l_exep;
        }

public static boolean verifCli (int idClient, String nomc) {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction();
        Query q = ses.createQuery ("from Client as c where c.idc = " + idClient);
        List<Client> l_cli = new ArrayList<>();
        l_cli = (List<Client>) q.list();
        tc.commit();
        if(l_cli.get(0).getNomc().equals(nomc)){
            return true;
        }else{
            return false;
        }
    }


public static boolean verifCoach (int idCoach, String nomCoach) {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction();
        Query q = ses.createQuery("from Coach as c where c.idco = " + idCoach);
        List<Coach> l_co = new ArrayList<>();
        l_co = (List<Coach>) q.list();
        tc.commit();
        if(l_co.get(0).getNomco().equals(nomCoach)){
            return true;
        }else{
            return false;
        }
    }
public static String showNameSea (int idSea) {
    Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tc = ses.beginTransaction() ;
    Query q = ses.createQuery("from Seanceperso as sp where sp.idsea="+idSea);
    Seanceperso sp = (Seanceperso) q.list().get(0);
    String name = sp.getLibsea();
    tc.commit();
    return name;

}

public static Exerciseperso showExe (int idExe) {
    Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tc = ses.beginTransaction() ;
    Query q = ses.createQuery("from Exerciseperso as ep where ep.idexe="+idExe);
    Exerciseperso ep = (Exerciseperso) q.list().get(0);
    tc.commit();
    return ep;
}

public static HashMap<Integer,Integer> getOrderExe(int idSea){
    Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tc = ses.beginTransaction();
    Query q = ses.createQuery("from Exerciseperso as ep where ep.seanceperso="+idSea+ " order by ep.idexe asc");
    ArrayList<Exerciseperso> e = (ArrayList<Exerciseperso>) q.list();
    HashMap<Integer,Integer> listexe = new HashMap<Integer,Integer>();
    for(Exerciseperso ep : e){
        listexe.put(ep.getOrdreexe(), ep.getIdexe());
    }
    tc.commit();
    return listexe;
}

public static List<Client> verifierClient (String nomSaisi) {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction() ;
        Query q  = ses.createQuery ("from Client as c where c.nomc like '"+nomSaisi+"%'");
        List<Client> lstc = new ArrayList<Client>();
        lstc = (List<Client>) q.list();
        tc.commit();
        return lstc;
    }

//author Fei
public static HashMap<String,String[]> evoluationBilan(int idCli){
    Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tc = ses.beginTransaction();
    Query q = ses.createQuery("from Seanceperso as sea where sea.programmeperso "
            + "= (select idpp from Programmeperso as pp where pp.client = "+idCli+") "
                    + "and sea.typesea='bilan' and sea.datesea is not null");
    HashMap<String,String[]> mres = new HashMap<String,String[]>();
    List<Seanceperso> lsea = (List<Seanceperso>) q.list();
    if(lsea.size()>1){
        Seanceperso b1 = lsea.get(0);
        Seanceperso b2 = lsea.get(lsea.size()-1);

        //for the evaluations of bras
        String[] resB = new String[3];
        resB[0]=b1.getBras().toString();
        resB[1]=b2.getBras().toString();
        resB[2]=new BigDecimal(Double.parseDouble(resB[1])-Double.parseDouble(resB[0]))
                .setScale(2,BigDecimal.ROUND_HALF_UP).toString();
        mres.put("Bras",resB);

        //for poitrine
        String[] resP = new String[3];
        resP[0]=b1.getPoitrine().toString();
        resP[1]=b2.getPoitrine().toString();
        resP[2]=new BigDecimal(Double.parseDouble(resP[1])-Double.parseDouble(resP[0]))
                .setScale(2,BigDecimal.ROUND_HALF_UP).toString();
        mres.put("Poitrine",resP);

        //for Taille
        String[] resT = new String[3];
        resT[0]=b1.getTaille().toString();
        resT[1]=b2.getTaille().toString();
        resT[2]=new BigDecimal(Double.parseDouble(resT[1])-Double.parseDouble(resT[0]))
                .setScale(2,BigDecimal.ROUND_HALF_UP).toString();
        mres.put("Taille",resT);

        //for hanches
        String[] resH = new String[3];
        resH[0]=b1.getHanches().toString();
        resH[1]=b2.getHanches().toString();
        resH[2]=new BigDecimal(Double.parseDouble(resH[1])-Double.parseDouble(resH[0]))
                .setScale(2,BigDecimal.ROUND_HALF_UP).toString();
        mres.put("Hanches",resH);

        //for Cuisses
        String[] resC = new String[3];
        resC[0]=b1.getCuisses().toString();
        resC[1]=b2.getCuisses().toString();
        resC[2]=new BigDecimal(Double.parseDouble(resC[1])-Double.parseDouble(resC[0]))
                .setScale(2,BigDecimal.ROUND_HALF_UP).toString();
        mres.put("Cuisses",resC);
    }
    else{
        Seanceperso b1 = lsea.get(0);

        //for the evaluations of bras
        String[] resB = new String[3];
        resB[0]=b1.getBras().toString();
        resB[1]="-";
        resB[2]="-";
        mres.put("Bras",resB);

        //for poitrine
        String[] resP = new String[3];
        resP[0]=b1.getPoitrine().toString();
        resP[1]="-";
        resP[2]="-";
        mres.put("Poitrine",resP);

        //for Taille
        String[] resT = new String[3];
        resT[0]=b1.getTaille().toString();
        resT[1]="-";
        resT[2]="-";
        mres.put("Taille",resT);

        //for hanches
        String[] resH = new String[3];
        resH[0]=b1.getHanches().toString();
        resH[1]="-";
        resH[2]="-";
        mres.put("Hanches",resH);

        //for Cuisses
        String[] resC = new String[3];
        resC[0]=b1.getCuisses().toString();
        resC[1]="-";
        resC[2]="-";
        mres.put("Cuisses",resC);
    }
    tc.commit();
    return mres;
}
public static void addPerformance (int idExe, String performance) {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction();
        Query q = ses.createQuery("update Exerciseperso set PERFORMANCE = '"+ performance +"' where IDEXE="+idExe);
        int result = q.executeUpdate();
        tc.commit();
    }

public static void finishSeance (int idSea) {
        Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tc = ses.beginTransaction();
        Date date = new Date();
        
        Query q = ses.createQuery("from Seanceperso as sp where idsea="+idSea);
        Seanceperso sp=(Seanceperso)q.list().get(0);
        sp.setDatesea(date);
        ses.update(sp);
        tc.commit();
    }

public static int showIdCli (int idSea){
    Session ses = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tc = ses.beginTransaction();
    Query q = ses.createQuery( " from Programmeperso as pp where pp.idpp in (select programmeperso from Seanceperso as sp where sp.idsea="+idSea+")" );
    List<Programmeperso> lpp = (List<Programmeperso>) q.list();
    Programmeperso pp = lpp.get(0);
    int idCli = pp.getClient().getIdc();
    tc.commit();
    return idCli;
    }
}
