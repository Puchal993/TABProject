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
@Table(name = "PACJENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacjent.findAll", query = "SELECT p FROM Pacjent p")
    , @NamedQuery(name = "Pacjent.findById", query = "SELECT p FROM Pacjent p WHERE p.id = :id")
    , @NamedQuery(name = "Pacjent.findByImie", query = "SELECT p FROM Pacjent p WHERE p.imie = :imie")
    , @NamedQuery(name = "Pacjent.findByNazwisko", query = "SELECT p FROM Pacjent p WHERE p.nazwisko = :nazwisko")
    , @NamedQuery(name = "Pacjent.findByLogin", query = "SELECT p FROM Pacjent p WHERE p.login = :login")
    , @NamedQuery(name = "Pacjent.findByHaslo", query = "SELECT p FROM Pacjent p WHERE p.haslo = :haslo")
    , @NamedQuery(name = "Pacjent.findByEmail", query = "SELECT p FROM Pacjent p WHERE p.email = :email")
    , @NamedQuery(name = "Pacjent.findByTelefon", query = "SELECT p FROM Pacjent p WHERE p.telefon = :telefon")
    , @NamedQuery(name = "Pacjent.findByPesel", query = "SELECT p FROM Pacjent p WHERE p.pesel = :pesel")
    , @NamedQuery(name = "Pacjent.findByDataUrodzenia", query = "SELECT p FROM Pacjent p WHERE p.dataUrodzenia = :dataUrodzenia")})
public class Pacjent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "IMIE")
    private String imie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "NAZWISKO")
    private String nazwisko;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "HASLO")
    private String haslo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TELEFON")
    private int telefon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PESEL")
    private long pesel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_URODZENIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUrodzenia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPacjenta")
    private Collection<Opinia> opiniaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPacjent")
    private Collection<Adres> adresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacjent")
    private Collection<Wizyta> wizytaCollection;

    public Pacjent() {
    }

    public Pacjent(Short id) {
        this.id = id;
    }

    public Pacjent(Short id, String imie, String nazwisko, String login, String haslo, String email, int telefon, long pesel, Date dataUrodzenia) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.login = login;
        this.haslo = haslo;
        this.email = email;
        this.telefon = telefon;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    @XmlTransient
    public Collection<Opinia> getOpiniaCollection() {
        return opiniaCollection;
    }

    public void setOpiniaCollection(Collection<Opinia> opiniaCollection) {
        this.opiniaCollection = opiniaCollection;
    }

    @XmlTransient
    public Collection<Adres> getAdresCollection() {
        return adresCollection;
    }

    public void setAdresCollection(Collection<Adres> adresCollection) {
        this.adresCollection = adresCollection;
    }

    @XmlTransient
    public Collection<Wizyta> getWizytaCollection() {
        return wizytaCollection;
    }

    public void setWizytaCollection(Collection<Wizyta> wizytaCollection) {
        this.wizytaCollection = wizytaCollection;
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
        if (!(object instanceof Pacjent)) {
            return false;
        }
        Pacjent other = (Pacjent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Pacjent[ id=" + id + " ]";
    }

    
    
}
