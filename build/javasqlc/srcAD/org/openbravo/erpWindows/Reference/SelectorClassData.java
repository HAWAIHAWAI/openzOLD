//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Reference;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

/**
WAD Generated class
 */
class SelectorClassData implements FieldProvider {
static Logger log4j = Logger.getLogger(SelectorClassData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adModelObjectId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String adReferenceId;
  public String adReferenceIdr;
  public String classname;
  public String isdefault;
  public String action;
  public String adTabId;
  public String adTaskId;
  public String adWorkflowId;
  public String adProcessId;
  public String adFormId;
  public String adCalloutId;
  public String language;
  public String adUserClient;
  public String adOrgClient;
  public String createdby;
  public String trBgcolor;
  public String totalCount;
  public String dateTimeFormat;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdbyr"))
      return createdbyr;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updated_time_stamp") || fieldName.equals("updatedTimeStamp"))
      return updatedTimeStamp;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("updatedbyr"))
      return updatedbyr;
    else if (fieldName.equalsIgnoreCase("ad_model_object_id") || fieldName.equals("adModelObjectId"))
      return adModelObjectId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_reference_id") || fieldName.equals("adReferenceId"))
      return adReferenceId;
    else if (fieldName.equalsIgnoreCase("ad_reference_idr") || fieldName.equals("adReferenceIdr"))
      return adReferenceIdr;
    else if (fieldName.equalsIgnoreCase("classname"))
      return classname;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("action"))
      return action;
    else if (fieldName.equalsIgnoreCase("ad_tab_id") || fieldName.equals("adTabId"))
      return adTabId;
    else if (fieldName.equalsIgnoreCase("ad_task_id") || fieldName.equals("adTaskId"))
      return adTaskId;
    else if (fieldName.equalsIgnoreCase("ad_workflow_id") || fieldName.equals("adWorkflowId"))
      return adWorkflowId;
    else if (fieldName.equalsIgnoreCase("ad_process_id") || fieldName.equals("adProcessId"))
      return adProcessId;
    else if (fieldName.equalsIgnoreCase("ad_form_id") || fieldName.equals("adFormId"))
      return adFormId;
    else if (fieldName.equalsIgnoreCase("ad_callout_id") || fieldName.equals("adCalloutId"))
      return adCalloutId;
    else if (fieldName.equalsIgnoreCase("language"))
      return language;
    else if (fieldName.equals("adUserClient"))
      return adUserClient;
    else if (fieldName.equals("adOrgClient"))
      return adOrgClient;
    else if (fieldName.equals("createdby"))
      return createdby;
    else if (fieldName.equals("trBgcolor"))
      return trBgcolor;
    else if (fieldName.equals("totalCount"))
      return totalCount;
    else if (fieldName.equals("dateTimeFormat"))
      return dateTimeFormat;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for edit
 */
  public static SelectorClassData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adReferenceId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adReferenceId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static SelectorClassData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adReferenceId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Model_Object.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Model_Object.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Model_Object.Updated, ?) as updated, " +
      "        to_char(AD_Model_Object.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Model_Object.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Model_Object.UpdatedBy) as UpdatedByR," +
      "        AD_Model_Object.AD_Model_Object_ID, " +
      "AD_Model_Object.AD_Client_ID, " +
      "(CASE WHEN AD_Model_Object.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_Model_Object.AD_Org_ID, " +
      "(CASE WHEN AD_Model_Object.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(AD_Model_Object.IsActive, 'N') AS IsActive, " +
      "AD_Model_Object.AD_Reference_ID, " +
      "(CASE WHEN AD_Model_Object.AD_Reference_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(list1.name),'') ) END) AS AD_Reference_IDR, " +
      "AD_Model_Object.Classname, " +
      "COALESCE(AD_Model_Object.IsDefault, 'N') AS IsDefault, " +
      "AD_Model_Object.Action, " +
      "AD_Model_Object.AD_Tab_ID, " +
      "AD_Model_Object.AD_Task_ID, " +
      "AD_Model_Object.AD_Workflow_ID, " +
      "AD_Model_Object.AD_Process_ID, " +
      "AD_Model_Object.AD_Form_ID, " +
      "AD_Model_Object.AD_Callout_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Model_Object left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_Model_Object.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_Model_Object.AD_Org_ID = table2.AD_Org_ID) left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table3 on (AD_Model_Object.AD_Reference_ID = table3.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL3 on (table3.AD_Reference_ID = tableTRL3.AD_Reference_ID and tableTRL3.AD_Language = ?)  left join ad_ref_list_v list1 on (table3.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adReferenceId==null || adReferenceId.equals(""))?"":"  AND AD_Model_Object.AD_Reference_ID = ?  ");
    strSql = strSql + 
      "        AND AD_Model_Object.AD_Model_Object_ID = ? " +
      "        AND AD_Model_Object.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Model_Object.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (adReferenceId != null && !(adReferenceId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        SelectorClassData objectSelectorClassData = new SelectorClassData();
        objectSelectorClassData.created = UtilSql.getValue(result, "created");
        objectSelectorClassData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectSelectorClassData.updated = UtilSql.getValue(result, "updated");
        objectSelectorClassData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectSelectorClassData.updatedby = UtilSql.getValue(result, "updatedby");
        objectSelectorClassData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectSelectorClassData.adModelObjectId = UtilSql.getValue(result, "ad_model_object_id");
        objectSelectorClassData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSelectorClassData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectSelectorClassData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSelectorClassData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectSelectorClassData.isactive = UtilSql.getValue(result, "isactive");
        objectSelectorClassData.adReferenceId = UtilSql.getValue(result, "ad_reference_id");
        objectSelectorClassData.adReferenceIdr = UtilSql.getValue(result, "ad_reference_idr");
        objectSelectorClassData.classname = UtilSql.getValue(result, "classname");
        objectSelectorClassData.isdefault = UtilSql.getValue(result, "isdefault");
        objectSelectorClassData.action = UtilSql.getValue(result, "action");
        objectSelectorClassData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectSelectorClassData.adTaskId = UtilSql.getValue(result, "ad_task_id");
        objectSelectorClassData.adWorkflowId = UtilSql.getValue(result, "ad_workflow_id");
        objectSelectorClassData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectSelectorClassData.adFormId = UtilSql.getValue(result, "ad_form_id");
        objectSelectorClassData.adCalloutId = UtilSql.getValue(result, "ad_callout_id");
        objectSelectorClassData.language = UtilSql.getValue(result, "language");
        objectSelectorClassData.adUserClient = "";
        objectSelectorClassData.adOrgClient = "";
        objectSelectorClassData.createdby = "";
        objectSelectorClassData.trBgcolor = "";
        objectSelectorClassData.totalCount = "";
        objectSelectorClassData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSelectorClassData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    SelectorClassData objectSelectorClassData[] = new SelectorClassData[vector.size()];
    vector.copyInto(objectSelectorClassData);
    return(objectSelectorClassData);
  }

/**
Create a registry
 */
  public static SelectorClassData[] set(String adReferenceId, String adTaskId, String adProcessId, String createdby, String createdbyr, String action, String adTabId, String adWorkflowId, String adFormId, String isactive, String isdefault, String adCalloutId, String classname, String adModelObjectId, String adOrgId, String adClientId, String updatedby, String updatedbyr)    throws ServletException {
    SelectorClassData objectSelectorClassData[] = new SelectorClassData[1];
    objectSelectorClassData[0] = new SelectorClassData();
    objectSelectorClassData[0].created = "";
    objectSelectorClassData[0].createdbyr = createdbyr;
    objectSelectorClassData[0].updated = "";
    objectSelectorClassData[0].updatedTimeStamp = "";
    objectSelectorClassData[0].updatedby = updatedby;
    objectSelectorClassData[0].updatedbyr = updatedbyr;
    objectSelectorClassData[0].adModelObjectId = adModelObjectId;
    objectSelectorClassData[0].adClientId = adClientId;
    objectSelectorClassData[0].adClientIdr = "";
    objectSelectorClassData[0].adOrgId = adOrgId;
    objectSelectorClassData[0].adOrgIdr = "";
    objectSelectorClassData[0].isactive = isactive;
    objectSelectorClassData[0].adReferenceId = adReferenceId;
    objectSelectorClassData[0].adReferenceIdr = "";
    objectSelectorClassData[0].classname = classname;
    objectSelectorClassData[0].isdefault = isdefault;
    objectSelectorClassData[0].action = action;
    objectSelectorClassData[0].adTabId = adTabId;
    objectSelectorClassData[0].adTaskId = adTaskId;
    objectSelectorClassData[0].adWorkflowId = adWorkflowId;
    objectSelectorClassData[0].adProcessId = adProcessId;
    objectSelectorClassData[0].adFormId = adFormId;
    objectSelectorClassData[0].adCalloutId = adCalloutId;
    objectSelectorClassData[0].language = "";
    return objectSelectorClassData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef802450_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Createdby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedbyR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "createdby");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDef802453(ConnectionProvider connectionProvider, String IsReport, String IsJasper)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (CASE WHEN ?='Y' OR ?='Y' THEN 'R' ELSE 'P' END) FROM DUAL ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IsReport);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IsJasper);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "case");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDef802452_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Updatedby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedbyR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updatedby");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_Model_Object.AD_Reference_ID AS NAME" +
      "        FROM AD_Model_Object" +
      "        WHERE AD_Model_Object.AD_Model_Object_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for parent field
 */
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String adReferenceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), '')) || ' - ' || list1.name) AS NAME FROM AD_Reference left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table1 on (AD_Reference.AD_Reference_ID = table1.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL1 on (table1.AD_Reference_ID = tableTRL1.AD_Reference_ID and tableTRL1.AD_Language = ?)  left join ad_ref_list_v list1 on (table1.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?)  WHERE AD_Reference.AD_Reference_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for parent field
 */
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String adReferenceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), '')) || ' - ' || list1.name) AS NAME FROM AD_Reference left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table1 on (AD_Reference.AD_Reference_ID = table1.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL1 on (table1.AD_Reference_ID = tableTRL1.AD_Reference_ID and tableTRL1.AD_Language = ?)  left join ad_ref_list_v list1 on (table1.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?)  WHERE AD_Reference.AD_Reference_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_Model_Object" +
      "        SET AD_Model_Object_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , IsActive = (?) , AD_Reference_ID = (?) , Classname = (?) , IsDefault = (?) , Action = (?) , AD_Tab_ID = (?) , AD_Task_ID = (?) , AD_Workflow_ID = (?) , AD_Process_ID = (?) , AD_Form_ID = (?) , AD_Callout_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Model_Object.AD_Model_Object_ID = ? " +
      "                 AND AD_Model_Object.AD_Reference_ID = ? " +
      "        AND AD_Model_Object.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Model_Object.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModelObjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, classname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, action);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWorkflowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFormId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adCalloutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModelObjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public int insert(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO AD_Model_Object " +
      "        (AD_Model_Object_ID, AD_Client_ID, AD_Org_ID, IsActive, AD_Reference_ID, Classname, IsDefault, Action, AD_Tab_ID, AD_Task_ID, AD_Workflow_ID, AD_Process_ID, AD_Form_ID, AD_Callout_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModelObjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, classname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, action);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWorkflowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFormId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adCalloutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int delete(ConnectionProvider connectionProvider, String param1, String adReferenceId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Model_Object" +
      "        WHERE AD_Model_Object.AD_Model_Object_ID = ? " +
      "                 AND AD_Model_Object.AD_Reference_ID = ? " +
      "        AND AD_Model_Object.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Model_Object.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adReferenceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Model_Object" +
      "        WHERE AD_Model_Object.AD_Model_Object_ID = ? " +
      "                 AND AD_Model_Object.AD_Reference_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

/**
Select for relation
 */
  public static String selectOrg(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_ID" +
      "          FROM AD_Model_Object" +
      "         WHERE AD_Model_Object.AD_Model_Object_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_org_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String getCurrentDBTimestamp(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp" +
      "          FROM AD_Model_Object" +
      "         WHERE AD_Model_Object.AD_Model_Object_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updated_time_stamp");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }
}
