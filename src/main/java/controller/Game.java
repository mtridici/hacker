/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Crono;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import model.Collector;
import model.Command;
import model.Item;
import model.Rebus;
import model.Room;
import model.Target;

/**
 *
 * @author mtridici
 */
public class Game extends Collector {

    private  Room entrance;
    private  Room boulevard;
    private  Room reception;
    private  Room switchboards;
    private  Room hall;
    private  Room hallway1;
    private  Room office;
    private  Room lab;
    private  Room hallway2;
    private  Room stairs;
    private  Room storageroom;
    private  Room wc;
    private  Room victory;
    private  Room currentRoom;

    private  Item plant;
    private  Item kick;
    private  Item book;
    private  Item code;
    private  Item wallet;
    private  Item badge;
    private  Item notebook;
    private  Item securcode;

    private  Command destroy;
    private  Command jump;
    private  Command turnOn;
    private  Command read;
    private  Command write;
    private  Command open;

    private  Target door;
    private  Target gate;
    private  Target light;

    private  Rebus rebus00;
    private  Rebus rebus01;
    private  Rebus rebus02;
    private  Rebus rebus03;
    private  Rebus rebus04;
    private  Rebus rebus05;
    private  Rebus rebus06;
    private  Rebus rebus07;
    private  Rebus rebus08;
    private  Rebus rebus09;
    private  Rebus rebus10;
    private  Rebus rebus11;
    private  Rebus currentRebus;
    private  int   rebusIndex;

    private boolean completed;
    public  String history = "";
    public  String playerName = "";


            
    public Game(){

        completed = false;

	// Inizializzazione Stanze
	entrance = new Room(0, "Entrata", "E' sera. Ti trovi davanti al cancello d'entrata del laboratorio informatico in cui è stato avvistato e segnalato un individuo sospetto. Uno degli ultimi attacchi informatici intercettato sembra provenire proprio da questo laboratorio. Purtroppo, l'individuo è fuggito subito dopo la soffiata. Tocca a te risalire al suo nome ed a bloccare l\'ultimo definitivo attacco. Ma prima dovrai superare il cancello. Sei un tipo atletico?", "entrance.jpg", 1);
	super.getRooms().add(entrance);

	boulevard = new Room(1, "Viale", "Stai percorrendo il viale che ti separa dalla reception del laboratorio, ma la porta d'ingresso è chiusa a chiave. Trova un modo per aprirla.", "boulevard.jpg", 1);
        boulevard.setAccessible(false); // Non è accessibile, c'è un cancello
        super.getRooms().add(boulevard);

	reception = new Room(2, "Reception", "Finalmente sei dentro, ma sei al buio. L'unica fonte di illuminazione è la luce del lampione esterno che ti permette di dare uno sguardo intorno a te. Per andare avanti sarà necessario illuminare tutte le stanze dell'edificio.", "reception.jpg", 0);
	super.getRooms().add(reception);
	reception.setAccessible(false); // Non è accessibile, è chiusa a chiave

	switchboards = new Room(3, "Sala Quadri Elettrici", "Sei nella sala di servizio in cui sono presenti i quadri elettrici dell'impianto di illuminazione. Sei nel posto giusto ed un file di luce ti aiuta a vedere cosa c'e' intorno a te. Fai ciò che è necessario per andare avanti!", "switchboards.jpg", 1);
	super.getRooms().add(switchboards);

	hall = new Room(4, "Sala Attesa", "Ti trovi nella sala d'attesa. Non vedo la presenza di indizi utili. C'è solo una porta davanti a te ed è chiusa, ma non a chiave.", "hall.jpg", 1);
	hall.setVisible(false);
        super.getRooms().add(hall);

	hallway1 = new Room(5, "Corridoio 1", "Stai percorrendo il corridoio 1, procedi con attenzione. Vedo una porta aperta. Che facciamo? Andiamo a vedere dove ci conduce?", "hallway1.jpg", 0);
	hallway1.setAccessible(false);
	super.getRooms().add(hallway1);

	office = new Room(6, "Ufficio del Responsabile del laboratorio", "Sei nell'ufficio del responsabile del laboratorio. Da questa stanza sembra essere possibile accedere al laboratorio informatico, ma la porta d'accesso al Lab è chiusa ed è protetta da un codice. Vediamo se il responsabile è stato distratto ed ha lasciato qualche indizio.", "office.jpg", 2);
	super.getRooms().add(office);

	lab = new Room(7, "Laboratorio Informatico", "Finalmente, sei nel laboratorio da cui, si presume, l'hacker anonimo abbia lanciato uno degli ultimi attacchi. Potrebbe aver usato uno dei PC presenti nel Lab. Tuttavia, è poco probabile che abbia agito indisturbato in presenza di altre persone. Prova a capire se si è spostato in altre stanze.", "lab.jpg", 0);
        lab.setAccessible(false);
	super.getRooms().add(lab);

	hallway2 = new Room(8, "Corridoio 2", "Stai percorrendo il corridoio 2, procedi speditamente alla ricerca di nuove stanze da visitare. Non credo abbia effettuato gli attacchi da qui. Purtroppo, per andare avanti occorre aprire una porta che sembra chiusa a chiave. Ma, aspetta, mi sembra di vedere un portafoglio a terra.", "hallway2.jpg", 2);
	super.getRooms().add(hallway2);

	stairs = new Room(9, "Scale", "Percorri le scale che sembrano condurre ad una nuova stanza. La ricerca si restringe. Forse ci siamo! Davanti a te, c'è una porta chiusa, ma non a chiave.", "stairs.jpg", 1);
        stairs.setAccessible(false);
        super.getRooms().add(stairs);

	storageroom = new Room(10, "Deposito", "Sei nel deposito. Non vedo nessun indizio, nulla che possa essere utile. Vedo un'ultima porta da aprire, ma sembra essere chiusa a chiave.", "storageroom.jpg", 1);
        storageroom.setAccessible(false);	
        super.getRooms().add(storageroom);

	wc = new Room(11, "Bagno", "Forse ti aspettavi qualcosa di diverso, ma sei nel bagno. C'è una finestra, è da lì che è fuggito Devil quando ha sniffato la soffiata. Per fortuna, nella fretta di scappare, ha abbandonato il suo notebook. Il notebook è spento. Sono sicuro che potremmo usarlo per bloccare l'attacco alla centrale nucleare. Risolvi gli ultimi due rebus per fermare l'hacker.", "secret.jpg", 2);
	wc.setAccessible(false);
        super.getRooms().add(wc);

	victory = new Room(12, "Hall Of Fame", "Complimenti. Hai evitato una catastrofe e sei stato catapultato nella Hall of Fame per i festeggiamenti", "fame.jpg", 0);
	victory.setAccessible(false);
        super.getRooms().add(victory);

	// Game Map
	entrance.setNeighbor(boulevard, null, null, null);
	boulevard.setNeighbor(null, entrance, null, reception);
	reception.setNeighbor(switchboards, null, boulevard, hall);
	switchboards.setNeighbor(null, reception, null, null);
	hall.setNeighbor(null, null, reception, hallway1);
	hallway1.setNeighbor(office, null, hall, null);
	office.setNeighbor(null, hallway1, null, lab);
	lab.setNeighbor(null, hallway2, office, null);
	hallway2.setNeighbor(lab, stairs, null, null);
	stairs.setNeighbor(hallway2, storageroom, null, null);
	storageroom.setNeighbor(stairs, null, null, wc);
	wc.setNeighbor(null, null, storageroom, null);
        victory.setNeighbor(null, null, null, null);

        // Current Room (Start Room)
        setCurrentRoom(entrance);

        // Rebus Entrance per entrare in Viale
        jump = new Command(0,new String[]{"salta", "supera", "scavalca"});
        gate = new Target(0,new String[]{"cancello", "portone"});
        rebus00 = new Rebus(0,"rebus00", false,null, jump, gate, boulevard, "Perfetto, potresti essere un campione di salto in alto. Procediamo.");
        entrance.addRebus(rebus00);
        // Collector 
        super.getTargets().add(gate);
        super.getCommands().add(jump);
        super.getRebus().add(rebus00);

        // Rebus Boulevard per entrare in Reception
        plant = new Item(1,new String[]{"pianta", "vaso"},true);
        destroy = new Command(1,new String[]{"sfonda", "lancia", "colpisci"});
        door = new Target(1,new String[]{"entrata", "porta", "portone"});
        rebus01 = new Rebus(1,"rebus01", false, plant, destroy, door, reception, "Un tantino violento, ma...va bene così! Andiamo avanti.");
        boulevard.addRebus(rebus01);
        // Collector 
        super.getItems().add(plant);
        super.getCommands().add(destroy);
        super.getTargets().add(door);
        super.getRebus().add(rebus01);

        // Rebus Sala Quadri per entrare in Hall
        turnOn = new Command(2,new String[]{"accendi", "solleva", "riarma", "attiva"});
        light = new Target(2,new String[]{"luce", "illuminazione", "interruttore", "interruttori"});
        rebus02 = new Rebus(2,"rebus02", false, null, turnOn, light, hall, "Complimenti. FIAT Lux! (non è una macchina della FIAT!). Ora sì che si può ragionare!");
        switchboards.addRebus(rebus02);
        // Collector 
        super.getTargets().add(light);
        super.getCommands().add(turnOn);
        super.getRebus().add(rebus02);

        // Rebus Hall per entrare in Corridoio 1
        open = new Command(3,new String[]{"apri", "supera"});
        rebus03 = new Rebus(3,"rebus03", false, null, open, door, hallway1, "Bene, andiamo avanti!");
        hall.addRebus(rebus03);
        // Collector 
        super.getTargets().add(door);
        super.getCommands().add(open);
        super.getRebus().add(rebus03);

        // Rebus #1 Office per entrare in Lab
        book = new Item(4,new String[]{"agendina", "agenda", "libro"},true);
        read = new Command(4,new String[]{"leggi", "sfoglia", "consulta"});
        rebus04 = new Rebus(4,"rebus04", false, book, read, null, lab, "Wow! Nelle prime pagine dell'agendina ho notato il numero 38475. Può essere il codice che cercavamo. Prova ad inserirlo.");
        office.addRebus(rebus04);
        // Collector 
        super.getItems().add(book);
        super.getCommands().add(read);
        super.getRebus().add(rebus04);

        code = new Item(5,new String[]{"38475", "codice"},true);
        write = new Command(5,new String[]{"inserisci", "digita", "componi"});
        rebus05 = new Rebus(5,"rebus05", false, code, write, null, lab, "Codice accettato. Puoi procedere");
        office.addRebus(rebus05);
        // Collector 
        super.getItems().add(code);
        super.getCommands().add(write);
        super.getRebus().add(rebus05);

        // Rebus n.1 Corridoio 2 per entrare in Scale
        wallet = new Item(6,new String[]{"portafoglio", "portafogli", "portamonete"}, true);
        rebus06 = new Rebus(6,"rebus06", false, wallet, open, null, stairs, "Ottima mossa. Qualcuno ha smarrito un portafoglio che sembra contenere il badge per aprire la porta. Prova ad usarlo");
        hallway2.addRebus(rebus06);
        // Collector 
        super.getItems().add(wallet);
        super.getRebus().add(rebus06);

        // Rebus n.2 Corridoio 2 per entrare in Scale
        badge = new Item(7,new String[]{"badge", "tessera", "tesserino", "scheda"},true);
        rebus07 = new Rebus(7,"rebus07", false, badge, open, door, stairs, "Molto bene! L'uso del badge ci ha consentito di aprire la porta ed andare avanti. Il badge sembrava clonato ed il nome dell'intestatario, 'Devil', mi dice che siamo sulla posta giusta. Sono sicuro che è il nome del nostro caro hacker.");
        hallway2.addRebus(rebus07);
        // Collector 
        super.getItems().add(badge);
        super.getRebus().add(rebus07);

        // Rebus Stairs per entrare in Storage Room
        rebus08 = new Rebus(8,"rebus08", false, null, open, door, storageroom, "Bene, andiamo avanti!");
        stairs.addRebus(rebus08);
        // Collector 
        super.getRebus().add(rebus08);

        // Rebus Storage Room per entrare in wc
        kick = new Item(9,new String[]{"calcio", "piede"}, true);
        rebus09 = new Rebus(9,"rebus09", false, kick, destroy, door, wc, "Perfetto! Proprio come nei film d'azione!!");
        storageroom.addRebus(rebus09);
        // Collector 
        super.getRebus().add(rebus09);

        // Rebus n.1 WC per entrare in Hall of Fame (victory)
        turnOn = new Command(10,new String[]{"accendi", "solleva", "riarma", "attiva"});
        notebook = new Item(10,new String[]{"pc", "portatile", "computer", "pc", "notebook"}, true);
        rebus10 = new Rebus(10,"rebus10", false, notebook, turnOn, null, victory, "Bene, ci siamo quasi! Il notebook è ora acceso. Ma, per bloccare la diffusione del virus e salvare la centrale nucleare, occorre inserire un codice di sicurezza di 3 cifre. Il suggerimento automatico lascia intendere che ha a che fare con il nome Devil.");
        wc.addRebus(rebus10);
        // Collector 
        super.getItems().add(notebook);
        super.getCommands().add(turnOn);
        super.getRebus().add(rebus10);

        // Rebus n. 2 WC per entrare in Hall of Fame (victory)
        securcode = new Item(11,new String[]{"666"}, true);
        rebus11 = new Rebus(11,"rebus11", false, securcode, write, null, victory, "Codice accettato.\nAVVIO PROCEDURA DI ANNULLAMENTO DIFFUSIONE VIRUS.\nOttimo lavoro, Nick! ");
        wc.addRebus(rebus11);
        // Collector 
        super.getItems().add(securcode);
        super.getRebus().add(rebus11);

        setCurrentRebus(getRebus().get(rebusIndex));

    }

    public Room getStartRoom() {
        return entrance;
}


    public  Room getCurrentRoom() {
        return currentRoom;
    }

    public  void setCurrentRoom(Room r) {
        currentRoom=r;
    }

    public  Rebus getCurrentRebus() {
        return currentRebus;
    }

    public  void setCurrentRebus(Rebus r) {
        currentRebus=r;
    }

    public  void setNextRebus() {
        int index, size;
        index = getRebus().indexOf(currentRebus);
        size = getRebus().size();
        
        if (index < (size-1) && getCurrentRebus().isSolved()) {
        index = index + 1;
        setCurrentRebus(getRebus().get(index));
        }
    }

    public  boolean isCompleted(Rebus rebus) {
        if(rebus.isSolved() && rebus.name.contains("rebus11")) {
            setCurrentRoom(victory);
            completed = true;
        }

        return completed;
    }

    public  void save(String filePath) throws FileNotFoundException, IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeObject(getRooms());
        oos.writeObject(getItems());
        oos.writeObject(getCommands());
        oos.writeObject(getTargets());
        oos.writeObject(getRebus());
        oos.writeObject(getGame());
        oos.writeObject(getCurrentRoom());
        oos.writeObject(getCurrentRebus());
        oos.writeObject(getCrono());

        oos.close();

    }

    public  void load(String filePath) throws ClassNotFoundException, FileNotFoundException, IOException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        setRooms((List<Room>) ois.readObject());
        setItems((List<Item>) ois.readObject());
        setCommands((List<Command>) ois.readObject());
        setTargets((List<Target>) ois.readObject());
        setRebus((List<Rebus>) ois.readObject());
        setGame((Game) ois.readObject());
        setCurrentRoom((Room) ois.readObject());
        setCurrentRebus((Rebus) ois.readObject());
        setCrono((Crono) ois.readObject());
        ois.close();
     
   }

    public  void setHistory(String h) {
        history = h;
    }

    public  String getHistory() {
        return history;
    }

    public  void setPlayerName(String p) {
        playerName = p; 
    }

    public  String getPlayerName() {
        return playerName;
    }

}
