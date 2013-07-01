package execao;

@SuppressWarnings("serial")
public class ExcecaoTipoConta extends RuntimeException {

	public ExcecaoTipoConta(String message) {
		super("ExcecaoTipoConta: " + message);
	}

}

