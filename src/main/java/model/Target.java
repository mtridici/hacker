/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mtridici
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

/**
 * Metodi degli oggetti.
 */
public class Target implements Serializable {

    private final int id; // Id dell'oggetto
    private String name; // Nome dell'oggetto
    private String description; // Descrizione dell'oggetto
    private Set<String> alias; // Alias dell'oggetto

    // Id
    public Target(int id) {
	this.id = id;
    }

    // Id + nome
    public Target(int id, String name) {
	this.id = id;
	this.name = name;
    }

    // Id + nome + descrizione
    public Target(int id, String name, String description) {
	this.id = id;
	this.name = name;
	this.description = description;
    }

        // Id + alias
    public Target(int id, String[] alias) {
	this.id = id;
	this.alias =  new HashSet<>(Arrays.asList(alias));
    }

    // Id + nome + descrizione + alias
    public Target(int id, String name, String description, Set<String> alias) {
	this.id = id;
	this.name = name;
	this.description = description;
	this.alias = alias;
    }

    // Id dell'oggetto
    public int getId() {
	return id;
    }

    // Nome dell'oggetto
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    // Descrizione dell'oggetto
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    // Alias dell'oggetto
    public Set<String> getAlias() {
	return alias;
    }

    public void setAlias(Set<String> alias) {
	this.alias = alias;
    }

    public void setAlias(String[] alias) {
	this.alias = new HashSet<>(Arrays.asList(alias));
    }
    
} // fine della classe principale "Target"
