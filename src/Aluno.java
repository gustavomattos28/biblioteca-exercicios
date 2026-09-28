public class Aluno extends Usuario {

    public Aluno(String nome) {
        super(nome);
    }

    public int getLimiteItens() {
        return 3;
    }
}