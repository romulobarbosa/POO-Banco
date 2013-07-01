package execao;

@SuppressWarnings("serial")
public class ExcecaoValorNegativo extends Exception {

	public ExcecaoValorNegativo(String message) {
		super("ExcecaoValorNegativo: " + message);
	}

}

