import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResourcesCache;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;

public class HBTurnONAmbLivingRoom {
	
	public String FinalHTMLString;
	public String LightName = "Hue ambiance lamp 1";
	public Boolean lightStatus;
	public String Status;
	public String Result;
	public String Remarks;
	public String SendToHTML;
	
	public String TurnONAmbianceLivingRoom(PHBridge bridge, WebDriver driver) throws InterruptedException{
		
		System.out.println("******************** TURN ON AMBIANCE LAMP IN LIVING ROOM **********************");
		
		List<String> TrueLights = new ArrayList<String>();
	    List<String> FalseLights = new ArrayList<String>();
	    List<String> nonReachableLights = new ArrayList<String>();
	    
	    TimeUnit.SECONDS.sleep(27);
	    
	    PHBridgeResourcesCache cache = bridge.getResourceCache();
	    List<PHLight> allLights = cache.getAllLights();
		
	    for (PHLight lights : allLights){
	    	
	    	PHLightState lightState = lights.getLastKnownLightState();
	    	
	    	if((lights.getName().equalsIgnoreCase(LightName)==true) && (lightState.isReachable()==true) && (lightState.isOn()==true)){
	    		lightStatus=lightState.isOn();
	    		TrueLights.add(lights.getName());
	    	}else if ((lights.getName().equalsIgnoreCase(LightName)==false) && (lightState.isReachable()==false)&& (lightState.isOn()==false)){
	    		FalseLights.add(lights.getName());
	    		
	    	}else if((lights.getName().equalsIgnoreCase(LightName)==true) && (lightState.isReachable()==false)){
	    		nonReachableLights.add(lights.getName());
	    	}
	    	
	    }
	    
	    if(FalseLights.isEmpty()==true){
	    	Status= "PASS";
	    	Result = "Hue ambiance lamp 1 is Turned ON in Living Room.";
	    	if(nonReachableLights.isEmpty()==true){
	    		Remarks=" ";
	    	}else{
	    		Remarks="Hue ambiance lamp 1 is not reachable.";
	    	}
	    	SendToHTML = createHTMLReport(Status,Result,Remarks);
	    }else if(FalseLights.isEmpty()==false){
	    	Status= "FAIL";
	    	Result = "Hue ambiance lamp 1 Didn't Turned ON in Living Room.";
	    	if(nonReachableLights.isEmpty()==true){
	    		Remarks="Please Try to receate issue by Turn ON/OFF Hue ambiance lamp Manually.";
	    	}else{
	    		Remarks="Hue ambiance lamp 1 is not reachable.";
	    	}
	    	SendToHTML = createHTMLReport(Status,Result,Remarks);
	    }
		return SendToHTML;
	}

	
	public String createHTMLReport(String htmlStatus, String htmlResult, String htmlRemarks){
		FinalHTMLString="<tr>\n<td style=\"border:1px solid black;border-collapse:collapse\">\n18</td>\n"
	    	      + "<td style=\"border:1px solid black;border-collapse:collapse\">\nTurn ON Hue ambiance lamp in Living Room</td>\n"
	    	      + "<td style=\"border:1px solid black;border-collapse:collapse\">\nHue ambiance lamp should Turn ON in Living Room.</td>\n"
	    	      + "<td style=\"border:1px solid black;border-collapse:collapse\">\n" +htmlResult + "</td>\n" 
	    	      + "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + htmlStatus + "</td>\n" 
	    	      +"<td style=\"border:1px solid black;border-collapse:collapse\">\n" + htmlRemarks + "</td>\n" + "</tr>\n";
		return FinalHTMLString;
	}
}
