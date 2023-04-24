package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class CercaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<String> parole = new ArrayList<>();
        parole.add("Corso");
        parole.add("Full");
        parole.add("Stack");
        parole.add("Java");
        parole.add("Developer");

        String conf = request.getParameter("parola");
        int tentativi = Integer.parseInt(request.getParameter("numTentativi"));

        PrintWriter pw = response.getWriter();

        if (parole.contains(conf)) {
            pw.write("<html>" +
                    "<head>" +
                    "<meta charset=\"UTF-8\">" +
                    "<title>Risultato</title>" +
                    "</head>" +
                    "<body>" +
                    "<h2>Evviva, hai vinto!!!</h2>" +
                    "<a href=\"index.html\"> Gioca ancora! </a>" +
                    "</body>" +
                    "</html>");
        }

        if (!parole.contains(conf) && tentativi==1) {
            pw.write("<html>" +
                    "<head>" +
                    "<meta charset=\"UTF-8\">" +
                    "<title>Risultato</title>" +
                    "</head>" +
                    "<body>" +
                    "<h2>Mi dispiace, hai perso!!!</h2>" +
                    "<a href=\"index.html\"> Gioca ancora! </a>" +
                    "</body>" +
                    "</html>");
        }

        if (!parole.contains(conf) && tentativi>1) {
            tentativi--;
            pw.write("<html>" +
                    "<head>" +
                    "    <meta charset=\"UTF-8\">" +
                    "    <title>Title</title>" +
                    "</head>" +
                    "<body>" +
                    "<h2>Ti restano " +tentativi+ " tentativi</h2>" +
                    "    <form action=\"CercaServlet\">" +
                    "        <label for=\"parola\">Parola:</label>" +
                    "        <input type=\"text\" id=\"parola\" name=\"parola\"><br>" +
                    "        <input type=\"hidden\" id=\"numTentativi\" name=\"numTentativi\" value=" +tentativi+ ">" +
                    "        <input type=\"submit\" value=\"Prova!\">" +
                    "    </form>" +
                    "</body>" +
                    "</html>");
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
