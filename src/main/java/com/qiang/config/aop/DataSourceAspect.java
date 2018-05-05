package com.qiang.config.aop;

import com.qiang.config.db.DataSourceContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 拦截数据库读写
 *
 * @author gengqiang
 */

@Aspect
@Component
@Order(1)
public class DataSourceAspect {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Before("execution(* com.qiang..*.*ServiceImpl.find*(..)) " +
            "|| execution(* com.qiang..*.*ServiceImpl.count*(..))" +
            "|| execution(* com.qiang..*.*ServiceImpl.sel*(..))" +
            "|| execution(* com.qiang..*.*ServiceImpl.get*(..))"
    )
    public void setReadDataSourceType() {
        logger.debug("拦截[read]方法");
        DataSourceContextHolder.read();
    }

    @Before("execution(* com.qiang..*.*ServiceImpl.insert*(..)) " +
            "|| execution(* com.qiang..*.*ServiceImpl.save*(..))" +
            "|| execution(* com.qiang..*.*ServiceImpl.update*(..))" +
            "|| execution(* com.qiang..*.*ServiceImpl.set*(..))" +
            "|| execution(* com.qiang..*.*ServiceImpl.del*(..))")
    public void setWriteDataSourceType() {
        logger.debug("拦截[write]操作");
        DataSourceContextHolder.write();
    }

}
