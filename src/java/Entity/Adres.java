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
@Table(name = "ADRES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adres.findAll", query = "SELECT a FROM Adres a")
    , @NamedQuery(name = "Adres.findByIdAdres", query = "SELECT a FROM Adres a WHERE a.idAdres = :idAdres")
    , @NamedQuery(name = "Adres.findByWojewodztwo", query = "SELECT a FROM Adres a WHERE a.wojewodztwo = :wojewodztwo")
    , @NamedQuery(name = "Adres.findByPowiat", query = "SELECT a FROM Adres a WHERE a.powiat = :powiat")
    , @NamedQuery(name = "Adres.findByKodPocztowy", query = "SELECT a FROM Adres a WHERE a.kodPocztowy = :kodPocztowy")
    , @NamedQuery(name = "Adres.findByMiejscowosc", query = "SELECT a FROM Adres a WHERE a.miejscowosc = :miejscowosc")
    , @NamedQuery(name = "Adres.findByUlica", query = "SELECT a FROM Adres a WHERE a.ulica = :ulica")
    , @NamedQuery(name = "Adres.findByNrLokalu", query = "SELECT a FROM Adres a WHERE a.nrLokalu = :nrLokalu")})
public class Adres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ADRES")
    private Short idAdres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "WOJEWODZTWO")
    private String wojewodztwo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "POWIAT")
    private String powiat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "KOD_POCZTOWY")
    private String kodPocztowy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "MIEJSCOWOSC")
    private String miejscowosc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ULICA")
    private String ulica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NR_LOKALU")
    private short nrLokalu;
    @JoinColumn(name = "ID_PACJENT", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Pacjent idPacjent;

    public Adres() {
    }

    public Adres(Short idAdres) {
        this.idAdres = idAdres;
    }

    public Adres(Short idAdres, String wojewodztwo, String powiat, String kodPocztowy, String miejscowosc, String ulica, short nrLokalu) {
        this.idAdres = idAdres;
        this.wojewodztwo = wojewodztwo;
        this.powiat = powiat;
        this.kodPocztowy = kodPocztowy;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.nrLokalu = nrLokalu;
    }

    public Short getIdAdres() {
        return idAdres;
    }

    public void setIdAdres(Short idAdres) {
        this.idAdres = idAdres;
    }

    public String getWojewodztwo() {
        return wojewodztwo;
    }

    public void setWojewodztwo(String wojewodztwo) {
        this.wojewodztwo = wojewodztwo;
    }

    public String getPowiat() {
        return powiat;
    }

    public void setPowiat(String powiat) {
        this.powiat = powiat;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public short getNrLokalu() {
        return nrLokalu;
    }

    public void setNrLokalu(short nrLokalu) {
        this.nrLokalu = nrLokalu;
    }

    public Pacjent getIdPacjent() {
        return idPacjent;
    }

    public void setIdPacjent(Pacjent idPacjent) {
        this.idPacjent = idPacjent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdres != null ? idAdres.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adres)) {
            return false;
        }
        Adres other = (Adres) object;
        if ((this.idAdres == null && other.idAdres != null) || (this.idAdres != null && !this.idAdres.equals(other.idAdres))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Adres[ idAdres=" + idAdres + " ]";
    }
    
}
