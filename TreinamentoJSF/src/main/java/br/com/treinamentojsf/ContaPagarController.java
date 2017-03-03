/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.treinamentojsf;

import br.com.treinamentojsf.dao.ContaPagarDao;
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
public class ContaPagarController implements Serializable{
    
    private Long id;
    private ContaPagarDao dao;
    private ContaPagar contaPagar;
    private List<ContaPagar> list;
    
    @PostConstruct
    public void init(){
        contaPagar = new ContaPagar();
        dao = new ContaPagarDao(DatabaseUtil.getConnection());
        
        try {
            if (list==null){
                list = dao.buscarTodos();
            }
            
            if (id!=null){
                contaPagar = dao.buscarPorId(id);               
            }            
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    public ContaPagar getContaPagar() {
        return contaPagar;
    }

    public void setContaPagar(ContaPagar contaPagar) {
        this.contaPagar = contaPagar;
    }

    public List<ContaPagar> getList() {
        return list;
    }

    public void setList(List<ContaPagar> list) {
        this.list = list;
    }
    
    public String salvar(){         
      return inserir();              
   }         
    
    private String inserir(){
        try {
                dao.salvar(contaPagar);                
            } catch (SQLException error){
                error.printStackTrace();               
                return "";
            }
        return caminhoRetornar();
    }
    
    private String caminhoRetornar(){
        return "/paginas/contaPagarPrincipal.xhtml?faces-redirect=true";
    }
    
    public String caminhoEditar(ContaPagar contaPagar){
        return "/paginas/contaPagarAlteracao?id="+contaPagar.getId()+"&faces-redirect=true";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
