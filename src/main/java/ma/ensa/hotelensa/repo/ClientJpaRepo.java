package ma.ensa.hotelensa.repo;

import ma.ensa.hotelensa.beans.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientJpaRepo extends JpaRepository<Client,Integer> {
}
