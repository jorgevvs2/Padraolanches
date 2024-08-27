package Common;

public class Ingrediente {
    public String Nome;
    public Double Valor;

    public Ingrediente(String nome, Double valor){
        Nome = nome;
        Valor = valor;
    }
    public Double getValor() {
        return Valor;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getNome() {
        return Nome;
    }

    public void setValor(Double valor) {
        Valor = valor;
    }
}
