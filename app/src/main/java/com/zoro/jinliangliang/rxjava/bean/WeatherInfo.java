package com.zoro.jinliangliang.rxjava.bean;

import java.io.Serializable;

/**
 * Created by Zoro
 * Created on 2020/12/16
 * description:
 */
public class WeatherInfo implements Serializable {
    private String weather;
    private String temperature;

    public String getWeather() {
        return weather == null ? "" : weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemperature() {
        return temperature == null ? "" : temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
