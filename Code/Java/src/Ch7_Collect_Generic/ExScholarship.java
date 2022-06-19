package Ch7_Collect_Generic;
import java.util.*;

public class ExScholarship {
    Scanner Scan = new Scanner(System.in);
    HashMap<String, Double> H = new HashMap<>();
    Vector<String> passStudent = new Vector<>();

    public void read(){
        System.out.println("미래장학금관리시스템입니다.");
        for(int i=0;i<5;i++){
            System.out.print("이름과 학점 >> ");
            String name = Scan.next();
            double score = Scan.nextDouble();
            H.put(name,score);
        }
    }
    public double passStandard(){
        System.out.print("장학생 선발 학점 기준 >> ");
        double passScore=Scan.nextDouble();
        return passScore;
    }
    public void writePass(double pScore){
        Set<String> Keys = H.keySet();
        Iterator<String> it = Keys.iterator();
        while(it.hasNext()){
            String Key=it.next();
            double Score = H.get(Key);
            if(Score>pScore) passStudent.add(Key);
        }
        System.out.print("장학생 명단");
        for(int i =0; i<passStudent.size();i++){
            System.out.print(" "+passStudent.get(i));
        }
    }
    public void run(){
        read();
        double pScore=passStandard();
        writePass(pScore);
    }
    public static void main(String[]args){
        ExScholarship Game = new ExScholarship();
        Game.run();
    }
}
