package com.ivnsim.hltbmrcalcservice.strategies;

import com.ivnsim.hltbmrcalcservice.domain.BmrBaseData;
import com.ivnsim.hltbmrcalcservice.domain.Sex;
import org.springframework.stereotype.Component;

@Component
public class CalcByMifflinStJeor implements BmrCalcStrategy {

    private final static int WEIGHT_MULTIPLIER = 10;
    private final static double HEIGHT_MULTIPLIER = 6.25;
    private final static int YEARS_MULTIPLIER = 5;
    private final static int MAN_CONSTANT = 5;
    private final static int WOMAN_CONSTANT = 161;

    @Override
    public double calculateBmr(BmrBaseData bmrBaseData) {
        double result = Math.round(bmrBaseData.getWeight() * WEIGHT_MULTIPLIER + bmrBaseData.getHeight() * HEIGHT_MULTIPLIER - bmrBaseData.getAge() * YEARS_MULTIPLIER);
        if (bmrBaseData.getSex() == Sex.MAN) {
            return result += MAN_CONSTANT;
        } else {
            return result -= WOMAN_CONSTANT;
        }
    }
}
