//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.WindowsTabsandFields;

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
class TabTranslationInstanceSpecificData implements FieldProvider {
static Logger log4j = Logger.getLogger(TabTranslationInstanceSpecificData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adTabTrlInstanceId;
  public String adTabId;
  public String adTabIdr;
  public String adLanguage;
  public String adLanguager;
  public String name;
  public String adClientId;
  public String isactive;
  public String adOrgId;
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
    else if (fieldName.equalsIgnoreCase("ad_tab_trl_instance_id") || fieldName.equals("adTabTrlInstanceId"))
      return adTabTrlInstanceId;
    else if (fieldName.equalsIgnoreCase("ad_tab_id") || fieldName.equals("adTabId"))
      return adTabId;
    else if (fieldName.equalsIgnoreCase("ad_tab_idr") || fieldName.equals("adTabIdr"))
      return adTabIdr;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("ad_languager") || fieldName.equals("adLanguager"))
      return adLanguager;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
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
  public static TabTranslationInstanceSpecificData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adTabId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adTabId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static TabTranslationInstanceSpecificData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adTabId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_tab_trl_instance.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_tab_trl_instance.CreatedBy) as CreatedByR, " +
      "        to_char(ad_tab_trl_instance.Updated, ?) as updated, " +
      "        to_char(ad_tab_trl_instance.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_tab_trl_instance.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_tab_trl_instance.UpdatedBy) as UpdatedByR," +
      "        ad_tab_trl_instance.AD_Tab_Trl_Instance_ID, " +
      "ad_tab_trl_instance.AD_Tab_ID, " +
      "(CASE WHEN ad_tab_trl_instance.AD_Tab_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS AD_Tab_IDR, " +
      "ad_tab_trl_instance.AD_Language, " +
      "(CASE WHEN ad_tab_trl_instance.AD_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_LanguageR, " +
      "ad_tab_trl_instance.Name, " +
      "ad_tab_trl_instance.AD_Client_ID, " +
      "COALESCE(ad_tab_trl_instance.Isactive, 'N') AS Isactive, " +
      "ad_tab_trl_instance.AD_Org_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_tab_trl_instance left join (select AD_Tab_ID, Name, AD_Window_ID from AD_Tab) table1 on (ad_tab_trl_instance.AD_Tab_ID = table1.AD_Tab_ID) left join (select AD_Tab_ID,AD_Language, Name from AD_Tab_TRL) tableTRL1 on (table1.AD_Tab_ID = tableTRL1.AD_Tab_ID and tableTRL1.AD_Language = ?)  left join (select AD_Window_ID, Name from AD_Window) table2 on (table1.AD_Window_ID = table2.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL2 on (table2.AD_Window_ID = tableTRL2.AD_Window_ID and tableTRL2.AD_Language = ?)  left join (select AD_Language, Name from AD_Language) table3 on (ad_tab_trl_instance.AD_Language =  table3.AD_Language)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adTabId==null || adTabId.equals(""))?"":"  AND ad_tab_trl_instance.AD_Tab_ID = ?  ");
    strSql = strSql + 
      "        AND ad_tab_trl_instance.AD_Tab_Trl_Instance_ID = ? " +
      "        AND ad_tab_trl_instance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_tab_trl_instance.AD_Org_ID IN (";
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
      if (adTabId != null && !(adTabId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
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
        TabTranslationInstanceSpecificData objectTabTranslationInstanceSpecificData = new TabTranslationInstanceSpecificData();
        objectTabTranslationInstanceSpecificData.created = UtilSql.getValue(result, "created");
        objectTabTranslationInstanceSpecificData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTabTranslationInstanceSpecificData.updated = UtilSql.getValue(result, "updated");
        objectTabTranslationInstanceSpecificData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTabTranslationInstanceSpecificData.updatedby = UtilSql.getValue(result, "updatedby");
        objectTabTranslationInstanceSpecificData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTabTranslationInstanceSpecificData.adTabTrlInstanceId = UtilSql.getValue(result, "ad_tab_trl_instance_id");
        objectTabTranslationInstanceSpecificData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectTabTranslationInstanceSpecificData.adTabIdr = UtilSql.getValue(result, "ad_tab_idr");
        objectTabTranslationInstanceSpecificData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectTabTranslationInstanceSpecificData.adLanguager = UtilSql.getValue(result, "ad_languager");
        objectTabTranslationInstanceSpecificData.name = UtilSql.getValue(result, "name");
        objectTabTranslationInstanceSpecificData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTabTranslationInstanceSpecificData.isactive = UtilSql.getValue(result, "isactive");
        objectTabTranslationInstanceSpecificData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTabTranslationInstanceSpecificData.language = UtilSql.getValue(result, "language");
        objectTabTranslationInstanceSpecificData.adUserClient = "";
        objectTabTranslationInstanceSpecificData.adOrgClient = "";
        objectTabTranslationInstanceSpecificData.createdby = "";
        objectTabTranslationInstanceSpecificData.trBgcolor = "";
        objectTabTranslationInstanceSpecificData.totalCount = "";
        objectTabTranslationInstanceSpecificData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTabTranslationInstanceSpecificData);
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
    TabTranslationInstanceSpecificData objectTabTranslationInstanceSpecificData[] = new TabTranslationInstanceSpecificData[vector.size()];
    vector.copyInto(objectTabTranslationInstanceSpecificData);
    return(objectTabTranslationInstanceSpecificData);
  }

/**
Create a registry
 */
  public static TabTranslationInstanceSpecificData[] set(String adTabId, String adTabTrlInstanceId, String adClientId, String name, String adLanguage, String updatedby, String updatedbyr, String createdby, String createdbyr, String isactive, String adOrgId)    throws ServletException {
    TabTranslationInstanceSpecificData objectTabTranslationInstanceSpecificData[] = new TabTranslationInstanceSpecificData[1];
    objectTabTranslationInstanceSpecificData[0] = new TabTranslationInstanceSpecificData();
    objectTabTranslationInstanceSpecificData[0].created = "";
    objectTabTranslationInstanceSpecificData[0].createdbyr = createdbyr;
    objectTabTranslationInstanceSpecificData[0].updated = "";
    objectTabTranslationInstanceSpecificData[0].updatedTimeStamp = "";
    objectTabTranslationInstanceSpecificData[0].updatedby = updatedby;
    objectTabTranslationInstanceSpecificData[0].updatedbyr = updatedbyr;
    objectTabTranslationInstanceSpecificData[0].adTabTrlInstanceId = adTabTrlInstanceId;
    objectTabTranslationInstanceSpecificData[0].adTabId = adTabId;
    objectTabTranslationInstanceSpecificData[0].adTabIdr = "";
    objectTabTranslationInstanceSpecificData[0].adLanguage = adLanguage;
    objectTabTranslationInstanceSpecificData[0].adLanguager = "";
    objectTabTranslationInstanceSpecificData[0].name = name;
    objectTabTranslationInstanceSpecificData[0].adClientId = adClientId;
    objectTabTranslationInstanceSpecificData[0].isactive = isactive;
    objectTabTranslationInstanceSpecificData[0].adOrgId = adOrgId;
    objectTabTranslationInstanceSpecificData[0].language = "";
    return objectTabTranslationInstanceSpecificData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefC5B0AC894BD2481080C5279608D5128C_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
Select for auxiliar field
 */
  public static String selectDef71634F788E374AEA918DFA0EDD3BCD97_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ad_tab_trl_instance.AD_Tab_ID AS NAME" +
      "        FROM ad_tab_trl_instance" +
      "        WHERE ad_tab_trl_instance.AD_Tab_Trl_Instance_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))) AS NAME FROM AD_Tab left join (select AD_Tab_ID, Name, AD_Window_ID from AD_Tab) table1 on (AD_Tab.AD_Tab_ID = table1.AD_Tab_ID) left join (select AD_Tab_ID,AD_Language, Name from AD_Tab_TRL) tableTRL1 on (table1.AD_Tab_ID = tableTRL1.AD_Tab_ID and tableTRL1.AD_Language = ?)  left join (select AD_Window_ID, Name from AD_Window) table2 on (table1.AD_Window_ID = table2.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL2 on (table2.AD_Window_ID = tableTRL2.AD_Window_ID and tableTRL2.AD_Language = ?)  WHERE AD_Tab.AD_Tab_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))) AS NAME FROM AD_Tab left join (select AD_Tab_ID, Name, AD_Window_ID from AD_Tab) table1 on (AD_Tab.AD_Tab_ID = table1.AD_Tab_ID) left join (select AD_Tab_ID,AD_Language, Name from AD_Tab_TRL) tableTRL1 on (table1.AD_Tab_ID = tableTRL1.AD_Tab_ID and tableTRL1.AD_Language = ?)  left join (select AD_Window_ID, Name from AD_Window) table2 on (table1.AD_Window_ID = table2.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL2 on (table2.AD_Window_ID = tableTRL2.AD_Window_ID and tableTRL2.AD_Language = ?)  WHERE AD_Tab.AD_Tab_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

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
      "        UPDATE ad_tab_trl_instance" +
      "        SET AD_Tab_Trl_Instance_ID = (?) , AD_Tab_ID = (?) , AD_Language = (?) , Name = (?) , AD_Client_ID = (?) , Isactive = (?) , AD_Org_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_tab_trl_instance.AD_Tab_Trl_Instance_ID = ? " +
      "                 AND ad_tab_trl_instance.AD_Tab_ID = ? " +
      "        AND ad_tab_trl_instance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_tab_trl_instance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabTrlInstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabTrlInstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
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
      "        INSERT INTO ad_tab_trl_instance " +
      "        (AD_Tab_Trl_Instance_ID, AD_Tab_ID, AD_Language, Name, AD_Client_ID, Isactive, AD_Org_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabTrlInstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adTabId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_tab_trl_instance" +
      "        WHERE ad_tab_trl_instance.AD_Tab_Trl_Instance_ID = ? " +
      "                 AND ad_tab_trl_instance.AD_Tab_ID = ? " +
      "        AND ad_tab_trl_instance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_tab_trl_instance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_tab_trl_instance" +
      "        WHERE ad_tab_trl_instance.AD_Tab_Trl_Instance_ID = ? " +
      "                 AND ad_tab_trl_instance.AD_Tab_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

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
      "          FROM ad_tab_trl_instance" +
      "         WHERE ad_tab_trl_instance.AD_Tab_Trl_Instance_ID = ? ";

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
      "          FROM ad_tab_trl_instance" +
      "         WHERE ad_tab_trl_instance.AD_Tab_Trl_Instance_ID = ? ";

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
