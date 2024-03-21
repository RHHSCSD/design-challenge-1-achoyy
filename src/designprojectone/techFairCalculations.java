/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package designprojectone;
import java.util.*;
import java.text.*; 
/***************************************************
*
*  Program:TechFairCost
*  Author: Abigail Choy 
*  Date: 03/19
*  Description: calculates cost of tech fair 
****************************************************/

/**************** IPO CHART ************************
*INPUT:
* number of basic people (int) 
* number of arduino people (int) 
* number of raspberry people (int) 
* number of vr people (int) 
*
*PROCESSING:
* add up all people for total people (int) 
* add up the basic cost for everyone (total students * 50) (int) 
* if number of arduino people is over 15, then multiply the arduino people (-15) by 9 and add to the total cost
*    then, make the arduino people = 15 (int)
* then, multiply the arduino people by 10 and add to total cost 
* if number of raspberries people is over 20, then multiply the raspberry people (-20) by 12 and add to the total cost
*    then, make the raspberry people = 20 
* then, multiply the raspberry people by 15 and add to total cost
* multiply the number of vr people by 20 and add to total cost (total cost is a double) 
* if the total amount of people is over 100, multiply the total cost by 0.95 
* cost per student is total cost / total people 
*
*OUTPUT:
* total cost (double, rounded to 2 decimals) 
* cost per student (double, rounded to 2 decimals) 
*
***************************************************/
  
/**************** TEST CASES ************************
* Test      Input            Desired Ouput
* 1         5, 0, 0, 10      $950.00, $63.33
* 2         1, 4, 25, 0      $1900.00, $63.33
* 3         25, 30, 20, 25   $6085.00, $60.85 
* 4         0, 15, 50, 50    $7182.00, $62.45 
* 5         50, 120, 130, 80 $22149.25, $58.29
* 
* things to test 
* - zeroes 
* - under/over/= limits 
* - total under/over/= 100
*
***************************************************/
public class DesignProjectOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    //Write Pseudocode FIRST as comments and THEN write the code
    
    /** 
    * CONSTANTS
    * final basicCost = 50.00 (double)
    * final mainDiscount = 0.95 (double)
    * 
    * final arduinoMax = 15 (int) 
    * final arduinoBasic = 10.00 (double) 
    * final arduinoDiscount = 9.00 (double) 
    *
    * final raspberryMax = 20 (int) 
    * final raspberryBasic = 15.00 (double) 
    * final raspberryDiscount = 12.00 (double) 
    * 
    * final vrBasic = 20.00
    * 
    *
    * VARIABLES
    * basicPeople = input (int) 
    * arduinoPeople = input (int)
    * raspberryPeople = input (int)
    * vrPeople = input (int) 
    * totalPeople = basicPeople + arduinoPeople + raspberryPeople + vrPeople (int)
    * 
    * totalCost = (double) 
    * costPerPerson = totalCost / totalPeople (double) 
    * 
    **/ 
    
    // CODE
    
    // initialize and declare constants 
    final double basicCost = 50.00; 
    final double mainDiscount = 0.95; 
    final int arduinoMax = 15; 
    final double arduinoBasic = 10.00; 
    final double arduinoDiscount = 9.00; 
    final int raspberryMax = 20; 
    final double raspberryBasic = 15.00; 
    final double raspberryDiscount = 12.00; 
    final double vrBasic = 20.00; 
    
    // initialize and take inputs 
    Scanner kb = new Scanner(System.in); 
    
    System.out.print("number of people who didn't get any additions: ");
    int basicPeople = kb.nextInt(); 
    kb.nextLine(); 
    
    System.out.print("number of people who got arduino additions: ");
    int arduinoPeople = kb.nextInt(); 
    kb.nextLine(); 
    
    System.out.print("number of people who got raspberry pi additions: ");
    int raspberryPeople = kb.nextInt(); 
    kb.nextLine(); 
    
    System.out.print("number of people who got vr set additions: ");
    int vrPeople = kb.nextInt(); 
    kb.nextLine(); 
    
    // basic cost and total people calcs
    int totalPeople = basicPeople + arduinoPeople + raspberryPeople + vrPeople; 
    double totalCost = totalPeople * basicCost; 
    
    // adds the cost for arduinos to the total 
    if (arduinoPeople > arduinoMax) 
    {
        totalCost += (arduinoPeople - arduinoMax) * arduinoDiscount; 
        arduinoPeople = arduinoMax; 
    }
    totalCost += arduinoPeople * arduinoBasic; 
    
    // adds the cost for raspberries to the total 
    if (raspberryPeople > raspberryMax) 
    {
        totalCost += (raspberryPeople - raspberryMax) * raspberryDiscount; 
        raspberryPeople = raspberryMax; 
    }
    totalCost += raspberryPeople * raspberryBasic; 
    
    // adds the cost for vr to the total 
    totalCost += vrPeople * vrBasic; 
    
    // calculate total cost and cost per person 
    if (totalPeople > 100)
    { 
        totalCost *= mainDiscount; 
    }
    double costPerPerson = totalCost / totalPeople; 
    
    // outputs (rounded to 2 decimals) 
    DecimalFormat df = new DecimalFormat("#.00"); 
    System.out.println("$" + df.format(totalCost)); 
    System.out.println("$" + df.format(costPerPerson)); 
    

    }
    
}
