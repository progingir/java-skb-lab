package com.example.demo.service;

import com.example.demo.model.RequestData;
import com.example.demo.model.ResponseData;
import org.springframework.stereotype.Service;

@Service
public class JsonProcessingService {

    public ResponseData process(RequestData requestData) {
        ResponseData.Info info = new ResponseData.Info(123, requestData.info().date());
        return new ResponseData(requestData.price(), info);
    }
}