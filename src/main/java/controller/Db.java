/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author mtridici
 */
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Db {

    private static String dbURL;
    private static String tableName;
    // jdbc Connection
    private static Connection conn;
    private static Statement stmt;
    private static String ranking;
    private static String user;
    private static String pass;
    private static final String createTable = "CREATE TABLE IF NOT EXISTS SCORES (name VARCHAR(10), score INT)";


    public Db() {
    
    //dbURL = "jdbc:h2:/Users/mtridici/NetBeansProjects/hacker/db/hacker";
    //dbURL = "jdbc:h2:~/hackerDB"; 
    dbURL = "jdbc:h2:./hackerDB"; 
    //salva il DB nella cwd per evitare problemi con i vari sistemi operativi e per accedere in RW al DB direttamente dal JAR

    user = "map2022";
    pass = "hacker";   
    tableName = "SCORES"; 
    // jdbc Connection
    conn = null;
    stmt = null;
    ranking = new String();
    
    }

    public static void createConnection() 
    {
        try
        {
            //Get a connection
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection(dbURL, user, pass); 

        }
        //catch (SQLException sqlExcept)
        catch (SQLException | ClassNotFoundException sqlExcept)
        {
            sqlExcept.printStackTrace();
            StringWriter errors = new StringWriter();
            sqlExcept.printStackTrace(new PrintWriter(errors));


            JOptionPane.showMessageDialog(null, "Non connesso al DB\n" + dbURL + errors.toString());
        }
    }
    
    public static void insertScore(String nome, long score)
    {
        try
        {
            stmt = conn.createStatement();
            //stmt.executeUpdate(createDb);
            stmt.executeUpdate(createTable);
            stmt.execute("insert into " + tableName + " values ('" + nome + "','" + score + "')");
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
            JOptionPane.showMessageDialog(null, "Impossibile inserire i nuovi record nel DB");
        }
    }
    
    
    public static void dropall()
    {
        try
        {
            stmt = conn.createStatement();
            stmt.execute("truncate table " + tableName);
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }

    public static void showScore()
    {
        try
        {
            stmt = conn.createStatement();
            stmt.executeUpdate(createTable);
            ResultSet results = stmt.executeQuery("select top 5 * from " + tableName + " order by score");
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();

            if(!results.isBeforeFirst() && results.getRow() == 0) {
                ranking = "Nessun record inserito nel ranking.";
            }
            else {
                while(results.next())
                {
                    String name = results.getString(1);
                    long score = results.getInt(2);

                    ranking += name + " \t\t\t\t " + score + "\n";    
                }
            }
            results.close();
            stmt.close();

            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, ranking, "Top 5 Players", JOptionPane.INFORMATION_MESSAGE);
            ranking = "";
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
            JOptionPane.showMessageDialog(null,"Impossibile visualizzare la classifica dei TOP5");
        }
    }
    
    public static void shutdown() 
    {
        try
        {
            if (stmt != null)
            {
                stmt.close();
            }
            if (conn != null)
            {
                conn=DriverManager.getConnection(dbURL, user, pass);
                conn.close();
            }           
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Si è verificato un errore in fase di chiusura del DB.");
            sqlExcept.printStackTrace();
        }

    }
}
