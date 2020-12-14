package ma.ensa.hotelensa.services;

import ma.ensa.hotelensa.beans.Categorie;

import java.util.List;

public interface ICategorieService {
    List<Categorie> findAllCategories();
    Categorie findCategorie(String nomCategorie);
    Categorie saveOrUpdateCategorie(Categorie categorie);
    boolean supprimerCategorieById(int categorieId);

}
