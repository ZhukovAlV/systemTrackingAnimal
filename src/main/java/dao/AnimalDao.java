package dao;

import model.Animal;

import java.util.List;

public interface AnimalDao {
    void setAnimals(List<Animal> animalList);
    List<Animal> getAnimalList();
}
