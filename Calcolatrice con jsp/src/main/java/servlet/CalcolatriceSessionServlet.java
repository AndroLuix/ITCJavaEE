package servlet;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class CalcolatriceServlet
 */
public class CalcolatriceSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcolatriceSessionServlet() {
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
		//boolean trovato = false;
		
		HttpSession session = request.getSession(false);
		
		Integer tentativi = (Integer)session.getAttribute("tentativi");
		if(tentativi==null)
			session.setAttribute("tentativi",3);
		else {
			
			if(tentativi>1)
			session.setAttribute("tentativi",tentativi-1);
			else {
				//invalidazione sessione:
				session.invalidate();
				
				response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE, "Limite Operazioni raggiunte");
				tentativiFiniti = true;
			}
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
