package execao;

@SuppressWarnings("serial")
public class ExcecaoOpcaoInvalida extends Exception {

	public ExcecaoOpcaoInvalida(String message) {
		super("ExcecaoOpcaoInvalida: " + message);
	}
}

