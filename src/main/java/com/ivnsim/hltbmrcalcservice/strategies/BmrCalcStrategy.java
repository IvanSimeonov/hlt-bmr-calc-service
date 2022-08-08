package com.ivnsim.hltbmrcalcservice.strategies;

import com.ivnsim.hltbmrcalcservice.domain.BmrBaseData;

public interface BmrCalcStrategy {
    double calculateBmr(BmrBaseData bmrBaseData);
}
