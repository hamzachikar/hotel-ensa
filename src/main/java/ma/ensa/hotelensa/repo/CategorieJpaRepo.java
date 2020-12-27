package ma.ensa.hotelensa.repo;

import ma.ensa.hotelensa.beans.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorieJpaRepo extends JpaRepository<Categorie,Integer> {
    public Categorie findFirstByNomCategorie(String nomCategorie);
    Categorie findByNomCategorie(String nomCategorie);
}
