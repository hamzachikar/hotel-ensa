package ma.ensa.hotelensa.repo;

import ma.ensa.hotelensa.beans.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionJpaRepo extends JpaRepository<Option,Integer> {
}
