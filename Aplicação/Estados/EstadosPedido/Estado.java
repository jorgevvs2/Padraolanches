package Aplicação.Estados.EstadosPedido;

import Common.Pedido;

public interface Estado {
    void AplicarDescontoExtra(Pedido pedido) throws Exception;
    void Produzir(Pedido pedido) throws Exception;
    void Cancelar(Pedido pedido) throws Exception;
    void Finalizar(Pedido pedido) throws Exception;
}
