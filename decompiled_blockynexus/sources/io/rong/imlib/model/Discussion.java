package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import io.rong.common.ParcelUtils;
import io.rong.imlib.NativeObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Discussion implements Parcelable {
    public static final Parcelable.Creator<Discussion> CREATOR = new Parcelable.Creator<Discussion>() { // from class: io.rong.imlib.model.Discussion.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Discussion createFromParcel(Parcel parcel) {
            return new Discussion(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Discussion[] newArray(int i) {
            return new Discussion[i];
        }
    };
    private String creatorId;
    private String id;
    private boolean isOpen;
    private List<String> memberIdList;
    private String name;

    public Discussion(NativeObject.DiscussionInfo discussionInfo) {
        this.isOpen = true;
        this.id = discussionInfo.getDiscussionId();
        this.name = discussionInfo.getDiscussionName();
        this.creatorId = discussionInfo.getAdminId();
        if (!TextUtils.isEmpty(discussionInfo.getUserIds())) {
            this.memberIdList = new ArrayList(Arrays.asList(discussionInfo.getUserIds().split(UMCustomLogInfoBuilder.LINE_SEP)));
        }
        Log.d("Discussion", "info.getInviteStatus():" + discussionInfo.getInviteStatus());
        this.isOpen = discussionInfo.getInviteStatus() != 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCreatorId() {
        return this.creatorId;
    }

    public String getId() {
        return this.id;
    }

    public List<String> getMemberIdList() {
        return this.memberIdList;
    }

    public String getName() {
        return this.name;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void setCreatorId(String str) {
        this.creatorId = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMemberIdList(List<String> list) {
        this.memberIdList = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOpen(boolean z) {
        this.isOpen = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, getId());
        ParcelUtils.writeToParcel(parcel, getName());
        ParcelUtils.writeToParcel(parcel, getCreatorId());
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(isOpen() ? 1 : 0));
        ParcelUtils.writeToParcel(parcel, getMemberIdList());
    }

    public Discussion(Parcel parcel) {
        this(ParcelUtils.readFromParcel(parcel), ParcelUtils.readFromParcel(parcel), ParcelUtils.readFromParcel(parcel), ParcelUtils.readIntFromParcel(parcel).intValue() == 1, ParcelUtils.readListFromParcel(parcel, String.class));
    }

    public Discussion(String str, String str2) {
        this.isOpen = true;
        this.id = str;
        this.name = str2;
    }

    public Discussion(String str, String str2, String str3, boolean z, List<String> list) {
        this.isOpen = true;
        this.id = str;
        this.name = str2;
        this.creatorId = str3;
        this.isOpen = z;
        this.memberIdList = list;
    }
}
