package ma.ensa.hotelensa.services;

import ma.ensa.hotelensa.beans.Option;
import java.util.List;

public interface IOptionService {
    Option saveOption(Option option);
    boolean deleteOptionById(int id);
    boolean affecterOptionToCategorie(int idOption, int idCategorie);
    List<Option> findAllOption();
    Option findOptionById(int id);
}
