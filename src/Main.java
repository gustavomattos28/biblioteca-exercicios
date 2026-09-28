public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Livro livro1 = new Livro("L001", "Dom Casmurro");
        Revista revista1 = new Revista("R001", "Superinteressante");
        Revista revista2 = new Revista("R002", "Veja");
        Revista revista3 = new Revista("R003", "Exame");
        Livro livro2 = new Livro("L002", "1984");

        biblioteca.cadastrarItem(livro1);
        biblioteca.cadastrarItem(revista1);
        biblioteca.cadastrarItem(revista2);
        biblioteca.cadastrarItem(revista3);
        biblioteca.cadastrarItem(livro2);

        Aluno aluno = new Aluno("Gustavo");
        biblioteca.cadastrarUsuario(aluno);

        boolean emprestimo1 = biblioteca.emprestar(livro1, aluno);
        System.out.println("Emprestimo 1 (livro) bem-sucedido: " + emprestimo1);

        biblioteca.emprestar(revista1, aluno);
        biblioteca.emprestar(revista2, aluno);

        boolean emprestimo4 = biblioteca.emprestar(revista3, aluno);
        System.out.println("Emprestimo 4 recusado por limite atingido: " + !emprestimo4);

        biblioteca.listarAcervo();
    }
}