/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webservices.repository;

import br.com.webservices.domain.ClienteTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author LucasPC
 */
//transição com o banco
public interface UsuarioRepository extends JpaRepository< ClienteTable , Long >
{
//    @Query(name="")
     //nome dos atributos tem que ser igual ao da classe
     ClienteTable findByTxtEmailAndTxtSenha(String email,String senha);
     //update
     @Modifying
     @Query("update ClienteTable c set c.txtNome = ?1 where c.idUsuario = ?2 ")
     void setTxtNomeByIdUsuario(String nome, Long id);
}
