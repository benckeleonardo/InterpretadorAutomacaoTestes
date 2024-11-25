package myPackage;

public class Configuracao {
    private String nome;
    private String valor;

    public Configuracao(String nome, String valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Configuracao[nome=" + nome + ", valor=" + valor + "]";
    }
}
