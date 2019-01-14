package pescado.comandos;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet{
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = null;
		String answer = null;
		String logicaRequest = request.getParameter("comandos");
		String comando = "pescado.comandos." + logicaRequest;
		
		try {
			Class<?> classe = Class.forName(comando);
			Logica logica = (Logica)classe.newInstance();
			
			answer = logica.execute(request, response);
		} catch (Exception e) {
			answer = "erro.jsp";
		}
		
		dispatcher = request.getRequestDispatcher(answer);
		dispatcher.forward(request, response);
		
		super.service(request, response);
	}	
}
