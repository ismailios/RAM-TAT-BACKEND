package ma.itroad.ram.tat.coref.service.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
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

import ma.itroad.ram.tat.coref.service.repository.ResourceRefRepository;
import ma.itroad.ram.tat.coref.service.service.ResourceRefService;
import ma.itroad.ram.tat.coref.service.service.dto.ResourceRefDTO;
import ma.itroad.ram.tat.coref.service.web.rest.errors.BadRequestAlertException;
import ma.itroad.ram.tat.coref.service.web.rest.util.HeaderUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.PaginationUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.ResponseUtil;

/**
 * REST controller for managing {@link ma.itroad.ram.tat.coref.service.domain.ResourceRef}.
 */
@RestController
@RequestMapping("/api")
public class ResourceRefResource {

    private final Logger log = LoggerFactory.getLogger(ResourceRefResource.class);

    private static final String ENTITY_NAME = "resourceRef";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ResourceRefService resourceRefService;

    private final ResourceRefRepository resourceRefRepository;

    public ResourceRefResource(ResourceRefService resourceRefService, ResourceRefRepository resourceRefRepository) {
        this.resourceRefService = resourceRefService;
        this.resourceRefRepository = resourceRefRepository;
    }

    /**
     * {@code POST  /resource-refs} : Create a new resourceRef.
     *
     * @param resourceRefDTO the resourceRefDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new resourceRefDTO, or with status {@code 400 (Bad Request)} if the resourceRef has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/resource-refs")
    public ResponseEntity<ResourceRefDTO> createResourceRef(@RequestBody ResourceRefDTO resourceRefDTO) throws URISyntaxException {
        log.debug("REST request to save ResourceRef : {}", resourceRefDTO);
        if (resourceRefDTO.getId() != null) {
            throw new BadRequestAlertException("A new resourceRef cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ResourceRefDTO result = resourceRefService.save(resourceRefDTO);
        return ResponseEntity
            .created(new URI("/api/resource-refs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /resource-refs/:id} : Updates an existing resourceRef.
     *
     * @param id the id of the resourceRefDTO to save.
     * @param resourceRefDTO the resourceRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated resourceRefDTO,
     * or with status {@code 400 (Bad Request)} if the resourceRefDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the resourceRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/resource-refs/{id}")
    public ResponseEntity<ResourceRefDTO> updateResourceRef(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ResourceRefDTO resourceRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to update ResourceRef : {}, {}", id, resourceRefDTO);
        if (resourceRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, resourceRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!resourceRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        ResourceRefDTO result = resourceRefService.save(resourceRefDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, resourceRefDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /resource-refs/:id} : Partial updates given fields of an existing resourceRef, field will ignore if it is null
     *
     * @param id the id of the resourceRefDTO to save.
     * @param resourceRefDTO the resourceRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated resourceRefDTO,
     * or with status {@code 400 (Bad Request)} if the resourceRefDTO is not valid,
     * or with status {@code 404 (Not Found)} if the resourceRefDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the resourceRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/resource-refs/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<ResourceRefDTO> partialUpdateResourceRef(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ResourceRefDTO resourceRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update ResourceRef partially : {}, {}", id, resourceRefDTO);
        if (resourceRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, resourceRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!resourceRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ResourceRefDTO> result = resourceRefService.partialUpdate(resourceRefDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, resourceRefDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /resource-refs} : get all the resourceRefs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of resourceRefs in body.
     */
    @GetMapping("/resource-refs")
    public ResponseEntity<List<ResourceRefDTO>> getAllResourceRefs(Pageable pageable) {
        log.debug("REST request to get a page of ResourceRefs");
        Page<ResourceRefDTO> page = resourceRefService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /resource-refs/:id} : get the "id" resourceRef.
     *
     * @param id the id of the resourceRefDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the resourceRefDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/resource-refs/{id}")
    public ResponseEntity<ResourceRefDTO> getResourceRef(@PathVariable Long id) {
        log.debug("REST request to get ResourceRef : {}", id);
        Optional<ResourceRefDTO> resourceRefDTO = resourceRefService.findOne(id);
        return ResponseUtil.wrapOrNotFound(resourceRefDTO);
    }

    /**
     * {@code DELETE  /resource-refs/:id} : delete the "id" resourceRef.
     *
     * @param id the id of the resourceRefDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/resource-refs/{id}")
    public ResponseEntity<Void> deleteResourceRef(@PathVariable Long id) {
        log.debug("REST request to delete ResourceRef : {}", id);
        resourceRefService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
    
    @GetMapping("/resource-refs/role/{id}")
    public ResponseEntity<List<ResourceRefDTO>> getResourceRefBayRole(@PathVariable Long id) {
       return null;
    }

    @GetMapping("/getRoleByUsername")
    public String getRole(@RequestParam String username){
        return resourceRefService.findRoleByUsername(username);
    }
    
    @PostMapping("/resource-refs/resources")
    public List<ResourceRefDTO> getResourcesRef(@RequestBody List<Long> ids) {
    	List<ResourceRefDTO> resources = new ArrayList<ResourceRefDTO>();
        
        ids.forEach(i->{
        	
        	 log.debug("REST request to get ResourceRef : {}", i );
        	
        	Optional<ResourceRefDTO> resourceRefDTO = resourceRefService.findOne(i);
        	resources.add(resourceRefDTO.get());
        	
        });
        
        return resources;
    }
    
}
