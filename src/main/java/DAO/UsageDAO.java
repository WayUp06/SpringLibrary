package DAO;

import Entity.Usage;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class UsageDAO extends ElementDAOImp<Usage> {
    public UsageDAO(Class<Usage> elementClass) {
        super(elementClass);
    }

    @Autowired
    SessionFactory sessionFactory;

    /**
     * @return count of all library usages during some period
     */
    public long getCountOfUsagesOfPeriod(String start, String end) {
        long result;
        Query query = sessionFactory.getCurrentSession().createQuery("select count(u.id) from Usage u" +
                " where u.takeDate > :start and u.takeDate < :end");
        LocalDate s = LocalDate.parse(start);
        LocalDate e = LocalDate.parse(end);
        query.setParameter("start", s);
        query.setParameter("end", e);
        result = (long) query.uniqueResult();
        return result;
    }
}
