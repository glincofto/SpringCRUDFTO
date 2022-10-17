package com.capacitacionfto.crud.mapper;

import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;

public class Mapper {
    private ModelMapper mapper = new ModelMapper();

    public Mapper() {
    }

    public ModelMapper getMapper() {
        return mapper;
    }

    public void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public void map(Object source, Type destinationType){
        mapper.map(source,destinationType);
    }
}
