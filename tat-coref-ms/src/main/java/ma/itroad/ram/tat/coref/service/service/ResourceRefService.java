package ma.itroad.ram.tat.coref.service.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.itroad.ram.tat.coref.service.domain.ResourceRef;
import ma.itroad.ram.tat.coref.service.repository.ResourceRefRepository;
import ma.itroad.ram.tat.coref.service.service.dto.ResourceRefDTO;
import ma.itroad.ram.tat.coref.service.service.mapper.ResourceRefMapper;

/**
 * Service Implementation for managing {@link ResourceRef}.
 */
@Service
@Transactional
public class ResourceRefService {

    private final Logger log = LoggerFactory.getLogger(ResourceRefService.class);

    private final ResourceRefRepository resourceRefRepository;

    private final ResourceRefMapper resourceRefMapper;

    public ResourceRefService(ResourceRefRepository resourceRefRepository, ResourceRefMapper resourceRefMapper) {
        this.resourceRefRepository = resourceRefRepository;
        this.resourceRefMapper = resourceRefMapper;
    }

    /**
     * Save a resourceRef.
     *
     * @param resourceRefDTO the entity to save.
     * @return the persisted entity.
     */
    public ResourceRefDTO save(ResourceRefDTO resourceRefDTO) {
        log.debug("Request to save ResourceRef : {}", resourceRefDTO);
        ResourceRef resourceRef = resourceRefMapper.toEntity(resourceRefDTO);
        resourceRef = resourceRefRepository.save(resourceRef);
        return resourceRefMapper.toDto(resourceRef);
    }

    /**
     * Partially update a resourceRef.
     *
     * @param resourceRefDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<ResourceRefDTO> partialUpdate(ResourceRefDTO resourceRefDTO) {
        log.debug("Request to partially update ResourceRef : {}", resourceRefDTO);

        return resourceRefRepository
            .findById(resourceRefDTO.getId())
            .map(
                existingResourceRef -> {
                    resourceRefMapper.partialUpdate(existingResourceRef, resourceRefDTO);

                    return existingResourceRef;
                }
            )
            .map(resourceRefRepository::save)
            .map(resourceRefMapper::toDto);
    }

    /**
     * Get all the resourceRefs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ResourceRefDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ResourceRefs");
        return resourceRefRepository.findAll(pageable).map(resourceRefMapper::toDto);
    }

    /**
     * Get one resourceRef by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ResourceRefDTO> findOne(Long id) {
        log.debug("Request to get ResourceRef : {}", id);
        return resourceRefRepository.findById(id).map(resourceRefMapper::toDto);
    }

    /**
     * Delete the resourceRef by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete ResourceRef : {}", id);
        resourceRefRepository.deleteById(id);
    }

    public String findRoleByUsername(String username) {
        return resourceRefRepository.findRoleByUsername(username);
    }
}
