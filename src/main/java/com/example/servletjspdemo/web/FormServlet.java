package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        response.setContentType ("text/html;charset=utf-8");
        response.setContentType ("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='utf-8'/><body><h2>Simple form servlet</h2>" +
				"<form action='data' method='post'>" +
				"First name: <input type='text' name='firstName' /> <br />"+
				"Last name: <input type='text' name='lastName' />  <br />" +
				"<select name='hobby' multiple style='width:200px;'>" +
				"	<option value='Televison'>Televison</option>" +
				"	<option value='Music'>Music</option>" +
				"	<option value='Sport'>Sport</option>" +
				"	<option value='Programming'>Programming</option>" +
				"	<option value='Gaming'>Gaming</option>" +
				"	<option value='Books'>Books</option>"
				+"</select><br />" +
				"<lablel style='color:#ff0000'>I'm 18 years old.<input name='happy' type='radio'/></label><br />"+
			    "<input type='date' name='someDate'/><br/>" +
				"<input placeholder='Tell sth about you' type='textarea' name='alotOfText' cols='20' rows='50'></br>"+
			    " <p>Your favourite fruits</p>"+
			    "<label>" +
					"<input type='checkbox' />Kiwi</label>" +
			   
			    "<label>" +
			    "<input type='checkbox'  />Jackfruit</label>"+
			    	"<label>" +
			    "<input type='checkbox'  />Mango</label>"	+
				"<input type='submit' value=' OK ' /><br />"+
				"</form>" +
				"</body></html>");
		out.close();
	}

}
