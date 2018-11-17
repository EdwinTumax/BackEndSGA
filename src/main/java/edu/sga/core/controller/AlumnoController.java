package edu.sga.core.controller;

import edu.sga.core.bs.dao.AlumnoRepository;
import edu.sga.core.eis.bo.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import javax.xml.ws.Response;
import java.lang.invoke.MethodType;

@RestController
@RequestMapping(value="/api/v1/alumno",produces = MediaType.APPLICATION_JSON_VALUE)
public class AlumnoController {
    @Autowired
    private AlumnoRepository alumnoRepository;
    @CrossOrigin(origins = {"http://localhost:9494","http://localhost:9300"})
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Alumno> getAll(){
        return  alumnoRepository.findAll();
    }
    @CrossOrigin(origins = {"http://localhost:9494","http://localhost:9300"})
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Alumno> update(@PathVariable("id") Long id,
                                         @RequestBody Alumno alumno){
        if(id == null || id < 0){
            return new ResponseEntity("{\"message\": \"Is required id\" }"
                    ,HttpStatus.CONFLICT);
        }
        if(alumnoRepository.findOne(id) == null){
            return new ResponseEntity("{\"message\" : \"no exist\"}"
                    ,HttpStatus.NO_CONTENT);
        }
        Alumno currenAlumno = alumnoRepository.findOne(id);
        currenAlumno.setApellidos(alumno.getApellidos());
        currenAlumno.setNombres(alumno.getNombres());
        currenAlumno.setFechaNacimiento(alumno.getFechaNacimiento());
        alumnoRepository.save(currenAlumno);
        return new ResponseEntity<Alumno>(currenAlumno,HttpStatus.OK);
    }
    @CrossOrigin(origins = {"http://localhost:9494","http://localhost:9300"})
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(id == null || id < 0){
            return new ResponseEntity("{\"message\": \"Is required id\" }"
                    ,HttpStatus.CONFLICT);
        }
        if(alumnoRepository.findOne(id) == null){
            return new ResponseEntity("{\"message\" : \"no exist\"}"
                    ,HttpStatus.NO_CONTENT);
        }
        alumnoRepository.delete(id);
        return  new ResponseEntity("{\"message\" : \"delete alumno\"}",HttpStatus.OK);
    }
}
