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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "farmacia_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmaciaTable.findAll", query = "SELECT f FROM FarmaciaTable f")
    , @NamedQuery(name = "FarmaciaTable.findByIdFarmacia", query = "SELECT f FROM FarmaciaTable f WHERE f.idFarmacia = :idFarmacia")
    , @NamedQuery(name = "FarmaciaTable.findByTxtNomeFarmacia", query = "SELECT f FROM FarmaciaTable f WHERE f.txtNomeFarmacia = :txtNomeFarmacia")
    , @NamedQuery(name = "FarmaciaTable.findByEndTxtBairro", query = "SELECT f FROM FarmaciaTable f WHERE f.endTxtBairro = :endTxtBairro")
    , @NamedQuery(name = "FarmaciaTable.findByEndTxtCidade", query = "SELECT f FROM FarmaciaTable f WHERE f.endTxtCidade = :endTxtCidade")
    , @NamedQuery(name = "FarmaciaTable.findByEndTxtEstado", query = "SELECT f FROM FarmaciaTable f WHERE f.endTxtEstado = :endTxtEstado")
    , @NamedQuery(name = "FarmaciaTable.findByEndTxtNumero", query = "SELECT f FROM FarmaciaTable f WHERE f.endTxtNumero = :endTxtNumero")
    , @NamedQuery(name = "FarmaciaTable.findByEndTxtRua", query = "SELECT f FROM FarmaciaTable f WHERE f.endTxtRua = :endTxtRua")})
public class FarmaciaTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FARMACIA")
    private Long idFarmacia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TXT_NOME_FARMACIA")
    private String txtNomeFarmacia;
  
 
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
    @JoinTable(name = "tb_farmacia_cliente", joinColumns = {
        @JoinColumn(name = "ID_FARMACIA", referencedColumnName = "ID_FARMACIA")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")})
    @ManyToMany
    private List<ClienteTable> clienteTableList;
    @JoinTable(name = "tb_farmacia_remedios", joinColumns = {
        @JoinColumn(name = "ID_FARMACIA", referencedColumnName = "ID_FARMACIA")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_REMEDIO", referencedColumnName = "ID_REMEDIO")})
    @ManyToMany
    private List<RemedioTable> remedioTableList;
    @JoinColumn(name = "ID_FORMA", referencedColumnName = "ID_FORMA_PAGAMENTO")
    @ManyToOne
    private FormaTable idForma;

    public FarmaciaTable() {
    }

    public FarmaciaTable(Long idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public FarmaciaTable(Long idFarmacia, String txtNomeFarmacia, String endTxtCep, String endTxtBairro, String endTxtCidade, String endTxtEstado, int endTxtNumero, String endTxtRua) {
        this.idFarmacia = idFarmacia;
        this.txtNomeFarmacia = txtNomeFarmacia;

        this.endTxtBairro = endTxtBairro;
        this.endTxtCidade = endTxtCidade;
        this.endTxtEstado = endTxtEstado;
        this.endTxtNumero = endTxtNumero;
        this.endTxtRua = endTxtRua;
    }

    public Long getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(Long idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public String getTxtNomeFarmacia() {
        return txtNomeFarmacia;
    }

    public void setTxtNomeFarmacia(String txtNomeFarmacia) {
        this.txtNomeFarmacia = txtNomeFarmacia;
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
    public List<ClienteTable> getClienteTableList() {
        return clienteTableList;
    }

    public void setClienteTableList(List<ClienteTable> clienteTableList) {
        this.clienteTableList = clienteTableList;
    }

    @XmlTransient
    public List<RemedioTable> getRemedioTableList() {
        return remedioTableList;
    }

    public void setRemedioTableList(List<RemedioTable> remedioTableList) {
        this.remedioTableList = remedioTableList;
    }

    public FormaTable getIdForma() {
        return idForma;
    }

    public void setIdForma(FormaTable idForma) {
        this.idForma = idForma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFarmacia != null ? idFarmacia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FarmaciaTable)) {
            return false;
        }
        FarmaciaTable other = (FarmaciaTable) object;
        if ((this.idFarmacia == null && other.idFarmacia != null) || (this.idFarmacia != null && !this.idFarmacia.equals(other.idFarmacia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domain.FarmaciaTable[ idFarmacia=" + idFarmacia + " ]";
    }
    
}
