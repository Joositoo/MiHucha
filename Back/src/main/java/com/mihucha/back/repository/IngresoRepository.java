package com.mihucha.back.repository;

import com.mihucha.back.model.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngresoRepository extends JpaRepository<Ingreso, Long> {
}
