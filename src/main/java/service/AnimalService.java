package service;

import dao.AnimalDao;
import daoimpl.AnimalDaoImpl;
import model.Animal;
import model.Rule;

import java.util.List;

public class AnimalService {

    private static AnimalDao animalDao = new AnimalDaoImpl();

    public static AnimalDao getAnimalDao() {
        return animalDao;
    }

    public void setAnimals(List<Animal> animals) {
        getAnimalDao().setAnimals(animals);
    }

    public List<Animal> getAnimals() {
        return getAnimalDao().getAnimalList();
    }
}
