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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lukasz
 */
@Entity
@Table(name = "ZLECONE_BADANIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZleconeBadania.findAll", query = "SELECT z FROM ZleconeBadania z")
    , @NamedQuery(name = "ZleconeBadania.findById", query = "SELECT z FROM ZleconeBadania z WHERE z.id = :id")
    , @NamedQuery(name = "ZleconeBadania.findByWynik", query = "SELECT z FROM ZleconeBadania z WHERE z.wynik = :wynik")})
public class ZleconeBadania implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @Size(max = 500)
    @Column(name = "WYNIK")
    private String wynik;
    @JoinColumn(name = "TYP_BADANIA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TypBadania typBadania;
    @JoinColumn(name = "ID_WIZYTY", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Wizyta idWizyty;

    public ZleconeBadania() {
    }

    public ZleconeBadania(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getWynik() {
        return wynik;
    }

    public void setWynik(String wynik) {
        this.wynik = wynik;
    }

    public TypBadania getTypBadania() {
        return typBadania;
    }

    public void setTypBadania(TypBadania typBadania) {
        this.typBadania = typBadania;
    }

    public Wizyta getIdWizyty() {
        return idWizyty;
    }

    public void setIdWizyty(Wizyta idWizyty) {
        this.idWizyty = idWizyty;
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
        if (!(object instanceof ZleconeBadania)) {
            return false;
        }
        ZleconeBadania other = (ZleconeBadania) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.ZleconeBadania[ id=" + id + " ]";
    }
    
}
