package br.com.treinamentojsf.dao;

import br.com.treinamentojsf.entidade.ClienteContaPagar;
import br.com.treinamentojsf.entidade.DatabaseEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bonifácio
 */
public class ClienteContaPagarDao extends DaoImpl<ClienteContaPagar> implements Dao<ClienteContaPagar> {
    
        public ClienteContaPagarDao(Connection conexao) {
        super(conexao,
                "cliente_conta_pagar",
                "insert into cliente_conta_pagar (idCliente,idContaPagar) values (?,?) returning id",
                "update cliente_conta_pagar set idCliente=?,idContaPagar=? where id=?");
    }

    @Override
    public <T extends DatabaseEntity> T extrair(ResultSet rs) throws SQLException {
        ClienteContaPagar clienteContaPagar = new ClienteContaPagar();
        clienteContaPagar.setId(rs.getLong("id"));
        clienteContaPagar.setIdCliente(rs.getLong("idCliente"));
        clienteContaPagar.setIdContaPagar(rs.getLong("idContaPagar"));
        return (T) clienteContaPagar;
    }

    @Override
    public <T extends DatabaseEntity> void prepararInsert(T t) throws SQLException {
        ClienteContaPagar clienteContaPagar = new ClienteContaPagar();
        getPs().setLong(1, clienteContaPagar.getIdCliente());
        getPs().setLong(2, clienteContaPagar.getIdContaPagar());
    }

    @Override
    public <T extends DatabaseEntity> void prepararUpdate(T t) throws SQLException {
        ClienteContaPagar clienteContaPagar = new ClienteContaPagar();
        getPs().setLong(1, clienteContaPagar.getIdCliente());
        getPs().setLong(2, clienteContaPagar.getIdContaPagar());
        getPs().setLong(3, clienteContaPagar.getId());
    }
    
}
