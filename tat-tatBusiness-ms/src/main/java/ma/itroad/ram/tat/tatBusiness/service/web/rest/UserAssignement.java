package ma.itroad.ram.tat.tatBusiness.service.web.rest;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.itroad.ram.tat.tatBusiness.service.service.TatService;
import ma.itroad.ram.tat.tatBusiness.service.service.TatUserAssignement;



@RestController
@RequestMapping("/tatBusiness")
public class UserAssignement {
	
	
	@Autowired
	private TatUserAssignement tatUserAssignement;
	
    @PostMapping("/manual-assignement")
    public ResponseEntity<?> autoAssignement(@RequestParam Long Id) {
    	tatUserAssignement.ManualAssignement(Id);
       return ResponseEntity.ok().build();
    }

    @PostMapping("/liberate")
    public ResponseEntity<?> liberate(@RequestParam Long Id) {
    	tatUserAssignement.liberate(Id);
       return ResponseEntity.ok().build();
    }

};
