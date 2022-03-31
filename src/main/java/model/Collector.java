/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mtridici
 */
import controller.Game;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;


public class Collector implements Serializable {

    private  List<Room> rooms = new ArrayList<>(); // Lista contenente le stanze
    private  List<Command> commands = new ArrayList<>(); // Lista contenente i comandi
    private  List<Item> items = new ArrayList<>(); // Lista degli oggetti nell'inventario
    private  List<Rebus> rebus = new ArrayList<>(); // Lista dei rebus nell'inventario
    private  List<Target> target = new ArrayList<>(); // Lista dei target nell'inventario
    private  static Game game = new Game();
    private  static Crono crono = new Crono();

    // Restituisci l'elenco delle stanze
    public  List<Room> getRooms() {
	return rooms;
    }

    // Restituisci l'elenco dei comandi
    public  List<Command> getCommands() {
      return commands;
    }

    // Restituisci l'elenco degli oggetti nell'inventario
    public  List<Item> getItems() {
	return items;
    }

    // Restituisci l'elenco dei rebus nell'inventario
    public  List<Rebus> getRebus() {
	return rebus;
    }

    // Restituisci l'elenco dei rebus nell'inventario
    public  List<Target> getTargets() {
	return target;
    }

    public  void setRooms(List<Room> r) {
	rooms = r;
    }
 
    // Restituisci l'elenco dei comandi
    public  void setCommands(List<Command> c) {
        commands = c;
    }

    // Restituisci l'elenco degli oggetti nell'inventario
    public  void setItems(List<Item> i) {
	items = i;
    }

    // Restituisci l'elenco dei rebus nell'inventario
    public  void setRebus(List<Rebus> r) {
	rebus = r;
    }

    // Restituisci l'elenco dei rebus nell'inventario
    public  void setTargets(List<Target> t) {
	target = t;
    }

    public static void setGame(Game g) {
        game = g;
    }

    public static Game getGame() {
        return game;
    }

    public static void setCrono(Crono c) {
        crono = c;
    }

    public static Crono getCrono() {
        return crono;
    }

} 

