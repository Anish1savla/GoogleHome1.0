import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResourcesCache;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;

public class HBCheckAllLightsGreen
{
  public static int counter = 0;
  public String results;
  public String Status;
  public String sendtoHTMLturnOFFAll;
  public String Remarks;
  public int OldintX;
  public int OldintY;
  public int NewintX;
  public int NewintY;
  public double xColor;
  public double yColor;
  
  public String HBCheckAllLightsToGreen(PHBridge bridge)
    throws InterruptedException
  {
    //System.out.println("/*************************Inside HBCheck change Green color****************************/");
    
    TimeUnit.SECONDS.sleep(60);
    PHBridgeResourcesCache cache = bridge.getResourceCache();
    
    List<PHLight> allLights = cache.getAllLights();
    List<String> lightList = new ArrayList<String>();
    List<String> reachablelightList = new ArrayList<String>();
    List<String> nonReachablelightList = new ArrayList<String>();
    List<String> nonColorLights = new ArrayList<String>();
    for (PHLight lights : allLights)
    {
      PHLight.PHLightType lightType = lights.getLightType();
      String br = lightType.toString();
      //System.out.println("Light Type:" + br);
      //System.out.println("Light Name:" + lights.getName());
      
      PHLightState lightState = lights.getLastKnownLightState();
      Float colorX = lightState.getX();
      Float colorY = lightState.getY();
      Boolean x = lightState.isReachable();
      //System.out.println("Turn all lights Green X value:" + colorX);
      //System.out.println("Turn all lights Green Y value:" + colorY);
      //System.out.println("Light is Reachable?:" + x);
      if ((colorX != null) && (colorY != null))
      {
        this.xColor = colorX.floatValue();
        this.yColor = colorY.floatValue();
      }
      else
      {
        this.xColor = -1.0D;
        this.yColor = -1.0D;
      }
      //System.out.println(this.xColor);
      //System.out.println(this.yColor);
      
      String lightversion = lights.getVersionNumber();
      
      System.out.println("Lighstrip or not:" + lights.getName().contains("lightstrip"));
      if (((lightversion.equals("1.15.2_r19181")) || ((lights.getName().contains("lightstrip")) && (lightversion == "5.50.1.19085"))) && 
        (colorX != null) && (colorY != null))
      {
        if ((this.xColor >= 0.17) && (this.xColor <= 0.173) && (this.yColor >= 0.69998) && (this.yColor <= 0.75))
        {
          this.OldintX = 1;
          this.OldintY = 1;
        }
        else
        {
          this.OldintX = 0;
          this.OldintY = 0;
        }
      }
      else if ((lightversion.equals("5.50.1.19085")) && (colorX != null) && (colorY != null) && (!lights.getName().contains("lightstrip")))
      {
        if ((this.xColor >= 0.409) && (this.xColor <= 0.41) && (this.yColor >= 0.517) && (this.yColor <= 0.519))
        {
          this.NewintX = 1;
          this.NewintY = 1;
        }
        else
        {
          this.NewintX = 0;
          this.NewintY = 0;
        }
      }
      else if (lights.getName().contains("lightstrip"))
      {
    	 // System.out.println("Inside lightstrip IF check");
        if ((this.xColor >= 0.17) && (this.xColor <= 0.173) && (this.yColor >= 0.69555) && (this.yColor <= 0.75005))
        {
          this.NewintX = 1;
          this.NewintY = 1;
        }
        else
        {
          this.NewintX = 0;
          this.NewintY = 0;
        }
      }
      else {
        nonColorLights.add(lights.getName());
      }
      if ((!lightType.toString().equals("CT_LIGHT")) && (!lightType.toString().equals("DIM_LIGHT")) && 
        ((this.OldintX == 1) || (this.NewintX == 1)) && ((this.OldintY == 1) || (this.NewintY == 1)) && (x.booleanValue()))
      {
        //System.out.println("Inside IF to check RED x Y values");
        reachablelightList.add(lights.getName());
      }
      else if ((x.booleanValue()) && (this.OldintX != 1) && (this.NewintX != 1) && (this.OldintY != 1) && (this.NewintY != 1) && 
        (!lightType.toString().equals("CT_LIGHT")) && (!lightType.toString().equals("DIM_LIGHT")))
      {
        //System.out.println("Inside 1st ELSE IF to check RED x Y values");
        lightList.add(lights.getName());
      }
      else if (!x.booleanValue())
      {
        //System.out.println("Inside 2nd ELSE IF to check RED not reachable values");
        nonReachablelightList.add(lights.getName());
      }
    }
    
    //String reachableLights="Reachable light List:"+reachablelightList.toString();
    //System.out.println(reachableLights);
    //String lightList1 = "lightList:"+lightList.toString();
    //System.out.println(lightList1);
    //String nonReachablelightList1="Non Reachable lights:"+nonReachablelightList.toString();
    //System.out.println(nonReachablelightList1);
    
    if (lightList.isEmpty())
    {
      //System.out.println("Inside IF to PASS");
      this.Status = "PASS";
      if (nonReachablelightList.isEmpty())
      {
        this.results = "All lights turned GREEN";
        this.Remarks = (nonColorLights.toString() + ": Are Not Color Lights");
      }
      else
      {
        //System.out.println("Inside IF to FAIL");
        this.results = "All lights turned GREEN. However few lights are Not Reachable.";
        this.Remarks = (nonReachablelightList.toString() + " : Lights are not reachable, please check Hue Bridge and Lights Settings." + nonColorLights.toString() + ": Are Not Color Lights");
      }
      this.sendtoHTMLturnOFFAll = createHTMLReport(this.results, this.Status, this.Remarks);
    }
    else
    {
      this.results = (lightList.toString() + ": Lights didn't Turn GREEN");
      
      this.Status = "FAIL";
      this.Remarks = ("Please check Network Connection, Hue Bridge connection in Google Home and Light Color Status Manually. " + nonReachablelightList.toString() + ":Lights are not reachable");
      this.sendtoHTMLturnOFFAll = createHTMLReport(this.results, this.Status, this.Remarks);
    }
    return this.sendtoHTMLturnOFFAll;
  }
  
  public String createHTMLReport(String results, String status, String remarks)
  {
    String htmlChangeColorGreenString = 
    
    "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + "3" + "</td>\n" + 
    "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + "Turn Lights Green" + "</td>\n" + 
    "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + "All lights Present on Bridge should Turn Green" + "</td>\n" + 
    "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + results + "</td>\n" + 
    "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + status + "</td>\n" + 
    "<td style=\"border:1px solid black;border-collapse:collapse\">\n" + remarks + "</td>\n" + "</tr>\n";
    
    
    return htmlChangeColorGreenString;
  }
}
