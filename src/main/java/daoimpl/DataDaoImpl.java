package daoimpl;

import dao.DataDao;
import database.DataBase;

public class DataDaoImpl implements DataDao {

    @Override
    public void clear() {
        DataBase.getDb().getAnimalList().clear();
        DataBase.getDb().getRuleList().clear();
    }
}
