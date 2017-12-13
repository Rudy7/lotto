package com.lotto.jse.service;

import java.util.List;
import com.lotto.jse.domain.LottoBean;

public interface LottoService {

	public List<LottoBean> showLottos();

	public void createLottos(LottoBean bean);

	int[] createLotto();
	
	
}
