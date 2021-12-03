package ma.itroad.ram.tat.coref.service.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.itroad.ram.tat.coref.service.domain.AirPortRef;
import ma.itroad.ram.tat.coref.service.repository.AirPortRefRepository;
import ma.itroad.ram.tat.coref.service.service.dto.AirPortRefDTO;
import ma.itroad.ram.tat.coref.service.service.mapper.AirPortRefMapper;

/**
 * Service Implementation for managing {@link AirPortRef}.
 */
@Service
@Transactional
public class AirPortRefService {

    private final Logger log = LoggerFactory.getLogger(AirPortRefService.class);

    private final AirPortRefRepository airPortRefRepository;

    private final AirPortRefMapper airPortRefMapper;

    public AirPortRefService(AirPortRefRepository airPortRefRepository, AirPortRefMapper airPortRefMapper) {
        this.airPortRefRepository = airPortRefRepository;
        this.airPortRefMapper = airPortRefMapper;
    }

    /**
     * Save a airPortRef.
     *
     * @param airPortRefDTO the entity to save.
     * @return the persisted entity.
     */
    public AirPortRefDTO save(AirPortRefDTO airPortRefDTO) {
        log.debug("Request to save AirPortRef : {}", airPortRefDTO);
        AirPortRef airPortRef = airPortRefMapper.toEntity(airPortRefDTO);
        airPortRef = airPortRefRepository.save(airPortRef);
        return airPortRefMapper.toDto(airPortRef);
    }

    /**
     * Partially update a airPortRef.
     *
     * @param airPortRefDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<AirPortRefDTO> partialUpdate(AirPortRefDTO airPortRefDTO) {
        log.debug("Request to partially update AirPortRef : {}", airPortRefDTO);

        return airPortRefRepository
            .findById(airPortRefDTO.getId())
            .map(
                existingAirPortRef -> {
                    airPortRefMapper.partialUpdate(existingAirPortRef, airPortRefDTO);

                    return existingAirPortRef;
                }
            )
            .map(airPortRefRepository::save)
            .map(airPortRefMapper::toDto);
    }

    /**
     * Get all the airPortRefs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AirPortRefDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AirPortRefs");
        return airPortRefRepository.findAll(pageable).map(airPortRefMapper::toDto);
    }

    /**
     * Get one airPortRef by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AirPortRefDTO> findOne(Long id) {
        log.debug("Request to get AirPortRef : {}", id);
        return airPortRefRepository.findById(id).map(airPortRefMapper::toDto);
    }
    
    
    @Transactional(readOnly = true)
    public Optional<AirPortRefDTO> findByCode(String code) {
        log.debug("Request to get AirPortRef : {}", code);
        return airPortRefRepository.findByName(code).map(airPortRefMapper::toDto);
    }

    /**
     * Delete the airPortRef by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AirPortRef : {}", id);
        airPortRefRepository.deleteById(id);
    }
}
