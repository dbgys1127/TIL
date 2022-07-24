package CodeStatesString;

public class test {
    /**
     *
     * @param str
     * @return
     */
    public String letterCapitalize(String str) {
        // TODO:
        if(str.length()==0)
            return "";
        String [] storage = str.split(" ");
        String result ="";
        for(int i=0 ; i<storage.length ; i++){
            String first = storage[i].substring(0,1);
            String second = storage[i].substring(1,storage[i].length());
            first = first.toUpperCase();
            storage[i]=first+second;
        }
        for(int i =0;i<storage.length;i++){
            result+=storage[i]+" ";
        }
        return result;
    }

    public static void main(String[] args) {
        test t = new test();
        System.out.println(t.letterCapitalize("nEVER gIVE uP"));
    }
}
