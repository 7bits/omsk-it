package it.sevenbits.conferences.service;

import it.sevenbits.conferences.domain.Subscription;

import java.util.List;

public interface SubscriptionService {

    Subscription addSubscription(final Subscription subscription);

    boolean removeSubscription(final Long id);

    Subscription updateSubscription(final Subscription subscription);

    List<Subscription> findAllSubscriptions();

    Subscription findSubscriptionById(final Long id);

    Subscription findSubscriptionByEmail(final String email);
}
