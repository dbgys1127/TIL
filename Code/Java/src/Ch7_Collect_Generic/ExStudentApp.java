package Ch7_Collect_Generic;
import  java.util.*;

public class ExStudentApp {
    public static void main(String[]args){
        ExStudent[] Student=new ExStudent[4];
        String Array[] =new String[4];
        Scanner Scan = new Scanner(System.in);
        ArrayList<ExStudent> Game = new ArrayList<>();

        System.out.println("학생이름, 학과, 학번, 학점평균을 입력하세요.");
        for(int i=0;i<Student.length;i++){
            System.out.print(">> ");
            String str=Scan.nextLine();
            StringTokenizer st = new StringTokenizer(str,", ");
            int n = st.countTokens();
            for(int j=0;j<n;j++){
                String token = st.nextToken();
                Array[j]=token;
            }
            Student[i]=new ExStudent(Array[0],Array[1],Array[2],Array[3]);
            Game.add(Student[i]);
        }
        for(int i=0;i<Student.length;i++){
            System.out.println("----------------------------");
            ExStudent b = Game.get(i);
            String name = b.getName();
            String major = b.getMajor();
            String grade = b.getGrade();
            String score = b.getScore();
            System.out.println("이름 : "+name);
            System.out.println("학과 : "+major);
            System.out.println("학번 : "+grade);
            System.out.println("학점 : "+score);
        }
        System.out.println("----------------------------");
        while(true){
            int i=0;
            System.out.print("학생 이름 >> ");
            String name = Scan.next();
            if(name.equals("그만")) {System.out.println("종료합니다.");break;}
            for(i=0;i<Student.length;i++) {
                ExStudent b = Game.get(i);
                String name1 = b.getName();
                String major = b.getMajor();
                String grade = b.getGrade();
                String score = b.getScore();
                if (name1.equals(name)) {
                    System.out.println(name1 + ", " + major + ", " + grade + ", " + score);
                    break;
                }
            }
            if(i==4)System.out.println(name+" 학생은 없습니다.");
        }
    }
}
