package ma.ensa.hotelensa.rest;

import ma.ensa.hotelensa.ChambreEtats;
import ma.ensa.hotelensa.beans.Chambre;
import ma.ensa.hotelensa.services.IChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chambres")
public class ChambreRestController {

    @Autowired
    IChambreService chambreService;

    @GetMapping(path = "/{etat}")
    public ResponseEntity<List<Chambre>> getChambersByEtat(@PathVariable(value = "etat") ChambreEtats etat) {
        return ResponseEntity.ok(
                chambreService.getChambersByEtat(etat)
        );
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Chambre> updateChambreEtat(@PathVariable(value = "id") int chambreId,
                                                     @RequestBody ChambreEtats etat) {
        return ResponseEntity.ok(
                chambreService.modifierEtatChambre(chambreId, etat)
        );
    }

    @PutMapping(path = "/{chambreId}/categorie/{catId}")
    public ResponseEntity<Chambre> updateChambreCategorie(@PathVariable(value = "chambreId") int chambreId,
                                                          @PathVariable(value = "catId") int catId) {
        return ResponseEntity.ok(
                chambreService.affecterChambreACategorie(chambreId, catId)
        );
    }
}
