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
@Table(name = "remedio_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RemedioTable.findAll", query = "SELECT r FROM RemedioTable r")
    , @NamedQuery(name = "RemedioTable.findByIdRemedio", query = "SELECT r FROM RemedioTable r WHERE r.idRemedio = :idRemedio")
    , @NamedQuery(name = "RemedioTable.findByTxtFaixaEtaria", query = "SELECT r FROM RemedioTable r WHERE r.txtFaixaEtaria = :txtFaixaEtaria")
    , @NamedQuery(name = "RemedioTable.findByTxtNome", query = "SELECT r FROM RemedioTable r WHERE r.txtNome = :txtNome")
    , @NamedQuery(name = "RemedioTable.findByTxtPreco", query = "SELECT r FROM RemedioTable r WHERE r.txtPreco = :txtPreco")
    , @NamedQuery(name = "RemedioTable.findByTxtQuantidade", query = "SELECT r FROM RemedioTable r WHERE r.txtQuantidade = :txtQuantidade")
    , @NamedQuery(name = "RemedioTable.findByTxtTipo", query = "SELECT r FROM RemedioTable r WHERE r.txtTipo = :txtTipo")})
public class RemedioTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_REMEDIO")
    private Long idRemedio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TXT_FAIXA_ETARIA")
    private String txtFaixaEtaria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TXT_NOME")
    private String txtNome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TXT_PRECO")
    private double txtPreco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TXT_QUANTIDADE")
    private long txtQuantidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TXT_TIPO")
    private String txtTipo;
    @ManyToMany(mappedBy = "remedioTableList")
    private List<FarmaciaTable> farmaciaTableList;

    public RemedioTable() {
    }

    public RemedioTable(Long idRemedio) {
        this.idRemedio = idRemedio;
    }

    public RemedioTable(Long idRemedio, String txtFaixaEtaria, String txtNome, double txtPreco, long txtQuantidade, String txtTipo) {
        this.idRemedio = idRemedio;
        this.txtFaixaEtaria = txtFaixaEtaria;
        this.txtNome = txtNome;
        this.txtPreco = txtPreco;
        this.txtQuantidade = txtQuantidade;
        this.txtTipo = txtTipo;
    }

    public Long getIdRemedio() {
        return idRemedio;
    }

    public void setIdRemedio(Long idRemedio) {
        this.idRemedio = idRemedio;
    }

    public String getTxtFaixaEtaria() {
        return txtFaixaEtaria;
    }

    public void setTxtFaixaEtaria(String txtFaixaEtaria) {
        this.txtFaixaEtaria = txtFaixaEtaria;
    }

    public String getTxtNome() {
        return txtNome;
    }

    public void setTxtNome(String txtNome) {
        this.txtNome = txtNome;
    }

    public double getTxtPreco() {
        return txtPreco;
    }

    public void setTxtPreco(double txtPreco) {
        this.txtPreco = txtPreco;
    }

    public long getTxtQuantidade() {
        return txtQuantidade;
    }

    public void setTxtQuantidade(long txtQuantidade) {
        this.txtQuantidade = txtQuantidade;
    }

    public String getTxtTipo() {
        return txtTipo;
    }

    public void setTxtTipo(String txtTipo) {
        this.txtTipo = txtTipo;
    }

    @XmlTransient
    public List<FarmaciaTable> getFarmaciaTableList() {
        return farmaciaTableList;
    }

    public void setFarmaciaTableList(List<FarmaciaTable> farmaciaTableList) {
        this.farmaciaTableList = farmaciaTableList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRemedio != null ? idRemedio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemedioTable)) {
            return false;
        }
        RemedioTable other = (RemedioTable) object;
        if ((this.idRemedio == null && other.idRemedio != null) || (this.idRemedio != null && !this.idRemedio.equals(other.idRemedio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domain.RemedioTable[ idRemedio=" + idRemedio + " ]";
    }
    
}
