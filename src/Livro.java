public class Livro extends ItemBiblioteca {

    public Livro(String codigo, String titulo) {
        super(codigo, titulo);
    }

    public int getPrazoEmprestimo() {
        return 14;
    }

    public double getMultaPorDia() {
        return 0.50;
    }
}