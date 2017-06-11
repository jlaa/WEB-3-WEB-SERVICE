/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webservices.rest;

import br.com.webservices.domain.ClienteTable;
import br.com.webservices.repository.UsuarioRepository;
import br.com.webservices.util.Mensagem;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LucasPC
 */
@RestController
@RequestMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {

    //instanciando a interface e populando o objeto do tipo usuarioRepository e vai herdar todos
    //os métodos de jpa repository
    @Autowired
    UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/inserir", method = RequestMethod.POST)
    //quer dizer que o inserir, o corpo do request é um objeto, 
    //o spring boot já sabe o que estamos passando pra ele é um objeto   
    //do tipo usuário 
    public Mensagem inserir(@RequestBody ClienteTable cliente) {
        this.usuarioRepository.save(cliente);
        return new Mensagem("sucesso");
    }

    //desse jeito pego só pela raiz /usuario
    @RequestMapping(method = RequestMethod.GET)
    public List<ClienteTable> listarClientes() {
    	
        return this.usuarioRepository.findAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Mensagem deletarCliente(Long id) {
        this.usuarioRepository.delete(id);
        return new Mensagem("sucesso");
    }

    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    //mesma coisa do request porem para respostas
    public @ResponseBody ClienteTable encontraPeloId(@PathVariable Long id) {
    	
        return this.usuarioRepository.findOne(id);
        
    }

    @RequestMapping(value = "/autenticar", method = RequestMethod.POST)
    public Mensagem autenticar(@RequestBody ClienteTable clienteTable) {
        String senha = clienteTable.getTxtSenha();
        ClienteTable clienteEncontrado = this.usuarioRepository.
                findByTxtEmailAndTxtSenha(clienteTable.getTxtEmail(), senha);
        if (clienteEncontrado != null) {
            return new Mensagem("sucesso");
        }
        return new Mensagem("falha");
    }
}
