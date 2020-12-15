package ma.ensa.hotelensa.beans;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Occupation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idOccupation;
    private Date beginDateOccupation;
    private Date endDateOccupation;
    @ManyToOne(cascade = CascadeType.DETACH)
    private Chambre chambre;
    @ManyToOne(cascade = CascadeType.DETACH)
    private Client client;

    public Occupation() {
    }

    public Occupation(int idOccupation, Date beginDateOccupation, Date endDateOccupation, Chambre chambre, Client client) {
        this.idOccupation = idOccupation;
        this.beginDateOccupation = beginDateOccupation;
        this.endDateOccupation = endDateOccupation;
        this.chambre = chambre;
        this.client = client;
    }

    public int getIdOccupation() {
        return idOccupation;
    }

    public void setIdOccupation(int idOccupation) {
        this.idOccupation = idOccupation;
    }

    public Date getBeginDateOccupation() {
        return beginDateOccupation;
    }

    public void setBeginDateOccupation(Date beginDateOccupation) {
        this.beginDateOccupation = beginDateOccupation;
    }

    public Date getEndDateOccupation() {
        return endDateOccupation;
    }

    public void setEndDateOccupation(Date endDateOccupation) {
        this.endDateOccupation = endDateOccupation;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
