package edu.sga.core.controller;

import edu.sga.core.bs.dao.CarreraRepository;
import edu.sga.core.eis.bo.Carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/carrera")
public class CarreraController {
    @Autowired
    private CarreraRepository carreraRepository;
    @RequestMapping(method = RequestMethod.GET)
    public  Iterable<Carrera> getAll(){
        return  carreraRepository.findAll();
    }
}
