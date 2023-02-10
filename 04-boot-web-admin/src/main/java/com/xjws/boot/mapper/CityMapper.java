package com.xjws.boot.mapper;

import com.xjws.boot.pojo.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @author xujian
 * @create 2023-02-06 16:59
 */
@Mapper
public interface CityMapper {
    @Select("select * from city where id = #{id}")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    City queryCity(Long id);


    @Insert("INSERT INTO city(`name`,`state`,`country`) VALUES(#{name},#{state},#{country})")
    void insertCity(City city);
}
