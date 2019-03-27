
package Module;


import Bd.Client;
import Bd.HibernateUtil;
import Bd.Programmeperso;
import Bd.Programmestandard;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class test {
//     public static void main (String[] args){
//        Programmeperso pp = new Programmeperso();
//        pp = .consultProgramClient(1);
//        System.out.print(pp.getIdpp());
//     }

//     public static void main (String[] args){
//        Client c = HibernateMethode.shoxInfoClient(1);
//        System.out.print(c.getNomc());
//     }

    public static void main (String[] args){
            ArrayList<String> a = new ArrayList();
            a=HibernateMethode.lireProgObj("Se muscler");
            for(String l : a){
                System.out.print(l);
            }

     }
}
