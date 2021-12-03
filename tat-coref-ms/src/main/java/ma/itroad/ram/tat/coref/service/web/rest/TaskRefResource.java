package ma.itroad.ram.tat.coref.service.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import ma.itroad.ram.tat.coref.service.domain.enumeration.GroupTaskEnum;
import ma.itroad.ram.tat.coref.service.domain.enumeration.PhaseEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ma.itroad.ram.tat.coref.service.domain.StandardTaskRef;
import ma.itroad.ram.tat.coref.service.domain.TaskRef;
import ma.itroad.ram.tat.coref.service.repository.TaskRefRepository;
import ma.itroad.ram.tat.coref.service.service.TaskRefService;
import ma.itroad.ram.tat.coref.service.service.dto.TaskRefDTO;
import ma.itroad.ram.tat.coref.service.web.rest.errors.BadRequestAlertException;
import ma.itroad.ram.tat.coref.service.web.rest.util.HeaderUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.PaginationUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.ResponseUtil;

import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * REST controller for managing {@link ma.itroad.ram.tat.coref.service.domain.TaskRef}.
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class TaskRefResource {
//    @Autowired
//    TaskRefService taskRefService;

    private final Logger log = LoggerFactory.getLogger(TaskRefResource.class);

    private static final String ENTITY_NAME = "taskRef";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TaskRefService taskRefService;

    private final TaskRefRepository taskRefRepository;

    public TaskRefResource(TaskRefService taskRefService, TaskRefRepository taskRefRepository) {
        this.taskRefService = taskRefService;
        this.taskRefRepository = taskRefRepository;
    }

    /**
     * {@code POST  /task-refs} : Create a new taskRef.
     *
     * @param taskRefDTO the taskRefDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new taskRefDTO, or with status {@code 400 (Bad Request)} if the taskRef has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/task-refs")
    public ResponseEntity<TaskRefDTO> createTaskRef(@Valid @RequestBody TaskRefDTO taskRefDTO) throws URISyntaxException {
        log.debug("REST request to save TaskRef : {}", taskRefDTO);
        if (taskRefDTO.getId() != null) {
            throw new BadRequestAlertException("A new taskRef cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TaskRefDTO result = taskRefService.save(taskRefDTO);
        return ResponseEntity
            .created(new URI("/api/task-refs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /task-refs/:id} : Updates an existing taskRef.
     *
     * @param id the id of the taskRefDTO to save.
     * @param taskRefDTO the taskRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated taskRefDTO,
     * or with status {@code 400 (Bad Request)} if the taskRefDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the taskRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/task-refs/{id}")
    public ResponseEntity<TaskRefDTO> updateTaskRef(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody TaskRefDTO taskRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to update TaskRef : {}, {}", id, taskRefDTO);
        if (taskRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, taskRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!taskRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        TaskRefDTO result = taskRefService.save(taskRefDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, taskRefDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /task-refs/:id} : Partial updates given fields of an existing taskRef, field will ignore if it is null
     *
     * @param id the id of the taskRefDTO to save.
     * @param taskRefDTO the taskRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated taskRefDTO,
     * or with status {@code 400 (Bad Request)} if the taskRefDTO is not valid,
     * or with status {@code 404 (Not Found)} if the taskRefDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the taskRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/task-refs/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<TaskRefDTO> partialUpdateTaskRef(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody TaskRefDTO taskRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update TaskRef partially : {}, {}", id, taskRefDTO);
        if (taskRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, taskRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!taskRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<TaskRefDTO> result = taskRefService.partialUpdate(taskRefDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, taskRefDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /task-refs} : get all the taskRefs.
     *
     * @parampageable the pagination information.
     * @parameagerload flag to eager load entities from relationships (This is applicable for many-to-many).
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of taskRefs in body.
     */
    @GetMapping("/task-refs")
    public ResponseEntity<List<TaskRef>> getAllTaskRefs(@RequestParam(name="eagerload",required = false, defaultValue = "true") boolean eagerload
    ) {
        log.debug("REST request to get a page of TaskRefs");
        List<TaskRef> page;
//        if (eagerload) {
//            page = taskRefService.findAllWithEagerRelationships(pageable);
//        } else {
            page = taskRefService.findAll();
//        }
       // HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest());
        return ResponseEntity.ok().body(page);
    }

    /**
     * {@code GET  /task-refs/:id} : get the "id" taskRef.
     *
     * @param id the id of the taskRefDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the taskRefDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/task-refs/{id}")
    public ResponseEntity<TaskRefDTO> getTaskRef(@PathVariable Long id) {
        log.debug("REST request to get TaskRef : {}", id);
        Optional<TaskRefDTO> taskRefDTO = taskRefService.findOne(id);
        return ResponseUtil.wrapOrNotFound(taskRefDTO);
    }

    /**
     * {@code DELETE  /task-refs/:id} : delete the "id" taskRef.
     *
     * @param id the id of the taskRefDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/task-refs/{id}")
    public ResponseEntity<Void> deleteTaskRef(@PathVariable Long id) {
        log.debug("REST request to delete TaskRef : {}", id);
        taskRefService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
    
    @GetMapping("/task-refs/flightType/{id}")
    public ResponseEntity<List<TaskRefDTO>> getAllTaskRefsByflightType(@PathVariable Long id){
       return null;
    }
    @GetMapping("/task-refs/delayReason/{id}")
    public ResponseEntity<List<TaskRefDTO>> getAllTaskRefsBydelayReason(@PathVariable Long id){
       return null;
    }
    
    @GetMapping("/task-refs/role/{id}")
    public ResponseEntity<List<TaskRefDTO>> getAllTaskRefsByRole(@PathVariable Long id){
       return null;
    }
    
    @GetMapping("/task/byTatAndAircraftAndFlightTypes")
    public List<StandardTaskRef> getTasksByFlightTypeAndAircraftTypeAndTatType(
            @RequestParam(name="legType",required = false,defaultValue = "") String legType,
            @RequestParam(name="tatType",required = false,defaultValue = "") String tatType,
            @RequestParam(name="aircraftSubType",required = false,defaultValue = "") String aircraftSubType){

        return taskRefService.getTasksByTatFlightAircraftTypes(tatType,legType,aircraftSubType);
    }
    
    @GetMapping("/task-refs/referenceDate/{str}")
    public ResponseEntity<List<TaskRefDTO>> getAllTaskRefsByReferenceDate(@PathVariable long str){
       return null;
    }

    @GetMapping("/task/getAllExceptionalTasks")
    public List<TaskRef> getAllExceptionalTasks(@RequestParam(value = "phase",required = false,defaultValue = "ARRIVEE_DEPART")String phase,
                                                @RequestParam(value = "groupTask",required = false,defaultValue = "ALL")String groupTask)

    {
        return taskRefService.getALlExceptionalTasks(phase,groupTask);
    }

    @GetMapping("/task/getExceptionalTask")
    public StandardTaskRef getExceptionalTaskById(@RequestParam("taskId")long taskId)
    {
        return taskRefService.getTaskById(taskId);
    }


}
