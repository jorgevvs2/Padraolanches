package Common;

import Aplicação.AplicaDescontos.AplicadorDeDescontos;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import Aplicação.Estados.EstadosPedido.Disponivel;
import Aplicação.Estados.EstadosPedido.Estado;

public class Pedido extends Observable {
    public Double Valor;
    public List<Ingrediente> Ingredientes;
    public Estado Estado = new Disponivel();
    public boolean descontoFoiAplicado = false;

    public double Desconto= 0.0;

    public String Observacoes;

    public Pedido(double valor, List<Ingrediente> lista, boolean desconto, String observacoes)
    {
        Valor = valor;
        Ingredientes = lista;
        descontoFoiAplicado = desconto;
        Observacoes = observacoes;
    }


    public void aplicaDesconto(){
        descontoFoiAplicado = true;
        AplicadorDeDescontos aplicador = new AplicadorDeDescontos();
        this.Desconto = aplicador.DevolveDesconto(this);
        this.Valor = Valor-Desconto;
    }

    public boolean getDescontoFoiAplicado(){
        return descontoFoiAplicado;
    }

    public void setEstado(Aplicação.Estados.EstadosPedido.Estado estado) {
        Estado = estado;
    }

    public Estado getEstado() {
        return Estado;
    }

    public List<Ingrediente> getIngredientes() {
        return Ingredientes;
    }

    public Double getValor() {
        return Valor;
    }

    public String getObservacoes() {
        return Observacoes;
    }

    public void setValor(Double valor) {
        this.Valor = valor;
    }

    public void setDescontoFoiAplicado(boolean descontoFoiAplicado) {
        this.descontoFoiAplicado = descontoFoiAplicado;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        Ingredientes = ingredientes;
    }

    public void setObservacoes(String observacoes) {
        Observacoes = observacoes;
    }

    public void update(Observable o, Object arg) {
        Estado estadoObservado = (Estado)o;
        String acao = String.valueOf(arg);

        if(acao.equals("Aplica")){
            System.out.println("O pedido teve um desconto aplicado.");
        }
        else if(acao.equals("Produz")){
            System.out.println("O pedido esta em producao.");
        }
        else if(acao.equals("Cancela")){
            System.out.println("O pedido foi cancelado.");
        }
        else if(acao.equals("Finaliza")){
            System.out.println("O pedido finalizou.");
        }
    }

    public double getDesconto() {
        return Desconto;
    }

}
