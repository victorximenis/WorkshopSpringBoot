package br.unipe.spi.repository;

import br.unipe.spi.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by victor on 10/7/15.
 */
@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
}
