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
public class Results {
    private String party;
    private String name;
    private int value;
  private String district;
    private int sum;

    /**
     * @return the party
     */
    public String getParty() {
        return party;
    }

    /**
     * @param party the party to set
     */
    public void setParty(String party) {
        this.party = party;
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
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }
      public String getDistrict() {
        return district;
    }
       public void setDistrict(String district) {
        this.district =district;
    }
    
        public int getSum() {
        return sum;
    }
       public void setSum(int sum) {
        this.sum =sum;
    }
    
}
