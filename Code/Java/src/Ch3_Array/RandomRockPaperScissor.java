package Ch3_Array;
import java.util.Scanner;
public class RandomRockPaperScissor {
	public static void main(String[]args) {
		Scanner User =new Scanner(System.in);
		String NPC[]= {"가위","바위","보"};
		
		while(true) {
			System.out.println("가위 바위 보를 시작합니다!");
			System.out.print("가위 바위 보!!! >> ");
			String UserWhat=User.next();
			int n = (int)(Math.random()*3);
			if(UserWhat.equals("그만")) {
				System.out.println("게임을 종료합니다.");
			}
			if(UserWhat.equals("가위")) {
				if(NPC[n].equals("가위")) {
					System.out.println("NPC는 가위를 냈습니다. 비겼습니다.");
				}
				else if(NPC[n].equals("바위")) {
					System.out.println("NPC는 바위를 냈습니다. 당신이 졌습니다.");
				}
				else if(NPC[n].equals("보")) {
					System.out.println("NPC는 보를 냈습니다. 당신이 이겼습니다.");
				}
			}else if(UserWhat.equals("바위")) {
				if(NPC[n].equals("가위")) {
					System.out.println("NPC는 가위를 냈습니다. 당신이 이겼습니다.");
				}
				else if(NPC[n].equals("바위")) {
					System.out.println("NPC는 바위를 냈습니다. 비겼습니다.");
				}
				else if(NPC[n].equals("보")) {
					System.out.println("NPC는 보를 냈습니다. 당신이 졌습니다.");
				}
			}else if(UserWhat.equals("보")) {
				if(NPC[n].equals("가위")) {
					System.out.println("NPC는 가위를 냈습니다. 당신이 졌습니다.");
				}
				else if(NPC[n].equals("바위")) {
					System.out.println("NPC는 바위를 냈습니다. 이겼습니다.");
				}
				else if(NPC[n].equals("보")) {
					System.out.println("NPC는 보를 냈습니다. 비겼습니다.");
				}
			}
		}
	}
}
