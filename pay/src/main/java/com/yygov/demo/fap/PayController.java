package com.yygov.demo.fap;

import java.util.HashMap;
import java.util.Map;

import org.apache.servicecomb.provider.pojo.RpcReference;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ufgov.budget.BudgetDto;
import com.yygov.demo.api.BudgetDto2;
import com.yygov.demo.api.BudgetService;
import com.yygov.demo.api.Hello;
import com.yygov.demo.api.PayDto;

@RestController
public class PayController {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(PayController.class);

    @RpcReference(microserviceName = "pay", schemaId = "budget")
    private BudgetService budgetInfo;
    private Hello hello;

    @GetMapping("/hello")
    public String hello(String name) {
        String ret = "Hello from Pay [name = " + name + "]" + hello.sayHi(name);
        log.debug("--- PayController.hello()  ret = " + ret);
        return ret;
    }

    @PostMapping("/api/v1.0/pay/{vouid}/dopay")
    public Map<String, Object> doPay(@PathVariable String vouid) {
        String budgetId = "ZB0001";
        Double payMoney = 3000.00;
        PayDto payDto = new PayDto(vouid, "2010101", "行政运行", "101001", "人大办公厅", "陕财办教[2018]001号", "1", "国库集中支付", "1", "基本支出", "11", "一般公共预算",
                budgetId, "50101", "基本工资", payMoney);

//        BudgetDto budgetDto = budgetInfo.getBill(budgetId);
        
        RestTemplate restTemplate = RestTemplateBuilder.create();
        BudgetDto budgetDto = restTemplate.getForObject("cse://budget/bedguet/getBill?vouid=" + budgetId, BudgetDto.class);

        Map<String, Object> retMap = new HashMap<String, Object>();
        retMap.put("budget", budgetDto);
        retMap.put("pay", payDto);
        if (payDto.getPayMoney() > budgetDto.getBudgetMoney()) {
            retMap.put("result", "[接口版本v1.0] 返回结果：支付金额大于指标额度。拒绝支付！");
        } else {
            retMap.put("result", "[接口版本v1.0] 返回结果：支付金额小于指标额度。允许支付！");
        }
        return retMap;
    }

}
