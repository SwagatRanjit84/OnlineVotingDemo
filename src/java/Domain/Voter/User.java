/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Voter;

/**
 *
 * @author Sweychya
 */
public class User {
    private int id;
    private String name;
    private String drink;

    /**
     * @return the name
     */
    
    
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the drink
     */
    public String getDrink() {
        return drink;
    }

    /**
     * @param drink the drink to set
     */
    public void setDrink(String drink) {
        this.drink = drink;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
}
