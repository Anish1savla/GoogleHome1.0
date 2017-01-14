import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResourcesCache;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;

public class HBTurnONHueColorLamp1
{
  public String noHueColorLamp1;
  public int noHueColorLamp1Counter = 0;
  public String results;
  public String Status;
  public String Remarks;
  public String sendTohtml;
  
  public String HBTurnONhueColorLampOne(PHBridge bridge)
    throws InterruptedException
  {
    System.out.println("/***************************Inside Hue Bridge Turn ON Hue Color Lamp 1 class*********************************/");
    TimeUnit.SECONDS.sleep(30);
    PHBridgeResourcesCache cache = bridge.getResourceCache();
    List<PHLight> allLights = cache.getAllLights();
    List<String> TrueLights = new ArrayList<String>();
    List<String> FalseLights = new ArrayList<String>();
    List<String> nonReachableHuecolorLamp1 = new ArrayList<String>();
    List<String> nonReachableLights = new ArrayList<String>();
    for (PHLight lights : allLights)
    {
      PHLightState lightState = lights.getLastKnownLightState();
      
      String lightName = lights.getName();
      
      Boolean lightStatus = lightState.isOn();
      
      Boolean lightReachable = lightState.isReachable();
      if ((lightName.equals("Hue Color Lamp 1")) && (lightReachable.booleanValue()) && (lightStatus.booleanValue()))
      {
        TrueLights.add(lights.getName());
        this.noHueColorLamp1Counter += 1;
      }
      else if ((lightName.equals("Hue Color Lamp 1")) && (lightReachable.booleanValue()) && (!lightStatus.booleanValue()))
      {
        FalseLights.add(lights.getName());
      }
      else if ((lightName.equals("Hue Color Lamp 1")) && (!lightReachable.booleanValue()))
      {
        nonReachableHuecolorLamp1.add(lights.getName());
      }
      else if ((!lightName.equals("Hue Color Lamp 1")) && (!lightReachable.booleanValue()))
      {
        nonReachableLights.add(lights.getName());
      }
    }
    if ((FalseLights.isEmpty()) && (nonReachableHuecolorLamp1.isEmpty()))
    {
      this.results = "PASS";
      this.Status = "Hue Color Lamp 1 Turned ON";
      this.Remarks = (nonReachableLights.toString() + ": Are Non Reachable Lights.");
      this.sendTohtml = createHTMLReport(this.Status, this.results, this.Remarks);
    }
    else if (!FalseLights.isEmpty())
    {
      this.results = "FAIL";
      this.Status = "Hue Color Lamp 1 is OFF";
      this.Remarks = (nonReachableLights.toString() + ": Are Non Reachable Lights.");
      this.sendTohtml = createHTMLReport(this.Status, this.results, this.Remarks);
    }
    else if (!nonReachableHuecolorLamp1.isEmpty())
    {
      this.results = "FAIL";
      this.Status = "Hue Color Lamp 1 is Not Reachable";
      this.Remarks = (nonReachableLights.toString() + ": Are Non Reachable Lights.");
      this.sendTohtml = createHTMLReport(this.Status, this.results, this.Remarks);
    }
    else if (this.noHueColorLamp1Counter == 0)
    {
      this.results = "FAIL";
      this.Status = "Hue Bridge Doesn't have Hue Color Lamp 1";
      this.Remarks = (nonReachableLights.toString() + ": Are Non Reachable Lights.");
      this.sendTohtml = createHTMLReport(this.Status, this.results, this.Remarks);
    }
    //System.out.println("SendToHTML is:" + this.sendTohtml + "\n");
    return this.sendTohtml;
  }
  
  public String createHTMLReport(String htmlResults, String htmlStatus, String htmlRemarks)
  {
    //System.out.println("htmlResults: " + htmlResults + " htmlStatus: " + htmlStatus + " htmlRemarks :" + htmlRemarks);
    String htmlString1 = 
      "<tr>\n<td style=\"border:1px solid black;border-collapse:collapse\">\n6</td>\n<td style=\"border:1px solid black;border-collapse:collapse\">\nTurn ON Hue color Lamp 1</td>\n<td style=\"border:1px solid black;border-collapse:collapse\">\nHue Color Lamp 1 Should Turn ON</td>\n<td style=\"border:1px solid black;border-collapse:collapse\">\n" + 
      
      htmlResults + "</td>\n" + 
      "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + htmlStatus + "</td>\n" + 
      "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + htmlRemarks + "</td>\n" + "</tr>\n";
    
    return htmlString1;
  }
}
