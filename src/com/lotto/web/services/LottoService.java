package com.lotto.web.services;

import com.lotto.web.domains.LottoBean;

public interface LottoService {
	public void createLotto(LottoBean param);
	public String createLotteryNum();
	public String createLottoSeq();
	public String createBall();
	public boolean duplicatePrevention(int[] arr);
	public String ascendingSort(int[] arr);
}

