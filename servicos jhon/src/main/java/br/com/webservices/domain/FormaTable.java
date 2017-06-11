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
@Table(name = "forma_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormaTable.findAll", query = "SELECT f FROM FormaTable f")
    , @NamedQuery(name = "FormaTable.findByIdFormaPagamento", query = "SELECT f FROM FormaTable f WHERE f.idFormaPagamento = :idFormaPagamento")
    , @NamedQuery(name = "FormaTable.findByInformacoesAdicionais", query = "SELECT f FROM FormaTable f WHERE f.informacoesAdicionais = :informacoesAdicionais")
    , @NamedQuery(name = "FormaTable.findByNomeForma", query = "SELECT f FROM FormaTable f WHERE f.nomeForma = :nomeForma")})
public class FormaTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FORMA_PAGAMENTO")
    private Long idFormaPagamento;
    @Size(max = 255)
    @Column(name = "INFORMACOES_ADICIONAIS")
    private String informacoesAdicionais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOME_FORMA")
    private String nomeForma;
    @OneToMany(mappedBy = "idForma")
    private List<FarmaciaTable> farmaciaTableList;

    public FormaTable() {
    }

    public FormaTable(Long idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public FormaTable(Long idFormaPagamento, String nomeForma) {
        this.idFormaPagamento = idFormaPagamento;
        this.nomeForma = nomeForma;
    }

    public Long getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(Long idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public String getNomeForma() {
        return nomeForma;
    }

    public void setNomeForma(String nomeForma) {
        this.nomeForma = nomeForma;
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
        hash += (idFormaPagamento != null ? idFormaPagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaTable)) {
            return false;
        }
        FormaTable other = (FormaTable) object;
        if ((this.idFormaPagamento == null && other.idFormaPagamento != null) || (this.idFormaPagamento != null && !this.idFormaPagamento.equals(other.idFormaPagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domain.FormaTable[ idFormaPagamento=" + idFormaPagamento + " ]";
    }
    
}
