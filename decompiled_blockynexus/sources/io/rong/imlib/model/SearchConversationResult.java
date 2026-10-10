package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.ParcelUtils;

/* JADX INFO: loaded from: classes5.dex */
public class SearchConversationResult implements Parcelable {
    public static final Parcelable.Creator<SearchConversationResult> CREATOR = new Parcelable.Creator<SearchConversationResult>() { // from class: io.rong.imlib.model.SearchConversationResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchConversationResult createFromParcel(Parcel parcel) {
            return new SearchConversationResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchConversationResult[] newArray(int i) {
            return new SearchConversationResult[i];
        }
    };
    private Conversation mConversation;
    private int mMatchCount;

    public SearchConversationResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Conversation getConversation() {
        return this.mConversation;
    }

    public int getMatchCount() {
        return this.mMatchCount;
    }

    public void setConversation(Conversation conversation) {
        this.mConversation = conversation;
    }

    public void setMatchCount(int i) {
        this.mMatchCount = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeToParcel(parcel, this.mConversation);
        ParcelUtils.writeToParcel(parcel, Integer.valueOf(this.mMatchCount));
    }

    public SearchConversationResult(Parcel parcel) {
        this.mConversation = (Conversation) ParcelUtils.readFromParcel(parcel, Conversation.class);
        this.mMatchCount = ParcelUtils.readIntFromParcel(parcel).intValue();
    }
}
