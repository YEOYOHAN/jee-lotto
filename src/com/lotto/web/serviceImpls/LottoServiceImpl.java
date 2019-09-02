package com.lotto.web.serviceImpls;

import java.util.Random;

import com.lotto.web.doalmpls.LottoDAOImpl;
import com.lotto.web.doas.LottoDAO;
import com.lotto.web.domains.LottoBean;
import com.lotto.web.services.LottoService;

public class LottoServiceImpl implements LottoService{
	private LottoDAO dao;
	
	public LottoServiceImpl() {
		dao = new LottoDAOImpl();
	}
	@Override
	public void createLotto(LottoBean param) {
		param.setLotteryNum(createLotteryNum());
		param.setBall(createBall());
		param.setLottoSeq(createLottoSeq());
		dao.insertLotto(param);
		
	}
	@Override
	public String createLotteryNum() {
		String flag ="";		
			return flag;
	}
	@Override
	public String createLottoSeq() {
		Random r = new Random();
		String flag ="No.";
		for(int i=0;i<4;i++) {
			flag += r.nextInt(9)+"";
		}
		return flag;
	}
	@Override
	public String createBall() {
		return new Random().nextInt(45)+1+"";
	}
	@Override
	public boolean duplicatePrevention(int[] arr) {
		boolean flag = true;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(i!=j && arr[i]==arr[j]) {
					flag = true;
					break;
				}else {
					flag = false;
				}
			}
			if(flag) {
				i--;
			}
		}
		return flag;
	}
	@Override
	public String ascendingSort(int[] arr) {
		String flag = "";
		return flag;
	}

}
