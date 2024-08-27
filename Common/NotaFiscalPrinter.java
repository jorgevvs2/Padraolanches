package Common;

import java.text.MessageFormat;

public class NotaFiscalPrinter {
    public void ImprimirNota(Pedido pedido){
        System.out.println("======== PEDIDO FINALIZADO =======");
        System.out.println("Lista total de Ingredientes:");
        pedido.getIngredientes().forEach(
                x -> System.out.println(x.getNome())
        );
        System.out.println("==================================");
        System.out.println(MessageFormat.format("Valor Total do Pedido: {0}", pedido.getValor()));
        System.out.println(MessageFormat.format("Desconto aplicado no pedido {0}:",pedido.getDesconto()));
        System.out.println("==================================");
    }

}