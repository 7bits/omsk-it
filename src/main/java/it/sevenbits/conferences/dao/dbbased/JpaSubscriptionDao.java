package it.sevenbits.conferences.dao.dbbased;

import org.springframework.stereotype.Repository;

import it.sevenbits.conferences.dao.SubscriptionDao;
import it.sevenbits.conferences.domain.Subscription;

/**
 * Java Persistence API based implementation of the SubscriptionDao.
 */
@Repository
public class JpaSubscriptionDao extends JpaEntityDao<Subscription> implements SubscriptionDao {

    /**
     * Default constructor for the spring framework annotation based configuration.
     */
    public JpaSubscriptionDao() {

        super(Subscription.class);
    }

    /**
     * Constructor from generic JpaEntityDao.
     * @param subscriptionClass generic class type.
     */
    public JpaSubscriptionDao(final Class<Subscription> subscriptionClass) {

        super(subscriptionClass);
    }
}
