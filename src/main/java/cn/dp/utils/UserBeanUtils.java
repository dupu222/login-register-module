package cn.dp.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pu on 2015/10/30 0030.
 */
public class UserBeanUtils {
    public static <T> T populate(HttpServletRequest req,Class<T> clazz){
        try {
            T bean = clazz.newInstance();
            BeanUtils.populate(bean,req.getParameterMap());
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
