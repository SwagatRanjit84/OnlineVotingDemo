/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Admin;

/**
 *
 * @author acer
 */
public class Result {
    private int id;
    private String candidate;
    private String numberOfVotes;

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
     * @return the candidate
     */
    public String getCandidate() {
        return candidate;
    }

    /**
     * @param candidate the candidate to set
     */
    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    /**
     * @return the numberOfVotes
     */
    public String getNumberOfVotes() {
        return numberOfVotes;
    }

    /**
     * @param numberOfVotes the numberOfVotes to set
     */
    public void setNumberOfVotes(String numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }
    
}
