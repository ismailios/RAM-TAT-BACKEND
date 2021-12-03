package ma.itroad.ram.tat.coref.service.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.itroad.ram.tat.coref.service.domain.AirLineRef;
import ma.itroad.ram.tat.coref.service.repository.AirLineRefRepository;
import ma.itroad.ram.tat.coref.service.service.dto.AirLineRefDTO;
import ma.itroad.ram.tat.coref.service.service.mapper.AirLineRefMapper;

/**
 * Service Implementation for managing {@link AirLineRef}.
 */
@Service
@Transactional
public class AirLineRefService {

    private final Logger log = LoggerFactory.getLogger(AirLineRefService.class);

    private final AirLineRefRepository airLineRefRepository;
    
 
    private final AirLineRefMapper airLineRefMapper;


    public AirLineRefService(AirLineRefRepository airLineRefRepository, AirLineRefMapper airLineRefMapper) {
        this.airLineRefRepository = airLineRefRepository;
        this.airLineRefMapper = airLineRefMapper;
    }

    /**
     * Save a airLineRef.
     *
     * @param airLineRefDTO the entity to save.
     * @return the persisted entity.
     */
    public AirLineRefDTO save(AirLineRefDTO airLineRefDTO) {
        log.debug("Request to save AirLineRef : {}", airLineRefDTO);
        AirLineRef airLineRef = airLineRefMapper.toEntity(airLineRefDTO);
        airLineRef = airLineRefRepository.save(airLineRef);
        return airLineRefMapper.toDto(airLineRef);
    }

    /**
     * Partially update a airLineRef.
     *
     * @param airLineRefDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<AirLineRefDTO> partialUpdate(AirLineRefDTO airLineRefDTO) {
        log.debug("Request to partially update AirLineRef : {}", airLineRefDTO);

        return airLineRefRepository
            .findById(airLineRefDTO.getId())
            .map(
                existingAirLineRef -> {
                    airLineRefMapper.partialUpdate(existingAirLineRef, airLineRefDTO);

                    return existingAirLineRef;
                }
            )
            .map(airLineRefRepository::save)
            .map(airLineRefMapper::toDto);
    }

    /**
     * Get all the airLineRefs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AirLineRefDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AirLineRefs");
        return airLineRefRepository.findAll(pageable).map(airLineRefMapper::toDto);
    }

    /**
     * Get one airLineRef by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AirLineRefDTO> findOne(Long id) {
        log.debug("Request to get AirLineRef : {}", id);
        return airLineRefRepository.findById(id).map(airLineRefMapper::toDto);
    }

    /**
     * Delete the airLineRef by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AirLineRef : {}", id);
        airLineRefRepository.deleteById(id);
    }
}
