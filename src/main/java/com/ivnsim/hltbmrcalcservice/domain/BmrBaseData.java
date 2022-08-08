package com.ivnsim.hltbmrcalcservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BmrBaseData {

    private Sex sex;
    private Double weight;
    private Double height;
    private Integer age;
    private Double leanBodyMass;
    private Double bodyFatPercentage;

}
