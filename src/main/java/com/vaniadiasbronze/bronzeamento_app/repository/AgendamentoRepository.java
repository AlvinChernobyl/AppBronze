package com.vaniadiasbronze.bronzeamento_app.repository;

import com.vaniadiasbronze.bronzeamento_app.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
