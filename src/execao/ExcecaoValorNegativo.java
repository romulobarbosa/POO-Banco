package execao;

@SuppressWarnings("serial")
public class ExcecaoValorNegativo extends RuntimeException {

	public ExcecaoValorNegativo(String message) {
		super("ExcecaoValorNegativo: " + message);
	}

}

