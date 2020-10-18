package service;

import dao.RuleDao;
import daoimpl.RuleDaoImpl;
import model.Rule;

import java.util.List;

public class RuleService {

    private static RuleDao ruleDao = new RuleDaoImpl();
    public static RuleDao getRuleDao() {
        return ruleDao;
    }

    public void setRules(List<Rule> rules) {
        getRuleDao().setRules(rules);
    }
    public List<Rule> getRules() {
        return getRuleDao().getRuleList();
    }
}
