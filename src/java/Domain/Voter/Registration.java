/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Voter;

/**
 *
 * @author acer
 */
public class Registration {
   private String name;
  private  String email;
  private  String voter_id;
  private  String citizenship;
  private  String district;
private String pin;
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
  
  
}
