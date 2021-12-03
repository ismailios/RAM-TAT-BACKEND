package ma.itroad.ram.tat.tatBusiness.service.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.itroad.ram.tat.tatBusiness.service.domain.TatEquipment;
import ma.itroad.ram.tat.tatBusiness.service.domain.TatResource;
import ma.itroad.ram.tat.tatBusiness.service.dtos.EquipmentDto;
import ma.itroad.ram.tat.tatBusiness.service.dtos.ResourceDto;
import ma.itroad.ram.tat.tatBusiness.service.proxy.CorefProxy;
import ma.itroad.ram.tat.tatBusiness.service.repository.TatEquipmentRepository;
import ma.itroad.ram.tat.tatBusiness.service.repository.TatResourceRepository;

@Service
public class ResourceEquipmentService {

	@Autowired
	CorefProxy corefProxy;

	@Autowired
	TatResourceRepository tatResourceRepository;
	
	@Autowired
	TatEquipmentRepository tatEquipmentRepository;

	@Autowired
	TatService tatService;

	public void resourceAssignement(Long tatId, List<Long> ids) {

	

		ids.forEach(i -> {

			TatResource tatResource = new TatResource();
			tatResource.setTatId(tatId);
			tatResource.setResourceId(i);
			tatResourceRepository.save(tatResource);

		});

	}

	public List<ResourceDto> getResourceByTat(Long tatId) {

		List<TatResource> tatResources = tatResourceRepository.findByTatId(tatId);

		List<Long> resourceIds = new ArrayList<Long>();

		tatResources.forEach(r -> {
			resourceIds.add(r.getResourceId());

		});

		List<ResourceDto> resources = corefProxy.getResources(resourceIds);
		return resources;

	}

	public void deleteResource(Long tatId, Long resourceId) {

		List<TatResource> tatResources = tatResourceRepository.findByTatIdAndResourceId(tatId, resourceId);
		tatResourceRepository.deleteAll(tatResources);
	}
	
	public void equipmentAssignement(Long tatId, List<Long> ids) {

		

		ids.forEach(i -> {

			TatEquipment tatEquipment = new TatEquipment();
			tatEquipment.setTatId(tatId);
			tatEquipment.setEquipmentId(i);
			tatEquipmentRepository.save(tatEquipment);

		});

	}

	public List<EquipmentDto> getEquipmentByTat(Long tatId) {

		List<TatEquipment> tatEquipments = tatEquipmentRepository.findByTatId(tatId);

		List<Long> equipmentIds = new ArrayList<Long>();

		tatEquipments.forEach(r -> {
			equipmentIds.add(r.getEquipmentId());

		});

		List<EquipmentDto> equipments = corefProxy.getEquipments(equipmentIds);
		return equipments;

	}

	public void deleteEquipment(Long tatId, Long equipmentId) {

		List<TatEquipment> tatEquipments = tatEquipmentRepository.findByTatIdAndEquipmentId(tatId, equipmentId);
		tatEquipmentRepository.deleteAll(tatEquipments);
	}
}
