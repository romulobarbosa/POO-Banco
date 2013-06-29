package execao;
import geral.Utilitarios;

public class ExcecaoValorNegativo extends RuntimeException {
	private static Utilitarios u = new Utilitarios();

	public ExcecaoValorNegativo(String message) {
		// super(message);
		u.pl(u.t(15, "*"));
		u.pl("Ocorreu um erro na operação. Tente novamente.");
		u.pl("Detalhe do erro: ExcecaoValorNegativo: " + message);
		u.pl(u.t(15, "*"));
		
	}

}

