package org.fjh.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MD5Helper {

    @Value("${key}")
    private static String key = "fanjianhua"; //密钥

    private static Logger logger = LoggerFactory.getLogger(MD5Helper.class);

    /**
     * MD5方法
     *
     * @param text 明文
     * @param key  密钥
     * @return 密文
     * @throws Exception
     */
    public static String md5(String text) throws Exception {
        //加密后的字符串
        String encodeStr = DigestUtils.md5Hex(text + key);
        logger.info("秘钥匙:key=" + key);

        logger.info("MD5加密后的字符串为:encodeStr=" + encodeStr);
        return encodeStr;
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param key  密钥
     * @param md5  密文
     * @return true/false
     * @throws Exception
     */
    public static boolean verify(String text, String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = md5(text);
        if (md5Text.equalsIgnoreCase(md5)) {
            logger.info("MD5验证通过");
            return true;
        }
        return false;
    }
}
