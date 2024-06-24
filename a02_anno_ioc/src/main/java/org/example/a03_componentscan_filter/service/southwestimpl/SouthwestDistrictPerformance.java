package org.example.a03_componentscan_filter.service.southwestimpl;

import org.example.a03_componentscan_filter.annotations.District;
import org.example.a03_componentscan_filter.service.DistrictPerformance;
import org.springframework.stereotype.Service;

/**
 * 西南区绩效计算的具体实现
 */
@Service("districtPerformance")
@District("southwest")
public class SouthwestDistrictPerformance implements DistrictPerformance {

    @Override
    public void calcPerformance(String type) {
        if("SUV".equalsIgnoreCase(type)){
            System.out.println("西南区"+type+"绩效是5");
        }else if("CAR".equalsIgnoreCase(type)){
            System.out.println("西南区"+type+"绩效是3");
        }
    }
}
