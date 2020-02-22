package com.example.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EmployeeRepository {
    private static Map<Long,Employee> store= new ConcurrentHashMap<>();

    public Employee add(Employee e){
        if(store.get(e.getId())!=null){
            throw new HttpClientErrorException(HttpStatus.FORBIDDEN,"Use PUT request instead of POST");
        }
        store.put(e.getId(),e);
        return e;
    }
    public Employee get(Long id){
        return store.get(id);
    }

}
