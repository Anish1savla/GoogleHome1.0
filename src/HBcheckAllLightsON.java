
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResourcesCache;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HBcheckAllLightsON
{
  public static int counter = 0;
  public String results;
  public String Status;
  public String sendtoHTMLturnOFFAll;
  public String Remarks;
  
  public String HBTurnONAllLight(PHBridge bridge)
    throws InterruptedException
  {
	  
	  System.out.println("/**************************** INSIDE TURN ON ALL LIGHTS **********************************/");
    TimeUnit.SECONDS.sleep(27);
    
    PHBridgeResourcesCache cache = bridge.getResourceCache();
    List<PHLight> allLights = cache.getAllLights();
    List<String> lightList = new ArrayList<String>();
    List<String> nonReachablelightList = new ArrayList<String>();
    for (PHLight lights : allLights)
    {
      PHLightState lightState = lights.getLastKnownLightState();
      Boolean x = lightState.isOn();
      System.out.println(lights.getName());
      System.out.println(x);
      
      Boolean y = lightState.isReachable();
      if ((!x.booleanValue()) || (!y.booleanValue())) {
        if ((y.booleanValue()) && (!x.booleanValue()))
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
        this.results = "All lights turned ON";
        this.Remarks = "";
      }
      else
      {
        this.results = "All lights are ON. However few lights are Not Reachable.";
        this.Remarks = (nonReachablelightList.toString() + " : Lights are not reachable, please check Hue Bridge and Lights Settings.");
      }
      this.sendtoHTMLturnOFFAll = createHTMLReport(this.results, this.Status, this.Remarks);
    }
    else
    {
      this.results = (lightList.toString() + ": Lights are Still OFF");
      
      this.Status = "FAIL";
      this.Remarks = ("Please check Network Connection, Hue Bridge connection in Google Home and Light Status Manually" + nonReachablelightList.toString() + ":Lights are not reachable");
      this.sendtoHTMLturnOFFAll = createHTMLReport(this.results, this.Status, this.Remarks);
    }
    return this.sendtoHTMLturnOFFAll;
  }
  
  public String createHTMLReport(String resultString, String statusString, String resultRemarks)
  {
    /*String htmlString = "<center>\n<table width=\"80%\" style=\"border:1px solid black;border-collapse:collapse\">\n"
    		+ "<tr>\n<th style=\"border:1px solid black;border-collapse:collapse\">\nTest ID</th>\n"
    		+ "<th style=\"border:1px solid black;border-collapse:collapse\">\nTest Command Name</th>\n"
    		+ "<th style=\"border:1px solid black;border-collapse:collapse\">\nExpected Results</th>\n"
    		+ "<th style=\"border:1px solid black;border-collapse:collapse\">\nActual Results</th>\n"
    		+ "<th style=\"border:1px solid black;border-collapse:collapse\">\nStatus</th>\n"
    		+ "<th style=\"border:1px solid black;border-collapse:collapse\">\nRemarks</th>\n</tr>\n";*/
    
    String htmlString1 = //htmlString + 
      "<tr>\n" + 
      "<td style=\"border:1px solid black;border-collapse:collapse\"><font face=\"Verdana\">\n" + "1" + "</td>\n"+"</font>\n" + 
      "<td style=\"border:1px solid black;border-collapse:collapse\"><font face=\"Verdana\">\n" + "TurnONAllLights" + "</td>\n" +"</font>\n" + 
      "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + "All lights Present on Bridge should Turn ON" + "</td>\n" + 
      "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + resultString + "</td>\n" + 
      "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + statusString + "</td>\n" + 
      "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + resultRemarks + "</td>\n" + "</tr>\n";
    return htmlString1;
  }
}
