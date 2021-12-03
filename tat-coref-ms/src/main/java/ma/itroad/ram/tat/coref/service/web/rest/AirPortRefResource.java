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

import ma.itroad.ram.tat.coref.service.repository.AirPortRefRepository;
import ma.itroad.ram.tat.coref.service.service.AirPortRefService;
import ma.itroad.ram.tat.coref.service.service.dto.AirPortRefDTO;
import ma.itroad.ram.tat.coref.service.web.rest.errors.BadRequestAlertException;
import ma.itroad.ram.tat.coref.service.web.rest.util.HeaderUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.PaginationUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.ResponseUtil;

/**
 * REST controller for managing {@link ma.itroad.ram.tat.coref.service.domain.AirPortRef}.
 */
@RestController
@RequestMapping("/api")
public class AirPortRefResource {

    private final Logger log = LoggerFactory.getLogger(AirPortRefResource.class);

    private static final String ENTITY_NAME = "airPortRef";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AirPortRefService airPortRefService;

    private final AirPortRefRepository airPortRefRepository;

    public AirPortRefResource(AirPortRefService airPortRefService, AirPortRefRepository airPortRefRepository) {
        this.airPortRefService = airPortRefService;
        this.airPortRefRepository = airPortRefRepository;
    }

    /**
     * {@code POST  /air-port-refs} : Create a new airPortRef.
     *
     * @param airPortRefDTO the airPortRefDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new airPortRefDTO, or with status {@code 400 (Bad Request)} if the airPortRef has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/air-port-refs")
    public ResponseEntity<AirPortRefDTO> createAirPortRef(@RequestBody AirPortRefDTO airPortRefDTO) throws URISyntaxException {
        log.debug("REST request to save AirPortRef : {}", airPortRefDTO);
        if (airPortRefDTO.getId() != null) {
            throw new BadRequestAlertException("A new airPortRef cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AirPortRefDTO result = airPortRefService.save(airPortRefDTO);
        return ResponseEntity
            .created(new URI("/api/air-port-refs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /air-port-refs/:id} : Updates an existing airPortRef.
     *
     * @param id the id of the airPortRefDTO to save.
     * @param airPortRefDTO the airPortRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated airPortRefDTO,
     * or with status {@code 400 (Bad Request)} if the airPortRefDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the airPortRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/air-port-refs/{id}")
    public ResponseEntity<AirPortRefDTO> updateAirPortRef(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody AirPortRefDTO airPortRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to update AirPortRef : {}, {}", id, airPortRefDTO);
        if (airPortRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, airPortRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!airPortRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        AirPortRefDTO result = airPortRefService.save(airPortRefDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, airPortRefDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /air-port-refs/:id} : Partial updates given fields of an existing airPortRef, field will ignore if it is null
     *
     * @param id the id of the airPortRefDTO to save.
     * @param airPortRefDTO the airPortRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated airPortRefDTO,
     * or with status {@code 400 (Bad Request)} if the airPortRefDTO is not valid,
     * or with status {@code 404 (Not Found)} if the airPortRefDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the airPortRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/air-port-refs/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<AirPortRefDTO> partialUpdateAirPortRef(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody AirPortRefDTO airPortRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update AirPortRef partially : {}, {}", id, airPortRefDTO);
        if (airPortRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, airPortRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!airPortRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<AirPortRefDTO> result = airPortRefService.partialUpdate(airPortRefDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, airPortRefDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /air-port-refs} : get all the airPortRefs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of airPortRefs in body.
     */
    @GetMapping("/air-port-refs")
    public ResponseEntity<List<AirPortRefDTO>> getAllAirPortRefs(Pageable pageable) {
        log.debug("REST request to get a page of AirPortRefs");
        Page<AirPortRefDTO> page = airPortRefService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /air-port-refs/:id} : get the "id" airPortRef.
     *
     * @param id the id of the airPortRefDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the airPortRefDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/air-port-refs/{id}")
    public ResponseEntity<AirPortRefDTO> getAirPortRef(@PathVariable Long id) {
        log.debug("REST request to get AirPortRef : {}", id);
        Optional<AirPortRefDTO> airPortRefDTO = airPortRefService.findOne(id);
        return ResponseUtil.wrapOrNotFound(airPortRefDTO);
    }
    
    @GetMapping("/air-port-refs/code/{code}")
    public ResponseEntity<AirPortRefDTO> getAirPortRefName(@PathVariable String code) {
        log.debug("REST request to get AirPortRef : {}", code);
        Optional<AirPortRefDTO> airPortRefDTO = airPortRefService.findByCode(code);
        return ResponseUtil.wrapOrNotFound(airPortRefDTO);
    }


    /**
     * {@code DELETE  /air-port-refs/:id} : delete the "id" airPortRef.
     *
     * @param id the id of the airPortRefDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/air-port-refs/{id}")
    public ResponseEntity<Void> deleteAirPortRef(@PathVariable Long id) {
        log.debug("REST request to delete AirPortRef : {}", id);
        airPortRefService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
