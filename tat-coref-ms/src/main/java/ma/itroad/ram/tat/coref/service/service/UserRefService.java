package ma.itroad.ram.tat.coref.service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.itroad.ram.tat.coref.service.domain.UserRef;
import ma.itroad.ram.tat.coref.service.repository.UserRefRepository;
import ma.itroad.ram.tat.coref.service.service.dto.UserRefDTO;
import ma.itroad.ram.tat.coref.service.service.mapper.UserRefMapper;


/**
 * Service Implementation for managing {@link UserRef}.
 */
@Service
@Transactional
public class UserRefService {

    private final Logger log = LoggerFactory.getLogger(UserRefService.class);

    private final UserRefRepository UserRefRepository;

    private final UserRefMapper UserRefMapper;
    


    public UserRefService(UserRefRepository UserRefRepository, UserRefMapper UserRefMapper) {
        this.UserRefRepository = UserRefRepository;
        this.UserRefMapper = UserRefMapper;
    }

    /**
     * Save a UserRef.
     *
     * @param UserRefDTO the entity to save.
     * @return the persisted entity.
     */
    public UserRefDTO save(UserRefDTO UserRefDTO) {
        log.debug("Request to save UserRef : {}", UserRefDTO);
        UserRef UserRef = UserRefMapper.toEntity(UserRefDTO);
        UserRef = UserRefRepository.save(UserRef);
        return UserRefMapper.toDto(UserRef);
    }

    /**
     * Partially update a UserRef.
     *
     * @param UserRefDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<UserRefDTO> partialUpdate(UserRefDTO UserRefDTO) {
        log.debug("Request to partially update UserRef : {}", UserRefDTO);

        return UserRefRepository
            .findById(UserRefDTO.getId())
            .map(
                existingUserRef -> {
                    UserRefMapper.partialUpdate(existingUserRef, UserRefDTO);

                    return existingUserRef;
                }
            )
            .map(UserRefRepository::save)
            .map(UserRefMapper::toDto);
    }

    /**
     * Get all the UserRefs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<UserRefDTO> findAll(Pageable pageable) {
        log.debug("Request to get all UserRefs");
        
  
        return UserRefRepository.findAll(pageable).map(UserRefMapper::toDto);
    }

    /**
     * Get one UserRef by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<UserRefDTO> findOne(Long id) {
        log.debug("Request to get UserRef : {}", id);
        return UserRefRepository.findById(id).map(UserRefMapper::toDto);
    }
    
    /**
     * Get one UserRef by empno.
     *
     * @paramid the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public UserRef findempno(String empno) {
        log.debug("Request to get UserRef : {}", empno);
        return UserRefRepository.findByEmpno(empno);
    }
    
    /**
     * Get one UserRef by empno.
     *
     * @paramid the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public UserRef findUsername(String username) {
        log.debug("Request to get UserRef : {}", username);
        return UserRefRepository.findByUsername(username);
    }


    /**
     * Delete the UserRef by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete UserRef : {}", id);
        UserRefRepository.deleteById(id);
    }
    
    
    public void createUsers() {
    	
    	List<UserRef> users =UserRefRepository.findAll();
    	
    	
    	
    	
    	
    	
  
    	
    	
    	for( int i=0 ; i < users.size() ; i++) {
    		
    	
        UserRepresentation user = new UserRepresentation();
        user.setUsername(users.get(i).getUsername());
        user.setEnabled(true);	
        user.setCredentials(new ArrayList<>());
		
    	CredentialRepresentation credential = new CredentialRepresentation();	
    	
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue("admin");
        credential.setTemporary(false);
        user.getCredentials().add(credential);

       
        
        
    	
   
       
    	
    	}
    }


}
