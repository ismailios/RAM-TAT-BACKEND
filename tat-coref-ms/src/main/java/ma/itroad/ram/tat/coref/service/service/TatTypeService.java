package ma.itroad.ram.tat.coref.service.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.itroad.ram.tat.coref.service.domain.TatType;
import ma.itroad.ram.tat.coref.service.repository.TatTypeRepository;
import ma.itroad.ram.tat.coref.service.service.dto.TatTypeDTO;
import ma.itroad.ram.tat.coref.service.service.mapper.TatTypeMapper;

/**
 * Service Implementation for managing {@link TatType}.
 */
@Service
@Transactional
public class TatTypeService {

    private final Logger log = LoggerFactory.getLogger(TatTypeService.class);

    private final TatTypeRepository tatTypeRepository;

    private final TatTypeMapper tatTypeMapper;

    public TatTypeService(TatTypeRepository tatTypeRepository, TatTypeMapper tatTypeMapper) {
        this.tatTypeRepository = tatTypeRepository;
        this.tatTypeMapper = tatTypeMapper;
    }

    /**
     * Save a tatType.
     *
     * @param tatTypeDTO the entity to save.
     * @return the persisted entity.
     */
    public TatTypeDTO save(TatTypeDTO tatTypeDTO) {
        log.debug("Request to save TatType : {}", tatTypeDTO);
        TatType tatType = tatTypeMapper.toEntity(tatTypeDTO);
        tatType = tatTypeRepository.save(tatType);
        return tatTypeMapper.toDto(tatType);
    }

    /**
     * Partially update a tatType.
     *
     * @param tatTypeDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<TatTypeDTO> partialUpdate(TatTypeDTO tatTypeDTO) {
        log.debug("Request to partially update TatType : {}", tatTypeDTO);

        return tatTypeRepository
            .findById(tatTypeDTO.getId())
            .map(
                existingTatType -> {
                    tatTypeMapper.partialUpdate(existingTatType, tatTypeDTO);

                    return existingTatType;
                }
            )
            .map(tatTypeRepository::save)
            .map(tatTypeMapper::toDto);
    }

    /**
     * Get all the tatTypes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TatTypeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TatTypes");
        return tatTypeRepository.findAll(pageable).map(tatTypeMapper::toDto);
    }

    /**
     * Get one tatType by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TatTypeDTO> findOne(Long id) {
        log.debug("Request to get TatType : {}", id);
        return tatTypeRepository.findById(id).map(tatTypeMapper::toDto);
    }

    /**
     * Delete the tatType by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete TatType : {}", id);
        tatTypeRepository.deleteById(id);
    }
}
