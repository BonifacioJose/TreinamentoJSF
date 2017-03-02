package br.com.treinamentojsf.dao;

import br.com.treinamentojsf.entidade.Cliente;
import br.com.treinamentojsf.entidade.DatabaseEntity;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author José
 */
public class ClienteDao extends DaoImpl<Cliente> implements Dao<Cliente> {


    public ClienteDao(Connection conexao) {
        super(conexao,
            "cliente",
            "insert into cliente (nome,email,telefone,dataNascimento) values (?,?,?,?) returning id",
            "update cliente set nome=?,email=?,telefone=?,dataNascimento=? where id=?");
    }
    
    @Override
    public <T extends DatabaseEntity> T extrair(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getLong("id"));
        cliente.setNome(rs.getString("nome"));
        cliente.setEmail(rs.getString("email"));
        cliente.setTelefone(rs.getString("telefone"));
        cliente.setDataNascimento(rs.getDate("dataNascimento"));
        return (T) cliente;
    }

    @Override
    public <T extends DatabaseEntity> void prepararInsert(T t) throws SQLException {
        Cliente cliente = (Cliente) t;
        getPs().setString(1, cliente.getNome());
        getPs().setString(2, cliente.getEmail());
        getPs().setString(3, cliente.getTelefone());
        getPs().setDate(4, new Date(cliente.getDataNascimento().getTime()));
    }

    @Override
    public <T extends DatabaseEntity> void prepararUpdate(T t) throws SQLException {
        Cliente cliente = (Cliente) t;
        getPs().setString(1, cliente.getNome());
        getPs().setString(2, cliente.getEmail());
        getPs().setString(3, cliente.getTelefone());
        getPs().setDate(4, new Date(cliente.getDataNascimento().getTime()));
        getPs().setLong(5, cliente.getId());
    }
    
}
