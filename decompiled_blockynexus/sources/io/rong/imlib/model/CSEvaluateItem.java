package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class CSEvaluateItem implements Parcelable {
    public static final Parcelable.Creator<CSEvaluateItem> CREATOR = new Parcelable.Creator<CSEvaluateItem>() { // from class: io.rong.imlib.model.CSEvaluateItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSEvaluateItem createFromParcel(Parcel parcel) {
            return new CSEvaluateItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSEvaluateItem[] newArray(int i) {
            return new CSEvaluateItem[i];
        }
    };
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
    private List<String> labelNameList;
    private int operateType;
    private int score;
    private String scoreExplain;
    private int settingMode;
    private long updateTime;

    public CSEvaluateItem() {
        this.labelNameList = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.configId);
        parcel.writeString(this.companyId);
        parcel.writeString(this.groupId);
        parcel.writeString(this.groupName);
        parcel.writeString(this.labelId);
        parcel.writeStringList(this.labelNameList);
        parcel.writeByte(this.isQuestionFlag ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.score);
        parcel.writeString(this.scoreExplain);
        parcel.writeByte(this.isTagMust ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isInputMust ? (byte) 1 : (byte) 0);
        parcel.writeString(this.inputLanguage);
        parcel.writeLong(this.createTime);
        parcel.writeInt(this.settingMode);
        parcel.writeLong(this.updateTime);
        parcel.writeInt(this.operateType);
    }

    protected CSEvaluateItem(Parcel parcel) {
        this.labelNameList = new ArrayList();
        this.configId = parcel.readString();
        this.companyId = parcel.readString();
        this.groupId = parcel.readString();
        this.groupName = parcel.readString();
        this.labelId = parcel.readString();
        this.labelNameList = parcel.createStringArrayList();
        this.isQuestionFlag = parcel.readByte() != 0;
        this.score = parcel.readInt();
        this.scoreExplain = parcel.readString();
        this.isTagMust = parcel.readByte() != 0;
        this.isInputMust = parcel.readByte() != 0;
        this.inputLanguage = parcel.readString();
        this.createTime = parcel.readLong();
        this.settingMode = parcel.readInt();
        this.updateTime = parcel.readLong();
        this.operateType = parcel.readInt();
    }
}
