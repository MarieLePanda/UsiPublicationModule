/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package usipublicationmodule;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import myObject.Application;
import myObject.Capability;
import myObject.Segment;

/**
 *
 * @author lug13995
 */
public class Publish {
    public static String htmlStarted = "<html>\n" +
"    <head>\n" +
"        <title>TODO supply a title</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <style>\n" +
"            body, html {\n" +
"                padding:0;\n" +
"                margin:0;\n" +
"                height: 100%;\n" +
"                width:100%;\n" +
"                font-family: sans-serif;\n" +
"                font-family: colibri;\n" +
"                font-color:white; \n" +
"                /*background-color: #0772A1;*/\n" +
"                background-color: #023052;\n" +
"                overflow: auto;\n" +
"                background-size: 100%;\n" +
"            }   \n" +
"            a {text-decoration: none;color:#333;}\n" +
"            #page {\n" +
"                width:70%;\n" +
"                margin: 0 auto;\n" +
"                height: 100%;\n" +
"                position: relative;\n" +
"                box-shadow: 1px 0px 15px #000000;\n" +
"                border-radius:20px;\n" +
"            }\n" +
"            #rightPage{\n" +
"                border: solid#ffff00;\n" +
"                margin-top:5%;\n" +
"                margin-right:auto;\n" +
"                margin-left:15%;\n" +
"            }\n" +
"            #value{\n" +
"                padding-top: 5px;\n" +
"                padding-bottom: 5px;\n" +
"                padding-left:12px;\n" +
"                padding-right:50px;\n" +
"                text-align:center;\n" +
"            }\n" +
"    </style>\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/PageObject.css\"/>\n" +
"    </head>\n" +
"    <body>\n" +
"        <div id=\"rightPage\">" +
"           <h1>"
            , htmlFinished = "</div></td>\n" +
"                </tr>\n" +
"            </table>\n" +
"        </div>\n" +
"    </body>\n" +
"       \n" +
"</html>\n";
    
    public static void generateSegment(){
        File dir = new File("publication\\zone");
        dir.mkdirs();
        String htmlAfterName, htmlAfterValId, htmlAfterValDescription,
                htmlAfterValResponsible, htmlAfterValResponsibleDeputy;
        htmlAfterName = "</h1>\n" +
"            <table id=\"tableau\" BORDER=\"2\">\n" +
"                <tr>\n" +
"                    <td><div id=\"value\">id :</div></td> <td><div id=\"value\">";
        htmlAfterValId = "</td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><div id=\"value\">description :</div></td> <td><div id=\"value\">";
        htmlAfterValDescription = "</div></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><div id=\"value\">Responsable :</div></td> <td><div id=\"value\">";
        htmlAfterValResponsible = "</div></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><div id=\"value\">Responsable suppléant :</div></td> <td><div id=\"value\">";
        htmlAfterValResponsibleDeputy = "</div></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><div id=\"value\">Liste des quartiers :</div></td> <td><div id=\"value\">";
        BufferedWriter file =null; 
        for(Segment s : data.IHM.DataIHM.getListAllSegment()){
            if(s.getName().equals("__Aucun") == false){    
                try{
                    FileWriter fileWriter = new FileWriter(".\\publication\\zone\\" + s.getName().replaceAll(" ", "_") + ".html");
                    file = new BufferedWriter(fileWriter);
                    file.write(htmlStarted + objectValue(s.getName()) +  htmlAfterName + objectValue(s.getId()) + htmlAfterValId + objectValue(s.getDescription())
                    + htmlAfterValDescription + objectValue(s.getResponsible()) + htmlAfterValResponsible + objectValue(s.getResponsibledeputy()) + 
                    htmlAfterValResponsibleDeputy);
                    for(myObject.Process p : s.getListProcess()){
                        file.write(objectValue(p.getName()) + "</br>"); 
                    }
                    file.write(htmlFinished);
                }
                catch (IOException ex) {
                    Logger.getLogger(Publish.class.getName()).log(Level.SEVERE, null, ex);
                }
                finally{
                    try {
                        if(file != null)
                            file.close();
                    }catch (IOException err) {
                        err.getMessage();
                    }
                }
            }
        }
    }
    
    public static void generateProcess(){
        String htmlAfterName, htmlAfterValId, htmlAfterValDescription,
                htmlAfterValResponsible, htmlAfterValResponsibleDeputy, htmlAfterValSegment;
        htmlAfterName = "</h1>\n" +
"            <table id=\"tableau\" BORDER=\"2\">\n" +
"                <tr>\n" +
"                    <td><div id=\"value\">id :</div></td> <td><div id=\"value\">";
        htmlAfterValId = "</td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><div id=\"value\">description :</div></td> <td><div id=\"value\">";
        htmlAfterValDescription = "</div></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><div id=\"value\">Responsable :</div></td> <td><div id=\"value\">";
        htmlAfterValResponsible = "</div></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><div id=\"value\">Responsable suppléant :</div></td> <td><div id=\"value\">";
        htmlAfterValResponsibleDeputy = "</div></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><div id=\"value\">Zone supportée :</div></td> <td><div id=\"value\">";
        htmlAfterValSegment = "</div></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><div id=\"value\">Liste des ilots :</div></td> <td><div id=\"value\">";
        BufferedWriter file =null; 
        File dir = new File("publication\\quartier");
        dir.mkdirs();
        for(myObject.Process p : data.IHM.DataIHM.getListAllProcess()){
            if(p.getName().equals("__Aucun") == false){
                try{
                    FileWriter fileWriter = new FileWriter(".\\publication\\quartier\\" + p.getName().replaceAll(" ", "_") + ".html");
                    file = new BufferedWriter(fileWriter);
                    file.write(htmlStarted + objectValue(p.getName()) +  htmlAfterName + objectValue(p.getId()) + htmlAfterValId + objectValue(p.getDescription())
                    + htmlAfterValDescription + objectValue(p.getResponsible()) + htmlAfterValResponsible + objectValue(p.getResponsibleDeputy()) + 
                    htmlAfterValResponsibleDeputy + objectValue(p.getSegment()) + htmlAfterValSegment);
                    for(Capability c : p.getListCapability()){
                        file.write(objectValue(c.getName()) + "</br>"); 
                    }
                    file.write(htmlFinished);
                }
                catch (IOException ex) {
                    Logger.getLogger(Publish.class.getName()).log(Level.SEVERE, null, ex);
                }
                finally{
                    try {
                        if(file != null)
                            file.close();
                    }catch (IOException err) {
                        err.getMessage();
                    }
                }
            }
        }
    }
    
    public static void generateCapabilities(){
        String htmlAfterName, htmlAfterValId, htmlAfterValDescription,
                htmlAfterValResponsible, htmlAfterValResponsibleDeputy, htmlAfterValProcess;
        htmlAfterName = "</h1>\n" +
"            <table id=\"tableau\" BORDER=\"2\">\n" +
"                <tr>\n" +
"                    <td><div id=\"value\">id :</div></td> <td><div id=\"value\">";
        htmlAfterValId = "</td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><div id=\"value\">description :</div></td> <td><div id=\"value\">";
        htmlAfterValDescription = "</div></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><div id=\"value\">Responsable :</div></td> <td><div id=\"value\">";
        htmlAfterValResponsible = "</div></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><div id=\"value\">Responsable suppléant :</div></td> <td><div id=\"value\">";
        htmlAfterValResponsibleDeputy = "</div></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><div id=\"value\">Quartier supportée :</div></td> <td><div id=\"value\">";
        htmlAfterValProcess = "</div></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td><div id=\"value\">Liste des applications :</div></td> <td><div id=\"value\">";
        BufferedWriter file =null; 
        File dir = new File("publication\\ilot");
        dir.mkdirs();
        for(Capability c : data.IHM.DataIHM.getAllCapability()){
            if(c.getName().equals("__Aucun") == false){
                try{
                    FileWriter fileWriter = new FileWriter(".\\publication\\ilot\\" + c.getName().replaceAll(" ", "_") + ".html");
                    file = new BufferedWriter(fileWriter);
                    file.write(htmlStarted + objectValue(c.getName()) +  htmlAfterName + objectValue(c.getId()) + htmlAfterValId + objectValue(c.getDescription())
                    + htmlAfterValDescription + objectValue(c.getResponsible()) + htmlAfterValResponsible + objectValue(c.getResponsibleDeputy()) + 
                    htmlAfterValResponsibleDeputy + objectValue(c.getProcess()) + htmlAfterValProcess);
                    for(Application a : c.getListApplication()){
                        file.write(objectValue(c.getName()) + "</br>"); 
                    }
                    file.write(htmlFinished);
                }
                catch (IOException ex) {
                    Logger.getLogger(Publish.class.getName()).log(Level.SEVERE, null, ex);
                }
                finally{
                    try {
                        if(file != null)
                            file.close();
                    }catch (IOException err) {
                        err.getMessage();
                    }
                }
            }
        }
    }
    
    public static String objectValue(Object o){
        if(o == null)
            return "N/A";
        else
            return o.toString();
    }

}
