package ma.ensa.hotelensa.repo;

import ma.ensa.hotelensa.beans.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccupationJpaRepo extends JpaRepository<Occupation,Integer> {
}
