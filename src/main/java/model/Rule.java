package model;

import java.util.ArrayList;

public class Rule {
    ArrayList<String> weight;
    ArrayList<String> height;
    ArrayList<String> type;
    int count;

    public void setCount(Integer count) {
        this.count = count;
    }
    public Integer getCount() {
        return count;
    }

    public ArrayList<String> getWeight() {
        return weight;
    }

    public ArrayList<String> getHeight() {
        return height;
    }

    public ArrayList<String> getType() {
        return type;
    }

    public Rule(ArrayList<String> weight, ArrayList<String> height, ArrayList<String> type) {
        this.weight = weight;
        this.height = height;
        this.type = type;
        this.count = 0;
    }
}
