//Sqlc generated V1.O00-1
package org.openbravo.erpReports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class RptCBpartnerVendorData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptCBpartnerVendorData.class);
  private String InitRecordNumber="0";
  public String paymentrulepo;
  public String pricelistpo;
  public String accountvendor;
  public String paymenttermnamepo;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("paymentrulepo"))
      return paymentrulepo;
    else if (fieldName.equalsIgnoreCase("pricelistpo"))
      return pricelistpo;
    else if (fieldName.equalsIgnoreCase("accountvendor"))
      return accountvendor;
    else if (fieldName.equalsIgnoreCase("paymenttermnamepo"))
      return paymenttermnamepo;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptCBpartnerVendorData[] select(ConnectionProvider connectionProvider, String adLanguage, String cBpartnerId)    throws ServletException {
    return select(connectionProvider, adLanguage, cBpartnerId, 0, 0);
  }

  public static RptCBpartnerVendorData[] select(ConnectionProvider connectionProvider, String adLanguage, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT PR.NAME AS PAYMENTRULEPO, P.NAME AS PRICELISTPO, C_ELEMENTVALUE.VALUE||' - '||C_ELEMENTVALUE.NAME AS ACCOUNTVENDOR, PT.NAME AS PAYMENTTERMNAMEPO" +
      "        FROM C_BPARTNER BP left join C_PAYMENTTERM PT on  BP.PO_PAYMENTTERM_ID = PT.C_PAYMENTTERM_ID" +
      "                           left join  (SELECT VALUE, NAME from AD_REF_LIST_V WHERE AD_REFERENCE_ID='195' AND AD_LANGUAGE= ?) PR on BP.PAYMENTRULEPO = PR.VALUE" +
      "                           left join M_PRICELIST P on BP.PO_PRICELIST_ID = P.M_PRICELIST_ID" +
      "                           left join C_BP_VENDOR_ACCT on BP.C_BPARTNER_ID = C_BP_VENDOR_ACCT.C_BPARTNER_ID " +
      "                           left join C_VALIDCOMBINATION on C_BP_VENDOR_ACCT.V_LIABILITY_ACCT = C_VALIDCOMBINATION.C_VALIDCOMBINATION_ID " +
      "                           left join C_ELEMENTVALUE on C_VALIDCOMBINATION.ACCOUNT_ID = C_ELEMENTVALUE.C_ELEMENTVALUE_ID" +
      "        WHERE " +
      "        BP.ISVENDOR = 'Y'";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND BP.C_BPARTNER_ID IN          " + cBpartnerId);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
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
        RptCBpartnerVendorData objectRptCBpartnerVendorData = new RptCBpartnerVendorData();
        objectRptCBpartnerVendorData.paymentrulepo = UtilSql.getValue(result, "paymentrulepo");
        objectRptCBpartnerVendorData.pricelistpo = UtilSql.getValue(result, "pricelistpo");
        objectRptCBpartnerVendorData.accountvendor = UtilSql.getValue(result, "accountvendor");
        objectRptCBpartnerVendorData.paymenttermnamepo = UtilSql.getValue(result, "paymenttermnamepo");
        objectRptCBpartnerVendorData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerVendorData);
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
    RptCBpartnerVendorData objectRptCBpartnerVendorData[] = new RptCBpartnerVendorData[vector.size()];
    vector.copyInto(objectRptCBpartnerVendorData);
    return(objectRptCBpartnerVendorData);
  }

  public static RptCBpartnerVendorData[] set()    throws ServletException {
    RptCBpartnerVendorData objectRptCBpartnerVendorData[] = new RptCBpartnerVendorData[1];
    objectRptCBpartnerVendorData[0] = new RptCBpartnerVendorData();
    objectRptCBpartnerVendorData[0].paymentrulepo = "";
    objectRptCBpartnerVendorData[0].pricelistpo = "";
    objectRptCBpartnerVendorData[0].accountvendor = "";
    objectRptCBpartnerVendorData[0].paymenttermnamepo = "";
    return objectRptCBpartnerVendorData;
  }
}
