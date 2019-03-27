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
public class VotedVoter {
 private   int id;
 private String voted_id;
 private String voter_id;
 private String time;

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
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the voted_id
     */
    public String getVoted_id() {
        return voted_id;
    }

    /**
     * @param voted_id the voted_id to set
     */
    public void setVoted_id(String voted_id) {
        this.voted_id = voted_id;
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
 
}
