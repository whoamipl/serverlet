//TODO:
// Content-type done
// Character encoding(utf-8) done
// Data validation
// Types
// Date conversion done
// Are you adult? to refractor

package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/data")
public class DataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static String isAdult (String dataFromForm) {

        int ONE_YERAR = 365;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = LocalDate.now().toString();
        long days = 0;

        try {
            Date date2 = dateFormat.parse(currentDate);
            Date date1 = dateFormat.parse(dataFromForm);
            long diff = date2.getTime() - date1.getTime();
            days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (days / ONE_YERAR < 18) {
            return "You're under 18!";
        } else {
            return "You're adult";
        }

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType ("text/html;charset=utf-8");
		String happy;
		String firstName;
		String lastName;
		
		PrintWriter out = response.getWriter();

		isAdult(request.getParameter("someDate"));

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
				"<p>Date of birth: " + request.getParameter("someDate") + isAdult(request.getParameter("someDate")) +
                "</br>" +
				"<p>Everything about you: " + request.getParameter("alotOfText")+
				"</body></html>");
		out.close();
	}

}
