package com.google.android.ads.mediationtestsuite.dataobjects;

import android.content.Context;
import com.google.android.ads.mediationtestsuite.R;
import com.google.android.ads.mediationtestsuite.dataobjects.Caption;
import com.google.android.ads.mediationtestsuite.viewmodels.TestState;
import com.google.android.ads.mediationtestsuite.viewmodels.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class AdUnit extends d implements Matchable {
    public static final String CUSTOM_EVENT_ADAPTER_CLASS = "com.google.ads.mediation.customevent.CustomEventAdapter";
    public static final String GOOGLE_ADAPTER_CLASS = "com.google.ads.mediation.admob.AdMobAdapter";
    private AdUnitId adUnitId;
    private Map<Integer, NetworkConfig> configIdToConfig;
    private Map<AdFormat, List<NetworkConfig>> configsPerFormat;
    private Map<AdFormat, Set<NetworkConfig>> failedTestsPerFormat;
    private AdFormat format;
    private String id;
    private String mediationGroup;
    private String name;
    private List<NetworkConfig> networkConfigs;
    private int numMissingAdapter;
    private int numMissingManifest;
    private int numMissingSDK;
    private Map<AdFormat, Set<NetworkConfig>> passedTestsPerFormat;
    private List<AdFormat> supportedFormats;

    public AdUnit() {
        this.numMissingSDK = 0;
        this.numMissingAdapter = 0;
        this.numMissingManifest = 0;
        this.networkConfigs = new ArrayList();
    }

    private void updateConfigAndAdapter(Integer num) {
        NetworkConfig networkConfig = this.configIdToConfig.get(num);
        NetworkAdapter adapter = networkConfig.getAdapter();
        Network network = adapter.getNetwork();
        TestResult lastTestResult = networkConfig.getLastTestResult();
        if (!adapter.isAdapterPresent()) {
            this.numMissingAdapter++;
        }
        if (network != null && !network.isSdkPresent()) {
            this.numMissingSDK++;
        }
        if (network != null && !network.isManifestPresent()) {
            this.numMissingManifest++;
        }
        AdFormat format = adapter.getFormat();
        if (lastTestResult == TestResult.SUCCESS && !this.passedTestsPerFormat.get(format).contains(networkConfig)) {
            this.passedTestsPerFormat.get(format).add(networkConfig);
        }
        if (!lastTestResult.isFailure() || this.failedTestsPerFormat.get(format).contains(networkConfig)) {
            return;
        }
        this.failedTestsPerFormat.get(format).add(networkConfig);
    }

    public void configFailedTest(Integer num) {
        NetworkConfig networkConfig = this.configIdToConfig.get(num);
        AdFormat format = networkConfig.getAdapter().getFormat();
        this.passedTestsPerFormat.get(format).remove(networkConfig);
        this.failedTestsPerFormat.get(format).add(networkConfig);
        if (hasFailureForAllSupportedFormats()) {
            DataStore.adUnitFailed(this);
        }
    }

    public void configPassedTest(Integer num) {
        NetworkConfig networkConfig = this.configIdToConfig.get(num);
        AdFormat format = networkConfig.getAdapter().getFormat();
        this.passedTestsPerFormat.get(format).add(networkConfig);
        this.failedTestsPerFormat.get(format).remove(networkConfig);
        if (hasAllConfigsPassingForOneFormat()) {
            DataStore.adUnitWorked(this);
        }
    }

    @Override // com.google.android.ads.mediationtestsuite.viewmodels.d
    public List<Caption> getCaptions() {
        TestState testState = TestState.OK;
        TestState testState2 = TestState.WARNING;
        TestState testState3 = this.numMissingSDK > 0 ? TestState.ERROR : testState;
        TestState testState4 = this.numMissingManifest > 0 ? TestState.ERROR : testState;
        if (this.numMissingAdapter > 0) {
            testState = TestState.ERROR;
        }
        TestState testState5 = TestState.ERROR;
        if (testState3 == testState5 || testState4 == testState5 || testState == testState5) {
            testState2 = null;
        } else if (hasFailureForAllSupportedFormats()) {
            testState2 = TestState.ERROR;
        } else if (hasAllConfigsPassingForOneFormat()) {
            testState2 = TestState.OK;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Caption(testState3, Caption.Component.SDK));
        arrayList.add(new Caption(testState, Caption.Component.ADAPTER));
        arrayList.add(new Caption(testState4, Caption.Component.MANIFEST));
        if (testState2 != null) {
            arrayList.add(new Caption(testState2, Caption.Component.AD_LOAD));
        }
        return arrayList;
    }

    @Override // com.google.android.ads.mediationtestsuite.viewmodels.d
    public String getDetailText(Context context) {
        return String.format(context.getString(R.string.gmts_ad_unit_format_label_format), getFormatForDisplay());
    }

    public AdFormat getFormat() {
        return this.format;
    }

    public String getFormatForDisplay() {
        return this.format.getDisplayString();
    }

    public String getId() {
        return this.id;
    }

    public String getMediationGroup() {
        return this.mediationGroup;
    }

    public String getName() {
        return this.name;
    }

    public List<NetworkConfig> getNetworkConfigs() {
        return this.networkConfigs;
    }

    public String getPubId() {
        return this.adUnitId.getPubId();
    }

    public String getSlotId() {
        return this.adUnitId.getSlotId();
    }

    public String getTitle() {
        return this.adUnitId.getTitle();
    }

    @Override // com.google.android.ads.mediationtestsuite.viewmodels.d
    public String getTitleText(Context context) {
        return getTitle();
    }

    public boolean hasAllConfigsPassingForOneFormat() {
        if (hasConfigsMissingComponents()) {
            return false;
        }
        for (AdFormat adFormat : this.configsPerFormat.keySet()) {
            Set<NetworkConfig> set = this.passedTestsPerFormat.get(adFormat);
            List<NetworkConfig> list = this.configsPerFormat.get(adFormat);
            if (set != null && list != null && set.size() == list.size()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasConfigsMissingComponents() {
        return this.numMissingAdapter > 0 || this.numMissingManifest > 0 || this.numMissingSDK > 0;
    }

    public boolean hasFailureForAllSupportedFormats() {
        Iterator<AdFormat> it = this.supportedFormats.iterator();
        while (it.hasNext()) {
            if (this.failedTestsPerFormat.get(it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.ads.mediationtestsuite.dataobjects.Matchable
    public boolean matches(CharSequence charSequence) {
        String lowerCase = charSequence.toString().toLowerCase();
        if ((getName() != null && getName().toLowerCase().contains(lowerCase)) || this.format.getDisplayString().toLowerCase(Locale.getDefault()).startsWith(lowerCase) || getSlotId().toLowerCase().startsWith(lowerCase) || (getMediationGroup() != null && getMediationGroup().contains(lowerCase))) {
            return true;
        }
        Iterator<NetworkConfig> it = getNetworkConfigs().iterator();
        while (it.hasNext()) {
            if (it.next().matches(lowerCase)) {
                return true;
            }
        }
        return false;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMediationGroup(String str) {
        this.mediationGroup = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    @Override // com.google.android.ads.mediationtestsuite.viewmodels.d
    public boolean shouldShowCheckbox() {
        return false;
    }

    public void updateConfigsAndAdapters() {
        this.numMissingAdapter = 0;
        this.numMissingSDK = 0;
        this.numMissingManifest = 0;
        this.configIdToConfig.clear();
        for (AdFormat adFormat : this.supportedFormats) {
            this.passedTestsPerFormat.get(adFormat).clear();
            this.failedTestsPerFormat.get(adFormat).clear();
        }
        for (NetworkConfig networkConfig : this.networkConfigs) {
            this.configIdToConfig.put(Integer.valueOf(networkConfig.getId()), networkConfig);
            updateConfigAndAdapter(Integer.valueOf(networkConfig.getId()));
        }
    }

    public AdUnit(int i, AdUnitResponse adUnitResponse, Map<String, Map<String, NetworkAdapter>> map) {
        this.numMissingSDK = 0;
        this.numMissingAdapter = 0;
        this.numMissingManifest = 0;
        this.configIdToConfig = new HashMap();
        this.configsPerFormat = new HashMap();
        this.passedTestsPerFormat = new HashMap();
        this.failedTestsPerFormat = new HashMap();
        this.id = adUnitResponse.getAdUnitId();
        this.name = adUnitResponse.getAdUnitName();
        this.adUnitId = new AdUnitId(this.id, this.name);
        this.format = adUnitResponse.getFormat();
        this.networkConfigs = new ArrayList();
        this.supportedFormats = new ArrayList();
        if (getFormat() == AdFormat.BANNER_INTERSTITIAL) {
            this.supportedFormats.add(AdFormat.BANNER);
            this.supportedFormats.add(AdFormat.INTERSTITIAL);
        } else {
            this.supportedFormats.add(getFormat());
        }
        for (AdFormat adFormat : this.supportedFormats) {
            this.configsPerFormat.put(adFormat, new ArrayList());
            this.passedTestsPerFormat.put(adFormat, new HashSet());
            this.failedTestsPerFormat.put(adFormat, new HashSet());
        }
        MediationConfig mediationConfig = adUnitResponse.getMediationConfig();
        if (mediationConfig == null || this.format == AdFormat.UNKNOWN) {
            return;
        }
        this.mediationGroup = mediationConfig.getMediationGroupName();
        List<NetworkResponse> adNetworks = mediationConfig.getAdNetworks();
        if (adNetworks == null) {
            return;
        }
        for (AdFormat adFormat2 : this.supportedFormats) {
            Iterator<NetworkResponse> it = adNetworks.iterator();
            boolean z = false;
            while (it.hasNext()) {
                NetworkConfig networkConfig = new NetworkConfig(i, adFormat2, it.next(), map);
                if (networkConfig.getAdapter() != null) {
                    if (GOOGLE_ADAPTER_CLASS.equals(networkConfig.getAdapter().getClassName())) {
                        if (!z) {
                            z = true;
                        }
                    }
                    this.networkConfigs.add(networkConfig);
                    this.configsPerFormat.get(adFormat2).add(networkConfig);
                    this.configIdToConfig.put(Integer.valueOf(networkConfig.getId()), networkConfig);
                    updateConfigAndAdapter(Integer.valueOf(networkConfig.getId()));
                    i++;
                }
            }
        }
    }
}
