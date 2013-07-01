package execao;

@SuppressWarnings("serial")
public class ExcecaoFaltaEspaco extends Exception {

	public ExcecaoFaltaEspaco(String message) {
		super("ExcecaoFaltaEspaco: " + message);
	}
	
}
