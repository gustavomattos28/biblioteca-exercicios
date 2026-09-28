public class Biblioteca {
    private ItemBiblioteca[] itens;
    private Usuario[] usuarios;
    private int totalItens;
    private int totalUsuarios;

    public Biblioteca() {
        itens = new ItemBiblioteca[10];
        usuarios = new Usuario[10];
        totalItens = 0;
        totalUsuarios = 0;
    }

    public void cadastrarItem(ItemBiblioteca item) {
        itens[totalItens] = item;
        totalItens++;
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios[totalUsuarios] = usuario;
        totalUsuarios++;
    }

    public boolean emprestar(ItemBiblioteca item, Usuario usuario) {
        if (item.isDisponivel() && usuario.podeEmprestar()) {
            item.marcarComoEmprestado();
            usuario.incrementarEmprestimos();
            return true;
        }
        return false;
    }

    public void devolver(ItemBiblioteca item, Usuario usuario) {
        item.marcarComoDisponivel();
        usuario.decrementarEmprestimos();
    }

    public void listarAcervo() {
        for (int i = 0; i < totalItens; i++) {
            ItemBiblioteca item = itens[i];
            System.out.println(item.getCodigo() + " - " + item.getTitulo()
                    + " | prazo: " + item.getPrazoEmprestimo() + " dias"
                    + " | multa: R$ " + item.getMultaPorDia() + "/dia"
                    + " | disponivel: " + item.isDisponivel());
        }
    }
}