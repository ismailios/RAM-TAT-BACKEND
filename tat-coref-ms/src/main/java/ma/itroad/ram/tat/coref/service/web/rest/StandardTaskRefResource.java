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

import ma.itroad.ram.tat.coref.service.repository.StandardTaskRefRepository;
import ma.itroad.ram.tat.coref.service.service.StandardTaskRefService;
import ma.itroad.ram.tat.coref.service.service.dto.StandardTaskRefDTO;
import ma.itroad.ram.tat.coref.service.web.rest.errors.BadRequestAlertException;
import ma.itroad.ram.tat.coref.service.web.rest.util.HeaderUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.PaginationUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.ResponseUtil;

/**
 * REST controller for managing {@link ma.itroad.ram.tat.coref.service.domain.StandardTaskRef}.
 */
@RestController
@RequestMapping("/api")
public class StandardTaskRefResource {

    private final Logger log = LoggerFactory.getLogger(StandardTaskRefResource.class);

    private static final String ENTITY_NAME = "standardTaskRef";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final StandardTaskRefService standardTaskRefService;

    private final StandardTaskRefRepository standardTaskRefRepository;

    public StandardTaskRefResource(StandardTaskRefService standardTaskRefService, StandardTaskRefRepository standardTaskRefRepository) {
        this.standardTaskRefService = standardTaskRefService;
        this.standardTaskRefRepository = standardTaskRefRepository;
    }

    /**
     * {@code POST  /standard-task-refs} : Create a new standardTaskRef.
     *
     * @param standardTaskRefDTO the standardTaskRefDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new standardTaskRefDTO, or with status {@code 400 (Bad Request)} if the standardTaskRef has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/standard-task-refs")
    public ResponseEntity<StandardTaskRefDTO> createStandardTaskRef(@RequestBody StandardTaskRefDTO standardTaskRefDTO)
        throws URISyntaxException {
        log.debug("REST request to save StandardTaskRef : {}", standardTaskRefDTO);
        if (standardTaskRefDTO.getId() != null) {
            throw new BadRequestAlertException("A new standardTaskRef cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StandardTaskRefDTO result = standardTaskRefService.save(standardTaskRefDTO);
        return ResponseEntity
            .created(new URI("/api/standard-task-refs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /standard-task-refs/:id} : Updates an existing standardTaskRef.
     *
     * @param id the id of the standardTaskRefDTO to save.
     * @param standardTaskRefDTO the standardTaskRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated standardTaskRefDTO,
     * or with status {@code 400 (Bad Request)} if the standardTaskRefDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the standardTaskRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/standard-task-refs/{id}")
    public ResponseEntity<StandardTaskRefDTO> updateStandardTaskRef(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody StandardTaskRefDTO standardTaskRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to update StandardTaskRef : {}, {}", id, standardTaskRefDTO);
        if (standardTaskRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, standardTaskRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!standardTaskRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        StandardTaskRefDTO result = standardTaskRefService.save(standardTaskRefDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, standardTaskRefDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /standard-task-refs/:id} : Partial updates given fields of an existing standardTaskRef, field will ignore if it is null
     *
     * @param id the id of the standardTaskRefDTO to save.
     * @param standardTaskRefDTO the standardTaskRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated standardTaskRefDTO,
     * or with status {@code 400 (Bad Request)} if the standardTaskRefDTO is not valid,
     * or with status {@code 404 (Not Found)} if the standardTaskRefDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the standardTaskRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/standard-task-refs/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<StandardTaskRefDTO> partialUpdateStandardTaskRef(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody StandardTaskRefDTO standardTaskRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update StandardTaskRef partially : {}, {}", id, standardTaskRefDTO);
        if (standardTaskRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, standardTaskRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!standardTaskRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<StandardTaskRefDTO> result = standardTaskRefService.partialUpdate(standardTaskRefDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, standardTaskRefDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /standard-task-refs} : get all the standardTaskRefs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of standardTaskRefs in body.
     */
    @GetMapping("/standard-task-refs")
    public ResponseEntity<List<StandardTaskRefDTO>> getAllStandardTaskRefs(Pageable pageable) {
        log.debug("REST request to get a page of StandardTaskRefs");
        Page<StandardTaskRefDTO> page = standardTaskRefService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /standard-task-refs/:id} : get the "id" standardTaskRef.
     *
     * @param id the id of the standardTaskRefDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the standardTaskRefDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/standard-task-refs/{id}")
    public ResponseEntity<StandardTaskRefDTO> getStandardTaskRef(@PathVariable Long id) {
        log.debug("REST request to get StandardTaskRef : {}", id);
        Optional<StandardTaskRefDTO> standardTaskRefDTO = standardTaskRefService.findOne(id);
        return ResponseUtil.wrapOrNotFound(standardTaskRefDTO);
    }

    /**
     * {@code DELETE  /standard-task-refs/:id} : delete the "id" standardTaskRef.
     *
     * @param id the id of the standardTaskRefDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/standard-task-refs/{id}")
    public ResponseEntity<Void> deleteStandardTaskRef(@PathVariable Long id) {
        log.debug("REST request to delete StandardTaskRef : {}", id);
        standardTaskRefService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
    
    @GetMapping("/standard-task-refs/FlightType/{str}")
    public ResponseEntity<List<StandardTaskRefDTO>> getAllStandardTaskRefsByFlightType(@PathVariable String str) {
        return null;
    }
    
    @GetMapping("/standard-task-refs/task/{id}")
    public ResponseEntity<List<StandardTaskRefDTO>> getAllStandardTaskRefsBytask(@PathVariable long id) {
        return null;
    }
}
