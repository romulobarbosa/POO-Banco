package execao;

@SuppressWarnings("serial")
public class ExcecaoNumeroInvalido extends RuntimeException {

	public ExcecaoNumeroInvalido(String message) {
		super("ExcecaoNumeroInvalido: " + message);
	}

}
