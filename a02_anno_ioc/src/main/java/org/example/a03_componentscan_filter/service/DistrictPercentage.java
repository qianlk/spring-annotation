package org.example.a03_componentscan_filter.service;

/**
 * 销售分成的桥接接口
 */
public interface DistrictPercentage {

    /**
     * 不同类型的提成不同
     * 类型：
     *      CAR
     *      SUV
     * @param type
     */
    void salePercentage(String type);
}
