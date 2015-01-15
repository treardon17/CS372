/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam1;
/**
 *
 * @author tylerreardon
 */
public class Player {
    private String _userName;
    private String _money;
    
    public Player(String userName, String money){
        _userName = userName;
        _money = money;
    }
   
    public String getUserName(){
        return _userName;
    }
    
    public String getMoney(){
        return _money;
    }
    
    public void setUserName(String userName){
        _userName = userName;
    }
    
    public void setMoney(String money){
        _money = money;
    }
    
    public void setPlayer(Player player){
        _userName = player.getUserName();
        _money = player.getMoney();
    }
    
    public String format(){
        return _userName + " ~" + _money + "\n";
    }
    
}
