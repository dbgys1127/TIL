package Ch3_Array;
import java.util.Scanner;
public class RandomRockPaperScissor {
	public static void main(String[]args) {
		Scanner User =new Scanner(System.in);
		String NPC[]= {"����","����","��"};
		
		while(true) {
			System.out.println("���� ���� ���� �����մϴ�!");
			System.out.print("���� ���� ��!!! >> ");
			String UserWhat=User.next();
			int n = (int)(Math.random()*3);
			if(UserWhat.equals("�׸�")) {
				System.out.println("������ �����մϴ�.");
			}
			if(UserWhat.equals("����")) {
				if(NPC[n].equals("����")) {
					System.out.println("NPC�� ������ �½��ϴ�. �����ϴ�.");
				}
				else if(NPC[n].equals("����")) {
					System.out.println("NPC�� ������ �½��ϴ�. ����� �����ϴ�.");
				}
				else if(NPC[n].equals("��")) {
					System.out.println("NPC�� ���� �½��ϴ�. ����� �̰���ϴ�.");
				}
			}else if(UserWhat.equals("����")) {
				if(NPC[n].equals("����")) {
					System.out.println("NPC�� ������ �½��ϴ�. ����� �̰���ϴ�.");
				}
				else if(NPC[n].equals("����")) {
					System.out.println("NPC�� ������ �½��ϴ�. �����ϴ�.");
				}
				else if(NPC[n].equals("��")) {
					System.out.println("NPC�� ���� �½��ϴ�. ����� �����ϴ�.");
				}
			}else if(UserWhat.equals("��")) {
				if(NPC[n].equals("����")) {
					System.out.println("NPC�� ������ �½��ϴ�. ����� �����ϴ�.");
				}
				else if(NPC[n].equals("����")) {
					System.out.println("NPC�� ������ �½��ϴ�. �̰���ϴ�.");
				}
				else if(NPC[n].equals("��")) {
					System.out.println("NPC�� ���� �½��ϴ�. �����ϴ�.");
				}
			}
		}
	}
}
