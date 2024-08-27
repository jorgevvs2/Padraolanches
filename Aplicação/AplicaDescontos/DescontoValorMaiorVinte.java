package Aplicação.AplicaDescontos;

import Common.Desconto;
import Common.Pedido;

public class DescontoValorMaiorVinte implements Desconto {
    public Desconto Proximo;

    public Desconto getProximo() {
        return Proximo;
    }
    @Override
    public void setProximo(Desconto proximo) {
        Proximo = proximo;
    }

    public double Desconta(Pedido pedido)
    {
        if(pedido.Valor > 20.0)
        {
            return pedido.Valor * 0.07;
        }
        else
        {
            return Proximo.Desconta(pedido);
        }
    }
}
