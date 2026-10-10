package com.sandboxol.imchat.model;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SealCSEvaluateItem {
    private String companyId;
    private String configId;
    private long createTime;
    private String groupId;
    private String groupName;
    private String inputLanguage;
    private boolean isInputMust;
    private boolean isQuestionFlag;
    private boolean isTagMust;
    private String labelId;
    private List<String> labelNameList = new ArrayList();
    private int operateType;
    private int score;
    private String scoreExplain;
    private int settingMode;
    private long updateTime;

    public String getCompanyId() {
        return this.companyId;
    }

    public String getConfigId() {
        return this.configId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getInputLanguage() {
        return this.inputLanguage;
    }

    public boolean getInputMust() {
        return this.isInputMust;
    }

    public String getLabelId() {
        return this.labelId;
    }

    public List<String> getLabelNameList() {
        return this.labelNameList;
    }

    public int getOperateType() {
        return this.operateType;
    }

    public boolean getQuestionFlag() {
        return this.isQuestionFlag;
    }

    public int getScore() {
        return this.score;
    }

    public String getScoreExplain() {
        return this.scoreExplain;
    }

    public int getSettingMode() {
        return this.settingMode;
    }

    public boolean getTagMust() {
        return this.isTagMust;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setCompanyId(String str) {
        this.companyId = str;
    }

    public void setConfigId(String str) {
        this.configId = str;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setInputLanguage(String str) {
        this.inputLanguage = str;
    }

    public void setInputMust(boolean z) {
        this.isInputMust = z;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public void setLabelNameList(List<String> list) {
        this.labelNameList = list;
    }

    public void setOperateType(int i) {
        this.operateType = i;
    }

    public void setQuestionFlag(boolean z) {
        this.isQuestionFlag = z;
    }

    public void setScore(int i) {
        this.score = i;
    }

    public void setScoreExplain(String str) {
        this.scoreExplain = str;
    }

    public void setSettingMode(int i) {
        this.settingMode = i;
    }

    public void setTagMust(boolean z) {
        this.isTagMust = z;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }
}
