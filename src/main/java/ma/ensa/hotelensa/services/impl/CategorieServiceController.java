package ma.ensa.hotelensa.services.impl;

import ma.ensa.hotelensa.ChambreEtats;
import ma.ensa.hotelensa.beans.Categorie;
import ma.ensa.hotelensa.beans.Chambre;
import ma.ensa.hotelensa.repo.CategorieJpaRepo;
import ma.ensa.hotelensa.repo.ChambreJpaRepo;
import ma.ensa.hotelensa.services.ICategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceController implements ICategorieService {

    @Autowired
    CategorieJpaRepo categorieJpaRepo;

    @Override
    public Categorie createCategorie(Categorie categorie) {
        return categorieJpaRepo.save(categorie);
    }


    @Override
    public Categorie modifierCategorie(int categorieId, Categorie categorie) {
        Categorie categorieToUpdate = categorieJpaRepo.getOne(categorieId);
        categorieToUpdate.setNomCategorie(categorie.getNomCategorie());
        categorieJpaRepo.save(categorieToUpdate);
        return categorieToUpdate;
    }

    @Override
    public boolean supprimerCategorie(int categorieId) {
        categorieJpaRepo.deleteById(categorieId);
        return true;
    }

    @Override
    public List<Categorie> findAllCategories() {
        return categorieJpaRepo.findAll();
    }

    @Override
    public Categorie findCategorie(String nomCategorie) {
        return categorieJpaRepo.findFirstByNomCategorie(nomCategorie);
    }


}
