import java.lang.*;

public class ddd {
        public String makeMarginalString(String str) {
            // TODO:
            if(str==""){
                return "";
            }
            for(int i=0;i<str.length();i++){
                for(int j=0;j<=i;j++){
                    str+=str.charAt(j);
                }
            }
            return str;
        }


    public static void main(String[] args) {
        ddd d = new ddd();
        System.out.println(d.makeMarginalString("flower"));
    }
}
