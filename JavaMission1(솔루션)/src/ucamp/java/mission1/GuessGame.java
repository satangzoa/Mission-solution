package ucamp.java.mission1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class GuessGame {
	private static final String PROMPT_MESSAGE = "1부터 100사이의 값을 입력하세요 : ";
	private static final int INVALID_INPUT = 999999;

	static int tryCount = 0;	//게임 시도 횟수
	
	public static void main(String[] args) {
		int randomNum = getRandomNumber(100);
		int inputNum = 0;
		
		//사용자가 난수를 맞출 때까지 반복하는 코드를 반복문(do~while)으로 작성한다.
		do {
			tryCount++;
			inputNum = getValidNumber();
			
			int diff = inputNum - randomNum;
			
			if (diff >= 10)
				System.out.println("입력하신 값은 너무 큽니다.");
			else if (diff >= 5)
				System.out.println("입력하신 값은 약간 큽니다");
			else if (diff > 0)
				System.out.println("입력하신 값은 아주 약간 큽니다.");
			else if (diff == 0) {
				System.out.println("축하합니다. " + tryCount + "번째 맞추셨습니다.");
				break;
			} else if (diff > -5)
				System.out.println("입력하신 값은 아주 약간 작습니다.");
			else if (diff > -10)
				System.out.println("입력하신 값은 약간 작습니다.");
			else
				System.out.println("입력하신 값은 너무 작습니다.");
			
		} while(inputNum != randomNum);
	}
	
	public static int getValidNumber() 
	{
		int inputNum;
		
		//"1부터 100사이의 값을 입력하세요 : " 메시지를 화면에 출력하고, 
		//사용자로부터 숫자를 입력 받아 그 수를 리턴한다. 
		//만약 사용자가 입력한 값이 숫자가 아니거나 1부터 100사이의 값이 아닌 경우, 
		//올바른 숫자를 입력할 때까지 메시지를 출력하고 숫자의 입력 작업을 반복한다. 
		
		do {
			System.out.print("[" + tryCount + "번째 시도]1부터 100사이의 값을 입력하세요 : ");
			inputNum = inputNumber();
		} while(inputNum == INVALID_INPUT || inputNum < 1 || inputNum > 100);
		
		return inputNum;
	}
	
	public static int inputNumber() {
		String inputData = null;
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			inputData = in.readLine();
			
			return Integer.parseInt(inputData);
		} catch(Exception e) {
			return INVALID_INPUT;
		}
	}
	
	private static int getRandomNumber(int maxNum) {
		return new Random().nextInt(100) + 1;
	}
}
