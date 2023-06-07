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
 * Servlet implementation class Register
 */
@WebServlet("/jp.co.aforce.servlet/regist")
public class Regist extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
			
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
						
			MemberInfoDAO dao = new MemberInfoDAO();
			int line = dao.regist(i);
			
			if (line == 1) {

				MemberInfoDAO dao2 = new MemberInfoDAO();
				MemberInfo info = dao2.id_search(email_address);
				
				request.setAttribute("member_id", info.getMemberId());
				request.getRequestDispatcher("/views/regist-success.jsp").forward(request, response);
			}else {
				//遷移できない
				request.setAttribute("failure", "会員情報が登録できませんでした。");
				request.getRequestDispatcher("/views/regist.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
