package com.google.android.ads.mediationtestsuite.dataobjects;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Network implements Parcelable {
    public static final Parcelable.Creator<Network> CREATOR = new Parcelable.Creator<Network>() { // from class: com.google.android.ads.mediationtestsuite.dataobjects.Network.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Network createFromParcel(Parcel parcel) {
            return new Network(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Network[] newArray(int i) {
            return new Network[i];
        }
    };
    private List<NetworkConfig> configs;
    private NetworkSDK detectedSDK;

    @c("name")
    private String name;

    @c("sdks")
    private final List<NetworkSDK> sdks;

    public void addConfig(NetworkConfig networkConfig) {
        this.configs.add(networkConfig);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void detectInstallation() {
        for (NetworkSDK networkSDK : this.sdks) {
            networkSDK.detectInstallation();
            NetworkSDK networkSDK2 = this.detectedSDK;
            if (networkSDK2 == null || (!networkSDK2.isManifestPresent() && networkSDK.isManifestPresent())) {
                this.detectedSDK = networkSDK;
            }
        }
    }

    public boolean equals(Object obj) {
        return obj instanceof Network ? this.name.equals(((Network) obj).getName()) : super.equals(obj);
    }

    public List<NetworkConfig> getConfigs() {
        return this.configs;
    }

    public String getName() {
        return this.name;
    }

    public List<NetworkSDK> getSdks() {
        return this.sdks;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public boolean isManifestPresent() {
        NetworkSDK networkSDK = this.detectedSDK;
        return networkSDK != null && networkSDK.isManifestPresent();
    }

    public boolean isSdkPresent() {
        return this.detectedSDK != null;
    }

    public void setName(String str) {
        this.name = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        NetworkSDK[] networkSDKArrNewArray = NetworkSDK.CREATOR.newArray(this.sdks.size());
        this.sdks.toArray(networkSDKArrNewArray);
        parcel.writeParcelableArray(networkSDKArrNewArray, 0);
        parcel.writeString(this.name);
    }

    public Network() {
        this.sdks = new ArrayList();
        this.configs = new ArrayList();
    }

    private Network(Parcel parcel) {
        NetworkSDK[] networkSDKArr = (NetworkSDK[]) parcel.readParcelableArray(NetworkSDK.class.getClassLoader());
        this.sdks = new ArrayList();
        Collections.addAll(this.sdks, networkSDKArr);
        this.name = parcel.readString();
        this.configs = new ArrayList();
    }
}
