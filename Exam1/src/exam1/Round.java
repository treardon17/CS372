/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam1;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Represents a round of the game played by the user
 *
 * @author tylerreardon
 */
public class Round {

    FileIO file = new FileIO();
    ArrayList<Player> players = new ArrayList<>();
    Random random = new Random(); //seed random number
    Player _player;
    String _betMessage;
    double _betAmount;
    int dice1;
    int dice2;
    int diceSum;

    public Round(double betAmount, Player player, String betMessage) throws FileNotFoundException {
        players = file.readPlayers();
        dice1 = random.nextInt(6) + 1; //create first random number
        dice2 = random.nextInt(6) + 1; //create second random number
        diceSum = dice1 + dice2;
        _player = player;
        _betAmount = betAmount;
        _betMessage = betMessage;
    }

    public boolean runRound() {
        double playerMoney = Double.parseDouble(_player.getMoney());

        if (dice1 + dice2 == 7 && _betMessage.equals("Exactly 7")) {
            _betAmount = _betAmount * 4;
            _player.setMoney(Double.toString(playerMoney + _betAmount));
            save();
            return true;
        } else if (dice1 + dice2 != 7 && _betMessage.equals("Exactly 7")) {
            _betAmount = _betAmount * 4;
            _player.setMoney(Double.toString(playerMoney - _betAmount));
            save();
            return false;
        } else if (dice1 + dice2 > 7 && _betMessage.equals("Over 7")) {
            _player.setMoney(Double.toString(playerMoney + _betAmount));
            save();
            return true;
        } else if (dice1 + dice2 <= 7 && _betMessage.equals("Over 7")) {
            _player.setMoney(Double.toString(playerMoney - _betAmount));
            save();
            return false;
        } else if (dice1 + dice2 < 7 && _betMessage.equals("Under 7")) {
            _player.setMoney(Double.toString(playerMoney + _betAmount));
            save();
            return true;
        } else if (dice1 + dice2 >= 7 && _betMessage.equals("Under 7")) {
            _player.setMoney(Double.toString(playerMoney - _betAmount));
            save();
            return false;
        }

        System.out.println("Something went wrong..."); //debugging
        return false;
    }
    
    public int getDiceSum(){
        return diceSum;
    }
    
    private void save(){
        for (int i = 0; i<players.size(); i++){
            if (_player.getUserName().equals(players.get(i).getUserName())){
                players.get(i).setPlayer(_player);
            }
        }
        file.savePlayers(players);
    }

}
