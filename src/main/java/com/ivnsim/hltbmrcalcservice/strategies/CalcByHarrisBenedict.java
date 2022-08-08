package com.ivnsim.hltbmrcalcservice.strategies;

import com.ivnsim.hltbmrcalcservice.domain.BmrBaseData;
import com.ivnsim.hltbmrcalcservice.domain.Sex;
import org.springframework.stereotype.Component;

@Component
public class CalcByHarrisBenedict implements BmrCalcStrategy {

    private final static double MAN_WEIGHT_MULTIPLIER = 13.75;
    private final static double MAN_HEIGHT_MULTIPLIER = 5.003;
    private final static double MAN_AGE_MULTIPLIER = 6.75;
    private final static double MAN_CONSTANT = 66.5;
    private final static double WOMAN_WEIGHT_MULTIPLIER = 9.563;
    private final static double WOMAN_HEIGHT_MULTIPLIER = 1.85;
    private final static double WOMAN_AGE_MULTIPLIER = 4.676;
    private final static double WOMAN_CONSTANT = 655.1;

    @Override
    public double calculateBmr(BmrBaseData bmrBaseData) {
        if (bmrBaseData.getSex() == Sex.MAN) {
            return Math.round(MAN_CONSTANT +
                    (MAN_WEIGHT_MULTIPLIER * bmrBaseData.getWeight()) +
                    (MAN_HEIGHT_MULTIPLIER * bmrBaseData.getHeight()) -
                    (MAN_AGE_MULTIPLIER * bmrBaseData.getAge()));
        } else {
            return Math.round(WOMAN_CONSTANT +
                    (WOMAN_WEIGHT_MULTIPLIER * bmrBaseData.getWeight()) +
                    (WOMAN_HEIGHT_MULTIPLIER * bmrBaseData.getHeight()) -
                    (WOMAN_AGE_MULTIPLIER * bmrBaseData.getAge()));
        }
    }
}
