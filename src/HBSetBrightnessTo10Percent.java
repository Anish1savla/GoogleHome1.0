import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResourcesCache;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;

public class HBSetBrightnessTo10Percent {
	
	public int CurrentLightBrightness;
	public String Status;
	public String Results;
	public String Remarks;
	public String sendTohtml;
	
	public String SetBrightness10Percent(PHBridge bridge, WebDriver driver) throws InterruptedException, InvalidFormatException, IOException{
		
		
	    HashMap<String,Integer> NewTrueBrightness = new HashMap<String,Integer>();
	    HashMap<String,Integer> NewFalseBrightness = new HashMap<String,Integer>();
	    List<String> nonReachableLights = new ArrayList<String>();
	    
		 TimeUnit.SECONDS.sleep(27);
		 
		 PHBridgeResourcesCache cache = bridge.getResourceCache();
		 
		 List<PHLight> allLights = cache.getAllLights();
		 
		 for (PHLight lights : allLights)
		    {
		    	
		    	PHLightState lightState = lights.getLastKnownLightState();
		    	
		    	if(lightState.isReachable()==false){
		    		nonReachableLights.add(lights.getName());
		    	}
		    	
		    	CurrentLightBrightness=lightState.getBrightness();
		    	//System.out.println("************************* BEFORE IF**************************");
		    	//System.out.println("Light Name:"+lights.getName());
		    	//System.out.println("Brightness:"+lightState.getBrightness());
		    	
		    	if(CurrentLightBrightness==25){
		    		//System.out.println("************************* Inside IF **************************");
		    		//System.out.println("Light Name"+lights.getName());
			    	//System.out.println("Brightness:"+lightState.getBrightness());
			    	
		    		NewTrueBrightness.put(lights.getName(),CurrentLightBrightness);
		    	}
		    	else{
		    		//System.out.println("************************* BEFORE ELSE**************************");
		    		//System.out.println("Light Name"+lights.getName());
			    	//System.out.println("Brightness:"+lightState.getBrightness());
		    		NewFalseBrightness.put(lights.getName(),CurrentLightBrightness);
		    	}
		    	//System.out.println("Light Name: "+lights.getName()+"Light Brightness: "+CurrentLightBrightness);
		    }
		 
		 if(NewFalseBrightness.isEmpty()==true){
			 Status="PASS";
			 Results="Brightness for all lights set to 10%";
			 if(nonReachableLights.isEmpty()==true){
				 Remarks="Brightness level of all lights:"+NewTrueBrightness.toString();
			 }else{
				 Remarks="Brightness level of all lights:"+NewTrueBrightness.toString()+". Non Reachable lights:"+nonReachableLights.toString();
			 }
			 sendTohtml=createHTMLReport(Status,Results,Remarks);
		 }else if(NewFalseBrightness.isEmpty()==false){
			 Status="FAIL";
			 Results="Brightness for all lights is not 10%";
			 if(nonReachableLights.isEmpty()==true){
				 Remarks="Brightness level of lights:"+NewFalseBrightness.toString()+"is not 10%";
			 }else{
				 Remarks="Brightness level of lights:"+NewFalseBrightness.toString()+"is not 10%"
						 +". Non Reachable lights:"+nonReachableLights.toString();
			 }
			 sendTohtml=createHTMLReport(Status,Results,Remarks);
			 
		 }
		 
		 CreateNewDailySummaryReport cdsr = new CreateNewDailySummaryReport();
		    if(Status=="PASS")
		    {
		    	System.out.println("Putting data into excel-Inside IF");
		    	cdsr.ReportSetLightsTo10P("PASS");
		    }else if(Status=="FAIL"){
		    	System.out.println("Putting data into excel-Inside ELSe");
		    	cdsr.ReportSetLightsTo10P("FAIL");
		    }
		 
		 return sendTohtml;
	}
		 
	
	public String createHTMLReport(String htmlStatus,String htmlResults,String htmlRemarks){
		System.out.println("htmlResults: " + htmlResults + " htmlStatus: " + htmlStatus + " htmlRemarks :" + htmlRemarks);
		 String htmlString1 = 
			      "<tr>\n<td style=\"border:1px solid black;border-collapse:collapse\">\n10</td>\n"
			      + "<td style=\"border:1px solid black;border-collapse:collapse\">\nSet the lights to 10%</td>\n"
			      + "<td style=\"border:1px solid black;border-collapse:collapse\">\nAll Lights Brightness should be set to 10%.</td>\n"
			      + "<td style=\"border:1px solid black;border-collapse:collapse\">\n" +htmlResults  + "</td>\n" 
			      + "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + htmlStatus+ "</td>\n" 
			      +"<td style=\"border:1px solid black;border-collapse:collapse\">\n" + htmlRemarks + "</td>\n" + "</tr>\n";
		
		 return htmlString1;
	}
}
