package it.sevenbits.conferences.service;

import java.util.List;

import it.sevenbits.conferences.domain.VkontakteProfile;

/**
 * Interface for service layer, which works with VkontakteProfileDao.
 * Role is the primary Entity for that Service.
 */
public interface VkontakteProfileService {

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#add(Object)
     */
    VkontakteProfile addVkontakteProfile(final VkontakteProfile vkontakteProfile);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#remove(Long)
     */
    boolean removeVkontakteProfile(final Long id);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#update(Object)
     */
    VkontakteProfile updateVkontakteProfile(final VkontakteProfile vkontakteProfile);

    /**
     * Reads all users from repository.
     * @return List, witch contain all users.
     */
    List<VkontakteProfile> findAllVkontakteProfiles();

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#findById(Long)
     */
    VkontakteProfile findVkontakteProfileById(Long id);

}
