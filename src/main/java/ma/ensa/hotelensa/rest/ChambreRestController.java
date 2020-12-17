package ma.ensa.hotelensa.rest;

import ma.ensa.hotelensa.config.ChambreEtats;
import ma.ensa.hotelensa.beans.Chambre;
import ma.ensa.hotelensa.services.IChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chambres")
public class ChambreRestController {

    @Autowired
    IChambreService chambreService;

    @PostMapping("/")
    public ResponseEntity<Chambre> saveOrUpdateChambre(@RequestBody Chambre chambre){
        return  ResponseEntity.ok(
          this.chambreService.saveChambre(chambre)
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChambreById(@PathVariable int id){
        if(this.chambreService.deleteChambreById(id)){
            return ResponseEntity.ok("chambre deleted");
        }
        return ResponseEntity.badRequest().body("something wrong check logs");
    }
    @GetMapping("/")
    public ResponseEntity<List<Chambre>> findAllChambre(){
        return ResponseEntity.ok(this.chambreService.findAllChambre());
    }
    @GetMapping("/{etat}")
    public ResponseEntity<List<Chambre>> getChambersByEtat(@PathVariable(value = "etat") ChambreEtats etat) {
        return ResponseEntity.ok(
                chambreService.getChambersByEtat(etat)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chambre> updateChambreEtat(@PathVariable(value = "id") int chambreId,
                                                     @RequestBody ChambreEtats etat) {
        return ResponseEntity.ok(
                chambreService.modifierEtatChmabre(chambreId, etat)
        );
    }

    @PutMapping("/{chambreId}/to/categorie/{catId}")
    public ResponseEntity<String> updateChambreCategorie(@PathVariable(value = "chambreId") int chambreId,
                                                          @PathVariable(value = "catId") int catId) {
        boolean isAffected=chambreService.affecterChambreACategorie(chambreId, catId);
        if(isAffected){
            return   ResponseEntity.ok("affected");
        }
        return ResponseEntity.badRequest().body("not affected");
    }
}
