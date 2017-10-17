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

import static java.util.Objects.isNull;

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
		String ruleBook;
		String firstName;
		String lastName;
		String alotOfText;
		
		PrintWriter out = response.getWriter();

		String selectedHobby = "";
        String chekedFruit = "";
		for (String hobby : request.getParameterValues("hobby")) {
			selectedHobby += hobby + " ";
		}
        if(!isNull(request.getParameterValues("fruit")))
		    for (String fruit  : request.getParameterValues("fruit")) {
                chekedFruit += fruit + " ";
            }
        else
            chekedFruit = "Empty";
		if(request.getParameter("rule") == "On")
			ruleBook = "Yes";
		else
			ruleBook = "No";
		
		if (request.getParameter("firstName").matches("^[A-Za-z]+$")) {
			firstName = request.getParameter("firstName");
		} else if(isNull(request.getParameter("firstName"))) {
		    firstName = "Empty!";
        }
		else
			firstName = "Error!";
		
		if (request.getParameter("lastName").matches("^[A-Za-z]+$")) {
			lastName = request.getParameter("lastName");
		} else if (isNull(request.getParameter("lastName"))) {
            lastName = "Empty!";
		} else
			lastName = "Error!";

        if (request.getParameter("alotOfText").matches("^[A-Za-z]+$")) {
            alotOfText = request.getParameter("alotOfText");
        } else if (isNull(request.getParameter("alotOfText"))) {
            alotOfText = "Empty!";
        } else
            alotOfText = "Error!";


        out.println("<html><body><h2>Your data</h2>" +
				"<p>First name: " + firstName + "<br />" +
				"<p>Last name: " + lastName + "<br /> " +
				"<p>Your hobby: " + selectedHobby + "<br />" +
				"<p>Your favourite fruit: " + chekedFruit + "<br />" +
				"<p>Is rulebook accepted: " + ruleBook + "<br />"+
				"<p>Date of birth: " + request.getParameter("someDate") +
                " " +isAdult(request.getParameter("someDate")) +
                "</br>" +
				"<p>Everything about you: " + alotOfText+
				"</body></html>");
		out.close();
	}

}
