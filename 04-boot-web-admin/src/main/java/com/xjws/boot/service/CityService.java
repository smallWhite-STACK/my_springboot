package com.xjws.boot.service;

import com.xjws.boot.mapper.CityMapper;
import com.xjws.boot.pojo.City;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xujian
 * @create 2023-02-06 17:05
 */
@Service
public class CityService {
    Counter counter;
    @Autowired
    CityMapper cityMapper;
    public CityService(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("cityService.savecity.count");

    }


    public City queryCity(Long id){
        counter.increment();

        City city = cityMapper.queryCity(id);
        return city;

    }

    public void insertCity(City city){
        cityMapper.insertCity(city);
    }
}
