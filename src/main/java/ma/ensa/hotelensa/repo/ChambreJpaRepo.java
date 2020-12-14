package ma.ensa.hotelensa.repo;

import ma.ensa.hotelensa.config.ChambreEtats;
import ma.ensa.hotelensa.beans.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChambreJpaRepo extends JpaRepository<Chambre,Integer> {
    public List<Chambre> findAllByEtatChambre(ChambreEtats etat);
}
