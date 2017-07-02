/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transportadoraifes;

import javax.swing.JOptionPane;

/**
 *
 * @author Igor Ferrani
 */
public class Util {
    public static void showCatch(String e){
        showMessage("### " + e);
    }
    
    public static void showMessage(String e){
        JOptionPane.showMessageDialog(null, e);
    }
}
