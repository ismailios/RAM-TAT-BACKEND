package ma.itroad.ram.tat.tatBusiness.service.web.rest;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import io.swagger.annotations.ApiOperation;
import ma.itroad.ram.tat.tatBusiness.service.domain.Tat;
import ma.itroad.ram.tat.tatBusiness.service.dtos.EquipmentDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.ResourceDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.TatDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.TatInfoDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.mappers.FlightMapper;
import ma.itroad.ram.tat.tatBusiness.service.dtos.mappers.TatMapper;
import ma.itroad.ram.tat.tatBusiness.service.repository.CrewRepository;
import ma.itroad.ram.tat.tatBusiness.service.repository.TaskRepository;
import ma.itroad.ram.tat.tatBusiness.service.service.CrewMemberService;
import ma.itroad.ram.tat.tatBusiness.service.service.FlightService;
import ma.itroad.ram.tat.tatBusiness.service.service.ResourceEquipmentService;
import ma.itroad.ram.tat.tatBusiness.service.service.RoleService;
import ma.itroad.ram.tat.tatBusiness.service.service.TaskService;
import ma.itroad.ram.tat.tatBusiness.service.service.TatService;

@RestController
@RequestMapping("/tatBusiness")
public class TatController {

	@Autowired
	private TatService tatService;

	@Autowired
	private TatMapper tatMapper;

	@Autowired
	FlightMapper flightMapper;

	@Autowired
	FlightService flightService;

	@Autowired
	CrewMemberService crewMemberService;

	@Autowired
	ResourceEquipmentService resourceEquipmentService;

	@Autowired
	RoleService roleService;

	@Autowired
	TaskService taskService;

	@Autowired
	CrewRepository crewRepository;

	@Autowired
	TaskRepository taskRepository;

	@Value("${local-airport}")
	String localAirport;

	@Value("${flight-start}")
	int startDefault;

	@Value("${flight-end}")
	int endDefault;

	@ApiOperation(notes = "", value = "Get a list Tat by its type")
	@RequestMapping(value = "/getTatsByType/{type}", method = RequestMethod.GET)
	public Page<TatDto> getAllTats(@PathVariable String type, @PageableDefault(page = 0, size = 300) Pageable page) {
		Page<Tat> tats = tatService.findTatsByType(type, page);
		List<TatDto> tatDtos = new ArrayList<>();

		for (Tat tat : tats) {
			TatDto tatDto = tatMapper.toDto(tat);
			tatDtos.add(tatDto);
		}
		return new PageImpl<>(tatDtos, page, tats.getTotalElements());

	}

	@ApiOperation(notes = "", value = "Get All Tats")
	@RequestMapping(value = "/getAllTats", method = RequestMethod.GET)
	public Page<TatDto> getAllTATs(@PageableDefault(page = 0, size = 300) Pageable page) {
		Page<Tat> tats = tatService.findAllTats(page);
		List<TatDto> tatDtos = new ArrayList<>();

		for (Tat tat : tats) {
			TatDto tatDto = tatMapper.toDto(tat);
			tatDtos.add(tatDto);
		}
		return new PageImpl<>(tatDtos, page, tats.getTotalElements());

	}

	// documentation
	@ApiOperation(notes = "to be implemented", value = "get if Tat is On Time , Green if No Delays, Orange if expected delay based on tasks timing ,red id not ontime at the end of tat ")
	@RequestMapping(value = "/isTatOnTime", method = RequestMethod.GET)
	String isTatOnTime() {
		return "green";

	}

	@ApiOperation(notes = "", value = "to be implemented, auto affect Tat ")
	@RequestMapping(value = "/tat/{tatId}/autoAffect/{userId}", method = RequestMethod.GET)
	void autoAffectTat(@PathVariable("tatId") String tatId, @PathVariable("userId") String userId) {

	}

	@ApiOperation(notes = "", value = "to be implemented, liberate Tat")
	@RequestMapping(value = "/tat/{tatId}/liberate/{userId}", method = RequestMethod.GET)
	void liberateTat(@PathVariable("tatId") String tatId, @PathVariable("userId") String userId) {

	}

	@ApiOperation(notes = "", value = "to be implemented , handover tat to another user")
	@RequestMapping(value = "/tat/{tatId}/handover/{userId}", method = RequestMethod.GET)
	void handoverTat(@PathVariable("tatId") String tatId, @PathVariable("userId") String userId) {

	}

	@ApiOperation(notes = "", value = "to be implemented , progress of tat depending on its tasks progress")
	@RequestMapping(value = "/tat/{tatId}/tatProgress", method = RequestMethod.GET)
	float getTatProgress(@PathVariable("tatId") String tatId) {
		return 50;
	}

	/*
	 * @ApiOperation(notes = "", value = "to be implemented , get Tat chatter")
	 *
	 * @RequestMapping(value = "/tat/{tatId}/getTatCHatter", method =
	 * RequestMethod.GET) ChatterDto getTatChatter(@PathVariable("tatId") String
	 * tatId){ ChatterDto chatter= new ChatterDto(); return chatter; }
	 */

	@ApiOperation(notes = "", value = "to be implemented , get Tat chatter")
	@RequestMapping(value = "/tat/{tatId}/insertMessageinChatter", method = RequestMethod.GET)
	String insertChatMessage(@PathVariable("tatId") String tatId) {
		return "ok";
	}
	// Crud Operation

	// Create
//    @RequestMapping(value = "/createTat", method = RequestMethod.POST)
//    public ResponseEntity<Void> createTat(@RequestBody TatDto tatDto) {
//        Tat tat = tatConverter.convertToEntity(tatDto);
//        Tat tatAdded = tatService.saveTat(tat);
//        if (tatAdded == null)
//            return ResponseEntity.noContent().build();
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(tatAdded.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//    }

	// Update
//    @RequestMapping(value = "/updateTat", method = RequestMethod.PUT)
//    public ResponseEntity<Void> updateTat(@RequestBody TatDto tatDto) {
//        Tat tat = tatConverter.convertToEntity(tatDto);
//        Tat tatAdded = tatService.saveTat(tat);
//        if (tatAdded == null)
//            return ResponseEntity.noContent().build();
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(tatAdded.getId())
//                .toUri();
//        return ResponseEntity.ok().build();
//    }

	// @PreAuthorize("hasRole('admin')")
	@RequestMapping(value = "/filterTats", method = RequestMethod.GET)
	public Page<TatDto> filterTats(
			@RequestParam(name = "myTat", required = false, defaultValue = "false") boolean myTat,
			@RequestParam(name = "tatType", required = false, defaultValue = "0,1,2") String[] tatType,
			@RequestParam(name = "isRam", required = false, defaultValue = "") String isRam,
			@RequestParam(name = "param", required = false, defaultValue = "") String param,
			@RequestParam(name = "startDate", required = false, defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") String start,
			@RequestParam(name = "endDate", required = false, defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") String end,
			@RequestParam(name = "interval", required = false, defaultValue = "0") int interval,
			@PageableDefault(page = 0, size = 300) Pageable page) {
		LocalDateTime startDate;
		LocalDateTime endDate;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
		// boolean autoAffect;
		// boolean liberate;
		



		int userId = roleService.getConnectedUserId();
		String userRole = roleService.getConnectedUserInfo().getRole();



		if (!start.equals("") || !end.equals("")) {
			interval = 0;
		}
		if (start.equals("") && !end.equals("")) {
			endDate = LocalDateTime.parse(end, formatter);
			if (endDate.isAfter(LocalDateTime.now()))
				startDate = LocalDateTime.now();
			else
				startDate = endDate.minusHours(startDefault);

		} else if (!start.equals("") && end.equals("")) {
			startDate = LocalDateTime.parse(start, formatter);
			if (startDate.isBefore(LocalDateTime.now()))
				endDate = LocalDateTime.now();
			else
				endDate = startDate.plusHours(endDefault);
		} else if (start.equals("") && end.equals("")) {
			startDate = LocalDateTime.now().minusHours(startDefault);
			endDate = LocalDateTime.now().plusHours(endDefault);
		} else // (!start.equals("")&& !end.equals(""))
		{
			try {
				startDate = LocalDateTime.parse(start, formatter);
				endDate = LocalDateTime.parse(end, formatter);
			} catch (Exception e) {
				return null;
			}
		}
		Page<Tat> tats;
		if (!myTat) {
			tats = tatService.filterTats(tatType, isRam, param, startDate, endDate, interval, page);
//			List<TatDto> tatDtos = new ArrayList<>();
//			for (Tat tat : tats) {
//				TatDto tatDto = tatMapper.toDto(tat);
//				boolean autoAffect;
//				boolean liberate;
//				if(!userRole.equals("CA") && !userRole.equals("SUPERVISEUR") && !userRole.equals("MCC")  && !userRole.equals("PC_ESCALE")){
//					autoAssign=false;
//					liberate=false;
//				}
//				else{
//					if(taskService.isAssignedToTat(tatDto.getId(),userId))
//					{
//						liberate=true;
//						autoAssign=false;
//					}
//					else{
//						liberate=false;
//						if (crewMemberService.TatAlreadyAffected(tatDto.getId(),userRole)) {
//							autoAssign=false;
//						}
//						else autoAssign=true;
//					}
//				}
//				tatDto.setLiberate(liberate);
//				tatDto.setAutoAffect(autoAffect);
//				tatDtos.add(tatDto);
//			}
//			return new PageImpl<>(tatDtos, page, tats.getTotalElements());
		} else {

			tats = tatService.filterMyTats(userId, tatType, isRam, param, startDate, endDate, interval, page);
		}
		List<TatDto> tatDtos = new ArrayList<>();
		for (Tat tat : tats) {
			TatDto tatDto = tatMapper.toDto(tat);
			tatDto.setProgress(tatService.tatProgress(tatDto.getId()));
			boolean autoAssign;
			boolean liberate;
			boolean handover;
			if (!roleService.roleAllowedToAutoAssign(userRole)) {
				autoAssign = false;
				liberate = false;
				handover = false;
			} else if (taskService.isManuallyAssignedToTat(tatDto.getId(), userId)) {
				autoAssign = false;

				if (roleService.roleAlreadyStartedTask(tatDto.getId(), userRole)) {
					liberate = false;
					handover = true;
				} else {
					liberate = true;
					handover = false;
				}

			} else {
				liberate = false;
				handover = false;
				if (crewMemberService.checkTatAssigned(tatDto.getId(), userRole)) {
					autoAssign = false;
				} else
					autoAssign = true;

			}
			tatDto.setLiberate(liberate);
			tatDto.setAutoAssign(autoAssign);
			tatDto.setHandover(handover);
			tatDto.setPotentialDelay(tatService.potentialDelay(tatDto.getId()));
			tatDtos.add(tatDto);

		}

		return new PageImpl<>(tatDtos, page, tats.getTotalElements());

	}

	@RequestMapping(value = "/filterMyTats", method = RequestMethod.GET)
	public Page<TatDto> filterMyTats(
			// @RequestParam(name ="tatType", required = false, defaultValue = "") String
			// tatType,
			@RequestHeader("Authorization") String header,
			@RequestParam(name = "tatType", required = false, defaultValue = "0,1,2") String[] tatType,
			@RequestParam(name = "isRam", required = false, defaultValue = "") String isRam,
			@RequestParam(name = "param", required = false, defaultValue = "") String param,
			@RequestParam(name = "startDate", required = false, defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") String start,
			@RequestParam(name = "endDate", required = false, defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") String end,
			@RequestParam(name = "interval", required = false, defaultValue = "0") int interval,
			@PageableDefault(page = 0, size = 300) Pageable page) {
		LocalDateTime startDate;
		LocalDateTime endDate;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

		int userId = roleService.getConnectedUserId();



		



		if (!start.equals("") || !end.equals("")) {
			interval = 0;
		}
		if (start.equals("") && !end.equals("")) {
			endDate = LocalDateTime.parse(end, formatter);
			if (endDate.isAfter(LocalDateTime.now()))
				startDate = LocalDateTime.now();
			else
				startDate = endDate.minusHours(startDefault);

		} else if (!start.equals("") && end.equals("")) {
			startDate = LocalDateTime.parse(start, formatter);
			if (startDate.isBefore(LocalDateTime.now()))
				endDate = LocalDateTime.now();
			else
				endDate = startDate.plusHours(endDefault);
		} else if (start.equals("") && end.equals("")) {
			startDate = LocalDateTime.now().minusHours(startDefault);
			endDate = LocalDateTime.now().plusHours(endDefault);
		} else // (!start.equals("")&& !end.equals(""))
		{
			try {
				startDate = LocalDateTime.parse(start, formatter);
				endDate = LocalDateTime.parse(end, formatter);
			} catch (Exception e) {
				return null;
			}
		}
		Page<Tat> tats = tatService.filterMyTats(userId, tatType, isRam, param, startDate, endDate, interval, page);
		List<TatDto> tatDtos = new ArrayList<>();
		for (Tat tat : tats) {
			TatDto tatDto = tatMapper.toDto(tat);
			tatDtos.add(tatDto);
		}
		return new PageImpl<>(tatDtos, page, tats.getTotalElements());

	}

	@RequestMapping(value = "/filterByRegistrationOrNumber", method = RequestMethod.GET)
	Page<TatDto> filterByRegistrationOrFlightNumber(@RequestParam("param") String param,
			@PageableDefault(page = 0, size = 300) Pageable page) {
		Page<Tat> tats = tatService.filterByRegistrationOrFlightNumber(param, page);
		List<TatDto> tatDtos = new ArrayList<>();
		for (Tat tat : tats) {
			TatDto tatDto = tatMapper.toDto(tat);
			tatDtos.add(tatDto);
		}
		return new PageImpl<>(tatDtos, page, tats.getTotalElements());
	}

	@RequestMapping(value = "/getTatsWithNoTasks", method = RequestMethod.GET)
	List<TatInfoDto> getTatsWithNoTasks() {
		return tatService.getTatsWithNoTasks();
	}

	@PutMapping(value = "/enableHasTasks")
	void updateTatTaskState(@RequestParam(name = "tatId", required = true) long id) {
		tatService.enableHasTasks(id);
	}

	@RequestMapping(value = "/getTatById", method = RequestMethod.GET)
	TatDto getTatById(@RequestParam(name = "tatId", required = true) long id) {
		if (tatService.findTatById(id) != null)
			return tatMapper.toDto(tatService.findTatById(id));
		else
			return null;
	}

	@GetMapping("/tat-duration")
	public long getTatDuration() {
		return tatService.findTatDuration(53);
	}

	@PostMapping("/tat-resource-assignement")
	public void tatResourceAssignement(@RequestParam Long tatId, @RequestBody List<Long> ids) {
		resourceEquipmentService.resourceAssignement(tatId, ids);

	}

	@DeleteMapping("/tat-resource-assignement")
	public void deleteResource(@RequestParam Long tatId, @RequestParam Long resourceId) {

		resourceEquipmentService.deleteResource(tatId, resourceId);

	}

	@GetMapping("/tat-resource")
	public List<ResourceDto> getResourcesByTat(@RequestParam Long tatId) {
		return resourceEquipmentService.getResourceByTat(tatId);

	}

	@PostMapping("/tat-equipment-assignement")
	public void tatEquipmentAssignement(@RequestParam Long tatId, @RequestBody List<Long> ids) {
		resourceEquipmentService.resourceAssignement(tatId, ids);

	}

	@DeleteMapping("/tat-equipment-assignement")
	public void deleteEquipment(@RequestParam Long tatId, @RequestParam Long equipmentId) {

		resourceEquipmentService.deleteEquipment(tatId, equipmentId);

	}

	@GetMapping("/tat-equipment")
	public List<EquipmentDto> getEquipmentsByTat(@RequestParam Long tatId) {
		return resourceEquipmentService.getEquipmentByTat(tatId);

	}

}
