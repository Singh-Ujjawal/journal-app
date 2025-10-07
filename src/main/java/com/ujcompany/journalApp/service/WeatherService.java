package com.ujcompany.journalApp.service;

import com.ujcompany.journalApp.api.response.WeatherResponse;
import com.ujcompany.journalApp.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    @Value("${weather.api.key}") //From properties
    private String apiKey;

    @Autowired
    private AppCache appCache;

    @Autowired
    RedisService redisService;

    private RestTemplate restTemplate =  new RestTemplate();

    public WeatherResponse getWeather(String city) {
        WeatherResponse weatherResponse = redisService.get("weather_of_" + city,WeatherResponse.class);
        if(weatherResponse!=null){
            return weatherResponse;
        }
        else {
            String finalAPI = appCache.APP_CACHE.get("weather_api").replace("<city>", city).replace("<apiKey>", apiKey);
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
            WeatherResponse body = response.getBody();
            if(body!=null){
                redisService.set("weather_of_" + city,body,300l);
            }
            return body;
        }
    }
}
