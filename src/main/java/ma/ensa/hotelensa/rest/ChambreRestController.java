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
    public ResponseEntity<List<Chambre>> getAvailableChambers(@PathVariable(value = "etat") ChambreEtats etat) {
        return ResponseEntity.ok(
                chambreService.getChambersByEtat(etat)
        );
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Chambre> updateChambre(@PathVariable(value = "id") int chambreId,
                                                  @RequestBody ChambreEtats etat) {
        return ResponseEntity.ok(
                chambreService.modifierEtatChambre(chambreId, etat)
        );
    }
}
