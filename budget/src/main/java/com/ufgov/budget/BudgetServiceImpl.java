package com.ufgov.budget;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import org.springframework.http.MediaType;

@RestSchema(schemaId = "budget")
@RequestMapping(path = "/api/budget", produces = MediaType.TEXT_PLAIN_VALUE)
public class BudgetServiceImpl implements BudgetService {

    private static org.slf4j.Logger log = LoggerFactory.getLogger(BudgetServiceImpl.class);

    @ResponseBody
    @RequestMapping(value = "/getBill", method = RequestMethod.GET)
    @ApiOperation(value = "根据指标单据编号获取指标内容信息", notes = "test: 仅 vouid = 001,002 有正确返回")
    @ApiImplicitParam(paramType = "query", name = "vouid", value = "指标编号", required = true, dataType = "String")
    @Override
    public BudgetDto getBill(String vouid) {
        BudgetDto dto = new BudgetDto(vouid, "2010101", "行政运行", "101001", "人大办公厅", "陕财办教[2018]001号", "1", "国库集中支付", "1", "基本支出", "11", "一般公共预算", 1,
                5000.00);
        log.debug("--- BudgetServiceImpl.getBill()  ret = " + dto);
        return dto;
    }

}
