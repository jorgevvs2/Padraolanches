package Aplicação;

import Common.Ingrediente;
import Common.Pedido;

import java.util.List;

public class main {
    public static void main(String[] args) throws Exception {
        List<Ingrediente> EstoqueDisponivel = MenuPrincipalFacade.AbastecerEstoque();
        Pedido result = MenuPrincipalFacade.MenuPrincipal(EstoqueDisponivel);
        if(result != null) MenuPrincipalFacade.ImprimirNota(result);
        System.out.print("Obrigado e Volte Sempre!");
    }
}