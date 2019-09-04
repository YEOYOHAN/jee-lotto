package com.lotto.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lotto.web.pool.Constants;
import com.lotto.web.domains.ConsumerBean;
import com.lotto.web.serviceImpls.ConsumerServiceImpl;
import com.lotto.web.services.ConsumerService;


@WebServlet("/consumer.do")
public class ConsumerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		switch (request.getParameter("action")) {
		case "move":
			request.getRequestDispatcher(String.format(Constants.VIEW_PATH,"consumer", request.getParameter("dest")))
					.forward(request, response);
			break;
		case "join":
			String cid = request.getParameter("cid");
			String pass = request.getParameter("pass");
			ConsumerBean param = new ConsumerBean();
			param.setCid(cid);
			param.setPass(pass);
			ConsumerService service = new ConsumerServiceImpl();
			service.registerConsumer(param);
			System.out.println(request.getParameter("dest"));
			request.getRequestDispatcher(String.format(Constants.VIEW_PATH, "consumer", request.getParameter("dest")))
					.forward(request, response);
			System.out.println(param.toString());
			break;
		case "login":
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
