/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SL
 * All portions are Copyright (C) 2008-2009 Openbravo SL
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
*/
package org.openbravo.model.manufacturing.maintenance;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity class for entity ManufacturingMainteanceOrder (stored in table MA_Maint_Part).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class MainteanceOrder extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "MA_Maint_Part";
    public static final String ENTITY_NAME = "ManufacturingMainteanceOrder";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_PARTDATE = "partdate";
    public static final String PROPERTY_SHIFT = "shift";
    public static final String PROPERTY_CREATEMAINT = "createMaint";
    public static final String PROPERTY_MANUFACTURINGMAINTENANCEWORKERLIST =
        "manufacturingMaintenanceWorkerList";
    public static final String PROPERTY_MANUFACTURINGMAINTENANCESCHEDULELIST =
        "manufacturingMaintenanceScheduleList";

    public MainteanceOrder() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_CREATEMAINT, false);
        setDefaultValue(PROPERTY_MANUFACTURINGMAINTENANCEWORKERLIST,
            new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGMAINTENANCESCHEDULELIST,
            new ArrayList<Object>());
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }

    public Organization getOrg() {
        return (Organization) get(PROPERTY_ORG);
    }

    public void setOrg(Organization org) {
        set(PROPERTY_ORG, org);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ISACTIVE);
    }

    public void setActive(Boolean isActive) {
        set(PROPERTY_ISACTIVE, isActive);
    }

    public Date getCreated() {
        return (Date) get(PROPERTY_CREATED);
    }

    public void setCreated(Date created) {
        set(PROPERTY_CREATED, created);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public Date getPartdate() {
        return (Date) get(PROPERTY_PARTDATE);
    }

    public void setPartdate(Date partdate) {
        set(PROPERTY_PARTDATE, partdate);
    }

    public String getShift() {
        return (String) get(PROPERTY_SHIFT);
    }

    public void setShift(String shift) {
        set(PROPERTY_SHIFT, shift);
    }

    public Boolean isCreateMaint() {
        return (Boolean) get(PROPERTY_CREATEMAINT);
    }

    public void setCreateMaint(Boolean createMaint) {
        set(PROPERTY_CREATEMAINT, createMaint);
    }

    @SuppressWarnings("unchecked")
    public List<Worker> getManufacturingMaintenanceWorkerList() {
        return (List<Worker>) get(PROPERTY_MANUFACTURINGMAINTENANCEWORKERLIST);
    }

    public void setManufacturingMaintenanceWorkerList(
        List<Worker> manufacturingMaintenanceWorkerList) {
        set(PROPERTY_MANUFACTURINGMAINTENANCEWORKERLIST,
            manufacturingMaintenanceWorkerList);
    }

    @SuppressWarnings("unchecked")
    public List<MaintenanceSchedule> getManufacturingMaintenanceScheduleList() {
        return (List<MaintenanceSchedule>) get(PROPERTY_MANUFACTURINGMAINTENANCESCHEDULELIST);
    }

    public void setManufacturingMaintenanceScheduleList(
        List<MaintenanceSchedule> manufacturingMaintenanceScheduleList) {
        set(PROPERTY_MANUFACTURINGMAINTENANCESCHEDULELIST,
            manufacturingMaintenanceScheduleList);
    }
}
