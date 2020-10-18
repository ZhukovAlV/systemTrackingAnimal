package service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import dao.AnimalDao;
import dao.DataDao;
import dao.RuleDao;
import daoimpl.AnimalDaoImpl;
import daoimpl.DataDaoImpl;
import daoimpl.RuleDaoImpl;
import model.Animal;
import model.Rule;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    private static Gson gson = new Gson();
    public static Gson getGson() {
        return gson;
    }

    private static AnimalDao animalDao = new AnimalDaoImpl();
    public static AnimalDao getAnimalDao() {
        return animalDao;
    }

    private static RuleDao ruleDao = new RuleDaoImpl();
    public static RuleDao getRuleDao() {
        return ruleDao;
    }

    private static DataDao dataDao = new DataDaoImpl();
    public static DataDao getDataDao() {
        return dataDao;
    }

    public void importDataFromFile(File file, AnimalService animalService, RuleService ruleService) {
        List<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            JsonReader reader = getGson().newJsonReader(br);
            reader.beginArray();
            while (reader.hasNext()) {
                String str = getGson().fromJson(reader, String.class);
                data.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        // укажем правильный параметризованный тип для нашего типа
        animalService.setAnimals((getGson().fromJson(data.get(0), new TypeToken<ArrayList<Animal>>() {}.getType())));
        ruleService.setRules((getGson().fromJson(data.get(1), new TypeToken<ArrayList<Rule>>() {}.getType())));
    }

    public void exportDataToFile(File file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            JsonArray ja = new JsonArray();
            ja.add(getGson().toJson(getAnimalDao().getAnimalList()));
            ja.add(getGson().toJson(getRuleDao().getRuleList()));
            bw.write(ja.toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        getDataDao().clear();
    }

}