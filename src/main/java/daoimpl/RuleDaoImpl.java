package daoimpl;

import dao.RuleDao;
import database.DataBase;
import model.Rule;

import java.util.List;

public class RuleDaoImpl implements RuleDao {
    @Override
    public void setRules(List<Rule> ruleList) {
        if (ruleList!=null) {
            DataBase.getDb().setRuleList(ruleList);
        }
    }

    @Override
    public List<Rule> getRuleList() {
        return DataBase.getDb().getRuleList();
    }
}
