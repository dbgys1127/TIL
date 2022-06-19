package Ch7_Collect_Generic;
import java.util.*;

public class ExStudentAppVer1 {
    Scanner Scan = new Scanner(System.in);
    HashMap<String,ExStudentVer1> h = new HashMap<>();
    public void Write(){
        System.out.println("학생 이름, 학과, 학번, 학점평균 입력하세요.");
        for(int i=0;i<4;i++){
            System.out.print(">> ");
            String str = Scan.nextLine();
            StringTokenizer St=new StringTokenizer(str,", ");
            String name = St.nextToken();
            //if(name.equals("그만")){System.out.println("종료합니다."); return;}
            String major =St.nextToken();
            String grade = St.nextToken();
            String score = St.nextToken();
            ExStudentVer1 Student = new ExStudentVer1(major,grade,score);
            h.put(name,Student);
        }
    }
    public void ViewAll(){
        Set<String> Keys = h.keySet();
        Iterator<String> it = Keys.iterator();
        while(it.hasNext()){
            String Key = it.next();
            ExStudentVer1 Student = h.get(Key);
            System.out.println("----------------");
            System.out.println("이름 : "+Key);
            System.out.println("학과 : "+Student.getMajor());
            System.out.println("학번 : "+Student.getGrade());
            System.out.println("학점 : "+Student.getScore());
        }
        System.out.println("----------------");
    }
    public void SerchStudent(){
        while(true){
            System.out.print("학생 이름 >>");
            String find = Scan.next();
            if(find.equals("그만")){System.out.println("종료합니다."); break;}
            ExStudentVer1 Student = h.get(find);
            if(Student==null)System.out.println(find+" 학생은 없습니다.");
            else{
            System.out.print(find+", "+Student.getMajor()+", "+Student.getGrade()+", "+Student.getScore());
            }
        }
    }
    public void run(){
        Write();
        ViewAll();
        SerchStudent();
    }
    public static void main(String[]args){
        ExStudentAppVer1 Game = new ExStudentAppVer1();
        Game.run();
    }
}
