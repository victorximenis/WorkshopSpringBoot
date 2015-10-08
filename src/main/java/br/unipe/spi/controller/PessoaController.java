package br.unipe.spi.controller;

import br.unipe.spi.entity.Contato;
import br.unipe.spi.entity.Pessoa;
import br.unipe.spi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victor on 10/5/15.
 */

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Pessoa> list(){
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        for (int i = 1; i <= 10; i++){
            Pessoa pessoa = new Pessoa();
            pessoa.setNome("Nome" + i);
            pessoa.setSobreNome("Sobrenome" +  i);
            pessoa.setDocumento("Documento" + i);
            pessoa.setApelido("Apelido" + i);

            Contato contato = new Contato();
            contato.setNumero("9999999"+i);
            contato.setEmail("email" + i + "@teste.com");

            pessoa.setContato(contato);
            pessoas.add(pessoa);
        }
        return pessoas;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Pessoa save(@RequestBody Pessoa pessoa){
        pessoaRepository.save(pessoa);
        return pessoa;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Pessoa update(@RequestBody Pessoa pessoa){

        Pessoa pessoa1 = pessoaRepository.findOne(pessoa.getId());
        pessoa1.setApelido(pessoa.getApelido());
        pessoaRepository.save(pessoa1);

        return pessoa;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Pessoa delete(@RequestBody Pessoa pessoa){

        Pessoa pessoa1 = pessoaRepository.findOne(pessoa.getId());
        pessoaRepository.delete(pessoa1);

        return pessoa;
    }

}
