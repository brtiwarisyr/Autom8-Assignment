package com.ram.repository;

import com.ram.entity.UserEntity;
import com.ram.entity.VMs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface VmsRepository extends PagingAndSortingRepository<UserEntity, Integer> {
//    @Query(value = "SELECT * FROM USERS a WHERE a.vMsList = '?'", nativeQuery = true);
//    List<VMs> vMsRequested(UserEntity id);
      VMs findByEmail(@NonNull String email);

      List<UserEntity> getVmsForLoggedInUser(@NonNull String id);

      List<VMs> getRequestedVms(@NonNull VMs vms);
}
