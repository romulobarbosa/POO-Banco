package execao;

@SuppressWarnings("serial")
public class ExcecaoContaInexistente extends Exception {

	public ExcecaoContaInexistente(String message) {
		super("ExcecaoContaInexistente:" + message);
	}
}
