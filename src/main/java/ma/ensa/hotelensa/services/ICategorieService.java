package ma.ensa.hotelensa.services;

import ma.ensa.hotelensa.beans.Categorie;

public interface ICategorieService {
    Categorie createCategorie(Categorie categorie);
    Categorie modifierCategorie(int categorieId,Categorie categorie);

    boolean supprimerCategorie(int categorieId);
}
