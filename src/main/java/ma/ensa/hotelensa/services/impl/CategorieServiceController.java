package ma.ensa.hotelensa.services.impl;

import ma.ensa.hotelensa.beans.Categorie;
import ma.ensa.hotelensa.repo.CategorieJpaRepo;
import ma.ensa.hotelensa.services.ICategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceController implements ICategorieService {

    @Autowired
    CategorieJpaRepo categorieJpaRepo;

    @Override
    public Categorie saveOrUpdateCategorie(Categorie categorie) {
        return this.categorieJpaRepo.save(categorie);
    }

    @Override
    public boolean supprimerCategorieById(int categorieId) {
        categorieJpaRepo.deleteById(categorieId);
        return true;
    }

    @Override
    public Categorie findByNomCategorie(String nomCategorie) {
        return this.categorieJpaRepo.findByNomCategorie(nomCategorie);
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
