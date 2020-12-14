package ma.ensa.hotelensa.services.impl;

import ma.ensa.hotelensa.ChambreEtats;
import ma.ensa.hotelensa.beans.Chambre;
import ma.ensa.hotelensa.repo.ChambreJpaRepo;
import ma.ensa.hotelensa.services.IChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreServiceController implements IChambreService {
    @Autowired
    ChambreJpaRepo chambreJpaRepo;

    @Override
    public Chambre modifierEtatChambre(int chambreId, ChambreEtats etat) {
        Chambre chambreToUpdate = chambreJpaRepo.getOne(chambreId);
        chambreToUpdate.setEtatChambre(etat);
        chambreJpaRepo.save(chambreToUpdate);
        return chambreToUpdate;
    }

    @Override
    public List<Chambre> getChambersByEtat(ChambreEtats etat) {
        return chambreJpaRepo.findAllByEtatChambre(etat);
    }
}
