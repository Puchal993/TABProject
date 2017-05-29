/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Lukasz
 */
@Getter
@Setter
public class Visit {
    private int id,idL,idP;
    private Date dat;
    private String diagnose;  
}
