/**
 * 
 */
package com.netease.luban.utils.cron;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.quartz.CronExpression;

/**
 * @author hzzhangyuandao
 * @since 2015/5/27
 */
public class CronUtils {

	/**
	 * @param cronExpression
	 * @param date
	 * @return true,if date is due by cronExpression.
	 */
	public static boolean isTimeDue(String cronExpression,Date date){
		
		//check parameters
		if(StringUtils.isEmpty(cronExpression)){
			return false;
		}
		if(date == null )
			return false;
		
		
		try {
			CronExpression cronExpr = new CronExpression(cronExpression);
			
			return cronExpr.isSatisfiedBy(date);
		} catch (ParseException e) {
			return false;
		}
	}
	
	
	
}
