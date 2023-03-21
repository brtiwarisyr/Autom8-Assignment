package com.ram.controller;

import com.ram.dto.UserDTO;
import com.ram.entity.RoleType;
import com.ram.entity.UserEntity;
import com.ram.entity.VMs;
import com.ram.exception.UserServiceException;
import com.ram.model.ui.UserRest;
import com.ram.service.UserService;
import com.ram.service.impl.VMsService;
import com.ram.utils.ErrorMessages;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("VMs")
public class VmProvisioningController {

    @Autowired
    private UserService userService;

    @Autowired
    private VMsService vMsService;

    @GetMapping("/{id}/VMaccess")
    public List<VMs> getVMsRequestedByUser(@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "limit", defaultValue = "3") int limit, String userId)
    {
        List<VMs> userRestList = new ArrayList<VMs>();
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);

        List<VMs> vMsList = vMsService.vMsRequestedByUser(page, limit, userId);

        for (VMs vMs : vMsList)
        {
            VMs vMs1 = null;
            BeanUtils.copyProperties(userDTO, vMs1);
            userRestList.add(vMs);
        }

        return userRestList;
    }

    @PostMapping("/{id}/requestVMs")
    public UserRest addRequestedVMs(@PathVariable("vms") VMs vMs, String email, RoleType roleType) throws UserServiceException{
        if (vMs.getValue().isEmpty())
        {
            throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage());
        }

            UserRest userRest = new UserRest();

            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(email);
            userDTO.setRoleType(roleType.toString(RoleType.MASTER));
            BeanUtils.copyProperties(vMs, userDTO);

            UserDTO createdUserDTO = userService.createUser(userDTO);
            BeanUtils.copyProperties(createdUserDTO, userRest);
            return userRest;
    }

}
