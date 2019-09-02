package com.lotto.web.serviceImpls;

import com.lotto.web.doalmpls.ConsumerDAOImpl;
import com.lotto.web.doas.ConsumerDAO;
import com.lotto.web.domains.ConsumerBean;
import com.lotto.web.services.ConsumerService;

public class ConsumerServiceImpl implements ConsumerService{
	private ConsumerDAO dao;
	public ConsumerServiceImpl() {
		dao = new ConsumerDAOImpl();
	}
	public void registerConsumer(ConsumerBean param) {
		dao.insertConsumer(param);
		
		
	}

}
