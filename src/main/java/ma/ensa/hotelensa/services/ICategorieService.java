package ma.ensa.hotelensa.services;

import ma.ensa.hotelensa.beans.Categorie;

import java.util.List;

public interface ICategorieService {
    List<Categorie> findAllCategories();
    Categorie findCategorie(String nomCategorie);
    Categorie createCategorie(Categorie categorie);
    Categorie modifierCategorie(int categorieId,Categorie categorie);
    boolean supprimerCategorie(int categorieId);

}
