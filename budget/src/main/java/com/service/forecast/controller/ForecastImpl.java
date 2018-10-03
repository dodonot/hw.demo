package com.service.forecast.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ufgov.budget.BudgetDto;

import javax.ws.rs.core.MediaType;

//@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2017-11-01T10:16:52.801+08:00")

@RestSchema(schemaId = "budget")
@RequestMapping(path = "/budget", produces = MediaType.APPLICATION_JSON)
public class ForecastImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(ForecastImpl.class);

    @Autowired
    private ForecastImplDelegate userForecastweatherdataDelegate;

    @RequestMapping(value = "/show", produces = { "application/json" }, method = RequestMethod.GET)
    public String getForecast(@RequestParam(value = "city", required = true) String city) {
        LOGGER.info("getForecast() is called, city = [{}]", city);
        return new JsonObject(Json.encode(userForecastweatherdataDelegate.showForecastWeather(city))).toString();
    }

    @ResponseBody
    @RequestMapping(value = "/getBill", method = RequestMethod.GET)
    public BudgetDto getBill(@RequestParam(value = "vouid", required = true) String vouid) {
        BudgetDto dto = new BudgetDto(vouid, "5020101", "事业经费", "305001", "教育局", "陕财办教[2018]005号", "1", "国库集中支付", "1", "基本支出", "11", "一般公共预算", 1,
                8000.00);
        LOGGER.debug("--- BudgetServiceImpl.getBill()  ret = " + dto);
        return dto;
    }

}
