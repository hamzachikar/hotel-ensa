package ma.ensa.hotelensa.beans;

import ma.ensa.hotelensa.ChambreEtats;

import javax.persistence.*;

@Entity
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChambre;
    private int nbreChambre;
    private int nbreEtageChambre;
    private ChambreEtats etatChambre= ChambreEtats.DISPONIBLE;
    @ManyToOne
    private Categorie categorie;
    public Chambre() {
    }

    public Chambre(int idChambre, int nbreChambre, int nbreEtageChambre, Categorie categorie) {
        this.idChambre = idChambre;
        this.nbreChambre = nbreChambre;
        this.nbreEtageChambre = nbreEtageChambre;
        this.categorie = categorie;
    }

    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }

    public int getNbreEtageChambre() {
        return nbreEtageChambre;
    }

    public void setNbreEtageChambre(int nbreEtageChambre) {
        this.nbreEtageChambre = nbreEtageChambre;
    }

    public int getNbreChambre() {
        return nbreChambre;
    }

    public void setNbreChambre(int nbreChambre) {
        this.nbreChambre = nbreChambre;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public ChambreEtats getEtatChambre() {
        return etatChambre;
    }

    public void setEtatChambre(ChambreEtats etatChambre) {
        this.etatChambre = etatChambre;
    }
}
