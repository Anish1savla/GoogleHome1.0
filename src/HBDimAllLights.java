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

public class HBDimAllLights {
	
	public String currentOldLightName;
	public String currentNewLightName;
	public float NewCalculatedBrightness;
	public float SixtyPercentBrightnessValue;
	public float floatvalueofbrightness;
	public int finalint;
	public int MaxRange;
	public int MinRange;
	public String Results;
	public String Status;
	public String Remarks;
	public String sendTohtml;
	
	public String HBDimLights(PHBridge bridge, WebDriver driver) throws InterruptedException, FindFailed{
		
		System.out.println("/***************************Inside Hue Bridge DIM ALL LIGHTS class*********************************/");
	    
		List<String> TrueLights = new ArrayList<String>();
	    List<String> FalseLights = new ArrayList<String>();
	    List<String> nonReachableLights = new ArrayList<String>();

	    PHBridgeResourcesCache cache = bridge.getResourceCache();
	    
	    List<PHLight> allLights = cache.getAllLights();
	    
	    HashMap<String,Integer> OldBrightness = new HashMap<String,Integer>();
	    HashMap<String,Integer> NewBrightness = new HashMap<String,Integer>();
	    
	    
	    for (PHLight lights : allLights)
	    {
	    	
	    	PHLightState lightState = lights.getLastKnownLightState();
	    	if(lightState.isReachable()==false){
	    		nonReachableLights.add(lights.getName());
	    	}else{
	    	
	    	String lightName = lights.getName();
	    	//System.out.println("Light Name is :"+lightName);
	    	
	    	//PHLightState lightState = lights.getLastKnownLightState();
	    	int lightBrightness = lightState.getBrightness();
	    	//System.out.println("Brightness is:"+lightBrightness);
	    	
	    	OldBrightness.put(lightName,lightBrightness);
	    	//System.out.println("Hashmap light:"+OldBrightness.get(lightName));
	    	
	    	//OldBrightness.keySet().stream().forEach(key->System.out.println(key));
	    	//OldBrightness.entrySet().stream().forEach(entry -> System.out.println(entry.getKey()+"-"+entry.getValue()));
	    	}
	    }
	  selDimAllLights sda = new selDimAllLights();
	  sda.selDimLights(bridge, driver);
	  
	  TimeUnit.SECONDS.sleep(30);
	  PHBridgeResourcesCache cache1 = bridge.getResourceCache();
	  List<PHLight> allLights1 = cache1.getAllLights();
	    for(PHLight lights : allLights1)
	    {
	    	PHLightState lightState = lights.getLastKnownLightState();
	    	if(lightState.isReachable()==false){
	    		nonReachableLights.add(lights.getName());
	    	}else{
	    	
	    	String lightName = lights.getName();
	    	//System.out.println("Light Name is :"+lightName);
	    	
	    	
	    	int lightBrightness = lightState.getBrightness();
	    	//System.out.println("Brightness is:"+lightBrightness);
	    	
	    	NewBrightness.put(lightName,lightBrightness);
	    	//System.out.println("Hashmap light:"+NewBrightness.get(lightName));
	    	
	    	//NewBrightness.keySet().stream().forEach(key->System.out.println(key));
	    	//NewBrightness.entrySet().stream().forEach(entry -> System.out.println(entry.getKey()+"-"+entry.getValue()));
	    	}
	    }
	    
	    for (Entry<String, Integer> key : OldBrightness.entrySet()){
	    	//System.out.println("Old Key  Is:"+key.getKey());
	    	//System.out.println("Old Value Is:"+key.getValue());
	    	 //TimeUnit.SECONDS.sleep(2);
	    	for(Entry<String, Integer> NewKey : NewBrightness.entrySet()){
	    		 //TimeUnit.SECONDS.sleep(2);
	    		currentOldLightName = key.getKey();
	    		currentNewLightName = NewKey.getKey();
	    		//System.out.println("New Key Is:"+currentNewLightName);
	    		//System.out.println("Old Key Is:"+currentOldLightName);
	    		Boolean x=currentNewLightName.contains(currentOldLightName);
	    		//System.out.println("Equal or not:"+x);
	    		
	    		//System.out.println("In Non Reachable Light list? "+nonReachableLights.contains(currentNewLightName));
	    		
	    		if(x==true && nonReachableLights.contains(currentNewLightName)==false){
	    			//System.out.println("Inside IF Statement");
	    			//System.out.println("Key Value is same as new key");
	    			//System.out.println("Old Brightness is:"+key.getValue());
	    			//System.out.println("New Brightness is:"+NewKey.getValue());
	    			floatvalueofbrightness=key.getValue();
	    			//System.out.println("floatvalueofbrightness is :"+floatvalueofbrightness);
	    			SixtyPercentBrightnessValue = (floatvalueofbrightness*60)/100;
	    			//System.out.println("SixtyPercentBrightnessValue is:"+SixtyPercentBrightnessValue);
	    			
	    			NewCalculatedBrightness = key.getValue()-SixtyPercentBrightnessValue;
	    			//System.out.println("NewCalculatedBrightness is :"+NewCalculatedBrightness);
	    			
	    			MaxRange = (int) (NewCalculatedBrightness+1);
	    			MinRange = (int) (NewCalculatedBrightness-1);
	    			
	    			//System.out.println("MaxRange is:"+MaxRange+"\nMinRange is:"+MinRange);
	    			
	    			
	    			if(NewCalculatedBrightness>=MinRange && NewCalculatedBrightness<=MaxRange){
	    				//System.out.println("New Calculated Value is matching");
	    				TrueLights.add(currentNewLightName);
	    			}else{
	    				//System.out.println("New Calcualted value is:"+NewCalculatedBrightness);
	    				//System.out.println("New Brightness Value is:"+NewKey.getValue());
	    				FalseLights.add(currentNewLightName);
	    			}
	    		}
	    	}
	    	
	    }
	    
	    if(FalseLights.isEmpty()==true){
	    	Results = "PASS";
	    	Status = "All lights are Dimmed by 60% of Current Brightness Level";
	    	if(nonReachableLights.isEmpty()==true){
	    		Remarks = " ";
	    		//Remarks= "Old Brightness level of lights : "+OldBrightness.toString()+"New Brightness level of lights: "+NewBrightness.toString();
	    		//System.out.println("Remarks:"+Remarks);
	    	}else {
	    	Remarks = nonReachableLights.toString()+": Are non Reachable Light.";
	    	}
	    	sendTohtml=createHTMLReport(Results,Status,Remarks);
	    }
	    else if(FalseLights.isEmpty()==false){
	    		Results="FAIL";
	    		Status= "Dimming Level of lights : "+FalseLights.toString()+" is incorrect";
	    		Remarks= "Old Brightness level of lights : "+OldBrightness.toString()+"\nNew Brightness level of lights: "+NewBrightness.toString();
	    		sendTohtml=createHTMLReport(Results,Status,Remarks);
	    	}
	     
    	return sendTohtml;
	}
	
	public String createHTMLReport(String htmlResults, String htmlStatus, String htmlRemarks){
	    System.out.println("htmlResults: " + htmlResults + " htmlStatus: " + htmlStatus + " htmlRemarks :" + htmlRemarks);
	    String htmlString1 = 
	      "<tr>\n<td style=\"border:1px solid black;border-collapse:collapse\">\n8</td>\n"
	      + "<td style=\"border:1px solid black;border-collapse:collapse\">\nDim All Lights</td>\n"
	      + "<td style=\"border:1px solid black;border-collapse:collapse\">\nAll Lights Should be Dimmed by 60% of current Brightness Level.</td>\n"
	      + "<td style=\"border:1px solid black;border-collapse:collapse\">\n" +htmlStatus + "</td>\n" 
	      + "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + htmlResults + "</td>\n" 
	      +"<td style=\"border:1px solid black;border-collapse:collapse\">\n" + htmlRemarks + "</td>\n" + "</tr>\n";
		return htmlString1;
		
	}
	
}
