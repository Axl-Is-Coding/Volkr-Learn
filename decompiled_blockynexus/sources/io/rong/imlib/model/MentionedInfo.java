package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.ParcelUtils;
import io.rong.common.RLog;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class MentionedInfo implements Parcelable {
    public static final Parcelable.Creator<MentionedInfo> CREATOR = new Parcelable.Creator<MentionedInfo>() { // from class: io.rong.imlib.model.MentionedInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MentionedInfo createFromParcel(Parcel parcel) {
            return new MentionedInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MentionedInfo[] newArray(int i) {
            return new MentionedInfo[i];
        }
    };
    private static final String TAG = "MentionedInfo";
    private String mentionedContent;
    private MentionedType type;
    private List<String> userIdList;

    public enum MentionedType {
        NONE(0),
        ALL(1),
        PART(2);

        private int value;

        MentionedType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static MentionedType valueOf(int i) {
            for (MentionedType mentionedType : values()) {
                if (mentionedType.getValue() == i) {
                    return mentionedType;
                }
            }
            return NONE;
        }
    }

    public MentionedInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMentionedContent() {
        return this.mentionedContent;
    }

    public List<String> getMentionedUserIdList() {
        return this.userIdList;
    }

    public MentionedType getType() {
        return this.type;
    }

    public void setMentionedContent(String str) {
        this.mentionedContent = str;
    }

    public void setMentionedUserIdList(List<String> list) {
        this.userIdList = list;
    }

    public void setType(MentionedType mentionedType) {
        this.type = mentionedType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(getType().getValue()));
        ParcelUtils.writeToParcel(parcel, getMentionedUserIdList());
        ParcelUtils.writeToParcel(parcel, getMentionedContent());
    }

    public MentionedInfo(Parcel parcel) {
        setType(MentionedType.valueOf(ParcelUtils.readIntFromParcel(parcel).intValue()));
        setMentionedUserIdList(ParcelUtils.readListFromParcel(parcel, String.class));
        setMentionedContent(ParcelUtils.readFromParcel(parcel));
    }

    public MentionedInfo(MentionedType mentionedType, List<String> list, String str) {
        if (mentionedType != null && mentionedType.equals(MentionedType.ALL)) {
            this.userIdList = null;
        } else if (mentionedType != null && mentionedType.equals(MentionedType.PART)) {
            if (list == null || list.size() == 0) {
                RLog.e(TAG, "When mentioned parts of the group members, userIdList can't be null!");
            }
            this.userIdList = list;
        }
        this.type = mentionedType;
        this.mentionedContent = str;
    }
}
