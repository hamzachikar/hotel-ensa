package ma.ensa.hotelensa.repo;

import ma.ensa.hotelensa.beans.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreJpaRepo extends JpaRepository<Chambre,Integer> {
}
