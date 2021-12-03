
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

import ma.itroad.ram.tat.coref.service.domain.UserRef;
import ma.itroad.ram.tat.coref.service.repository.UserRefRepository;
import ma.itroad.ram.tat.coref.service.service.UserRefService;
import ma.itroad.ram.tat.coref.service.service.dto.UserRefDTO;
import ma.itroad.ram.tat.coref.service.web.rest.errors.BadRequestAlertException;
import ma.itroad.ram.tat.coref.service.web.rest.util.HeaderUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.PaginationUtil;
import ma.itroad.ram.tat.coref.service.web.rest.util.ResponseUtil;
/**
 * REST controller for managing {@link ma.itroad.ram.tat.coref.service.domain.UserRef}.
 */
@RestController
@RequestMapping("/api")
public class UserRefResource {

    private final Logger log = LoggerFactory.getLogger(UserRefResource.class);

    private static final String ENTITY_NAME = "userRef";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UserRefService userRefService;

    private final UserRefRepository userRefRepository;

    public UserRefResource(UserRefService userRefService, UserRefRepository userRefRepository) {
        this.userRefService = userRefService;
        this.userRefRepository = userRefRepository;
    }

    /**
     * {@code POST  /user-refs} : Create a new userRef.
     *
     * @param userRefDTO the userRefDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new userRefDTO, or with status {@code 400 (Bad Request)} if the userRef has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/user-refs")
    public ResponseEntity<UserRefDTO> createUserRef(@Valid @RequestBody UserRefDTO userRefDTO) throws URISyntaxException {
        log.debug("REST request to save UserRef : {}", userRefDTO);
        if (userRefDTO.getId() != null) {
            throw new BadRequestAlertException("A new userRef cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UserRefDTO result = userRefService.save(userRefDTO);
        return ResponseEntity
            .created(new URI("/api/user-refs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /user-refs/:id} : Updates an existing userRef.
     *
     * @param id the id of the userRefDTO to save.
     * @param userRefDTO the userRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userRefDTO,
     * or with status {@code 400 (Bad Request)} if the userRefDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the userRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/user-refs/{id}")
    public ResponseEntity<UserRefDTO> updateUserRef(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody UserRefDTO userRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to update UserRef : {}, {}", id, userRefDTO);
        if (userRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, userRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!userRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        UserRefDTO result = userRefService.save(userRefDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, userRefDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /user-refs/:id} : Partial updates given fields of an existing userRef, field will ignore if it is null
     *
     * @param id the id of the userRefDTO to save.
     * @param userRefDTO the userRefDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userRefDTO,
     * or with status {@code 400 (Bad Request)} if the userRefDTO is not valid,
     * or with status {@code 404 (Not Found)} if the userRefDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the userRefDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/user-refs/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<UserRefDTO> partialUpdateUserRef(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody UserRefDTO userRefDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update UserRef partially : {}, {}", id, userRefDTO);
        if (userRefDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, userRefDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!userRefRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<UserRefDTO> result = userRefService.partialUpdate(userRefDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, userRefDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /user-refs} : get all the userRefs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of userRefs in body.
     */
    @GetMapping("/user-refs")
    public ResponseEntity<List<UserRefDTO>> getAllUserRefs(Pageable pageable) {
        log.debug("REST request to get a page of UserRefs");
        Page<UserRefDTO> page = userRefService.findAll(pageable);
        userRefService.createUsers();
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /user-refs/:id} : get the "id" userRef.
     *
     * @param //id the id of the userRefDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the userRefDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/user-refs/empno/{empno}")
    public UserRef getUserRefByEmpno(@PathVariable String empno) {
        log.debug("REST request to get UserRef : {}", empno);
        UserRef userRef = userRefService.findempno(empno);
        return userRef;
    }
    
    @GetMapping("/user-refs/username/{username}")
    public UserRef getUserRefByUsername(@PathVariable String username) {
        log.debug("REST request to get UserRef : {}", username);
        UserRef userRef = userRefService.findUsername(username);
        return userRef;
    }

//    @GetMapping("/user-refs/empNo/{empNo}")
//    public UserRef getUserRefByEMpNo(@PathVariable String empNo) {
//        log.debug("REST request to get UserRef : {}", empNo);
//        UserRef userRef = userRefService.findByEmpNo(empNo);
//        return userRef;
//    }
    
    @GetMapping("/user-refs/{id}")
    public ResponseEntity<UserRefDTO> getUserRef(@PathVariable Long id) {
        log.debug("REST request to get UserRef : {}", id);
        Optional<UserRefDTO> userRefDTO = userRefService.findOne(id);
        return ResponseUtil.wrapOrNotFound(userRefDTO);
    }



    /**
     * {@code DELETE  /user-refs/:id} : delete the "id" userRef.
     *
     * @param id the id of the userRefDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/user-refs/{id}")
    public ResponseEntity<Void> deleteUserRef(@PathVariable Long id) {
        log.debug("REST request to delete UserRef : {}", id);
        userRefService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
    

}
