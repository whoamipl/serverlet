//Content-type
//encoding(utf-8)
//Walidacja danych
//(typy) liczby
//Daty konwersja
//(czy jesteś pełnoletni

package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/data")
public class DataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String happy;
		String firstName;
		String lastName;
		response.setContentType ("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String selectedHobby = "";
		for (String hobby : request.getParameterValues("hobby")) {
			selectedHobby += hobby + " ";
		}
		
		if(request.getParameter("happy") == "On")
			happy="Yes";
		else
			happy="No";
		
		if (request.getParameter("lastName").matches("^[A-Za-z]+$")) {
			lastName = request.getParameter("lastName");
		} else
			lastName = "Error!";
		
		if (request.getParameter("firstName").matches("^[A-Za-z]+$")) {
			firstName = request.getParameter("lastName");
		} else
			firstName = "Error!";
		
		out.println("<html><body><h2>Your data</h2>" +
				"<p>First name: " + firstName + "<br />" +
				"<p>Last name: " + lastName + "<br /> " +
				"<p>Your hobby: " + selectedHobby + "<br />" +
				"<p>Are you happy: " + happy + "<br />"+
				"<p>Date of birth: " + request.getParameter("someDate")+ "</br>" +
				"<p>Everythink about you: " + request.getParameter("alotOfText")+
				"</body></html>");
		out.close();
	}

}
