package com.google.android.ads.mediationtestsuite;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.ads.mediationtestsuite.activities.HomeActivity;
import com.google.android.ads.mediationtestsuite.dataobjects.AdFormat;
import com.google.android.ads.mediationtestsuite.utils.c;
import com.google.android.ads.mediationtestsuite.utils.d;
import com.google.android.ads.mediationtestsuite.utils.logging.a;
import com.google.android.ads.mediationtestsuite.utils.logging.e;
import com.google.android.ads.mediationtestsuite.utils.logging.g;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MediationTestSuite {
    private static final MediationTestSuite instance = new MediationTestSuite();
    private MediationTestSuiteListener listener;
    private final Set<String> testDevices = new HashSet();
    private AdRequest testRequest;

    private MediationTestSuite() {
    }

    public static void addTestDevice(String str) {
        instance.testDevices.add(str);
    }

    public static MediationTestSuiteListener getListener() {
        return instance.listener;
    }

    public static Set<String> getTestDevices() {
        return instance.testDevices;
    }

    public static AdRequest getTestRequest() {
        return instance.testRequest;
    }

    public static void launch(Context context, String str) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Iterator<String> it = instance.testDevices.iterator();
        while (it.hasNext()) {
            builder.addTestDevice(it.next());
        }
        if (!d.b(context) && !builder.build().isTestDevice(context)) {
            Log.d("gma_test", context.getString(R.string.gmts_log_text_device_not_registered));
            loadTestAdToLogDeviceHash(context);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) HomeActivity.class);
        intent.putExtra("app_id", str);
        g.f().a(str);
        e.a(new a(), context);
        context.startActivity(intent);
    }

    private static void loadTestAdToLogDeviceHash(Context context) {
        AdView adView = new AdView(context);
        adView.setAdUnitId(c.a(AdFormat.BANNER));
        adView.setAdSize(AdSize.BANNER);
        adView.loadAd(new AdRequest.Builder().build());
    }

    public static void setAdRequest(AdRequest adRequest) {
        instance.testRequest = adRequest;
    }

    public static void setListener(MediationTestSuiteListener mediationTestSuiteListener) {
        instance.listener = mediationTestSuiteListener;
    }

    static void setUserAgentSuffix(String str) {
        g.f().b(str);
    }
}
