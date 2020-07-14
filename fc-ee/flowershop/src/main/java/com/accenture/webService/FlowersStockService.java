package com.accenture.webService;

import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@Transactional
@WebService
public interface FlowersStockService {
    @WebMethod
    void increaseFlowersStockSize(@WebParam(name = "count")int count);
}
