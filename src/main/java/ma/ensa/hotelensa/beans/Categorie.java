package ma.ensa.hotelensa.beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomCategorie;
    @ManyToMany
    private List<Option> optionList;

    public Categorie() {
    }

    public Categorie(int id, String nomCategorie, List<Option> optionList) {
        this.id = id;
        this.nomCategorie = nomCategorie;
        this.optionList = optionList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }
    public void addOption(Option option){
        if(this.optionList==null){
            this.optionList=new ArrayList<>();
        }
        this.optionList.add(option);
    }
}
