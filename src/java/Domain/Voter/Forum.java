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
public class Forum {
    private int id;
    private String candidate;
    private String wish;

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
     * @return the CandidateName
     */
    public String getCandidate() {
        return candidate;
    }

    /**
     * @param CandidateName the CandidateName to set
     */
    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    /**
     * @return the wish
     */
    public String getWish() {
        return wish;
    }

    /**
     * @param wish the wish to set
     */
    public void setWish(String wish) {
        this.wish = wish;
    }
    
    
}
