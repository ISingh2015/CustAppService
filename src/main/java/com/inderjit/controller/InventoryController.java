package com.inderjit.controller;

import com.inderjit.util.PortalUtil;
import com.inderjit.vo.InvImageDescVO;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InventoryController {

    @RequestMapping(value = "featureInventory", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView feature() {
        ModelAndView mav = new ModelAndView("home/featureInventory");
        PortalUtil.addAttributesToSession(mav);
        mav.addObject("imageAndDescr", createInventoryDat());
        return mav;
    }

    @RequestMapping(value = "featureInventory{imageId}", method = {RequestMethod.GET, RequestMethod.POST})
    
    public ModelAndView featureImage(@PathVariable Long imageId) {
        ModelAndView mav = new ModelAndView("home/inventoryimage");
        PortalUtil.addAttributesToSession(mav);
        mav.addObject("imageToDisplay", invImage[imageId.intValue()]);
        return mav;
    }

    private ArrayList<InvImageDescVO> invImageAndDescrList;

    private final String[] invImage = {"images/login.png", "images/salesman.png", "images/salesmanrep.png", "images/supplier.png", "images/supplierRep.png", "images/customer.png",
        "images/customerRep.png", "images/purchase.png", "images/purchaserep.png", "images/purchasebillselect.png", "images/invoice.png",
        "images/invoicerep.png", "images/invoicerepselect.png", "images/purchasertn.png", "images/purchasertnrep.png", "images/purchasertnrepselect.png",
        "images/invoicertn.png", "images/invoicertnrep.png", "images/invoicertnrepselect.png", "images/admin.png", "images/adminrep.png",
        "images/helpscrsample.png"
    };

    private ArrayList<InvImageDescVO> createInventoryDat() {
        invImageAndDescrList = new ArrayList<>();
        for (int i = 0; i < invImage.length; i++) {
            InvImageDescVO iid = new InvImageDescVO();
            iid.setDescr(getInvImageDescr(i));
            iid.setName(getInvImage()[i]);
            invImageAndDescrList.add(iid);

        }
        return invImageAndDescrList;
    }

    public String getInvImageDescr(int option) {
        if (option == 0) {
            return "<b><mark>Login Screen to the Swing Client</mark></b> Image on the Left "
                    + "<b><mark>Sign button</mark></b> on this page. Sign in to the Inventory module "
                    + "with your credentials, Signing In through the WEB only allows for download of the SWING Client and creates a ADMIN User in the Inventory Database. "
                    + "If a user is a Administrator then this user could create other users (using the swing client) and provide them with access to Sign In remotely and access a Inventory module using the downloaded Inventory SWING Client. "
                    + "</br>"
                    + "To do the above,Click the <b><mark>Sign Up button</mark></b> on this page, and create a login on our Web Site (You will need a valid email address and mobile no to create a Sign in). Click <b><mark>Download button</mark></b> on this page and download the SWING client. The run downloaded Setup (EXE) file and install the Online Inventory software on a Windows Machine, Once the Inventory SWING Client in installed successfully, Run the Inventory application by double clicking on the desktop ICON and Sign In using your credentials. (See Login screen on the Left)."
                    + "</br>"
                    + "The above should enable you to see the rest of the Inventory screens on your Desktop (As shown below).Please take your time to go through before downloading and running the application. You could leave me a comment by clicking the <mark>About US</mark> link below in the <mark>Comments section</mark> to enable me enhance my services.";
        } else if (option == 1) {
            return "<b><mark>Sales Man</mark></b> Create-Update-Remove Sales Person. The sales person once created is used for recording Orders, Invoices & returns. An existing sales person appears in the list as shown in the image and can be updated but DOUBLE CLICKING, buttons are reassigned automatically and the sales person can be edited or deleted (in case of no transactions). On completing the update click the SAVE button. The enteries in the listing table will be disabled till the update is completed or disgarded. Text Filed and number fileds on the forms follow validations, help button on the form is used to select a manager code for the sales person.  budgeting is possible and will be made available in the accounting module. To view a List or actvie or inactive sales people, simply press the PRINT LIST  button or select the option from the Menu and on the appearing report-filter popup window click the Ok button to view the report to the screen. Printing hardcopies to shared or connected devices, exporting of the report is possible to different formats (e.g. PDf, Excel, Word.). Report layout can be changed depending on hardcopy printout requirements as shown in the image below.";
        } else if (option == 2) {
            return "<b><mark>Sales Person Report Filter Panel</mark></b> This produces a listing of Sales people within your oganisation, To filter the report, sort the report apply the criteria in the window before clicking the ok button. The report is displayed in seconds on your screen, depending on your internet connection speed. If nothing found is displayed try adjusting the create dates as this is important. To print hard copies of the report or navigate between pages, use the buttons in the top panel of the report view. To export the report use  the SAVE icon on the report view.";
        } else if (option == 3) {
            return "<b><mark>Supplier</mark></b> Create-Update-Remove Suppliers. The supplier onces created can be used to raise orders. An existing supplier can be edited by  DOUBLE CLICKING in the list below as shown in the screen or deleted (In case of no ORDER or INVOICE transactions found). A unique code in generated for each supplier along with the name and address information. Email fields and website fields are important and are used for mailing orders intimations to supplier websites or email domains. If enrolled suppliers could approve or reject an order using external portal). To view a List or actvie or inactive suppliers, simply press the PRINT LIST  button or select the option from the Menu and on the appearing report-filter popup window click the Ok button to view the report to the screen. Printing hardcopies to shared or connected devices, exporting of the report is possible to different formats (e.g. PDf, Excel, Word.). Report layout can be changed depending on hardcopy printout requirements as shown in the image below.";
        } else if (option == 4) {
            return "<b><mark>Supplier Report Filter Panel</mark></b> This produces a listing of Supplier within your oganisation, To filter the report, sort the report apply the criteria in the window before clicking the ok button. The report is displayed in seconds on your screen, depending on your internet connection speed. If nothing found is displayed try adjusting the create dates as this is important. To print hard copies of the report or navigate between pages, use the buttons in the top panel of the report view. To export the report use  the SAVE icon on the report view.";
        } else if (option == 5) {
            return "<b><mark>Customer</mark></b> Create-Update-Remove Customers. Once created are used to raise invoice depending on the sale of an existing product. The invoice module is exlained below. A unique code is generated for each Customer, with the address, email and website information. These are validated and can be edited anytime from within the system by any administrator or user. To edit an existing customer DOUBLE CLICK on the itme in the list as shown in the figure on the left. The buttons in the action panel are enable or disabled depending on the assigned rights. On completing the update click the SAVE button. The enteries in the listing table will be disabled till the update is completed or disgarded. Email fields and website fields are important and are used for mailing order intimations to supplier websites or email domains. If enrolled suppliers could approve or reject an order using external portal). To view a List or actvie or inactive sales people, simply press the PRINT LIST  button or select the option from the Menu and on the appearing report-filter popup window click the Ok button to view the report to the screen. Printing hardcopies to shared or connected devices, exporting of the report is possible to different formats (e.g. PDf, Excel, Word.). Report layout can be changed depending on hardcopy printout requirements as shown in the image below.";
        } else if (option == 6) {
            return "<b><mark>Customer Report Filter Panel</mark></b> This produces a listing of Customers within your oganisation, To filter the report, sort the report apply the criteria in the window before clicking the ok button. The report is displayed in seconds on your screen, depending on your internet connection speed. If nothing found is displayed try adjusting the create dates as this is important. To print hard copies of the report or navigate between pages, use the buttons in the top panel of the report view. To export the report use  the SAVE icon on the report view.";
        } else if (option == 7) {
            return "<b><mark>Order</mark></b> The Order Data Entry Form. Create-Update-Remove Orders for your oganisation. To create new orders click the NEW button in the action panel. Once the order form is filled click the save button to save the order. If the user Signed in is a ADMINSITRATOR the authorisation panel appears and the use is allowed only to authorise the bill, deletion or update is only allowed to OPERATORS (see User ADMINISTRATION module below). The user can add as many as thousand line items in the order. With each line items there is a column showing the current stock available for the line item. The column at the end would show the total of the line item and the TOTAL field on the form would reflect the total of the ORDER. To view a List or active or inactive orders, simply press the PRINT LIST  button or select the option from the Menu and on the appearing report-filter popup window click the Ok button to view the report to the screen. Printing hardcopies to shared or connected devices, exporting of the report is possible to different formats (e.g. PDf, Excel, Word.). Report layout can be changed depending on hardcopy printout requirements as shown in the image below. There is also a PRINT BILL button which enables printing of single or multiple orders at one time.";
        } else if (option == 8) {
            return "<b><mark>Order Report Filter Panel</mark></b> This produces a listing of order within your oganisation, To filter the report, sort the report apply the criteria in the window before clicking the ok button. The Help buttons with ? on the screen will display a code selection panel for Sales Person or Supplier. The report is displayed in seconds on your screen, depending on your internet connection speed. If nothing found is displayed try adjusting the create dates as this is important. To print hard copies of the report or navigate between pages, use the buttons in the top panel of the report view. To export the report use  the SAVE icon on the report view.";
        } else if (option == 9) {
            return "<b><mark>Order Bill Print Filter Panel</mark></b> This produces a Line-Item Order listing for your oganisation, To filter the report, apply the from - to criteria in the window before clicking the ok button. The Help buttons with ? on the screen will display a code selection panel allowing to select Bill Nos. The report is displayed in seconds on your screen, depending on your internet connection speed. If nothing found is displayed try adjusting the Order Nos in the selection criteria. To print hard copies of the report or navigate between pages, use the buttons in the top panel of the report view. To export the report use  the SAVE icon on the report view.";
        } else if (option == 10) {
            return "<b><mark>Invoice</mark></b> The Invoice Data Entry Form. Create-Update-Remove invoices for your oganisation. To create new orders click the NEW button in the action panel. Once the order form is filled click the save button to save the order. If the user Signed in is a ADMINSITRATOR the authorisation panel appears and the use is allowed only to authorise the bill, deletion or update is only allowed to OPERATORS (see User ADMINISTRATION module below). The user can add as many as thousand line items in the order. With each line items there is a column showing the current stock available for the line item. The column at the end would show the total of the line item and the TOTAL field on the form would reflect the total of the ORDER. To view a List or active or inactive orders, simply press the PRINT LIST  button or select the option from the Menu and on the appearing report-filter popup window click the Ok button to view the report to the screen. Printing hardcopies to shared or connected devices, exporting of the report is possible to different formats (e.g. PDf, Excel, Word.). Report layout can be changed depending on hardcopy printout requirements as shown in the image below. There is also a PRINT BILL button which enables printing of single or multiple orders at one time.";
        } else if (option == 11) {
            return "<b><mark>Invoice Report Filter Panel</mark></b> This produces a listing of invoices, To filter the report, sort the report apply the criteria in the window before clicking the ok button. The Help buttons with ? on the screen will display a code selection panel for Sales Person or Supplier. The report is displayed in seconds on your screen, depending on your internet connection speed. If nothing found is displayed try adjusting the create dates as this is important. To print hard copies of the report or navigate between pages, use the buttons in the top panel of the report view. To export the report use  the SAVE icon on the report view.";
        } else if (option == 12) {
            return "<b><mark>Invoice Bill Print Filter Panel</mark></b> This produces a Line-Item Invoice listing, To filter the report, apply the from - to criteria in the window before clicking the ok button. The Help buttons with ? on the screen will display a code selection panel allowing to select Bill Nos. The report is displayed in seconds on your screen, depending on your internet connection speed. If nothing found is displayed try adjusting the Order Nos in the selection criteria. To print hard copies of the report or navigate between pages, use the buttons in the top panel of the report view. To export the report use  the SAVE icon on the report view.";
        } else if (option == 13) {
            return "<b><mark>The Order Return Data Entry Form.<mark></b> Create-Update-Remove Orders Returned for your oganisation. To create new orders click the NEW button in the action panel. Once the order form is filled click the save button to save the order. If the user Signed in is a ADMINSITRATOR the authorisation panel appears and the use is allowed only to authorise the bill, deletion or update is only allowed to OPERATORS (see User ADMINISTRATION module below). The user can add as many as thousand line items in the order. With each line items there is a column showing the current stock available for the line item. The column at the end would show the total of the line item and the TOTAL field on the form would reflect the total of the ORDER. To view a List or active or inactive orders, simply press the PRINT LIST  button or select the option from the Menu and on the appearing report-filter popup window click the Ok button to view the report to the screen. Printing hardcopies to shared or connected devices, exporting of the report is possible to different formats (e.g. PDf, Excel, Word.). Report layout can be changed depending on hardcopy printout requirements as shown in the image below. There is also a PRINT BILL button which enables printing of single or multiple orders at one time.";
        } else if (option == 14) {
            return "<b><mark>Order Return Print Filter Panel</mark></b> This produces a Order Return listing within your oganisation, To filter the report, apply the from - to criteria in the window before clicking the ok button. The Help buttons with ? on the screen will display a code selection panel for Sales Person or Supplier. The report is displayed in seconds on your screen, depending on your internet connection speed. If nothing found is displayed try adjusting the Order Nos in the selection criteria. To print hard copies of the report or navigate between pages, use the buttons in the top panel of the report view. To export the report use  the SAVE icon on the report view.";
        } else if (option == 15) {
            return "<b><mark>Order Return Bill Print Filter Panel</mark></b> This produces a Line-Item Order Return listing, To filter the report, apply the from - to criteria in the window before clicking the ok button. The Help buttons with ? on the screen will display a code selection panel allowing to select Bill Nos. The report is displayed in seconds on your screen, depending on your internet connection speed. If nothing found is displayed try adjusting the Order Nos in the selection criteria. To print hard copies of the report or navigate between pages, use the buttons in the top panel of the report view. To export the report use  the SAVE icon on the report view.";
        } else if (option == 16) {
            return "<b><mark>Invoice Return</mark></b> The Invoice Data Entry Form. Create-Update-Remove invoices for your oganisation. To create new orders click the NEW button in the action panel. Once the order form is filled click the save button to save the order. If the user Signed in is a ADMINSITRATOR the authorisation panel appears and the use is allowed only to authorise the bill, deletion or update is only allowed to OPERATORS (see User ADMINISTRATION module below). The user can add as many as thousand line items in the order. With each line items there is a column showing the current stock available for the line item. The column at the end would show the total of the line item and the TOTAL field on the form would reflect the total of the ORDER. To view a List or active or inactive orders, simply press the PRINT LIST  button or select the option from the Menu and on the appearing report-filter popup window click the Ok button to view the report to the screen. Printing hardcopies to shared or connected devices, exporting of the report is possible to different formats (e.g. PDf, Excel, Word.). Report layout can be changed depending on hardcopy printout requirements as shown in the image below. There is also a PRINT BILL button which enables printing of single or multiple orders at one time.";
        } else if (option == 17) {
            return "<b><mark>Invoice Return Print Filter Panel<mark></b> This produces a Invoice Return listing, To filter the report, apply the from - to criteria in the window before clicking the ok button. The report is displayed in seconds on your screen, depending on your internet connection speed. If nothing found is displayed try adjusting the Order Nos in the selection criteria. To print hard copies of the report or navigate between pages, use the buttons in the top panel of the report view. To export the report use  the SAVE icon on the report view.";
        } else if (option == 18) {
            return "<b><mark>Invoice Return Bill Print Filter Panel</mark></b> This produces a Line-Item Invoice return listing, To filter the report, apply the from - to criteria in the window before clicking the ok button. The Help buttons with ? on the screen will display a code selection panel allowing to select Bill Nos. The report is displayed in seconds on your screen, depending on your internet connection speed. If nothing found is displayed try adjusting the Order Nos in the selection criteria. To print hard copies of the report or navigate between pages, use the buttons in the top panel of the report view. To export the report use  the SAVE icon on the report view.";
        } else if (option == 19) {
            return "<b><mark>User Administration</mark></b> Create-Update-Remove Users for your organisation who are required access to the elegant inventory module, assign user access rights for the various inventory modules and reports. This user could be either enabled or disabled to grant or prevent login to the elegant inventory module.";
        } else if (option == 20) {
            return "<b><mark>User Administration Report Filter Panel<mark></b> This produces a listing of User in your oganisation, To filter the report, sort the report apply the criteria in the window before clicking the ok button. The report is displayed in seconds on your screen, depending on your internet connection speed. If nothing found is displayed try adjusting the create dates as this is important. To print hard copies of the report or navigate between pages, use the buttons in the top panel of the report view. To export the report use  the SAVE icon on the report view.";
        } else if (option == 21) {
            return "<b><mark>Sample Help Screen<mark></b>This is a help screen which popups when the user presses the Help Button on any of the form or sub forms (e.g. ones used for listing and reports). The list is searchable and user could enter a string in the text box on the top of the window as in the screen to filter the code selection. To select a code user needs to click on the item in the list and then click the OK button in the panel at the bottom, which will close the popup and return the user to the previous window.";
        }

        return "";
    }

    public String[] getInvImage() {
        return invImage;
    }

    /**
     * @return the invImageAndDescrList
     */
    public ArrayList<InvImageDescVO> getInvImageAndDescrList() {
        invImageAndDescrList = new ArrayList<>();
        return invImageAndDescrList;
    }

}
