package Aplicação.Estados.EstadosPedido;

import Common.Pedido;

import java.util.Observable;

public class Disponivel extends Observable implements Estado{

    private String acao = "";

    @Override
    public void AplicarDescontoExtra(Pedido pedido) throws Exception {
        acao = "Aplica";
        pedido.update((Observable) pedido.getEstado(), acao);
        if(pedido.getDescontoFoiAplicado()){
            throw new Exception("Já foi aplicado desconto neste pedido");
        }
        pedido.aplicaDesconto();
    }
    @Override
    public void Produzir(Pedido pedido) {
        acao = "Produz";
        pedido.update((Observable) pedido.getEstado(), acao);
        pedido.setEstado(new Produzindo());
    }
    @Override
    public void Cancelar(Pedido pedido) {
        acao = "Cancela";
        pedido.update((Observable) pedido.getEstado(), acao);
        pedido.setEstado(new Cancelado());
    }
    @Override
    public void Finalizar(Pedido pedido) throws Exception {
        acao = "Finaliza";
        pedido.update((Observable) pedido.getEstado(), acao);
        throw new Exception("Não se pode passar um pedido disponível para finalizado!");
    }

}
