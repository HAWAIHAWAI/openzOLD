
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.ProductionOrder;





import org.openbravo.erpCommon.utility.*;
import org.openbravo.data.FieldProvider;
import org.openbravo.utils.FormatUtilities;
import org.openbravo.utils.Replace;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.base.exception.OBException;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessRunner;
import org.openbravo.erpCommon.businessUtility.WindowTabs;
import org.openbravo.xmlEngine.XmlDocument;
import java.util.Vector;
import java.util.StringTokenizer;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.Connection;
import org.apache.log4j.Logger;
import org.openz.view.*;
import org.openz.model.*;
import org.openz.controller.callouts.CalloutStructure;
import org.openz.view.Formhelper;
import org.openz.view.Scripthelper;
import org.openz.view.templates.ConfigureButton;
import org.openz.view.templates.ConfigureInfobar;
import org.openz.view.templates.ConfigurePopup;
import org.openz.view.templates.ConfigureSelectBox;
import org.openz.view.templates.ConfigureFrameWindow;
import org.openz.util.LocalizationUtils;
import org.openz.util.UtilsData;
import org.openz.controller.businessprocess.DocActionWorkflowOptions;
import org.openbravo.data.Sqlc;

public class SequencePlan2FEBB8D8B124467D85CCA469B76BEC45 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(SequencePlan2FEBB8D8B124467D85CCA469B76BEC45.class);
  
  private static final String windowId = "A2BEBB9B07564D2AAA372B4CB2D01165";
  private static final String tabId = "2FEBB8D8B124467D85CCA469B76BEC45";
  private static final String defaultTabView = "RELATION";
  private static final int accesslevel = 1;
  private static final double SUBTABS_COL_SIZE = 15;

  public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
    TableSQLData tableSQL = null;
    VariablesSecureApp vars = new VariablesSecureApp(request);
    
    Boolean saveRequest = (Boolean) request.getAttribute("autosave");
    this.setWindowId(windowId);
    this.setTabId(tabId);
    if(saveRequest != null && saveRequest){
      String currentOrg = vars.getStringParameter("inpadOrgId");
      String currentClient = vars.getStringParameter("inpadClientId");
      boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)
                            && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars,"#User_Org", windowId, accesslevel), currentOrg)) 
                            && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),currentClient)));
    
        OBError myError = new OBError();
        String commandType = request.getParameter("inpCommandType");
        String strzssmProductionorderTaskdepVId = request.getParameter("inpzssmProductionorderTaskdepVId");
         String strPZssm_ProductionOrder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_ProductionOrder_V_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strzssmProductionorderTaskdepVId.equals(""))
              total = saveRecord(vars, myError, 'U', strPZssm_ProductionOrder_V_ID);
          else
              total = saveRecord(vars, myError, 'I', strPZssm_ProductionOrder_V_ID);
          
          if (!myError.isEmpty() && total == 0)     
            throw new OBException(myError.getMessage());
        }
        vars.setSessionValue(request.getParameter("mappingName") +"|hash", vars.getPostDataHash());
        vars.setSessionValue(tabId + "|Header.view", "EDIT");
        
        return;
    }
    
    try {
      tableSQL = new TableSQLData(vars, this, tabId, Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    String strOrderBy = vars.getSessionValue(tabId + "|orderby");
    if (!strOrderBy.equals("")) {
      vars.setSessionValue(tabId + "|newOrder", "1");
    }

    if (vars.commandIn("DEFAULT")) {
      String strPZssm_ProductionOrder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_ProductionOrder_V_ID", "");

      String strZssm_Productionorder_Taskdep_V_ID = vars.getGlobalVariable("inpzssmProductionorderTaskdepVId", windowId + "|Zssm_Productionorder_Taskdep_V_ID", "");
            if (strPZssm_ProductionOrder_V_ID.equals("")) {
        strPZssm_ProductionOrder_V_ID = getParentID(vars, strZssm_Productionorder_Taskdep_V_ID);
        if (strPZssm_ProductionOrder_V_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|Zssm_ProductionOrder_V_ID");
        vars.setSessionValue(windowId + "|Zssm_ProductionOrder_V_ID", strPZssm_ProductionOrder_V_ID);

        refreshParentSession(vars, strPZssm_ProductionOrder_V_ID);
      }


      String strView = vars.getSessionValue(tabId + "|SequencePlan2FEBB8D8B124467D85CCA469B76BEC45.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strZssm_Productionorder_Taskdep_V_ID.equals("")) strZssm_Productionorder_Taskdep_V_ID = firstElement(vars, tableSQL);
          if (strZssm_Productionorder_Taskdep_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssm_Productionorder_Taskdep_V_ID, strPZssm_ProductionOrder_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strPZssm_ProductionOrder_V_ID, strZssm_Productionorder_Taskdep_V_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strZssm_Productionorder_Taskdep_V_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strZssm_Productionorder_Taskdep_V_ID.equals("")) strZssm_Productionorder_Taskdep_V_ID = vars.getRequiredGlobalVariable("inpzssmProductionorderTaskdepVId", windowId + "|Zssm_Productionorder_Taskdep_V_ID");
      else vars.setSessionValue(windowId + "|Zssm_Productionorder_Taskdep_V_ID", strZssm_Productionorder_Taskdep_V_ID);
      
      
      String strPZssm_ProductionOrder_V_ID = getParentID(vars, strZssm_Productionorder_Taskdep_V_ID);
      
      vars.setSessionValue(windowId + "|Zssm_ProductionOrder_V_ID", strPZssm_ProductionOrder_V_ID);
      vars.setSessionValue("CF6D6BC0255A47DFBD4FF6F8BEBA0C71|Production Order.view", "EDIT");

      refreshParentSession(vars, strPZssm_ProductionOrder_V_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|SequencePlan2FEBB8D8B124467D85CCA469B76BEC45.view", "EDIT");

        printPageEdit(response, request, vars, false, strZssm_Productionorder_Taskdep_V_ID, strPZssm_ProductionOrder_V_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|SequencePlan2FEBB8D8B124467D85CCA469B76BEC45.view", "RELATION");
        printPageDataSheet(response, vars, strPZssm_ProductionOrder_V_ID, strZssm_Productionorder_Taskdep_V_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPZssm_ProductionOrder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_ProductionOrder_V_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|Zssm_Productionorder_Taskdep_V_ID");
      refreshParentSession(vars, strPZssm_ProductionOrder_V_ID);


      String strView = vars.getSessionValue(tabId + "|SequencePlan2FEBB8D8B124467D85CCA469B76BEC45.view");
      String strZssm_Productionorder_Taskdep_V_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strZssm_Productionorder_Taskdep_V_ID = firstElement(vars, tableSQL);
          if (strZssm_Productionorder_Taskdep_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strZssm_Productionorder_Taskdep_V_ID.equals("")) strZssm_Productionorder_Taskdep_V_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strZssm_Productionorder_Taskdep_V_ID, strPZssm_ProductionOrder_V_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPZssm_ProductionOrder_V_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamDependsOnTask", tabId + "|paramDependsOnTask");
vars.getRequestGlobalVariable("inpParamC_Projecttask_ID", tabId + "|paramC_Projecttask_ID");
vars.getRequestGlobalVariable("inpParamStockRotation", tabId + "|paramStockRotation");

            String strPZssm_ProductionOrder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_ProductionOrder_V_ID");

      
      vars.removeSessionValue(windowId + "|Zssm_Productionorder_Taskdep_V_ID");
      String strZssm_Productionorder_Taskdep_V_ID="";

      String strView = vars.getSessionValue(tabId + "|SequencePlan2FEBB8D8B124467D85CCA469B76BEC45.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strZssm_Productionorder_Taskdep_V_ID = firstElement(vars, tableSQL);
        if (strZssm_Productionorder_Taskdep_V_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|SequencePlan2FEBB8D8B124467D85CCA469B76BEC45.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssm_Productionorder_Taskdep_V_ID, strPZssm_ProductionOrder_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strPZssm_ProductionOrder_V_ID, strZssm_Productionorder_Taskdep_V_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPZssm_ProductionOrder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_ProductionOrder_V_ID");
      

      String strZssm_Productionorder_Taskdep_V_ID = vars.getGlobalVariable("inpzssmProductionorderTaskdepVId", windowId + "|Zssm_Productionorder_Taskdep_V_ID", "");
      vars.setSessionValue(tabId + "|SequencePlan2FEBB8D8B124467D85CCA469B76BEC45.view", "RELATION");
      printPageDataSheet(response, vars, strPZssm_ProductionOrder_V_ID, strZssm_Productionorder_Taskdep_V_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPZssm_ProductionOrder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_ProductionOrder_V_ID");


      printPageEdit(response, request, vars, true, "", strPZssm_ProductionOrder_V_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPZssm_ProductionOrder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_ProductionOrder_V_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strZssm_Productionorder_Taskdep_V_ID = vars.getGlobalVariable("inpzssmProductionorderTaskdepVId", windowId + "|Zssm_Productionorder_Taskdep_V_ID", "");
      vars.setSessionValue(tabId + "|SequencePlan2FEBB8D8B124467D85CCA469B76BEC45.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strZssm_Productionorder_Taskdep_V_ID, strPZssm_ProductionOrder_V_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPZssm_ProductionOrder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_ProductionOrder_V_ID");
      String strZssm_Productionorder_Taskdep_V_ID = vars.getRequiredStringParameter("inpzssmProductionorderTaskdepVId");
      
      String strNext = nextElement(vars, strZssm_Productionorder_Taskdep_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPZssm_ProductionOrder_V_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPZssm_ProductionOrder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_ProductionOrder_V_ID");
      String strZssm_Productionorder_Taskdep_V_ID = vars.getRequiredStringParameter("inpzssmProductionorderTaskdepVId");
      
      String strPrevious = previousElement(vars, strZssm_Productionorder_Taskdep_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPZssm_ProductionOrder_V_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_ProductionOrder_V_ID");

      vars.setSessionValue(tabId + "|SequencePlan2FEBB8D8B124467D85CCA469B76BEC45.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPZssm_ProductionOrder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_ProductionOrder_V_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|SequencePlan2FEBB8D8B124467D85CCA469B76BEC45.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|SequencePlan2FEBB8D8B124467D85CCA469B76BEC45.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|SequencePlan2FEBB8D8B124467D85CCA469B76BEC45.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Zssm_Productionorder_Taskdep_V_ID");
      vars.setSessionValue(windowId + "|Zssm_ProductionOrder_V_ID", strPZssm_ProductionOrder_V_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPZssm_ProductionOrder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_ProductionOrder_V_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|SequencePlan2FEBB8D8B124467D85CCA469B76BEC45.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|SequencePlan2FEBB8D8B124467D85CCA469B76BEC45.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Zssm_Productionorder_Taskdep_V_ID");
      vars.setSessionValue(windowId + "|Zssm_ProductionOrder_V_ID", strPZssm_ProductionOrder_V_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPZssm_ProductionOrder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_ProductionOrder_V_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPZssm_ProductionOrder_V_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPZssm_ProductionOrder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_ProductionOrder_V_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPZssm_ProductionOrder_V_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPZssm_ProductionOrder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_ProductionOrder_V_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPZssm_ProductionOrder_V_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPZssm_ProductionOrder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_ProductionOrder_V_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPZssm_ProductionOrder_V_ID);      
      if (!myError.isEmpty()) {        
        response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
      } 
      else {
		if (myError.isEmpty()) {
		  myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsInserted");
		  myError.setMessage(total + " " + myError.getMessage());
		  vars.setMessage(tabId, myError);
		}        
        if (vars.commandIn("SAVE_NEW_NEW")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
        else if (vars.commandIn("SAVE_NEW_EDIT")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
    } else if (vars.commandIn("SAVE_EDIT_RELATION", "SAVE_EDIT_NEW", "SAVE_EDIT_EDIT", "SAVE_EDIT_NEXT")) {
      String strPZssm_ProductionOrder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_ProductionOrder_V_ID");
      String strZssm_Productionorder_Taskdep_V_ID = vars.getRequiredGlobalVariable("inpzssmProductionorderTaskdepVId", windowId + "|Zssm_Productionorder_Taskdep_V_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPZssm_ProductionOrder_V_ID);      
      if (!myError.isEmpty()) {
        response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
      } 
      else {
        if (myError.isEmpty()) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsUpdated");
          myError.setMessage(total + " " + myError.getMessage());
          vars.setMessage(tabId, myError);
        }
        if (vars.commandIn("SAVE_EDIT_NEW")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
        else if (vars.commandIn("SAVE_EDIT_EDIT")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        else if (vars.commandIn("SAVE_EDIT_NEXT")) {
          String strNext = nextElement(vars, strZssm_Productionorder_Taskdep_V_ID, tableSQL);
          vars.setSessionValue(windowId + "|Zssm_Productionorder_Taskdep_V_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
/*    } else if (vars.commandIn("DELETE_RELATION")) {
      String strPZssm_ProductionOrder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_ProductionOrder_V_ID");

      String strZssm_Productionorder_Taskdep_V_ID = vars.getRequiredInStringParameter("inpzssmProductionorderTaskdepVId");
      String message = deleteRelation(vars, strZssm_Productionorder_Taskdep_V_ID, strPZssm_ProductionOrder_V_ID);
      if (!message.equals("")) {
        bdError(request, response, message, vars.getLanguage());
      } else {
        vars.removeSessionValue(windowId + "|zssmProductionorderTaskdepVId");
        vars.setSessionValue(tabId + "|SequencePlan2FEBB8D8B124467D85CCA469B76BEC45.view", "RELATION");
        response.sendRedirect(strDireccion + request.getServletPath());
      }*/
    } else if (vars.commandIn("DELETE")) {
      String strPZssm_ProductionOrder_V_ID = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_ProductionOrder_V_ID");

      String strZssm_Productionorder_Taskdep_V_ID = vars.getRequiredStringParameter("inpzssmProductionorderTaskdepVId");
      //SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data data = getEditVariables(vars, strPZssm_ProductionOrder_V_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.delete(this, strZssm_Productionorder_Taskdep_V_ID, strPZssm_ProductionOrder_V_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
        } catch(ServletException ex) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          if (!myError.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myError);
        }
        if (myError==null && total==0) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
        }
        vars.removeSessionValue(windowId + "|zssmProductionorderTaskdepVId");
        vars.setSessionValue(tabId + "|SequencePlan2FEBB8D8B124467D85CCA469B76BEC45.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());








    } else if (vars.getCommand().toUpperCase().startsWith("BUTTON") || vars.getCommand().toUpperCase().startsWith("SAVE_BUTTON")) {
      pageErrorPopUp(response);
    } else pageError(response);
  }
/*
  String deleteRelation(VariablesSecureApp vars, String strZssm_Productionorder_Taskdep_V_ID, String strPZssm_ProductionOrder_V_ID) throws IOException, ServletException {
    log4j.debug("Deleting records");
    Connection conn = this.getTransactionConnection();
    try {
      if (strZssm_Productionorder_Taskdep_V_ID.startsWith("(")) strZssm_Productionorder_Taskdep_V_ID = strZssm_Productionorder_Taskdep_V_ID.substring(1, strZssm_Productionorder_Taskdep_V_ID.length()-1);
      if (!strZssm_Productionorder_Taskdep_V_ID.equals("")) {
        strZssm_Productionorder_Taskdep_V_ID = Replace.replace(strZssm_Productionorder_Taskdep_V_ID, "'", "");
        StringTokenizer st = new StringTokenizer(strZssm_Productionorder_Taskdep_V_ID, ",", false);
        while (st.hasMoreTokens()) {
          String strKey = st.nextToken();
          if (SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.deleteTransactional(conn, this, strKey, strPZssm_ProductionOrder_V_ID)==0) {
            releaseRollbackConnection(conn);
            log4j.warn("deleteRelation - key :" + strKey + " - 0 records deleted");
          }
        }
      }
      releaseCommitConnection(conn);
    } catch (ServletException e) {
      releaseRollbackConnection(conn);
      e.printStackTrace();
      log4j.error("Rollback in transaction");
      return "ProcessRunError";
    }
    return "";
  }
*/
  private SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data getEditVariables(Connection con, VariablesSecureApp vars, String strPZssm_ProductionOrder_V_ID) throws IOException,ServletException {
    SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data data = new SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data();
    ServletException ex = null;
    try {
    data.zssmProductionorderTaskdepVId = vars.getRequestGlobalVariable("inpzssmProductionorderTaskdepVId", windowId + "|Zssm_Productionorder_Taskdep_V_ID");     data.zssmProductionorderVId = vars.getStringParameter("inpzssmProductionorderVId");     data.zssmProductionorderVIdr = vars.getStringParameter("inpzssmProductionorderVId_R");     data.zspmProjecttaskdepId = vars.getStringParameter("inpzspmProjecttaskdepId");     data.isactive = vars.getStringParameter("inpisactive", "N");    try {   data.sortno = vars.getNumericParameter("inpsortno");  } catch (ServletException paramEx) { ex = paramEx; }     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.dependsontask = vars.getStringParameter("inpdependsontask");     data.dependsontaskr = vars.getStringParameter("inpdependsontask_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");     data.description = vars.getStringParameter("inpdescription");     data.stockrotation = vars.getStringParameter("inpstockrotation", "N");     data.dependentstatuscheck = vars.getStringParameter("inpdependentstatuscheck", "N"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.zssmProductionorderVId = vars.getGlobalVariable("inpzssmProductionorderVId", windowId + "|Zssm_ProductionOrder_V_ID");


    
    

    
    }
    catch(ServletException e) {
    	vars.setEditionData(tabId, data);
    	throw e;
    }
    // Behavior with exception for numeric fields is to catch last one if we have multiple ones
    if(ex != null) {
      vars.setEditionData(tabId, data);
      throw ex;
    }
    return data;
  }

   private SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[] getRelationData(SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].zssmProductionorderTaskdepVId = FormatUtilities.truncate(data[i].zssmProductionorderTaskdepVId, 32);        data[i].zssmProductionorderVId = FormatUtilities.truncate(data[i].zssmProductionorderVId, 32);        data[i].zspmProjecttaskdepId = FormatUtilities.truncate(data[i].zspmProjecttaskdepId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].dependsontask = FormatUtilities.truncate(data[i].dependsontask, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].description = FormatUtilities.truncate(data[i].description, 50);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPZssm_ProductionOrder_V_ID) throws IOException,ServletException {
      ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data[] data = ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPZssm_ProductionOrder_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].mWarehouseId);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].cCurrencyId);    vars.setSessionValue(windowId + "|IsCommitment", data[0].iscommitment);    vars.setSessionValue(windowId + "|Zssm_Productionorder_V_ID", data[0].zssmProductionorderVId);    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].cBpartnerId);    vars.setSessionValue(windowId + "|ProjectCategory", data[0].projectcategory);    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].mPricelistId);
      vars.setSessionValue(windowId + "|Zssm_ProductionOrder_V_ID", strPZssm_ProductionOrder_V_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strZssm_Productionorder_Taskdep_V_ID) throws ServletException {
    String strPZssm_ProductionOrder_V_ID = SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.selectParentID(this, strZssm_Productionorder_Taskdep_V_ID);
    if (strPZssm_ProductionOrder_V_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strZssm_Productionorder_Taskdep_V_ID);
      throw new ServletException("Parent record not found");
    }
    return strPZssm_ProductionOrder_V_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|Zssm_Productionorder_Taskdep_V_ID", data[0].getField("zssmProductionorderTaskdepVId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPZssm_ProductionOrder_V_ID) throws IOException,ServletException {
      SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[] data = SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPZssm_ProductionOrder_V_ID, vars.getStringParameter("inpzssmProductionorderTaskdepVId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
      refreshSessionEdit(vars, data);
    }

  private String nextElement(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (strSelected == null || strSelected.equals("")) return firstElement(vars, tableSQL);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(), 0, 0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.NEXT, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting next element", e);
      }
      if (data!=null) {
        if (data!=null) return data;
      }
    }
    return strSelected;
  }

  private int getKeyPosition(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("getKeyPosition: " + strSelected);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.GETPOSITION, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting key position", e);
      }
      if (data!=null) {
        // split offset -> (page,relativeOffset)
        int absoluteOffset = Integer.valueOf(data);
        int page = absoluteOffset / TableSQLData.maxRowsPerGridPage;
        int relativeOffset = absoluteOffset % TableSQLData.maxRowsPerGridPage;
        log4j.debug("getKeyPosition: absOffset: " + absoluteOffset + "=> page: " + page + " relOffset: " + relativeOffset);
        String currPageKey = tabId + "|" + "currentPage";
        vars.setSessionValue(currPageKey, String.valueOf(page));
        return relativeOffset;
      }
    }
    return 0;
  }

  private String previousElement(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (strSelected == null || strSelected.equals("")) return firstElement(vars, tableSQL);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.PREVIOUS, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting previous element", e);
      }
      if (data!=null) {
        return data;
      }
    }
    return strSelected;
  }

  private String firstElement(VariablesSecureApp vars, TableSQLData tableSQL) throws IOException, ServletException {
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,1);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.FIRST, "", tableSQL.getKeyColumn());

      } catch (Exception e) { 
        log4j.debug("Error getting first element", e);
      }
      if (data!=null) return data;
    }
    return "";
  }

  private String lastElement(VariablesSecureApp vars, TableSQLData tableSQL) throws IOException, ServletException {
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.LAST, "", tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting last element", e);
      }
      if (data!=null) return data;
    }
    return "";
  }

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPZssm_ProductionOrder_V_ID, String strZssm_Productionorder_Taskdep_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamDependsOnTask = vars.getSessionValue(tabId + "|paramDependsOnTask");
String strParamC_Projecttask_ID = vars.getSessionValue(tabId + "|paramC_Projecttask_ID");
String strParamStockRotation = vars.getSessionValue(tabId + "|paramStockRotation");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    if (!(strParamDependsOnTask.equals("") && strParamC_Projecttask_ID.equals("") && strParamStockRotation.equals(""))) hasSearchCondition=true;
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strZssm_Productionorder_Taskdep_V_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strZssm_Productionorder_Taskdep_V_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/serprod/ProductionOrder/SequencePlan2FEBB8D8B124467D85CCA469B76BEC45_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "SequencePlan2FEBB8D8B124467D85CCA469B76BEC45", false, "document.frmMain.inpzssmProductionorderTaskdepVId", "grid", "..", "".equals("Y"), "ProductionOrder", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPZssm_ProductionOrder_V_ID);

    StringBuffer orderByArray = new StringBuffer();
      vars.setSessionValue(tabId + "|newOrder", "1");
      String positions = vars.getSessionValue(tabId + "|orderbyPositions");
      orderByArray.append("var orderByPositions = new Array(\n");
      if (!positions.equals("")) {
        StringTokenizer tokens=new StringTokenizer(positions, ",");
        boolean firstOrder = true;
        while(tokens.hasMoreTokens()){
          if (!firstOrder) orderByArray.append(",\n");
          orderByArray.append("\"").append(tokens.nextToken()).append("\"");
          firstOrder = false;
        }
      }
      orderByArray.append(");\n");
      String directions = vars.getSessionValue(tabId + "|orderbyDirections");
      orderByArray.append("var orderByDirections = new Array(\n");
      if (!positions.equals("")) {
        StringTokenizer tokens=new StringTokenizer(directions, ",");
        boolean firstOrder = true;
        while(tokens.hasMoreTokens()){
          if (!firstOrder) orderByArray.append(",\n");
          orderByArray.append("\"").append(tokens.nextToken()).append("\"");
          firstOrder = false;
        }
      }
      orderByArray.append(");\n");
//    }

    xmlDocument.setParameter("selectedColumn", "\nvar selectedRow = " + selectedRow + ";\n" + orderByArray.toString());
    xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
    xmlDocument.setParameter("windowId", windowId);
    xmlDocument.setParameter("KeyName", "zssmProductionorderTaskdepVId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "SequencePlan2FEBB8D8B124467D85CCA469B76BEC45_Relation.html", "ProductionOrder", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "SequencePlan2FEBB8D8B124467D85CCA469B76BEC45_Relation.html", strReplaceWith);
      xmlDocument.setParameter("leftTabs", lBar.relationTemplate());
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
    {
      OBError myMessage = vars.getMessage(tabId);
      vars.removeMessage(tabId);
      if (myMessage!=null) {
        xmlDocument.setParameter("messageType", myMessage.getType());
        xmlDocument.setParameter("messageTitle", myMessage.getTitle());
        xmlDocument.setParameter("messageMessage", myMessage.getMessage());
      }
    }
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.selectParent(this, strPZssm_ProductionOrder_V_ID));
    else xmlDocument.setParameter("parent", SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.selectParentTrl(this, strPZssm_ProductionOrder_V_ID));

    xmlDocument.setParameter("grid", Utility.getContext(this, vars, "#RecordRange", windowId));
xmlDocument.setParameter("grid_Offset", strOffset);
xmlDocument.setParameter("grid_SortCols", positions);
xmlDocument.setParameter("grid_SortDirs", directions);
xmlDocument.setParameter("grid_Default", selectedRow);


    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strZssm_Productionorder_Taskdep_V_ID, String strPZssm_ProductionOrder_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " zssm_productionorder_taskdep_v.sortno";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamDependsOnTask = vars.getSessionValue(tabId + "|paramDependsOnTask");
String strParamC_Projecttask_ID = vars.getSessionValue(tabId + "|paramC_Projecttask_ID");
String strParamStockRotation = vars.getSessionValue(tabId + "|paramStockRotation");

    boolean hasSearchCondition=false;
    if (!(strParamDependsOnTask.equals("") && strParamC_Projecttask_ID.equals("") && strParamStockRotation.equals(""))) hasSearchCondition=true;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPZssm_ProductionOrder_V_ID, strZssm_Productionorder_Taskdep_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strZssm_Productionorder_Taskdep_V_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("zssmProductionorderTaskdepVId") == null || dataField.getField("zssmProductionorderTaskdepVId").equals("")) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        boolNew = true;
      } else {
        discard[0] = new String ("newDiscard");
        strCommand = "EDIT";
      }
    }
    
    
    
    if (dataField==null) {
      if (boolNew || data==null || data.length==0) {
        refreshSessionNew(vars, strPZssm_ProductionOrder_V_ID);
        data = SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.set(strPZssm_ProductionOrder_V_ID, Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "A2BEBB9B07564D2AAA372B4CB2D01165", "2FEBB8D8B124467D85CCA469B76BEC45", "", dataField), Utility.getDefault(this, vars, "DependentStatusCheck", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "2FEBB8D8B124467D85CCA469B76BEC45", "N", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "A2BEBB9B07564D2AAA372B4CB2D01165", "2FEBB8D8B124467D85CCA469B76BEC45", "", dataField), "", "Y", Utility.getDefault(this, vars, "Updatedby", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "2FEBB8D8B124467D85CCA469B76BEC45", "", dataField), SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.selectDef2A8B0CA9880E41CA9DA0A849E8FC55C3_0(this, Utility.getDefault(this, vars, "Updatedby", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "2FEBB8D8B124467D85CCA469B76BEC45", "", dataField)), Utility.getDefault(this, vars, "Createdby", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "2FEBB8D8B124467D85CCA469B76BEC45", "", dataField), SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.selectDefC1218B169193460985C60C8E591DFA81_1(this, Utility.getDefault(this, vars, "Createdby", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "2FEBB8D8B124467D85CCA469B76BEC45", "", dataField)), Utility.getDefault(this, vars, "Zspm_Projecttaskdep_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "2FEBB8D8B124467D85CCA469B76BEC45", "", dataField), Utility.getDefault(this, vars, "DependsOnTask", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "2FEBB8D8B124467D85CCA469B76BEC45", "", dataField), Utility.getDefault(this, vars, "StockRotation", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "2FEBB8D8B124467D85CCA469B76BEC45", "N", dataField), Utility.getDefault(this, vars, "Description", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "2FEBB8D8B124467D85CCA469B76BEC45", "", dataField), Utility.getDefault(this, vars, "C_Projecttask_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "2FEBB8D8B124467D85CCA469B76BEC45", "", dataField), Utility.getDefault(this, vars, "SortNo", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "2FEBB8D8B124467D85CCA469B76BEC45", "", dataField));
        
      }
    } else {
      data = new SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71Data.selectOrg(this, strPZssm_ProductionOrder_V_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "SequencePlan2FEBB8D8B124467D85CCA469B76BEC45", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpzssmProductionorderTaskdepVId", "", "..", "".equals("Y"), "ProductionOrder", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strZssm_Productionorder_Taskdep_V_ID));
    toolbar.prepareEditionTemplate("N".equals("Y"), hasSearchCondition, vars.getSessionValue("#ShowTest", "N").equals("Y"), "STD", Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    
  // set updated timestamp to manage locking mechanism
    String updatedTimestamp="";
    if (!boolNew) {
      updatedTimestamp=(dataField != null ? dataField.getField("updatedTimeStamp") : data[0].getField("updatedTimeStamp"));
    }
    this.setUpdatedtimestamp(updatedTimestamp);
   // this.setOrgparent(currentPOrg);
    this.setCommandtype(strCommand);
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, true, (strCommand.equalsIgnoreCase("NEW")));
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter output = response.getWriter();
      
      Connection conn = null;
      Scripthelper script = new Scripthelper();
      if (boolNew) 
        script.addHiddenfieldWithID("newdatasetindicator", "NEW");
      else
        script.addHiddenfieldWithID("newdatasetindicator", "");
      script.addHiddenfieldWithID("enabledautosave", "Y");
      script.addMessage(this, vars, vars.getMessage(tabId));
      Formhelper fh=new Formhelper();
      String strLeftabsmode="EDIT";
      String focus=fh.TabGetFirstFocusField(this,tabId);
      String strSkeleton = ConfigureFrameWindow.doConfigureWindowMode(this,vars,Sqlc.TransformaNombreColumna(focus),tabs.breadcrumb(), "Form Window",null,strLeftabsmode,tabs,"_Relation",toolbar.toString());
      String strTableStructure="";
      if (editableTab||tabId.equalsIgnoreCase("800026"))
        strTableStructure=fh.prepareTabFields(this, vars, script, tabId,data[0], Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
      else
        strTableStructure=fh.prepareTabFieldsRO(this, vars, script, tabId,data[0], Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
      strSkeleton=Replace.replace(strSkeleton, "@CONTENT@", strTableStructure );  
      strSkeleton = script.doScript(strSkeleton, "",this,vars);
      output.println(strSkeleton);
      vars.removeMessage(tabId);
      output.close();
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
  }

  void printPageButtonFS(HttpServletResponse response, VariablesSecureApp vars, String strProcessId, String path) throws IOException, ServletException {
    log4j.debug("Output: Frames action button");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate(
        "org/openbravo/erpCommon/ad_actionButton/ActionButtonDefaultFrames").createXmlDocument();
    xmlDocument.setParameter("processId", strProcessId);
    xmlDocument.setParameter("trlFormType", "PROCESS");
    xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
    xmlDocument.setParameter("type", strDireccion + path);
    out.println(xmlDocument.print());
    out.close();
  }
  






    private String getDisplayLogicContext(VariablesSecureApp vars, boolean isNew) throws IOException, ServletException {
      log4j.debug("Output: Display logic context fields");
      String result = "var strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\n";
      return result;
    }


    private String getReadOnlyLogicContext(VariablesSecureApp vars) throws IOException, ServletException {
      log4j.debug("Output: Read Only logic context fields");
      String result = "";
      return result;
    }




 
  private String getShortcutScript( HashMap<String, String> usedButtonShortCuts){
    StringBuffer shortcuts = new StringBuffer();
    shortcuts.append(" function buttonListShorcuts() {\n");
    Iterator<String> ik = usedButtonShortCuts.keySet().iterator();
    Iterator<String> iv = usedButtonShortCuts.values().iterator();
    while(ik.hasNext() && iv.hasNext()){
      shortcuts.append("  keyArray[keyArray.length] = new keyArrayItem(\"").append(ik.next()).append("\", \"").append(iv.next()).append("\", null, \"altKey\", false, \"onkeydown\");\n");
    }
    shortcuts.append(" return true;\n}");
    return shortcuts.toString();
  }
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPZssm_ProductionOrder_V_ID) throws IOException, ServletException {
    SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data data = null;
    int total = 0;
    if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        OBError newError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        myError.setError(newError);
        vars.setMessage(tabId, myError);
    }
    else {
        Connection con = null;
        try {
            con = this.getTransactionConnection();
            data = getEditVariables(con, vars, strPZssm_ProductionOrder_V_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.zssmProductionorderTaskdepVId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (SequencePlan2FEBB8D8B124467D85CCA469B76BEC45Data.getCurrentDBTimestamp(this, data.zssmProductionorderTaskdepVId).equals(
                vars.getStringParameter("updatedTimestamp"))) {
                total = data.update(con, this);
               } else {
                 myError.setMessage(Replace.replace(Replace.replace(Utility.messageBD(this,
                    "SavingModifiedRecord", vars.getLanguage()), "\\n", "<br/>"), "&quot;", "\""));
                 myError.setType("Error");
                 vars.setSessionValue(tabId + "|concurrentSave", "true");
               } 
		     }		            
          
            }
                else {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
            myError.setError(newError);            
          }
          releaseCommitConnection(con);
          CrudOperations.UpdateCustomFields(tabId, data.zssmProductionorderTaskdepVId, vars, this);
        } catch(Exception ex) {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
            myError.setError(newError);   
            try {
              releaseRollbackConnection(con);
            } catch (final Exception e) { //do nothing 
            }           
        }
            
        if (myError.isEmpty() && total == 0) {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=DBExecuteError");
            myError.setError(newError);
        }
        vars.setMessage(tabId, myError);
            
        if(!myError.isEmpty()){
            if(data != null ) {
                if(type == 'I') {            			
                    data.zssmProductionorderTaskdepVId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Zssm_Productionorder_Taskdep_V_ID", data.zssmProductionorderTaskdepVId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet SequencePlan2FEBB8D8B124467D85CCA469B76BEC45. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}