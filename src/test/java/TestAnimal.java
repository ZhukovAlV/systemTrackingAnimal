import exception.ServerException;
import org.junit.Assert;
import org.junit.Test;
import service.RuleService;

import java.io.File;
import java.io.IOException;

public class TestAnimal {

    private static RuleService ruleService = new RuleService();
    public static RuleService getRuleService() {
        return ruleService;
    }

    final File FILE_IMPORT = new File("importDataFile.json");
    final File FILE_EXPORT = new File("exportDataFile.json");

    // Добавляем животных в базу и смотрим ответ
    @Test
    public void addAnimals() throws IOException, ServerException {
        if (Server.isIsStarted()) Server.stopServer(FILE_EXPORT);
        Server.startServer(FILE_IMPORT);
        int result = getRuleService().getRules().get(0).getCount();
        Assert.assertEquals(result,0);
        Server.counterRules();
        result = getRuleService().getRules().get(0).getCount();
        Assert.assertEquals(result,1);
        Server.stopServer(FILE_EXPORT);
    }
}
