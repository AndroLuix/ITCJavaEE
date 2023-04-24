package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class misuraServlet
 */
public class misuraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public misuraServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		double misuraIniziale = Double.parseDouble(request.getParameter("misura"));

		String unitaIniziale = request.getParameter("unita1");
		String unitaFinale = request.getParameter("unita2");
		String risultato = "";

		if (unitaIniziale.equals(unitaFinale)) {
			risultato = misuraIniziale + unitaFinale;
		} else {
			String[] unitaDiMisura = { "mm", "cm", "dm", "m", "dam", "hm", "km" };
			int pos = 0;
			for (int i = 0; i < unitaDiMisura.length; i++) {
				if (unitaIniziale.equals(unitaDiMisura[i])) {
					pos = i;// così sappiamo l'unità di misura iniziale
				}
			}

			int pos2 = 0;
			for (int k = 0; k < unitaDiMisura.length; k++) {
				if (unitaFinale.equals(unitaDiMisura[k])) {
					pos2 = k;// così sappiamo l'unità di misura da raggiungere
				}
			}

			if (pos < pos2) {
				int x = pos;
				while (x <= pos2) {
					misuraIniziale /= 10;
					x++;
				}

			} else {
				int x = pos;
				while (x >= pos2) {
					misuraIniziale *= 10;
					x--;
				}
			}
		}
		risultato = misuraIniziale + unitaFinale;
		request.setAttribute("risultato", risultato);

		RequestDispatcher rd = request.getRequestDispatcher("misura.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
