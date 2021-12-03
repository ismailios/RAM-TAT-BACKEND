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

import ma.itroad.ram.tat.coref.service.repository.AirLineRefRepository;
import ma.itroad.ram.tat.coref.service.service.AirLineRefService;
import ma.itroad.ram.tat.coref.service.service.dto.AirLineRefDTO;
import ma.itroad.ram.tat.coref.service.web.rest.errors.BadRequestAlertException;
import ma.itroad.ram.tat.coref.service.web.rest.util.HeaderUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.PaginationUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.ResponseUtil;

/**
 * REST controller for managing {@link ma.itroad.ram.tat.coref.service.domain.AirLineRef}.
 */
@RestController
@RequestMapping("/api")
public class AirLineRefResource {

    private final Logger log = LoggerFactory.getLogger(AirLineRefResource.class);

    private static final String ENTITY_NAME = "airLineRef";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AirLineRefService airLineRefService;

    private final AirLineRefRepository airLineRefRepository;

    public AirLineRefResource(AirLineRefService airLineRefService, AirLineRefRepository airLineRefRepository) {
        this.airLineRefService = airLineRefService;
        this.airLineRefRepository = airLineRefRepository;
    }

    /**
     * {@code POST  /air-line-refs} : Create a new airLineRef.
     *
     * @param airLineRefDTO the airLineRefDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new airLineRefDTO, or with status {@code 400 (Bad Request)} if the airLineRef has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/air-line-refs")
    public ResponseEntity<AirLineRefDTO> createAirLineRef(@RequestBody AirLineRefDTO airLineRefDTO) throws URISyntaxException {
        log.debug("REST request to save AirLineRef : {}", airLineRefDTO);
        if (airLineRefDTO.getId() != null) {
            throw new BadRequestAlertException("A new airLineRef cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AirLineRefDTO result = airLineRefService.save(airLineRefDTO);
        return ResponseEntity
            .created(new URI("/api/air-line-refs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /air-line-refs/:id} : Updates an existing airLineRef.
     *
     * @param id the id of the airLineRefDTO to save.
     * @param airLineRefDTO the airLineRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated airLineRefDTO,
     * or with status {@code 400 (Bad Request)} if the airLineRefDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the airLineRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/air-line-refs/{id}")
    public ResponseEntity<AirLineRefDTO> updateAirLineRef(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody AirLineRefDTO airLineRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to update AirLineRef : {}, {}", id, airLineRefDTO);
        if (airLineRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, airLineRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!airLineRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        AirLineRefDTO result = airLineRefService.save(airLineRefDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, airLineRefDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /air-line-refs/:id} : Partial updates given fields of an existing airLineRef, field will ignore if it is null
     *
     * @param id the id of the airLineRefDTO to save.
     * @param airLineRefDTO the airLineRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated airLineRefDTO,
     * or with status {@code 400 (Bad Request)} if the airLineRefDTO is not valid,
     * or with status {@code 404 (Not Found)} if the airLineRefDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the airLineRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/air-line-refs/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<AirLineRefDTO> partialUpdateAirLineRef(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody AirLineRefDTO airLineRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update AirLineRef partially : {}, {}", id, airLineRefDTO);
        if (airLineRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, airLineRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!airLineRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<AirLineRefDTO> result = airLineRefService.partialUpdate(airLineRefDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, airLineRefDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /air-line-refs} : get all the airLineRefs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of airLineRefs in body.
     */
    @GetMapping("/air-line-refs")
    public ResponseEntity<List<AirLineRefDTO>> getAllAirLineRefs(Pageable pageable) {
        log.debug("REST request to get a page of AirLineRefs");
        Page<AirLineRefDTO> page = airLineRefService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /air-line-refs/:id} : get the "id" airLineRef.
     *
     * @param id the id of the airLineRefDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the airLineRefDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/air-line-refs/{id}")
    public ResponseEntity<AirLineRefDTO> getAirLineRef(@PathVariable Long id) {
        log.debug("REST request to get AirLineRef : {}", id);
        Optional<AirLineRefDTO> airLineRefDTO = airLineRefService.findOne(id);
        return ResponseUtil.wrapOrNotFound(airLineRefDTO);
    }

    /**
     * {@code DELETE  /air-line-refs/:id} : delete the "id" airLineRef.
     *
     * @param id the id of the airLineRefDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/air-line-refs/{id}")
    public ResponseEntity<Void> deleteAirLineRef(@PathVariable Long id) {
        log.debug("REST request to delete AirLineRef : {}", id);
        airLineRefService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
