package com.spring.example.springdemo.steps;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.example.springdemo.builders.PersonBuilder;
import lombok.SneakyThrows;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;


public class stepdefs {
    @SneakyThrows
    public void sendParametersAsPostQuery(final Map<String,String> parameters){
        String uri="";
        String TOKEN="1234";
        PersonBuilder buildPerson = new PersonBuilder();

        var obj = buildPerson.Build(parameters);

        ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        var jsonPayload = mapper.writeValueAsString(obj);

        Map<String, String> map = mapper.convertValue(obj, new TypeReference<Map<String,String>>(){});

        LinkedMultiValueMap<String,String> linkedMultiValueMap = new LinkedMultiValueMap<>();

        map.entrySet().forEach(e -> linkedMultiValueMap.add(e.getKey(),e.getValue()));

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl("http://localhopst:8080" + uri).queryParams(linkedMultiValueMap).build();

        String uriComponentsx = String.valueOf(uriComponents).replace(" ","%20");

        final HttpUriRequest request = RequestBuilder.post().addHeader("X-AUTH-TOKEN",TOKEN).setUri(uriComponentsx).build();

        //Send(request);

    }
}
