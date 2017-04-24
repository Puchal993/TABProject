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
@Table(name = "TYP_BADANIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypBadania.findAll", query = "SELECT t FROM TypBadania t")
    , @NamedQuery(name = "TypBadania.findById", query = "SELECT t FROM TypBadania t WHERE t.id = :id")
    , @NamedQuery(name = "TypBadania.findByNazwa", query = "SELECT t FROM TypBadania t WHERE t.nazwa = :nazwa")})
public class TypBadania implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAZWA")
    private String nazwa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typBadania")
    private Collection<ZleconeBadania> zleconeBadaniaCollection;

    public TypBadania() {
    }

    public TypBadania(Short id) {
        this.id = id;
    }

    public TypBadania(Short id, String nazwa) {
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

    @XmlTransient
    public Collection<ZleconeBadania> getZleconeBadaniaCollection() {
        return zleconeBadaniaCollection;
    }

    public void setZleconeBadaniaCollection(Collection<ZleconeBadania> zleconeBadaniaCollection) {
        this.zleconeBadaniaCollection = zleconeBadaniaCollection;
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
        if (!(object instanceof TypBadania)) {
            return false;
        }
        TypBadania other = (TypBadania) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TypBadania[ id=" + id + " ]";
    }
    
}
