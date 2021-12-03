package ma.itroad.ram.tat.tatBusiness.service.service;


import ma.itroad.ram.tat.tatBusiness.service.configuration.KeycloakProvider;
import ma.itroad.ram.tat.tatBusiness.service.dtos.UserDto;
import ma.itroad.ram.tat.tatBusiness.service.proxy.CorefProxy;
import ma.itroad.ram.tat.tatBusiness.service.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import static ma.itroad.ram.tat.tatBusiness.service.domain.enums.UserRoleEnum.*;

@Service
public class RoleService {

    @Autowired
    CorefProxy corefProxy;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    KeycloakProvider keycloak;

    public UserDto getConnectedUserInfo()
    {
        String connectedUser = keycloak.getConnectedUser();
        UserDto user = corefProxy.getUserInfo(connectedUser);
    return user;}

    public int getConnectedUserId()
    {
        String connectedUser = keycloak.getConnectedUser();
        UserDto user = corefProxy.getUserInfo(connectedUser);
        return Integer.parseInt(user.getEmpno());
    }

    public boolean roleAllowedToAutoAssign(String userRole){
        return isCA(userRole) || isSupervisor(userRole) || isMCC(userRole)||isPcEscale(userRole);


    }

    public boolean roleAlreadyStartedTask(long tatId,String role){
        return (taskRepository.getMaxProgressByRoleAndTat(tatId,role)>0);

    }



}
