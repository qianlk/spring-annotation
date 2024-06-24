package org.example.a03_componentscan_filter.typefilter;

import org.example.a03_componentscan_filter.annotations.District;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.filter.AbstractTypeHierarchyTraversingFilter;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.ClassUtils;
import org.springframework.util.PathMatcher;

import java.util.Properties;

/**
 * 自定义扫描规则过滤器
 * 给 @ComponentScan 使用
 *
 * @author qlk
 */
public class DistrictTypeFilter extends AbstractTypeHierarchyTraversingFilter {

    private static final String PATTERN_STANDARD = ClassUtils.convertClassNameToResourcePath("org.example.componentscan_filter.service.*.*");

    // spring 提供的 路径匹配器
    private PathMatcher pathMatcher;

    // 定义区域名称
    // 此处数据,应该是读取配置文件的内容
    // 注意, 不能使用@Value读取
    // 原因是负责解析@Value,填充属性值的 InstantiationPostProcessor 在 TypeFilter 执行阶段没有加载上
    private String districtName;

    protected DistrictTypeFilter() {
        /**
         * 调用父类的构造函数
         * 第一个参数
         *  considerInherited, 表示不考虑基类
         *  considerInterfaces, 表示不考虑接口
         */
        super(false, false);

        // 硬编码加载配置文件
        pathMatcher = new AntPathMatcher();

        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties("district.properties");
            districtName = properties.getProperty("common.district.name");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 本方法将注册类 excludefilter, 返回true表示拒绝
     *
     * @param className
     * @return
     */
    @Override
    protected boolean matchClassName(String className) {
        if (!isPotentialPackageClass(className)) {
            // 不符合
            return false;
        }
        try {
            // 判断当前区域和配置区域是否一致, 不一致要 exclude
            Class<?> clazz = ClassUtils.forName(className, DistrictTypeFilter.class.getClassLoader());
            // 获取注解
            District district = clazz.getAnnotation(District.class);

            if (district == null) {
                return false;
            }

            // 取出注解属性值
            String districtValue = district.value();
            // 校验, 注解值和配置文件匹配上了就注入
            return !districtName.equalsIgnoreCase(districtValue);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 判断指定的包名是否是 和区域相关的类所在包
     * @param className
     * @return
     */
    private boolean isPotentialPackageClass(String className) {
        // 1. 类名转化成资源路径, 匹配扫描条件
        String path
                 = ClassUtils.convertClassNameToResourcePath(className);
        // 2. 校验
        return pathMatcher.match(PATTERN_STANDARD, path);
    }


}
