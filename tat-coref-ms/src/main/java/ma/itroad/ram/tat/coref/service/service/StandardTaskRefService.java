package ma.itroad.ram.tat.coref.service.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.itroad.ram.tat.coref.service.domain.StandardTaskRef;
import ma.itroad.ram.tat.coref.service.repository.StandardTaskRefRepository;
import ma.itroad.ram.tat.coref.service.service.dto.StandardTaskRefDTO;
import ma.itroad.ram.tat.coref.service.service.mapper.StandardTaskRefMapper;

/**
 * Service Implementation for managing {@link StandardTaskRef}.
 */
@Service
@Transactional
public class StandardTaskRefService {

    private final Logger log = LoggerFactory.getLogger(StandardTaskRefService.class);

    private final StandardTaskRefRepository standardTaskRefRepository;

    private final StandardTaskRefMapper standardTaskRefMapper;

    public StandardTaskRefService(StandardTaskRefRepository standardTaskRefRepository, StandardTaskRefMapper standardTaskRefMapper) {
        this.standardTaskRefRepository = standardTaskRefRepository;
        this.standardTaskRefMapper = standardTaskRefMapper;
    }

    /**
     * Save a standardTaskRef.
     *
     * @param standardTaskRefDTO the entity to save.
     * @return the persisted entity.
     */
    public StandardTaskRefDTO save(StandardTaskRefDTO standardTaskRefDTO) {
        log.debug("Request to save StandardTaskRef : {}", standardTaskRefDTO);
        StandardTaskRef standardTaskRef = standardTaskRefMapper.toEntity(standardTaskRefDTO);
        standardTaskRef = standardTaskRefRepository.save(standardTaskRef);
        return standardTaskRefMapper.toDto(standardTaskRef);
    }

    /**
     * Partially update a standardTaskRef.
     *
     * @param standardTaskRefDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<StandardTaskRefDTO> partialUpdate(StandardTaskRefDTO standardTaskRefDTO) {
        log.debug("Request to partially update StandardTaskRef : {}", standardTaskRefDTO);

        return standardTaskRefRepository
            .findById(standardTaskRefDTO.getId())
            .map(
                existingStandardTaskRef -> {
                    standardTaskRefMapper.partialUpdate(existingStandardTaskRef, standardTaskRefDTO);

                    return existingStandardTaskRef;
                }
            )
            .map(standardTaskRefRepository::save)
            .map(standardTaskRefMapper::toDto);
    }

    /**
     * Get all the standardTaskRefs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<StandardTaskRefDTO> findAll(Pageable pageable) {
        log.debug("Request to get all StandardTaskRefs");
        return standardTaskRefRepository.findAll(pageable).map(standardTaskRefMapper::toDto);
    }

    /**
     * Get one standardTaskRef by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<StandardTaskRefDTO> findOne(Long id) {
        log.debug("Request to get StandardTaskRef : {}", id);
        return standardTaskRefRepository.findById(id).map(standardTaskRefMapper::toDto);
    }

    /**
     * Delete the standardTaskRef by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete StandardTaskRef : {}", id);
        standardTaskRefRepository.deleteById(id);
    }
}
