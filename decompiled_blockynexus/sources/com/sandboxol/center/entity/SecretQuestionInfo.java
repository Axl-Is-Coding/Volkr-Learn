package com.sandboxol.center.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class SecretQuestionInfo implements Parcelable {
    public static final Parcelable.Creator<SecretQuestionInfo> CREATOR = new Parcelable.Creator<SecretQuestionInfo>() { // from class: com.sandboxol.center.entity.SecretQuestionInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SecretQuestionInfo createFromParcel(Parcel parcel) {
            return new SecretQuestionInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SecretQuestionInfo[] newArray(int i) {
            return new SecretQuestionInfo[i];
        }
    };
    public String answer;
    public int id;
    public String question;

    public SecretQuestionInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAnswer() {
        return this.answer;
    }

    public int getId() {
        return this.id;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setAnswer(String str) {
        this.answer = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setQuestion(String str) {
        this.question = str;
    }

    public String toString() {
        return "SecretQuestionInfo{answer='" + this.answer + "', id=" + this.id + ", question='" + this.question + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.answer);
        parcel.writeInt(this.id);
        parcel.writeString(this.question);
    }

    protected SecretQuestionInfo(Parcel parcel) {
        this.answer = parcel.readString();
        this.id = parcel.readInt();
        this.question = parcel.readString();
    }
}
