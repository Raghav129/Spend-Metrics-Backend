package com.mr.SpendMetrics.Service.Stats;

import com.mr.SpendMetrics.DTO.GraphDTO;
import com.mr.SpendMetrics.DTO.StatsDTO;

public interface StatsService {

    GraphDTO getChartData();

    StatsDTO getStats();



}
