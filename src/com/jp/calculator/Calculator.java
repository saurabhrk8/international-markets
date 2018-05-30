package com.jp.calculator;

import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import com.jp.input.Entity;

public class Calculator {
	
	/**
	 * @author Saurabh K
	 * @param transactionIdsVsCustomerData
	 * @return
	 */
	public double tottalAmoundsettledIncomingEveryday(HashMap<String, Entity>transactionIdsVsCustomerData)
	{
		double tottalAmoundsettledIncomingEveryday = 0;
		
		
		for(Entry<String,Entity> entry : transactionIdsVsCustomerData.entrySet())
		{  
			Entity entity = entry.getValue();
			
			if(entity.getTypeOfPurchase().equalsIgnoreCase("b"))
			{
				if(isWeekend(entity.getSettlementDate(), entity.getCurrency()))
				{
					double  tottalAmoundsettledIncomingEveryday1 = entity.getUnits() * entity.getPriceperunit();
					
					double sum = tottalAmoundsettledIncomingEveryday1 * entity.getAggredFx();
					
					tottalAmoundsettledIncomingEveryday = tottalAmoundsettledIncomingEveryday + sum ;
				}
			}
			
		}
		return tottalAmoundsettledIncomingEveryday;
		
	}
	
	/**
	 * Saurabh K
	 * @param transactionIdsVsCustomerData
	 * @return
	 */
	public double tottalAmoundsettledOutgoingEveryday(HashMap<String, Entity>transactionIdsVsCustomerData)
	{
		double tottalAmoundsettledIncomingEveryday = 0;
		
		
		for(Entry<String,Entity> entry : transactionIdsVsCustomerData.entrySet())
		{  
			Entity entity = entry.getValue();
			
			if(entity.getTypeOfPurchase().equalsIgnoreCase("s"))
			{
				if(isWeekend(entity.getSettlementDate(), entity.getCurrency()))
				{
					double  tottalAmoundsettledIncomingEveryday1 = entity.getUnits() * entity.getPriceperunit();
					
					double sum = tottalAmoundsettledIncomingEveryday1 * entity.getAggredFx();
					
					tottalAmoundsettledIncomingEveryday = tottalAmoundsettledIncomingEveryday + sum ;
				}
			}
			
		}
		return tottalAmoundsettledIncomingEveryday;
		
	}
	
	
	public boolean isWeekend(Date settelmentDate , String currency)
	{
		
		boolean isWeekend =false;
		
		int day = settelmentDate.getDay();
		
		if(day == 4 || day == 5 && currency.equalsIgnoreCase("AED") || currency.equalsIgnoreCase("SAR"))
		{
			isWeekend = true;
		}
		
		else if(day == 6 || day == 7 )
		{
			if(currency.equalsIgnoreCase("AED") || currency.equalsIgnoreCase("SAR"))
			{
				isWeekend = false;
			}
			
			isWeekend = true;
		}
		
		else
		{
			isWeekend = false;
		}
		
		return isWeekend;
		
	}

}
