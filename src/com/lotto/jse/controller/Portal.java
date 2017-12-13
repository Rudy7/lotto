package com.lotto.jse.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JOptionPane;

import com.lotto.jse.constants_pool.Value;
import com.lotto.jse.domain.LottoBean;
import com.lotto.jse.service.LottoService;
import com.lotto.jse.serviceImpl.LottoServiceImpl;
public class Portal {
//		천원~ 5천원까지 받고,  900원이면 안 팔아요.
//		얼마냐 살거냐고 물어봐.  3천원이라고 말하면  그걸 입력받는데 그건 객체의 프로퍼티가 된다. 
//		로또빈을 만드시라는 거에요. 
//		돈을 받았어요. 제가. 3천원을 받으면 랜덤숫자 3줄을 주겠죠.  그것도 보여주는 객체가 되겠죠. 
//		프로퍼티는  받는 돈하고,  머니,    숫자,   넘버 두가지만 되겠죠. 
//      0.종료 1. 구매금액확인(얼마나 사시나요?)(3천원 받고, 랜덤숫자 만들어야한다.1~45중에서 뽑는다. 6번. 겹쳐지면 안돼요. 카운터 --??)
//		추출해서 어레이스에 갖고 있을거에요. 출력을 하면. 
//		2. 로또번호생성. 만들어서 가지고 있기.  누르면 보여주기
//		3. 번호 보여주기. 로컬로 프린트. 
//	1 메뉴
//	2 모니터로 숫자를 본다
//	3 출력
//	1200 : 1 2 3 4 5 6
//	2700 : 1 2 3 4 5 6  역슬러시
//	       1 2 3 4 5 6
//	3500 : 1 2 3 4 5 6
//	 	   1 2 3 4 5 6  역슬러시
//   	   1 2 3 4 5 6
//	10000: 5줄만 나오게. 맥시멈 5개만, 잔돈은 안해도 된다. 

	private static BufferedWriter bw;

	public static void main(String[] args) {
		LottoService service = new LottoServiceImpl();
		LottoBean lotto = new LottoBean();
		while(true) {
			switch(JOptionPane.showInputDialog(Value.MENU)) {
				case "0":
					JOptionPane.showMessageDialog(null, "거래가 종료되었습니다.");
					return;
				case "1":
					lotto.setMoney(JOptionPane.showInputDialog("enter  구매가격"));
					service.createLottos(lotto);
					break;
				case "2":
					String message = service.showLottos().toString();
					
					JOptionPane.showMessageDialog(null, message);	
					break;
				case "3":    //p.388
					int[] ar1 = new int[6];
					
					Arrays.sort(ar1);
					
					File f = new File("C:\\Users\\1027\\jse\\eclipse\\workspace\\lotto\\lotto.txt");  //workspace\\lotto 여기까지는 프로젝트이름이다.
					try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(f));
					bw.write("로또번호 : 1 2 3 4 5 6");
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
						bw.flush();
						bw.close();
					}	catch (IOException e) {
						e.printStackTrace();
					}
					}
					JOptionPane.showMessageDialog(null, "");
					break;
				default:
						break;
			}
		}
	}	
}	
	












