package ma.itroad.ram.tat.coref.service.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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

import ma.itroad.ram.tat.coref.service.repository.EquipmentRefRepository;
import ma.itroad.ram.tat.coref.service.service.EquipmentRefService;
import ma.itroad.ram.tat.coref.service.service.dto.EquipmentRefDTO;
import ma.itroad.ram.tat.coref.service.service.dto.ResourceRefDTO;
import ma.itroad.ram.tat.coref.service.web.rest.errors.BadRequestAlertException;
import ma.itroad.ram.tat.coref.service.web.rest.util.HeaderUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.PaginationUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.ResponseUtil;
/**
 * REST controller for managing {@link ma.itroad.ram.tat.coref.service.domain.EquipmentRef}.
 */
@RestController
@RequestMapping("/api")
public class EquipmentRefResource {

    private final Logger log = LoggerFactory.getLogger(EquipmentRefResource.class);

    private static final String ENTITY_NAME = "equipmentRef";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EquipmentRefService equipmentRefService;

    private final EquipmentRefRepository equipmentRefRepository;

    public EquipmentRefResource(EquipmentRefService equipmentRefService, EquipmentRefRepository equipmentRefRepository) {
        this.equipmentRefService = equipmentRefService;
        this.equipmentRefRepository = equipmentRefRepository;
    }

    /**
     * {@code POST  /equipment-refs} : Create a new equipmentRef.
     *
     * @param equipmentRefDTO the equipmentRefDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new equipmentRefDTO, or with status {@code 400 (Bad Request)} if the equipmentRef has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/equipment-refs")
    public ResponseEntity<EquipmentRefDTO> createEquipmentRef(@Valid @RequestBody EquipmentRefDTO equipmentRefDTO)
        throws URISyntaxException {
        log.debug("REST request to save EquipmentRef : {}", equipmentRefDTO);
        if (equipmentRefDTO.getId() != null) {
            throw new BadRequestAlertException("A new equipmentRef cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EquipmentRefDTO result = equipmentRefService.save(equipmentRefDTO);
        return ResponseEntity
            .created(new URI("/api/equipment-refs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /equipment-refs/:id} : Updates an existing equipmentRef.
     *
     * @param id the id of the equipmentRefDTO to save.
     * @param equipmentRefDTO the equipmentRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated equipmentRefDTO,
     * or with status {@code 400 (Bad Request)} if the equipmentRefDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the equipmentRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/equipment-refs/{id}")
    public ResponseEntity<EquipmentRefDTO> updateEquipmentRef(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody EquipmentRefDTO equipmentRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to update EquipmentRef : {}, {}", id, equipmentRefDTO);
        if (equipmentRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, equipmentRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!equipmentRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        EquipmentRefDTO result = equipmentRefService.save(equipmentRefDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, equipmentRefDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /equipment-refs/:id} : Partial updates given fields of an existing equipmentRef, field will ignore if it is null
     *
     * @param id the id of the equipmentRefDTO to save.
     * @param equipmentRefDTO the equipmentRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated equipmentRefDTO,
     * or with status {@code 400 (Bad Request)} if the equipmentRefDTO is not valid,
     * or with status {@code 404 (Not Found)} if the equipmentRefDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the equipmentRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/equipment-refs/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<EquipmentRefDTO> partialUpdateEquipmentRef(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody EquipmentRefDTO equipmentRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update EquipmentRef partially : {}, {}", id, equipmentRefDTO);
        if (equipmentRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, equipmentRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!equipmentRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<EquipmentRefDTO> result = equipmentRefService.partialUpdate(equipmentRefDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, equipmentRefDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /equipment-refs} : get all the equipmentRefs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of equipmentRefs in body.
     */
    @GetMapping("/equipment-refs")
    public ResponseEntity<List<EquipmentRefDTO>> getAllEquipmentRefs(Pageable pageable) {
        log.debug("REST request to get a page of EquipmentRefs");
        Page<EquipmentRefDTO> page = equipmentRefService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /equipment-refs/:id} : get the "id" equipmentRef.
     *
     * @param id the id of the equipmentRefDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the equipmentRefDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/equipment-refs/{id}")
    public ResponseEntity<EquipmentRefDTO> getEquipmentRef(@PathVariable Long id) {
        log.debug("REST request to get EquipmentRef : {}", id);
        Optional<EquipmentRefDTO> equipmentRefDTO = equipmentRefService.findOne(id);
        return ResponseUtil.wrapOrNotFound(equipmentRefDTO);
    }

    /**
     * {@code DELETE  /equipment-refs/:id} : delete the "id" equipmentRef.
     *
     * @param id the id of the equipmentRefDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/equipment-refs/{id}")
    public ResponseEntity<Void> deleteEquipmentRef(@PathVariable Long id) {
        log.debug("REST request to delete EquipmentRef : {}", id);
        equipmentRefService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
    
    @PostMapping("/equipment-refs/equipments")
    public List<EquipmentRefDTO> getEquipmentssRef(@RequestBody List<Long> ids) {
    	List<EquipmentRefDTO> equipments = new ArrayList<EquipmentRefDTO>();
        
        ids.forEach(i->{
        	
        	 log.debug("REST request to get ResourceRef : {}", i );
        	
        	Optional<EquipmentRefDTO> resourceRefDTO = equipmentRefService.findOne(i);
        	equipments.add(resourceRefDTO.get());
        	
        });
        
        return equipments;
    }
}
