/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treinamentojsf;

import br.com.treinamentojsf.dao.ClienteDao;
import br.com.treinamentojsf.entidade.Cliente;
import br.com.treinamentojsf.util.DatabaseUtil;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author darlan
 */
@Named
@ViewScoped
public class ClienteController implements Serializable {

    private ClienteDao dao;
    private Cliente cliente;

    private List<Cliente> clientes;

    @PostConstruct
    public void qualquernome() {
        try {
            dao = new ClienteDao(DatabaseUtil.getConnection());
            cliente = new Cliente();
            clientes = dao.buscarTodos();
        } catch (SQLException ex) {

        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String salvar() throws SQLException {
        dao.salvar(cliente);
        return "index.xhtml";
    }

    public void buscar() throws SQLException {
        List<Cliente> lista = dao.buscarTodos();
        System.out.println("Cliente Cadastrado ----------------> " + lista.toString());

    }

    public ClienteDao getDao() {
        return dao;
    }

    public void setDao(ClienteDao dao) {
        this.dao = dao;
    }

    public List<Cliente> getClientes() throws SQLException {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getUrlEditar(Cliente cliente) {
        return "/paginas/editarCliente.xhtml?id=" + cliente.getId() + "&nome=" + cliente.getNome() + "&faces-redirect=true";
    }
}
