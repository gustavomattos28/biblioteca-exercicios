public class Revista extends ItemBiblioteca {

    public Revista(String codigo, String titulo) {
        super(codigo, titulo);
    }

    public int getPrazoEmprestimo() {
        return 7;
    }

    public double getMultaPorDia() {
        return 1.00;
    }
}