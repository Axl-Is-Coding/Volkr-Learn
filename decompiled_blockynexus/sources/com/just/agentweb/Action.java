package com.just.agentweb;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class Action implements Parcelable {
    public static final transient int ACTION_CAMERA = 3;
    public static final transient int ACTION_FILE = 2;
    public static final transient int ACTION_PERMISSION = 1;
    public static final transient int ACTION_VIDEO = 4;
    public static final Parcelable.Creator<Action> CREATOR = new Parcelable.Creator<Action>() { // from class: com.just.agentweb.Action.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Action createFromParcel(Parcel parcel) {
            return new Action(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Action[] newArray(int i) {
            return new Action[i];
        }
    };
    private int mAction;
    private int mFromIntention;
    private ArrayList<String> mPermissions;

    public Action() {
        this.mPermissions = new ArrayList<>();
    }

    public static Action createPermissionsAction(String[] strArr) {
        Action action = new Action();
        action.setAction(1);
        action.setPermissions(new ArrayList<>(Arrays.asList(strArr)));
        return action;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAction() {
        return this.mAction;
    }

    public int getFromIntention() {
        return this.mFromIntention;
    }

    public ArrayList<String> getPermissions() {
        return this.mPermissions;
    }

    public void setAction(int i) {
        this.mAction = i;
    }

    public Action setFromIntention(int i) {
        this.mFromIntention = i;
        return this;
    }

    public void setPermissions(ArrayList<String> arrayList) {
        this.mPermissions = arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.mPermissions);
        parcel.writeInt(this.mAction);
        parcel.writeInt(this.mFromIntention);
    }

    public void setPermissions(String[] strArr) {
        this.mPermissions = new ArrayList<>(Arrays.asList(strArr));
    }

    protected Action(Parcel parcel) {
        this.mPermissions = new ArrayList<>();
        this.mPermissions = parcel.createStringArrayList();
        this.mAction = parcel.readInt();
        this.mFromIntention = parcel.readInt();
    }
}
