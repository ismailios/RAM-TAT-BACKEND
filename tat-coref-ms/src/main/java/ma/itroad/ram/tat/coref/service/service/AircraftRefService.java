package ma.itroad.ram.tat.coref.service.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.itroad.ram.tat.coref.service.domain.AircraftRef;
import ma.itroad.ram.tat.coref.service.domain.AircraftTypeRef;
import ma.itroad.ram.tat.coref.service.repository.AircraftRefRepository;
import ma.itroad.ram.tat.coref.service.service.dto.AircraftRefDTO;
import ma.itroad.ram.tat.coref.service.service.mapper.AircraftRefMapper;

/**
 * Service Implementation for managing {@link AircraftRef}.
 */
@Service
@Transactional
public class AircraftRefService {

    private final Logger log = LoggerFactory.getLogger(AircraftRefService.class);

    private final AircraftRefRepository aircraftRefRepository;

    private final AircraftRefMapper aircraftRefMapper;

    public AircraftRefService(AircraftRefRepository aircraftRefRepository, AircraftRefMapper aircraftRefMapper) {
        this.aircraftRefRepository = aircraftRefRepository;
        this.aircraftRefMapper = aircraftRefMapper;
    }

    /**
     * Save a aircraftRef.
     *
     * @param aircraftRefDTO the entity to save.
     * @return the persisted entity.
     */
    public AircraftRefDTO save(AircraftRefDTO aircraftRefDTO) {
        log.debug("Request to save AircraftRef : {}", aircraftRefDTO);
        AircraftRef aircraftRef = aircraftRefMapper.toEntity(aircraftRefDTO);
        aircraftRef = aircraftRefRepository.save(aircraftRef);
        return aircraftRefMapper.toDto(aircraftRef);
    }

    /**
     * Partially update a aircraftRef.
     *
     * @param aircraftRefDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<AircraftRefDTO> partialUpdate(AircraftRefDTO aircraftRefDTO) {
        log.debug("Request to partially update AircraftRef : {}", aircraftRefDTO);

        return aircraftRefRepository
            .findById(aircraftRefDTO.getId())
            .map(
                existingAircraftRef -> {
                    aircraftRefMapper.partialUpdate(existingAircraftRef, aircraftRefDTO);

                    return existingAircraftRef;
                }
            )
            .map(aircraftRefRepository::save)
            .map(aircraftRefMapper::toDto);
    }

    /**
     * Get all the aircraftRefs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AircraftRefDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AircraftRefs");
        return aircraftRefRepository.findAll(pageable).map(aircraftRefMapper::toDto);
    }

    /**
     * Get one aircraftRef by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AircraftRefDTO> findOne(Long id) {
        log.debug("Request to get AircraftRef : {}", id);
        return aircraftRefRepository.findById(id).map(aircraftRefMapper::toDto);
    }

    /**
     * Delete the aircraftRef by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AircraftRef : {}", id);
        aircraftRefRepository.deleteById(id);
    }
   
    public AircraftRef getaircraftRef(String code){
   	   AircraftRef aircraftRef = aircraftRefRepository.findByCode(code);
       return aircraftRef;

   }
    
    public AircraftRef getaircraftTypeRef(String code){
      	 AircraftRef aircraftRef = aircraftRefRepository.findByCode(code);
          return aircraftRef;

      }
    
}
