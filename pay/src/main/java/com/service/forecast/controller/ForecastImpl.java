package com.service.forecast.controller;

import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.ufgov.budget.BudgetDto;
import com.yygov.demo.api.PayDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

@RestSchema(schemaId = "pay")
@RequestMapping(path = "/pay", produces = MediaType.APPLICATION_JSON)
public class ForecastImpl {
    private static final Logger LOGGER = LoggerFactory.getLogger(ForecastImpl.class);

    private List<String> processedTransId = new ArrayList<String>();
    private Double processedTotal = 0.0;

    @Autowired
    private ForecastImplDelegate userForecastweatherdataDelegate;

    @RequestMapping(value = "/show", produces = { "application/json" }, method = RequestMethod.GET)
    public String getForecast(@RequestParam(value = "city", required = true) String city) {
        LOGGER.info("getForecast() is called, city = [{}]", city);
        return new JsonObject(Json.encode(userForecastweatherdataDelegate.showForecastWeather(city))).toString();
    }

    @PostMapping("/pay/{vouid}")
    public Map<String, Object> doPay(@PathVariable String vouid) {
        String budgetId = "ZB0001";
        Double payMoney = 500.00;
        PayDto payDto = new PayDto(vouid, "2010101", "行政运行", "101001", "人大办公厅", "陕财办教[2018]001号", "1", "国库集中支付", "1", "基本支出", "11", "一般公共预算",
                budgetId, "50101", "基本工资", payMoney);

        if (processedTransId.indexOf(vouid) < 0) {
            processedTotal += payMoney;
            processedTransId.add(vouid);
        }

        RestTemplate restTemplate = RestTemplateBuilder.create();
        BudgetDto budgetDto = restTemplate.getForObject("cse://budget/budget/getBill?vouid=" + vouid, BudgetDto.class);
        budgetDto.setBudgetMoney(budgetDto.getBudgetMoney() - processedTotal);

        Map<String, Object> retMap = new HashMap<String, Object>();
        retMap.put("budget", budgetDto);
        retMap.put("pay", payDto);
        if (payDto.getPayMoney() > budgetDto.getBudgetMoney()) {
            retMap.put("result", "处理结果：支付金额大于指标额度。拒绝支付！");
        } else {
            retMap.put("result", "处理结果：支付金额小于指标额度。允许支付！");
        }
        return retMap;
    }

}
