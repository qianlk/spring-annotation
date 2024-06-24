package org.example.a03_componentscan_filter.service;

/**
 * 绩效计算的桥接接口
 */
public interface DistrictPerformance {

    /**
     * 根据不同车辆类型计算绩效
     *  类型：
     *      CAR
     *      SUV
     * @param type
     */
    void calcPerformance(String type);
}
