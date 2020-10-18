package service;

import com.google.gson.Gson;
import exception.ErrorCode;
import exception.ServerException;

import java.io.File;

public class ServerService {

    private static FileService fileService = new FileService();
    public static FileService getFileService() {
        return fileService;
    }

    private static AnimalService animalService = new AnimalService();
    public static AnimalService getAnimalService() {
        return animalService;
    }

    private static RuleService ruleService = new RuleService();
    public static RuleService getRuleService() {
        return ruleService;
    }

    // Проверка сервера на Включен
    public static void checkServerIsStart(boolean isStarted) throws ServerException{
        if (!isStarted) throw new ServerException(ErrorCode.SERVER_NOT_START);
    }

    // Проверка сервера на Выключен
    public static void checkServerNotStart(boolean isStarted) throws ServerException{
        if (isStarted) throw new ServerException(ErrorCode.SERVER_IS_START);
    }

    public static void startServer(File savedDataFileName, boolean isStarted) throws ServerException {
        checkServerIsStart(isStarted);
        if (savedDataFileName!=null) getFileService().importDataFromFile(savedDataFileName, getAnimalService(), getRuleService());
    }

    public static void stopServer(File savedDataFile,boolean isStarted) throws ServerException{
        checkServerNotStart(isStarted);
        if (savedDataFile==null) throw new ServerException(ErrorCode.SERVER_FILE_NOT_EXIST);
        getFileService().exportDataToFile(savedDataFile);
    }

}
