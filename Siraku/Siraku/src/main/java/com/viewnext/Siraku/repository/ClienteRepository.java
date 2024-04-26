package com.viewnext.Siraku.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viewnext.Siraku.modelFL.ClienteFL;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteFL, String>{

}
