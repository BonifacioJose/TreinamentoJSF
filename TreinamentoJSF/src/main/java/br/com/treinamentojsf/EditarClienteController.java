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
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author darlan
 */
@Named
@ViewScoped
public class EditarClienteController implements Serializable {

    private Long id;
    private Cliente cliente;
    private ClienteDao dao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @PostConstruct
    public void init() {
    }

    public void salvar() {

    }

    public void carregarParametros() throws SQLException {
        if (id == null) {
            cliente = new Cliente();
        } else {
            dao = new ClienteDao(DatabaseUtil.getConnection());
            cliente = dao.buscarPorId(id);

        }
    }

}
