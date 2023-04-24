package servlet;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CalcolatriceServlet
 */
public class CalcolatriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcolatriceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double op1 = Double.parseDouble(request.getParameter("op1"));
		double op2 = Double.parseDouble(request.getParameter("op2"));
		
		//cookie
		boolean tentativiFiniti = false;
		boolean trovato = false;
		for(Cookie c: request.getCookies()) {
			if(c.getName().equals("calcolatrice")){ 
				trovato = true;
				if(c.getValue().equals("1")) {
					//nel caso si vuole rendere inefficace un cookie lato client:
					Cookie cookie = new Cookie("calcolatrice","");
					cookie.setMaxAge(0); //cancella il cookie , verrà generato unaltro cookie
					response.addCookie(cookie);
					
					response.sendError(response.SC_SERVICE_UNAVAILABLE, "Limite massime operazioni raggiunte");
					tentativiFiniti = true;
	
				}else {
				c.setValue(""+ (Integer.parseInt(c.getValue())-1));
				response.addCookie(c);
				System.out.println(c.getValue());
				//diminuisce il valore del cookie ossia il "3",
				}
				break;
			} 
		}
		
		if(!trovato) {
				//creazione cookie
				Cookie cookie = new Cookie ("calcolatrice","3");
				response.addCookie(cookie);
				
				//cookie.setMaxAge(60_000); //durata del cookie
				//se non mettiamo una durata, il coockie durerà per sempre.
			
		}
		if(!tentativiFiniti) {
		String operazione = request.getParameter("operazione");
		
		double risultato=0;
		
		if(operazione.equals("+")) {
			risultato = op1 + op2;
		}else if(operazione.equals("-")) {
			risultato = op1 - op2;
		}else if(operazione.equals("*")) {
			risultato = op1 * op2;
		}else if(operazione.equals("/")) {
			risultato = op1 / op2;
		}
		
		request.setAttribute("risultato", risultato);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
