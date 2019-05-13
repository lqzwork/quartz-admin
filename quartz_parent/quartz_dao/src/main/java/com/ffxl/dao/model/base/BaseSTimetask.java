package com.ffxl.dao.model.base;

import java.io.Serializable;
import java.util.Date;

public class BaseSTimetask implements Serializable {
    private String id;

    private String name;

    private String groupName;

    private Date startTime;

    private Date endTime;

    private String cron;

    private String jobStatus;

    private String planStatus;

    private Boolean concurrent;

    private String jobData;

    private String methodName;

    private String beanName;

    private String description;

    private Date createDate;

    private Date modifyDate;

    private String createUserId;

    private String modifyUserId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron == null ? null : cron.trim();
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus == null ? null : jobStatus.trim();
    }

    public String getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus == null ? null : planStatus.trim();
    }

    public Boolean getConcurrent() {
        return concurrent;
    }

    public void setConcurrent(Boolean concurrent) {
        this.concurrent = concurrent;
    }

    public String getJobData() {
        return jobData;
    }

    public void setJobData(String jobData) {
        this.jobData = jobData == null ? null : jobData.trim();
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName == null ? null : beanName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId == null ? null : modifyUserId.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BaseSTimetask other = (BaseSTimetask) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getCron() == null ? other.getCron() == null : this.getCron().equals(other.getCron()))
            && (this.getJobStatus() == null ? other.getJobStatus() == null : this.getJobStatus().equals(other.getJobStatus()))
            && (this.getPlanStatus() == null ? other.getPlanStatus() == null : this.getPlanStatus().equals(other.getPlanStatus()))
            && (this.getConcurrent() == null ? other.getConcurrent() == null : this.getConcurrent().equals(other.getConcurrent()))
            && (this.getJobData() == null ? other.getJobData() == null : this.getJobData().equals(other.getJobData()))
            && (this.getMethodName() == null ? other.getMethodName() == null : this.getMethodName().equals(other.getMethodName()))
            && (this.getBeanName() == null ? other.getBeanName() == null : this.getBeanName().equals(other.getBeanName()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getModifyDate() == null ? other.getModifyDate() == null : this.getModifyDate().equals(other.getModifyDate()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getModifyUserId() == null ? other.getModifyUserId() == null : this.getModifyUserId().equals(other.getModifyUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getCron() == null) ? 0 : getCron().hashCode());
        result = prime * result + ((getJobStatus() == null) ? 0 : getJobStatus().hashCode());
        result = prime * result + ((getPlanStatus() == null) ? 0 : getPlanStatus().hashCode());
        result = prime * result + ((getConcurrent() == null) ? 0 : getConcurrent().hashCode());
        result = prime * result + ((getJobData() == null) ? 0 : getJobData().hashCode());
        result = prime * result + ((getMethodName() == null) ? 0 : getMethodName().hashCode());
        result = prime * result + ((getBeanName() == null) ? 0 : getBeanName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getModifyDate() == null) ? 0 : getModifyDate().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getModifyUserId() == null) ? 0 : getModifyUserId().hashCode());
        return result;
    }
}