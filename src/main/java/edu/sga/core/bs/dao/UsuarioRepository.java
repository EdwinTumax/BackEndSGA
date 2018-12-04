package edu.sga.core.bs.dao;

import edu.sga.core.eis.bo.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario,Long> {
    Usuario findByUsername(String name);
}
