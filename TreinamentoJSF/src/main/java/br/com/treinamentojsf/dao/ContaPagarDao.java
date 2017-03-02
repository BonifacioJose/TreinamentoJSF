package br.com.treinamentojsf.dao;

import br.com.treinamentojsf.entidade.ContaPagar;
import br.com.treinamentojsf.entidade.DatabaseEntity;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bonifácio
 */
public class ContaPagarDao extends DaoImpl<ContaPagar> implements Dao<ContaPagar> {

    public ContaPagarDao(Connection conexao) {
        super(conexao,
                "conta_pagar",
                "insert into conta_pagar (valor,dataVencimento) values (?,?) returning id",
                "update conta_pagar set valor=?,dataVencimento=? where id=?");
    }

    @Override
    public <T extends DatabaseEntity> T extrair(ResultSet rs) throws SQLException {
        ContaPagar contaPagar = new ContaPagar();
        contaPagar.setId(rs.getLong("id"));
        contaPagar.setValor(rs.getBigDecimal("valor"));
        contaPagar.setDataVencimento(rs.getDate("dataVencimento"));
        return (T) contaPagar;
    }

    @Override
    public <T extends DatabaseEntity> void prepararInsert(T t) throws SQLException {
        ContaPagar contaPagar = (ContaPagar) t;
        getPs().setBigDecimal(1, contaPagar.getValor());
        getPs().setDate(2, new Date(contaPagar.getDataVencimento().getTime()));
    }

    @Override
    public <T extends DatabaseEntity> void prepararUpdate(T t) throws SQLException {
        ContaPagar contaPagar = (ContaPagar) t;
        getPs().setBigDecimal(1, contaPagar.getValor());
        getPs().setDate(2, new Date(contaPagar.getDataVencimento().getTime()));
        getPs().setLong(3, contaPagar.getId());
    }

}
