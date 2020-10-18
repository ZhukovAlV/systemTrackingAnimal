package dao;

import model.Animal;
import model.Rule;

import java.util.List;

public interface RuleDao {
    void setRules(List<Rule> ruleList);
    List<Rule> getRuleList();
}
