package Aplicação.AplicaDescontos;

import Common.Desconto;
import Common.Pedido;

public class SemDesconto implements Desconto {
    public Desconto Proximo;

    public Desconto getProximo() {
        return Proximo;
    }

    public void setProximo(Desconto proximo) {
        Proximo = proximo;
    }

    public double Desconta(Pedido pedido)
    {
        return 0;
    }
}
