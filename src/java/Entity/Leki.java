/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lukasz
 */
@Entity
@Table(name = "LEKI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Leki.findAll", query = "SELECT l FROM Leki l")
    , @NamedQuery(name = "Leki.findById", query = "SELECT l FROM Leki l WHERE l.id = :id")
    , @NamedQuery(name = "Leki.findByNazwa", query = "SELECT l FROM Leki l WHERE l.nazwa = :nazwa")})
public class Leki implements Serializable {

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
    @JoinColumn(name = "GRUPA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GrupyLekow grupa;
    @OneToMany(mappedBy = "idLeku")
    private Collection<PrzepisaneLeki> przepisaneLekiCollection;

    public Leki() {
    }

    public Leki(Short id) {
        this.id = id;
    }

    public Leki(Short id, String nazwa) {
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

    public GrupyLekow getGrupa() {
        return grupa;
    }

    public void setGrupa(GrupyLekow grupa) {
        this.grupa = grupa;
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
        if (!(object instanceof Leki)) {
            return false;
        }
        Leki other = (Leki) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Leki[ id=" + id + " ]";
    }
    
}
