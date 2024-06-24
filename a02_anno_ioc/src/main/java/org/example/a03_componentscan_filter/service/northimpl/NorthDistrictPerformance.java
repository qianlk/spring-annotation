package org.example.a03_componentscan_filter.service.northimpl;

import org.example.a03_componentscan_filter.annotations.District;
import org.example.a03_componentscan_filter.service.DistrictPerformance;
import org.springframework.stereotype.Service;

/**
 * 华北区绩效计算的具体实现
 */
@Service("districtPerformance")
@District("north")
public class NorthDistrictPerformance implements DistrictPerformance {

    @Override
    public void calcPerformance(String type) {
        if("SUV".equalsIgnoreCase(type)){
            System.out.println("华北区"+type+"绩效是3");
        }else if("CAR".equalsIgnoreCase(type)){
            System.out.println("华北区"+type+"绩效是5");
        }
    }
}
