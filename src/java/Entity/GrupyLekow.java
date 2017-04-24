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
@Table(name = "GRUPY_LEKOW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupyLekow.findAll", query = "SELECT g FROM GrupyLekow g")
    , @NamedQuery(name = "GrupyLekow.findById", query = "SELECT g FROM GrupyLekow g WHERE g.id = :id")
    , @NamedQuery(name = "GrupyLekow.findByNazwaGrupy", query = "SELECT g FROM GrupyLekow g WHERE g.nazwaGrupy = :nazwaGrupy")})
public class GrupyLekow implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAZWA_GRUPY")
    private String nazwaGrupy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupa")
    private Collection<Leki> lekiCollection;

    public GrupyLekow() {
    }

    public GrupyLekow(Short id) {
        this.id = id;
    }

    public GrupyLekow(Short id, String nazwaGrupy) {
        this.id = id;
        this.nazwaGrupy = nazwaGrupy;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNazwaGrupy() {
        return nazwaGrupy;
    }

    public void setNazwaGrupy(String nazwaGrupy) {
        this.nazwaGrupy = nazwaGrupy;
    }

    @XmlTransient
    public Collection<Leki> getLekiCollection() {
        return lekiCollection;
    }

    public void setLekiCollection(Collection<Leki> lekiCollection) {
        this.lekiCollection = lekiCollection;
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
        if (!(object instanceof GrupyLekow)) {
            return false;
        }
        GrupyLekow other = (GrupyLekow) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.GrupyLekow[ id=" + id + " ]";
    }
    
}
