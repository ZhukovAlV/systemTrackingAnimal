package database;

import model.Animal;
import model.Rule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataBase {

    private static DataBase db = new DataBase();

    private DataBase() {
    }

    public static DataBase getDb() {
        return db;
    }

    private List<Animal> animalList = new ArrayList<>();
    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
    public List<Animal> getAnimalList() {
        return animalList;
    }

    private List<Rule> ruleList = new LinkedList<>();
    public void setRuleList(List<Rule> ruleList) {
        this.ruleList = ruleList;
    }
    public List<Rule> getRuleList() {
        return ruleList;
    }

}
