/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lukasz
 */
@Entity
@Table(name = "WIZYTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wizyta.findAll", query = "SELECT w FROM Wizyta w")
    , @NamedQuery(name = "Wizyta.findById", query = "SELECT w FROM Wizyta w WHERE w.id = :id")
    , @NamedQuery(name = "Wizyta.findByDataWizyty", query = "SELECT w FROM Wizyta w WHERE w.dataWizyty = :dataWizyty")
    , @NamedQuery(name = "Wizyta.findByDiagnoza", query = "SELECT w FROM Wizyta w WHERE w.diagnoza = :diagnoza")})
public class Wizyta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_WIZYTY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataWizyty;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DIAGNOZA")
    private String diagnoza;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idWizyty")
    private Collection<ZleconeBadania> zleconeBadaniaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idWizyty")
    private Collection<Recepta> receptaCollection;
    @JoinColumn(name = "LEKARZ", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Lekarz lekarz;
    @JoinColumn(name = "PACJENT", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Pacjent pacjent;

    public Wizyta() {
    }

    public Wizyta(Short id) {
        this.id = id;
    }

    public Wizyta(Short id, Date dataWizyty, String diagnoza) {
        this.id = id;
        this.dataWizyty = dataWizyty;
        this.diagnoza = diagnoza;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Date getDataWizyty() {
        return dataWizyty;
    }

    public void setDataWizyty(Date dataWizyty) {
        this.dataWizyty = dataWizyty;
    }

    public String getDiagnoza() {
        return diagnoza;
    }

    public void setDiagnoza(String diagnoza) {
        this.diagnoza = diagnoza;
    }

    @XmlTransient
    public Collection<ZleconeBadania> getZleconeBadaniaCollection() {
        return zleconeBadaniaCollection;
    }

    public void setZleconeBadaniaCollection(Collection<ZleconeBadania> zleconeBadaniaCollection) {
        this.zleconeBadaniaCollection = zleconeBadaniaCollection;
    }

    @XmlTransient
    public Collection<Recepta> getReceptaCollection() {
        return receptaCollection;
    }

    public void setReceptaCollection(Collection<Recepta> receptaCollection) {
        this.receptaCollection = receptaCollection;
    }

    public Lekarz getLekarz() {
        return lekarz;
    }

    public void setLekarz(Lekarz lekarz) {
        this.lekarz = lekarz;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
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
        if (!(object instanceof Wizyta)) {
            return false;
        }
        Wizyta other = (Wizyta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Wizyta[ id=" + id + " ]";
    }
    
}
