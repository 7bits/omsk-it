package it.sevenbits.conferences.service.common;

import it.sevenbits.conferences.dao.SubscriptionDao;
import it.sevenbits.conferences.domain.Subscription;
import it.sevenbits.conferences.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Simple implementation of the SubscriptionService.
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionDao subscriptionDao;

    @Transactional
    @Override
    public Subscription addSubscription(final Subscription subscription) {

        return subscriptionDao.add(subscription);
    }

    @Transactional
    @Override
    public boolean removeSubscription(final Long id) {

        return subscriptionDao.remove(id);
    }

    @Transactional
    @Override
    public Subscription updateSubscription(final Subscription subscription) {

        return subscriptionDao.update(subscription);
    }

    @Transactional
    @Override
    public List<Subscription> findAllSubscriptions() {

        return subscriptionDao.findAll();
    }

    @Transactional
    @Override
    public Subscription findSubscriptionById(final Long id) {

        return subscriptionDao.findById(id);
    }

    @Transactional
    @Override
    public Subscription findSubscriptionByEmail(final String email) {
        List<Subscription> result = subscriptionDao.findByQuery("select s from Subscription s where s.email = '" + email + "'", null);
        if (result != null && !result.isEmpty()) {
            return result.get(0);
        }
        return null;
    }
}
