package Aplicação.AplicaDescontos;

import Common.Desconto;
import Common.Pedido;

public class AplicadorDeDescontos {
    public double DevolveDesconto(Pedido pedido){
        Desconto d1 = new DescontoCincoItens();
        Desconto d2 = new DescontoValorMaiorVinte();
        Desconto d3 = new SemDesconto();

        d1.setProximo(d2);
        d2.setProximo(d3);
        d3.setProximo(null);

        return d1.Desconta(pedido);
    }
}
