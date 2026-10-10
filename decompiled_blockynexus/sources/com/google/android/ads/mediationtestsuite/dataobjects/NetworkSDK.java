package com.google.android.ads.mediationtestsuite.dataobjects;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.ads.mediationtestsuite.utils.d;
import com.google.gson.a.c;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NetworkSDK implements Parcelable {
    public static final Parcelable.Creator<NetworkSDK> CREATOR = new Parcelable.Creator<NetworkSDK>() { // from class: com.google.android.ads.mediationtestsuite.dataobjects.NetworkSDK.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkSDK createFromParcel(Parcel parcel) {
            return new NetworkSDK(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkSDK[] newArray(int i) {
            return new NetworkSDK[i];
        }
    };
    private boolean manifestPresent;

    @c("requiredActivities")
    private List<String> requiredActivities;

    @c("requiredPermissions")
    private List<String> requiredPermissions;

    @c("sdkDetectionClass")
    private String sdkDetectionClass;
    private boolean sdkPresent;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void detectInstallation() {
        this.sdkPresent = d.b(this.sdkDetectionClass);
        if (this.sdkPresent) {
            String strValueOf = String.valueOf(this.sdkDetectionClass);
            Log.i("gma_test", strValueOf.length() != 0 ? "Detected SDK class ".concat(strValueOf) : new String("Detected SDK class "));
        } else {
            String strValueOf2 = String.valueOf(this.sdkDetectionClass);
            Log.i("gma_test", strValueOf2.length() != 0 ? "Failed to detect SDK class ".concat(strValueOf2) : new String("Failed to detect SDK class "));
        }
        boolean z = true;
        for (String str : this.requiredActivities) {
            if (d.a(str)) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 32);
                sb.append("Required activity '");
                sb.append(str);
                sb.append("' registered.");
                Log.i("gma_test", sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 36);
                sb2.append("Required activity '");
                sb2.append(str);
                sb2.append("' NOT registered.");
                Log.d("gma_test", sb2.toString());
                z = false;
            }
        }
        for (String str2 : this.requiredPermissions) {
            if (d.c(str2)) {
                StringBuilder sb3 = new StringBuilder(String.valueOf(str2).length() + 33);
                sb3.append("Required permission '");
                sb3.append(str2);
                sb3.append("' requested.");
                Log.i("gma_test", sb3.toString());
            } else {
                StringBuilder sb4 = new StringBuilder(String.valueOf(str2).length() + 37);
                sb4.append("Required permission '");
                sb4.append(str2);
                sb4.append("' NOT requested.");
                Log.d("gma_test", sb4.toString());
                z = false;
            }
        }
        this.manifestPresent = z;
    }

    public boolean equals(Object obj) {
        return obj instanceof NetworkSDK ? this.sdkDetectionClass.equals(((NetworkSDK) obj).getSdkDetectionClass()) : super.equals(obj);
    }

    public List<String> getRequiredActivities() {
        return this.requiredActivities;
    }

    public List<String> getRequiredPermissions() {
        return this.requiredPermissions;
    }

    public String getSdkDetectionClass() {
        return this.sdkDetectionClass;
    }

    public int hashCode() {
        return this.sdkDetectionClass.hashCode();
    }

    public boolean isManifestPresent() {
        return this.manifestPresent;
    }

    public boolean isSdkPresent() {
        return this.sdkPresent;
    }

    public void setManifestPresent(boolean z) {
        this.manifestPresent = z;
    }

    public void setRequiredActivities(List<String> list) {
        this.requiredActivities = list;
    }

    public void setRequiredPermissions(List<String> list) {
        this.requiredPermissions = list;
    }

    public void setSdkDetectionClass(String str) {
        this.sdkDetectionClass = str;
    }

    public void setSdkPresent(boolean z) {
        this.sdkPresent = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        boolean[] zArr = {this.sdkPresent, this.manifestPresent};
        parcel.writeString(this.sdkDetectionClass);
        parcel.writeStringList(this.requiredActivities);
        parcel.writeStringList(this.requiredPermissions);
    }

    private NetworkSDK(Parcel parcel) {
        boolean[] zArr = new boolean[2];
        parcel.readBooleanArray(zArr);
        this.sdkPresent = zArr[0];
        this.manifestPresent = zArr[1];
        this.sdkDetectionClass = parcel.readString();
        this.requiredActivities = new ArrayList();
        parcel.readStringList(this.requiredActivities);
        this.requiredPermissions = new ArrayList();
        parcel.readStringList(this.requiredPermissions);
    }
}
