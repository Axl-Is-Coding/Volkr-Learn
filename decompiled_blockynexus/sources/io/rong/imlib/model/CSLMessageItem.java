package io.rong.imlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class CSLMessageItem implements Parcelable {
    public static final Parcelable.Creator<CSLMessageItem> CREATOR = new Parcelable.Creator<CSLMessageItem>() { // from class: io.rong.imlib.model.CSLMessageItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSLMessageItem createFromParcel(Parcel parcel) {
            return new CSLMessageItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CSLMessageItem[] newArray(int i) {
            return new CSLMessageItem[i];
        }
    };
    private String defaultText;
    private int max;
    private String name;
    private Map<String, String> remindMessage;
    private boolean required;
    private String title;
    private String type;
    private String verification;

    public enum RemindType {
        EMPTY("empty"),
        WRONG_FORMAT("wrong_format"),
        OVER_LENGTH("over_length");

        private String name;

        RemindType(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }
    }

    public CSLMessageItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDefaultText() {
        return this.defaultText;
    }

    public int getMax() {
        return this.max;
    }

    public Map<String, String> getMessage() {
        return this.remindMessage;
    }

    public String getName() {
        return this.name;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public String getVerification() {
        return this.verification;
    }

    public boolean isRequired() {
        return this.required;
    }

    public void setDefaultText(String str) {
        this.defaultText = str;
    }

    public void setMax(int i) {
        this.max = i;
    }

    public void setMessage(Map<String, String> map) {
        this.remindMessage = map;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRequired(boolean z) {
        this.required = z;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setVerification(String str) {
        this.verification = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.title);
        parcel.writeString(this.type);
        parcel.writeString(this.defaultText);
        parcel.writeByte(this.required ? (byte) 1 : (byte) 0);
        parcel.writeString(this.verification);
        parcel.writeInt(this.max);
        parcel.writeInt(this.remindMessage.size());
        for (Map.Entry<String, String> entry : this.remindMessage.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }

    protected CSLMessageItem(Parcel parcel) {
        this.name = parcel.readString();
        this.title = parcel.readString();
        this.type = parcel.readString();
        this.defaultText = parcel.readString();
        this.required = parcel.readByte() != 0;
        this.verification = parcel.readString();
        this.max = parcel.readInt();
        int i = parcel.readInt();
        this.remindMessage = new HashMap(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.remindMessage.put(parcel.readString(), parcel.readString());
        }
    }
}
