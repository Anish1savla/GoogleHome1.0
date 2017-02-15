import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResourcesCache;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;

public class HBSetAllBrightnessTo100
{
  public static int counter = 0;
  public String results;
  public String Status;
  public String sendtoHTMLsetBrightness100;
  public String Remarks;
  
  public String HBSetBrightnessTo100Percent(PHBridge bridge)
    throws InterruptedException
  {
    System.out.println("Inside HBCheck change red color");
    
    TimeUnit.SECONDS.sleep(27);
    PHBridgeResourcesCache cache = bridge.getResourceCache();
    
    HashMap<String, Integer> TrueLightListHash = new HashMap<String, Integer>();
    HashMap<String, Integer> FalseLightListHash = new HashMap<String, Integer>();
    List<PHLight> allLights = cache.getAllLights();
    List<String> FalselightList = new ArrayList<String>();
    List<String> TruelightList = new ArrayList<String>();
    List<String> nonReachablelightList = new ArrayList<String>();
    List<String> nonDimmingLights = new ArrayList<String>();
    for (PHLight lights : allLights)
    {
      PHLight.PHLightType lightType = lights.getLightType();
      String br = lightType.toString();
      
      //System.out.println(br);
      //System.out.println(lights.getName());
      
      PHLightState lightState = lights.getLastKnownLightState();
      int BrightnessLevel = lightState.getBrightness().intValue();
      
      Boolean x = lightState.isReachable();
      if ((!br.toString().equals("ON_OFF_LIGHT")) && (BrightnessLevel == 254) && (x.booleanValue()))
      {
        TruelightList.add(lights.getName());
        TrueLightListHash.put(lights.getName(), lightState.getBrightness());
      }
      else if ((!br.toString().equals("ON_OFF_LIGHT")) && (BrightnessLevel != 254) && (x.booleanValue()))
      {
        FalselightList.add(lights.getName());
        FalseLightListHash.put(lights.getName(), lightState.getBrightness());
      }
      else if ((br.toString().equals("ON_OFF_LIGHT")) && (x.booleanValue()))
      {
        nonDimmingLights.add(lights.getName());
      }
      else if (!x.booleanValue())
      {
        nonReachablelightList.add(lights.getName());
      }
    }
    if ((FalselightList.isEmpty()) && (nonDimmingLights.isEmpty()) && (nonReachablelightList.isEmpty()))
    {
      this.results = "PASS";
      this.Status = "Brightness for All Lights is 100%.";
      this.Remarks = "";
      this.sendtoHTMLsetBrightness100 = createHTMLReport(this.Status, this.results, this.Remarks);
    }
    else if ((FalselightList.isEmpty()) && (!nonDimmingLights.isEmpty()) && (nonReachablelightList.isEmpty()))
    {
      this.results = "PASS";
      this.Status = "Brightness for All Lights is 100%.";
      this.Remarks = (nonDimmingLights.toString() + ": Are Non Dimming Lights.");
      this.sendtoHTMLsetBrightness100 = createHTMLReport(this.Status, this.results, this.Remarks);
    }
    else if ((FalselightList.isEmpty()) && (nonDimmingLights.isEmpty()) && (!nonReachablelightList.isEmpty()))
    {
      this.results = "PASS";
      this.Status = "Brightness for All Lights is 100%.";
      this.Remarks = (nonReachablelightList.toString() + ": Lights are Not Reachable");
      this.sendtoHTMLsetBrightness100 = createHTMLReport(this.Status, this.results, this.Remarks);
    }
    else if ((FalselightList.isEmpty()) && (!nonDimmingLights.isEmpty()) && (!nonReachablelightList.isEmpty()))
    {
      this.results = "PASS";
      this.Status = "Brightness for All Lights is 100%. However few lights are not reachable.";
      this.Remarks = (nonDimmingLights.toString() + ": Are Non Dimming Lights." + nonReachablelightList.toString() + " : Are Non Reachable Lights.");
      this.sendtoHTMLsetBrightness100 = createHTMLReport(this.Status, this.results, this.Remarks);
    }
    else if ((!FalselightList.isEmpty()) && (nonDimmingLights.isEmpty()) && (nonReachablelightList.isEmpty()))
    {
      this.results = "FAIL";
      this.Status = ("Brightness for lights: " + FalselightList.toString() + " are not 100%." + FalseLightListHash.toString());
      this.Remarks = ("Please check Hue Lights and Bridge Connection. Manually Test Command \"Set Brightness to 100%\" " + FalseLightListHash.toString());
      this.sendtoHTMLsetBrightness100 = createHTMLReport(this.Status, this.results, this.Remarks);
    }
    else if ((!FalselightList.isEmpty()) && (!nonDimmingLights.isEmpty()) && (nonReachablelightList.isEmpty()))
    {
      this.results = "FAIL";
      this.Status = ("Brightness for lights: " + FalselightList.toString() + " are not 100%. ");
      this.Remarks = 
        ("Brightness Level :" + FalseLightListHash.toString() + nonDimmingLights.toString() + ": Lights are Not Dimming Lights.");
      this.sendtoHTMLsetBrightness100 = createHTMLReport(this.Status, this.results, this.Remarks);
    }
    else if ((!FalselightList.isEmpty()) && (nonDimmingLights.isEmpty()) && (!nonReachablelightList.isEmpty()))
    {
      this.results = "FAIL";
      this.Status = ("Brightness for lights: " + FalselightList.toString() + " are not 100%. ");
      this.Remarks = ("Brightness Level :" + FalseLightListHash.toString() + nonReachablelightList.toString() + ": Lights are Not Reachable.");
      this.sendtoHTMLsetBrightness100 = createHTMLReport(this.Status, this.results, this.Remarks);
    }
    else if ((!FalselightList.isEmpty()) && (!nonDimmingLights.isEmpty()) && (!nonReachablelightList.isEmpty()))
    {
      this.results = "FAIL";
      this.Status = ("Brightness for lights: " + FalselightList.toString() + " are not 100%. ");
      this.Remarks = 
        ("Brightness Level :" + FalseLightListHash.toString() + nonReachablelightList.toString() + ": Lights are Not Reachable." + nonDimmingLights.toString() + ": Lights are Non Dimmable Lights.");
      this.sendtoHTMLsetBrightness100 = createHTMLReport(this.Status, this.results, this.Remarks);
    }
    //System.out.println("HTML Data from Brightness 100%" + this.sendtoHTMLsetBrightness100);
    
    return this.sendtoHTMLsetBrightness100;
  }
  
  public String createHTMLReport(String results, String status, String remarks)
  {
    String htmlSetBrightness100 = 
      "<tr>\n<td style=\"border:1px solid black;border-collapse:collapse\">\n5</td>\n"
      + "<td style=\"border:1px solid black;border-collapse:collapse\">\nSet Brightness For All Lights To 100%</td>\n"
      + "<td style=\"border:1px solid black;border-collapse:collapse\">\nBrightness for All Lights should be set to 100%</td>\n"
      + "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + results  + "</td>\n" + 
      "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + status + "</td>\n" + 
      "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + remarks + "</td>\n" + "</tr>\n";
    
    return htmlSetBrightness100;
  }
}
