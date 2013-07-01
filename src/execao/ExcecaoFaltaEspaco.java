package execao;

@SuppressWarnings("serial")
public class ExcecaoFaltaEspaco extends RuntimeException {

	public ExcecaoFaltaEspaco(String message) {
		super("ExcecaoFaltaEspaco: " + message);
	}
	
}
