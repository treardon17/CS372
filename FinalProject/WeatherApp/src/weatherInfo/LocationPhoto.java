/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherInfo;

/**
 * This represents a picture found on flickr using their API
 * @author tylerreardon
 */
public class LocationPhoto {

    private String photoID;
    private String ownerID;
    private String secret;
    private String server;
    private String farm;
    private String title;
    private String url;

    public LocationPhoto() {}

    public void setPhotoID(String photoID) {
        this.photoID = photoID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }
    
    public void setSecret(String secret){
        this.secret = secret;
    }
    
    public void setServer(String server){
        this.server = server;
    }
    
    public void setFarm(String farm){
        this.farm = farm;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setURL(String url){
        this.url = url;
    }
    
    public String getPhotoID(){
        return photoID;
    }
    
    public String getOwnerID(){
        return ownerID;
    }
    
    public String getSecret(){
        return secret;
    }
    
    public String getServer(){
        return server;
    }
    
    public String getFarm(){
        return farm;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getURL(){
        return url;
    }
}
