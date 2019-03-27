/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Random;

/**
 *
 * @author Sweychya
 */
public class RandomNumber {
    public int getNumber(){
    Random r = new Random( System.currentTimeMillis() );
    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
}

   
 
  
    }
    

