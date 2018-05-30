package com.jp.input;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.jp.calculator.Calculator;

public class ReadXMLFile {
	
	public static void main(String argv[])
	{
		
		try
		{
			File xmlFile = new File ("/Users/abhinavashesh/Documents/workspace/international-markets/src/input.xml");
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			Document doc = dBuilder.parse(xmlFile);
			
			doc.getDocumentElement().normalize();
			
			NodeList numberofCustomerList = doc.getElementsByTagName("tran");
			
			HashMap<String, Entity>transactionIdsVsCustomerData=new HashMap<String,Entity>();
			
			for(int temp = 0 ;temp < numberofCustomerList.getLength();temp++)
			{
				Node nNode = numberofCustomerList.item(temp);
				
				Element eElement = (Element) nNode;
				
				Entity entity = populateEntity(eElement);
				
				transactionIdsVsCustomerData.put(eElement.getAttribute("id"), entity);
				
			}
			
			Calculator calculator = new Calculator();
			
			System.out.println("Total Amount Settled Incoming Everyday " + calculator.tottalAmoundsettledIncomingEveryday(transactionIdsVsCustomerData));
			System.out.println("Total Amount Settled Outgoing Everyday " + calculator.tottalAmoundsettledOutgoingEveryday(transactionIdsVsCustomerData));
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static Entity populateEntity(Element eElement) {
	
		 Entity entity = new Entity();
		 
		 try
		 {
			 
			 entity.setAggredFx(Double.parseDouble(eElement.getElementsByTagName("agreedFix").item(0).getTextContent()));
			 
			 entity.setCurrency(eElement.getElementsByTagName("curr").item(0).getTextContent());
			 
			 entity.setCustomerName(eElement.getElementsByTagName("customerName").item(0).getTextContent());
			 
			 Date instructiondate;
			 Date settelementDate;
			 
			 instructiondate = new SimpleDateFormat("dd-mm-yyyy").parse(eElement.getElementsByTagName("instructionDate").item(0).getTextContent());
			 
			 settelementDate = new SimpleDateFormat("dd-mm-yyyy").parse(eElement.getElementsByTagName("settelmentDate").item(0).getTextContent());
			 
			 entity.setInstructionDate(instructiondate);
			 entity.setSettlementDate(settelementDate);
			 
			 entity.setTypeOfPurchase(eElement.getElementsByTagName("buysell").item(0).getTextContent());
			 
			 entity.setUnits(Integer.parseInt(eElement.getElementsByTagName("Units").item(0).getTextContent()));
			 
			 entity.setPriceperunit(Double.parseDouble(eElement.getElementsByTagName("priceperunit").item(0).getTextContent()));
			
			 
			 
			 
		 }
		 
		 catch (DOMException e)
		 {
			 e.printStackTrace();
		 } catch (ParseException e)
		 {
			 e.printStackTrace();
		 }
		
		return entity;
	}
	
	

}
