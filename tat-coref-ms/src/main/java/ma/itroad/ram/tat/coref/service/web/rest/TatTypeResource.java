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

import ma.itroad.ram.tat.coref.service.repository.TatTypeRepository;
import ma.itroad.ram.tat.coref.service.service.TatTypeService;
import ma.itroad.ram.tat.coref.service.service.dto.TatTypeDTO;
import ma.itroad.ram.tat.coref.service.web.rest.errors.BadRequestAlertException;
import ma.itroad.ram.tat.coref.service.web.rest.util.HeaderUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.PaginationUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.ResponseUtil;

/**
 * REST controller for managing {@link ma.itroad.ram.tat.coref.service.domain.TatType}.
 */
@RestController
@RequestMapping("/api")
public class TatTypeResource {

    private final Logger log = LoggerFactory.getLogger(TatTypeResource.class);

    private static final String ENTITY_NAME = "tatType";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TatTypeService tatTypeService;

    private final TatTypeRepository tatTypeRepository;

    public TatTypeResource(TatTypeService tatTypeService, TatTypeRepository tatTypeRepository) {
        this.tatTypeService = tatTypeService;
        this.tatTypeRepository = tatTypeRepository;
    }

    /**
     * {@code POST  /tat-types} : Create a new tatType.
     *
     * @param tatTypeDTO the tatTypeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new tatTypeDTO, or with status {@code 400 (Bad Request)} if the tatType has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/tat-types")
    public ResponseEntity<TatTypeDTO> createTatType(@RequestBody TatTypeDTO tatTypeDTO) throws URISyntaxException {
        log.debug("REST request to save TatType : {}", tatTypeDTO);
        if (tatTypeDTO.getId() != null) {
            throw new BadRequestAlertException("A new tatType cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TatTypeDTO result = tatTypeService.save(tatTypeDTO);
        return ResponseEntity
            .created(new URI("/api/tat-types/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /tat-types/:id} : Updates an existing tatType.
     *
     * @param id the id of the tatTypeDTO to save.
     * @param tatTypeDTO the tatTypeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tatTypeDTO,
     * or with status {@code 400 (Bad Request)} if the tatTypeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the tatTypeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/tat-types/{id}")
    public ResponseEntity<TatTypeDTO> updateTatType(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody TatTypeDTO tatTypeDTO
    ) throws URISyntaxException {
        log.debug("REST request to update TatType : {}, {}", id, tatTypeDTO);
        if (tatTypeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, tatTypeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!tatTypeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        TatTypeDTO result = tatTypeService.save(tatTypeDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, tatTypeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /tat-types/:id} : Partial updates given fields of an existing tatType, field will ignore if it is null
     *
     * @param id the id of the tatTypeDTO to save.
     * @param tatTypeDTO the tatTypeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tatTypeDTO,
     * or with status {@code 400 (Bad Request)} if the tatTypeDTO is not valid,
     * or with status {@code 404 (Not Found)} if the tatTypeDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the tatTypeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/tat-types/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<TatTypeDTO> partialUpdateTatType(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody TatTypeDTO tatTypeDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update TatType partially : {}, {}", id, tatTypeDTO);
        if (tatTypeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, tatTypeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!tatTypeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<TatTypeDTO> result = tatTypeService.partialUpdate(tatTypeDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, tatTypeDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /tat-types} : get all the tatTypes.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tatTypes in body.
     */
    @GetMapping("/tat-types")
    public ResponseEntity<List<TatTypeDTO>> getAllTatTypes(Pageable pageable) {
        log.debug("REST request to get a page of TatTypes");
        Page<TatTypeDTO> page = tatTypeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /tat-types/:id} : get the "id" tatType.
     *
     * @param id the id of the tatTypeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the tatTypeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/tat-types/{id}")
    public ResponseEntity<TatTypeDTO> getTatType(@PathVariable Long id) {
        log.debug("REST request to get TatType : {}", id);
        Optional<TatTypeDTO> tatTypeDTO = tatTypeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tatTypeDTO);
    }

    /**
     * {@code DELETE  /tat-types/:id} : delete the "id" tatType.
     *
     * @param id the id of the tatTypeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/tat-types/{id}")
    public ResponseEntity<Void> deleteTatType(@PathVariable Long id) {
        log.debug("REST request to delete TatType : {}", id);
        tatTypeService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
    
    @GetMapping("/tat-types/task/{str}")
    public ResponseEntity<List<TatTypeDTO>> getAllTatTypesByTask(@PathVariable String str) {
    
        return null;
    }
    
    @GetMapping("/tat-types/TatType/{str}")
    public ResponseEntity<List<TatTypeDTO>> getAllTatTypesByTatType(@PathVariable String str) {
    
        return null;
    }
}
