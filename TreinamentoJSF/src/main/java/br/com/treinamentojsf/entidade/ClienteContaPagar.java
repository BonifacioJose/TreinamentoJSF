package br.com.treinamentojsf.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Bonifácio
 */
public class ClienteContaPagar implements Serializable, DatabaseEntity {
    
    private Long id;
    private Long idCliente;
    private Long idContaPagar;
    
    //Auxiliares
    private String nomeCliente;
    private BigDecimal valorConta;

    public ClienteContaPagar() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdContaPagar() {
        return idContaPagar;
    }

    public void setIdContaPagar(Long idContaPagar) {
        this.idContaPagar = idContaPagar;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public BigDecimal getValorConta() {
        return valorConta;
    }

    public void setValorConta(BigDecimal valorConta) {
        this.valorConta = valorConta;
    }   
    
    
    @Override
    public boolean isNovo() {
        return this.id == null;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteContaPagar other = (ClienteContaPagar) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClienteContaPagar{" + "id=" + id + ", idCliente=" + idCliente + ", idContaPagar=" + idContaPagar + '}';
    }
    
    
    
}
