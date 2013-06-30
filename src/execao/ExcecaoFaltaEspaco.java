package execao;
import geral.Utilitarios;

@SuppressWarnings("serial")
public class ExcecaoFaltaEspaco extends Exception {
	private static Utilitarios u = new Utilitarios();

	public ExcecaoFaltaEspaco(String message) {
		super(message);
		// u.pl("Detalhe do erro: ExcecaoFaltaEspaco: " + message);
	}
	
}
