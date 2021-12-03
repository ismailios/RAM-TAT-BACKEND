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

import ma.itroad.ram.tat.coref.service.repository.FlightTypeRefRepository;
import ma.itroad.ram.tat.coref.service.service.FlightTypeRefService;
import ma.itroad.ram.tat.coref.service.service.dto.FlightTypeRefDTO;
import ma.itroad.ram.tat.coref.service.web.rest.errors.BadRequestAlertException;
import ma.itroad.ram.tat.coref.service.web.rest.util.HeaderUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.PaginationUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.ResponseUtil;

/**
 * REST controller for managing {@link ma.itroad.ram.tat.coref.service.domain.FlightTypeRef}.
 */
@RestController
@RequestMapping("/api")
public class FlightTypeRefResource {

    private final Logger log = LoggerFactory.getLogger(FlightTypeRefResource.class);

    private static final String ENTITY_NAME = "flightTypeRef";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FlightTypeRefService flightTypeRefService;

    private final FlightTypeRefRepository flightTypeRefRepository;

    public FlightTypeRefResource(FlightTypeRefService flightTypeRefService, FlightTypeRefRepository flightTypeRefRepository) {
        this.flightTypeRefService = flightTypeRefService;
        this.flightTypeRefRepository = flightTypeRefRepository;
    }

    /**
     * {@code POST  /flight-type-refs} : Create a new flightTypeRef.
     *
     * @param flightTypeRefDTO the flightTypeRefDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new flightTypeRefDTO, or with status {@code 400 (Bad Request)} if the flightTypeRef has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/flight-type-refs")
    public ResponseEntity<FlightTypeRefDTO> createFlightTypeRef(@RequestBody FlightTypeRefDTO flightTypeRefDTO) throws URISyntaxException {
        log.debug("REST request to save FlightTypeRef : {}", flightTypeRefDTO);
        if (flightTypeRefDTO.getId() != null) {
            throw new BadRequestAlertException("A new flightTypeRef cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FlightTypeRefDTO result = flightTypeRefService.save(flightTypeRefDTO);
        return ResponseEntity
            .created(new URI("/api/flight-type-refs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /flight-type-refs/:id} : Updates an existing flightTypeRef.
     *
     * @param id the id of the flightTypeRefDTO to save.
     * @param flightTypeRefDTO the flightTypeRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated flightTypeRefDTO,
     * or with status {@code 400 (Bad Request)} if the flightTypeRefDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the flightTypeRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/flight-type-refs/{id}")
    public ResponseEntity<FlightTypeRefDTO> updateFlightTypeRef(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody FlightTypeRefDTO flightTypeRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to update FlightTypeRef : {}, {}", id, flightTypeRefDTO);
        if (flightTypeRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, flightTypeRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!flightTypeRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        FlightTypeRefDTO result = flightTypeRefService.save(flightTypeRefDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, flightTypeRefDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /flight-type-refs/:id} : Partial updates given fields of an existing flightTypeRef, field will ignore if it is null
     *
     * @param id the id of the flightTypeRefDTO to save.
     * @param flightTypeRefDTO the flightTypeRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated flightTypeRefDTO,
     * or with status {@code 400 (Bad Request)} if the flightTypeRefDTO is not valid,
     * or with status {@code 404 (Not Found)} if the flightTypeRefDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the flightTypeRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/flight-type-refs/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<FlightTypeRefDTO> partialUpdateFlightTypeRef(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody FlightTypeRefDTO flightTypeRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update FlightTypeRef partially : {}, {}", id, flightTypeRefDTO);
        if (flightTypeRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, flightTypeRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!flightTypeRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<FlightTypeRefDTO> result = flightTypeRefService.partialUpdate(flightTypeRefDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, flightTypeRefDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /flight-type-refs} : get all the flightTypeRefs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of flightTypeRefs in body.
     */
    @GetMapping("/flight-type-refs")
    public ResponseEntity<List<FlightTypeRefDTO>> getAllFlightTypeRefs(Pageable pageable) {
        log.debug("REST request to get a page of FlightTypeRefs");
        Page<FlightTypeRefDTO> page = flightTypeRefService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /flight-type-refs/:id} : get the "id" flightTypeRef.
     *
     * @param id the id of the flightTypeRefDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the flightTypeRefDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/flight-type-refs/{id}")
    public ResponseEntity<FlightTypeRefDTO> getFlightTypeRef(@PathVariable Long id) {
        log.debug("REST request to get FlightTypeRef : {}", id);
        Optional<FlightTypeRefDTO> flightTypeRefDTO = flightTypeRefService.findOne(id);
        return ResponseUtil.wrapOrNotFound(flightTypeRefDTO);
    }

    /**
     * {@code DELETE  /flight-type-refs/:id} : delete the "id" flightTypeRef.
     *
     * @param id the id of the flightTypeRefDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/flight-type-refs/{id}")
    public ResponseEntity<Void> deleteFlightTypeRef(@PathVariable Long id) {
        log.debug("REST request to delete FlightTypeRef : {}", id);
        flightTypeRefService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
    
    @GetMapping("/flight-type-refs/LegEnum/{str}")
    public ResponseEntity<FlightTypeRefDTO> getFlightTypeRefBayLeg(@PathVariable String str) {
      return null;
    }
    
}
