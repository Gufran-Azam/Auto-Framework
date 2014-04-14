package home;

import base.Base;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Gufran on 4/12/14.
 */
public class NavigationTab extends Base {
   // @Test
    public void test1() throws InterruptedException {
        System.out.println(wd.getCurrentUrl());
        Thread.sleep(1000);
        ClickOnId("nav-politics");
        ClickOnId("nav-world");
        ClickByCss("#cnn_switchEdition_intl");
        ClickOnId("cnn_switchEdition_intl");

        List<WebElement> navTabLink = getWebElementsByCss("#cnn_hdr-nav","li");
        System.out.println(navTabLink.size());
        for(WebElement element : navTabLink){
            System.out.println(element.getText());

        }

        //Click one by one on Tabs:
        List<WebElement> navTab = getWebElementsByCss("#cnn_hdr-nav" , "li");
        for(int i=0;i<navTab.size();i++){
            if(i==1 || i==13 || i==14 || i==15){
                navTab.get(i).findElement(By.tagName("a")).click();
                navigateBack();
            }
            else{
                navTab.get(i).findElement(By.tagName("a")).click();
                //navigateBack();

            }
            navTab = getWebElementsByCss("#cnn_hdr-nav", "li"); //Refetch to store the item in the DOM or to make the item fresh

        }
        //Few other Examples:
        typeByCss("input#hdr-search-box" , "ny");
        sleep(2);
        navigateBack();
        wd.findElement(By.cssSelector("input#hdr-search-box")).clear();

        wd.findElement(By.xpath(".//*[@id='cnn_mc2_large1']/div[1]/div[1]/a")).click();

    }
    //Fetch Tabs texts:
    /**ClickOnId("nav-politics");
     List<String> list = getListOfString("#cnn_mtt1rgtarea", "li");
     for(String list1 : list){
     System.out.println(list1); **/



    //@Test
    //Click one by one on Top News Links in Politics tab
    public void test2() throws InterruptedException {
        ClickOnId("nav-politics");
        List<WebElement> LinkTab = getWebElementsByCss("#cnn_mtt1rgtarea .cnn_bulletbin", "li");
        System.out.println(LinkTab.size());
        for(int i=0;i<LinkTab.size();i++){

            LinkTab.get(i).findElement(By.tagName("a")).click();
            sleep(4);
            navigateBack();
            sleep(2);
            LinkTab = getWebElementsByCss("#cnn_mtt1rgtarea .cnn_bulletbin", "li");//Refetch to store the item in the DOM or to make the item fresh

        }
    }
    @Test
    //Select DropDown Menu options:
    public void test3() throws InterruptedException{
        List<WebElement> dropDown;
        dropDown = getWebElementsByCss(".cnn_tsbnav.cnn_pmtvmodddown", "option");
        WebElement element = getWebElementByCss(".cnn_tsbnav.cnn_pmtvmodddown select");
        List<String> listOfMenutext = getListOfString(".cnn_tsbnav.cnn_pmtvmodddown", " select option");
        System.out.println(dropDown.size());
        for(int l=0;l<listOfMenutext.size();l++){
            if(l==1 || l==3){
                continue;

            }else{

                selectElementByOption(element, listOfMenutext.get(l));

            }
            navigateBack();
            element = getWebElementByCss(".cnn_tsbnav.cnn_pmtvmodddown select"); // Refetch to store the item in the DOM(=document object model) or to make the item fresh

        }
    }

    public void selectElementByOption(WebElement element, String value){
        Select select = new Select(element);
        select.selectByVisibleText(value);

    }


    /**
     public void selectOption() throws InterruptedException {
     WebElement element =wd.findElement(By.cssSelector(".cnn_tsbnav.cnn_pmtvmodddown select"));
     Select select1 = new Select(element);
     select1.selectByVisibleText("Early Start");
     sleep(2);
     navigateBack();




     }**/

    //@Test
    //This is Login to a separate window:
    public void test4() throws InterruptedException {
        Set<String> window = wd.getWindowHandles();
        Iterator it = window.iterator();
        String homewindow = wd.getWindowHandle();
        wd.findElement(By.xpath(".//*[@id='hdr-auth']/ul/li[2]/a")).click();
        window = wd.getWindowHandles();
        it = window.iterator();
        String popUpWindow = (String) it.next();
        wd.switchTo().window(popUpWindow);
        wd.findElement(By.cssSelector(".cnnOvrlyBtn.cnnBtnLogIn")).click();
        window = wd.getWindowHandles();
        it = window.iterator();
        String popUpWindow2 = (String) it.next();
        wd.switchTo().window(popUpWindow2);
        typeByCss("input#cnnOverlayEmail1l","gufran.azam1992@gmail.com");
        typeByCss("input#cnnOverlayPwd","Mycnn786");
        wd.findElement(By.cssSelector(".cnnOvrlyBtn.cnnBtnLogIn")).click();
        wd.switchTo().window(homewindow);
        sleep(5);
        wd.findElement(By.cssSelector(".no-border.no-pad-right li"));
        //.findElement(By.linkText("Log out"));


        //("javascript:Member.fullLogout();"));
        //findElement(By.cssSelector(".no-border no-pad-right")).

        //wd.findElement(By.xpath(".//*[@id='hdr-auth']/ul/li[2]/a")).click();





    }
}





