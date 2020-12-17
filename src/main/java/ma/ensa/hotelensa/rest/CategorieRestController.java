package ma.ensa.hotelensa.rest;

import ma.ensa.hotelensa.beans.Categorie;
import ma.ensa.hotelensa.services.ICategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategorieRestController {
    @Autowired
    ICategorieService categorieService;


    @GetMapping(path = "/")
    public ResponseEntity<List<Categorie>> findAllCategories() {
        return ResponseEntity.ok(
                categorieService.findAllCategories()
        );
    }

    @GetMapping(path = "/{nom}")
    public ResponseEntity<Categorie> findCategorie(@PathVariable(value = "nom") String nomCategorie) {
        return ResponseEntity.ok(
                categorieService.findCategorie(nomCategorie)
        );
    }

    @PostMapping(path = "/")
    public ResponseEntity<Categorie> saveOrUpdateCategorie(@RequestBody Categorie categorie) {
        return ResponseEntity.ok(
                categorieService.saveOrUpdateCategorie(categorie)
        );
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteCategorie(@PathVariable(value = "id") int categorieId) {
        return ResponseEntity.ok(
                categorieService.supprimerCategorieById(categorieId)
        );
    }

}
