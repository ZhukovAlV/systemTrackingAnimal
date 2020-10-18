import database.DataBase;
import exception.ServerException;
import model.Animal;
import model.Rule;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestAnimal {

    final File FILE_IMPORT = new File("importDataFile.json");
    final File FILE_EXPORT = new File("exportDataFile.json");

    // Добавляем животных в базу и смотрим ответ
    @Test
    public void addAnimals() throws IOException, ServerException {
        if (Server.isIsStarted()) Server.stopServer(FILE_EXPORT);
        Server.startServer(FILE_IMPORT);
        Server.counterRules();
        Server.stopServer(FILE_EXPORT);
       // Assert.assertEquals(Server.registerUser(REG_USER_JSON_ONE), "{\"firstName\":\"Pirs\",\"lastName\":\"Brosnan\",\"login\":\"bond\"}");
    }
}
