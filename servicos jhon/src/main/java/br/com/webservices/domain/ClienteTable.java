/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webservices.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LucasPC
 */
@Entity
@Table(name = "cliente_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteTable.findAll", query = "SELECT c FROM ClienteTable c")
    , @NamedQuery(name = "ClienteTable.findByIdUsuario", query = "SELECT c FROM ClienteTable c WHERE c.idUsuario = :idUsuario")
    , @NamedQuery(name = "ClienteTable.findByTxtEmail", query = "SELECT c FROM ClienteTable c WHERE c.txtEmail = :txtEmail")
    , @NamedQuery(name = "ClienteTable.findByTxtLogin", query = "SELECT c FROM ClienteTable c WHERE c.txtLogin = :txtLogin")
    , @NamedQuery(name = "ClienteTable.findByTxtNome", query = "SELECT c FROM ClienteTable c WHERE c.txtNome = :txtNome")
    , @NamedQuery(name = "ClienteTable.findByTxtOcupa\u00e7ao", query = "SELECT c FROM ClienteTable c WHERE c.txtOcupacao = :txtOcupa\u00e7ao")
    , @NamedQuery(name = "ClienteTable.findByTxtSenha", query = "SELECT c FROM ClienteTable c WHERE c.txtSenha = :txtSenha")
    , @NamedQuery(name = "ClienteTable.findByTxtTelefone", query = "SELECT c FROM ClienteTable c WHERE c.txtTelefone = :txtTelefone")
    , @NamedQuery(name = "ClienteTable.findByEndTxtBairro", query = "SELECT c FROM ClienteTable c WHERE c.endTxtBairro = :endTxtBairro")
    , @NamedQuery(name = "ClienteTable.findByEndTxtCidade", query = "SELECT c FROM ClienteTable c WHERE c.endTxtCidade = :endTxtCidade")
    , @NamedQuery(name = "ClienteTable.findByEndTxtEstado", query = "SELECT c FROM ClienteTable c WHERE c.endTxtEstado = :endTxtEstado")
    , @NamedQuery(name = "ClienteTable.findByEndTxtNumero", query = "SELECT c FROM ClienteTable c WHERE c.endTxtNumero = :endTxtNumero")
    , @NamedQuery(name = "ClienteTable.findByEndTxtRua", query = "SELECT c FROM ClienteTable c WHERE c.endTxtRua = :endTxtRua")})
public class ClienteTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TXT_EMAIL")
    private String txtEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TXT_LOGIN")
    private String txtLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TXT_NOME")
    private String txtNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TXT_OCUPACAO")
    private String txtOcupacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TXT_SENHA")
    private String txtSenha;
    @Size(max = 255)
    @Column(name = "TXT_TELEFONE")
    private String txtTelefone;
  
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "END_TXT_BAIRRO")
    private String endTxtBairro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "END_TXT_CIDADE")
    private String endTxtCidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "END_TXT_ESTADO")
    private String endTxtEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "END_TXT_NUMERO")
    private int endTxtNumero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "END_TXT_RUA")
    private String endTxtRua;
    @ManyToMany(mappedBy = "clienteTableList")
    private List<FarmaciaTable> farmaciaTableList;
    @OneToMany(mappedBy = "idCartaoCliente")
    private List<CartaoTable> cartaoTableList;

    public ClienteTable() {
    }

    public ClienteTable(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ClienteTable(Long idUsuario, String txtEmail, String txtLogin, String txtNome, String txtOcupaçao, String txtSenha, String endTxtCep, String endTxtBairro, String endTxtCidade, String endTxtEstado, int endTxtNumero, String endTxtRua) {
        this.idUsuario = idUsuario;
        this.txtEmail = txtEmail;
        this.txtLogin = txtLogin;
        this.txtNome = txtNome;
        this.txtOcupacao = txtOcupaçao;
        this.txtSenha = txtSenha;
        
        this.endTxtBairro = endTxtBairro;
        this.endTxtCidade = endTxtCidade;
        this.endTxtEstado = endTxtEstado;
        this.endTxtNumero = endTxtNumero;
        this.endTxtRua = endTxtRua;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(String txtEmail) {
        this.txtEmail = txtEmail;
    }

    public String getTxtLogin() {
        return txtLogin;
    }

    public void setTxtLogin(String txtLogin) {
        this.txtLogin = txtLogin;
    }

    public String getTxtNome() {
        return txtNome;
    }

    public void setTxtNome(String txtNome) {
        this.txtNome = txtNome;
    }

    public String getTxtOcupaçao() {
        return txtOcupacao;
    }

    public void setTxtOcupaçao(String txtOcupaçao) {
        this.txtOcupacao = txtOcupaçao;
    }

    public String getTxtSenha() {
        return txtSenha;
    }

    public void setTxtSenha(String txtSenha) {
        this.txtSenha = txtSenha;
    }

    public String getTxtTelefone() {
        return txtTelefone;
    }

    public void setTxtTelefone(String txtTelefone) {
        this.txtTelefone = txtTelefone;
    }

  

    public String getEndTxtBairro() {
        return endTxtBairro;
    }

    public void setEndTxtBairro(String endTxtBairro) {
        this.endTxtBairro = endTxtBairro;
    }

    public String getEndTxtCidade() {
        return endTxtCidade;
    }

    public void setEndTxtCidade(String endTxtCidade) {
        this.endTxtCidade = endTxtCidade;
    }

    public String getEndTxtEstado() {
        return endTxtEstado;
    }

    public void setEndTxtEstado(String endTxtEstado) {
        this.endTxtEstado = endTxtEstado;
    }

    public int getEndTxtNumero() {
        return endTxtNumero;
    }

    public void setEndTxtNumero(int endTxtNumero) {
        this.endTxtNumero = endTxtNumero;
    }

    public String getEndTxtRua() {
        return endTxtRua;
    }

    public void setEndTxtRua(String endTxtRua) {
        this.endTxtRua = endTxtRua;
    }

    @XmlTransient
    public List<FarmaciaTable> getFarmaciaTableList() {
        return farmaciaTableList;
    }

    public void setFarmaciaTableList(List<FarmaciaTable> farmaciaTableList) {
        this.farmaciaTableList = farmaciaTableList;
    }

    @XmlTransient
    public List<CartaoTable> getCartaoTableList() {
        return cartaoTableList;
    }

    public void setCartaoTableList(List<CartaoTable> cartaoTableList) {
        this.cartaoTableList = cartaoTableList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteTable)) {
            return false;
        }
        ClienteTable other = (ClienteTable) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domain.ClienteTable[ idUsuario=" + idUsuario + " ]";
    }
    
}
