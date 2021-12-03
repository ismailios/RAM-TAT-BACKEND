package ma.itroad.ram.tat.coref.service.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.itroad.ram.tat.coref.service.domain.EquipmentRef;
import ma.itroad.ram.tat.coref.service.repository.EquipmentRefRepository;
import ma.itroad.ram.tat.coref.service.service.dto.EquipmentRefDTO;
import ma.itroad.ram.tat.coref.service.service.mapper.EquipmentRefMapper;

/**
 * Service Implementation for managing {@link EquipmentRef}.
 */
@Service
@Transactional
public class EquipmentRefService {

    private final Logger log = LoggerFactory.getLogger(EquipmentRefService.class);

    private final EquipmentRefRepository equipmentRefRepository;

    private final EquipmentRefMapper equipmentRefMapper;

    public EquipmentRefService(EquipmentRefRepository equipmentRefRepository, EquipmentRefMapper equipmentRefMapper) {
        this.equipmentRefRepository = equipmentRefRepository;
        this.equipmentRefMapper = equipmentRefMapper;
    }

    /**
     * Save a equipmentRef.
     *
     * @param equipmentRefDTO the entity to save.
     * @return the persisted entity.
     */
    public EquipmentRefDTO save(EquipmentRefDTO equipmentRefDTO) {
        log.debug("Request to save EquipmentRef : {}", equipmentRefDTO);
        EquipmentRef equipmentRef = equipmentRefMapper.toEntity(equipmentRefDTO);
        equipmentRef = equipmentRefRepository.save(equipmentRef);
        return equipmentRefMapper.toDto(equipmentRef);
    }

    /**
     * Partially update a equipmentRef.
     *
     * @param equipmentRefDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<EquipmentRefDTO> partialUpdate(EquipmentRefDTO equipmentRefDTO) {
        log.debug("Request to partially update EquipmentRef : {}", equipmentRefDTO);

        return equipmentRefRepository
            .findById(equipmentRefDTO.getId())
            .map(
                existingEquipmentRef -> {
                    equipmentRefMapper.partialUpdate(existingEquipmentRef, equipmentRefDTO);

                    return existingEquipmentRef;
                }
            )
            .map(equipmentRefRepository::save)
            .map(equipmentRefMapper::toDto);
    }

    /**
     * Get all the equipmentRefs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<EquipmentRefDTO> findAll(Pageable pageable) {
        log.debug("Request to get all EquipmentRefs");
        return equipmentRefRepository.findAll(pageable).map(equipmentRefMapper::toDto);
    }

    /**
     * Get one equipmentRef by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<EquipmentRefDTO> findOne(Long id) {
        log.debug("Request to get EquipmentRef : {}", id);
        return equipmentRefRepository.findById(id).map(equipmentRefMapper::toDto);
    }

    /**
     * Delete the equipmentRef by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete EquipmentRef : {}", id);
        equipmentRefRepository.deleteById(id);
    }
}
