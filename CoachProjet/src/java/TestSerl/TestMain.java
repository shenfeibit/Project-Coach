/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestSerl;

import Bd.*;
import Module.HibernateMethode;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author 21611943
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Programmeperso pp = new Programmeperso();
        pp = HibernateMethode.consultProgramIdPro(1);
        System.out.println("lib"+pp.getLibpp()+"/des"+pp.getDescrippp());
        HashMap<Integer,Seanceperso> msp = HibernateMethode.consultSeancesIdProgPerso(1);
        for(int ordre: msp.keySet()){
            System.out.println("ordre"+ordre+"/lib"+msp.get(ordre).getLibsea());
        }
    }
    
}
