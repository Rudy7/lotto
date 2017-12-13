package com.lotto.jse.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.lotto.jse.domain.LottoBean;
import com.lotto.jse.service.LottoService;

public class LottoServiceImpl implements LottoService {
	private ArrayList<LottoBean> lottos;

	public LottoServiceImpl() {
		// TODO Auto-generated constructor stub
		lottos = new ArrayList<LottoBean>();

	}

	@Override
	public void createLottos(LottoBean bean) {
		// TODO Auto-generated method stub
		LottoBean lotto = null;
		if(Integer.parseInt(bean.getMoney())>5000) {
			bean.setMoney("5000");
		}
		String res = "";
		for (int i = 0; i < Integer.parseInt(bean.getMoney())/1000; i++) {
			lotto = new LottoBean();
			int[] t = createLotto();
			res += "" + t[0] + "," + t[1] + "," + t[2] + "," + t[3] + "," +t[4] + "," +t[5] + "\n";
			lotto.setNumber(res);
			lottos.add(lotto);
		}
		
	}	
	@Override
	public int[] createLotto() {
		int[] lotto = new int[6];
		for(int i=0; i<6; i++) {
			int num = (int)(Math.random()*45)+1;
			boolean exist = false;
			for(int j=0; j<lotto.length; j++) {
				if(num == lotto[j]) {
					exist = true;
					break;
				}
			}
			if(exist) {
				i--;
				continue;
			}else {
				lotto[i] = num;
			}
		}
		return lotto;
	}
			
			
			
			
//			int[] arr = new int[6];
//			for (int j=0; j<6; j++) {
//				arr[i] = (int) (Math.random() * 45) + 1; // 제이 대신에 매스.랜덤()으로 하라
//			if(arr[i]==arr[j]) {
//				
//			}
//			}
//			for (int j = 1; j <= 6; j++) {
//				System.out.print(arr[j]+"\t");
//			}
//			System.out.println();
//		}
//		System.out.println("임시 로또 :\n" + lottos);
//	}
	@Override
	public List<LottoBean> showLottos() {
		return lottos;
	}
}
	

