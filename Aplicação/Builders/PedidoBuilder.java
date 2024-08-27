package Aplicação.Builders;

import Common.Ingrediente;
import Common.Pedido;
import Aplicação.Estados.EstadosPedido.Disponivel;
import Aplicação.Estados.EstadosPedido.Estado;

import java.util.ArrayList;
import java.util.List;

public class PedidoBuilder {
    public Double valor = 10.0;
    public List<Ingrediente> Ingredientes = new ArrayList<>() {
    };
    public Estado Estado = new Disponivel() {
    };
    public boolean descontoFoiAplicado = false;
    public String Observacoes;

    private static PedidoBuilder instanciaUnica = new PedidoBuilder();
    public static PedidoBuilder getInstancia(){
        return instanciaUnica;
    }
    private PedidoBuilder(){

    }

    public PedidoBuilder comIngrediente(Ingrediente ingrediente){
        Ingredientes.add(ingrediente);
        valor += ingrediente.Valor;
        return this;
    }

    public PedidoBuilder comObservacoes(String observacoes){
        Observacoes = observacoes;
        return this;
    }

    public Pedido Finaliza(){
        return new Pedido(valor, Ingredientes,false,Observacoes);
    }
}
