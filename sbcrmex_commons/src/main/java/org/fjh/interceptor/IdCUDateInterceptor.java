package org.fjh.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Properties;

/**
 * mybatis自定义拦截器
 * 用来在insert 时自动绑定 id，createdate,updatedate
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
public class IdCUDateInterceptor implements Interceptor {
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
            if (SqlCommandType.INSERT.equals(sqlCommandType)) {
                if (field.getName().equalsIgnoreCase("createdate")) {
                    //设定字段可访问
                    field.setAccessible(true);
                    //设定值
                    field.set(parameter, new Date());
                } else if (field.getName().equalsIgnoreCase("updatedate")) {
                    field.setAccessible(true);
                    field.set(parameter, new Date());
                } else if (field.getName().equalsIgnoreCase("id")) {
                    field.setAccessible(true);
                    //得到拦截的实体名称
                    String entityFullName = parameter.getClass().getName();
                    //得到实体名称
                    String entity = entityFullName.substring(entityFullName.lastIndexOf(".")+1);
                    //以实体的三个字母为前缀+时间 组合成主键
                    String prefix = entity.substring(0,3).toLowerCase();
                    String id = prefix+System.currentTimeMillis();
                    field.set(parameter, id);

                    //产生UUID
                    //field.set(parameter, UUID.randomUUID().toString().replace("-", ""));
                }
            } else if (SqlCommandType.UPDATE.equals(sqlCommandType)) {
                if (field.getName().equalsIgnoreCase("updatedate")) {
                    field.setAccessible(true);
                    field.set(parameter, new Date());
                    break;
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
