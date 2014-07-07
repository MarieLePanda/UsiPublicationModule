/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package usipublicationmodule;

import java.io.File;

/**
 *
 * @author lug13995
 */
public class UsiPublicationModule {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File dir = new File("publication");
        dir.mkdir();
        Publish.generateSegment();
        Publish.generateProcess();
        Publish.generateCapabilities();
    }
    
}
