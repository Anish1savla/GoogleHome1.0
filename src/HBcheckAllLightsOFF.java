
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResourcesCache;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;

public class HBcheckAllLightsOFF
{
  public static int counter = 0;
  public String results;
  public String Status;
  public String Remarks;
  public String sendTohtml;
  
  public String HBTurnOFFAlllight(PHBridge bridge)
    throws InterruptedException
  {
    //System.out.println("/***************************Inside Hue Bridge Turn OFF All Lights class*********************************/");
    TimeUnit.SECONDS.sleep(40);
    PHBridgeResourcesCache cache = bridge.getResourceCache();
    List<PHLight> allLights = cache.getAllLights();
    List<String> lightList = new ArrayList<String>();
    List<String> nonReachablelightList = new ArrayList<String>();
    for (PHLight lights : allLights)
    {
      PHLightState lightState = lights.getLastKnownLightState();
      Boolean x = lightState.isOn();
      
      Boolean y = lightState.isReachable();
      if ((x.booleanValue()) || (!y.booleanValue())) {
        if ((x.booleanValue()) && (y.booleanValue()))
        {
          lightList.add(lights.getName());
          
          counter += 1;
        }
        else if (!y.booleanValue())
        {
          nonReachablelightList.add(lights.getName());
        }
      }
    }
    if (lightList.isEmpty())
    {
      this.Status = "PASS";
      if (nonReachablelightList.isEmpty())
      {
        this.results = "All lights are OFF";
        this.Remarks = "";
      }
      else
      {
        this.results = "All lights are OFF.However few lights are Not Reachable.";
        this.Remarks = (nonReachablelightList.toString() + ": Lights are not reachable. Please check your Hue Bridge and Lights Settings");
      }
      this.sendTohtml = createHTMLReport(this.results, this.Status, this.Remarks);
    }
    else
    {
      this.results = (lightList.toString() + ": Lights are Still ON.");
      
      this.Status = "FAIL";
      this.Remarks = ("Please check Network Connection, Hue Bridge connection in Google Home and Light Status Manually. " + nonReachablelightList.toString() + ":Lights are not reachable");
      this.sendTohtml = createHTMLReport(this.results, this.Status, this.Remarks);
    }
    return this.sendTohtml;
  }
  
  public String createHTMLReport(String htmlResults, String htmlStatus, String htmlRemarks)
  {
    String htmlString1 = "<tr>\n" + 
    	      "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + "2" + "</td>\n" + 
    "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + "TurnOFFAllLights" + "</td>\n" + 
    "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + "All lights Present on Bridge should Turn OFF" + "</td>\n"  
     + "<td style=\"border:1px solid black;border-collapse:collapse\">\n" +htmlResults + "</td>\n" + 
      "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + htmlStatus + "</td>\n" + 
      "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + htmlRemarks + "</td>\n" + "</tr>\n";
    return htmlString1;
  }
}
