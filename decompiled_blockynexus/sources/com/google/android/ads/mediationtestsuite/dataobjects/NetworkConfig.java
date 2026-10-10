package com.google.android.ads.mediationtestsuite.dataobjects;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.ads.mediationtestsuite.R;
import com.google.android.ads.mediationtestsuite.dataobjects.Caption;
import com.google.android.ads.mediationtestsuite.utils.c;
import com.google.android.ads.mediationtestsuite.viewmodels.TestState;
import com.google.android.ads.mediationtestsuite.viewmodels.d;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class NetworkConfig extends d implements Parcelable, Matchable {
    public static final Parcelable.Creator<NetworkConfig> CREATOR = new Parcelable.Creator<NetworkConfig>() { // from class: com.google.android.ads.mediationtestsuite.dataobjects.NetworkConfig.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkConfig createFromParcel(Parcel parcel) {
            return new NetworkConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkConfig[] newArray(int i) {
            return new NetworkConfig[i];
        }
    };
    private AdUnit adUnit;
    private AdUnitId adUnitId;
    private NetworkAdapter adapter;
    private boolean hasMissingParameters;
    private int id;
    private String label;
    private TestResult lastTestResult;
    private Map<String, String> serverParameters;

    /* JADX INFO: renamed from: com.google.android.ads.mediationtestsuite.dataobjects.NetworkConfig$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$ads$mediationtestsuite$dataobjects$TestResult = new int[TestResult.values().length];

        static {
            try {
                $SwitchMap$com$google$android$ads$mediationtestsuite$dataobjects$TestResult[TestResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$android$ads$mediationtestsuite$dataobjects$TestResult[TestResult.UNTESTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void checkMissingParameters() {
        Iterator<String> it = this.adapter.getServerParameters().values().iterator();
        while (it.hasNext()) {
            if (this.serverParameters.get(it.next()) == null) {
                this.hasMissingParameters = true;
            }
        }
    }

    public static Comparator<NetworkConfig> sortComparator() {
        return new Comparator<NetworkConfig>() { // from class: com.google.android.ads.mediationtestsuite.dataobjects.NetworkConfig.1
            @Override // java.util.Comparator
            public int compare(NetworkConfig networkConfig, NetworkConfig networkConfig2) {
                if (networkConfig.getSortValue() > networkConfig2.getSortValue()) {
                    return 1;
                }
                if (networkConfig.getSortValue() == networkConfig2.getSortValue()) {
                    return networkConfig.getLabel().toLowerCase().compareTo(networkConfig2.getLabel().toLowerCase());
                }
                return -1;
            }
        };
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TestState getAdLoadState() {
        if (!isTestable()) {
            return null;
        }
        int i = AnonymousClass3.$SwitchMap$com$google$android$ads$mediationtestsuite$dataobjects$TestResult[this.lastTestResult.ordinal()];
        return i != 1 ? i != 2 ? TestState.ERROR : TestState.WARNING : TestState.OK;
    }

    public AdUnit getAdUnit() {
        return this.adUnit;
    }

    public AdUnitId getAdUnitId() {
        return this.adUnitId;
    }

    public String getAdUnitIdForTestLoad() {
        return this.adapter.getClassName().equals(AdUnit.GOOGLE_ADAPTER_CLASS) ? c.a(this.adapter.getFormat()) : this.adUnit.getId();
    }

    public NetworkAdapter getAdapter() {
        return this.adapter;
    }

    public TestState getAdapterState() {
        NetworkAdapter networkAdapter = this.adapter;
        if (networkAdapter == null || networkAdapter.getClassName().equals(AdUnit.GOOGLE_ADAPTER_CLASS)) {
            return null;
        }
        return this.adapter.isAdapterPresent() ? TestState.OK : TestState.ERROR;
    }

    @Override // com.google.android.ads.mediationtestsuite.viewmodels.d
    public List<Caption> getCaptions() {
        ArrayList arrayList = new ArrayList();
        TestState sDKState = getSDKState();
        TestState manifestState = getManifestState();
        TestState adapterState = getAdapterState();
        TestState adLoadState = getAdLoadState();
        if (sDKState != null) {
            arrayList.add(new Caption(sDKState, Caption.Component.SDK));
        }
        if (adapterState != null) {
            arrayList.add(new Caption(adapterState, Caption.Component.ADAPTER));
        }
        if (manifestState != null) {
            arrayList.add(new Caption(manifestState, Caption.Component.MANIFEST));
        }
        if (adLoadState != null) {
            arrayList.add(new Caption(adLoadState, Caption.Component.AD_LOAD));
        }
        return arrayList;
    }

    @Override // com.google.android.ads.mediationtestsuite.viewmodels.d
    public String getDetailText(Context context) {
        return String.format(context.getString(R.string.gmts_compatible_with_format_ads), getAdapter().getFormat().getDisplayString().toLowerCase(Locale.getDefault()));
    }

    public int getId() {
        return this.id;
    }

    public String getLabel() {
        return this.label;
    }

    public TestResult getLastTestResult() {
        return this.lastTestResult;
    }

    public TestState getManifestState() {
        Network network;
        NetworkAdapter networkAdapter = this.adapter;
        if (networkAdapter == null || (network = networkAdapter.getNetwork()) == null) {
            return null;
        }
        return network.isManifestPresent() ? TestState.OK : TestState.ERROR;
    }

    public TestState getSDKState() {
        Network network;
        NetworkAdapter networkAdapter = this.adapter;
        if (networkAdapter == null || (network = networkAdapter.getNetwork()) == null) {
            return null;
        }
        return network.isSdkPresent() ? TestState.OK : TestState.ERROR;
    }

    public Map<String, String> getServerParameters() {
        return this.serverParameters;
    }

    public TestState getServerParametersState() {
        return this.hasMissingParameters ? TestState.ERROR : TestState.OK;
    }

    public int getSortValue() {
        if (getAdLoadState() == TestState.OK) {
            return 2;
        }
        return isTestable() ? 1 : 0;
    }

    @Override // com.google.android.ads.mediationtestsuite.viewmodels.d
    public String getTitleText(Context context) {
        return getAdapter().getNetworkLabel();
    }

    public boolean isTestable() {
        NetworkAdapter networkAdapter = this.adapter;
        if (networkAdapter == null) {
            return false;
        }
        Network network = networkAdapter.getNetwork();
        if (this.adapter.isAdapterPresent()) {
            return network == null || (network != null && network.isSdkPresent() && network.isManifestPresent());
        }
        return false;
    }

    @Override // com.google.android.ads.mediationtestsuite.dataobjects.Matchable
    public boolean matches(CharSequence charSequence) {
        NetworkAdapter networkAdapter;
        NetworkAdapter networkAdapter2;
        String lowerCase = charSequence.toString().toLowerCase();
        String str = this.label;
        return (str != null && str.toLowerCase().contains(lowerCase)) || ((networkAdapter = this.adapter) != null && networkAdapter.getClassName().toLowerCase().contains(lowerCase)) || ((networkAdapter2 = this.adapter) != null && networkAdapter2.getFormat().getDisplayString().toLowerCase().startsWith(lowerCase));
    }

    public void setAdUnit(AdUnit adUnit) {
        this.adUnitId = new AdUnitId(adUnit.getId(), adUnit.getName());
        this.adUnit = adUnit;
    }

    public void setAdapter(NetworkAdapter networkAdapter) {
        this.adapter = networkAdapter;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setLastTestResult(TestResult testResult) {
        TestResult testResult2 = this.lastTestResult;
        this.lastTestResult = testResult;
        if (testResult2 != this.lastTestResult) {
            DataStore.networkConfigUpdated(this);
        }
        if (testResult == TestResult.SUCCESS) {
            this.adUnit.configPassedTest(Integer.valueOf(this.id));
        } else if (testResult.isFailure()) {
            this.adUnit.configFailedTest(Integer.valueOf(this.id));
        }
    }

    @Override // com.google.android.ads.mediationtestsuite.viewmodels.d
    public boolean shouldEnableCheckbox() {
        return isTestable();
    }

    @Override // com.google.android.ads.mediationtestsuite.viewmodels.d
    public boolean shouldShowCheckbox() {
        return true;
    }

    public boolean testedSuccessfully() {
        return this.lastTestResult == TestResult.SUCCESS;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.label);
        parcel.writeInt(this.lastTestResult.ordinal());
        parcel.writeParcelable(this.adapter, 0);
        parcel.writeInt(this.serverParameters.size());
        for (String str : this.serverParameters.keySet()) {
            parcel.writeString(str);
            parcel.writeString(this.serverParameters.get(str));
        }
        parcel.writeString(this.adUnitId.getId());
        parcel.writeString(this.adUnitId.getName());
    }

    public NetworkConfig(int i, AdFormat adFormat, NetworkResponse networkResponse, Map<String, Map<String, NetworkAdapter>> map) {
        this.hasMissingParameters = false;
        this.id = i;
        this.serverParameters = new HashMap();
        if (networkResponse.hasValidMediationAdapter()) {
            Map<String, String> data = networkResponse.getData();
            if (networkResponse.isCustomEventAdapter()) {
                NetworkAdapter networkAdapter = new NetworkAdapter();
                for (String str : data.keySet()) {
                    String str2 = data.get(str);
                    byte b2 = -1;
                    int iHashCode = str.hashCode();
                    if (iHashCode != -290474766) {
                        if (iHashCode != 102727412) {
                            if (iHashCode == 1954460585 && str.equals(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD)) {
                                b2 = 1;
                            }
                        } else if (str.equals(PlusShare.KEY_CALL_TO_ACTION_LABEL)) {
                            b2 = 2;
                        }
                    } else if (str.equals("class_name")) {
                        b2 = 0;
                    }
                    if (b2 == 0) {
                        networkAdapter.setClassName(str2);
                    } else if (b2 == 1) {
                        this.serverParameters.put(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD, str2);
                    } else if (b2 == 2) {
                        String[] strArrSplit = str2.split("\\.");
                        networkAdapter.setNetworkLabel(String.format(DataStore.getContext().getString(R.string.gmts_ad_source_custom_event_title_format), strArrSplit[strArrSplit.length - 1]));
                        this.label = networkAdapter.getNetworkLabel();
                    }
                }
                networkAdapter.setFormat(adFormat);
                networkAdapter.getServerParameters().put(DataStore.getContext().getString(R.string.gmts_parameter_label), MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD);
                networkAdapter.detectInstallation();
                this.adapter = networkAdapter;
            } else {
                String className = networkResponse.getClassName();
                if (map.get(className) != null) {
                    this.adapter = map.get(className).get(adFormat.getFormatString());
                }
                this.serverParameters = data;
                if (this.adapter != null) {
                    checkMissingParameters();
                    this.label = this.adapter.getNetwork().getName();
                }
            }
            this.lastTestResult = TestResult.UNTESTED;
            if (this.adapter == null || isTestable()) {
                return;
            }
            this.lastTestResult = TestResult.FAILURE_UNABLE_TO_TEST;
        }
    }

    private NetworkConfig(Parcel parcel) {
        this.hasMissingParameters = false;
        this.id = parcel.readInt();
        this.label = parcel.readString();
        this.lastTestResult = TestResult.values()[parcel.readInt()];
        this.adapter = (NetworkAdapter) parcel.readParcelable(NetworkAdapter.class.getClassLoader());
        this.serverParameters = new HashMap();
        int i = parcel.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.serverParameters.put(parcel.readString(), parcel.readString());
        }
        this.adUnitId = new AdUnitId(parcel.readString(), parcel.readString());
    }
}
