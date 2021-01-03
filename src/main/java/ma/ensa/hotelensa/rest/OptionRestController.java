package ma.ensa.hotelensa.rest;

import ma.ensa.hotelensa.beans.Option;
import ma.ensa.hotelensa.services.IOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/option")
public class OptionRestController {
    @Autowired
    private IOptionService optionService;
    @GetMapping("/")
    public List<Option> findAllOptions(){
        return this.optionService.findAllOption();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Option> findOptionById(@PathVariable int id){
        Option option= this.optionService.findOptionById(id);
        if(option!=null){
            return ResponseEntity.ok(option);
        }
        return ResponseEntity.badRequest().body(null);
     }
    @DeleteMapping("/{id}")
    public boolean deleteOptionById(@PathVariable int id){
        return this.optionService.deleteOptionById(id);
    }
    @PostMapping("/")
    public ResponseEntity<Option> saveOrUpdateOption(@RequestBody Option option){
        return ResponseEntity.ok(this.optionService.saveOption(option));
    }
    @PostMapping("/{idOption}/to/categorie/{idCategorie}")
    public ResponseEntity<String> affecterOptionToCategorie(@PathVariable(value = "idOption") int idOption,@PathVariable(value = "idCategorie")int idCategorie){
        boolean isAffected=this.optionService.affecterOptionToCategorie(idOption,idCategorie);
        if(isAffected){
            return ResponseEntity.ok("affected");
        }
        return ResponseEntity.badRequest().body("not affected");
    }

}
