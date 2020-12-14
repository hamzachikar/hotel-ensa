package ma.ensa.hotelensa.services.impl;

import ma.ensa.hotelensa.beans.Categorie;
import ma.ensa.hotelensa.beans.Option;
import ma.ensa.hotelensa.repo.CategorieJpaRepo;
import ma.ensa.hotelensa.repo.OptionJpaRepo;
import ma.ensa.hotelensa.services.IOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void deleteOptionById(int id) {
        this.optionRepo.deleteById(id);
    }

    @Override
    public void deleteOption(Option option) {
        this.optionRepo.delete(option);
    }

    @Override
    public Categorie affecterOptionToCategorie(Option option, Categorie categorie) {
        categorie.addOption(option);
        return this.categorieRepo.save(categorie);
    }

    @Override
    public List<Option> findAllOption() {
        return this.optionRepo.findAll();
    }

    @Override
    public Option findOptionById(int id) {
        return this.optionRepo.findById(id).get();
    }
}
