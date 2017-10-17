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
		out.println("<html>\n" +
				"<head>\n" +
				"\t<meta charset='utf-8' />\n" +
				"\t<style type=\"text/css\">\n" +
				"\t\t.form-style-1 {\n" +
				"\t\t\tmargin: 10px auto;\n" +
				"\t\t\tmax-width: 400px;\n" +
				"\t\t\tpadding: 20px 12px 10px 20px;\n" +
				"\t\t\tfont: 13px \"Lucida Sans Unicode\", \"Lucida Grande\", sans-serif;\n" +
				"\t\t}\n" +
				"\n" +
				"\t\t.form-style-1 li {\n" +
				"\t\t\tpadding: 0;\n" +
				"\t\t\tdisplay: block;\n" +
				"\t\t\tlist-style: none;\n" +
				"\t\t\tmargin: 10px 0 0 0;\n" +
				"\t\t}\n" +
				"\n" +
				"\t\t.form-style-1 label {\n" +
				"\t\t\tmargin: 0 0 3px 0;\n" +
				"\t\t\tpadding: 0px;\n" +
				"\t\t\tdisplay: block;\n" +
				"\t\t\tfont-weight: bold;\n" +
				"\t\t}\n" +
				"\n" +
				"\t\t.form-style-1 input[type=text],\n" +
				"\t\t.form-style-1 input[type=date],\n" +
				"\t\t.form-style-1 input[type=datetime],\n" +
				"\t\t.form-style-1 input[type=number],\t\t\n" +
				"\t\ttextarea,\n" +
				"\t\tselect {\n" +
				"\t\t\tbox-sizing: border-box;\n" +
				"\t\t\t-webkit-box-sizing: border-box;\n" +
				"\t\t\t-moz-box-sizing: border-box;\n" +
				"\t\t\tborder: 1px solid #BEBEBE;\n" +
				"\t\t\tpadding: 7px;\n" +
				"\t\t\tmargin: 0px;\n" +
				"\t\t\t-webkit-transition: all 0.30s ease-in-out;\n" +
				"\t\t\t-moz-transition: all 0.30s ease-in-out;\n" +
				"\t\t\t-ms-transition: all 0.30s ease-in-out;\n" +
				"\t\t\t-o-transition: all 0.30s ease-in-out;\n" +
				"\t\t\toutline: none;\n" +
				"\t\t}\n" +
				"\n" +
				"\t\t.form-style-1 input[type=text]:focus,\n" +
				"\t\t.form-style-1 input[type=date]:focus,\n" +
				"\t\t.form-style-1 input[type=datetime]:focus,\n" +
				"\t\t.form-style-1 input[type=number]:focus,\n" +
				"\t\t.form-style-1 input[type=search]:focus,\n" +
				"\t\t.form-style-1 input[type=time]:focus,\n" +
				"\t\t.form-style-1 input[type=url]:focus,\n" +
				"\t\t.form-style-1 input[type=email]:focus,\n" +
				"\t\t.form-style-1 textarea:focus,\n" +
				"\t\t.form-style-1 select:focus {\n" +
				"\t\t\t-moz-box-shadow: 0 0 8px #88D5E9;\n" +
				"\t\t\t-webkit-box-shadow: 0 0 8px #88D5E9;\n" +
				"\t\t\tbox-shadow: 0 0 8px #88D5E9;\n" +
				"\t\t\tborder: 1px solid #88D5E9;\n" +
				"\t\t}\n" +
				"\n" +
				"\t\t.form-style-1 .field-divided {\n" +
				"\t\t\twidth: 49%;\n" +
				"\t\t}\n" +
				"\n" +
				"\t\t.form-style-1 .field-long {\n" +
				"\t\t\twidth: 100%;\n" +
				"\t\t}\n" +
				"\n" +
				"\t\t.form-style-1 .field-select {\n" +
				"\t\t\twidth: 100%;\n" +
				"\t\t}\n" +
				"\n" +
				"\t\t.form-style-1 .field-textarea {\n" +
				"\t\t\theight: 100px;\n" +
				"\t\t}\n" +
				"\n" +
				"\t\t.form-style-1 input[type=submit],\n" +
				"\t\t.form-style-1 input[type=button] {\n" +
				"\t\t\tbackground: #4B99AD;\n" +
				"\t\t\tpadding: 8px 15px 8px 15px;\n" +
				"\t\t\tborder: none;\n" +
				"\t\t\tcolor: #fff;\n" +
				"\t\t}\n" +
				"\n" +
				"\t\t.form-style-1 input[type=submit]:hover,\n" +
				"\t\t.form-style-1 input[type=button]:hover {\n" +
				"\t\t\tbackground: #4691A4;\n" +
				"\t\t\tbox-shadow: none;\n" +
				"\t\t\t-moz-box-shadow: none;\n" +
				"\t\t\t-webkit-box-shadow: none;\n" +
				"\t\t}\n" +
				"\n" +
				"\t\t.form-style-1 .required {\n" +
				"\t\t\tcolor: red;\n" +
				"\t\t}\n" +
				"\t</style>\n" +
				"</head>\n" +
				"\n" +
				"<body>\n" +
				"\t<h2>Simple form servlet</h2>\n" +
				"\t<form id=\"form\" action='data' method='post'>\n" +
				"\t\t<ul class=\"form-style-1\">\n" +
				"\t\t\t<li><label>Full Name <span class=\"required\">*</span></label><input type=\"text\" name=\"firstName\" class=\"field-divided\" placeholder=\"First\" />&nbsp;<input type=\"text\" name=\"lastName\" class=\"field-divided\" placeholder=\"Last\" /></li>\n" +
				"\t\t\t<li>\n" +
				"\t\t\t\t<label>Date of birth <span class=\"required\">*</span></label>\n" +
				"\t\t\t\t<input type='date' name='someDate' class=\"field-long\" />\n" +
				"\t\t\t</li>\n" +
				"\t\t\t<li>\n" +
				"\t\t\t\t<label>Hobby</label>\n" +
				"\t\t\t\t<select name='hobby' multiple style='width:200px;'>\n" +
				"\t\t\t\t\t\t<option value='Televison'>Televison</option>\n" +
				"\t\t\t\t\t\t<option value='Music'>Music</option>\n" +
				"\t\t\t\t\t\t<option value='Sport'>Sport</option>\n" +
				"\t\t\t\t\t\t<option value='Programming'>Programming</option>\n" +
				"\t\t\t\t\t\t<option value='Gaming'>Gaming</option>\n" +
				"\t\t\t\t\t\t<option value='Books'>Books</option>\n" +
				"\t\t\t\t\t</select>\n" +
				"\t\t\t</li>\n" +
				"\t\t\t<li>\n" +
				"\t\t\t\t<label>Something about you: <span class=\"required\">*</span></label>\n" +
				"\t\t\t\t<textarea name=\"field5\" id=\"field5\" class=\"field-long field-textarea\"></textarea>\n" +
				"\t\t\t</li>\n" +
				"\t\t\t<li>\n" +
				"\t\t\t\t<label>Favourite fruit: <span class=\"required\">*</span></label>\n" +
				"\t\t\t\t<label><input type='checkbox' />Kiwi</label>\n" +
				"\t\t\t\t<label><input type='checkbox'  />Jackfruit</label>\n" +
				"\t\t\t\t<label> <input type='checkbox'  />Mango</label>\n" +
				"\t\t\t</li>\n" +
				"\t\t\t<li>\n" +
				"\t\t\t\t<label>I'm accepting the rulebook: </label>\n" +
				"\t\t\t\t<input type=\"radio\" name=\"rulebook\" />\n" +
				"\t\t\t</li>\n" +
				"\t\t\t<li>\n" +
				"\t\t\t\t<input type=\"submit\" value=\"OK\" />\n" +
				"\t\t\t</li>\n" +
				"\t\t</ul>\n" +
				"\t</form>\n" +
				"</body>\n" +
				"</html>\n");
		out.close();
	}

}
