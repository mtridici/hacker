/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author mtridici
 */
import java.awt.HeadlessException;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Sound implements Runnable {

private Clip clip;
private AudioInputStream stream;
private boolean enabled = false;

    @Override
    public void run() {

        try {

            stream = AudioSystem.getAudioInputStream(getClass().getResource("/hacker.wav"));
            //audioInput = AudioSystem.getAudioInputStream(this.getClass().getResource("/hacker.wav"));
            clip = AudioSystem.getClip();
            clip.open(stream);

            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            enabled=true;

        } catch (HeadlessException | IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
            System.err.println("Impossibile riprodurre la musica.\nEccezione verificata: " + ex);
        }

    }

    public void stop(){
        if(enabled)
            if(clip.isOpen() && clip.isRunning()) {
                this.clip.stop();
                this.clip.close();
            }
    }

}
