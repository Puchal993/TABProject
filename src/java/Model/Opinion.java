/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Lukasz
 */
public class Opinion {
    private int id,intP,intL;
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIntP() {
        return intP;
    }

    public void setIntP(int intP) {
        this.intP = intP;
    }

    public int getIntL() {
        return intL;
    }

    public void setIntL(int intL) {
        this.intL = intL;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
