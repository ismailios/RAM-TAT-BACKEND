package ma.itroad.ram.tat.coref.service.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.itroad.ram.tat.coref.service.domain.TaskCategoryRef;
import ma.itroad.ram.tat.coref.service.repository.TaskCategoryRefRepository;
import ma.itroad.ram.tat.coref.service.service.dto.TaskCategoryRefDTO;
import ma.itroad.ram.tat.coref.service.service.mapper.TaskCategoryRefMapper;

/**
 * Service Implementation for managing {@link TaskCategoryRef}.
 */
@Service
@Transactional
public class TaskCategoryRefService {

    private final Logger log = LoggerFactory.getLogger(TaskCategoryRefService.class);

    private final TaskCategoryRefRepository taskCategoryRefRepository;

    private final TaskCategoryRefMapper taskCategoryRefMapper;

    public TaskCategoryRefService(TaskCategoryRefRepository taskCategoryRefRepository, TaskCategoryRefMapper taskCategoryRefMapper) {
        this.taskCategoryRefRepository = taskCategoryRefRepository;
        this.taskCategoryRefMapper = taskCategoryRefMapper;
    }

    /**
     * Save a taskCategoryRef.
     *
     * @param taskCategoryRefDTO the entity to save.
     * @return the persisted entity.
     */
    public TaskCategoryRefDTO save(TaskCategoryRefDTO taskCategoryRefDTO) {
        log.debug("Request to save TaskCategoryRef : {}", taskCategoryRefDTO);
        TaskCategoryRef taskCategoryRef = taskCategoryRefMapper.toEntity(taskCategoryRefDTO);
        taskCategoryRef = taskCategoryRefRepository.save(taskCategoryRef);
        return taskCategoryRefMapper.toDto(taskCategoryRef);
    }

    /**
     * Partially update a taskCategoryRef.
     *
     * @param taskCategoryRefDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<TaskCategoryRefDTO> partialUpdate(TaskCategoryRefDTO taskCategoryRefDTO) {
        log.debug("Request to partially update TaskCategoryRef : {}", taskCategoryRefDTO);

        return taskCategoryRefRepository
            .findById(taskCategoryRefDTO.getId())
            .map(
                existingTaskCategoryRef -> {
                    taskCategoryRefMapper.partialUpdate(existingTaskCategoryRef, taskCategoryRefDTO);

                    return existingTaskCategoryRef;
                }
            )
            .map(taskCategoryRefRepository::save)
            .map(taskCategoryRefMapper::toDto);
    }

    /**
     * Get all the taskCategoryRefs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TaskCategoryRefDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TaskCategoryRefs");
        return taskCategoryRefRepository.findAll(pageable).map(taskCategoryRefMapper::toDto);
    }

    /**
     * Get one taskCategoryRef by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TaskCategoryRefDTO> findOne(Long id) {
        log.debug("Request to get TaskCategoryRef : {}", id);
        return taskCategoryRefRepository.findById(id).map(taskCategoryRefMapper::toDto);
    }

    /**
     * Delete the taskCategoryRef by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete TaskCategoryRef : {}", id);
        taskCategoryRefRepository.deleteById(id);
    }
}
