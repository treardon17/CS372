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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import javax.swing.Timer;
import weatherInfo.LocationParser;

/**
 * Represents the window that displays weather information
 *
 * @author tylerreardon
 */
public class WeatherAppUI extends JFrame {

    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private static City preferredCity;
    private City currentLocation;
    private static final FileIO file = new FileIO();
    private Map<String, ArrayList<Hour>> weatherInfo = new HashMap<>();
    private final ChooseCityUI chooseCity;
    private Background background = new Background();
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

        //Refresh weather information every hour
        Timer tm = new Timer(3600000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateWeatherUI();
                } catch (IOException | SAXException | ParserConfigurationException ex) {
                    Logger.getLogger(WeatherAppUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        updateWeatherUI();
        background.setSize(dim);
        this.add(background, -1);
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
            //Set background image with relavent picture
            weatherImage = file.getBackgroundImage(weatherInfo.get(sortedDates.get(0)).get(0).getWeatherDescr());
            background.setBackground(weatherImage, this);
        } catch (Exception ex) {
            System.out.printf("%s\n", ex.getMessage());
            System.out.println("Invalid image\n");
            weatherImage = file.getBackgroundImage(null);
            background.setBackground(weatherImage, this);
        }

        try {
            for (int i = 0; i < sortedDates.size(); i++) {
                Date dt1 = dateFormat.parse(sortedDates.get(i));
                calendar.setTime(dt1);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek == 1) {
                    daysOfWeek.add("Sunday:");
                } else if (dayOfWeek == 2) {
                    daysOfWeek.add("Monday:");
                } else if (dayOfWeek == 3) {
                    daysOfWeek.add("Tuesday:");
                } else if (dayOfWeek == 4) {
                    daysOfWeek.add("Wednesday:");
                } else if (dayOfWeek == 5) {
                    daysOfWeek.add("Thursday:");
                } else if (dayOfWeek == 6) {
                    daysOfWeek.add("Friday:");
                } else if (dayOfWeek == 7) {
                    daysOfWeek.add("Saturday:");
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(WeatherAppUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //TODAY'S INFORMATION
            currentTemp.setText(weatherInfo.get(sortedDates.get(0)).get(0).getTemp() + "°F");
            dayMaxTemp.setText("Max: " + weatherInfo.get(sortedDates.get(0)).get(0).getDayMaxTemp() + "°F");
            dayMinTemp.setText("Min: " + weatherInfo.get(sortedDates.get(0)).get(0).getDayMinTemp() + "°F");
            humidity.setText("Humidity: " + weatherInfo.get(sortedDates.get(0)).get(0).getHumidity());
            currentWeather.setText("Current conditions: " + weatherInfo.get(sortedDates.get(0)).get(0).getWeatherDescr());

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

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cityLabel = new javax.swing.JLabel();
        currentTemp = new javax.swing.JLabel();
        dayMaxTemp = new javax.swing.JLabel();
        dayMinTemp = new javax.swing.JLabel();
        currentWeather = new javax.swing.JLabel();
        humidity = new javax.swing.JLabel();
        openweathermap = new javax.swing.JLabel();
        day1 = new javax.swing.JLabel();
        day2 = new javax.swing.JLabel();
        day3 = new javax.swing.JLabel();
        day4 = new javax.swing.JLabel();
        day5 = new javax.swing.JLabel();
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
        CurrentLocation = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 900, 600));
        setPreferredSize(new java.awt.Dimension(900, 411));

        cityLabel.setFont(new java.awt.Font("Heiti TC", 1, 24)); // NOI18N
        cityLabel.setText("City:");

        currentTemp.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        currentTemp.setText("?");

        dayMaxTemp.setText("Max:");

        dayMinTemp.setText("Min:");

        currentWeather.setText("Currently:");

        humidity.setText("Humidity:");

        openweathermap.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        openweathermap.setText("Weather information provided by openweathermap.org");

        day1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        day1.setText("Tomorrow:");
        day1.setMaximumSize(new java.awt.Dimension(57, 17));
        day1.setMinimumSize(new java.awt.Dimension(57, 17));
        day1.setPreferredSize(new java.awt.Dimension(57, 17));

        day2.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        day2.setText("Next day:");

        day3.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        day3.setText("Next day:");

        day4.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        day4.setText("Next day:");

        day5.setText("Next day:");
        day5.setMaximumSize(new java.awt.Dimension(57, 17));
        day5.setMinimumSize(new java.awt.Dimension(57, 17));
        day5.setPreferredSize(new java.awt.Dimension(57, 17));

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

        File.setText("File");

        Preferences.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        Preferences.setText("Preferences");
        Preferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreferencesActionPerformed(evt);
            }
        });
        File.add(Preferences);

        CurrentLocation.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        CurrentLocation.setText("Use Current Location");
        CurrentLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CurrentLocationActionPerformed(evt);
            }
        });
        File.add(CurrentLocation);

        MenuBar.add(File);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(day1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nextWeather1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(day2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nextWeather2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(currentTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(day3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nextWeather3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(day4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nextWeather4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dayMaxTemp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(day5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nextWeather5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(temp1)
                            .addComponent(temp2)
                            .addComponent(temp3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(temp4, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(temp5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(openweathermap))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentWeather)
                    .addComponent(humidity)
                    .addComponent(dayMinTemp))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(currentTemp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dayMaxTemp))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(temp1)
                            .addComponent(nextWeather1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(day1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(temp2)
                            .addComponent(nextWeather2)
                            .addComponent(day2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(temp3)
                            .addComponent(nextWeather3)
                            .addComponent(day3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(temp4)
                            .addComponent(nextWeather4)
                            .addComponent(day4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(temp5)
                            .addComponent(nextWeather5)
                            .addComponent(day5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dayMinTemp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(humidity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(currentWeather)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(openweathermap)
                .addContainerGap())
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
     * Allows user to get weather information from their current location
     *
     * @param evt
     */
    private void CurrentLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CurrentLocationActionPerformed
        boolean error = false;
        LocationParser parse = null;
        try {
            parse = new LocationParser();
            this.updateWeatherUI();
            currentLocation = parse.getCity();
        } catch (MalformedURLException ex) {
            error = true;
            Logger.getLogger(WeatherAppUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            error = true;
            Logger.getLogger(WeatherAppUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (!error) {
                Dialogue dialogue = new Dialogue(currentLocation);
                dialogue.runDialogue();
            }
        } catch (Exception ex) {
            System.out.printf("%s\n", ex.getMessage());
        }

    }//GEN-LAST:event_CurrentLocationActionPerformed

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

                    weatherAppUI.setSize(900, 600);
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
    private javax.swing.JMenuItem CurrentLocation;
    private javax.swing.JMenu File;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem Preferences;
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
    private javax.swing.JLabel humidity;
    private javax.swing.JLabel nextWeather1;
    private javax.swing.JLabel nextWeather2;
    private javax.swing.JLabel nextWeather3;
    private javax.swing.JLabel nextWeather4;
    private javax.swing.JLabel nextWeather5;
    private javax.swing.JLabel openweathermap;
    private javax.swing.JLabel temp1;
    private javax.swing.JLabel temp2;
    private javax.swing.JLabel temp3;
    private javax.swing.JLabel temp4;
    private javax.swing.JLabel temp5;
    // End of variables declaration//GEN-END:variables
}
