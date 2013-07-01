package execao;

@SuppressWarnings("serial")
public class ExcecaoContaExistente extends RuntimeException {

	public ExcecaoContaExistente(String message) {
		super("ExcecaoContaExistente:" + message);
	}
}
