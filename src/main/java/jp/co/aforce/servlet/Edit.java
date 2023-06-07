package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.MemberInfo;
import jp.co.aforce.dao.MemberInfoDAO;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/jp.co.aforce.servlet/edit")
public class Edit extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {request.setCharacterEncoding("UTF-8");
			
			String member_id = request.getParameter("member_id");
			String last_name = request.getParameter("last_name");
			String first_name = request.getParameter("first_name");
			String gender = request.getParameter("gender");
			String birth_year = request.getParameter("birth_year");
			String birth_month = request.getParameter("birth_month");
			String birth_day = request.getParameter("birth_day");
			String phone_number = request.getParameter("phone_number");
			String email_address = request.getParameter("email_address");
			String job = request.getParameter("job");
			
			MemberInfo i = new MemberInfo();
			i.setLastName(last_name);
			i.setFirstName(first_name);
			i.setGender(gender);
			i.setBirthYear(birth_year);
			i.setBirthMonth(birth_month);
			i.setBirthDay(birth_day);
			i.setPhoneNumber(phone_number);
			i.setEmailAddress(email_address);
			i.setJob(job);
			i.setMemberId(member_id);
		
			MemberInfoDAO dao = new MemberInfoDAO();
			int line = dao.edit(i);
			
			if (line == 1) {
				request.getRequestDispatcher("/views/edit-success.jsp").forward(request, response);
			}else {
				request.setAttribute("failure", "会員情報が更新できませんでした。");
				request.getRequestDispatcher("/views/edit.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
