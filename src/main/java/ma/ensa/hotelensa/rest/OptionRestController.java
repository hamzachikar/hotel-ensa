package ma.ensa.hotelensa.rest;

import ma.ensa.hotelensa.beans.Categorie;
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
    @GetMapping("/findAll")
    public List<Option> findAllOptions(){
        return this.optionService.findAllOption();
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Option> findOptionById(@PathVariable int id){
        Option option= this.optionService.findOptionById(id);
        if(option!=null){
            return ResponseEntity.ok(option);
        }
        return ResponseEntity.badRequest().body(null);
     }
    @DeleteMapping("delete/{id}")
    public boolean deleteOptionById(@PathVariable int id){
        return this.optionService.deleteOptionById(id);
    }
    @PostMapping("/save")
    public ResponseEntity<Option> saveOrUpdateOption(@RequestBody Option option){
        return ResponseEntity.ok(this.optionService.saveOption(option));
    }
    @PostMapping("/affecterToCategorie")
    public Categorie affecterOptionToCategorie(@RequestBody Option option, @RequestBody Categorie categorie){
        return  this.optionService.affecterOptionToCategorie(option,categorie);
    }

}
