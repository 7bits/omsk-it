package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.VkontakteProfileDao;
import it.sevenbits.conferences.domain.VkontakteProfile;
import org.springframework.stereotype.Repository;

/**
 * Java Persistence API based implementation of the VkontakteProfileDao.
 */
@Repository
public class JpaVkontakteProfileDao extends JpaEntityDao<VkontakteProfile> implements VkontakteProfileDao {

    /**
     * Default constructor for the spring framework annotation based configuration.
     */
    public JpaVkontakteProfileDao() {

        super(VkontakteProfile.class);
    }

    /**
     * Constructor from generic JpaEntityDao.
     * @param vkontakteProfileClass generic class type.
     */
    public JpaVkontakteProfileDao(final Class<VkontakteProfile> vkontakteProfileClass) {

        super(vkontakteProfileClass);
    }
}
