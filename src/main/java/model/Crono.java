/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author mtridici
 */
public class Crono implements Serializable{

    private Instant start;
    private Instant stop;
    private long gap, partialGap;
    private boolean resumedGame;

    public Crono() {
        start = Instant.now();
        stop = Instant.now();
        gap = 0;
        partialGap = 0;
        resumedGame = false;
    }

    public void setStart() {
        start = Instant.now();
    }

    public void setStop() {
        stop = Instant.now();
    }

    public void setResumed() {
        resumedGame = true;
    }

    public Instant getStart() {
        return start;
    }

    public Instant getStop() {
        return stop;
    }

    public long getScore() {
        return gap;
    }

public void calculateScore() {

        if(resumedGame) {
            partialGap = ChronoUnit.SECONDS.between(start,stop);
            gap = partialGap + gap;
        }
        else {
            gap = ChronoUnit.SECONDS.between(start,stop);
        }

}
    
} // fine della classe principale "Crono"
