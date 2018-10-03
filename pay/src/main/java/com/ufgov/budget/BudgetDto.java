package com.ufgov.budget;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDto {

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
    private Integer adjustKind; // 指标调整方向
    private Double budgetMoney; // 指标金额

}
