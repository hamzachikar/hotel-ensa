package ma.ensa.hotelensa.repo;

import ma.ensa.hotelensa.beans.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieJpaRepo extends JpaRepository<Categorie,Integer> {
}
