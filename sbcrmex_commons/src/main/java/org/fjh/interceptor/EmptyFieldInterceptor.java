package org.fjh.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.util.Properties;

/**
 * mybatis自定义拦截器
 * 用来在insert 对于空字符串的对象自动转成null
 * update时绑定updatedate
 */
@Intercepts(
        {
                @Signature(type = Executor.class,
                        method = "update",
                        args = {MappedStatement.class, Object.class}
                )
        }
)
public class EmptyFieldInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //取得statement
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        // 获取 SQL
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        // 获取参数(映射的实体)
        Object parameter = invocation.getArgs()[1];

        // 获取私有成员变量
        Field[] declaredFields = parameter.getClass().getDeclaredFields();

        for (Field field : declaredFields) {
            // 判断sql类型
            if (SqlCommandType.INSERT.equals(sqlCommandType) || SqlCommandType.UPDATE.equals(sqlCommandType)) {
                field.setAccessible(true);
                Object value=field.get(parameter);
                if(value!=null && value instanceof String){
                     String t = value.toString();
                     if( t.trim().length()==0){
                         field.set(parameter, null);
                     }
                }
            }
        }                // 返回
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}
