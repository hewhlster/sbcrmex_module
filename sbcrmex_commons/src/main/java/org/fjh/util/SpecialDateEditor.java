package org.fjh.util;

/**
 * 作用：
 * 版本信息：
 * 日期：2017年12月19日-下午3:08:48
 * 版权:樊建华
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * 作用：日期转换器
 * 版本信息：
 * 日期：2017年12月19日-下午3:13:47
 * 版权:樊建华
 */

public class SpecialDateEditor extends PropertyEditorSupport {
    private static Logger logger = LoggerFactory.getLogger(SpecialDateEditor.class);

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date date = null;
        try {
            //防止空数据出错
            date = format.parse(text);
        } catch (ParseException e) {
            format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = format.parse(text);
            } catch (ParseException e1) {
                format = new SimpleDateFormat("yyyy-MM");

                try {
                    date = format.parse(text);
                } catch (Exception e2) {
                    logger.info("自动绑定日期数据出错" + e);
                }
            }
        }
        setValue(date);
    }
}