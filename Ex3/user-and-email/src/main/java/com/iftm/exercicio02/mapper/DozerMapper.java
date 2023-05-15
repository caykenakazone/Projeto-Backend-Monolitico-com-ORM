package com.iftm.exercicio02.mapper;


import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.iftm.exercicio02.data.vo.GroupVO;
import com.iftm.exercicio02.models.Group;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

@Configuration
public class DozerMapper {


    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObject(List<O> origin, Class<D> destination) {
        List<D> destinationObjects = new ArrayList<D>();
        for(O o : origin) {
            destinationObjects.add(mapper.map(o, destination));
        }
        return destinationObjects;
    }


}
