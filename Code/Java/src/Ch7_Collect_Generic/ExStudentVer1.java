package Ch7_Collect_Generic;

public class ExStudentVer1 {
    private String major;
    private String grade;
    private String score;
    public ExStudentVer1(String major, String grade, String score){
        this.major=major;
        this.grade=grade;
        this.score=score;
    }
    public String getMajor(){
        return major;
    }
    public String getGrade(){
        return grade;
    }
    public String getScore(){
        return score;
    }
}