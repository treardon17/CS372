/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam1;
/**
 * Represents a player in the game
 * @author tylerreardon
 */
public class Player {
    private String _userName;
    private String _money;
    
    /**
     * Assigns values to player
     * @param userName
     * @param money 
     */
    public Player(String userName, String money){
        _userName = userName;
        _money = money;
    }
   
    /**
     * Gets the username
     * @return username
     */
    public String getUserName(){
        return _userName;
    }
    
    /**
     * Gets the money that the user has
     * @return money
     */
    public String getMoney(){
        return _money;
    }
    
    /**
     * Sets the username
     * @param userName
     */
    public void setUserName(String userName){
        _userName = userName;
    }
    
    /**
     * Sets the username
     * @param money
     */
    public void setMoney(String money){
        _money = money;
    }
    
    /**
     * Sets the player
     * @param player 
     */
    public void setPlayer(Player player){
        _userName = player.getUserName();
        _money = player.getMoney();
    }
    
    /**
     * Formats the string so to be saved to the file
     * @return 
     */
    public String format(){
        return _userName + " ~" + _money + "\n";
    }
    
}
