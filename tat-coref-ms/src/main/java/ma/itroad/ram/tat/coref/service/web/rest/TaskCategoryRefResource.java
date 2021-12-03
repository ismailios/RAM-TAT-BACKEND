package ma.itroad.ram.tat.coref.service.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ma.itroad.ram.tat.coref.service.repository.TaskCategoryRefRepository;
import ma.itroad.ram.tat.coref.service.service.TaskCategoryRefService;
import ma.itroad.ram.tat.coref.service.service.dto.TaskCategoryRefDTO;
import ma.itroad.ram.tat.coref.service.web.rest.errors.BadRequestAlertException;
import ma.itroad.ram.tat.coref.service.web.rest.util.HeaderUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.PaginationUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.ResponseUtil;

/**
 * REST controller for managing {@link ma.itroad.ram.tat.coref.service.domain.TaskCategoryRef}.
 */
@RestController
@RequestMapping("/api")
public class TaskCategoryRefResource {

    private final Logger log = LoggerFactory.getLogger(TaskCategoryRefResource.class);

    private static final String ENTITY_NAME = "taskCategoryRef";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TaskCategoryRefService taskCategoryRefService;

    private final TaskCategoryRefRepository taskCategoryRefRepository;

    public TaskCategoryRefResource(TaskCategoryRefService taskCategoryRefService, TaskCategoryRefRepository taskCategoryRefRepository) {
        this.taskCategoryRefService = taskCategoryRefService;
        this.taskCategoryRefRepository = taskCategoryRefRepository;
    }

    /**
     * {@code POST  /task-category-refs} : Create a new taskCategoryRef.
     *
     * @param taskCategoryRefDTO the taskCategoryRefDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new taskCategoryRefDTO, or with status {@code 400 (Bad Request)} if the taskCategoryRef has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/task-category-refs")
    public ResponseEntity<TaskCategoryRefDTO> createTaskCategoryRef(@RequestBody TaskCategoryRefDTO taskCategoryRefDTO)
        throws URISyntaxException {
        log.debug("REST request to save TaskCategoryRef : {}", taskCategoryRefDTO);
        if (taskCategoryRefDTO.getId() != null) {
            throw new BadRequestAlertException("A new taskCategoryRef cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TaskCategoryRefDTO result = taskCategoryRefService.save(taskCategoryRefDTO);
        return ResponseEntity
            .created(new URI("/api/task-category-refs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /task-category-refs/:id} : Updates an existing taskCategoryRef.
     *
     * @param id the id of the taskCategoryRefDTO to save.
     * @param taskCategoryRefDTO the taskCategoryRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated taskCategoryRefDTO,
     * or with status {@code 400 (Bad Request)} if the taskCategoryRefDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the taskCategoryRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/task-category-refs/{id}")
    public ResponseEntity<TaskCategoryRefDTO> updateTaskCategoryRef(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody TaskCategoryRefDTO taskCategoryRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to update TaskCategoryRef : {}, {}", id, taskCategoryRefDTO);
        if (taskCategoryRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, taskCategoryRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!taskCategoryRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        TaskCategoryRefDTO result = taskCategoryRefService.save(taskCategoryRefDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, taskCategoryRefDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /task-category-refs/:id} : Partial updates given fields of an existing taskCategoryRef, field will ignore if it is null
     *
     * @param id the id of the taskCategoryRefDTO to save.
     * @param taskCategoryRefDTO the taskCategoryRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated taskCategoryRefDTO,
     * or with status {@code 400 (Bad Request)} if the taskCategoryRefDTO is not valid,
     * or with status {@code 404 (Not Found)} if the taskCategoryRefDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the taskCategoryRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/task-category-refs/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<TaskCategoryRefDTO> partialUpdateTaskCategoryRef(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody TaskCategoryRefDTO taskCategoryRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update TaskCategoryRef partially : {}, {}", id, taskCategoryRefDTO);
        if (taskCategoryRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, taskCategoryRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!taskCategoryRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<TaskCategoryRefDTO> result = taskCategoryRefService.partialUpdate(taskCategoryRefDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, taskCategoryRefDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /task-category-refs} : get all the taskCategoryRefs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of taskCategoryRefs in body.
     */
    @GetMapping("/task-category-refs")
    public ResponseEntity<List<TaskCategoryRefDTO>> getAllTaskCategoryRefs(Pageable pageable) {
        log.debug("REST request to get a page of TaskCategoryRefs");
        Page<TaskCategoryRefDTO> page = taskCategoryRefService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /task-category-refs/:id} : get the "id" taskCategoryRef.
     *
     * @param id the id of the taskCategoryRefDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the taskCategoryRefDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/task-category-refs/{id}")
    public ResponseEntity<TaskCategoryRefDTO> getTaskCategoryRef(@PathVariable Long id) {
        log.debug("REST request to get TaskCategoryRef : {}", id);
        Optional<TaskCategoryRefDTO> taskCategoryRefDTO = taskCategoryRefService.findOne(id);
        return ResponseUtil.wrapOrNotFound(taskCategoryRefDTO);
    }

    /**
     * {@code DELETE  /task-category-refs/:id} : delete the "id" taskCategoryRef.
     *
     * @param id the id of the taskCategoryRefDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/task-category-refs/{id}")
    public ResponseEntity<Void> deleteTaskCategoryRef(@PathVariable Long id) {
        log.debug("REST request to delete TaskCategoryRef : {}", id);
        taskCategoryRefService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
