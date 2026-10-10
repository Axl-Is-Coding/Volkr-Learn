package com.google.android.ads.mediationtestsuite.dataobjects;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.ads.mediationtestsuite.utils.d;
import com.google.gson.a.c;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class NetworkAdapter implements Parcelable {
    public static final Parcelable.Creator<NetworkAdapter> CREATOR = new Parcelable.Creator<NetworkAdapter>() { // from class: com.google.android.ads.mediationtestsuite.dataobjects.NetworkAdapter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkAdapter createFromParcel(Parcel parcel) {
            return new NetworkAdapter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkAdapter[] newArray(int i) {
            return new NetworkAdapter[i];
        }
    };
    private boolean adapterPresent;

    @c("className")
    private String className;

    @c("format")
    private AdFormat format;
    private Network network;

    @c("networkLabel")
    private String networkLabel;

    @c("serverParameters")
    private Map<String, String> serverParameters;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void detectInstallation() {
        this.adapterPresent = d.b(this.className);
        if (this.adapterPresent) {
            Log.i("gma_test", String.valueOf(this.className).concat(" class detected."));
        } else {
            Log.d("gma_test", String.valueOf(this.className).concat(" class NOT detected."));
        }
    }

    public String getClassName() {
        return this.className;
    }

    public AdFormat getFormat() {
        return this.format;
    }

    public Network getNetwork() {
        return this.network;
    }

    public String getNetworkLabel() {
        return this.networkLabel;
    }

    public Map<String, String> getServerParameters() {
        return this.serverParameters;
    }

    public boolean isAdapterPresent() {
        return this.adapterPresent;
    }

    public void setAdapterPresent(boolean z) {
        this.adapterPresent = z;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public void setFormat(AdFormat adFormat) {
        this.format = adFormat;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public void setNetworkLabel(String str) {
        this.networkLabel = str;
    }

    public void setServerParameters(Map<String, String> map) {
        this.serverParameters = map;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBooleanArray(new boolean[]{this.adapterPresent});
        parcel.writeString(this.format.getFormatString());
        parcel.writeString(this.className);
        parcel.writeString(this.networkLabel);
        parcel.writeParcelable(this.network, 0);
        parcel.writeInt(this.serverParameters.size());
        for (String str : this.serverParameters.keySet()) {
            parcel.writeString(str);
            parcel.writeString(this.serverParameters.get(str));
        }
    }

    public NetworkAdapter() {
        this.serverParameters = new HashMap();
    }

    private NetworkAdapter(Parcel parcel) {
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.adapterPresent = zArr[0];
        this.format = AdFormat.from(parcel.readString());
        this.className = parcel.readString();
        this.networkLabel = parcel.readString();
        this.network = (Network) parcel.readParcelable(Network.class.getClassLoader());
        this.serverParameters = new HashMap();
        int i = parcel.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.serverParameters.put(parcel.readString(), parcel.readString());
        }
    }
}
