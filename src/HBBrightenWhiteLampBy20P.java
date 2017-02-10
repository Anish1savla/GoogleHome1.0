import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;

import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResourcesCache;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;

public class HBBrightenWhiteLampBy20P {

	public String LightName = "White Lamp";
	public String Status;
	public String Results;
	public String Remarks;
	public String sendToHTML;
	public String FinalHTMLString;
	public int OldWhiteLampBrightness;
	public int NewWhiteLampBrightness;
	
	public String BrightenWhiteLampBy20P(PHBridge bridge, WebDriver driver) throws FindFailed, InterruptedException{
		
		PHBridgeResourcesCache cache = bridge.getResourceCache();
	    
	    List<PHLight> allLights = cache.getAllLights();
	    
	    HashMap<String,Integer> OldBrightnessLevel = new HashMap<String,Integer>();
	    HashMap<String,Integer> NewBrightnessLevel = new HashMap<String,Integer>();
	    List<String> nonReachableLights = new ArrayList<String>();
	    
	    for(PHLight lights : allLights){
	    	
	    	PHLightState lightState = lights.getLastKnownLightState();
	    	
	    	if(lightState.isReachable()==false){
	    		nonReachableLights.add(lights.getName());
	    	}
	    	
	    	OldBrightnessLevel.put(lights.getName(), lightState.getBrightness());
	    	
	    }
		
	    selBrightenWhiteLampBy20P bwl20p = new selBrightenWhiteLampBy20P();
	    bwl20p.BrightenWhiteLampBy20P();
	    
	    TimeUnit.SECONDS.sleep(30);
	    
	    PHBridgeResourcesCache NewCache = bridge.getResourceCache();
	    
	    List<PHLight> allNewLights = NewCache.getAllLights();
	    
	    for(PHLight NewLights :allNewLights){
	    	
	    	PHLightState NewLightState = NewLights.getLastKnownLightState();
	    	
	    	if(NewLightState.isReachable()==false){
	    		nonReachableLights.add(NewLights.getName());
	    	}
	    	
	    	NewBrightnessLevel.put(NewLights.getName(), NewLightState.getBrightness());
	    }
	    
	    HashMap<String,Integer> TrueLights = new HashMap<String,Integer>();
	    HashMap<String,Integer> FalseLights = new HashMap<String,Integer>();
	    HashMap<String,Integer> TrueNonWhiteLampLights = new HashMap<String,Integer>();
	    HashMap<String,Integer> FalseNonWhiteLampLights = new HashMap<String,Integer>();
	    
	    for (Entry<String, Integer> OldKey : OldBrightnessLevel.entrySet()){
	    	
	    	for(Entry<String, Integer> NewKey : NewBrightnessLevel.entrySet()){
	    		
	    		if((NewKey.getKey().equals(OldKey.getKey())==true) && (NewKey.getKey().equalsIgnoreCase(LightName)==true)){
	    			
	    			OldWhiteLampBrightness=OldKey.getValue();
	    			NewWhiteLampBrightness=NewKey.getValue();
	    			
	    			int CalculatedBrightnessValue = OldKey.getValue()+((OldKey.getValue()*20)/100);
	    			
	    			if(NewKey.getValue().equals(CalculatedBrightnessValue)==true){
	    				TrueLights.put(NewKey.getKey(), NewKey.getValue());
	    			}else {
	    				FalseLights.put(NewKey.getKey(), NewKey.getValue());
	    			}
	    		}else if(NewKey.getKey().equalsIgnoreCase(LightName)==false && (NewKey.getKey().equalsIgnoreCase(OldKey.getKey())==true)){
	    			System.out.println("New Light Name:"+NewKey.getKey());
	    			System.out.println("New Brightness:"+NewKey.getValue());
	    			
	    			System.out.println("Old Light Name:"+OldKey.getKey());
	    			System.out.println("Old Brightness:"+OldKey.getValue());
	    			
	    			if((NewKey.getValue().equals(OldKey.getValue())==true)){
	    				TrueNonWhiteLampLights.put(NewKey.getKey(), NewKey.getValue());
	    			}else{
	    				FalseNonWhiteLampLights.put(NewKey.getKey(), NewKey.getValue());
	    			}
	    			
	    		}
	    		
	    	}
	    	
	    }
	    System.out.println("True Non white Lamp lights:"+TrueNonWhiteLampLights.toString());
	    System.out.println("False Non white Lamp lights:"+FalseNonWhiteLampLights.toString());
	    
	    if(FalseLights.isEmpty()==true && FalseNonWhiteLampLights.isEmpty()==true){
	    	Status="PASS";
	    	Results="White Lamp Brightened By 20%";
	    	if(nonReachableLights.isEmpty()==true){
	    		Remarks = "Old Brightness of White Lamp:"+OldWhiteLampBrightness+". New Brightness of White Lamp:"+NewWhiteLampBrightness;
	    	}else{
	    		Remarks = "Old Brightness of White Lamp:"+OldWhiteLampBrightness
	    				+". New Brightness of White Lamp:"+NewWhiteLampBrightness
	    				+". Non Reachable Lights:"+nonReachableLights.toString();
	    	}
	    	
	    	sendToHTML=createHTMLReport(Status,Results,Remarks);
	    }
	    else if(FalseLights.isEmpty()==true && FalseNonWhiteLampLights.isEmpty()==false){
	    	Status="FAIL";
	    	Results="White Lamp Brightened By 20%. However Brightness of some other light also changed.";
	    	if(nonReachableLights.isEmpty()==true){
	    		Remarks = "Brightness changed for:"+FalseNonWhiteLampLights.toString()+" Lights.";
	    	}else{
	    		Remarks = "Brightness changed for:"+FalseNonWhiteLampLights.toString()+" Lights."
	    				+". Non Reachable Lights:"+nonReachableLights.toString();
	    	}
	    	sendToHTML=createHTMLReport(Status,Results,Remarks);
	    }else if(FalseLights.isEmpty()==false && FalseNonWhiteLampLights.isEmpty()==true){
	    	Status="FAIL";
	    	Results="White Lamp is not Brightened By 20%.";
	    	if(nonReachableLights.isEmpty()==true){
	    		Remarks = "Old Brightness Value of White Lamp:"+OldWhiteLampBrightness
	    				+". New Brightness Value of white Lamp"+NewWhiteLampBrightness;
	    	}else{
	    		Remarks = "Old Brightness Value of White Lamp:"+OldWhiteLampBrightness
	    				+". New Brightness Value of white Lamp"+NewWhiteLampBrightness
	    				+". Non Reachable Lights:"+nonReachableLights.toString();
	    	}
	    	sendToHTML=createHTMLReport(Status,Results,Remarks);
	    }else if(FalseLights.isEmpty()==false && FalseNonWhiteLampLights.isEmpty()==false){
	    	Status="FAIL";
	    	Results="White Lamp is not Brightened By 20%. Also Brightness level of other Lights changed. ";
	    	if(nonReachableLights.isEmpty()==true){
	    		Remarks = "Old Brightness Value of All Lights:"+OldBrightnessLevel.toString()
	    				+". New Brightness Value of All Lights:"+NewBrightnessLevel.toString();
	    	}else{
	    		Remarks = "Old Brightness Value of All Lights:"+OldBrightnessLevel.toString()
				+". New Brightness Value of All Lights:"+NewBrightnessLevel.toString()
	    				+". Non Reachable Lights:"+nonReachableLights.toString();
	    	}
	    	sendToHTML=createHTMLReport(Status,Results,Remarks);
	    }
		return sendToHTML;
	}
	
	public String createHTMLReport(String htmlStatus, String htmlResults, String htmlRemarks){
		FinalHTMLString="<tr>\n<td style=\"border:1px solid black;border-collapse:collapse\">\n15</td>\n"
			      + "<td style=\"border:1px solid black;border-collapse:collapse\">\n Brighten White Lamp By 20%</td>\n"
			      + "<td style=\"border:1px solid black;border-collapse:collapse\">\n White Lamp should be Brighten By 20%.</td>\n"
			      + "<td style=\"border:1px solid black;border-collapse:collapse\">\n" +htmlResults + "</td>\n" 
			      + "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + htmlStatus + "</td>\n" 
			      +"<td style=\"border:1px solid black;border-collapse:collapse\">\n" + htmlRemarks + "</td>\n" + "</tr>\n";
		
		return FinalHTMLString;
	}
}
