package pescado.comandos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {

	public String execute(HttpServletRequest request, HttpServletResponse response);
	
}
