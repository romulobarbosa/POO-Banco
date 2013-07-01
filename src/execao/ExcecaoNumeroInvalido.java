package execao;

@SuppressWarnings("serial")
public class ExcecaoNumeroInvalido extends Exception {

	public ExcecaoNumeroInvalido(String message) {
		super("ExcecaoNumeroInvalido: " + message);
	}

}
