/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherInfo;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * This finds the URL's of the pictures on flickr
 * @author tylerreardon
 */
public class CurrentPhotoHandler extends DefaultHandler {
    ArrayList<LocationPhoto> locationPhotos = new ArrayList<>();
    
    String data;
        /**
     * Resets the data when new element is found
     * @param uri
     * @param localName
     * @param qName
     * @param attributes 
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("photo")){
            LocationPhoto photo = new LocationPhoto();
            /*
            photo.setPhotoID(attributes.getValue("id"));
            photo.setOwnerID(attributes.getValue("owner"));
            photo.setSecret(attributes.getValue("secret"));
            photo.setServer(attributes.getValue("server"));
            photo.setFarm(attributes.getValue("farm"));
            photo.setTitle(attributes.getValue("title"));
            */
            photo.setURL(attributes.getValue("url_k"));
            locationPhotos.add(photo);
        }
        
        
        data = "";
    }

    /**
     * Gathers the data
     * @param ch
     * @param start
     * @param length 
     */
    @Override
    public void characters(char[] ch, int start, int length) {
        data = data + new String(ch, start, length);
    }

    /**
     * Stores the data
     * @param uri
     * @param localName
     * @param qName 
     */
    @Override
    public void endElement(String uri, String localName, String qName) {
        
    }
    
    public ArrayList<LocationPhoto> getPhotos(){
        return locationPhotos;
    }
    
}
