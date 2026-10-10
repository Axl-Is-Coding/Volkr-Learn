package com.google.android.ads.mediationtestsuite.utils;

import android.content.Context;
import android.util.Log;
import com.android.volley.m;
import com.google.android.ads.mediationtestsuite.dataobjects.AdFormat;
import com.google.android.ads.mediationtestsuite.dataobjects.AdUnit;
import com.google.android.ads.mediationtestsuite.dataobjects.AdUnitResponse;
import com.google.android.ads.mediationtestsuite.dataobjects.CLDResponse;
import com.google.android.ads.mediationtestsuite.dataobjects.ConfigResponse;
import com.google.android.ads.mediationtestsuite.dataobjects.DataStore;
import com.google.android.ads.mediationtestsuite.dataobjects.Network;
import com.google.android.ads.mediationtestsuite.dataobjects.NetworkAdapter;
import com.google.android.ads.mediationtestsuite.dataobjects.NetworkConfig;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: MediationConfigClient.java */
/* JADX INFO: loaded from: classes.dex */
public class m {
    public static void a(m.b<ConfigResponse> bVar, m.a aVar) throws IOException {
        String str = String.format(Locale.getDefault(), "https://googleads.g.doubleclick.net/getconfig/pubsetting?client=%1$s&admob_appcc=%2$s&expflags=eventfe_enable_pubindexing_based_config_loading:true", DataStore.getAppId().substring(0, 27), DataStore.getAppId().substring(28));
        com.android.volley.l lVarA = com.android.volley.toolbox.s.a(DataStore.getContext());
        Map<String, Network> mapA = a(DataStore.getContext());
        lVarA.a(new com.android.volley.toolbox.m(0, str, null, new i(a(DataStore.getContext(), mapA), mapA, bVar), aVar));
    }

    public static List<AdUnit> a(JSONObject jSONObject, Map<String, Map<String, NetworkAdapter>> map) {
        ArrayList arrayList = new ArrayList();
        com.google.gson.j jVarA = a();
        Type type = new j().getType();
        Log.d("gma_test", jSONObject.toString());
        CLDResponse cLDResponse = (CLDResponse) jVarA.a(jSONObject.toString(), type);
        if (cLDResponse == null) {
            return null;
        }
        int size = 1;
        Iterator<AdUnitResponse> it = cLDResponse.getAdUnitSettings().iterator();
        while (it.hasNext()) {
            AdUnit adUnit = new AdUnit(size, it.next(), map);
            if (!adUnit.getNetworkConfigs().isEmpty()) {
                arrayList.add(adUnit);
            }
            size += adUnit.getNetworkConfigs().size();
        }
        return arrayList;
    }

    public static Map<String, Network> a(Context context) throws IOException {
        List<Network> list = (List) a().a(a(context, "networks.json"), new k().getType());
        HashMap map = new HashMap();
        for (Network network : list) {
            network.detectInstallation();
            map.put(network.getName(), network);
        }
        return map;
    }

    public static Map<String, Map<String, NetworkAdapter>> a(Context context, Map<String, Network> map) throws IOException {
        HashMap map2 = new HashMap();
        for (NetworkAdapter networkAdapter : (List) a().a(a(context, "adapters.json"), new l().getType())) {
            networkAdapter.setNetwork(map.get(networkAdapter.getNetworkLabel()));
            networkAdapter.detectInstallation();
            if (!map2.containsKey(networkAdapter.getClassName())) {
                map2.put(networkAdapter.getClassName(), new HashMap());
            }
            ((Map) map2.get(networkAdapter.getClassName())).put(networkAdapter.getFormat().getFormatString(), networkAdapter);
        }
        return map2;
    }

    public static String a(Context context, String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStream inputStreamOpen = context.getAssets().open(str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, "UTF-8"));
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                sb.append(line);
                sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            } else {
                inputStreamOpen.close();
                bufferedReader.close();
                return sb.toString();
            }
        }
    }

    public static void a(Context context, List<Network> list, List<AdUnit> list2) {
        d.a(context);
        for (AdUnit adUnit : list2) {
            for (NetworkConfig networkConfig : adUnit.getNetworkConfigs()) {
                int iIndexOf = list.indexOf(networkConfig.getAdapter().getNetwork());
                if (iIndexOf >= 0) {
                    list.get(iIndexOf).addConfig(networkConfig);
                }
                networkConfig.setAdUnit(adUnit);
            }
        }
    }

    public static com.google.gson.j a() {
        com.google.gson.k kVar = new com.google.gson.k();
        kVar.a(AdFormat.class, new AdFormatSerializer());
        return kVar.a();
    }
}
