package com.disabngo.blockynexus.entity;

import android.text.TextUtils;
import androidx.databinding.BaseObservable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityTaskAction extends BaseObservable {
    private String actionFlag;
    private int actionFrequency;
    private int actionId;
    private String actionName;
    private List<ActivityTaskActionReward> actionRewards;
    private int completeQuantity;
    private String content;
    private String dateDesc;
    private boolean isFirst;
    private int isShowComplete;
    private int isSingleCumulative;
    private String pic;
    private int quantity;
    private int status;

    public ActivityTaskAction() {
    }

    public String getActionFlag() {
        return this.actionFlag;
    }

    public int getActionFrequency() {
        return this.actionFrequency;
    }

    public int getActionId() {
        return this.actionId;
    }

    public String getActionName() {
        return this.actionName;
    }

    public List<ActivityTaskActionReward> getActionRewards() {
        return this.actionRewards;
    }

    public int getCompleteQuantity() {
        return this.status > 0 ? this.quantity : this.completeQuantity;
    }

    public String getContent() {
        return this.content;
    }

    public String getDateDesc() {
        return this.dateDesc;
    }

    public int getIsShowComplete() {
        return this.isShowComplete;
    }

    public int getIsSingleCumulative() {
        return this.isSingleCumulative;
    }

    public String getPic() {
        return this.pic;
    }

    public String getProgressText() {
        int i;
        StringBuilder sb = new StringBuilder();
        if (this.status > 0) {
            i = this.quantity;
        } else {
            i = this.completeQuantity;
            int i2 = this.quantity;
            if (i > i2) {
                i = i2;
            }
        }
        sb.append(i);
        sb.append("/");
        sb.append(this.quantity);
        return sb.toString();
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getStatus() {
        return this.status;
    }

    public int getTopType() {
        if (!TextUtils.isEmpty(this.dateDesc)) {
            return 1;
        }
        if (TextUtils.isEmpty(this.pic)) {
            return 0;
        }
        return !TextUtils.isEmpty(this.content) ? 3 : 2;
    }

    public boolean isFirst() {
        return this.isFirst;
    }

    public void setActionFlag(String str) {
        this.actionFlag = str;
    }

    public void setActionFrequency(int i) {
        this.actionFrequency = i;
    }

    public void setActionId(int i) {
        this.actionId = i;
    }

    public void setActionName(String str) {
        this.actionName = str;
    }

    public void setActionRewards(List<ActivityTaskActionReward> list) {
        this.actionRewards = list;
    }

    public void setCompleteQuantity(int i) {
        this.completeQuantity = i;
        notifyChange();
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDateDesc(String str) {
        this.dateDesc = str;
    }

    public void setFirst(boolean z) {
        this.isFirst = z;
    }

    public void setIsShowComplete(int i) {
        this.isShowComplete = i;
    }

    public void setIsSingleCumulative(int i) {
        this.isSingleCumulative = i;
    }

    public void setPic(String str) {
        this.pic = str;
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }

    public void setStatus(int i) {
        this.status = i;
        notifyChange();
    }

    public ActivityTaskAction(String str, String str2, String str3, boolean z) {
        this.content = str;
        this.dateDesc = str2;
        this.pic = str3;
        this.isFirst = z;
    }
}
