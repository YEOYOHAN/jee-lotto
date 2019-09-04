package com.lotto.web.daolmpls;

import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;

import com.lotto.web.daos.LottoDAO;
import com.lotto.web.domains.LottoBean;

public class LottoDAOImpl implements LottoDAO{
	public static final String FILE_PATH = String.format("C:%sUsers%suser%seclipse-jee%sjee-lotto%sWebContent%sresources%stxt%s",
			File.separator,
			File.separator,
			File.separator,
			File.separator,
			File.separator,
			File.separator,
			File.separator,
			File.separator);

	@Override
	public void insertLotto(LottoBean param) {
		try {
			File file = new File(FILE_PATH + "lottoNum.txt");
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(String.format("%s/%s", param.getLottoSeq(), param.getLotteryNum()));
			writer.newLine();
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}