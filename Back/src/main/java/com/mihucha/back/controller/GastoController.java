package com.mihucha.back.controller;

import com.mihucha.back.repository.GastoRepository;
import com.mihucha.back.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gastos")
public class GastoController {
    @Autowired
    private GastoRepository gastoRepository;
    @Autowired
    private GastoService gastoService;
}
