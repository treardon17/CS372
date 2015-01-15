/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Allows for file Input and Output
 * @author tylerreardon
 */
public class FileIO {

    /**
     * Creates an array of Player objects from a file
     * @return an <code>ArrayList</code> of Players
     * @throws FileNotFoundException 
     */
    public ArrayList<Player> readPlayers() throws FileNotFoundException {
        ArrayList<Player> players = new ArrayList<>();
        File f = new File("resources/userInfo.txt");
        String line;
        String[] info;
        try {
            BufferedReader rdr = new BufferedReader(new FileReader(f));

            while ((line = rdr.readLine()) != null) { //read to the end of the file
                info = line.split(" ~"); //split items based on " $"
                Player p1 = new Player(info[0], info[1]); //constructs player
                players.add(p1); //adds player to ArrayList
            }
            rdr.close();
        } catch (Exception ex) {
            System.out.println("Error!");
        }
        return players; //return the ArrayList
    }

    /**
     * Saves the players to a file
     * @param players 
     */
    public void savePlayers(ArrayList<Player> players) {
        File file = new File("resources/userInfo.txt");
        try {
            BufferedWriter wrtr = new BufferedWriter(new FileWriter(file));
            String line;

            //Writes all players to the file line by line
            for (int i = 0; i < players.size(); i++) {
                line = players.get(i).format();
                wrtr.write(line);
            }
            wrtr.close();
        } catch (Exception ex) {
            System.out.println("Invalid File!");
        }

    }

}

