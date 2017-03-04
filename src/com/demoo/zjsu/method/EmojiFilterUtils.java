package com.demoo.zjsu.method;

import org.apache.commons.lang3.StringUtils;  
 
/**
 * 将4位的emoji图像转换成*
 * @author yuanjian
 */
public class EmojiFilterUtils {  
  
    /** 
     * 将emoji表情替换成* 
     *  
     * @param source 
     * @return 过滤后的字符串 
     */  
    public static String filterEmoji(String source) {
    	if(source == null){
            return source; 
    	}
        if(StringUtils.isNotBlank(source)){  
            return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "*");  
        }else{  
            return source;  
        }  
    }  
}  
