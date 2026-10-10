package com.google.android.ads.mediationtestsuite.dataobjects;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.google.android.ads.mediationtestsuite.AdLoadCallback;
import com.google.android.ads.mediationtestsuite.BatchAdRequestCallbacks;
import com.google.android.ads.mediationtestsuite.utils.AdManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BatchAdRequestManager implements AdLoadCallback {
    private final Context context;
    private final List<NetworkConfig> networks;
    private final BatchAdRequestCallbacks tester;
    private final HashMap<NetworkConfig, AdManager> networksToLoaders = new HashMap<>();
    private int testedCount = 0;
    private boolean stopTesting = false;

    public BatchAdRequestManager(Context context, Collection<NetworkConfig> collection, BatchAdRequestCallbacks batchAdRequestCallbacks) {
        this.networks = new ArrayList(collection);
        this.tester = batchAdRequestCallbacks;
        if (context instanceof ContextWrapper) {
            ContextWrapper contextWrapper = (ContextWrapper) context;
            if (contextWrapper.getBaseContext() instanceof Activity) {
                context = contextWrapper.getBaseContext();
            }
        }
        this.context = context;
    }

    private void testNextConfig() {
        if (this.testedCount >= this.networks.size() || this.stopTesting) {
            this.tester.a(this);
            return;
        }
        NetworkConfig networkConfig = this.networks.get(this.testedCount);
        this.testedCount++;
        if (!networkConfig.isTestable()) {
            this.tester.a(this, networkConfig);
            testNextConfig();
            return;
        }
        AdManager adManagerCreateAdLoader = this.networksToLoaders.get(networkConfig);
        if (adManagerCreateAdLoader == null) {
            adManagerCreateAdLoader = networkConfig.getAdapter().getFormat().createAdLoader(networkConfig, this);
            this.networksToLoaders.put(networkConfig, adManagerCreateAdLoader);
        }
        adManagerCreateAdLoader.a(this.context);
    }

    public void beginTesting() {
        this.testedCount = 0;
        this.stopTesting = false;
        testNextConfig();
    }

    public void cancelTesting() {
        this.stopTesting = true;
        Iterator<AdManager> it = this.networksToLoaders.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    @Override // com.google.android.ads.mediationtestsuite.AdLoadCallback
    public void onAdFailedToLoad(AdManager adManager, int i) {
        testNextConfig();
    }

    @Override // com.google.android.ads.mediationtestsuite.AdLoadCallback
    public void onAdLoaded(AdManager adManager) {
        testNextConfig();
    }
}
