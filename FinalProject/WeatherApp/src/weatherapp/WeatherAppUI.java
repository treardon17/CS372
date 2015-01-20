/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import weatherInfo.Hour;
import java.util.Calendar;

/**
 * Represents the window that displays weather information
 *
 * @author tylerreardon
 */
public class WeatherAppUI extends JFrame {

    private static City preferredCity;
    private static final FileIO file = new FileIO();
    private Map<String, ArrayList<Hour>> weatherInfo = new HashMap<>();
    private final ChooseCityUI chooseCity;
    private JLabel weatherImage = new JLabel();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date todayDate = new Date();
    String todayDateString;

    /**
     * Creates new form WeatherAppUI
     *
     * @throws java.io.IOException
     * @throws java.net.MalformedURLException
     * @throws org.xml.sax.SAXException
     */
    public WeatherAppUI() throws IOException, MalformedURLException, SAXException, ParserConfigurationException {
        this.chooseCity = new ChooseCityUI(this);
        initComponents();
        updateWeatherUI();
        this.baseLayer.add(weatherImage, -1, 6);
    }

    public void updateWeatherUI() throws IOException, MalformedURLException, SAXException, ParserConfigurationException {

        preferredCity = file.getPreferredCity();
        cityLabel.setText(preferredCity.getCityName());
        weatherInfo = preferredCity.parseForWeather();
        ImageIcon icon;
        todayDateString = dateFormat.format(todayDate);
        Calendar calendar = Calendar.getInstance();

        ArrayList<String> sortedDates = new ArrayList<>();
        ArrayList<String> daysOfWeek = new ArrayList<>();

        try {
            if (!weatherInfo.isEmpty()) {
                Iterator it = weatherInfo.keySet().iterator(); //make iterator for map
                //String lowestDate = it.next().toString();
                //String temp;
                //lowestDate = lowestDate.substring(8, Math.min(lowestDate.length(), 10));
                while (it.hasNext()) {
                    String aDate = it.next().toString();
                    //aDate = aDate.substring(8, Math.min(aDate.length(), 10));
                    sortedDates.add(aDate);
                }
                Collections.sort(sortedDates);
            }
            
            for (int i = 0; i<sortedDates.size(); i++){
                Date dt1=dateFormat.parse(sortedDates.get(i));
                calendar.setTime(dt1);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek == 1){daysOfWeek.add("Sunday");}
                else if (dayOfWeek == 2){daysOfWeek.add("Monday");}
                else if (dayOfWeek == 3){daysOfWeek.add("Tuesday");}
                //NEED TO FINISH!!!
            }
            

            //TODAY'S INFORMATION
            currentTemp.setText(weatherInfo.get(sortedDates.get(0)).get(0).getTemp() + "°F");
            dayMaxTemp.setText("Max: " + weatherInfo.get(sortedDates.get(0)).get(0).getDayMaxTemp() + "°F");
            dayMinTemp.setText("Min: " + weatherInfo.get(sortedDates.get(0)).get(0).getDayMinTemp() + "°F");
            currentWeather.setText(weatherInfo.get(sortedDates.get(0)).get(0).getWeatherDescr());
            
            //TOMORROW'S INFORMATION
            nextWeather1.setText(weatherInfo.get(sortedDates.get(1)).get(0).getWeatherDescr());
            temp1.setText(weatherInfo.get(sortedDates.get(1)).get(0).getTemp() + "°F");
            
            //NEXT DAY'S INFORMATION
            nextWeather2.setText(weatherInfo.get(sortedDates.get(2)).get(0).getWeatherDescr());
            temp2.setText(weatherInfo.get(sortedDates.get(2)).get(0).getTemp() + "°F");
            
            //NEXT DAY'S INFORMATION
            nextWeather3.setText(weatherInfo.get(sortedDates.get(3)).get(0).getWeatherDescr());
            temp3.setText(weatherInfo.get(sortedDates.get(3)).get(0).getTemp() + "°F");        
            
            //NEXT DAY'S INFORMATION
            nextWeather4.setText(weatherInfo.get(sortedDates.get(4)).get(0).getWeatherDescr());
            temp4.setText(weatherInfo.get(sortedDates.get(4)).get(0).getTemp() + "°F");
            
            //NEXT DAY'S INFORMATION
            nextWeather5.setText(weatherInfo.get(sortedDates.get(5)).get(0).getWeatherDescr());
            temp5.setText(weatherInfo.get(sortedDates.get(5)).get(0).getTemp() + "°F");
            
            //Set background image with relavent picture
            icon = file.getBackgroundImage(weatherInfo.get(sortedDates.get(0)).get(0).getWeatherDescr());
            weatherImage.setIcon(icon);
            weatherImage.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

        } catch (Exception ex) {
            System.out.println("Invalid weather information\n");
            icon = file.getBackgroundImage(null);
            weatherImage.setIcon(icon);
            weatherImage.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
            currentWeather.setText("Weather information not available");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        baseLayer = new javax.swing.JLayeredPane();
        currentTemp = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        day1 = new javax.swing.JLabel();
        day2 = new javax.swing.JLabel();
        day3 = new javax.swing.JLabel();
        day4 = new javax.swing.JLabel();
        day5 = new javax.swing.JLabel();
        dayMaxTemp = new javax.swing.JLabel();
        dayMinTemp = new javax.swing.JLabel();
        currentWeather = new javax.swing.JLabel();
        nextWeather1 = new javax.swing.JLabel();
        nextWeather2 = new javax.swing.JLabel();
        nextWeather3 = new javax.swing.JLabel();
        nextWeather4 = new javax.swing.JLabel();
        nextWeather5 = new javax.swing.JLabel();
        temp1 = new javax.swing.JLabel();
        temp2 = new javax.swing.JLabel();
        temp3 = new javax.swing.JLabel();
        temp4 = new javax.swing.JLabel();
        temp5 = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        Preferences = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 900, 600));
        setPreferredSize(new java.awt.Dimension(900, 411));

        baseLayer.setPreferredSize(new java.awt.Dimension(900, 500));

        currentTemp.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        currentTemp.setText("?");

        cityLabel.setFont(new java.awt.Font("Heiti TC", 1, 24)); // NOI18N
        cityLabel.setText("City:");

        day1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        day1.setText("Tomorrow:");

        day2.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        day2.setText("Next day:");

        day3.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        day3.setText("Next day:");

        day4.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        day4.setText("Next day:");

        day5.setText("Next day:");

        dayMaxTemp.setText("Max:");

        dayMinTemp.setText("Min:");

        currentWeather.setText("Currently:");

        nextWeather1.setText("weather data");

        nextWeather2.setText("weather data");

        nextWeather3.setText("weather data");

        nextWeather4.setText("weather data");

        nextWeather5.setText("weather data");

        temp1.setText("temp");

        temp2.setText("temp");

        temp3.setText("temp");

        temp4.setText("temp");

        temp5.setText("temp");

        javax.swing.GroupLayout baseLayerLayout = new javax.swing.GroupLayout(baseLayer);
        baseLayer.setLayout(baseLayerLayout);
        baseLayerLayout.setHorizontalGroup(
            baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayerLayout.createSequentialGroup()
                .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(baseLayerLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(baseLayerLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(baseLayerLayout.createSequentialGroup()
                                .addComponent(dayMaxTemp)
                                .addGap(35, 35, 35)
                                .addComponent(dayMinTemp))
                            .addComponent(currentWeather)
                            .addComponent(currentTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(day1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(day2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(day3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(day4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(day5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nextWeather5)
                            .addComponent(nextWeather1)
                            .addComponent(nextWeather2)
                            .addComponent(nextWeather3)
                            .addComponent(nextWeather4))
                        .addGap(51, 51, 51)
                        .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(temp4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(temp5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(temp1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(temp2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(temp3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(24, 24, 24)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        baseLayerLayout.setVerticalGroup(
            baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayerLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(cityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baseLayerLayout.createSequentialGroup()
                        .addComponent(currentTemp)
                        .addGap(38, 38, 38)
                        .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dayMaxTemp)
                            .addComponent(dayMinTemp))
                        .addGap(33, 33, 33)
                        .addComponent(currentWeather))
                    .addGroup(baseLayerLayout.createSequentialGroup()
                        .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(day1)
                            .addComponent(nextWeather1)
                            .addComponent(temp1))
                        .addGap(18, 18, 18)
                        .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(day2)
                            .addComponent(nextWeather2)
                            .addComponent(temp2))
                        .addGap(18, 18, 18)
                        .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(day3)
                            .addComponent(nextWeather3)
                            .addComponent(temp3))
                        .addGap(18, 18, 18)
                        .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(day4)
                            .addComponent(nextWeather4)
                            .addComponent(temp4))
                        .addGap(18, 18, 18)
                        .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(day5)
                            .addComponent(nextWeather5)
                            .addComponent(temp5))))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        baseLayer.setLayer(currentTemp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        baseLayer.setLayer(cityLabel, javax.swing.JLayeredPane.PALETTE_LAYER);
        baseLayer.setLayer(day1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        baseLayer.setLayer(day2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        baseLayer.setLayer(day3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        baseLayer.setLayer(day4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        baseLayer.setLayer(day5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        baseLayer.setLayer(dayMaxTemp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        baseLayer.setLayer(dayMinTemp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        baseLayer.setLayer(currentWeather, javax.swing.JLayeredPane.DEFAULT_LAYER);
        baseLayer.setLayer(nextWeather1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        baseLayer.setLayer(nextWeather2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        baseLayer.setLayer(nextWeather3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        baseLayer.setLayer(nextWeather4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        baseLayer.setLayer(nextWeather5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        baseLayer.setLayer(temp1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        baseLayer.setLayer(temp2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        baseLayer.setLayer(temp3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        baseLayer.setLayer(temp4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        baseLayer.setLayer(temp5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        File.setText("File");

        Preferences.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        Preferences.setText("Preferences");
        Preferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreferencesActionPerformed(evt);
            }
        });
        File.add(Preferences);

        MenuBar.add(File);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(baseLayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(baseLayer, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Opens window, allowing user to specify which location to display
     *
     * @param evt
     */
    private void PreferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreferencesActionPerformed
        chooseCity.runChooseCity();
    }//GEN-LAST:event_PreferencesActionPerformed

    /**
     * Runs the application, beginning with the WeatherAppUI
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WeatherAppUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WeatherAppUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WeatherAppUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WeatherAppUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WeatherAppUI weatherAppUI;
                JLabel weatherImage = new JLabel();
                try {
                    weatherAppUI = new WeatherAppUI();

                    weatherAppUI.setSize(900, 645);
                    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                    weatherAppUI.setLocation(dim.width / 2 - weatherAppUI.getSize().width / 2,
                            dim.height / 2 - weatherAppUI.getSize().height / 2);

                    weatherAppUI.setVisible(true);
                } catch (IOException | SAXException | ParserConfigurationException | HeadlessException e) {
                    System.out.printf("%s", e.getMessage());
                }
            }

        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu File;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem Preferences;
    private javax.swing.JLayeredPane baseLayer;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JLabel currentTemp;
    private javax.swing.JLabel currentWeather;
    private javax.swing.JLabel day1;
    private javax.swing.JLabel day2;
    private javax.swing.JLabel day3;
    private javax.swing.JLabel day4;
    private javax.swing.JLabel day5;
    private javax.swing.JLabel dayMaxTemp;
    private javax.swing.JLabel dayMinTemp;
    private javax.swing.JLabel nextWeather1;
    private javax.swing.JLabel nextWeather2;
    private javax.swing.JLabel nextWeather3;
    private javax.swing.JLabel nextWeather4;
    private javax.swing.JLabel nextWeather5;
    private javax.swing.JLabel temp1;
    private javax.swing.JLabel temp2;
    private javax.swing.JLabel temp3;
    private javax.swing.JLabel temp4;
    private javax.swing.JLabel temp5;
    // End of variables declaration//GEN-END:variables
}
