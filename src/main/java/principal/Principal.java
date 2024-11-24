package principal;

// Importa a classe FrmMenuAcesso do pacote view, que representa a interface principal do programa.
import view.FrmMenuAcesso;

/**
 * Classe principal do aplicativo. 
 * É o ponto de entrada para execução do programa.
 */
public class Principal {

    /**
     * Método principal (main), responsável por iniciar a aplicação.
     * 
     * @param args Argumentos passados pela linha de comando (não utilizados neste programa).
     */
    public static void main(String[] args) {
        // Cria uma instância da classe FrmMenuAcesso, que provavelmente representa a tela inicial da aplicação.
        FrmMenuAcesso objetotela = new FrmMenuAcesso();
        
        // Torna a interface gráfica visível para o usuário.
        objetotela.setVisible(true);
    }
}