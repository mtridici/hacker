/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author mtridici
 */
import model.Rebus;
import model.Collector;
import model.Room;


/**
 * Gestione del parser.
 */
public class Parser extends Collector{

    private String[] words;
    
    public int checkUserCommand(String userCommand, Rebus rebus, Room room) {
        
        String phrase = userCommand.toLowerCase().trim();

        //Remove extra chars
        String[] extras = {" il ", " lo ", " la ", " i ", " gli ", " le ", "'", " l ", " con ", " nel ", " in ", "nello", "nella", "nell"};
	for (String extra : extras) {
	    phrase = phrase.replace(extra, " ");
	}
        
        words = phrase.split("\\s+|\\'"); // Dividi la frase digitata in più parole

        
        if (rebus.item == null)
            if (compareCommand(rebus) != -1 && compareTarget(rebus) != -1) {
                return 0;
            }
        
        if (rebus.target == null)
            if (compareCommand(rebus) != -1 && compareItem(rebus) != -1) {
                return 0;
            }
        
        if (rebus.item != null && rebus.command != null && rebus.target != null)
            if (compareCommand(rebus) != -1 && compareItem(rebus) != -1 && compareTarget(rebus) != -1) {
                return 0;
            }
        
        return -1; //Istruzione errata
    
    }
    
   
    public int compareCommand(Rebus rebus){
        

        for (int i=0; i<words.length; i++)
        for(String s : rebus.command.getAlias()) {
            if(s.equals(words[i])) {
                return i;
            }
        }

        return -1; // Comando non trovato
        
    }
    
    public int compareItem(Rebus rebus){
        
        for (int i=0; i<words.length; i++)
        for(String s : rebus.item.getAlias()) {
            if(s.equals(words[i])) {
                return i;
            }
        }

               
        return -1; // Item non trovato
    }
      
    public int compareTarget(Rebus rebus){
        
        for (int i=0; i<words.length; i++)
        for(String s : rebus.target.getAlias()) {
            if(s.equals(words[i])) {
                return i;
            }
        }

               
        return -1; // Item non trovato
    }
    
    
} // fine della classe principale "Parser"