/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.model;

/**
 *
 * @author ceiroa
 */
public interface iVisit {

    public String getAchingDullSore();
    public String getBurning();
    public String getComplaint();
    public String getDateCreated();
    public String getDateUpdated();
    public String getFrequency();
    public long getId();
    public long getClientId();
    public String getFirstName();
    public String getLastName();
    public String getNumbnessTingling();
    public String getPainChange();
    public int getPainLevel();
    public String getSameComplaint();
    public String getSharpShooting();
    public String getSharpStabbing();
    public String getSnapPopGrind();
    public String getStiffnessTightness();
    public String getSwelling();
    public String getThrobbing();
    public String getVisitType();
    public String getDxAction();
    public String getInspection();
    public String getPalpation();
    public String getController();

    public void setAchingDullSore(String achingDullSore);
    public void setBurning(String burning);
    public void setComplaint(String complaint);
    public void setDateCreated(String dateCreated);
    public void setDateUpdated(String dateUpdated);
    public void setFrequency(String frequency);
    public void setId(long id);
    public void setClientId(long clientId);
    public void setFirstName(String firstName);
    public void setLastName(String lastName);
    public void setNumbnessTingling(String numbnessTingling);
    public void setPainChange(String painChange);
    public void setPainLevel(int painLevel);
    public void setSameComplaint(String sameComplaint);
    public void setSharpShooting(String sharpShooting);
    public void setSharpStabbing(String sharpStabbing);
    public void setSnapPopGrind(String snapPopGrind);
    public void setStiffnessTightness(String stiffnessTightness);
    public void setSwelling(String swelling);
    public void setThrobbing(String throbbing);
    public void setVisitType(String visitType);
    public void setDxAction(String dxAction);
    public void setInspection(String inspection);
    public void setPalpation(String palpation);
    public void setController(String controller);
}