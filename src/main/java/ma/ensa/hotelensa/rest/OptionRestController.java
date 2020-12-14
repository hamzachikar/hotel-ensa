package ma.ensa.hotelensa.rest;

import ma.ensa.hotelensa.beans.Categorie;
import ma.ensa.hotelensa.beans.Option;
import ma.ensa.hotelensa.services.IOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/option")
public class OptionRestController {
    @Autowired
    private IOptionService optionService;
    @GetMapping("/findAll")
    public List<Option> findAllOptions(){
        return this.optionService.findAllOption();
    }
    @GetMapping("/find/{id}")
    public Option findOptionById(@PathVariable int id){
        return this.optionService.findOptionById(id);
    }
    @DeleteMapping("delete/{id}")
    public void deleteOptionById(@PathVariable int id){
        this.optionService.deleteOptionById(id);
    }
    @PostMapping("/save")
    public void saveOrUpdateOption(@RequestBody Option option){
        this.optionService.saveOption(option);
    }
    @PostMapping("/affecterToCategorie")
    public void affecterOptionToCategorie(@RequestBody Option option, @RequestBody Categorie categorie){
        this.optionService.affecterOptionToCategorie(option,categorie);
    }

}
