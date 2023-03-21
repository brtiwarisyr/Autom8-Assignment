package com.ram.service.impl;

import com.ram.dto.UserDTO;
import com.ram.entity.UserEntity;
//import com.ram.entity.VMs;
import com.ram.entity.VMs;
import com.ram.repository.VmsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class VMsService {

    @Autowired
    public VmsRepository vmsRepository;

    public List<VMs> vMsRequestedByUser(int page, int limit, String userId){
        List<VMs> requestedVms = new ArrayList<>();
        UserDTO userDTO = new UserDTO();
        String em = userDTO.getEmail();
        VMs vMs1 = vmsRepository.findByEmail(em);
        if (vMs1 != null)
        {
            throw new RuntimeException("Already Requested VMs");
        }
        if(page>0)
        {
            page = page-1;
        }

        Pageable pageable= PageRequest.of(page, limit);
        Page<UserEntity> usersPage = vmsRepository.findAll(pageable);

        List<UserEntity> userEntityList = usersPage.getContent();

        for (UserEntity userEntity : userEntityList)
        {
            VMs vMs = null;
            BeanUtils.copyProperties(userEntity, vMs);
            requestedVms.add(vMs);
        }


        return requestedVms;
        }
    }


