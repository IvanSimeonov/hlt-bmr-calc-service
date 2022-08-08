package com.ivnsim.hltbmrcalcservice.controllers;

import com.ivnsim.hltbmrcalcservice.domain.BmrBaseData;
import com.ivnsim.hltbmrcalcservice.strategies.BmrCalcStrategy;
import com.ivnsim.hltbmrcalcservice.strategies.CalcByHarrisBenedict;
import com.ivnsim.hltbmrcalcservice.strategies.CalcByKatchMcArdle;
import com.ivnsim.hltbmrcalcservice.strategies.CalcByMifflinStJeor;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bmr-calc")
public class BasalMetabolicRateController {

    @Operation(summary = "Calculate Basal Metabolic Rate")
    @PostMapping("/{id}")
    public Long getCalculatedBasalMetabolicRate(@RequestBody BmrBaseData bmrBaseData, @PathVariable("id") Integer id) {
        BmrCalcStrategy bmrCalcStrategy;
        switch (id) {
            case 1 -> {
                bmrCalcStrategy = new CalcByHarrisBenedict();
                return Math.round(bmrCalcStrategy.calculateBmr(bmrBaseData));
            }
            case 2 -> {
                bmrCalcStrategy = new CalcByKatchMcArdle();
                return Math.round(bmrCalcStrategy.calculateBmr(bmrBaseData));
            }
            case 3 -> {
                bmrCalcStrategy = new CalcByMifflinStJeor();
                return Math.round(bmrCalcStrategy.calculateBmr(bmrBaseData));
            }
        }
        return 0L;
    }
}
