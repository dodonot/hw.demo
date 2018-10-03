package com.ufgov.budget;

import javax.ws.rs.core.MediaType;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestSchema(schemaId = "forecast")
@RequestMapping(path = "/hello", produces = MediaType.APPLICATION_JSON)
@RestController
public class BudgetController {

    @GetMapping("/api/budgetinfo/{vouid}")
    public BudgetDto budgetInfo(@PathVariable String vouid) {
        return new BudgetDto(vouid, "2010101", "行政运行", "101001", "人大办公厅", "陕财办教[2018]001号", "1", "国库集中支付", "1", "基本支出", "11", "一般公共预算", 1, 5000.00);
    }

//    @GetMapping("/api/v2.0/budgetinfo/{vouid}")
//    public BudgetDto2 budgetInfo2(@PathVariable String vouid) {
//        return new BudgetDto2(vouid, "3010101", "事业经费", "202001", "教育局", "陕财办教[2018]003号", "1", "国库集中支付", "1", "基本支出", "22", "专项公共预算", 1, 5100.00,
//                "111001", "财政待分指标");
//    }

}
