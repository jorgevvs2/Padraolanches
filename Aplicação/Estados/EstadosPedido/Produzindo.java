package Aplicação.Estados.EstadosPedido;

import Common.Pedido;

import java.util.Observable;

public class Produzindo extends Observable implements Estado{

    private String acao = "";
    @Override
    public void AplicarDescontoExtra(Pedido pedido) throws Exception {
        acao = "Aplica";
        pedido.update((Observable) pedido.getEstado(), acao);
        throw new Exception("O pedido já está em produção, não é possível aplicar descontos!");
    }
    @Override
    public void Produzir(Pedido pedido) throws Exception {
        acao = "Produz";
        pedido.update((Observable) pedido.getEstado(), acao);
        throw new Exception("O pedido já está em produção!");
    }
    @Override
    public void Cancelar(Pedido pedido) throws Exception {
        acao = "Cancela";
        pedido.update((Observable) pedido.getEstado(), acao);
        pedido.setEstado(new Cancelado());
    }
    @Override
    public void Finalizar(Pedido pedido) throws Exception {
        acao = "Finaliza";
        pedido.update((Observable) pedido.getEstado(), acao);
        pedido.setEstado(new Finalizado());
    }
}
