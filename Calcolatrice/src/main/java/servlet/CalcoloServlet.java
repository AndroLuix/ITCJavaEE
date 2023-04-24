package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CalcoloServlet
 */
public class CalcoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcoloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		double risultato = 0;
		PrintWriter pw = response.getWriter();
		String primoAddendo = request.getParameter("primo");
		int primo = Integer.parseInt(primoAddendo);
		
		String secondoAddendo = request.getParameter("secondo");
		int secondo = Integer.parseInt(secondoAddendo);
		
		String operatore = request.getParameter("op");
		
		if(operatore.equals("piu")) {
			risultato = primo+ secondo;
			
		}else if(operatore.equals("meno")) {
			risultato = primo - secondo;
		}else if(operatore.equals("per")) {
			risultato = primo * secondo;
		}else if(operatore.equals("dividi")) {
			risultato = primo / secondo;
		}
		pw.write(
				"<!DOCTYPE html>"+
		"<!DOCTYPE html>"
		+ "<html lang=\"en\">"
		+ "<head>\r\n"
		+ "    <meta charset=\"UTF-8\">"
		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\""
		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
		+ "    <title>Document</title>"
		+ "    <link rel=\"stylesheet\" href=\"style.css\">"
		+ "</head>\r\n"
		+ "<body>"+
		"<form action=\"CalcoloServlet\">"+
        "<label for=\"primo\">Primo addendo</label>"+
        "<input type=\"number\" name=\"primo\" id=\"primo\" required>"+
        "<label for=\"secondo\">Secondo Addendo</label>"+
        "<input type=\"number\" name=\"secondo\" id=\"secondo\" required>"+
        "<div>"+
            "<label for=\"op\">addizione</label>"+
            "<input type=\"radio\" name=\"op\" id=\"a\" value=\"piu\" checked=\"checked\"> <br><br>"+
            "<label for=\"op\">sottrazione</label>"+
            "<input type=\"radio\" name=\"op\" id=\"b\" value=\"meno\"><br><br>"+
            "<label for=\"op\">moltiplica</label>"+
            "<input type=\"radio\" name=\"op\" id=\"c\" value=\"per\"><br><br>"+
            "<label for=\"op\">divisione</label>"+
            "<input type=\"radio\" name=\"op\" id=\"d\" value=\"dividi\">"+
        "</div>"+
       
        
        "<input type=\"submit\" value=\"calcola\">"+
		        "<p> Risultato: "+risultato+"</p>"+
		    "</form>"+
		"</body>"+
		"</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
