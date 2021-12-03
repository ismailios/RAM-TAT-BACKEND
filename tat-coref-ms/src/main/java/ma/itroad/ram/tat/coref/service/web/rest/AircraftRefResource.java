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

import ma.itroad.ram.tat.coref.service.domain.AircraftRef;
import ma.itroad.ram.tat.coref.service.domain.AircraftTypeRef;
import ma.itroad.ram.tat.coref.service.repository.AircraftRefRepository;
import ma.itroad.ram.tat.coref.service.service.AircraftRefService;
import ma.itroad.ram.tat.coref.service.service.AircraftTypeRefService;
import ma.itroad.ram.tat.coref.service.service.dto.AircraftRefDTO;
import ma.itroad.ram.tat.coref.service.service.dto.AircraftTypeRefDTO;
import ma.itroad.ram.tat.coref.service.web.rest.errors.BadRequestAlertException;
import ma.itroad.ram.tat.coref.service.web.rest.util.HeaderUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.PaginationUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.ResponseUtil;


/**
 * REST controller for managing {@link ma.itroad.ram.tat.coref.service.domain.AircraftRef}.
 */
@RestController
@RequestMapping("/api")
public class AircraftRefResource {

    private final Logger log = LoggerFactory.getLogger(AircraftRefResource.class);

    private static final String ENTITY_NAME = "aircraftRef";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AircraftRefService aircraftRefService;
    private final AircraftTypeRefService aircraftTypeRefService;
    private final AircraftRefRepository aircraftRefRepository;

    public AircraftRefResource(AircraftRefService aircraftRefService, AircraftRefRepository aircraftRefRepository, AircraftTypeRefService aircraftTypeRefService) {
        this.aircraftRefService = aircraftRefService;
        this.aircraftRefRepository = aircraftRefRepository;
        this.aircraftTypeRefService = aircraftTypeRefService;
    }

    /**
     * {@code POST  /aircraft-refs} : Create a new aircraftRef.
     *
     * @param aircraftRefDTO the aircraftRefDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new aircraftRefDTO, or with status {@code 400 (Bad Request)} if the aircraftRef has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/aircraft-refs")
    public ResponseEntity<AircraftRefDTO> createAircraftRef(@RequestBody AircraftRefDTO aircraftRefDTO) throws URISyntaxException {
        log.debug("REST request to save AircraftRef : {}", aircraftRefDTO);
        if (aircraftRefDTO.getId() != null) {
            throw new BadRequestAlertException("A new aircraftRef cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AircraftRefDTO result = aircraftRefService.save(aircraftRefDTO);
        return ResponseEntity
            .created(new URI("/api/aircraft-refs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /aircraft-refs/:id} : Updates an existing aircraftRef.
     *
     * @param id the id of the aircraftRefDTO to save.
     * @param aircraftRefDTO the aircraftRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated aircraftRefDTO,
     * or with status {@code 400 (Bad Request)} if the aircraftRefDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the aircraftRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/aircraft-refs/{id}")
    public ResponseEntity<AircraftRefDTO> updateAircraftRef(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody AircraftRefDTO aircraftRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to update AircraftRef : {}, {}", id, aircraftRefDTO);
        if (aircraftRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, aircraftRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!aircraftRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        AircraftRefDTO result = aircraftRefService.save(aircraftRefDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, aircraftRefDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /aircraft-refs/:id} : Partial updates given fields of an existing aircraftRef, field will ignore if it is null
     *
     * @param id the id of the aircraftRefDTO to save.
     * @param aircraftRefDTO the aircraftRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated aircraftRefDTO,
     * or with status {@code 400 (Bad Request)} if the aircraftRefDTO is not valid,
     * or with status {@code 404 (Not Found)} if the aircraftRefDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the aircraftRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/aircraft-refs/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<AircraftRefDTO> partialUpdateAircraftRef(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody AircraftRefDTO aircraftRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update AircraftRef partially : {}, {}", id, aircraftRefDTO);
        if (aircraftRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, aircraftRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!aircraftRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<AircraftRefDTO> result = aircraftRefService.partialUpdate(aircraftRefDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, aircraftRefDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /aircraft-refs} : get all the aircraftRefs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of aircraftRefs in body.
     */
    @GetMapping("/aircraft-refs")
    public ResponseEntity<List<AircraftRefDTO>> getAllAircraftRefs(Pageable pageable) {
        log.debug("REST request to get a page of AircraftRefs");
        Page<AircraftRefDTO> page = aircraftRefService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /aircraft-refs/:id} : get the "id" aircraftRef.
     *
     * @param id the id of the aircraftRefDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the aircraftRefDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/aircraft-refs/{id}")
    public ResponseEntity<AircraftRefDTO> getAircraftRef(@PathVariable Long id) {
        log.debug("REST request to get AircraftRef : {}", id);
        Optional<AircraftRefDTO> aircraftRefDTO = aircraftRefService.findOne(id);
        return ResponseUtil.wrapOrNotFound(aircraftRefDTO);
    }

    /**
     * {@code DELETE  /aircraft-refs/:id} : delete the "id" aircraftRef.
     *
     * @param id the id of the aircraftRefDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/aircraft-refs/{id}")
    public ResponseEntity<Void> deleteAircraftRef(@PathVariable Long id) {
        log.debug("REST request to delete AircraftRef : {}", id);
        aircraftRefService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }

	/*
	 * @GetMapping("/aircraft-refs/code/{code}") public
	 * ResponseEntity<AircraftRefDTO> getTatMax(@PathVariable String code) {
	 * AircraftRef aircraftRef = aircraftRefService.getaircraftRef(code);
	 * log.debug("REST request to get AircraftRef : {}", aircraftRef.getId());
	 * Optional<AircraftRefDTO> aircraftRefDTO =
	 * aircraftRefService.findOne(aircraftRef.getId()); return
	 * ResponseUtil.wrapOrNotFound(aircraftRefDTO);
	 * 
	 * }
	 */
    @GetMapping("/aircraft-refs/code/{code}")
    public ResponseEntity<AircraftTypeRefDTO> getTatMax(@PathVariable String code) {
    	   AircraftRef aircraftRef = aircraftRefService.getaircraftRef(code);
    	   AircraftTypeRef aircraftTypeRef = aircraftRef.getAircraftTypeRef();
    	   log.debug("REST request to get AircraftRef : {}", aircraftTypeRef.getId());
           Optional<AircraftTypeRefDTO> aircraftTypeRefDTO = aircraftTypeRefService.findOne(aircraftTypeRef.getId());
           return ResponseUtil.wrapOrNotFound(aircraftTypeRefDTO);

    }
    
    @GetMapping("/aircraft-refs/aircraftTypeRef/{id}")
    public ResponseEntity<AircraftRefDTO> getAircraftByAircraftTypeRef(@PathVariable long id) {
    	
    	return null;
    	
    }
}
