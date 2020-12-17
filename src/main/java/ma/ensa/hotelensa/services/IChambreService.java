package ma.ensa.hotelensa.services;

import ma.ensa.hotelensa.beans.Categorie;
import ma.ensa.hotelensa.config.ChambreEtats;
import ma.ensa.hotelensa.beans.Chambre;

import java.util.List;

public interface IChambreService {
    public Chambre saveChambre(Chambre chambre);
    public Chambre modifierEtatChmabre(int idChambre,ChambreEtats etat);
    public boolean deleteChambreById(int idChambre);
    public List<Chambre> filterChambreByCategorie(Categorie categorie);
    public  List<Chambre> filterChambreByCategorieId(int idCategorie);
    List<Chambre> getChambersByEtat(ChambreEtats etat);
    public Chambre affecterChambreACategorie(int chambreId, int categorieId);
}
