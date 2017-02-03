import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResourcesCache;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;

public class HBTurnOFFHueColorLamp1 {
	
	  public String noHueColorLamp1;
	  public int noHueColorLamp1Counter = 0;
	  public String results;
	  public String Status;
	  public String Remarks;
	  public String sendTohtml;
	  public int HueColorLampOneCounter=0;
	  public String HueColorLampName = "Hue Color lamp 1";

	public String HBTurnOFFHueColorLampOne(PHBridge bridge) throws InterruptedException {
		   System.out.println("/***************************Inside Hue Bridge Turn OFF Hue Color Lamp 1 class*********************************/");
		    TimeUnit.SECONDS.sleep(30);
		    PHBridgeResourcesCache cache = bridge.getResourceCache();
		    List<PHLight> allLights = cache.getAllLights();
		    List<String> TrueLights = new ArrayList<String>();
		    List<String> FalseLights = new ArrayList<String>();
		    List<String> nonReachableHuecolorLamp1 = new ArrayList<String>();
		    //List<String> nonReachableLights = new ArrayList<String>();
		    
		    for (PHLight lights : allLights)
		    {
		      PHLightState lightState = lights.getLastKnownLightState();
		      
		      String lightName = lights.getName();
		      System.out.println(lightName);
		      
		      Boolean lightStatus = lightState.isOn();
		      //System.out.println(lightStatus + ": is Light Status");
		      //Boolean HCL1 = lightName.contains(HueColorLampName);
		      //System.out.println("HCL1:"+HCL1);
		      if(lightName.equalsIgnoreCase(HueColorLampName)==true){
		    	  HueColorLampOneCounter++;
		    	  
		      }
		      System.out.println("Hue Color Lamp Counter Value:"+HueColorLampOneCounter);
		      Boolean lightReachable = lightState.isReachable();
		      //System.out.println(lightReachable+": Light Reachable");
		      Boolean lightNameCheck=lightName.equals(HueColorLampName);
		      //System.out.println(lightNameCheck);
		      if(lightStatus==false && lightName.equals(HueColorLampName)==true && lightReachable==true){
		    	  //System.out.println("Inside IF");
		    	  TrueLights.add(lightName);
		    	  //System.out.println(TrueLights.isEmpty());
		      } else if(lightStatus==true && lightName.equals(HueColorLampName)==true && lightReachable==true){
		    	  FalseLights.add(lightName);
		      }else if(lightReachable==false && lightName.equals(HueColorLampName)){
		    	  nonReachableHuecolorLamp1.add(lightName);
		      }
		      
		    }
		    
		    if(HueColorLampOneCounter ==1){
		    	if(FalseLights.isEmpty()==true && nonReachableHuecolorLamp1.isEmpty()==true && TrueLights.isEmpty()==false){
		    		results="PASS";
		    		Status="Hue Color Lamp 1 Turned OFF";
		    		Remarks=" ";
		    		sendTohtml=createHTMLReport(results,Status,Remarks);
		    	}
		    	else if(FalseLights.isEmpty()==false && nonReachableHuecolorLamp1.isEmpty()==true && TrueLights.isEmpty()==true){
		    		results="FAIL";
		    		Status="Hue Color Lamp 1 is Still ON";
		    		Remarks="Please check Hue Bridge connection and Light Configuration. Manually Verify control of Hue Color Lamp 1.";
		    		sendTohtml=createHTMLReport(results,Status,Remarks);
		    	}
		    }else if (HueColorLampOneCounter==0){
		    	results="FAIL";
		    	Status="Hue Color Lamp 1 doesn't exist on Hue Bridge.";
		    	Remarks="Hue Color Lamp 1 is not present on Hue Bridge. Please check Bridge Configuration.";
		    	sendTohtml=createHTMLReport(results,Status,Remarks);
		    }
		    //System.out.println(results);
		    //System.out.println(Status);
		    //System.out.println(Remarks);
		    
		    System.out.println("Send To HTML:"+sendTohtml);
		return sendTohtml;
		
	}
	
	public String createHTMLReport(String results, String Status, String Remarks){
		System.out.println("htmlResults: " + results + " htmlStatus: " + Status + " htmlRemarks :" + Remarks);
		 String htmlString1 = 
			      "<tr>\n<td style=\"border:1px solid black;border-collapse:collapse\">\n7</td>\n"
			      + "<td style=\"border:1px solid black;border-collapse:collapse\">\nTurn OFF Hue color Lamp 1</td>\n"
			      + "<td style=\"border:1px solid black;border-collapse:collapse\">\nHue Color Lamp 1 Should Turn OFF</td>\n"
			      + "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + Status+ "</td>\n" 
			      + "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + results + "</td>\n" 
			      +"<td style=\"border:1px solid black;border-collapse:collapse\">\n" + Remarks + "</td>\n" + "</tr>\n";
			    
		return htmlString1;
		
		
	}
}
	