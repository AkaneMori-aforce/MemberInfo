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
@WebServlet("/jp.co.aforce.servlet/search")
public class Search extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
			String member_id = request.getParameter("member_id");
			
			MemberInfoDAO dao = new MemberInfoDAO();
			MemberInfo info = dao.search(member_id);
			
			if(info != null) {
				request.setAttribute("member_id", info.getMemberId());
				request.setAttribute("last_name", info.getLastName());
				request.setAttribute("first_name", info.getFirstName());
				request.setAttribute("gender", info.getGender());
				request.setAttribute("birth_year", info.getBirthYear());
				request.setAttribute("birth_month", info.getBirthMonth());
				request.setAttribute("birth_day", info.getBirthDay());
				request.setAttribute("phone_number", info.getPhoneNumber());
				request.setAttribute("email_address", info.getEmailAddress());
				request.setAttribute("job", info.getJob());
				request.getRequestDispatcher("/views/search.jsp").forward(request, response);
			}else {
				request.setAttribute("failure_id", member_id);
				request.setAttribute("failure_msg", "検索結果がありません");
				request.getRequestDispatcher("/views/search.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
