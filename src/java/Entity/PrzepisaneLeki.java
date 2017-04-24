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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lukasz
 */
@Entity
@Table(name = "PRZEPISANE_LEKI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrzepisaneLeki.findAll", query = "SELECT p FROM PrzepisaneLeki p")
    , @NamedQuery(name = "PrzepisaneLeki.findById", query = "SELECT p FROM PrzepisaneLeki p WHERE p.id = :id")
    , @NamedQuery(name = "PrzepisaneLeki.findByIlosc", query = "SELECT p FROM PrzepisaneLeki p WHERE p.ilosc = :ilosc")})
public class PrzepisaneLeki implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ILOSC")
    private short ilosc;
    @JoinColumn(name = "ID_LEKU", referencedColumnName = "ID")
    @ManyToOne
    private Leki idLeku;
    @JoinColumn(name = "ID_RECEPTY", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Recepta idRecepty;

    public PrzepisaneLeki() {
    }

    public PrzepisaneLeki(Short id) {
        this.id = id;
    }

    public PrzepisaneLeki(Short id, short ilosc) {
        this.id = id;
        this.ilosc = ilosc;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public short getIlosc() {
        return ilosc;
    }

    public void setIlosc(short ilosc) {
        this.ilosc = ilosc;
    }

    public Leki getIdLeku() {
        return idLeku;
    }

    public void setIdLeku(Leki idLeku) {
        this.idLeku = idLeku;
    }

    public Recepta getIdRecepty() {
        return idRecepty;
    }

    public void setIdRecepty(Recepta idRecepty) {
        this.idRecepty = idRecepty;
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
        if (!(object instanceof PrzepisaneLeki)) {
            return false;
        }
        PrzepisaneLeki other = (PrzepisaneLeki) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.PrzepisaneLeki[ id=" + id + " ]";
    }
    
}
