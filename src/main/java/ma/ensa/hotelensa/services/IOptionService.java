package ma.ensa.hotelensa.services;

import ma.ensa.hotelensa.beans.Categorie;
import ma.ensa.hotelensa.beans.Option;

import java.util.List;

public interface IOptionService {
    public Option saveOption(Option option);
    public boolean deleteOptionById(int id);
    public boolean affecterOptionToCategorie(int idOption, int idCategorie);
    public List<Option> findAllOption();
    public Option findOptionById(int id);
}
