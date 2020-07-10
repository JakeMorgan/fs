package com.accenture.webService;

import javax.xml.ws.Endpoint;


public class FlowersStockServiceEndpoint {
    public static void main(String[] args){
        Endpoint.publish("http://localhost:8080/ws/FlowersStockService",
                new FlowersStockServiceImpl());
    }
}
