/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lukasz
 */
@Entity
@Table(name = "RECEPTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recepta.findAll", query = "SELECT r FROM Recepta r")
    , @NamedQuery(name = "Recepta.findById", query = "SELECT r FROM Recepta r WHERE r.id = :id")})
public class Recepta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @JoinColumn(name = "ID_WIZYTY", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Wizyta idWizyty;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecepty")
    private Collection<PrzepisaneLeki> przepisaneLekiCollection;

    public Recepta() {
    }

    public Recepta(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Wizyta getIdWizyty() {
        return idWizyty;
    }

    public void setIdWizyty(Wizyta idWizyty) {
        this.idWizyty = idWizyty;
    }

    @XmlTransient
    public Collection<PrzepisaneLeki> getPrzepisaneLekiCollection() {
        return przepisaneLekiCollection;
    }

    public void setPrzepisaneLekiCollection(Collection<PrzepisaneLeki> przepisaneLekiCollection) {
        this.przepisaneLekiCollection = przepisaneLekiCollection;
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
        if (!(object instanceof Recepta)) {
            return false;
        }
        Recepta other = (Recepta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Recepta[ id=" + id + " ]";
    }
    
}
