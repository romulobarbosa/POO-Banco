package execao;

@SuppressWarnings("serial")
public class ExcecaoSaqueInvalido extends RuntimeException {

	public ExcecaoSaqueInvalido(String message) {
		super("ExcecaoSaqueInvalido: " + message);
	}

}

