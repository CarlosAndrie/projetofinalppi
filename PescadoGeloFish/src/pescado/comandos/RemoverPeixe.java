package pescado.comandos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pescado.daos.PeixesDAO;
import pescado.models.Peixe;

public class RemoverPeixe implements Logica {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		Long id = null;
		Peixe peixe = null;
		
		try {
			id = Long.parseLong(request.getParameter("id"));
			peixe = new PeixesDAO().getPeixesById(id);
			
			if(new PeixesDAO().remover(peixe)) {
				return "peixeRemovido";
			} else {
				
			}
			
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	
	
}
