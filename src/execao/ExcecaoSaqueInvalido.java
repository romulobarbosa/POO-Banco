package execao;

@SuppressWarnings("serial")
public class ExcecaoSaqueInvalido extends Exception {

	public ExcecaoSaqueInvalido(String message) {
		super("ExcecaoSaqueInvalido: " + message);
	}

}

