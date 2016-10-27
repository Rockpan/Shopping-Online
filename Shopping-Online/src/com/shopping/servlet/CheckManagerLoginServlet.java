package com.shopping.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.service.CheckUsernameService;

/**
 * 
 * @author ��ϣ��
 *
 */
public class CheckManagerLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + ".........." + password);

		CheckUsernameService s = new CheckUsernameService();
		int isChecked = s.checkExist(username, password);
		if (isChecked == 1) {
			System.out.println("isChecked1......" + isChecked);
			response.sendRedirect(request.getContextPath() + "/manager_page.jsp");
		} else {
			System.out.println("isChecked2......" + isChecked);
			HttpSession session = request.getSession();
			session.setAttribute("LoginError", "error");
			request.getRequestDispatcher("/manager_login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
