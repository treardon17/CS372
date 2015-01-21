/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.ParseException;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents the window that displays weather information
 *
 * @author tylerreardon
 */
public class WeatherAppUI extends JFrame {
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private static City preferredCity;
    private static final FileIO file = new FileIO();
    private Map<String, ArrayList<Hour>> weatherInfo = new HashMap<>();
    private final ChooseCityUI chooseCity;
    private Gradient gradient;
    private BufferedImage weatherImage;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Date todayDate = new Date();

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
        gradient = new Gradient(weatherImage, this);
        gradient.setSize(dim);
        this.add(gradient,-1);
        //this.baseLayer.add(weatherImage, -1, 6);
        
    }

    public void updateWeatherUI() throws IOException, MalformedURLException, SAXException, ParserConfigurationException {

        preferredCity = file.getPreferredCity();
        cityLabel.setText(preferredCity.getCityName() + ", " + preferredCity.getState());
        weatherInfo = preferredCity.parseForWeather();
        ImageIcon icon;
        Calendar calendar = Calendar.getInstance();

        ArrayList<String> sortedDates = new ArrayList<>();
        ArrayList<String> daysOfWeek = new ArrayList<>();

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

        try {
            for (int i = 0; i < sortedDates.size(); i++) {
                Date dt1 = dateFormat.parse(sortedDates.get(i));
                calendar.setTime(dt1);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek == 1) {daysOfWeek.add("Sunday:");
                } else if (dayOfWeek == 2) {daysOfWeek.add("Monday:");
                } else if (dayOfWeek == 3) {daysOfWeek.add("Tuesday:");
                } else if (dayOfWeek == 4) {daysOfWeek.add("Wednesday:");
                } else if (dayOfWeek == 5) {daysOfWeek.add("Thursday:");
                } else if (dayOfWeek == 6) {daysOfWeek.add("Friday:");
                } else if (dayOfWeek == 7) {daysOfWeek.add("Saturday:");}
            }
        } catch (ParseException ex) {
            Logger.getLogger(WeatherAppUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //TODAY'S INFORMATION
            currentTemp.setText(weatherInfo.get(sortedDates.get(0)).get(0).getTemp() + "°F");
            dayMaxTemp.setText("Max: " + weatherInfo.get(sortedDates.get(0)).get(0).getDayMaxTemp() + "°F");
            dayMinTemp.setText("Min: " + weatherInfo.get(sortedDates.get(0)).get(0).getDayMinTemp() + "°F");
            currentWeather.setText(weatherInfo.get(sortedDates.get(0)).get(0).getWeatherDescr());

            //TOMORROW'S INFORMATION
            nextWeather1.setText(weatherInfo.get(sortedDates.get(1)).get(0).getWeatherDescr());
            temp1.setText(weatherInfo.get(sortedDates.get(1)).get(0).getTemp() + "°F");
            //day1.setText(daysOfWeek.get(0));

            //NEXT DAY'S INFORMATION
            nextWeather2.setText(weatherInfo.get(sortedDates.get(2)).get(0).getWeatherDescr());
            temp2.setText(weatherInfo.get(sortedDates.get(2)).get(0).getTemp() + "°F");
            day2.setText(daysOfWeek.get(1));

            //NEXT DAY'S INFORMATION
            nextWeather3.setText(weatherInfo.get(sortedDates.get(3)).get(0).getWeatherDescr());
            temp3.setText(weatherInfo.get(sortedDates.get(3)).get(0).getTemp() + "°F");
            day3.setText(daysOfWeek.get(2));

            //NEXT DAY'S INFORMATION
            nextWeather4.setText(weatherInfo.get(sortedDates.get(4)).get(0).getWeatherDescr());
            temp4.setText(weatherInfo.get(sortedDates.get(4)).get(0).getTemp() + "°F");
            day4.setText(daysOfWeek.get(3));

            //NEXT DAY'S INFORMATION
            if (sortedDates.size() == 6) {
                nextWeather5.setText(weatherInfo.get(sortedDates.get(5)).get(0).getWeatherDescr());
                temp5.setText(weatherInfo.get(sortedDates.get(5)).get(0).getTemp() + "°F");
                day5.setText(daysOfWeek.get(4));
            } else {
                nextWeather5.setText("");
                temp5.setText("");
                day5.setText("");
            }

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Invalid weather information!\n");
            System.out.printf("%s\n", ex.getMessage());
        }

        try {
            weatherImage = file.getBackgroundImage(weatherInfo.get(sortedDates.get(0)).get(0).getWeatherDescr());
            //Set background image with relavent picture
            //icon = file.getBackgroundImage(weatherInfo.get(sortedDates.get(0)).get(0).getWeatherDescr());
            //weatherImage.setIcon(icon);
            //weatherImage.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

        } catch (Exception ex) {
            System.out.printf("%s\n", ex.getMessage());
            System.out.println("Invalid image\n");
            weatherImage = file.getBackgroundImage(null);
            //icon = file.getBackgroundImage(null);
            //weatherImage.setIcon(icon);
            //weatherImage.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
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
        jLabel1 = new javax.swing.JLabel();
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

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel1.setText("Weather information provided by openweathermap.org");

        javax.swing.GroupLayout baseLayerLayout = new javax.swing.GroupLayout(baseLayer);
        baseLayer.setLayout(baseLayerLayout);
        baseLayerLayout.setHorizontalGroup(
            baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baseLayerLayout.createSequentialGroup()
                        .addComponent(dayMaxTemp)
                        .addGap(35, 35, 35)
                        .addComponent(dayMinTemp)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(baseLayerLayout.createSequentialGroup()
                        .addComponent(currentWeather)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(baseLayerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(currentTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baseLayerLayout.createSequentialGroup()
                        .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, baseLayerLayout.createSequentialGroup()
                                    .addComponent(day4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nextWeather4))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, baseLayerLayout.createSequentialGroup()
                                    .addComponent(day3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(nextWeather3)))
                            .addGroup(baseLayerLayout.createSequentialGroup()
                                .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(day1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(day2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nextWeather2)
                                    .addComponent(nextWeather1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(temp4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(temp3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(temp2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(temp1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(baseLayerLayout.createSequentialGroup()
                        .addComponent(day5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(nextWeather5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(temp5)))
                .addGap(31, 31, 31))
            .addGroup(baseLayerLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(cityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        baseLayerLayout.setVerticalGroup(
            baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayerLayout.createSequentialGroup()
                .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baseLayerLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentTemp)
                    .addGroup(baseLayerLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(temp1)
                            .addComponent(nextWeather1)
                            .addComponent(day1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(day2)
                            .addComponent(nextWeather2)
                            .addComponent(temp2))))
                .addGap(7, 7, 7)
                .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baseLayerLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dayMaxTemp)
                            .addComponent(dayMinTemp)))
                    .addGroup(baseLayerLayout.createSequentialGroup()
                        .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(day3)
                            .addComponent(nextWeather3)
                            .addComponent(temp3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nextWeather4)
                            .addComponent(day4)
                            .addComponent(temp4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(baseLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(temp5)
                    .addComponent(nextWeather5)
                    .addComponent(day5))
                .addGap(7, 7, 7)
                .addComponent(currentWeather)
                .addContainerGap(165, Short.MAX_VALUE))
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
        baseLayer.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
    private javax.swing.JLabel jLabel1;
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
