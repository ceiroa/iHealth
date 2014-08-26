/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.model;

/**
 *
 * @author ceiroa
 */
public abstract class abstractVisit {

    private long id;
    private long clientId;
    private String firstName; //From client table
    private String lastName;  //From client table
    private String dateCreated;
    private String dateUpdated;
    private String sameComplaint;
    private String painChange;
    private String achingDullSore;
    private String burning;
    private String numbnessTingling;
    private String sharpShooting;
    private String sharpStabbing;
    private String stiffnessTightness;
    private String swelling;
    private String throbbing;
    private String snapPopGrind;
    private int painLevel;
    private String complaint;
    private String frequency;
    private String visitType;
    private String inspection;
    private String palpation;
    private String dxAction;
    private String controller;

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getDxAction() {
        return dxAction;
    }

    public void setDxAction(String dxAction) {
        if(dxAction.length()>1600) {
            dxAction = dxAction.substring(0, 1600);
        }
        this.dxAction = dxAction;
    }

    public String getInspection() {
        return inspection;
    }

    public void setInspection(String inspection) {
        if(inspection.length()>1200) {
            inspection = inspection.substring(0, 1200);
        }
        this.inspection = inspection;
    }

    public String getPalpation() {
        return palpation;
    }

    public void setPalpation(String palpation) {
        if(palpation.length()>1200) {
            palpation = palpation.substring(0, 1200);
        }
        this.palpation = palpation;
    }

    public String getVisitType() {
        return visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAchingDullSore() {
        return achingDullSore;
    }

    public void setAchingDullSore(String achingDullSore) {
        this.achingDullSore = achingDullSore;
    }

    public String getBurning() {
        return burning;
    }

    public void setBurning(String burning) {
        this.burning = burning;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        if(complaint.length()>800) {
            complaint = complaint.substring(0, 800);
        }
        this.complaint = complaint;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        if(frequency.length()>400) {
           frequency = frequency.substring(0, 400);
        }
        this.frequency = frequency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    
    public String getNumbnessTingling() {
        return numbnessTingling;
    }

    public void setNumbnessTingling(String numbnessTingling) {
        this.numbnessTingling = numbnessTingling;
    }

    public String getPainChange() {
        return painChange;
    }

    public void setPainChange(String painChange) {
        this.painChange = painChange;
    }

    public int getPainLevel() {
        return painLevel;
    }

    public void setPainLevel(int painLevel) {
        this.painLevel = painLevel;
    }

    public String getSameComplaint() {
        return sameComplaint;
    }

    public void setSameComplaint(String sameComplaint) {
        this.sameComplaint = sameComplaint;
    }

    public String getSharpShooting() {
        return sharpShooting;
    }

    public void setSharpShooting(String sharpShooting) {
        this.sharpShooting = sharpShooting;
    }

    public String getSharpStabbing() {
        return sharpStabbing;
    }

    public void setSharpStabbing(String sharpStabbing) {
        this.sharpStabbing = sharpStabbing;
    }

    public String getSnapPopGrind() {
        return snapPopGrind;
    }

    public void setSnapPopGrind(String snapPopGrind) {
        this.snapPopGrind = snapPopGrind;
    }

    public String getStiffnessTightness() {
        return stiffnessTightness;
    }

    public void setStiffnessTightness(String stiffnessTightness) {
        this.stiffnessTightness = stiffnessTightness;
    }

    public String getSwelling() {
        return swelling;
    }

    public void setSwelling(String swelling) {
        this.swelling = swelling;
    }

    public String getThrobbing() {
        return throbbing;
    }

    public void setThrobbing(String throbbing) {
        this.throbbing = throbbing;
    }
}
