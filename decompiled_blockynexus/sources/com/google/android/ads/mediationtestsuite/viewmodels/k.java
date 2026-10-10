package com.google.android.ads.mediationtestsuite.viewmodels;

import android.content.Context;
import com.google.android.ads.mediationtestsuite.R;
import com.google.android.ads.mediationtestsuite.dataobjects.AdUnit;
import com.google.android.ads.mediationtestsuite.dataobjects.DataStore;
import com.google.android.ads.mediationtestsuite.dataobjects.NetworkConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ViewModelFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    public static List<ListItemViewModel> a(AdUnit adUnit, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (!z) {
            f fVar = new f(R.drawable.gmts_quantum_ic_info_white_24, R.string.gmts_section_ad_unit_info);
            Context context = DataStore.getContext();
            String string = context.getString(R.string.gmts_ad_unit_id);
            String string2 = context.getString(R.string.gmts_format);
            g gVar = new g(string, adUnit.getId());
            g gVar2 = new g(string2, adUnit.getFormatForDisplay());
            arrayList.add(fVar);
            arrayList.add(gVar);
            arrayList.add(gVar2);
        }
        arrayList.add(new f(R.drawable.gmts_ad_sources_icon, R.string.gmts_section_ad_sources));
        List<NetworkConfig> networkConfigs = adUnit.getNetworkConfigs();
        Collections.sort(networkConfigs, NetworkConfig.sortComparator());
        arrayList.addAll(networkConfigs);
        return arrayList;
    }

    public static List<ListItemViewModel> a(NetworkConfig networkConfig) {
        TestState testState;
        ArrayList arrayList = new ArrayList();
        Context context = DataStore.getContext();
        arrayList.add(new f(R.drawable.gmts_quantum_ic_sdk_white_24, R.string.gmts_section_implementation));
        if (networkConfig.getAdapter().getNetwork() != null) {
            TestState sDKState = networkConfig.getSDKState();
            arrayList.add(new g(context.getString(R.string.gmts_sdk), context.getString(sDKState.getExistenceMessageResId()), sDKState));
        }
        TestState adapterState = networkConfig.getAdapterState();
        if (adapterState != null) {
            arrayList.add(new g(context.getString(R.string.gmts_adapter), context.getString(adapterState.getExistenceMessageResId()), adapterState));
        }
        TestState manifestState = networkConfig.getManifestState();
        if (manifestState != null) {
            arrayList.add(new g(context.getString(R.string.gmts_manifest), context.getString(manifestState.getExistenceMessageResId()), manifestState));
        }
        Map<String, String> serverParameters = networkConfig.getAdapter().getServerParameters();
        if (!serverParameters.keySet().isEmpty()) {
            arrayList.add(new f(R.drawable.gmts_ad_sources_icon, R.string.gmts_section_ad_source_configuration));
            for (String str : serverParameters.keySet()) {
                if (networkConfig.getServerParameters().get(serverParameters.get(str)) != null) {
                    testState = TestState.OK;
                } else {
                    testState = TestState.ERROR;
                }
                arrayList.add(new g(str, context.getString(testState.getExistenceMessageResId()), testState));
            }
        }
        f fVar = new f(R.drawable.gmts_quantum_ic_progress_activity_white_24, R.string.gmts_ad_load);
        c cVar = new c(networkConfig);
        arrayList.add(fVar);
        arrayList.add(cVar);
        return arrayList;
    }

    public static List<ListItemViewModel> a(List<AdUnit> list) {
        if (list.isEmpty()) {
            f fVar = new f(-1, R.string.gmts_no_ad_units_found);
            ArrayList arrayList = new ArrayList();
            arrayList.add(fVar);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (AdUnit adUnit : list) {
            if (adUnit.hasConfigsMissingComponents()) {
                arrayList2.add(adUnit);
            } else if (adUnit.hasAllConfigsPassingForOneFormat()) {
                arrayList4.add(adUnit);
            } else {
                arrayList3.add(adUnit);
            }
        }
        f fVar2 = new f(R.drawable.gmts_quantum_ic_settings_input_component_white_24, R.string.gmts_section_missing_components);
        f fVar3 = new f(R.drawable.gmts_quantum_ic_signal_wifi_off_white_24, R.string.gmts_section_configuration_errors);
        f fVar4 = new f(R.drawable.gmts_quantum_ic_check_circle_white_24, R.string.gmts_section_working);
        ArrayList arrayList5 = new ArrayList();
        if (!arrayList2.isEmpty()) {
            arrayList5.add(fVar2);
            arrayList5.addAll(arrayList2);
        }
        if (!arrayList3.isEmpty()) {
            arrayList5.add(fVar3);
            arrayList5.addAll(arrayList3);
        }
        if (!arrayList4.isEmpty()) {
            arrayList5.add(fVar4);
            arrayList5.addAll(arrayList4);
        }
        return arrayList5;
    }
}
