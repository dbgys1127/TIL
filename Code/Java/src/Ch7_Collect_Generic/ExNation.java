package Ch7_Collect_Generic;

public class ExNation <T> {
    T country;
    T capital;

    public ExNation(T country, T capital){
        this.country=country;
        this.capital=capital;
    }
    public T getCountry(){
        return country;
    }
    public T getCapital(){
        return capital;
    }
}
