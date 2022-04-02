/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mtridici
 */
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * Metodi delle stanze.
 */
public class Room implements Serializable {

    private final int id; // Id della stanza
    private String name; // Nome della stanza
    private String description; // Descrizione della stanza
    private String details; // Contenuto del comando "OSSERVA"
    private String image;
    private int numberOfRebus = 0;

    private boolean accessible = true; // La stanza è accessibile
    private boolean visible = true; // La stanza è visibile (ha le luci accese)

    private Room north = null;
    private Room south = null;
    private Room west = null;
    private Room east = null;

    //private final List<Item> list = new ArrayList<>(); // Oggetti presenti nella stanza
    private final List<Rebus> rebus = new ArrayList<>(); // Rebus presenti nella stanza

    // Id
    public Room(int id) {
	this.id = id;
    }

    // Id + nome + descrizione
    public Room(int id, String name, String description,String image,int numberOfRebus) {
	this.id = id;
	this.name = name;
	this.description = description;
        this.image = image;
	this.numberOfRebus = numberOfRebus;
    }
    
    // Id della stanza
    public int getId() {
	return id;
    }
    
    public void setNumberOfRebus(int numberOfRebus) {
	this.numberOfRebus = numberOfRebus;
    }    
    
    public int getNumberOfRebus() {
	return numberOfRebus;
    }

    // Nome della stanza
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    // Descrizione della stanza
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getImage() {
	return this.image;
    }

    public void setImage(String name) {
	this.name = image;
    }
    
    // Comando "OSSERVA"
    public String getDetails() {
	return details;
    }

    public void setDetails(String details) {
	this.details = details;
    }
    
    public List<Rebus> getRebus() {
	return rebus;
    }
    
    public void addRebus(Rebus rebus) {
	this.rebus.add(rebus);
    }

    // Se accessibile
    public boolean isAccessible() {
	return accessible;
    }

    public void setAccessible(boolean accessible) {
	this.accessible = accessible;
    }

    // Se visibile (luci accese)
    public boolean isVisible() {
	return visible;
    }

    public void setVisible(boolean visible) {
	this.visible = visible;
    }

    // Stanze adiacenti (N/S/W/E)
    public void setNeighbor(Room north, Room south, Room west, Room east) {
	this.north = north;
	this.south = south;
	this.west = west;
	this.east = east;
    }

    // Stanza a nord, sud, ovest, est
    public Room getNorth() {
	return north;
    }

    public Room getSouth() {
	return south;
    }

    public Room getWest() {
	return west;
    }

    public Room getEast() {
	return east;
    }

    // EQUALS + HASH CODE override
    
    // EQUALS + HASH CODE override
    // confrontare due oggetti usando i metodi hascode ed equals "originali"
    // restituisce "false" come risultato poiché si confrontano gli indirizzi 
    //di memoria e non i "valori" 
    
    @Override
    public int hashCode() {
	int hash = 3; //prime number
	hash = 83 * hash + this.id;
	return hash;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
        
	final Room other = (Room) obj;
        
	if (this.id != other.id) {
	    return false;
	}
	return true;
    }


} // fine della classe principale "Room"