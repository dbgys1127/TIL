package observerpattern.observer;

import observerpattern.subject.WeatherData;

public class ForecastDisplay implements Observer,DisplayElement{
    private float currentPressure = 29.92f;
    private float lastPressure;
    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("현재기압 = "+currentPressure+" 최근기압 = "+lastPressure);
    }

    @Override
    public void update() {
        lastPressure=currentPressure;
        currentPressure= weatherData.getPressure();
        display();
    }
}
