package ma.ensa.hotelensa.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOption;
    private String nomOption;
    private int quantite;
    private double priceOption;

    public Option() {
    }

    public Option(int idOption, String nomOption, int quantite, double priceOption) {
        this.idOption = idOption;
        this.nomOption = nomOption;
        this.quantite = quantite;
        this.priceOption = priceOption;
    }

    public int getIdOption() {
        return idOption;
    }

    public void setIdOption(int idOption) {
        this.idOption = idOption;
    }

    public String getNomOption() {
        return nomOption;
    }

    public void setNomOption(String nomOption) {
        this.nomOption = nomOption;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPriceOption() {
        return priceOption;
    }

    public void setPriceOption(double priceOption) {
        this.priceOption = priceOption;
    }
}
