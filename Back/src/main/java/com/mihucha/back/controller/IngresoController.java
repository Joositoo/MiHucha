package com.mihucha.back.controller;

import com.mihucha.back.repository.IngresoRepository;
import com.mihucha.back.service.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingresos")
public class IngresoController {
    @Autowired
    private IngresoRepository ingresoRepository;
    @Autowired
    private IngresoService ingresoService;
}
