package com.yygov.demo.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PayDto2 {

    private String vouId; // 单据id
    private String bsCode; // 功能分类代码
    private String bsName; // 功能分类名称
    private String agencyCode; // 单位编码
    private String agencyName; // 单位名称
    private String fileName; // 指标文号
    private String pkCode; // 支付方式编码
    private String pkName; // 支付方式名称
    private String bisCode; // 预算项目编码
    private String bisName; // 预算项目名称
    private String mkCode; // 资金性质编码
    private String mkName; // 资金性质名称
    private String fromBudgetId; // 来源指标id
    private String bsiCode; // 经济分类编码
    private String bsiName; // 经济分类名称

    // 版本2新增字段
    private String pmCode; // 结算方式编码
    private String pmName; // 结算方式名称

}
