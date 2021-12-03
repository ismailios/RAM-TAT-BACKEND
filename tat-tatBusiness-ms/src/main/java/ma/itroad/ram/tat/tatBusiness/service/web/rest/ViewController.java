package ma.itroad.ram.tat.tatBusiness.service.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tatBusiness")
public class ViewController {

	
	@Autowired
	ViewController viewController;
	
    @GetMapping("/side_bar")
    public ResponseEntity<?> viewSideBar() {
    	      viewController.viewMyTask().getStatusCodeValue();
       return ResponseEntity.ok().build();
    }
    
    @GetMapping("/my-task")
    public ResponseEntity<?> viewMyTask() {
    	
       return ResponseEntity.ok().build();
    }
}
