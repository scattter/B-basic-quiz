package com.example.demo.serializer;

import com.example.demo.entity.PersonEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class UserIdSerial extends JsonSerializer<PersonEntity> {
    @Override
    public void serialize(PersonEntity value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeNumber(value.getId());
    }
}
