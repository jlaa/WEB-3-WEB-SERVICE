/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webservices.util;

import java.io.Serializable;

/**
 *
 * @author LucasPC
 */
public class Mensagem implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5469866276187815794L;
	public String mensagem;
    
    public Mensagem(String mensagem)
    {
        super();
        this.mensagem = mensagem;
    }
}
