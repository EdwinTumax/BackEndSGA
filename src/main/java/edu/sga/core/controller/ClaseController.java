package edu.sga.core.controller;
import edu.sga.core.bs.dao.ClaseRepository;
import edu.sga.core.eis.bo.Clase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "/api/v1/clase",produces = MediaType.APPLICATION_JSON_VALUE)
public class ClaseController {
    @Autowired
    private ClaseRepository claseRepository;
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Clase> getAll(){
        return claseRepository.findAll();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Clase> getClase(@PathVariable("id") Long id){
        return new ResponseEntity<Clase>(claseRepository.findOne(id), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody Clase clase){
        return claseRepository.save(clase);
    }
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(id == null || id < 0){
            return new ResponseEntity("{ \"message\" : \"Debe enviar un id valido\"}",HttpStatus.CONFLICT);
        }
        Clase clase = claseRepository.findOne(id);
        claseRepository.delete(clase);
        return new ResponseEntity("{ \"message\" : \"Registro eliminado\"}", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Clase> update(@PathVariable("id") Long id, @RequestBody Clase clase){
        if(id == null || id < 0){
            return new ResponseEntity("{ \"message\" : \"Debe enviar un id valido\"}",HttpStatus.CONFLICT);
        }
        Clase claseUpdate = claseRepository.findOne(id);
        if(claseUpdate == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        claseUpdate.setFechaFinal(clase.getFechaFinal());
        claseUpdate.setFechaInicio(clase.getFechaInicio());
        claseRepository.save(claseUpdate);
        return new ResponseEntity<Clase>(claseUpdate,HttpStatus.OK);
    }
}
