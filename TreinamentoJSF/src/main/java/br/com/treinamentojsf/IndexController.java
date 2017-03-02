package br.com.treinamentojsf;

import br.com.treinamentojsf.dao.ClienteDao;
import br.com.treinamentojsf.entidade.Cliente;
import br.com.treinamentojsf.util.DatabaseUtil;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Bonifácio
 */
@Named
@ViewScoped
public class IndexController implements Serializable {

    public String getHelloWorld() {
        return "Hello World!";
    }
    
    public void salvar() {
        ClienteDao clienteDao = new ClienteDao(DatabaseUtil.getConnection());
        try {
            clienteDao.salvar(clienteDao.buscarPorId(1L));
            for (Cliente cliente : clienteDao.buscarTodos()) {
                System.out.println("teste: " + cliente.getNome());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            clienteDao.fecharConexoes();
        }
    }
}
