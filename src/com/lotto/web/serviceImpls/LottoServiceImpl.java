package com.lotto.web.serviceImpls;

import java.util.Random;

import com.lotto.web.daolmpls.LottoDAOImpl;
import com.lotto.web.daos.LottoDAO;
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
		param.setBall(createBall() + "");
		param.setLottoSeq(createLottoSeq());
		dao.insertLotto(param);
	}

	@Override
	public String createLotteryNum() {
		String flag = "";
		int[] arr = new int[6];
		for (int i = 0; i < arr.length; i++) {
			int a = createBall();
			if (!exist(arr, a)) {
				arr[i] = a;
			} else {
				i--;
			}
		}
		arr = bubbleSort(arr, true);
		for (int i = 0; i < arr.length; i++) {
			flag += arr[i] + ",";
		}
		return flag;
	}

	@Override
	public String createLottoSeq() {
		Random r = new Random();
		String flag = "No.";
		for (int i = 0; i < 4; i++) {
			flag += r.nextInt(9) + "";
		}
		return flag;
	}

	@Override
	public int createBall() {
		return (int) (Math.random() * 45) + 1;
	}

	@Override
	public boolean exist(int[] arr, int a) {
		boolean flag = false;
		for (int i : arr) {
			if (a == i) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public int[] bubbleSort(int[] arr, boolean flag) {
		int t = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (flag) {
					if (arr[j] > arr[j + 1]) {
						t = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = t;
					}
				} else {
					if (arr[j] < arr[j + 1]) {
						t = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = t;
					}
				}

			}
		}
		return arr;
	}

}
