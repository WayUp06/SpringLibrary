package Service;

import DAO.UsageDAO;
import Entity.Usage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class UsageService {

    //private UsageDAO usageDAO = new UsageDAO(Usage.class);

    @Autowired
    UsageDAO usageDAO;

    public UsageService() {
    }

    public void add(Usage usage) {
        usageDAO.add(usage);
    }

    public boolean update(Usage usage) {
            usageDAO.update(usage);
            return true;
    }

    public Usage get(int id) {
        return usageDAO.get(id);
    }

    public Collection<Usage> getAll() {
        return usageDAO.getAll();
    }

    public void delete(Usage usage) {
        usageDAO.delete(usage);
    }

    public long getCountOfUsagesOfPeriod(String start, String end) {
        return usageDAO.getCountOfUsagesOfPeriod(start, end);
    }
}
