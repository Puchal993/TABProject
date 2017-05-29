/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Lukasz
 */
@Getter
@Setter
public class Lekarz {

    private String name, lastname, login, pass, email, data, dataZ;
    private long pesel, pwz;
    private int tel,id,spec;
    private Date dat, datZ;
    private boolean edit;
    private BigDecimal score;   
}