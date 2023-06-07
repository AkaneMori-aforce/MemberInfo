package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.MemberInfoDAO;

/**
 * Servlet implementation class Register
 */
@WebServlet("/jp.co.aforce.servlet/delete")
public class Delete extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
			String member_id = (String)request.getSession().getAttribute("id");
			
			MemberInfoDAO dao = new MemberInfoDAO();
			int line = dao.delete(member_id);
			
			if(line == 1) {
				request.setAttribute("success", "会員情報を削除しました。");
				request.getRequestDispatcher("/views/delete.jsp").forward(request, response);
			}else {
				request.setAttribute("failure", "会員情報が削除できませんでした。");
				request.getRequestDispatcher("/views/delete.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
