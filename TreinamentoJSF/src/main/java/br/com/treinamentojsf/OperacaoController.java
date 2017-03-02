/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.treinamentojsf;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author darlan
 */
@Named
@ViewScoped
public class OperacaoController implements Serializable{
    
    private double valorUm = 0d;
    private double valorDois = 0d;
    private double resultado = 0d;

    public double getValorUm() {
        return valorUm;
    }

    public void setValorUm(double valorUm) {
        this.valorUm = valorUm;
    }

    public double getValorDois() {
        return valorDois;
    }

    public void setValorDois(double valorDois) {
        this.valorDois = valorDois;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
    
    public void somar(){     
        setResultado(getValorUm()+getValorDois());
        System.out.println("Resultado Final -------->"+getResultado());
    } 
    
    public void subtrair(){
        setResultado(getValorUm()-getValorDois());
    }
    
    public void dividir(){
        setResultado(getValorUm()/getValorDois());
    }
    
    public void multiplicar(){
        setResultado(getValorUm()*getValorDois());
    }
    
}
