package ma.itroad.ram.tat.coref.service.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.itroad.ram.tat.coref.service.domain.DelayReasonRef;
import ma.itroad.ram.tat.coref.service.repository.DelayReasonRefRepository;
import ma.itroad.ram.tat.coref.service.service.dto.DelayReasonRefDTO;
import ma.itroad.ram.tat.coref.service.service.mapper.DelayReasonRefMapper;

/**
 * Service Implementation for managing {@link DelayReasonRef}.
 */
@Service
@Transactional
public class DelayReasonRefService {

    private final Logger log = LoggerFactory.getLogger(DelayReasonRefService.class);

    private final DelayReasonRefRepository delayReasonRefRepository;

    private final DelayReasonRefMapper delayReasonRefMapper;

    public DelayReasonRefService(DelayReasonRefRepository delayReasonRefRepository, DelayReasonRefMapper delayReasonRefMapper) {
        this.delayReasonRefRepository = delayReasonRefRepository;
        this.delayReasonRefMapper = delayReasonRefMapper;
    }

    /**
     * Save a delayReasonRef.
     *
     * @param delayReasonRefDTO the entity to save.
     * @return the persisted entity.
     */
    public DelayReasonRefDTO save(DelayReasonRefDTO delayReasonRefDTO) {
        log.debug("Request to save DelayReasonRef : {}", delayReasonRefDTO);
        DelayReasonRef delayReasonRef = delayReasonRefMapper.toEntity(delayReasonRefDTO);
        delayReasonRef = delayReasonRefRepository.save(delayReasonRef);
        return delayReasonRefMapper.toDto(delayReasonRef);
    }

    /**
     * Partially update a delayReasonRef.
     *
     * @param delayReasonRefDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<DelayReasonRefDTO> partialUpdate(DelayReasonRefDTO delayReasonRefDTO) {
        log.debug("Request to partially update DelayReasonRef : {}", delayReasonRefDTO);

        return delayReasonRefRepository
            .findById(delayReasonRefDTO.getId())
            .map(
                existingDelayReasonRef -> {
                    delayReasonRefMapper.partialUpdate(existingDelayReasonRef, delayReasonRefDTO);

                    return existingDelayReasonRef;
                }
            )
            .map(delayReasonRefRepository::save)
            .map(delayReasonRefMapper::toDto);
    }

    /**
     * Get all the delayReasonRefs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<DelayReasonRefDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DelayReasonRefs");
        return delayReasonRefRepository.findAll(pageable).map(delayReasonRefMapper::toDto);
    }

    /**
     * Get one delayReasonRef by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<DelayReasonRefDTO> findOne(Long id) {
        log.debug("Request to get DelayReasonRef : {}", id);
        return delayReasonRefRepository.findById(id).map(delayReasonRefMapper::toDto);
    }

    /**
     * Delete the delayReasonRef by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete DelayReasonRef : {}", id);
        delayReasonRefRepository.deleteById(id);
    }

    public List<DelayReasonRef> getDelayReasonListByTask(Long id) {
        return delayReasonRefRepository.getDelayReasonListByTask(id);
    }
}
