package ma.ensa.hotelensa.services.impl;

import ma.ensa.hotelensa.config.ChambreEtats;
import ma.ensa.hotelensa.beans.Categorie;
import ma.ensa.hotelensa.beans.Chambre;
import ma.ensa.hotelensa.repo.CategorieJpaRepo;
import ma.ensa.hotelensa.repo.ChambreJpaRepo;
import ma.ensa.hotelensa.services.IChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChambreServiceController implements IChambreService {
    @Autowired
    private ChambreJpaRepo chambreJpaRepo;
    @Autowired
    private CategorieJpaRepo categorieJpaRepo;

    @Override
    public Chambre saveChambre(Chambre chambre) {
        return this.chambreJpaRepo.save(chambre);
    }

    @Override
    public Chambre modifierEtatChmabre(int idChambre, ChambreEtats etat) {
        Optional<Chambre> chambre=this.chambreJpaRepo.findById(idChambre);
        if(chambre.isPresent()){
            chambre.ifPresent(
                    oldChambre -> oldChambre.setEtatChambre(etat)
            );
            return chambre.get();
        }
        return null;
    }

    @Override
    public boolean deleteChambreById(int idChambre) {
        this.chambreJpaRepo.deleteById(idChambre);
        return true;
    }

    @Override
    public List<Chambre> filterChambreByCategorie(Categorie categorie) {
        return this.chambreJpaRepo.findAll();
    }

    @Override
    public List<Chambre> filterChambreByCategorieId(int idCategorie) {
        List<Chambre> chambres=new ArrayList<>();
        Optional<Categorie> categorie=this.categorieJpaRepo.findById(idCategorie);
        if(categorie.isPresent()){
            chambres=this.chambreJpaRepo.findAllByCategorie(categorie.get());
        }
        return chambres;
    }

    @Override
    public List<Chambre> getChambersByEtat(ChambreEtats etat) {
        return chambreJpaRepo.findAllByEtatChambre(etat);
    }

    @Override
    public boolean affecterChambreACategorie(int chambreId, int categorieId) {
        Chambre chambreToUpdate =  chambreJpaRepo.findById(chambreId).get();
        Categorie categorie = categorieJpaRepo.findById(categorieId).get();
        if(chambreToUpdate!=null&&categorie!=null){
            chambreToUpdate.setCategorie(categorie);
            chambreJpaRepo.save(chambreToUpdate);
            return true;
        }


        return false;
    }

    @Override
    public List<Chambre> findAllChambre() {
        return this.chambreJpaRepo.findAll();
    }


}
