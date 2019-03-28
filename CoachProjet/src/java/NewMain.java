
import Bd.Seancestandard;
import Module.HibernateMethode;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 21611943
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashMap<Integer,Seancestandard> mss = HibernateMethode.consultSeancesIdProgStand(1);
        for(int i: mss.keySet()){
            System.out.println(i+" :"+mss.get(i).getLibseas()+mss.get(i).getDescripseas());
        }
    }
    
}
