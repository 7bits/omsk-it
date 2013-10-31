package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.SubscriptionDao;
import it.sevenbits.conferences.domain.Subscription;
import org.springframework.stereotype.Repository;

@Repository
public class JpaSubscriptionDao extends JpaEntityDao<Subscription> implements SubscriptionDao {

    public JpaSubscriptionDao() {

        super(Subscription.class);
    }

    public JpaSubscriptionDao(Class<Subscription> subscriptionClass) {

        super(subscriptionClass);
    }
}
