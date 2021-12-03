package ma.itroad.ram.tat.coref.service.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.itroad.ram.tat.coref.service.domain.FlightTypeRef;
import ma.itroad.ram.tat.coref.service.domain.enumeration.LegEnum;
import ma.itroad.ram.tat.coref.service.repository.FlightTypeRefRepository;
import ma.itroad.ram.tat.coref.service.service.dto.FlightTypeRefDTO;
import ma.itroad.ram.tat.coref.service.service.mapper.FlightTypeRefMapper;

/**
 * Service Implementation for managing {@link FlightTypeRef}.
 */
@Service
@Transactional
public class FlightTypeRefService {

    private final Logger log = LoggerFactory.getLogger(FlightTypeRefService.class);

    private final FlightTypeRefRepository flightTypeRefRepository;

    private final FlightTypeRefMapper flightTypeRefMapper;

    public FlightTypeRefService(FlightTypeRefRepository flightTypeRefRepository, FlightTypeRefMapper flightTypeRefMapper) {
        this.flightTypeRefRepository = flightTypeRefRepository;
        this.flightTypeRefMapper = flightTypeRefMapper;
    }

    /**
     * Save a flightTypeRef.
     *
     * @param flightTypeRefDTO the entity to save.
     * @return the persisted entity.
     */
    public FlightTypeRefDTO save(FlightTypeRefDTO flightTypeRefDTO) {
        log.debug("Request to save FlightTypeRef : {}", flightTypeRefDTO);
        FlightTypeRef flightTypeRef = flightTypeRefMapper.toEntity(flightTypeRefDTO);
        flightTypeRef = flightTypeRefRepository.save(flightTypeRef);
        return flightTypeRefMapper.toDto(flightTypeRef);
    }

    /**
     * Partially update a flightTypeRef.
     *
     * @param flightTypeRefDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<FlightTypeRefDTO> partialUpdate(FlightTypeRefDTO flightTypeRefDTO) {
        log.debug("Request to partially update FlightTypeRef : {}", flightTypeRefDTO);

        return flightTypeRefRepository
            .findById(flightTypeRefDTO.getId())
            .map(
                existingFlightTypeRef -> {
                    flightTypeRefMapper.partialUpdate(existingFlightTypeRef, flightTypeRefDTO);

                    return existingFlightTypeRef;
                }
            )
            .map(flightTypeRefRepository::save)
            .map(flightTypeRefMapper::toDto);
    }

    /**
     * Get all the flightTypeRefs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<FlightTypeRefDTO> findAll(Pageable pageable) {
        log.debug("Request to get all FlightTypeRefs");
        return flightTypeRefRepository.findAll(pageable).map(flightTypeRefMapper::toDto);
    }

    /**
     * Get one flightTypeRef by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<FlightTypeRefDTO> findOne(Long id) {
        log.debug("Request to get FlightTypeRef : {}", id);
        return flightTypeRefRepository.findById(id).map(flightTypeRefMapper::toDto);
    }

    /**
     * Delete the flightTypeRef by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete FlightTypeRef : {}", id);
        flightTypeRefRepository.deleteById(id);
    }

    public List<FlightTypeRef> getFlightTypeByLegType(String legType) {
        LegEnum leg= LegEnum.valueOf(legType);
        return flightTypeRefRepository.getFlightTypeByLegType(leg);
    }
}
