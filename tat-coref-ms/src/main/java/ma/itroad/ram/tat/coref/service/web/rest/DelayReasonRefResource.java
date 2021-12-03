package ma.itroad.ram.tat.coref.service.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import ma.itroad.ram.tat.coref.service.domain.DelayReasonRef;
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

import ma.itroad.ram.tat.coref.service.repository.DelayReasonRefRepository;
import ma.itroad.ram.tat.coref.service.service.DelayReasonRefService;
import ma.itroad.ram.tat.coref.service.service.dto.DelayReasonRefDTO;
import ma.itroad.ram.tat.coref.service.web.rest.errors.BadRequestAlertException;
import ma.itroad.ram.tat.coref.service.web.rest.util.HeaderUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.PaginationUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.ResponseUtil;

/**
 * REST controller for managing {@link ma.itroad.ram.tat.coref.service.domain.DelayReasonRef}.
 */
@RestController
@RequestMapping("/api")
public class DelayReasonRefResource {

    private final Logger log = LoggerFactory.getLogger(DelayReasonRefResource.class);

    private static final String ENTITY_NAME = "delayReasonRef";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DelayReasonRefService delayReasonRefService;

    private final DelayReasonRefRepository delayReasonRefRepository;

    public DelayReasonRefResource(DelayReasonRefService delayReasonRefService, DelayReasonRefRepository delayReasonRefRepository) {
        this.delayReasonRefService = delayReasonRefService;
        this.delayReasonRefRepository = delayReasonRefRepository;
    }

    /**
     * {@code POST  /delay-reason-refs} : Create a new delayReasonRef.
     *
     * @param delayReasonRefDTO the delayReasonRefDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new delayReasonRefDTO, or with status {@code 400 (Bad Request)} if the delayReasonRef has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/delay-reason-refs")
    public ResponseEntity<DelayReasonRefDTO> createDelayReasonRef(@RequestBody DelayReasonRefDTO delayReasonRefDTO)
        throws URISyntaxException {
        log.debug("REST request to save DelayReasonRef : {}", delayReasonRefDTO);
        if (delayReasonRefDTO.getId() != null) {
            throw new BadRequestAlertException("A new delayReasonRef cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DelayReasonRefDTO result = delayReasonRefService.save(delayReasonRefDTO);
        return ResponseEntity
            .created(new URI("/api/delay-reason-refs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /delay-reason-refs/:id} : Updates an existing delayReasonRef.
     *
     * @param id the id of the delayReasonRefDTO to save.
     * @param delayReasonRefDTO the delayReasonRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated delayReasonRefDTO,
     * or with status {@code 400 (Bad Request)} if the delayReasonRefDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the delayReasonRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/delay-reason-refs/{id}")
    public ResponseEntity<DelayReasonRefDTO> updateDelayReasonRef(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody DelayReasonRefDTO delayReasonRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to update DelayReasonRef : {}, {}", id, delayReasonRefDTO);
        if (delayReasonRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, delayReasonRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!delayReasonRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        DelayReasonRefDTO result = delayReasonRefService.save(delayReasonRefDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, delayReasonRefDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /delay-reason-refs/:id} : Partial updates given fields of an existing delayReasonRef, field will ignore if it is null
     *
     * @param id the id of the delayReasonRefDTO to save.
     * @param delayReasonRefDTO the delayReasonRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated delayReasonRefDTO,
     * or with status {@code 400 (Bad Request)} if the delayReasonRefDTO is not valid,
     * or with status {@code 404 (Not Found)} if the delayReasonRefDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the delayReasonRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/delay-reason-refs/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<DelayReasonRefDTO> partialUpdateDelayReasonRef(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody DelayReasonRefDTO delayReasonRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update DelayReasonRef partially : {}, {}", id, delayReasonRefDTO);
        if (delayReasonRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, delayReasonRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!delayReasonRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<DelayReasonRefDTO> result = delayReasonRefService.partialUpdate(delayReasonRefDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, delayReasonRefDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /delay-reason-refs} : get all the delayReasonRefs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of delayReasonRefs in body.
     */
    @GetMapping("/delay-reason-refs")
    public ResponseEntity<List<DelayReasonRefDTO>> getAllDelayReasonRefs(Pageable pageable) {
        log.debug("REST request to get a page of DelayReasonRefs");
        Page<DelayReasonRefDTO> page = delayReasonRefService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /delay-reason-refs/:id} : get the "id" delayReasonRef.
     *
     * @param id the id of the delayReasonRefDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the delayReasonRefDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/delay-reason-refs/{id}")
    public ResponseEntity<DelayReasonRefDTO> getDelayReasonRef(@PathVariable Long id) {
        log.debug("REST request to get DelayReasonRef : {}", id);
        Optional<DelayReasonRefDTO> delayReasonRefDTO = delayReasonRefService.findOne(id);
        return ResponseUtil.wrapOrNotFound(delayReasonRefDTO);
    }

    /**
     * {@code DELETE  /delay-reason-refs/:id} : delete the "id" delayReasonRef.
     *
     * @param id the id of the delayReasonRefDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/delay-reason-refs/{id}")
    public ResponseEntity<Void> deleteDelayReasonRef(@PathVariable Long id) {
        log.debug("REST request to delete DelayReasonRef : {}", id);
        delayReasonRefService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
    
    @GetMapping("/delay-reason-refs/task/{id}")
    public ResponseEntity<Void> getAlldelayReasonsByTask(@PathVariable Long id) {
    	return null;
    }


    @GetMapping("/delay-reason-by-task-id")
    public List<DelayReasonRef> getDelayReasonListByTask(@RequestParam("taskId") long taskId){
        return delayReasonRefService.getDelayReasonListByTask(taskId);
    }

}
