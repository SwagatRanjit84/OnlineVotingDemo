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
public class Voter {
    private int id;
    private String name;
    private String relationName;
    private String email;
    private String password;
    private String district;

    private String voter_id;
    private String citizenship;
    private String pin;
    private String secondPin;

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

    /**
     * @return the voter_id
     */
    public String getVoter_id() {
        return voter_id;
    }

    /**
     * @param voter_id the voter_id to set
     */
    public void setVoter_id(String voter_id) {
        this.voter_id = voter_id;
    }

    /**
     * @return the citizenship
     */
    public String getCitizenship() {
        return citizenship;
    }

    /**
     * @param citizenship the citizenship to set
     */
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    /**
     * @return the pin
     */
    public String getPin() {
        return pin;
    }

    /**
     * @param pin the pin to set
     */
    public void setPin(String pin) {
        this.pin = pin;
    }

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
     * @return the RelationName
     */
    public String getRelationName() {
        return relationName;
    }

    /**
     * @param RelationName the RelationName to set
     */
    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
   public String getSecondPin() {
        return secondPin;
    }

    /**
     * @param password the password to set
     */
    public void setSecondPin(String secondPin) {
        this.secondPin = secondPin;
    }

    /**
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(String district) {
        this.district = district;
    }
  
    
}
