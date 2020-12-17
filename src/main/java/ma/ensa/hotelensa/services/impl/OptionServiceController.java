package ma.ensa.hotelensa.services.impl;

import ma.ensa.hotelensa.beans.Categorie;
import ma.ensa.hotelensa.beans.Option;
import ma.ensa.hotelensa.repo.CategorieJpaRepo;
import ma.ensa.hotelensa.repo.OptionJpaRepo;
import ma.ensa.hotelensa.services.IOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OptionServiceController implements IOptionService {
    @Autowired
    private OptionJpaRepo optionRepo;
    @Autowired
    private CategorieJpaRepo categorieRepo;
    @Override
    public Option saveOption(Option option) {
        return this.optionRepo.save(option);
    }

    @Override
    public boolean deleteOptionById(int id) {
        this.optionRepo.deleteById(id);
        return true;
    }

    @Override
    public void deleteOption(Option option) {
        this.optionRepo.delete(option);
    }

    @Override
    public boolean affecterOptionToCategorie(int idOption, int idCategorie) {
        Categorie categorie=this.categorieRepo.findById(idCategorie).get();
        Option option=this.optionRepo.findById(idOption).get();
        if(categorie!=null&&option!=null){
            categorie.addOption(option);
            this.categorieRepo.save(categorie);
            return true;
        }
        return false;
    }

    @Override
    public List<Option> findAllOption() {
        return this.optionRepo.findAll();
    }

    @Override
    public Option findOptionById(int id) {
        Optional<Option> option=this.optionRepo.findById(id);
        if(option.isPresent()){
            return option.get();
        }
        return null;
    }
}
