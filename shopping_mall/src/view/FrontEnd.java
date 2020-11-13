package view;
import java.util.Scanner;

public class FrontEnd {
	public FrontEnd() {
		this.Control();
	}
	private void Control() {
		
		String title = this.CreateTitle();
		String menu1 = this.CreateMenu("1. 로그인          2. 회원가입.");
		String state1 = this.CreateState("MAIN");
		
		while(true) {
			
			this.Output(title);
			this.Output(state1);
			this.Output(menu1);;
			if(this.Input().equals("0")) {break;}
		}
		
	}
	
	private String CreateTitle() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("**********************************\n");
		sb.append("*                                *\n");
		sb.append("*            BIG MARKET          *\n");
		sb.append("*                 MADE BY WBKIM  *\n");
		sb.append("*                                *\n");
		sb.append("**********************************\n");
		return sb.toString();
	}
	
	private String CreateState(String state) {
		StringBuffer sb = new StringBuffer();
		sb.append("[ "+state+" ]\n");
		return sb.toString() ;
	}
	
	private String CreateMenu(String menu) {
		StringBuffer sb = new StringBuffer();
		sb.append("**********************************\n");
		sb.append("* "+menu+" *\n");
		sb.append("*******************************: ");
		
		return sb.toString() ;	
	}
	
	
	private String Input() {
		Scanner scan  = new Scanner(System.in);
		return scan.nextLine();
	}
	private void Output(String text) {
		System.out.print(text+'\n');		
	}
}
