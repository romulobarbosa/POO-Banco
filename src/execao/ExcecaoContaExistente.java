package execao;

@SuppressWarnings("serial")
public class ExcecaoContaExistente extends Exception {

	public ExcecaoContaExistente(String message) {
		super("ExcecaoContaExistente:" + message);
	}
}
