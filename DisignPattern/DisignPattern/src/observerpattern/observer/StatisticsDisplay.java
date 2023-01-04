package observerpattern.observer;

import observerpattern.subject.Subject;
import observerpattern.subject.WeatherData;

public class StatisticsDisplay implements Observer,DisplayElement{
    private float temperature;
    private float maxTemperature=Float.MIN_VALUE;
    private float minTemperature=Float.MAX_VALUE;
    private float avgTemperature=0;
    private float sum=0;
    private float count=0;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("평균/최고/최저 온도 = "+avgTemperature+"/"+maxTemperature+"/"+minTemperature);
    }

    @Override
    public void update() {
        temperature = weatherData.getTemperature();
        sum+= temperature;
        count++;
        avgTemperature=sum/count;
        if(temperature>maxTemperature) maxTemperature=temperature;
        if(temperature<minTemperature) minTemperature=temperature;
        display();
    }
}
