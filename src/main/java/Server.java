import exception.ServerException;
import service.ServerService;

import java.io.File;
import java.io.IOException;

public class Server {

    private static boolean isStarted;
    public static boolean isIsStarted() {
        return isStarted;
    }
    public static void setIsStarted(boolean isStarted) {
        Server.isStarted = isStarted;
    }

    // Запускает импорт данных с файла и запускает сервер
    public static void startServer(File importDataFileName) throws ServerException {
        ServerService.checkServerNotStart(isIsStarted());
        setIsStarted(true);
        ServerService.startServer(importDataFileName, isIsStarted());
    }

    // Записывает в файл результаты работы и останавливает сервер
    public static void stopServer(File exportDataFile) throws IOException,ServerException{
        ServerService.checkServerIsStart(isIsStarted());
        setIsStarted(false);
        ServerService.stopServer(exportDataFile, isIsStarted());
    }

    public static void counterRules() {
        ServerService.setCountForRules();
    }
}
