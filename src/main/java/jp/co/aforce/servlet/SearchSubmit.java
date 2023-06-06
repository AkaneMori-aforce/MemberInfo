package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/jp.co.aforce.servlet/search-submit")
public class SearchSubmit extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("edit") != null) {
			String id = (String) request.getAttribute("id");
			String last_name = (String) request.getAttribute("last_name");
			String first_name = (String) request.getAttribute("first_name");
			String gender = (String) request.getAttribute("gender");
			String birth_year = (String) request.getAttribute("birth_year");
			String birth_month = (String) request.getAttribute("birth_month");
			String birth_day = (String) request.getAttribute("birth_day");
			String tel = (String) request.getAttribute("tel");
			String email = (String) request.getAttribute("email");
			String job = (String) request.getAttribute("job");
			
			request.setAttribute("id", id);
			request.setAttribute("last_name", last_name);
			request.setAttribute("first_name", first_name);
			request.setAttribute("gender", gender);
			request.setAttribute("birth_year", birth_year);
			request.setAttribute("birth_month", birth_month);
			request.setAttribute("birth_day", birth_day);
			request.setAttribute("tel", tel);
			request.setAttribute("email", email);
			request.setAttribute("job", job);
			
			request.getRequestDispatcher("/views/edit.jsp").forward(request, response);
			} else if (request.getParameter("delete") != null) {
				request.setAttribute("forward", "delete.jsp");
				request.getRequestDispatcher("/views/delete.jsp").forward(request, response);
			}
		
	}

}
