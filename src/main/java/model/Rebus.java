/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
/**
 *
 * @author mtridici
 */
public class Rebus implements Serializable {

    private int id;
    boolean isSolved=false;
    public Item item;
    public Command command;
    public Target target;
    public Room unlockableRoom;
    public String name;
    public String feedback;

    public Rebus(int id, String name, boolean isSolved, Item item, Command command, Target target, Room unlockableRoom, String feedback) {

        this.id = id;
        this.isSolved = false;
        this.item = item;
        this.command = command;
        this.target = target;
        this.unlockableRoom = unlockableRoom;
        this.name = name;
        this.feedback = feedback;

    }

    public int getId() {
        return this.id;
    }

    public void setRebus(int id, String name, boolean isSolved,  Item item, Command command, Target target, Room unlockableRoom, String feedback) {

        this.id = id;
        this.isSolved = false;
        this.item = item;
        this.command = command;
        this.target = target;
        this.unlockableRoom = unlockableRoom;
        this.name = name;
        this.feedback = feedback;

    }

    public Rebus getRebus() {
        return this;
    }

    public Item getRebusItem() {
        return this.item;
    }

    public Command getRebusCommands() {
        return this.command;
    }

    public Target getRebusTarget() {
        return this.target;
    }

    public String getRebusFeedback() {
        return this.feedback;
    }

    public boolean isSolved(){
        return this.isSolved;
    }

    public void setSolved(boolean isSolved){
        this.isSolved=true;
        Collector.getGame().getCurrentRoom().setNumberOfRebus(Collector.getGame().getCurrentRoom().getNumberOfRebus() - 1);

        if(Collector.getGame().getCurrentRoom().getNumberOfRebus() == 0) {

            unlockableRoom.setVisible(true);
            unlockableRoom.setAccessible(true);
        }
    }

    public String getRebusName() {
        return this.name;
    }

} // fine della classe principale "Rebus"
