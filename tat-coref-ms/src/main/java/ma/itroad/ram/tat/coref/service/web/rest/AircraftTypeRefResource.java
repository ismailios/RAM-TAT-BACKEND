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

import ma.itroad.ram.tat.coref.service.repository.AircraftTypeRefRepository;
import ma.itroad.ram.tat.coref.service.service.AircraftTypeRefService;
import ma.itroad.ram.tat.coref.service.service.dto.AircraftRefDTO;
import ma.itroad.ram.tat.coref.service.service.dto.AircraftTypeRefDTO;
import ma.itroad.ram.tat.coref.service.web.rest.errors.BadRequestAlertException;
import ma.itroad.ram.tat.coref.service.web.rest.util.HeaderUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.PaginationUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.ResponseUtil;

/**
 * REST controller for managing {@link ma.itroad.ram.tat.coref.service.domain.AircraftTypeRef}.
 */
@RestController
@RequestMapping("/api")
public class AircraftTypeRefResource {

    private final Logger log = LoggerFactory.getLogger(AircraftTypeRefResource.class);

    private static final String ENTITY_NAME = "aircraftTypeRef";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AircraftTypeRefService aircraftTypeRefService;

    private final AircraftTypeRefRepository aircraftTypeRefRepository;

    public AircraftTypeRefResource(AircraftTypeRefService aircraftTypeRefService, AircraftTypeRefRepository aircraftTypeRefRepository) {
        this.aircraftTypeRefService = aircraftTypeRefService;
        this.aircraftTypeRefRepository = aircraftTypeRefRepository;
    }

    /**
     * {@code POST  /aircraft-type-refs} : Create a new aircraftTypeRef.
     *
     * @param aircraftTypeRefDTO the aircraftTypeRefDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new aircraftTypeRefDTO, or with status {@code 400 (Bad Request)} if the aircraftTypeRef has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/aircraft-type-refs")
    public ResponseEntity<AircraftTypeRefDTO> createAircraftTypeRef(@RequestBody AircraftTypeRefDTO aircraftTypeRefDTO)
        throws URISyntaxException {
        log.debug("REST request to save AircraftTypeRef : {}", aircraftTypeRefDTO);
        if (aircraftTypeRefDTO.getId() != null) {
            throw new BadRequestAlertException("A new aircraftTypeRef cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AircraftTypeRefDTO result = aircraftTypeRefService.save(aircraftTypeRefDTO);
        return ResponseEntity
            .created(new URI("/api/aircraft-type-refs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /aircraft-type-refs/:id} : Updates an existing aircraftTypeRef.
     *
     * @param id the id of the aircraftTypeRefDTO to save.
     * @param aircraftTypeRefDTO the aircraftTypeRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated aircraftTypeRefDTO,
     * or with status {@code 400 (Bad Request)} if the aircraftTypeRefDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the aircraftTypeRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/aircraft-type-refs/{id}")
    public ResponseEntity<AircraftTypeRefDTO> updateAircraftTypeRef(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody AircraftTypeRefDTO aircraftTypeRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to update AircraftTypeRef : {}, {}", id, aircraftTypeRefDTO);
        if (aircraftTypeRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, aircraftTypeRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!aircraftTypeRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        AircraftTypeRefDTO result = aircraftTypeRefService.save(aircraftTypeRefDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, aircraftTypeRefDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /aircraft-type-refs/:id} : Partial updates given fields of an existing aircraftTypeRef, field will ignore if it is null
     *
     * @param id the id of the aircraftTypeRefDTO to save.
     * @param aircraftTypeRefDTO the aircraftTypeRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated aircraftTypeRefDTO,
     * or with status {@code 400 (Bad Request)} if the aircraftTypeRefDTO is not valid,
     * or with status {@code 404 (Not Found)} if the aircraftTypeRefDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the aircraftTypeRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/aircraft-type-refs/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<AircraftTypeRefDTO> partialUpdateAircraftTypeRef(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody AircraftTypeRefDTO aircraftTypeRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update AircraftTypeRef partially : {}, {}", id, aircraftTypeRefDTO);
        if (aircraftTypeRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, aircraftTypeRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!aircraftTypeRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<AircraftTypeRefDTO> result = aircraftTypeRefService.partialUpdate(aircraftTypeRefDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, aircraftTypeRefDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /aircraft-type-refs} : get all the aircraftTypeRefs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of aircraftTypeRefs in body.
     */
    @GetMapping("/aircraft-type-refs")
    public ResponseEntity<List<AircraftTypeRefDTO>> getAllAircraftTypeRefs(Pageable pageable) {
        log.debug("REST request to get a page of AircraftTypeRefs");
        Page<AircraftTypeRefDTO> page = aircraftTypeRefService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /aircraft-type-refs/:id} : get the "id" aircraftTypeRef.
     *
     * @param id the id of the aircraftTypeRefDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the aircraftTypeRefDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/aircraft-type-refs/{id}")
    public ResponseEntity<AircraftTypeRefDTO> getAircraftTypeRef(@PathVariable Long id) {
        log.debug("REST request to get AircraftTypeRef : {}", id);
        Optional<AircraftTypeRefDTO> aircraftTypeRefDTO = aircraftTypeRefService.findOne(id);
        return ResponseUtil.wrapOrNotFound(aircraftTypeRefDTO);
    }

    /**
     * {@code DELETE  /aircraft-type-refs/:id} : delete the "id" aircraftTypeRef.
     *
     * @param id the id of the aircraftTypeRefDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/aircraft-type-refs/{id}")
    public ResponseEntity<Void> deleteAircraftTypeRef(@PathVariable Long id) {
        log.debug("REST request to delete AircraftTypeRef : {}", id);
        aircraftTypeRefService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
    
    
    
    @GetMapping("/aircraftTypeRef/FlightType/{str}")
    public ResponseEntity<AircraftRefDTO> getAircraftByFlightType(@PathVariable String str) {
    	
    	return null;
    	
    }
    @GetMapping("/tatMaxBySubType/{subType}")
    public long getTatMaxBySubtype(@PathVariable("subType") String subType, @RequestHeader("Authorization") String header){
    	//System.out.println(header);
        return aircraftTypeRefService.getTatMaxBySubtype(subType);
    }
    @GetMapping("/aircraftTypeBySubType/{subType}")
    public String getAircraftTypeBySubtype(@PathVariable("subType") String subType){
        return aircraftTypeRefService.getAircraftTypeBySubtype(subType);
    }


    
}
