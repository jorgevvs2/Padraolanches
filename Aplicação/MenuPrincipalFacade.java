package Aplicação;

import Aplicação.Builders.PedidoBuilder;
import Common.Ingrediente;
import Common.NotaFiscalPrinter;
import Common.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipalFacade {
    public static Pedido MenuPrincipal(List<Ingrediente> estoque) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("========== Padrão Lanches ==========");
        System.out.println("Gostaria de realizar um novo pedido?");
        System.out.println("====================================");
        System.out.println("     1 - Sim            2- Não");
        System.out.println("====================================");
        System.out.print("Digite: ");
        int resposta = Integer.parseInt(in.nextLine());
        System.out.println("====================================");
        if(resposta == 1){
            Pedido criado = NovoPedido(estoque);
            Thread.sleep(1000);
            criado.aplicaDesconto();
            criado.getEstado().Produzir(criado);
            Thread.sleep(1000);
            criado.getEstado().Finalizar(criado);
            Thread.sleep(1000);
            return criado;
        }
        return null;
    }

    public static Pedido NovoPedido(List<Ingrediente> estoque){
        Scanner in = new Scanner(System.in);
        PedidoBuilder CriadorDePedido = PedidoBuilder.getInstancia();
        int resposta = -1;
        List<String> ingredientes = new ArrayList<>();

        System.out.println("================= Novo Pedido =================");
        while(resposta != 0) {
            System.out.println("==============================================");
            System.out.println("Lista Atual de Ingredientes:");
            ingredientes.forEach(x -> System.out.println(x));
            System.out.println("==============================================");
            System.out.println("Digite o número do ingrediente para \n" +
                    "   adicionar ou 0 para sair");
            System.out.println("1- Carne ($5.00)          2 - Frango($4.00)");
            System.out.println("3- Cebola ($0.50)         4 - Picles($1.00)");
            System.out.println("5- Cheddar ($5.00)        6 - Batata Palha($1.00)");
            System.out.println("7- Ovo de Codorna ($2.50) 8 - Calabresa($2.50)");
            System.out.println("9- Catupiry ($2.00)       10 - Presunto($1.00)");
            System.out.println("              11 - Molhos($0.50)");
            System.out.println("==============================================");
            System.out.print("Digite: ");
            resposta = Integer.parseInt(in.nextLine());
            AdicionaPedidoLista(ingredientes, estoque, resposta, CriadorDePedido);
        }
        System.out.println("Digite alguma Observação para adicionar no Pedido:");
        CriadorDePedido.comObservacoes(in.nextLine());
        return CriadorDePedido.Finaliza();
    }

    public static void AdicionaPedidoLista(List<String> ingredientes, List<Ingrediente> estoque,  int ingrediente, PedidoBuilder criador){
        switch (ingrediente){
            case 1:
                if(estoque.get(0) != null){
                    ingredientes.add(estoque.get(0).getNome());
                    criador.comIngrediente(estoque.get(0));
                }
                break;
            case 2:
                if(estoque.get(1) != null){
                    ingredientes.add(estoque.get(1).getNome());
                    criador.comIngrediente(estoque.get(1));
                }
                break;
            case 3:
                if(estoque.get(2) != null){
                    ingredientes.add(estoque.get(2).getNome());
                    criador.comIngrediente(estoque.get(2));
                }
                break;
            case 4:
                if(estoque.get(3) != null){
                    ingredientes.add(estoque.get(3).getNome());
                    criador.comIngrediente(estoque.get(3));
                }
                break;
            case 5:
                if(estoque.get(4) != null){
                    ingredientes.add(estoque.get(4).getNome());
                    criador.comIngrediente(estoque.get(4));
                }
                break;
            case 6:
                if(estoque.get(5) != null){
                    ingredientes.add(estoque.get(5).getNome());
                    criador.comIngrediente(estoque.get(5));
                }
                break;
            case 7:
                if(estoque.get(6) != null){
                    ingredientes.add(estoque.get(6).getNome());
                    criador.comIngrediente(estoque.get(6));
                }
                break;
            case 8:
                if(estoque.get(7) != null){
                    ingredientes.add(estoque.get(7).getNome());
                    criador.comIngrediente(estoque.get(7));
                }
                break;
            case 9:
                if(estoque.get(8) != null){
                    ingredientes.add(estoque.get(8).getNome());
                    criador.comIngrediente(estoque.get(8));
                }
                break;
            case 10:
                if(estoque.get(9) != null){
                    ingredientes.add(estoque.get(9).getNome());
                    criador.comIngrediente(estoque.get(9));
                }
                break;
            case 11:
                if(estoque.get(10) != null){
                    ingredientes.add(estoque.get(10).getNome());
                    criador.comIngrediente(estoque.get(10));
                }
                break;
        }
    }


    public static List<Ingrediente> AbastecerEstoque() {
        List<Ingrediente> ingredientes = new ArrayList<>();
        ingredientes.add(new Ingrediente("Carne", 5.00));
        ingredientes.add(new Ingrediente("Frango", 4.00));
        ingredientes.add(new Ingrediente("Cebola", 0.50));
        ingredientes.add(new Ingrediente("Picles", 1.00));
        ingredientes.add(new Ingrediente("Cheddar", 2.00));
        ingredientes.add(new Ingrediente("Batata Palha", 1.00));
        ingredientes.add(new Ingrediente("Ovo de Codorna", 2.50));
        ingredientes.add(new Ingrediente("Calabresa", 2.50));
        ingredientes.add(new Ingrediente("Catupiry", 2.00));
        ingredientes.add(new Ingrediente("Presunto", 1.00));
        ingredientes.add(new Ingrediente("Molhos", 0.50));
        return ingredientes;
    }

    public static void ImprimirNota(Pedido pedido){
        NotaFiscalPrinter notaFiscalPrinter = new NotaFiscalPrinter();
        notaFiscalPrinter.ImprimirNota(pedido);
    }
}
