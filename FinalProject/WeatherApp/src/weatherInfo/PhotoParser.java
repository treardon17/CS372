/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherInfo;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import java.lang.Exception;

/**
 *
 * @author tylerreardon
 */
public class PhotoParser {

    private CurrentPhotoHandler cPhandler = new CurrentPhotoHandler();
    private ArrayList<LocationPhoto> locationPhotos = new ArrayList<>();
    private BufferedImage image;

    public PhotoParser(String cityName, String stateName) throws Exception {

        String photoInfoString;
        Random rand = new Random();
        int index;
        boolean error;
        String secret;
        String photoID;
        String photoURLString;
        String farm;
        String server;

        photoInfoString = "https://api.flickr.com/services/rest/?&method=flickr.photos."
                + "getRecent&search=" + cityName + ",%20" + stateName + "%20outdoors&extras=url_k&accuracy=11&api_key=e98dfbc5069"
                + "e5a46a12f8574d653778d";

        index = 0;//rand.nextInt(locationPhotos.size() - 2) + 1;

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser;
        try {
            parser = factory.newSAXParser();
            URL photoInfoURL = new URL(photoInfoString);

            parser.parse(photoInfoURL.openStream(), cPhandler);
            locationPhotos = cPhandler.getPhotos();

            do {
                error = false;
            //secret = locationPhotos.get(index).getSecret();
                //photoID = locationPhotos.get(index).getPhotoID();
                //farm = locationPhotos.get(index).getFarm();
                //server = locationPhotos.get(index).getServer();

                //photoURLString = "https://farm"+farm+".staticflickr.com/"+server+"/"+photoID+"_"+secret+"_"+"k.(jpg|gif|png)";
                //URL photoURL = new URL(photoURLString);
                try {
                    photoURLString = locationPhotos.get(index).getURL();
                    URL photoURL = new URL(photoURLString);
                    image = ImageIO.read(photoURL);
                } catch (Exception e) {
                    index++;
                    error = true;
                }

            } while (error && index<100);
            
            if (index>98){
                Exception e = new Exception();
                throw e;
            }

        } catch (ParserConfigurationException | SAXException ex) {
            Logger.getLogger(LocationParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.printf("%s\n", ex.getMessage());
        }
    }

    public BufferedImage getImage() {
        return image;
    }

}
