package Ch7_Collect_Generic;

public class ExStudent {
    private String name;
    private String major;
    private String grade;
    private String score;
    public ExStudent(String name, String major, String grade, String score){
        this.name=name;
        this.major=major;
        this.grade=grade;
        this.score=score;
    }
    public String getName(){
        return name;
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
