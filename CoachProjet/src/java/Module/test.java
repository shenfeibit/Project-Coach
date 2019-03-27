
package Module;


import Bd.Choisir;
import Bd.Client;
import Bd.HibernateUtil;
import Bd.Objectif;
import Bd.Programmeperso;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class test {
//     public static void main (String[] args){
//        Programmeperso pp = new Programmeperso();
//        pp = HibernateMethode.consultProgramClient(1);
//        System.out.print(pp.getIdpp());
//     }
     
     public static void main (String[] args){
        Client c = HibernateMethode.showInfoClient(6);
        System.out.print(c.getNomc());
     }
     
//     public static void main (String[] args){
////        List<Objectif> l_obj = HibernateMethode.showObjectifCli(6);
////            System.out.print(0);
////        for (Objectif o : l_obj){
////            System.out.print(o.getLibobj());
////        }
//
////        System.exit(0);
//     }
}
