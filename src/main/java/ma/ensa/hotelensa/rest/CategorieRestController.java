package ma.ensa.hotelensa.rest;

import ma.ensa.hotelensa.beans.Categorie;
import ma.ensa.hotelensa.services.ICategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategorieRestController {
    @Autowired
    ICategorieService categorieService;

    @PostMapping(path = "/")
    public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie) {
        return ResponseEntity.ok(
                categorieService.createCategorie(categorie)
        );
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Categorie> updateCategorie(@PathVariable(value = "id") int categorieId,
                                                  @RequestBody Categorie categorie) {
        return ResponseEntity.ok(
                categorieService.modifierCategorie(categorieId, categorie)
        );
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteCategorie(@PathVariable(value = "id") int categorieId) {
        return ResponseEntity.ok(
                categorieService.supprimerCategorie(categorieId)
        );
    }

}
