package daoimpl;

import dao.AnimalDao;
import database.DataBase;
import model.Animal;

import java.util.List;

public class AnimalDaoImpl implements AnimalDao {
    @Override
    public void setAnimals(List<Animal> animalList) {
        if (animalList!=null) {
            DataBase.getDb().setAnimalList(animalList);
        }
    }

    @Override
    public List<Animal> getAnimalList() {
        return DataBase.getDb().getAnimalList();
    }
}
