/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package usipublicationmodule;

import javax.swing.JOptionPane;


/**
 *
 * @author lug13995
 */
public class PublishModule implements plugin.IModule{

    public PublishModule(){
        
    }
    
    @Override
    public void plug() {
    }

    @Override
    public void start() {
        Publish.generateSegment();
        Publish.generateProcess();
        Publish.generateCapabilities();
        JOptionPane.showMessageDialog(null, "Page html créée");
    }

    @Override
    public void unplug() {
    }

    @Override
    public String getName() {
        return "Publication html";
    }
    
}
