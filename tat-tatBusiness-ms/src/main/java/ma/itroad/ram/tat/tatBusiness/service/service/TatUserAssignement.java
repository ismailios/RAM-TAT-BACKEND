package ma.itroad.ram.tat.tatBusiness.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.itroad.ram.tat.tatBusiness.service.configuration.KeycloakProvider;
import ma.itroad.ram.tat.tatBusiness.service.domain.CrewMember;
import ma.itroad.ram.tat.tatBusiness.service.domain.Task;
import ma.itroad.ram.tat.tatBusiness.service.domain.Tat;
import ma.itroad.ram.tat.tatBusiness.service.dtos.UserDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.changer.crewMember.RootCrewMemberDto;
import ma.itroad.ram.tat.tatBusiness.service.proxy.CorefProxy;
import ma.itroad.ram.tat.tatBusiness.service.proxy.CrewProxy;
import ma.itroad.ram.tat.tatBusiness.service.repository.CrewRepository;
import ma.itroad.ram.tat.tatBusiness.service.repository.TaskRepository;
import ma.itroad.ram.tat.tatBusiness.service.repository.TatRepository;

import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.UserRoleEnum.isCA;
import ma.itroad.ram.tat.tatBusiness.service.domain.enums.StatusEnum;

@Service
public class TatUserAssignement {

	@Autowired
	CrewProxy crewProxy;

	@Autowired
	CrewRepository crewRepository;

	@Autowired
	TatRepository tatRepository;
	
	@Autowired
	TaskRepository taskRepository;

	@Autowired
	KeycloakProvider keycloakProvider;

	@Autowired
	CorefProxy corefProxy;
	
	@Autowired
	RoleService roleService;

	@Autowired
	TaskService taskService;
	

	String FnCarrier;
	String FnNumber;
	String StartTime;
	String UserId;

	String Dep;
	String Fltnbr;
	String Start;
	String type;

	public void AutomaticAssignement(Tat tat) {

		tat.getFlights().forEach(f -> {

			FnCarrier = f.getFnCarrier();
			FnNumber =  f.getFnNumber();
			StartTime = f.getDayOfOrigin() + "-" + f.getDayOfOrigin();
			UserId = "TAT5a2DCp7zH3QrQwafaZuZEnm3p";

			RootCrewMemberDto crewMemberDto = crewProxy.getCrewMember(FnCarrier, FnNumber, StartTime, UserId);

			crewMemberDto.envelope.body.getCrewOnBoardResponse.retour.crewRoster.forEach((c) -> {

				if (c != null) {
					CrewMember crewMember = new CrewMember((c.getCREWCAT()), (c.getDEP()), (c.getEMPNO()),
							(c.getFLTNBR()), (c.getISPASSIVE()), (c.getSTARTTIME()),"auto", tat);
					System.out.println(crewMember);
					if(!isCA(c.getCREWCAT()))
					crewRepository.save(crewMember);
		//					System.out.println("crewMember saved");
					// set tat has crew true
					// tat.setHasCrew(true);
					//
				}

			});

		});

	}

	public void ManualAssignement(Long id) {

		Tat tat = tatRepository.findById(id).get();

		tat.getFlights().forEach(f -> {

			Dep = f.getDepApActual();
			Fltnbr = f.getFnNumber();
			Start = f.getDayOfOrigin();
			

			String username = keycloakProvider.getConnectedUser();
			type =  roleService.getConnectedUserInfo().getRole();
			
			UserDto userDto = corefProxy.getUserInfo(username);
			CrewMember crewMember = new CrewMember((userDto.getRole()), (Dep), Integer.parseInt(userDto.getEmpno()),
					Integer.parseInt(Fltnbr), 0,(Start),type , tat);
			crewRepository.save(crewMember);
			
			
		});
		taskService.setTatTasksOwners(tat.getId());



	}

	public void liberate(Long id ) {

		Tat tat = tatRepository.findById(id).get();
		String username=keycloakProvider.getConnectedUser();

		String empno = corefProxy.getUserInfo(username).getEmpno();
		int empNo = Integer.parseInt(empno);
		List<CrewMember> crewMember = crewRepository.findByTatAndEmpNo(tat, empNo);
		crewMember.forEach(f -> {
			
			f.setTat(null);
			crewRepository.save(f);
		
		
		});
		
		List<Task> tasks = taskRepository.findByTatId(id);
		tasks.forEach(t-> {
		
			if(t.status== StatusEnum.FINISHED.getValue())
			
			t.setOwner(null);
			t.setOwnerRole(null);
		
			
		
		});
	}
		
		public void handover(Long id ) {

			Tat tat = tatRepository.findById(id).get();
			String username=keycloakProvider.getConnectedUser();
			String empno = corefProxy.getUserInfo(username).getEmpno();
			int empNo = Integer.parseInt(empno);
			List<CrewMember> crewMember = crewRepository.findByTatAndEmpNo(tat, empNo);
			crewMember.forEach(f -> {
				
				f.setTat(null);
				crewRepository.save(f);
					
			});
			
			List<Task> tasks = taskRepository.findByTatId(id);
			tasks.forEach(t-> {
			
				if(t.status== StatusEnum.FINISHED.getValue())
				
				t.setOwner(null);
				t.setOwnerRole(null);
			
				
			
			});
		

	}

}
