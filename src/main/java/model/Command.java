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
 * Metodi dei comandi.
 */
public class Command implements Serializable {

    private Set<String> alias; // Nome e alias del comando
    int id;
    
    public void setId(int id) {
        this.id = id;
    }

    // Tipo di comando + alias
    public Command(Set<String> alias) {
	this.alias = alias;
    }
    
    public Command(int id, String[] alias) {
        this.id = id;
	this.alias = new HashSet<>(Arrays.asList(alias));
    }

    // Alias
    public Set<String> getAlias() {
	return alias;
    }

    public void setAlias(Set<String> alias) {
	this.alias = alias;
    }

    public void setAlias(String[] alias) {
	this.alias = new HashSet<>(Arrays.asList(alias));
    }


} // fine della classe principale "Command"
