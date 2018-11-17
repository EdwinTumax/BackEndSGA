package edu.sga.core.bs.dao;

import edu.sga.core.eis.bo.Alumno;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AlumnoRepository
        extends PagingAndSortingRepository<Alumno,Long> {

}
