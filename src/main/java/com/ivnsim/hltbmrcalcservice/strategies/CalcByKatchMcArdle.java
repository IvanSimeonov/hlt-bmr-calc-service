package com.ivnsim.hltbmrcalcservice.strategies;

import com.ivnsim.hltbmrcalcservice.domain.BmrBaseData;
import com.ivnsim.hltbmrcalcservice.domain.Sex;
import org.springframework.stereotype.Component;

@Component
public class CalcByKatchMcArdle implements BmrCalcStrategy {

    private final static double BMR_ADDITION_CONSTANT = 370;
    private final static double BMR_MULTIPLIER = 21.6;
    private final static double MAN_LBM_WEIGHT_MULTIPLIER = 0.407;
    private final static double MAN_LBM_HEIGHT_MULTIPLIER = 0.267;
    private final static double MAN_LBM_CONSTANT = 19.2;
    private final static double WOMAN_LBM_WEIGHT_MULTIPLIER = 0.252;
    private final static double WOMAN_LBM_HEIGHT_MULTIPLIER = 0.473;
    private final static double WOMAN_LBM_CONSTANT = 48.3;

    @Override
    public double calculateBmr(BmrBaseData bmrBaseData) {
        if (bmrBaseData.getLeanBodyMass() > 1) {
            return BMR_ADDITION_CONSTANT + (BMR_MULTIPLIER * bmrBaseData.getLeanBodyMass());
        } else {
            if (bmrBaseData.getBodyFatPercentage() < 1) {
                return BMR_ADDITION_CONSTANT + (BMR_MULTIPLIER * calculateLeanBodyMassByWeightAndHeight(bmrBaseData));
            } else {
                return BMR_ADDITION_CONSTANT + (BMR_MULTIPLIER * calculateLeanBodyMassByBodyFatPercentage(bmrBaseData));
            }
        }
    }

    private double calculateLeanBodyMassByBodyFatPercentage(BmrBaseData bmrBaseData) {
        return bmrBaseData.getWeight() * (100 - bmrBaseData.getBodyFatPercentage()) / 100;
    }

    private double calculateLeanBodyMassByWeightAndHeight(BmrBaseData bmrBaseData) {
        if (bmrBaseData.getSex() == Sex.MAN) {
            return bmrBaseData.getWeight() * MAN_LBM_WEIGHT_MULTIPLIER + bmrBaseData.getHeight() * MAN_LBM_HEIGHT_MULTIPLIER - MAN_LBM_CONSTANT;
        } else {
            return bmrBaseData.getWeight() * WOMAN_LBM_WEIGHT_MULTIPLIER + bmrBaseData.getHeight() * WOMAN_LBM_HEIGHT_MULTIPLIER - WOMAN_LBM_CONSTANT;
        }
    }
}
