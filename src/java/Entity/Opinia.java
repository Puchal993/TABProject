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
@Table(name = "OPINIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opinia.findAll", query = "SELECT o FROM Opinia o")
    , @NamedQuery(name = "Opinia.findById", query = "SELECT o FROM Opinia o WHERE o.id = :id")
    , @NamedQuery(name = "Opinia.findByOcena", query = "SELECT o FROM Opinia o WHERE o.ocena = :ocena")
    , @NamedQuery(name = "Opinia.findByKomentarz", query = "SELECT o FROM Opinia o WHERE o.komentarz = :komentarz")})
public class Opinia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OCENA")
    private short ocena;
    @Size(max = 150)
    @Column(name = "KOMENTARZ")
    private String komentarz;
    @JoinColumn(name = "ID_LEKARZ", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Lekarz idLekarz;
    @JoinColumn(name = "ID_PACJENTA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Pacjent idPacjenta;

    public Opinia() {
    }

    public Opinia(Short id) {
        this.id = id;
    }

    public Opinia(Short id, short ocena) {
        this.id = id;
        this.ocena = ocena;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public short getOcena() {
        return ocena;
    }

    public void setOcena(short ocena) {
        this.ocena = ocena;
    }

    public String getKomentarz() {
        return komentarz;
    }

    public void setKomentarz(String komentarz) {
        this.komentarz = komentarz;
    }

    public Lekarz getIdLekarz() {
        return idLekarz;
    }

    public void setIdLekarz(Lekarz idLekarz) {
        this.idLekarz = idLekarz;
    }

    public Pacjent getIdPacjenta() {
        return idPacjenta;
    }

    public void setIdPacjenta(Pacjent idPacjenta) {
        this.idPacjenta = idPacjenta;
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
        if (!(object instanceof Opinia)) {
            return false;
        }
        Opinia other = (Opinia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Opinia[ id=" + id + " ]";
    }
    
}
