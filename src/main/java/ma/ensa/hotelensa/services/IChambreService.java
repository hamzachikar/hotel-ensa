package ma.ensa.hotelensa.services;

import ma.ensa.hotelensa.ChambreEtats;
import ma.ensa.hotelensa.beans.Chambre;

import java.util.List;

public interface IChambreService {
    Chambre modifierEtatChambre(int chambreId, ChambreEtats etat);

    List<Chambre> getChambersByEtat(ChambreEtats etat);
}
