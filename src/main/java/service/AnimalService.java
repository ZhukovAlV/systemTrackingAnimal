package service;

import dao.AnimalDao;
import daoimpl.AnimalDaoImpl;
import model.Animal;

import java.util.List;

public class AnimalService {

    private static AnimalDao animalDao = new AnimalDaoImpl();

    public void setAnimals(List<Animal> animals) {
        animalDao.setAnimals(animals);
    }
}
