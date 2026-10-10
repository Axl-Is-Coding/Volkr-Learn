package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.android.billingclient.BuildConfig;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.util.BillingHelper;
import com.android.vending.billing.IInAppBillingService;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
class BillingClientImpl extends BillingClient {
    private static final long ASYNCHRONOUS_TIMEOUT_IN_MILLISECONDS = 30000;
    private static final String GET_SKU_DETAILS_ITEM_LIST = "ITEM_ID_LIST";
    private static final int MAX_IAP_VERSION = 10;
    private static final int MAX_SKU_DETAILS_ITEMS_PER_REQUEST = 20;
    private static final int MIN_IAP_VERSION = 3;
    private static final long SYNCHRONOUS_TIMEOUT_IN_MILLISECONDS = 5000;
    private static final String TAG = "BillingClient";
    private final Context mApplicationContext;
    private final BillingBroadcastManager mBroadcastManager;
    private final int mChildDirected;
    private int mClientState;
    private final boolean mEnablePendingPurchases;
    private ExecutorService mExecutorService;
    private boolean mIABv10Supported;
    private boolean mIABv6Supported;
    private boolean mIABv8Supported;
    private boolean mIABv9Supported;
    private final String mQualifiedVersionNumber;
    private IInAppBillingService mService;
    private BillingServiceConnection mServiceConnection;
    private boolean mSubscriptionUpdateSupported;
    private boolean mSubscriptionsSupported;
    private final Handler mUiThreadHandler;
    private final int mUnderAgeOfConsent;
    private final ResultReceiver onPurchaseFinishedReceiver;

    private final class BillingServiceConnection implements ServiceConnection {
        private boolean disconnected;
        private final Object lock;
        private BillingClientStateListener mListener;

        /* JADX INFO: Access modifiers changed from: private */
        public void notifySetupResult(final BillingResult billingResult) {
            BillingClientImpl.this.postToUiThread(new Runnable() { // from class: com.android.billingclient.api.BillingClientImpl.BillingServiceConnection.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (BillingServiceConnection.this.lock) {
                        if (BillingServiceConnection.this.mListener != null) {
                            BillingServiceConnection.this.mListener.onBillingSetupFinished(billingResult);
                        }
                    }
                }
            });
        }

        void markDisconnectedAndCleanUp() {
            synchronized (this.lock) {
                this.mListener = null;
                this.disconnected = true;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BillingHelper.logVerbose(BillingClientImpl.TAG, "Billing service connected.");
            BillingClientImpl.this.mService = IInAppBillingService.Stub.asInterface(iBinder);
            if (BillingClientImpl.this.executeAsync(new Callable<Void>() { // from class: com.android.billingclient.api.BillingClientImpl.BillingServiceConnection.2
                @Override // java.util.concurrent.Callable
                public Void call() {
                    int iIsBillingSupported;
                    synchronized (BillingServiceConnection.this.lock) {
                        if (BillingServiceConnection.this.disconnected) {
                            return null;
                        }
                        try {
                            String packageName = BillingClientImpl.this.mApplicationContext.getPackageName();
                            int i = 10;
                            iIsBillingSupported = 3;
                            while (true) {
                                if (i < 3) {
                                    i = 0;
                                    break;
                                }
                                try {
                                    iIsBillingSupported = BillingClientImpl.this.mService.isBillingSupported(i, packageName, BillingClient.SkuType.SUBS);
                                    if (iIsBillingSupported == 0) {
                                        break;
                                    }
                                    i--;
                                } catch (Exception unused) {
                                    BillingHelper.logWarn(BillingClientImpl.TAG, "Exception while checking if billing is supported; try to reconnect");
                                    BillingClientImpl.this.mClientState = 0;
                                    BillingClientImpl.this.mService = null;
                                }
                            }
                            boolean z = true;
                            BillingClientImpl.this.mSubscriptionUpdateSupported = i >= 5;
                            BillingClientImpl.this.mSubscriptionsSupported = i >= 3;
                            if (i < 3) {
                                BillingHelper.logVerbose(BillingClientImpl.TAG, "In-app billing API does not support subscription on this device.");
                            }
                            int i2 = 10;
                            while (true) {
                                if (i2 < 3) {
                                    i2 = 0;
                                    break;
                                }
                                iIsBillingSupported = BillingClientImpl.this.mService.isBillingSupported(i2, packageName, BillingClient.SkuType.INAPP);
                                if (iIsBillingSupported == 0) {
                                    break;
                                }
                                i2--;
                            }
                            BillingClientImpl.this.mIABv10Supported = i2 >= 10;
                            BillingClientImpl.this.mIABv9Supported = i2 >= 9;
                            BillingClientImpl.this.mIABv8Supported = i2 >= 8;
                            BillingClientImpl billingClientImpl = BillingClientImpl.this;
                            if (i2 < 6) {
                                z = false;
                            }
                            billingClientImpl.mIABv6Supported = z;
                            if (i2 < 3) {
                                BillingHelper.logWarn(BillingClientImpl.TAG, "In-app billing API version 3 is not supported on this device.");
                            }
                            if (iIsBillingSupported == 0) {
                                BillingClientImpl.this.mClientState = 2;
                            } else {
                                BillingClientImpl.this.mClientState = 0;
                                BillingClientImpl.this.mService = null;
                            }
                        } catch (Exception unused2) {
                            iIsBillingSupported = 3;
                        }
                        if (iIsBillingSupported == 0) {
                            BillingServiceConnection.this.notifySetupResult(BillingResults.OK);
                        } else {
                            BillingServiceConnection.this.notifySetupResult(BillingResults.API_VERSION_NOT_V3);
                        }
                        return null;
                    }
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.BillingClientImpl.BillingServiceConnection.3
                @Override // java.lang.Runnable
                public void run() {
                    BillingClientImpl.this.mClientState = 0;
                    BillingClientImpl.this.mService = null;
                    BillingServiceConnection.this.notifySetupResult(BillingResults.SERVICE_TIMEOUT);
                }
            }) == null) {
                notifySetupResult(BillingClientImpl.this.getBillingResultForNullFutureResult());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            BillingHelper.logWarn(BillingClientImpl.TAG, "Billing service disconnected.");
            BillingClientImpl.this.mService = null;
            BillingClientImpl.this.mClientState = 0;
            synchronized (this.lock) {
                if (this.mListener != null) {
                    this.mListener.onBillingServiceDisconnected();
                }
            }
        }

        private BillingServiceConnection(BillingClientStateListener billingClientStateListener) {
            this.lock = new Object();
            this.disconnected = false;
            this.mListener = billingClientStateListener;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ClientState {
        public static final int CLOSED = 3;
        public static final int CONNECTED = 2;
        public static final int CONNECTING = 1;
        public static final int DISCONNECTED = 0;
    }

    private static class PurchaseHistoryResult {
        private BillingResult mBillingResult;
        private List<PurchaseHistoryRecord> mPurchaseHistoryRecordList;

        PurchaseHistoryResult(BillingResult billingResult, List<PurchaseHistoryRecord> list) {
            this.mPurchaseHistoryRecordList = list;
            this.mBillingResult = billingResult;
        }

        BillingResult getBillingResult() {
            return this.mBillingResult;
        }

        List<PurchaseHistoryRecord> getPurchaseHistoryRecordList() {
            return this.mPurchaseHistoryRecordList;
        }
    }

    BillingClientImpl(Context context, int i, int i2, boolean z, PurchasesUpdatedListener purchasesUpdatedListener) {
        this(context, i, i2, z, purchasesUpdatedListener, BuildConfig.VERSION_NAME);
    }

    private BillingResult broadcastFailureAndReturnBillingResponse(BillingResult billingResult) {
        this.mBroadcastManager.getListener().onPurchasesUpdated(billingResult, null);
        return billingResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void consumeInternal(ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        final int iConsumePurchase;
        String debugMessageFromBundle;
        final String purchaseToken = consumeParams.getPurchaseToken();
        try {
            BillingHelper.logVerbose(TAG, "Consuming purchase with token: " + purchaseToken);
            if (this.mIABv9Supported) {
                Bundle bundleConsumePurchaseExtraParams = this.mService.consumePurchaseExtraParams(9, this.mApplicationContext.getPackageName(), purchaseToken, BillingHelper.constructExtraParamsForConsume(consumeParams, this.mIABv9Supported, this.mQualifiedVersionNumber));
                int i = bundleConsumePurchaseExtraParams.getInt(BillingHelper.RESPONSE_CODE);
                debugMessageFromBundle = BillingHelper.getDebugMessageFromBundle(bundleConsumePurchaseExtraParams, TAG);
                iConsumePurchase = i;
            } else {
                iConsumePurchase = this.mService.consumePurchase(3, this.mApplicationContext.getPackageName(), purchaseToken);
                debugMessageFromBundle = "";
            }
            final BillingResult billingResultBuild = BillingResult.newBuilder().setResponseCode(iConsumePurchase).setDebugMessage(debugMessageFromBundle).build();
            if (iConsumePurchase == 0) {
                postToUiThread(new Runnable() { // from class: com.android.billingclient.api.BillingClientImpl.22
                    @Override // java.lang.Runnable
                    public void run() {
                        BillingHelper.logVerbose(BillingClientImpl.TAG, "Successfully consumed purchase.");
                        consumeResponseListener.onConsumeResponse(billingResultBuild, purchaseToken);
                    }
                });
            } else {
                postToUiThread(new Runnable() { // from class: com.android.billingclient.api.BillingClientImpl.23
                    @Override // java.lang.Runnable
                    public void run() {
                        BillingHelper.logWarn(BillingClientImpl.TAG, "Error consuming purchase with token. Response code: " + iConsumePurchase);
                        consumeResponseListener.onConsumeResponse(billingResultBuild, purchaseToken);
                    }
                });
            }
        } catch (Exception e2) {
            postToUiThread(new Runnable() { // from class: com.android.billingclient.api.BillingClientImpl.24
                @Override // java.lang.Runnable
                public void run() {
                    BillingHelper.logWarn(BillingClientImpl.TAG, "Error consuming purchase; ex: " + e2);
                    consumeResponseListener.onConsumeResponse(BillingResults.SERVICE_DISCONNECTED, purchaseToken);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> Future<T> executeAsync(Callable<T> callable, long j, final Runnable runnable) {
        double d2 = j;
        Double.isNaN(d2);
        long j2 = (long) (d2 * 0.95d);
        if (this.mExecutorService == null) {
            this.mExecutorService = Executors.newFixedThreadPool(BillingHelper.NUMBER_OF_CORES);
        }
        try {
            final Future<T> futureSubmit = this.mExecutorService.submit(callable);
            this.mUiThreadHandler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.BillingClientImpl.20
                @Override // java.lang.Runnable
                public void run() {
                    if (futureSubmit.isDone() || futureSubmit.isCancelled()) {
                        return;
                    }
                    futureSubmit.cancel(true);
                    BillingHelper.logWarn(BillingClientImpl.TAG, "Async task is taking too long, cancel it!");
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, j2);
            return futureSubmit;
        } catch (Exception e2) {
            BillingHelper.logWarn(TAG, "Async task throws exception " + e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle generateVrBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(BillingFlowParams.EXTRA_PARAM_KEY_VR, true);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BillingResult getBillingResultForNullFutureResult() {
        int i = this.mClientState;
        return (i == 0 || i == 3) ? BillingResults.SERVICE_DISCONNECTED : BillingResults.INTERNAL_ERROR;
    }

    private BillingResult isBillingSupportedOnVr(final String str) {
        try {
            return ((Integer) executeAsync(new Callable<Integer>() { // from class: com.android.billingclient.api.BillingClientImpl.21
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(BillingClientImpl.this.mService.isBillingSupportedExtraParams(7, BillingClientImpl.this.mApplicationContext.getPackageName(), str, BillingClientImpl.this.generateVrBundle()));
                }
            }, SYNCHRONOUS_TIMEOUT_IN_MILLISECONDS, null).get(SYNCHRONOUS_TIMEOUT_IN_MILLISECONDS, TimeUnit.MILLISECONDS)).intValue() == 0 ? BillingResults.OK : BillingResults.FEATURE_NOT_SUPPORTED;
        } catch (Exception unused) {
            BillingHelper.logWarn(TAG, "Exception while checking if billing is supported; try to reconnect");
            return BillingResults.SERVICE_DISCONNECTED;
        }
    }

    private int launchBillingFlowCpp(Activity activity, BillingFlowParams billingFlowParams) {
        return launchBillingFlow(activity, billingFlowParams).getResponseCode();
    }

    private void launchPriceChangeConfirmationFlow(Activity activity, PriceChangeFlowParams priceChangeFlowParams, long j) {
        launchPriceChangeConfirmationFlow(activity, priceChangeFlowParams, new BillingClientNativeCallback(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postToUiThread(Runnable runnable) {
        if (Thread.interrupted()) {
            return;
        }
        this.mUiThreadHandler.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PurchaseHistoryResult queryPurchaseHistoryInternal(String str) {
        BillingHelper.logVerbose(TAG, "Querying purchase history, item type: " + str);
        ArrayList arrayList = new ArrayList();
        Bundle bundleConstructExtraParamsForQueryPurchases = BillingHelper.constructExtraParamsForQueryPurchases(this.mIABv9Supported, this.mEnablePendingPurchases, this.mQualifiedVersionNumber);
        String string = null;
        while (this.mIABv6Supported) {
            try {
                Bundle purchaseHistory = this.mService.getPurchaseHistory(6, this.mApplicationContext.getPackageName(), str, string, bundleConstructExtraParamsForQueryPurchases);
                BillingResult billingResultCheckPurchasesBundleValidity = PurchaseApiResponseChecker.checkPurchasesBundleValidity(purchaseHistory, TAG, "getPurchaseHistory()");
                if (billingResultCheckPurchasesBundleValidity != BillingResults.OK) {
                    return new PurchaseHistoryResult(billingResultCheckPurchasesBundleValidity, null);
                }
                ArrayList<String> stringArrayList = purchaseHistory.getStringArrayList(BillingHelper.RESPONSE_INAPP_ITEM_LIST);
                ArrayList<String> stringArrayList2 = purchaseHistory.getStringArrayList(BillingHelper.RESPONSE_INAPP_PURCHASE_DATA_LIST);
                ArrayList<String> stringArrayList3 = purchaseHistory.getStringArrayList(BillingHelper.RESPONSE_INAPP_SIGNATURE_LIST);
                for (int i = 0; i < stringArrayList2.size(); i++) {
                    String str2 = stringArrayList2.get(i);
                    String str3 = stringArrayList3.get(i);
                    BillingHelper.logVerbose(TAG, "Purchase record found for sku : " + stringArrayList.get(i));
                    try {
                        PurchaseHistoryRecord purchaseHistoryRecord = new PurchaseHistoryRecord(str2, str3);
                        if (TextUtils.isEmpty(purchaseHistoryRecord.getPurchaseToken())) {
                            BillingHelper.logWarn(TAG, "BUG: empty/null token!");
                        }
                        arrayList.add(purchaseHistoryRecord);
                    } catch (JSONException e2) {
                        BillingHelper.logWarn(TAG, "Got an exception trying to decode the purchase: " + e2);
                        return new PurchaseHistoryResult(BillingResults.INTERNAL_ERROR, null);
                    }
                }
                string = purchaseHistory.getString(BillingHelper.INAPP_CONTINUATION_TOKEN);
                BillingHelper.logVerbose(TAG, "Continuation token: " + string);
                if (TextUtils.isEmpty(string)) {
                    return new PurchaseHistoryResult(BillingResults.OK, arrayList);
                }
            } catch (RemoteException e3) {
                BillingHelper.logWarn(TAG, "Got exception trying to get purchase history: " + e3 + "; try to reconnect");
                return new PurchaseHistoryResult(BillingResults.SERVICE_DISCONNECTED, null);
            }
        }
        BillingHelper.logWarn(TAG, "getPurchaseHistory is not supported on current device");
        return new PurchaseHistoryResult(BillingResults.GET_PURCHASE_HISTORY_NOT_SUPPORTED, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Purchase.PurchasesResult queryPurchasesInternal(String str) {
        BillingHelper.logVerbose(TAG, "Querying owned items, item type: " + str);
        ArrayList arrayList = new ArrayList();
        Bundle bundleConstructExtraParamsForQueryPurchases = BillingHelper.constructExtraParamsForQueryPurchases(this.mIABv9Supported, this.mEnablePendingPurchases, this.mQualifiedVersionNumber);
        String string = null;
        do {
            try {
                Bundle purchasesExtraParams = this.mIABv9Supported ? this.mService.getPurchasesExtraParams(9, this.mApplicationContext.getPackageName(), str, string, bundleConstructExtraParamsForQueryPurchases) : this.mService.getPurchases(3, this.mApplicationContext.getPackageName(), str, string);
                BillingResult billingResultCheckPurchasesBundleValidity = PurchaseApiResponseChecker.checkPurchasesBundleValidity(purchasesExtraParams, TAG, "getPurchase()");
                if (billingResultCheckPurchasesBundleValidity != BillingResults.OK) {
                    return new Purchase.PurchasesResult(billingResultCheckPurchasesBundleValidity, null);
                }
                ArrayList<String> stringArrayList = purchasesExtraParams.getStringArrayList(BillingHelper.RESPONSE_INAPP_ITEM_LIST);
                ArrayList<String> stringArrayList2 = purchasesExtraParams.getStringArrayList(BillingHelper.RESPONSE_INAPP_PURCHASE_DATA_LIST);
                ArrayList<String> stringArrayList3 = purchasesExtraParams.getStringArrayList(BillingHelper.RESPONSE_INAPP_SIGNATURE_LIST);
                for (int i = 0; i < stringArrayList2.size(); i++) {
                    String str2 = stringArrayList2.get(i);
                    String str3 = stringArrayList3.get(i);
                    BillingHelper.logVerbose(TAG, "Sku is owned: " + stringArrayList.get(i));
                    try {
                        Purchase purchase = new Purchase(str2, str3);
                        if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                            BillingHelper.logWarn(TAG, "BUG: empty/null token!");
                        }
                        arrayList.add(purchase);
                    } catch (JSONException e2) {
                        BillingHelper.logWarn(TAG, "Got an exception trying to decode the purchase: " + e2);
                        return new Purchase.PurchasesResult(BillingResults.INTERNAL_ERROR, null);
                    }
                }
                string = purchasesExtraParams.getString(BillingHelper.INAPP_CONTINUATION_TOKEN);
                BillingHelper.logVerbose(TAG, "Continuation token: " + string);
            } catch (Exception e3) {
                BillingHelper.logWarn(TAG, "Got exception trying to get purchases: " + e3 + "; try to reconnect");
                return new Purchase.PurchasesResult(BillingResults.SERVICE_DISCONNECTED, null);
            }
        } while (!TextUtils.isEmpty(string));
        return new Purchase.PurchasesResult(BillingResults.OK, arrayList);
    }

    @Override // com.android.billingclient.api.BillingClient
    public void acknowledgePurchase(final AcknowledgePurchaseParams acknowledgePurchaseParams, final AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (!isReady()) {
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(BillingResults.SERVICE_DISCONNECTED);
            return;
        }
        if (TextUtils.isEmpty(acknowledgePurchaseParams.getPurchaseToken())) {
            BillingHelper.logWarn(TAG, "Please provide a valid purchase token.");
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(BillingResults.INVALID_PURCHASE_TOKEN);
        } else if (!this.mIABv9Supported) {
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(BillingResults.API_VERSION_NOT_V9);
        } else if (executeAsync(new Callable<Void>() { // from class: com.android.billingclient.api.BillingClientImpl.18
            @Override // java.util.concurrent.Callable
            public Void call() {
                try {
                    Bundle bundleAcknowledgePurchaseExtraParams = BillingClientImpl.this.mService.acknowledgePurchaseExtraParams(9, BillingClientImpl.this.mApplicationContext.getPackageName(), acknowledgePurchaseParams.getPurchaseToken(), BillingHelper.constructExtraParamsForAcknowledgePurchase(acknowledgePurchaseParams, BillingClientImpl.this.mQualifiedVersionNumber));
                    final int responseCodeFromBundle = BillingHelper.getResponseCodeFromBundle(bundleAcknowledgePurchaseExtraParams, BillingClientImpl.TAG);
                    final String debugMessageFromBundle = BillingHelper.getDebugMessageFromBundle(bundleAcknowledgePurchaseExtraParams, BillingClientImpl.TAG);
                    BillingClientImpl.this.postToUiThread(new Runnable() { // from class: com.android.billingclient.api.BillingClientImpl.18.2
                        @Override // java.lang.Runnable
                        public void run() {
                            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(BillingResult.newBuilder().setResponseCode(responseCodeFromBundle).setDebugMessage(debugMessageFromBundle).build());
                        }
                    });
                    return null;
                } catch (Exception e2) {
                    BillingClientImpl.this.postToUiThread(new Runnable() { // from class: com.android.billingclient.api.BillingClientImpl.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BillingHelper.logWarn(BillingClientImpl.TAG, "Error acknowledge purchase; ex: " + e2);
                            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(BillingResults.SERVICE_DISCONNECTED);
                        }
                    });
                    return null;
                }
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.BillingClientImpl.19
            @Override // java.lang.Runnable
            public void run() {
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(BillingResults.SERVICE_TIMEOUT);
            }
        }) == null) {
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(getBillingResultForNullFutureResult());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void consumeAsync(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        if (!isReady()) {
            consumeResponseListener.onConsumeResponse(BillingResults.SERVICE_DISCONNECTED, null);
        } else if (executeAsync(new Callable<Void>() { // from class: com.android.billingclient.api.BillingClientImpl.12
            @Override // java.util.concurrent.Callable
            public Void call() {
                BillingClientImpl.this.consumeInternal(consumeParams, consumeResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.BillingClientImpl.13
            @Override // java.lang.Runnable
            public void run() {
                consumeResponseListener.onConsumeResponse(BillingResults.SERVICE_TIMEOUT, null);
            }
        }) == null) {
            consumeResponseListener.onConsumeResponse(getBillingResultForNullFutureResult(), null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void endConnection() {
        try {
            try {
                this.mBroadcastManager.destroy();
                if (this.mServiceConnection != null) {
                    this.mServiceConnection.markDisconnectedAndCleanUp();
                }
                if (this.mServiceConnection != null && this.mService != null) {
                    BillingHelper.logVerbose(TAG, "Unbinding from service.");
                    this.mApplicationContext.unbindService(this.mServiceConnection);
                    this.mServiceConnection = null;
                }
                this.mService = null;
                if (this.mExecutorService != null) {
                    this.mExecutorService.shutdownNow();
                    this.mExecutorService = null;
                }
            } catch (Exception e2) {
                BillingHelper.logWarn(TAG, "There was an exception while ending connection: " + e2);
            }
        } finally {
            this.mClientState = 3;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.android.billingclient.api.BillingClient
    public BillingResult isFeatureSupported(String str) {
        if (!isReady()) {
            return BillingResults.SERVICE_DISCONNECTED;
        }
        byte b2 = -1;
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS_UPDATE)) {
                    b2 = 1;
                }
                break;
            case 207616302:
                if (str.equals(BillingClient.FeatureType.PRICE_CHANGE_CONFIRMATION)) {
                    b2 = 4;
                }
                break;
            case 292218239:
                if (str.equals(BillingClient.FeatureType.IN_APP_ITEMS_ON_VR)) {
                    b2 = 2;
                }
                break;
            case 1219490065:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS_ON_VR)) {
                    b2 = 3;
                }
                break;
            case 1987365622:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS)) {
                    b2 = 0;
                }
                break;
        }
        if (b2 == 0) {
            return this.mSubscriptionsSupported ? BillingResults.OK : BillingResults.FEATURE_NOT_SUPPORTED;
        }
        if (b2 == 1) {
            return this.mSubscriptionUpdateSupported ? BillingResults.OK : BillingResults.FEATURE_NOT_SUPPORTED;
        }
        if (b2 == 2) {
            return isBillingSupportedOnVr(BillingClient.SkuType.INAPP);
        }
        if (b2 == 3) {
            return isBillingSupportedOnVr(BillingClient.SkuType.SUBS);
        }
        if (b2 == 4) {
            return this.mIABv8Supported ? BillingResults.OK : BillingResults.FEATURE_NOT_SUPPORTED;
        }
        BillingHelper.logWarn(TAG, "Unsupported feature: " + str);
        return BillingResults.UNKNOWN_FEATURE;
    }

    @Override // com.android.billingclient.api.BillingClient
    public boolean isReady() {
        return (this.mClientState != 2 || this.mService == null || this.mServiceConnection == null) ? false : true;
    }

    @Override // com.android.billingclient.api.BillingClient
    public BillingResult launchBillingFlow(Activity activity, final BillingFlowParams billingFlowParams) {
        Future futureExecuteAsync;
        if (!isReady()) {
            BillingResult billingResult = BillingResults.SERVICE_DISCONNECTED;
            broadcastFailureAndReturnBillingResponse(billingResult);
            return billingResult;
        }
        final String skuType = billingFlowParams.getSkuType();
        final String sku = billingFlowParams.getSku();
        SkuDetails skuDetails = billingFlowParams.getSkuDetails();
        boolean z = skuDetails != null && skuDetails.isRewarded();
        if (sku == null) {
            BillingHelper.logWarn(TAG, "Please fix the input params. SKU can't be null.");
            BillingResult billingResult2 = BillingResults.NULL_SKU;
            broadcastFailureAndReturnBillingResponse(billingResult2);
            return billingResult2;
        }
        if (skuType == null) {
            BillingHelper.logWarn(TAG, "Please fix the input params. SkuType can't be null.");
            BillingResult billingResult3 = BillingResults.NULL_SKU_TYPE;
            broadcastFailureAndReturnBillingResponse(billingResult3);
            return billingResult3;
        }
        if (skuType.equals(BillingClient.SkuType.SUBS) && !this.mSubscriptionsSupported) {
            BillingHelper.logWarn(TAG, "Current client doesn't support subscriptions.");
            BillingResult billingResult4 = BillingResults.SUBSCRIPTIONS_NOT_SUPPORTED;
            broadcastFailureAndReturnBillingResponse(billingResult4);
            return billingResult4;
        }
        boolean z2 = billingFlowParams.getOldSku() != null;
        if (z2 && !this.mSubscriptionUpdateSupported) {
            BillingHelper.logWarn(TAG, "Current client doesn't support subscriptions update.");
            BillingResult billingResult5 = BillingResults.SUBSCRIPTIONS_UPDATE_NOT_SUPPORTED;
            broadcastFailureAndReturnBillingResponse(billingResult5);
            return billingResult5;
        }
        if (billingFlowParams.hasExtraParams() && !this.mIABv6Supported) {
            BillingHelper.logWarn(TAG, "Current client doesn't support extra params for buy intent.");
            BillingResult billingResult6 = BillingResults.EXTRA_PARAMS_NOT_SUPPORTED;
            broadcastFailureAndReturnBillingResponse(billingResult6);
            return billingResult6;
        }
        if (z && !this.mIABv6Supported) {
            BillingHelper.logWarn(TAG, "Current client doesn't support extra params for buy intent.");
            BillingResult billingResult7 = BillingResults.EXTRA_PARAMS_NOT_SUPPORTED;
            broadcastFailureAndReturnBillingResponse(billingResult7);
            return billingResult7;
        }
        BillingHelper.logVerbose(TAG, "Constructing buy intent for " + sku + ", item type: " + skuType);
        if (this.mIABv6Supported) {
            final Bundle bundleConstructExtraParamsForLaunchBillingFlow = BillingHelper.constructExtraParamsForLaunchBillingFlow(billingFlowParams, this.mIABv9Supported, this.mEnablePendingPurchases, this.mQualifiedVersionNumber);
            if (!skuDetails.getSkuDetailsToken().isEmpty()) {
                bundleConstructExtraParamsForLaunchBillingFlow.putString(BillingHelper.EXTRA_PARAM_KEY_SKU_DETAILS_TOKEN, skuDetails.getSkuDetailsToken());
            }
            if (z) {
                bundleConstructExtraParamsForLaunchBillingFlow.putString(BillingFlowParams.EXTRA_PARAM_KEY_RSKU, skuDetails.rewardToken());
                int i = this.mChildDirected;
                if (i != 0) {
                    bundleConstructExtraParamsForLaunchBillingFlow.putInt(BillingFlowParams.EXTRA_PARAM_CHILD_DIRECTED, i);
                }
                int i2 = this.mUnderAgeOfConsent;
                if (i2 != 0) {
                    bundleConstructExtraParamsForLaunchBillingFlow.putInt(BillingFlowParams.EXTRA_PARAM_UNDER_AGE_OF_CONSENT, i2);
                }
            }
            final int i3 = this.mIABv9Supported ? 9 : billingFlowParams.getVrPurchaseFlow() ? 7 : 6;
            futureExecuteAsync = executeAsync(new Callable<Bundle>() { // from class: com.android.billingclient.api.BillingClientImpl.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Bundle call() throws Exception {
                    return BillingClientImpl.this.mService.getBuyIntentExtraParams(i3, BillingClientImpl.this.mApplicationContext.getPackageName(), sku, skuType, null, bundleConstructExtraParamsForLaunchBillingFlow);
                }
            }, SYNCHRONOUS_TIMEOUT_IN_MILLISECONDS, null);
        } else {
            futureExecuteAsync = z2 ? executeAsync(new Callable<Bundle>() { // from class: com.android.billingclient.api.BillingClientImpl.5
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Bundle call() throws Exception {
                    return BillingClientImpl.this.mService.getBuyIntentToReplaceSkus(5, BillingClientImpl.this.mApplicationContext.getPackageName(), Arrays.asList(billingFlowParams.getOldSku()), sku, BillingClient.SkuType.SUBS, null);
                }
            }, SYNCHRONOUS_TIMEOUT_IN_MILLISECONDS, null) : executeAsync(new Callable<Bundle>() { // from class: com.android.billingclient.api.BillingClientImpl.6
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Bundle call() throws Exception {
                    return BillingClientImpl.this.mService.getBuyIntent(3, BillingClientImpl.this.mApplicationContext.getPackageName(), sku, skuType, null);
                }
            }, SYNCHRONOUS_TIMEOUT_IN_MILLISECONDS, null);
        }
        try {
            Bundle bundle = (Bundle) futureExecuteAsync.get(SYNCHRONOUS_TIMEOUT_IN_MILLISECONDS, TimeUnit.MILLISECONDS);
            int responseCodeFromBundle = BillingHelper.getResponseCodeFromBundle(bundle, TAG);
            String debugMessageFromBundle = BillingHelper.getDebugMessageFromBundle(bundle, TAG);
            if (responseCodeFromBundle == 0) {
                Intent intent = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                intent.putExtra("result_receiver", this.onPurchaseFinishedReceiver);
                intent.putExtra(BillingHelper.RESPONSE_BUY_INTENT_KEY, (PendingIntent) bundle.getParcelable(BillingHelper.RESPONSE_BUY_INTENT_KEY));
                activity.startActivity(intent);
                return BillingResults.OK;
            }
            BillingHelper.logWarn(TAG, "Unable to buy item, Error response code: " + responseCodeFromBundle);
            BillingResult billingResultBuild = BillingResult.newBuilder().setResponseCode(responseCodeFromBundle).setDebugMessage(debugMessageFromBundle).build();
            broadcastFailureAndReturnBillingResponse(billingResultBuild);
            return billingResultBuild;
        } catch (CancellationException | TimeoutException unused) {
            BillingHelper.logWarn(TAG, "Time out while launching billing flow: ; for sku: " + sku + "; try to reconnect");
            BillingResult billingResult8 = BillingResults.SERVICE_TIMEOUT;
            broadcastFailureAndReturnBillingResponse(billingResult8);
            return billingResult8;
        } catch (Exception unused2) {
            BillingHelper.logWarn(TAG, "Exception while launching billing flow: ; for sku: " + sku + "; try to reconnect");
            BillingResult billingResult9 = BillingResults.SERVICE_DISCONNECTED;
            broadcastFailureAndReturnBillingResponse(billingResult9);
            return billingResult9;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void loadRewardedSku(final RewardLoadParams rewardLoadParams, final RewardResponseListener rewardResponseListener) {
        if (!this.mIABv6Supported) {
            rewardResponseListener.onRewardResponse(BillingResults.ITEM_UNAVAILABLE);
        } else if (executeAsync(new Callable<Void>() { // from class: com.android.billingclient.api.BillingClientImpl.16
            @Override // java.util.concurrent.Callable
            public Void call() {
                try {
                    Bundle buyIntentExtraParams = BillingClientImpl.this.mService.getBuyIntentExtraParams(6, BillingClientImpl.this.mApplicationContext.getPackageName(), rewardLoadParams.getSkuDetails().getSku(), rewardLoadParams.getSkuDetails().getType(), null, BillingHelper.constructExtraParamsForLoadRewardedSku(rewardLoadParams.getSkuDetails().rewardToken(), BillingClientImpl.this.mChildDirected, BillingClientImpl.this.mUnderAgeOfConsent, BillingClientImpl.this.mQualifiedVersionNumber));
                    final BillingResult billingResultBuild = BillingResult.newBuilder().setResponseCode(BillingHelper.getResponseCodeFromBundle(buyIntentExtraParams, BillingClientImpl.TAG)).setDebugMessage(BillingHelper.getDebugMessageFromBundle(buyIntentExtraParams, BillingClientImpl.TAG)).build();
                    BillingClientImpl.this.postToUiThread(new Runnable() { // from class: com.android.billingclient.api.BillingClientImpl.16.2
                        @Override // java.lang.Runnable
                        public void run() {
                            rewardResponseListener.onRewardResponse(billingResultBuild);
                        }
                    });
                    return null;
                } catch (Exception unused) {
                    BillingClientImpl.this.postToUiThread(new Runnable() { // from class: com.android.billingclient.api.BillingClientImpl.16.1
                        @Override // java.lang.Runnable
                        public void run() {
                            rewardResponseListener.onRewardResponse(BillingResults.INTERNAL_ERROR);
                        }
                    });
                    return null;
                }
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.BillingClientImpl.17
            @Override // java.lang.Runnable
            public void run() {
                rewardResponseListener.onRewardResponse(BillingResults.SERVICE_TIMEOUT);
            }
        }) == null) {
            rewardResponseListener.onRewardResponse(getBillingResultForNullFutureResult());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void queryPurchaseHistoryAsync(final String str, final PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        if (!isReady()) {
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(BillingResults.SERVICE_DISCONNECTED, null);
        } else if (executeAsync(new Callable<Void>() { // from class: com.android.billingclient.api.BillingClientImpl.14
            @Override // java.util.concurrent.Callable
            public Void call() {
                final PurchaseHistoryResult purchaseHistoryResultQueryPurchaseHistoryInternal = BillingClientImpl.this.queryPurchaseHistoryInternal(str);
                BillingClientImpl.this.postToUiThread(new Runnable() { // from class: com.android.billingclient.api.BillingClientImpl.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        purchaseHistoryResponseListener.onPurchaseHistoryResponse(purchaseHistoryResultQueryPurchaseHistoryInternal.getBillingResult(), purchaseHistoryResultQueryPurchaseHistoryInternal.getPurchaseHistoryRecordList());
                    }
                });
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.BillingClientImpl.15
            @Override // java.lang.Runnable
            public void run() {
                purchaseHistoryResponseListener.onPurchaseHistoryResponse(BillingResults.SERVICE_TIMEOUT, null);
            }
        }) == null) {
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(getBillingResultForNullFutureResult(), null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public Purchase.PurchasesResult queryPurchases(final String str) {
        if (!isReady()) {
            return new Purchase.PurchasesResult(BillingResults.SERVICE_DISCONNECTED, null);
        }
        if (TextUtils.isEmpty(str)) {
            BillingHelper.logWarn(TAG, "Please provide a valid SKU type.");
            return new Purchase.PurchasesResult(BillingResults.EMPTY_SKU_TYPE, null);
        }
        try {
            return (Purchase.PurchasesResult) executeAsync(new Callable<Purchase.PurchasesResult>() { // from class: com.android.billingclient.api.BillingClientImpl.7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Purchase.PurchasesResult call() throws Exception {
                    return BillingClientImpl.this.queryPurchasesInternal(str);
                }
            }, SYNCHRONOUS_TIMEOUT_IN_MILLISECONDS, null).get(SYNCHRONOUS_TIMEOUT_IN_MILLISECONDS, TimeUnit.MILLISECONDS);
        } catch (CancellationException | TimeoutException unused) {
            return new Purchase.PurchasesResult(BillingResults.SERVICE_TIMEOUT, null);
        } catch (Exception unused2) {
            return new Purchase.PurchasesResult(BillingResults.INTERNAL_ERROR, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void querySkuDetailsAsync(SkuDetailsParams skuDetailsParams, final SkuDetailsResponseListener skuDetailsResponseListener) {
        if (!isReady()) {
            skuDetailsResponseListener.onSkuDetailsResponse(BillingResults.SERVICE_DISCONNECTED, null);
            return;
        }
        final String skuType = skuDetailsParams.getSkuType();
        final List<String> skusList = skuDetailsParams.getSkusList();
        if (TextUtils.isEmpty(skuType)) {
            BillingHelper.logWarn(TAG, "Please fix the input params. SKU type can't be empty.");
            skuDetailsResponseListener.onSkuDetailsResponse(BillingResults.EMPTY_SKU_TYPE, null);
        } else if (skusList == null) {
            BillingHelper.logWarn(TAG, "Please fix the input params. The list of SKUs can't be empty.");
            skuDetailsResponseListener.onSkuDetailsResponse(BillingResults.EMPTY_SKU_LIST, null);
        } else if (executeAsync(new Callable<Void>() { // from class: com.android.billingclient.api.BillingClientImpl.10
            @Override // java.util.concurrent.Callable
            public Void call() {
                final SkuDetails.SkuDetailsResult skuDetailsResultQuerySkuDetailsInternal = BillingClientImpl.this.querySkuDetailsInternal(skuType, skusList);
                BillingClientImpl.this.postToUiThread(new Runnable() { // from class: com.android.billingclient.api.BillingClientImpl.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        skuDetailsResponseListener.onSkuDetailsResponse(BillingResult.newBuilder().setResponseCode(skuDetailsResultQuerySkuDetailsInternal.getResponseCode()).setDebugMessage(skuDetailsResultQuerySkuDetailsInternal.getDebugMessage()).build(), skuDetailsResultQuerySkuDetailsInternal.getSkuDetailsList());
                    }
                });
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.BillingClientImpl.11
            @Override // java.lang.Runnable
            public void run() {
                skuDetailsResponseListener.onSkuDetailsResponse(BillingResults.SERVICE_TIMEOUT, null);
            }
        }) == null) {
            skuDetailsResponseListener.onSkuDetailsResponse(getBillingResultForNullFutureResult(), null);
        }
    }

    SkuDetails.SkuDetailsResult querySkuDetailsInternal(String str, List<String> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 20;
            ArrayList<String> arrayList2 = new ArrayList<>(list.subList(i, i2 > size ? size : i2));
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(GET_SKU_DETAILS_ITEM_LIST, arrayList2);
            bundle.putString(BillingHelper.LIBRARY_VERSION_KEY, this.mQualifiedVersionNumber);
            try {
                Bundle skuDetailsExtraParams = this.mIABv10Supported ? this.mService.getSkuDetailsExtraParams(10, this.mApplicationContext.getPackageName(), str, bundle, BillingHelper.constructExtraParamsForGetSkuDetails(this.mIABv9Supported, this.mEnablePendingPurchases, this.mQualifiedVersionNumber)) : this.mService.getSkuDetails(3, this.mApplicationContext.getPackageName(), str, bundle);
                if (skuDetailsExtraParams == null) {
                    BillingHelper.logWarn(TAG, "querySkuDetailsAsync got null sku details list");
                    return new SkuDetails.SkuDetailsResult(4, "Null sku details list", null);
                }
                if (!skuDetailsExtraParams.containsKey(BillingHelper.RESPONSE_GET_SKU_DETAILS_LIST)) {
                    int responseCodeFromBundle = BillingHelper.getResponseCodeFromBundle(skuDetailsExtraParams, TAG);
                    String debugMessageFromBundle = BillingHelper.getDebugMessageFromBundle(skuDetailsExtraParams, TAG);
                    if (responseCodeFromBundle == 0) {
                        BillingHelper.logWarn(TAG, "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                        return new SkuDetails.SkuDetailsResult(6, debugMessageFromBundle, arrayList);
                    }
                    BillingHelper.logWarn(TAG, "getSkuDetails() failed. Response code: " + responseCodeFromBundle);
                    return new SkuDetails.SkuDetailsResult(responseCodeFromBundle, debugMessageFromBundle, arrayList);
                }
                ArrayList<String> stringArrayList = skuDetailsExtraParams.getStringArrayList(BillingHelper.RESPONSE_GET_SKU_DETAILS_LIST);
                if (stringArrayList == null) {
                    BillingHelper.logWarn(TAG, "querySkuDetailsAsync got null response list");
                    return new SkuDetails.SkuDetailsResult(4, "querySkuDetailsAsync got null response list", null);
                }
                for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
                    try {
                        SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i3));
                        BillingHelper.logVerbose(TAG, "Got sku details: " + skuDetails);
                        arrayList.add(skuDetails);
                    } catch (JSONException unused) {
                        BillingHelper.logWarn(TAG, "Got a JSON exception trying to decode SkuDetails.");
                        return new SkuDetails.SkuDetailsResult(6, "Error trying to decode SkuDetails.", null);
                    }
                }
                i = i2;
            } catch (Exception e2) {
                BillingHelper.logWarn(TAG, "querySkuDetailsAsync got a remote exception (try to reconnect)." + e2);
                return new SkuDetails.SkuDetailsResult(-1, "Service connection is disconnected.", null);
            }
        }
        return new SkuDetails.SkuDetailsResult(0, "", arrayList);
    }

    void setExecutorService(ExecutorService executorService) {
        this.mExecutorService = executorService;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void startConnection(BillingClientStateListener billingClientStateListener) {
        ResolveInfo resolveInfo;
        ServiceInfo serviceInfo;
        if (isReady()) {
            BillingHelper.logVerbose(TAG, "Service connection is valid. No need to re-initialize.");
            billingClientStateListener.onBillingSetupFinished(BillingResults.OK);
            return;
        }
        int i = this.mClientState;
        if (i == 1) {
            BillingHelper.logWarn(TAG, "Client is already in the process of connecting to billing service.");
            billingClientStateListener.onBillingSetupFinished(BillingResults.CLIENT_CONNECTING);
            return;
        }
        if (i == 3) {
            BillingHelper.logWarn(TAG, "Client was already closed and can't be reused. Please create another instance.");
            billingClientStateListener.onBillingSetupFinished(BillingResults.SERVICE_DISCONNECTED);
            return;
        }
        this.mClientState = 1;
        this.mBroadcastManager.registerReceiver();
        BillingHelper.logVerbose(TAG, "Starting in-app billing setup.");
        this.mServiceConnection = new BillingServiceConnection(billingClientStateListener);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> listQueryIntentServices = this.mApplicationContext.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices != null && !listQueryIntentServices.isEmpty() && (serviceInfo = (resolveInfo = listQueryIntentServices.get(0)).serviceInfo) != null) {
            String str = serviceInfo.packageName;
            String str2 = resolveInfo.serviceInfo.name;
            if (!"com.android.vending".equals(str) || str2 == null) {
                BillingHelper.logWarn(TAG, "The device doesn't have valid Play Store.");
            } else {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                intent2.putExtra(BillingHelper.LIBRARY_VERSION_KEY, this.mQualifiedVersionNumber);
                if (this.mApplicationContext.bindService(intent2, this.mServiceConnection, 1)) {
                    BillingHelper.logVerbose(TAG, "Service was bonded successfully.");
                    return;
                }
                BillingHelper.logWarn(TAG, "Connection to Billing service is blocked.");
            }
        }
        this.mClientState = 0;
        BillingHelper.logVerbose(TAG, "Billing service unavailable on device.");
        billingClientStateListener.onBillingSetupFinished(BillingResults.BILLING_UNAVAILABLE);
    }

    private BillingClientImpl(Activity activity, int i, int i2, boolean z, String str) {
        this(activity.getApplicationContext(), i, i2, z, new BillingClientNativeCallback(), str);
    }

    @Override // com.android.billingclient.api.BillingClient
    public void launchPriceChangeConfirmationFlow(Activity activity, PriceChangeFlowParams priceChangeFlowParams, final PriceChangeConfirmationListener priceChangeConfirmationListener) {
        if (!isReady()) {
            priceChangeConfirmationListener.onPriceChangeConfirmationResult(BillingResults.SERVICE_DISCONNECTED);
            return;
        }
        if (priceChangeFlowParams == null || priceChangeFlowParams.getSkuDetails() == null) {
            BillingHelper.logWarn(TAG, "Please fix the input params. priceChangeFlowParams must contain valid sku.");
            priceChangeConfirmationListener.onPriceChangeConfirmationResult(BillingResults.NULL_SKU);
            return;
        }
        final String sku = priceChangeFlowParams.getSkuDetails().getSku();
        if (sku == null) {
            BillingHelper.logWarn(TAG, "Please fix the input params. priceChangeFlowParams must contain valid sku.");
            priceChangeConfirmationListener.onPriceChangeConfirmationResult(BillingResults.NULL_SKU);
            return;
        }
        if (!this.mIABv8Supported) {
            BillingHelper.logWarn(TAG, "Current client doesn't support price change confirmation flow.");
            priceChangeConfirmationListener.onPriceChangeConfirmationResult(BillingResults.FEATURE_NOT_SUPPORTED);
            return;
        }
        final Bundle bundle = new Bundle();
        bundle.putString(BillingHelper.LIBRARY_VERSION_KEY, this.mQualifiedVersionNumber);
        bundle.putBoolean(BillingHelper.EXTRA_PARAM_KEY_SUBS_PRICE_CHANGE, true);
        try {
            Bundle bundle2 = (Bundle) executeAsync(new Callable<Bundle>() { // from class: com.android.billingclient.api.BillingClientImpl.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Bundle call() throws Exception {
                    return BillingClientImpl.this.mService.getSubscriptionManagementIntent(8, BillingClientImpl.this.mApplicationContext.getPackageName(), sku, BillingClient.SkuType.SUBS, bundle);
                }
            }, SYNCHRONOUS_TIMEOUT_IN_MILLISECONDS, null).get(SYNCHRONOUS_TIMEOUT_IN_MILLISECONDS, TimeUnit.MILLISECONDS);
            int responseCodeFromBundle = BillingHelper.getResponseCodeFromBundle(bundle2, TAG);
            BillingResult billingResultBuild = BillingResult.newBuilder().setResponseCode(responseCodeFromBundle).setDebugMessage(BillingHelper.getDebugMessageFromBundle(bundle2, TAG)).build();
            if (responseCodeFromBundle != 0) {
                BillingHelper.logWarn(TAG, "Unable to launch price change flow, error response code: " + responseCodeFromBundle);
                priceChangeConfirmationListener.onPriceChangeConfirmationResult(billingResultBuild);
                return;
            }
            ResultReceiver resultReceiver = new ResultReceiver(this.mUiThreadHandler) { // from class: com.android.billingclient.api.BillingClientImpl.3
                @Override // android.os.ResultReceiver
                public void onReceiveResult(int i, Bundle bundle3) {
                    priceChangeConfirmationListener.onPriceChangeConfirmationResult(BillingResult.newBuilder().setResponseCode(i).setDebugMessage(BillingHelper.getDebugMessageFromBundle(bundle3, BillingClientImpl.TAG)).build());
                }
            };
            Intent intent = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
            intent.putExtra(BillingHelper.RESPONSE_SUBS_MANAGEMENT_INTENT_KEY, (PendingIntent) bundle2.getParcelable(BillingHelper.RESPONSE_SUBS_MANAGEMENT_INTENT_KEY));
            intent.putExtra("result_receiver", resultReceiver);
            activity.startActivity(intent);
        } catch (CancellationException | TimeoutException unused) {
            BillingHelper.logWarn(TAG, "Time out while launching Price Change Flow for sku: " + sku + "; try to reconnect");
            priceChangeConfirmationListener.onPriceChangeConfirmationResult(BillingResults.SERVICE_TIMEOUT);
        } catch (Exception unused2) {
            BillingHelper.logWarn(TAG, "Exception caught while launching Price Change Flow for sku: " + sku + "; try to reconnect");
            priceChangeConfirmationListener.onPriceChangeConfirmationResult(BillingResults.SERVICE_DISCONNECTED);
        }
    }

    private BillingClientImpl(Context context, int i, int i2, boolean z, PurchasesUpdatedListener purchasesUpdatedListener, String str) {
        this.mClientState = 0;
        this.mUiThreadHandler = new Handler(Looper.getMainLooper());
        this.onPurchaseFinishedReceiver = new ResultReceiver(this.mUiThreadHandler) { // from class: com.android.billingclient.api.BillingClientImpl.1
            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i3, Bundle bundle) {
                PurchasesUpdatedListener listener = BillingClientImpl.this.mBroadcastManager.getListener();
                if (listener == null) {
                    BillingHelper.logWarn(BillingClientImpl.TAG, "PurchasesUpdatedListener is null - no way to return the response.");
                } else {
                    listener.onPurchasesUpdated(BillingResult.newBuilder().setResponseCode(i3).setDebugMessage(BillingHelper.getDebugMessageFromBundle(bundle, BillingClientImpl.TAG)).build(), BillingHelper.extractPurchases(bundle));
                }
            }
        };
        this.mApplicationContext = context.getApplicationContext();
        this.mChildDirected = i;
        this.mUnderAgeOfConsent = i2;
        this.mEnablePendingPurchases = z;
        this.mBroadcastManager = new BillingBroadcastManager(this.mApplicationContext, purchasesUpdatedListener);
        this.mQualifiedVersionNumber = str;
    }

    private void consumeAsync(ConsumeParams consumeParams, long j) {
        consumeAsync(consumeParams, new BillingClientNativeCallback(j));
    }

    private void loadRewardedSku(RewardLoadParams rewardLoadParams, long j) {
        loadRewardedSku(rewardLoadParams, new BillingClientNativeCallback(j));
    }

    private void queryPurchaseHistoryAsync(String str, long j) {
        queryPurchaseHistoryAsync(str, new BillingClientNativeCallback(j));
    }

    private void acknowledgePurchase(AcknowledgePurchaseParams acknowledgePurchaseParams, long j) {
        acknowledgePurchase(acknowledgePurchaseParams, new BillingClientNativeCallback(j));
    }

    private void queryPurchases(final String str, long j) {
        final BillingClientNativeCallback billingClientNativeCallback = new BillingClientNativeCallback(j);
        if (!isReady()) {
            billingClientNativeCallback.onQueryPurchasesResponse(BillingResults.SERVICE_DISCONNECTED, null);
        }
        if (executeAsync(new Callable<Void>() { // from class: com.android.billingclient.api.BillingClientImpl.8
            @Override // java.util.concurrent.Callable
            public Void call() {
                final Purchase.PurchasesResult purchasesResultQueryPurchasesInternal = BillingClientImpl.this.queryPurchasesInternal(str);
                BillingClientImpl.this.postToUiThread(new Runnable() { // from class: com.android.billingclient.api.BillingClientImpl.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        billingClientNativeCallback.onQueryPurchasesResponse(purchasesResultQueryPurchasesInternal.getBillingResult(), purchasesResultQueryPurchasesInternal.getPurchasesList());
                    }
                });
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.BillingClientImpl.9
            @Override // java.lang.Runnable
            public void run() {
                billingClientNativeCallback.onQueryPurchasesResponse(BillingResults.SERVICE_TIMEOUT, null);
            }
        }) == null) {
            billingClientNativeCallback.onQueryPurchasesResponse(getBillingResultForNullFutureResult(), null);
        }
    }

    private void querySkuDetailsAsync(String str, String[] strArr, long j) {
        querySkuDetailsAsync(SkuDetailsParams.newBuilder().setType(str).setSkusList(Arrays.asList(strArr)).build(), new BillingClientNativeCallback(j));
    }

    private void startConnection(long j) {
        startConnection(new BillingClientNativeCallback(j));
    }
}
