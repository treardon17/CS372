/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cookiesales;

/**
 * This class tracks the total sales of girl scout cookies 
 * @author tylerreardon
 */
public class CookieSales {
    double thinMintSales;
    int numThinMints;
    double samoaSales;
    int numSamoas;
    double chocolateChipSales;
    int numChocolateChip;
    
    /**
     * Constructor sets all sales to initial value of zero
     */
    public CookieSales(){
        thinMintSales = 0;
        numThinMints = 0;
        samoaSales = 0;
        numSamoas = 0;
        chocolateChipSales = 0;
        numChocolateChip = 0;
    }
    /**
     * This function calculates total sales of Thin Mints
     * @param numSold 
     */
    public void addThinMints(int numSold){
        thinMintSales += numSold*3; //price of thin mints are $3
        numThinMints += numSold; //set number of thin mints sold
    }
    /**
     * This function calculates total sales of Samoas
     * @param numSold 
     */
    public void addSamoas(int numSold){
        samoaSales += numSold*4; //price of samoas are $4
        numSamoas += numSold; //set number of samoas sold
    }
    /**
     * This function calculates total sales of Chocolate Chip
     * @param numSold 
     */
    public void addChocolateChip(int numSold){
        chocolateChipSales += numSold*5; //price of chocolate chip cookies are $5
        numChocolateChip += numSold; //set number of chocolate chip sold
    }
    /**
     * 
     * @return <code>thinMintSales</code> which represents the total sales (cash) of thin mints
     */
     public double getThinMintSales(){
        return thinMintSales;
    }
     /**
     * 
     * @return <code>numThinMints</code> which represents the total number of thin mints sold
     */
     public int getNumThinMints(){
         return numThinMints;
     }
     /**
     * 
     * @return <code>samoaSales</code> which represents the total sales (cash) of samoas sold
     */
     public double getSamoaSales(){
         return samoaSales;
     }
      /**
     * 
     * @return <code>numSamoas</code> which represents the total number of samoas sold
     */
     public int getNumSamoas(){
         return numSamoas;
     }
     /**
     * 
     * @return <code>chocolateChipSales</code> which represents the total sales (cash) of chocolate chip sold
     */
     public double getChocolateChipSales(){
         return chocolateChipSales;
     }
     /**
     * 
     * @return <code>numChocolateChip</code> which represents the total number of chocolate chip sold
     */
     public int getNumChocolateChip(){
         return numChocolateChip;
     }
     /**
     * 
     * @return Total Sales which represents the total sales (cash) of all cookies sold
     */
     public double getTotalSales(){
         return (thinMintSales + samoaSales + chocolateChipSales);
     }
     /**
     * 
     * @return Total Number of cookies sold
     */
     public int getTotalNum(){
         return (numThinMints + numSamoas + numChocolateChip);
     }
}
