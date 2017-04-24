/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lukasz
 */
@Entity
@Table(name = "SPECJALIZACJA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specjalizacja.findAll", query = "SELECT s FROM Specjalizacja s")
    , @NamedQuery(name = "Specjalizacja.findById", query = "SELECT s FROM Specjalizacja s WHERE s.id = :id")
    , @NamedQuery(name = "Specjalizacja.findByNazwa", query = "SELECT s FROM Specjalizacja s WHERE s.nazwa = :nazwa")})
public class Specjalizacja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "NAZWA")
    private String nazwa;

    public Specjalizacja() {
    }

    public Specjalizacja(Short id) {
        this.id = id;
    }

    public Specjalizacja(Short id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specjalizacja)) {
            return false;
        }
        Specjalizacja other = (Specjalizacja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Specjalizacja[ id=" + id + " ]";
    }
    
}
