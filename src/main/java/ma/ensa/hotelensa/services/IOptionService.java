package ma.ensa.hotelensa.services;

import ma.ensa.hotelensa.beans.Categorie;
import ma.ensa.hotelensa.beans.Option;

import java.util.List;

public interface IOptionService {
    public void saveOption(Option option);
    public void deleteOptionById(int id);
    public void deleteOption(Option option);
    public void affecterOptionToCategorie(Option option, Categorie categorie);
    public List<Option> findAllOption();
    public Option findOptionById(int id);
}
