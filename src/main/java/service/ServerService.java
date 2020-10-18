package service;

import exception.ErrorCode;
import exception.ServerException;
import model.Animal;
import model.Rule;

import java.io.File;
import java.util.List;

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
        for (int i = 0; i < getRuleService().getRules().size(); i++) {
            System.out.println(getRuleService().getRules().get(i).getCount());
        }
        getFileService().exportDataToFile(savedDataFile);
    }

    public static void setCountForRules() {
        List<Animal> listAnimal = getAnimalService().getAnimals();
        List<Rule> listRule = getRuleService().getRules();
        for (Animal animal:listAnimal) {
            for (int i = 0; i < listRule.size(); i++) {
                if (listRule.get(i).getWeight().size() == 0 || listRule.get(i).getWeight().contains(animal.getWeight())) {
                    if (listRule.get(i).getHeight().size() == 0  || listRule.get(i).getHeight().contains(animal.getHeight())) {
                        if (listRule.get(i).getType().size() == 0  || listRule.get(i).getType().contains(animal.getType())) {
                            listRule.get(i).setCount(listRule.get(i).getCount()+1);
                        }
                    }
                }
            }
        }
    }

}
