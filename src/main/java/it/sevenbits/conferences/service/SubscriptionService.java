package it.sevenbits.conferences.service;

import it.sevenbits.conferences.domain.Subscription;

import java.util.List;

/**
 * Interface for service layer, which works with EntityDao.
 * Subscription is the primary Entity for that Service.
 */
public interface SubscriptionService {

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#add(Object)
     */
    Subscription addSubscription(final Subscription subscription);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#remove(Long)
     */
    boolean removeSubscription(final Long id);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#update(Object)
     */
    Subscription updateSubscription(final Subscription subscription);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#findAll()
     */
    List<Subscription> findAllSubscriptions();

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#findById(Long)
     */
    Subscription findSubscriptionById(final Long id);

    /**
     * Finds an stored Subscription by it's email.
     * @param email Subscription's email.
     * @return the found Subscription, or null if the Subscription does not exist or an error occurs.
     * @see it.sevenbits.conferences.dao.EntityDao#findByQuery(String, java.util.Map)
     */
    Subscription findSubscriptionByEmail(final String email);
}
