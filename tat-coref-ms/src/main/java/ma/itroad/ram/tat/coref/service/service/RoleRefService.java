package ma.itroad.ram.tat.coref.service.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.itroad.ram.tat.coref.service.config.KeycloakProvider;
import ma.itroad.ram.tat.coref.service.domain.RoleRef;
import ma.itroad.ram.tat.coref.service.repository.RoleRefRepository;
import ma.itroad.ram.tat.coref.service.service.dto.RoleRefDTO;
import ma.itroad.ram.tat.coref.service.service.mapper.RoleRefMapper;


/**
 * Service Implementation for managing {@link RoleRef}.
 */
@Service
@Transactional
public class RoleRefService {

    private final Logger log = LoggerFactory.getLogger(RoleRefService.class);

    private final RoleRefRepository roleRefRepository;

    private final RoleRefMapper roleRefMapper;
    
    @Autowired
    KeycloakProvider keycloakProvider;

    public RoleRefService(RoleRefRepository roleRefRepository, RoleRefMapper roleRefMapper) {
        this.roleRefRepository = roleRefRepository;
        this.roleRefMapper = roleRefMapper;
    }

    /**
     * Save a roleRef.
     *
     * @param roleRefDTO the entity to save.
     * @return the persisted entity.
     */
    public RoleRefDTO save(RoleRefDTO roleRefDTO) {
        log.debug("Request to save RoleRef : {}", roleRefDTO);
        RoleRef roleRef = roleRefMapper.toEntity(roleRefDTO);
        roleRef = roleRefRepository.save(roleRef);
        return roleRefMapper.toDto(roleRef);
    }

    /**
     * Partially update a roleRef.
     *
     * @param roleRefDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<RoleRefDTO> partialUpdate(RoleRefDTO roleRefDTO) {
        log.debug("Request to partially update RoleRef : {}", roleRefDTO);

        return roleRefRepository
            .findById(roleRefDTO.getId())
            .map(
                existingRoleRef -> {
                    roleRefMapper.partialUpdate(existingRoleRef, roleRefDTO);

                    return existingRoleRef;
                }
            )
            .map(roleRefRepository::save)
            .map(roleRefMapper::toDto);
    }

    /**
     * Get all the roleRefs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<RoleRefDTO> findAll(Pageable pageable) {
        log.debug("Request to get all RoleRefs");
        
      
        return roleRefRepository.findAll(pageable).map(roleRefMapper::toDto);
    }

    /**
     * Get one roleRef by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<RoleRefDTO> findOne(Long id) {
        log.debug("Request to get RoleRef : {}", id);
        return roleRefRepository.findById(id).map(roleRefMapper::toDto);
    }

    /**
     * Delete the roleRef by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete RoleRef : {}", id);
        roleRefRepository.deleteById(id);
    }

}
