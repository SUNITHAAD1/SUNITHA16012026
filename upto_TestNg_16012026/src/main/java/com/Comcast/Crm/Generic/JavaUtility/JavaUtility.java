package com.Comcast.Crm.Generic.JavaUtility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JavaUtility {
	
	public int randomNumber()
	{
		Random r= new Random();
		int randomInt = r.nextInt();
		return randomInt;
	}
	
	public void getAlphaNumString() throws FileNotFoundException, IOException, ParseException
	{	int n=20;
		String AlphaNumString="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb=new StringBuilder(n);
		for(int i=0;i<n;i++)
		{
			int index=(int)(AlphaNumString.length()*Math.random());
			sb.append(AlphaNumString.charAt(index));
		}
		System.out.println(sb);
		
	}
	public String getSystemDateYYYYMMDD()
	{
		Date date =new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String actDate = sim.format(date);
		return actDate;
	}
	
	public String getRequiredDateYYYYMMDD(int days)
	{
		Date date =new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String expecDate = sim.format(cal.getTime());
		return expecDate;
	}
	
}
