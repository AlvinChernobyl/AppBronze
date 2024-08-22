package com.vaniadiasbronze.bronzeamento_app.repository;

import com.vaniadiasbronze.bronzeamento_app.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
