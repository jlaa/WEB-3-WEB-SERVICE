/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webservices.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LucasPC
 */
@Entity
@Table(name = "cartao_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartaoTable.findAll", query = "SELECT c FROM CartaoTable c")
    , @NamedQuery(name = "CartaoTable.findByIdCartao", query = "SELECT c FROM CartaoTable c WHERE c.idCartao = :idCartao")
    , @NamedQuery(name = "CartaoTable.findByTxtBandeira", query = "SELECT c FROM CartaoTable c WHERE c.txtBandeira = :txtBandeira")
    , @NamedQuery(name = "CartaoTable.findByDtExpiracao", query = "SELECT c FROM CartaoTable c WHERE c.dtExpiracao = :dtExpiracao")
    , @NamedQuery(name = "CartaoTable.findByTxtNumero", query = "SELECT c FROM CartaoTable c WHERE c.txtNumero = :txtNumero")})
public class CartaoTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CARTAO")
    private Long idCartao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TXT_BANDEIRA")
    private String txtBandeira;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_EXPIRACAO")
    @Temporal(TemporalType.DATE)
    private Date dtExpiracao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TXT_NUMERO")
    private String txtNumero;
    @JoinColumn(name = "ID_CARTAO_CLIENTE", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private ClienteTable idCartaoCliente;

    public CartaoTable() {
    }

    public CartaoTable(Long idCartao) {
        this.idCartao = idCartao;
    }

    public CartaoTable(Long idCartao, String txtBandeira, Date dtExpiracao, String txtNumero) {
        this.idCartao = idCartao;
        this.txtBandeira = txtBandeira;
        this.dtExpiracao = dtExpiracao;
        this.txtNumero = txtNumero;
    }

    public Long getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(Long idCartao) {
        this.idCartao = idCartao;
    }

    public String getTxtBandeira() {
        return txtBandeira;
    }

    public void setTxtBandeira(String txtBandeira) {
        this.txtBandeira = txtBandeira;
    }

    public Date getDtExpiracao() {
        return dtExpiracao;
    }

    public void setDtExpiracao(Date dtExpiracao) {
        this.dtExpiracao = dtExpiracao;
    }

    public String getTxtNumero() {
        return txtNumero;
    }

    public void setTxtNumero(String txtNumero) {
        this.txtNumero = txtNumero;
    }

    public ClienteTable getIdCartaoCliente() {
        return idCartaoCliente;
    }

    public void setIdCartaoCliente(ClienteTable idCartaoCliente) {
        this.idCartaoCliente = idCartaoCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCartao != null ? idCartao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartaoTable)) {
            return false;
        }
        CartaoTable other = (CartaoTable) object;
        if ((this.idCartao == null && other.idCartao != null) || (this.idCartao != null && !this.idCartao.equals(other.idCartao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domain.CartaoTable[ idCartao=" + idCartao + " ]";
    }
    
}
