package it.sevenbits.conferences.service.common;

import it.sevenbits.conferences.dao.RoleDao;
import it.sevenbits.conferences.dao.VkontakteProfileDao;
import it.sevenbits.conferences.domain.Role;
import it.sevenbits.conferences.domain.VkontakteProfile;
import it.sevenbits.conferences.service.RoleService;
import it.sevenbits.conferences.service.VkontakteProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Simple implementation of the VkontakteProfileService.
 */
@Service
public class SimpleVkontakteProfileService implements VkontakteProfileService {

    @Autowired
    private VkontakteProfileDao vkontakteProfileDao;

    @Transactional
    @Override
    public VkontakteProfile addVkontakteProfile(final VkontakteProfile vkontakteProfile) {
        return vkontakteProfileDao.add(vkontakteProfile);
    }

    @Transactional
    @Override
    public boolean removeVkontakteProfile(final Long id) {
        return vkontakteProfileDao.remove(id);
    }

    @Transactional
    @Override
    public VkontakteProfile updateVkontakteProfile(final VkontakteProfile vkontakteProfile) {
        return vkontakteProfileDao.update(vkontakteProfile);
    }

    @Transactional
    @Override
    public List<VkontakteProfile> findAllVkontakteProfiles() {
        return vkontakteProfileDao.findAll();
    }

    @Transactional
    @Override
    public VkontakteProfile findVkontakteProfileById(final Long id) {
        return vkontakteProfileDao.findById(id);
    }
}
