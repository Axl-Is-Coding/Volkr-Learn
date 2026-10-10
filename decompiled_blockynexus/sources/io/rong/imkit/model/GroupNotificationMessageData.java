package io.rong.imkit.model;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class GroupNotificationMessageData {
    private String newCreatorId;
    private String newCreatorName;
    private String oldCreatorId;
    private String oldCreatorName;
    private String operatorNickname;
    private String targetGroupName;
    private List<String> targetUserDisplayNames = new ArrayList();
    private List<String> targetUserIds = new ArrayList();
    private long timestamp;

    public String getNewCreatorId() {
        return this.newCreatorId;
    }

    public String getNewCreatorName() {
        return this.newCreatorName;
    }

    public String getOldCreatorId() {
        return this.oldCreatorId;
    }

    public String getOldCreatorName() {
        return this.oldCreatorName;
    }

    public String getOperatorNickname() {
        return this.operatorNickname;
    }

    public String getTargetGroupName() {
        return this.targetGroupName;
    }

    public List<String> getTargetUserDisplayNames() {
        return this.targetUserDisplayNames;
    }

    public List<String> getTargetUserIds() {
        return this.targetUserIds;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setNewCreatorId(String str) {
        this.newCreatorId = str;
    }

    public void setNewCreatorName(String str) {
        this.newCreatorName = str;
    }

    public void setOldCreatorId(String str) {
        this.oldCreatorId = str;
    }

    public void setOldCreatorName(String str) {
        this.oldCreatorName = str;
    }

    public void setOperatorNickname(String str) {
        this.operatorNickname = str;
    }

    public void setTargetGroupName(String str) {
        this.targetGroupName = str;
    }

    public void setTargetUserDisplayNames(List<String> list) {
        this.targetUserDisplayNames = list;
    }

    public void setTargetUserIds(List<String> list) {
        this.targetUserIds = list;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
