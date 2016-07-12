package model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JsonServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

//		System.out.println(str);
		
		
		
		CategoriaFitService service = new CategoriaFitService();
	    SocioService socioService = SocioService.getInstance() ;
	    // Creates and persists a campo
		if ((String) request.getParameter("id") != "" && (String) request.getParameter("id") != "0") {
			int id = Integer.parseInt((String) request.getParameter("id"));
			System.out.println(id);
			// Campo cam = service.createCampo(3, "brutto");
			// Campo cam =
			// service.createCampo((long)4,BigDecimal.valueOf(0),Date.from(Instant.now()),
			// "Gino", "Italia", "Terra" );

			Socio socio = socioService.findSocio(id);
			System.out.println("Socio: " + socio.getFirstName());

			String nTessera = service.findFromId(id);
			System.out.println("Cat Found     : " + nTessera);
			ObjectMapper jsonMapper = new ObjectMapper();
			response.setContentType("application/json");

			String str = jsonMapper.writeValueAsString(socio);
			response.getWriter().write(str);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
