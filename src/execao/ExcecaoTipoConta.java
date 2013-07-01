package execao;

@SuppressWarnings("serial")
public class ExcecaoTipoConta extends Exception {

	public ExcecaoTipoConta(String message) {
		super("ExcecaoTipoConta: " + message);
	}

}

