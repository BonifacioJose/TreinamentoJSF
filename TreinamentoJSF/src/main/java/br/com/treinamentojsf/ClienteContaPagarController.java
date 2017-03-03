/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.treinamentojsf;

import br.com.treinamentojsf.dao.ClienteContaPagarDao;
import br.com.treinamentojsf.dao.ClienteDao;
import br.com.treinamentojsf.dao.ContaPagarDao;
import br.com.treinamentojsf.dto.ClienteContaPagarDTO;
import br.com.treinamentojsf.entidade.Cliente;
import br.com.treinamentojsf.entidade.ClienteContaPagar;
import br.com.treinamentojsf.entidade.ContaPagar;
import br.com.treinamentojsf.util.DatabaseUtil;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author darlan
 */
@Named
@ViewScoped
public class ClienteContaPagarController implements Serializable{
    
    
    private Long id;
    private ClienteContaPagarDao daoConta;
    private ClienteDao daoCliente;
    private ContaPagarDao daoContaPagar;
    private ClienteContaPagar object;
    private List<ClienteContaPagarDTO> clienteContas;
    private List<Cliente> clientes;
    private List<ContaPagar> contas;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteContaPagar getObject() {
        return object;
    }

    public void setObject(ClienteContaPagar object) {
        this.object = object;
    }
    
    @PostConstruct
    public void init(){
        object = new ClienteContaPagar();
        daoConta = new ClienteContaPagarDao(DatabaseUtil.getConnection());
        daoCliente = new ClienteDao(DatabaseUtil.getConnection());
        daoContaPagar = new ContaPagarDao(DatabaseUtil.getConnection());
        
        try {
            
            if (clienteContas==null){
                clienteContas = daoConta.buscarListaClienteContaPagar();
            }
            
            if (clientes==null){
                clientes = daoCliente.buscarTodos();
            }
            
            if (contas==null){
                contas = daoContaPagar.buscarTodos();
            }
            
            if (id!=null){
                System.out.println("Entrou no Id!=null");
                object = daoConta.buscarPorId(id);
            } else {
                 System.out.println("Entrou no Id==null");
            }
            
        } catch (SQLException sql){
           sql.printStackTrace();
        }
    }
    
    
    public String salvar(){
        try {            
            daoConta.salvar(object);
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
        
        return caminhoRetornar();
    }
    
    public String caminhoRetornar(){
        return "/paginas/clienteContaPagarPrincipal.xhtml?faces-redirect=true";
    }
    
    public String caminhoEditar(ClienteContaPagarDTO object){
        System.out.println("ObjectClienteContaPagar ------------------> "+object.getId());
        return "/paginas/clienteContaPagarAlteracao.xhtml?id="+object.getId()+"&faces-redirect=true";
    }

    public List<ClienteContaPagarDTO> getClienteContas() {
        return clienteContas;
    }

    public void setClienteContas(List<ClienteContaPagarDTO> clienteContas) {
        this.clienteContas = clienteContas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<ContaPagar> getContas() {
        return contas;
    }

    public void setContas(List<ContaPagar> contas) {
        this.contas = contas;
    }
    
    
    
    
    
}
