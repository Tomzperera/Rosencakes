package testp;

import org.testng.annotations.Test;

import basep.BaseClass;
import pagep.RnCp1;
import pagep.RnCp2;
import pagep.RnCp3;
import pagep.RnCp4;
import utilityp.RncExcel;

public class RncTest extends BaseClass{
	@Test
	public void verifyLoginWithValidCred () throws Exception

	{
	            RnCp1 p1 = new RnCp1(driver);
	            

	// Reading the data from excel file by the specified path

	            String xl = "C:\\Users\\thomas\\Downloads\\Rosencakes.xlsx";

	            String Sheet = "Sheet1";

	            int rowCount = RncExcel.getRowCount(xl, Sheet);

	            for (int i=0;i<=rowCount;i++)

	            {
	            	p1.login();
	                        String UserName=RncExcel.getCellValue(xl, Sheet, i, 0);
                               System.out.println("username---"+UserName);
	                        String Pwd=RncExcel.getCellValue(xl, Sheet, i, 1);
                             System.out.println("password---"+Pwd);
	                        //Passing Username and password as parameters
	                        p1.passvalues(UserName, Pwd);
                         //Submitting the data by clicking on login button                   
                             p1.pressbtn();        
	                        
	                        String expectedurl="https://www.rosencakes.com/dashboard.php";
	          			  String actualurl= driver.getCurrentUrl();
	          			  
	          			     if(actualurl.equals(expectedurl))
	          			     {
	          			    	System.out.println("pass");
	          			     }else
	          			     {
	          			    	System.out.println("fail");
	          			     }

	                        
	            }
	            RnCp2 p2 = new RnCp2(driver);
	            p2.enterinput();
	            p2.Capture();
	            p2.checkbox();
	            p2.button();
	            p2.size();
	            p2.selectdate();
	            p2.deliverytime();
	            p2.message();
	            p2.Addtocart();
	            
	            RnCp3 p3 = new RnCp3(driver);
	            p3.coupon();
	            p3.warning();
	            p3.order();
	            p3.receiverdetails();
	            p3.Country();
	            p3.cart();
	            p3.Logout();
	            
	            RnCp4 p4 = new RnCp4(driver);
	            p4.Facebook();	            
}

}
