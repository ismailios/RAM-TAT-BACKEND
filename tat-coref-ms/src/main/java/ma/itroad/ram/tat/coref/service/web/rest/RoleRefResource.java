package ma.itroad.ram.tat.coref.service.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
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

import ma.itroad.ram.tat.coref.service.repository.RoleRefRepository;
import ma.itroad.ram.tat.coref.service.service.RoleRefService;
import ma.itroad.ram.tat.coref.service.service.dto.RoleRefDTO;
import ma.itroad.ram.tat.coref.service.web.rest.errors.BadRequestAlertException;
import ma.itroad.ram.tat.coref.service.web.rest.util.HeaderUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.PaginationUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.ResponseUtil;
/**
 * REST controller for managing {@link ma.itroad.ram.tat.coref.service.domain.RoleRef}.
 */
@RestController
@RequestMapping("/api")
public class RoleRefResource {

    private final Logger log = LoggerFactory.getLogger(RoleRefResource.class);

    private static final String ENTITY_NAME = "roleRef";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final RoleRefService roleRefService;

    private final RoleRefRepository roleRefRepository;

    public RoleRefResource(RoleRefService roleRefService, RoleRefRepository roleRefRepository) {
        this.roleRefService = roleRefService;
        this.roleRefRepository = roleRefRepository;
    }

    /**
     * {@code POST  /role-refs} : Create a new roleRef.
     *
     * @param roleRefDTO the roleRefDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new roleRefDTO, or with status {@code 400 (Bad Request)} if the roleRef has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/role-refs")
    public ResponseEntity<RoleRefDTO> createRoleRef(@Valid @RequestBody RoleRefDTO roleRefDTO) throws URISyntaxException {
        log.debug("REST request to save RoleRef : {}", roleRefDTO);
        if (roleRefDTO.getId() != null) {
            throw new BadRequestAlertException("A new roleRef cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RoleRefDTO result = roleRefService.save(roleRefDTO);
        return ResponseEntity
            .created(new URI("/api/role-refs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /role-refs/:id} : Updates an existing roleRef.
     *
     * @param id the id of the roleRefDTO to save.
     * @param roleRefDTO the roleRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated roleRefDTO,
     * or with status {@code 400 (Bad Request)} if the roleRefDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the roleRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/role-refs/{id}")
    public ResponseEntity<RoleRefDTO> updateRoleRef(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody RoleRefDTO roleRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to update RoleRef : {}, {}", id, roleRefDTO);
        if (roleRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, roleRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!roleRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        RoleRefDTO result = roleRefService.save(roleRefDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, roleRefDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /role-refs/:id} : Partial updates given fields of an existing roleRef, field will ignore if it is null
     *
     * @param id the id of the roleRefDTO to save.
     * @param roleRefDTO the roleRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated roleRefDTO,
     * or with status {@code 400 (Bad Request)} if the roleRefDTO is not valid,
     * or with status {@code 404 (Not Found)} if the roleRefDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the roleRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/role-refs/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<RoleRefDTO> partialUpdateRoleRef(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody RoleRefDTO roleRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update RoleRef partially : {}, {}", id, roleRefDTO);
        if (roleRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, roleRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!roleRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<RoleRefDTO> result = roleRefService.partialUpdate(roleRefDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, roleRefDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /role-refs} : get all the roleRefs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of roleRefs in body.
     */
    @GetMapping("/role-refs")
    public ResponseEntity<List<RoleRefDTO>> getAllRoleRefs(Pageable pageable) {
        log.debug("REST request to get a page of RoleRefs");
        Page<RoleRefDTO> page = roleRefService.findAll(pageable);
        
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /role-refs/:id} : get the "id" roleRef.
     *
     * @param id the id of the roleRefDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the roleRefDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/role-refs/{id}")
    public ResponseEntity<RoleRefDTO> getRoleRef(@PathVariable Long id) {
        log.debug("REST request to get RoleRef : {}", id);
        Optional<RoleRefDTO> roleRefDTO = roleRefService.findOne(id);
        return ResponseUtil.wrapOrNotFound(roleRefDTO);
    }

    /**
     * {@code DELETE  /role-refs/:id} : delete the "id" roleRef.
     *
     * @param id the id of the roleRefDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/role-refs/{id}")
    public ResponseEntity<Void> deleteRoleRef(@PathVariable Long id) {
        log.debug("REST request to delete RoleRef : {}", id);
        roleRefService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
    
    @GetMapping("/role-refs/task/{id}")
    public ResponseEntity<List<RoleRefDTO>> getRolesByTask(@PathVariable long id) {
        return null;
    }


}
