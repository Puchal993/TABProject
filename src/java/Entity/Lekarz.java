/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "LEKARZ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lekarz.findAll", query = "SELECT l FROM Lekarz l")
    , @NamedQuery(name = "Lekarz.findById", query = "SELECT l FROM Lekarz l WHERE l.id = :id")
    , @NamedQuery(name = "Lekarz.findByImie", query = "SELECT l FROM Lekarz l WHERE l.imie = :imie")
    , @NamedQuery(name = "Lekarz.findByNazwisko", query = "SELECT l FROM Lekarz l WHERE l.nazwisko = :nazwisko")
    , @NamedQuery(name = "Lekarz.findByLogin", query = "SELECT l FROM Lekarz l WHERE l.login = :login")
    , @NamedQuery(name = "Lekarz.findByHaslo", query = "SELECT l FROM Lekarz l WHERE l.haslo = :haslo")
    , @NamedQuery(name = "Lekarz.findByEmail", query = "SELECT l FROM Lekarz l WHERE l.email = :email")
    , @NamedQuery(name = "Lekarz.findByTelefon", query = "SELECT l FROM Lekarz l WHERE l.telefon = :telefon")
    , @NamedQuery(name = "Lekarz.findByPwz", query = "SELECT l FROM Lekarz l WHERE l.pwz = :pwz")
    , @NamedQuery(name = "Lekarz.findByPesel", query = "SELECT l FROM Lekarz l WHERE l.pesel = :pesel")
    , @NamedQuery(name = "Lekarz.findByOcenaOgolna", query = "SELECT l FROM Lekarz l WHERE l.ocenaOgolna = :ocenaOgolna")
    , @NamedQuery(name = "Lekarz.findByDataZatrudnienia", query = "SELECT l FROM Lekarz l WHERE l.dataZatrudnienia = :dataZatrudnienia")
    , @NamedQuery(name = "Lekarz.findByDataZwolnienia", query = "SELECT l FROM Lekarz l WHERE l.dataZwolnienia = :dataZwolnienia")})
public class Lekarz implements Serializable {

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
    @Column(name = "PWZ")
    private int pwz;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PESEL")
    private long pesel;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "OCENA_OGOLNA")
    private BigDecimal ocenaOgolna;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_ZATRUDNIENIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataZatrudnienia;
    @Column(name = "DATA_ZWOLNIENIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataZwolnienia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLekarz")
    private Collection<Opinia> opiniaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lekarz")
    private Collection<Wizyta> wizytaCollection;

    public Lekarz() {
    }

    public Lekarz(Short id) {
        this.id = id;
    }

    public Lekarz(Short id, String imie, String nazwisko, String login, String haslo, String email, int telefon, int pwz, long pesel, Date dataZatrudnienia) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.login = login;
        this.haslo = haslo;
        this.email = email;
        this.telefon = telefon;
        this.pwz = pwz;
        this.pesel = pesel;
        this.dataZatrudnienia = dataZatrudnienia;
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

    public int getPwz() {
        return pwz;
    }

    public void setPwz(int pwz) {
        this.pwz = pwz;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public BigDecimal getOcenaOgolna() {
        return ocenaOgolna;
    }

    public void setOcenaOgolna(BigDecimal ocenaOgolna) {
        this.ocenaOgolna = ocenaOgolna;
    }

    public Date getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(Date dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    public Date getDataZwolnienia() {
        return dataZwolnienia;
    }

    public void setDataZwolnienia(Date dataZwolnienia) {
        this.dataZwolnienia = dataZwolnienia;
    }

    @XmlTransient
    public Collection<Opinia> getOpiniaCollection() {
        return opiniaCollection;
    }

    public void setOpiniaCollection(Collection<Opinia> opiniaCollection) {
        this.opiniaCollection = opiniaCollection;
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
        if (!(object instanceof Lekarz)) {
            return false;
        }
        Lekarz other = (Lekarz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Lekarz[ id=" + id + " ]";
    }
    
}
