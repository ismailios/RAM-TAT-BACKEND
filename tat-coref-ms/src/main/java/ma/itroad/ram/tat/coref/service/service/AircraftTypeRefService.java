package ma.itroad.ram.tat.coref.service.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.itroad.ram.tat.coref.service.domain.AircraftTypeRef;
import ma.itroad.ram.tat.coref.service.repository.AircraftTypeRefRepository;
import ma.itroad.ram.tat.coref.service.service.dto.AircraftTypeRefDTO;
import ma.itroad.ram.tat.coref.service.service.mapper.AircraftTypeRefMapper;

/**
 * Service Implementation for managing {@link AircraftTypeRef}.
 */
@Service
@Transactional
public class AircraftTypeRefService {

    private final Logger log = LoggerFactory.getLogger(AircraftTypeRefService.class);

    private final AircraftTypeRefRepository aircraftTypeRefRepository;

    private final AircraftTypeRefMapper aircraftTypeRefMapper;

    public AircraftTypeRefService(AircraftTypeRefRepository aircraftTypeRefRepository, AircraftTypeRefMapper aircraftTypeRefMapper) {
        this.aircraftTypeRefRepository = aircraftTypeRefRepository;
        this.aircraftTypeRefMapper = aircraftTypeRefMapper;
    }

    /**
     * Save a aircraftTypeRef.
     *
     * @param aircraftTypeRefDTO the entity to save.
     * @return the persisted entity.
     */
    public AircraftTypeRefDTO save(AircraftTypeRefDTO aircraftTypeRefDTO) {
        log.debug("Request to save AircraftTypeRef : {}", aircraftTypeRefDTO);
        AircraftTypeRef aircraftTypeRef = aircraftTypeRefMapper.toEntity(aircraftTypeRefDTO);
        aircraftTypeRef = aircraftTypeRefRepository.save(aircraftTypeRef);
        return aircraftTypeRefMapper.toDto(aircraftTypeRef);
    }

    /**
     * Partially update a aircraftTypeRef.
     *
     * @param aircraftTypeRefDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<AircraftTypeRefDTO> partialUpdate(AircraftTypeRefDTO aircraftTypeRefDTO) {
        log.debug("Request to partially update AircraftTypeRef : {}", aircraftTypeRefDTO);

        return aircraftTypeRefRepository
            .findById(aircraftTypeRefDTO.getId())
            .map(
                existingAircraftTypeRef -> {
                    aircraftTypeRefMapper.partialUpdate(existingAircraftTypeRef, aircraftTypeRefDTO);

                    return existingAircraftTypeRef;
                }
            )
            .map(aircraftTypeRefRepository::save)
            .map(aircraftTypeRefMapper::toDto);
    }

    /**
     * Get all the aircraftTypeRefs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AircraftTypeRefDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AircraftTypeRefs");
        return aircraftTypeRefRepository.findAll(pageable).map(aircraftTypeRefMapper::toDto);
    }

    /**
     * Get one aircraftTypeRef by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AircraftTypeRefDTO> findOne(Long id) {
        log.debug("Request to get AircraftTypeRef : {}", id);
        return aircraftTypeRefRepository.findById(id).map(aircraftTypeRefMapper::toDto);
    }

    /**
     * Delete the aircraftTypeRef by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AircraftTypeRef : {}", id);
        aircraftTypeRefRepository.deleteById(id);
    }
    public long getTatMaxBySubtype(String subType)
    {
        try {return aircraftTypeRefRepository.tatMax(subType);}
        catch (Exception e){return 60;}
    }


    public String getAircraftTypeBySubtype(String acSubtype) {
        try{
            return aircraftTypeRefRepository.aircraftType(acSubtype);
        }
        catch(Exception e){return "MP";}
    }


}
