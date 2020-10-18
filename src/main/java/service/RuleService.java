package service;

import dao.RuleDao;
import daoimpl.RuleDaoImpl;
import model.Rule;

import java.util.List;

public class RuleService {

    private static RuleDao ruleDao = new RuleDaoImpl();

    public void setRules(List<Rule> rules) {
        ruleDao.setRules(rules);
    }
}
