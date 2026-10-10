package com.ironsource.sdk.controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import b.f.d.h.a;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.data.SSAEnums$DebugMode;
import com.ironsource.sdk.data.SSAEnums$ProductType;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import com.unity3d.services.purchasing.core.TransactionErrorDetailsUtilities;
import io.rong.common.LibStorageUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class WebController extends WebView implements DownloadListener, a.c, I {
    public static String EXTERNAL_URL = "external_url";
    public static String IS_STORE = "is_store";
    private static String JSON_KEY_FAIL = "fail";
    private static String JSON_KEY_SUCCESS = "success";
    public static String SECONDARY_WEB_VIEW = "secondary_web_view";
    public static int mDebugMode;
    private final String GENERIC_MESSAGE;
    private String PUB_TAG;
    private String TAG;
    private b.f.d.h.a downloadManager;
    private Boolean isKitkatAndAbove;
    private boolean isRemoveCloseEventHandler;
    private C2385b mAdViewsJsAdapter;
    private String mApplicationKey;
    private C2387c mBannerJsAdapter;
    private String mCacheDirectory;
    private b.f.d.g.g mChangeListener;
    private CountDownTimer mCloseEventTimer;
    private com.ironsource.sdk.service.a mConnectivityAdapter;
    private C2397h mControllerAdapter;
    private String mControllerKeyPressed;
    private FrameLayout mControllerLayout;
    private InterfaceC2399i mControllerListener;
    Context mCurrentActivityContext;
    private View mCustomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    private FrameLayout mCustomViewContainer;
    private b.f.d.g.a.b mDSBannerListener;
    private b.f.d.g.a.c mDSInterstitialListener;
    private b.f.d.g.a.d mDSRewardedVideoListener;
    private E mDemandSourceManager;
    private G mDeviceDataJsAdapter;
    private int mHiddenForceCloseHeight;
    private String mHiddenForceCloseLocation;
    private int mHiddenForceCloseWidth;
    private boolean mIsImmersive;
    private boolean mIsWebControllerReady;
    public CountDownTimer mLoadControllerTimer;
    private boolean mOWCreditsMiss;
    private Map<String, String> mOWExtraParameters;
    private boolean mOWmiss;
    private Y mOmidJsAdapter;
    private b.f.d.g.c mOnGenericFunctionListener;
    private b.f.d.g.e mOnOfferWallListener;
    private String mOrientationState;
    private C2388ca mPermissionsJsAdapter;
    private com.ironsource.sdk.data.c mSavedState;
    private Object mSavedStateLocker;
    private State mState;
    private C2396ga mTokenJSAdapter;
    Handler mUiHandler;
    private String mUserId;
    private InterfaceC2398ha mVideoEventsListener;
    private a mWebChromeClient;
    private Xa mWebViewMessagingMediator;

    public enum State {
        Display,
        Gone
    }

    private class a extends WebChromeClient {
        private a() {
        }

        @Override // android.webkit.WebChromeClient
        public View getVideoLoadingProgressView() {
            FrameLayout frameLayout = new FrameLayout(WebController.this.getCurrentActivityContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return frameLayout;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            com.ironsource.sdk.utils.f.c("MyApplication", consoleMessage.message() + " -- From line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            WebView webView2 = new WebView(webView.getContext());
            webView2.setWebChromeClient(this);
            webView2.setWebViewClient(new b(WebController.this, null));
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            com.ironsource.sdk.utils.f.c("onCreateWindow", "onCreateWindow");
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            com.ironsource.sdk.utils.f.c("Test", "onHideCustomView");
            if (WebController.this.mCustomView == null) {
                return;
            }
            WebController.this.mCustomView.setVisibility(8);
            WebController.this.mCustomViewContainer.removeView(WebController.this.mCustomView);
            WebController.this.mCustomView = null;
            WebController.this.mCustomViewContainer.setVisibility(8);
            WebController.this.mCustomViewCallback.onCustomViewHidden();
            WebController.this.setVisibility(0);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            com.ironsource.sdk.utils.f.c("Test", "onShowCustomView");
            WebController.this.setVisibility(8);
            if (WebController.this.mCustomView != null) {
                com.ironsource.sdk.utils.f.c("Test", "mCustomView != null");
                customViewCallback.onCustomViewHidden();
                return;
            }
            com.ironsource.sdk.utils.f.c("Test", "mCustomView == null");
            WebController.this.mCustomViewContainer.addView(view);
            WebController.this.mCustomView = view;
            WebController.this.mCustomViewCallback = customViewCallback;
            WebController.this.mCustomViewContainer.setVisibility(0);
        }

        /* synthetic */ a(WebController webController, C2406la c2406la) {
            this();
        }
    }

    private class b extends WebViewClient {
        private b() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Context currentActivityContext = WebController.this.getCurrentActivityContext();
            Intent intent = new Intent(currentActivityContext, (Class<?>) OpenUrlActivity.class);
            intent.putExtra(WebController.EXTERNAL_URL, str);
            intent.putExtra(WebController.SECONDARY_WEB_VIEW, false);
            currentActivityContext.startActivity(intent);
            return true;
        }

        /* synthetic */ b(WebController webController, C2406la c2406la) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface d {
        void a(String str, SSAEnums$ProductType sSAEnums$ProductType, com.ironsource.sdk.data.d dVar);
    }

    static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f15243b;

        e() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class f implements View.OnTouchListener {
        private f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                String str = WebController.this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("X:");
                int i = (int) x;
                sb.append(i);
                sb.append(" Y:");
                int i2 = (int) y;
                sb.append(i2);
                com.ironsource.sdk.utils.f.c(str, sb.toString());
                int iJ = com.ironsource.environment.b.j();
                int iD = com.ironsource.environment.b.d();
                com.ironsource.sdk.utils.f.c(WebController.this.TAG, "Width:" + iJ + " Height:" + iD);
                int iA = com.ironsource.sdk.utils.i.a((long) WebController.this.mHiddenForceCloseWidth);
                int iA2 = com.ironsource.sdk.utils.i.a((long) WebController.this.mHiddenForceCloseHeight);
                if ("top-right".equalsIgnoreCase(WebController.this.mHiddenForceCloseLocation)) {
                    i = iJ - i;
                } else if (!"top-left".equalsIgnoreCase(WebController.this.mHiddenForceCloseLocation)) {
                    if ("bottom-right".equalsIgnoreCase(WebController.this.mHiddenForceCloseLocation)) {
                        i = iJ - i;
                    } else if (!"bottom-left".equalsIgnoreCase(WebController.this.mHiddenForceCloseLocation)) {
                        i = 0;
                        i2 = 0;
                    }
                    i2 = iD - i2;
                }
                if (i <= iA && i2 <= iA2) {
                    WebController.this.isRemoveCloseEventHandler = false;
                    if (WebController.this.mCloseEventTimer != null) {
                        WebController.this.mCloseEventTimer.cancel();
                    }
                    WebController.this.mCloseEventTimer = new Wa(this, 2000L, 500L).start();
                }
            }
            return false;
        }

        /* synthetic */ f(WebController webController, C2406la c2406la) {
            this();
        }
    }

    private class g extends WebViewClient {
        private g() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            com.ironsource.sdk.utils.f.c("onPageFinished", str);
            if (str.contains("adUnit") || str.contains("index.html")) {
                WebController.this.pageFinished();
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            com.ironsource.sdk.utils.f.c("onPageStarted", str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            com.ironsource.sdk.utils.f.c("onReceivedError", str2 + " " + str);
            if (str2.contains("mobileController.html") && WebController.this.mControllerListener != null) {
                WebController.this.mControllerListener.a("WebView failed to load mobileController.html - " + str + " (errorCode: " + i + ")");
            }
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            boolean zContains;
            com.ironsource.sdk.utils.f.c("shouldInterceptRequest", str);
            try {
                zContains = new URL(str).getFile().contains("mraid.js");
            } catch (MalformedURLException unused) {
                zContains = false;
            }
            if (zContains) {
                String str2 = "file://" + WebController.this.mCacheDirectory + File.separator + "mraid.js";
                try {
                    new FileInputStream(new File(str2));
                    return new WebResourceResponse("text/javascript", "UTF-8", getClass().getResourceAsStream(str2));
                } catch (FileNotFoundException unused2) {
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            com.ironsource.sdk.utils.f.c("shouldOverrideUrlLoading", str);
            try {
                if (WebController.this.handleSearchKeysURLs(str)) {
                    WebController.this.interceptedUrlToStore();
                    return true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        /* synthetic */ g(WebController webController, C2406la c2406la) {
            this();
        }
    }

    public WebController(Activity activity, E e2, InterfaceC2399i interfaceC2399i) {
        super(activity.getApplicationContext());
        this.TAG = WebController.class.getSimpleName();
        this.PUB_TAG = "IronSource";
        this.GENERIC_MESSAGE = "We're sorry, some error occurred. we will investigate it";
        this.mControllerKeyPressed = "interrupt";
        this.mHiddenForceCloseWidth = 50;
        this.mHiddenForceCloseHeight = 50;
        this.mHiddenForceCloseLocation = "top-right";
        C2406la c2406la = null;
        this.isKitkatAndAbove = null;
        this.mSavedStateLocker = new Object();
        this.mIsImmersive = false;
        this.mCurrentActivityContext = new MutableContextWrapper(activity);
        com.ironsource.sdk.utils.f.c(this.TAG, "C'tor");
        this.mControllerListener = interfaceC2399i;
        this.mCacheDirectory = initializeCacheDirectory(this.mCurrentActivityContext.getApplicationContext());
        this.mDemandSourceManager = e2;
        initLayout(this.mCurrentActivityContext);
        this.mSavedState = new com.ironsource.sdk.data.c();
        this.downloadManager = getDownloadManager();
        this.downloadManager.a(this);
        this.mWebChromeClient = new a(this, c2406la);
        setWebViewClient(new g(this, c2406la));
        setWebChromeClient(this.mWebChromeClient);
        com.ironsource.sdk.utils.k.a(this);
        setWebViewSettings();
        createSecuredCommunication();
        setDownloadListener(this);
        setOnTouchListener(new f(this, c2406la));
        this.mUiHandler = createMainThreadHandler();
        this.mConnectivityAdapter = createConnectivityAdapter(activity);
        registerConnectionReceiver(activity);
        setDebugMode(H.b().a());
    }

    static /* synthetic */ WebView access$5200(WebController webController) {
        webController.getWebview();
        return webController;
    }

    private void addGooglePlayInstalledData(JSONObject jSONObject) throws JSONException {
        jSONObject.put(com.ironsource.sdk.utils.i.b("gpi"), com.ironsource.sdk.service.e.a(getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeWebView() {
        b.f.d.g.g gVar = this.mChangeListener;
        if (gVar != null) {
            gVar.onCloseRequested();
        }
    }

    private com.ironsource.sdk.service.a createConnectivityAdapter(Context context) {
        return new C2406la(this, com.ironsource.sdk.utils.i.d(), context);
    }

    private e createInitProductJSMethod(SSAEnums$ProductType sSAEnums$ProductType, com.ironsource.sdk.data.d dVar) {
        e eVar = new e();
        if (sSAEnums$ProductType == SSAEnums$ProductType.RewardedVideo || sSAEnums$ProductType == SSAEnums$ProductType.Interstitial || sSAEnums$ProductType == SSAEnums$ProductType.OfferWall || sSAEnums$ProductType == SSAEnums$ProductType.Banner) {
            HashMap map = new HashMap();
            map.put("applicationKey", this.mApplicationKey);
            map.put("applicationUserId", this.mUserId);
            if (dVar != null) {
                if (dVar.e() != null) {
                    map.putAll(dVar.e());
                }
                map.put("demandSourceName", dVar.d());
                map.put("demandSourceId", dVar.f());
            }
            Map<String, String> extraParamsByProduct = getExtraParamsByProduct(sSAEnums$ProductType);
            if (extraParamsByProduct != null) {
                map.putAll(extraParamsByProduct);
            }
            String strA = com.ironsource.sdk.utils.i.a(map);
            b.f.d.e.a aVarA = b.f.d.e.a.a(sSAEnums$ProductType);
            String strGenerateJSToInject = generateJSToInject(aVarA.f2732a, strA, aVarA.f2733b, aVarA.f2734c);
            eVar.f15242a = aVarA.f2732a;
            eVar.f15243b = strGenerateJSToInject;
        } else if (sSAEnums$ProductType == SSAEnums$ProductType.OfferWallCredits) {
            String strGenerateJSToInject2 = generateJSToInject("getUserCredits", parseToJson("productType", "OfferWall", "applicationKey", this.mApplicationKey, "applicationUserId", this.mUserId, null, null, null, false), "null", "onGetUserCreditsFail");
            eVar.f15242a = "getUserCredits";
            eVar.f15243b = strGenerateJSToInject2;
        }
        return eVar;
    }

    private void createSecuredCommunication() {
        C2392ea c2392ea = new C2392ea(C2392ea.a());
        addJavascriptInterface(createControllerMessageHandler(c2392ea), "Android");
        addJavascriptInterface(createSecureMessagingInterface(c2392ea), "GenerateTokenForMessaging");
    }

    private String createShowProductJSMethod(SSAEnums$ProductType sSAEnums$ProductType, JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("sessionDepth", Integer.toString(jSONObject.optInt("sessionDepth")));
        String strOptString = jSONObject.optString("demandSourceName");
        String strA = com.ironsource.sdk.utils.i.a(jSONObject);
        com.ironsource.sdk.data.d dVarA = this.mDemandSourceManager.a(sSAEnums$ProductType, strA);
        if (dVarA != null) {
            if (dVarA.e() != null) {
                map.putAll(dVarA.e());
            }
            if (!TextUtils.isEmpty(strOptString)) {
                map.put("demandSourceName", strOptString);
            }
            if (!TextUtils.isEmpty(strA)) {
                map.put("demandSourceId", strA);
            }
        }
        Map<String, String> extraParamsByProduct = getExtraParamsByProduct(sSAEnums$ProductType);
        if (extraParamsByProduct != null) {
            map.putAll(extraParamsByProduct);
        }
        String strA2 = com.ironsource.sdk.utils.i.a(map);
        b.f.d.e.a aVarB = b.f.d.e.a.b(sSAEnums$ProductType);
        return generateJSToInject(aVarB.f2732a, strA2, aVarB.f2733b, aVarB.f2734c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void evaluateJavascriptKitKat(String str) {
        evaluateJavascript(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String extractFailFunctionToCall(String str) {
        return new com.ironsource.sdk.data.f(str).d(JSON_KEY_FAIL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String extractSuccessFunctionToCall(String str) {
        return new com.ironsource.sdk.data.f(str).d(JSON_KEY_SUCCESS);
    }

    private String generateJSToInject(String str) {
        return "SSA_CORE.SDKController.runFunction('" + str + "');";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b.f.d.g.a.a getAdProductListenerByProductType(SSAEnums$ProductType sSAEnums$ProductType) {
        if (sSAEnums$ProductType == SSAEnums$ProductType.Interstitial) {
            return this.mDSInterstitialListener;
        }
        if (sSAEnums$ProductType == SSAEnums$ProductType.RewardedVideo) {
            return this.mDSRewardedVideoListener;
        }
        if (sSAEnums$ProductType == SSAEnums$ProductType.Banner) {
            return this.mDSBannerListener;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] getApplicationParams(String str, String str2) {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        Map<String, String> map = null;
        if (TextUtils.isEmpty(str)) {
            z = true;
        } else {
            SSAEnums$ProductType stringProductTypeAsEnum = getStringProductTypeAsEnum(str);
            if (stringProductTypeAsEnum == SSAEnums$ProductType.OfferWall) {
                map = this.mOWExtraParameters;
            } else {
                com.ironsource.sdk.data.d dVarA = this.mDemandSourceManager.a(stringProductTypeAsEnum, str2);
                if (dVarA != null) {
                    Map<String, String> mapE = dVarA.e();
                    mapE.put("demandSourceName", dVarA.d());
                    mapE.put("demandSourceId", dVarA.f());
                    map = mapE;
                }
            }
            try {
                jSONObject.put("productType", str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            try {
                Map<String, String> mapF = com.ironsource.sdk.utils.i.f();
                if (mapF != null) {
                    jSONObject = com.ironsource.sdk.utils.i.a(jSONObject, new JSONObject(mapF));
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            z = false;
        }
        if (TextUtils.isEmpty(this.mUserId)) {
            z = true;
        } else {
            try {
                jSONObject.put(com.ironsource.sdk.utils.i.b("applicationUserId"), com.ironsource.sdk.utils.i.b(this.mUserId));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(this.mApplicationKey)) {
            z = true;
        } else {
            try {
                jSONObject.put(com.ironsource.sdk.utils.i.b("applicationKey"), com.ironsource.sdk.utils.i.b(this.mApplicationKey));
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey().equalsIgnoreCase("sdkWebViewCache")) {
                    setWebviewCache(entry.getValue());
                }
                try {
                    jSONObject.put(com.ironsource.sdk.utils.i.b(entry.getKey()), com.ironsource.sdk.utils.i.b(entry.getValue()));
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            }
        }
        return new Object[]{jSONObject.toString(), Boolean.valueOf(z)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] getDeviceParams(Context context) {
        boolean z;
        com.ironsource.sdk.utils.a aVarB = com.ironsource.sdk.utils.a.b(context);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appOrientation", com.ironsource.sdk.utils.i.c(com.ironsource.environment.b.b(getCurrentActivityContext())));
            String strD = aVarB.d();
            if (strD != null) {
                jSONObject.put(com.ironsource.sdk.utils.i.b("deviceOEM"), com.ironsource.sdk.utils.i.b(strD));
            }
            String strC = aVarB.c();
            if (strC != null) {
                jSONObject.put(com.ironsource.sdk.utils.i.b("deviceModel"), com.ironsource.sdk.utils.i.b(strC));
                z = false;
            } else {
                z = true;
            }
            try {
                com.ironsource.sdk.utils.i.b(context);
                String strB = com.ironsource.sdk.utils.i.b();
                Boolean boolValueOf = Boolean.valueOf(com.ironsource.sdk.utils.i.k());
                if (!TextUtils.isEmpty(strB)) {
                    com.ironsource.sdk.utils.f.c(this.TAG, "add AID and LAT");
                    jSONObject.put("isLimitAdTrackingEnabled", boolValueOf);
                    jSONObject.put("deviceIds[AID]", com.ironsource.sdk.utils.i.b(strB));
                }
                String strE = aVarB.e();
                if (strE != null) {
                    jSONObject.put(com.ironsource.sdk.utils.i.b("deviceOs"), com.ironsource.sdk.utils.i.b(strE));
                } else {
                    z = true;
                }
                String strF = aVarB.f();
                if (strF != null) {
                    jSONObject.put(com.ironsource.sdk.utils.i.b("deviceOSVersion"), strF.replaceAll("[^0-9/.]", ""));
                } else {
                    z = true;
                }
                String strF2 = aVarB.f();
                if (strF2 != null) {
                    jSONObject.put(com.ironsource.sdk.utils.i.b("deviceOSVersionFull"), com.ironsource.sdk.utils.i.b(strF2));
                }
                String strValueOf = String.valueOf(aVarB.a());
                if (strValueOf != null) {
                    jSONObject.put(com.ironsource.sdk.utils.i.b("deviceApiLevel"), strValueOf);
                } else {
                    z = true;
                }
                String strG = com.ironsource.sdk.utils.a.g();
                if (strG != null) {
                    jSONObject.put(com.ironsource.sdk.utils.i.b("SDKVersion"), com.ironsource.sdk.utils.i.b(strG));
                }
                if (aVarB.b() != null && aVarB.b().length() > 0) {
                    jSONObject.put(com.ironsource.sdk.utils.i.b("mobileCarrier"), com.ironsource.sdk.utils.i.b(aVarB.b()));
                }
                String strB2 = b.f.c.b.b(context);
                if (strB2.equals("none")) {
                    z = true;
                } else {
                    jSONObject.put(com.ironsource.sdk.utils.i.b("connectionType"), com.ironsource.sdk.utils.i.b(strB2));
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    jSONObject.put(com.ironsource.sdk.utils.i.b("hasVPN"), b.f.c.b.c(context));
                }
                String language = context.getResources().getConfiguration().locale.getLanguage();
                if (!TextUtils.isEmpty(language)) {
                    jSONObject.put(com.ironsource.sdk.utils.i.b("deviceLanguage"), com.ironsource.sdk.utils.i.b(language.toUpperCase()));
                }
                if (com.ironsource.sdk.utils.i.j()) {
                    jSONObject.put(com.ironsource.sdk.utils.i.b("diskFreeSize"), com.ironsource.sdk.utils.i.b(String.valueOf(com.ironsource.environment.b.a(this.mCacheDirectory))));
                } else {
                    z = true;
                }
                String strValueOf2 = String.valueOf(com.ironsource.environment.b.j());
                if (TextUtils.isEmpty(strValueOf2)) {
                    z = true;
                } else {
                    jSONObject.put(com.ironsource.sdk.utils.i.b("deviceScreenSize") + "[" + com.ironsource.sdk.utils.i.b(ViewHierarchyConstants.DIMENSION_WIDTH_KEY) + "]", com.ironsource.sdk.utils.i.b(strValueOf2));
                }
                jSONObject.put(com.ironsource.sdk.utils.i.b("deviceScreenSize") + "[" + com.ironsource.sdk.utils.i.b(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY) + "]", com.ironsource.sdk.utils.i.b(String.valueOf(com.ironsource.environment.b.d())));
                String strF3 = com.ironsource.environment.a.f(getContext());
                if (!TextUtils.isEmpty(strF3)) {
                    jSONObject.put(com.ironsource.sdk.utils.i.b("bundleId"), com.ironsource.sdk.utils.i.b(strF3));
                }
                String strValueOf3 = String.valueOf(com.ironsource.environment.b.c());
                if (!TextUtils.isEmpty(strValueOf3)) {
                    jSONObject.put(com.ironsource.sdk.utils.i.b("deviceScreenScale"), com.ironsource.sdk.utils.i.b(strValueOf3));
                }
                String strValueOf4 = String.valueOf(com.ironsource.environment.b.n());
                if (!TextUtils.isEmpty(strValueOf4)) {
                    jSONObject.put(com.ironsource.sdk.utils.i.b("unLocked"), com.ironsource.sdk.utils.i.b(strValueOf4));
                }
                jSONObject.put(com.ironsource.sdk.utils.i.b("deviceVolume"), com.ironsource.sdk.utils.a.b(context).a(context));
                Context currentActivityContext = getCurrentActivityContext();
                if (Build.VERSION.SDK_INT >= 19 && (currentActivityContext instanceof Activity)) {
                    jSONObject.put(com.ironsource.sdk.utils.i.b("immersiveMode"), com.ironsource.environment.b.a((Activity) currentActivityContext));
                }
                jSONObject.put(com.ironsource.sdk.utils.i.b("batteryLevel"), com.ironsource.environment.b.e(currentActivityContext));
                jSONObject.put(com.ironsource.sdk.utils.i.b("mcc"), b.f.c.a.b(currentActivityContext));
                jSONObject.put(com.ironsource.sdk.utils.i.b("mnc"), b.f.c.a.c(currentActivityContext));
                jSONObject.put(com.ironsource.sdk.utils.i.b("phoneType"), b.f.c.a.d(currentActivityContext));
                jSONObject.put(com.ironsource.sdk.utils.i.b("simOperator"), com.ironsource.sdk.utils.i.b(b.f.c.a.e(currentActivityContext)));
                jSONObject.put(com.ironsource.sdk.utils.i.b("lastUpdateTime"), com.ironsource.environment.a.e(currentActivityContext));
                jSONObject.put(com.ironsource.sdk.utils.i.b("firstInstallTime"), com.ironsource.environment.a.c(currentActivityContext));
                jSONObject.put(com.ironsource.sdk.utils.i.b("appVersion"), com.ironsource.sdk.utils.i.b(com.ironsource.environment.a.b(currentActivityContext)));
                String strD2 = com.ironsource.environment.a.d(currentActivityContext);
                if (!TextUtils.isEmpty(strD2)) {
                    jSONObject.put(com.ironsource.sdk.utils.i.b("installerPackageName"), com.ironsource.sdk.utils.i.b(strD2));
                }
                addGooglePlayInstalledData(jSONObject);
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                new com.ironsource.sdk.utils.b().execute("https://www.supersonicads.com/mobile/sdk5/log?method=" + e.getStackTrace()[0].getMethodName());
            }
        } catch (JSONException e3) {
            e = e3;
            z = false;
        }
        return new Object[]{jSONObject.toString(), Boolean.valueOf(z)};
    }

    private String getErrorCodeByProductType(SSAEnums$ProductType sSAEnums$ProductType) {
        int i = C2404ka.f15299a[sSAEnums$ProductType.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "Init BN" : "Show OW Credits" : "Init OW" : "Init IS" : "Init RV";
    }

    private Map<String, String> getExtraParamsByProduct(SSAEnums$ProductType sSAEnums$ProductType) {
        if (sSAEnums$ProductType == SSAEnums$ProductType.OfferWall) {
            return this.mOWExtraParameters;
        }
        return null;
    }

    private String getRequestParameters(JSONObject jSONObject) {
        com.ironsource.sdk.utils.a aVarB = com.ironsource.sdk.utils.a.b(getContext());
        StringBuilder sb = new StringBuilder();
        String strG = com.ironsource.sdk.utils.a.g();
        if (!TextUtils.isEmpty(strG)) {
            sb.append("SDKVersion");
            sb.append("=");
            sb.append(strG);
            sb.append("&");
        }
        String strE = aVarB.e();
        if (!TextUtils.isEmpty(strE)) {
            sb.append("deviceOs");
            sb.append("=");
            sb.append(strE);
        }
        Uri uri = Uri.parse(com.ironsource.sdk.utils.i.e());
        if (uri != null) {
            String str = uri.getScheme() + ":";
            String host = uri.getHost();
            int port = uri.getPort();
            if (port != -1) {
                host = host + ":" + port;
            }
            sb.append("&");
            sb.append("protocol");
            sb.append("=");
            sb.append(str);
            sb.append("&");
            sb.append("domain");
            sb.append("=");
            sb.append(host);
            if (jSONObject.keys().hasNext()) {
                try {
                    String string = new JSONObject(jSONObject, new String[]{"isSecured", "applicationKey"}).toString();
                    if (!TextUtils.isEmpty(string)) {
                        sb.append("&");
                        sb.append("controllerConfig");
                        sb.append("=");
                        sb.append(string);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            sb.append("&");
            sb.append("debug");
            sb.append("=");
            sb.append(getDebugMode());
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SSAEnums$ProductType getStringProductTypeAsEnum(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase(SSAEnums$ProductType.Interstitial.toString())) {
            return SSAEnums$ProductType.Interstitial;
        }
        if (str.equalsIgnoreCase(SSAEnums$ProductType.RewardedVideo.toString())) {
            return SSAEnums$ProductType.RewardedVideo;
        }
        if (str.equalsIgnoreCase(SSAEnums$ProductType.OfferWall.toString())) {
            return SSAEnums$ProductType.OfferWall;
        }
        if (str.equalsIgnoreCase(SSAEnums$ProductType.Banner.toString())) {
            return SSAEnums$ProductType.Banner;
        }
        return null;
    }

    private WebView getWebview() {
        return this;
    }

    private void handleLoadAd(com.ironsource.sdk.data.d dVar, Map<String, String> map) {
        Map<String, String> mapA = com.ironsource.sdk.utils.i.a((Map<String, String>[]) new Map[]{map, dVar.a()});
        this.mSavedState.a(dVar.f(), true);
        injectJavascript(generateJSToInject("loadInterstitial", com.ironsource.sdk.utils.i.a(mapA), "onLoadInterstitialSuccess", "onLoadInterstitialFail"));
    }

    private void initLayout(Context context) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.mControllerLayout = new FrameLayout(context);
        this.mCustomViewContainer = new FrameLayout(context);
        this.mCustomViewContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mCustomViewContainer.setVisibility(8);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(this);
        this.mControllerLayout.addView(this.mCustomViewContainer, layoutParams);
        this.mControllerLayout.addView(frameLayout);
    }

    private void initProduct(String str, String str2, SSAEnums$ProductType sSAEnums$ProductType, com.ironsource.sdk.data.d dVar, d dVar2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            dVar2.a("User id or Application key are missing", sSAEnums$ProductType, dVar);
        } else {
            injectJavascript(createInitProductJSMethod(sSAEnums$ProductType, dVar).f15243b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void injectJavascript(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = "console.log(\"JS exeption: \" + JSON.stringify(e));";
        if (getDebugMode() != SSAEnums$DebugMode.MODE_0.getValue() && (getDebugMode() < SSAEnums$DebugMode.MODE_1.getValue() || getDebugMode() > SSAEnums$DebugMode.MODE_3.getValue())) {
            str2 = "empty";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("try{");
        sb.append(str);
        sb.append("}catch(e){");
        sb.append(str2);
        sb.append("}");
        runOnUiThread(new RunnableC2400ia(this, "javascript:" + sb.toString(), sb));
    }

    private String mapToJson(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null && !map.isEmpty()) {
            for (String str : map.keySet()) {
                try {
                    jSONObject.put(str, com.ironsource.sdk.utils.i.b(map.get(str)));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String parseToJson(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                jSONObject.put(str, com.ironsource.sdk.utils.i.b(str2));
            }
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                jSONObject.put(str3, com.ironsource.sdk.utils.i.b(str4));
            }
            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                jSONObject.put(str5, com.ironsource.sdk.utils.i.b(str6));
            }
            if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str8)) {
                jSONObject.put(str7, com.ironsource.sdk.utils.i.b(str8));
            }
            if (!TextUtils.isEmpty(str9)) {
                jSONObject.put(str9, z);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            new com.ironsource.sdk.utils.b().execute("https://www.supersonicads.com/mobile/sdk5/log?method=" + e2.getStackTrace()[0].getMethodName());
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void responseBack(java.lang.String r4, boolean r5, java.lang.String r6, java.lang.String r7) {
        /*
            r3 = this;
            com.ironsource.sdk.data.f r0 = new com.ironsource.sdk.data.f
            r0.<init>(r4)
            java.lang.String r1 = com.ironsource.sdk.controller.WebController.JSON_KEY_SUCCESS
            java.lang.String r1 = r0.d(r1)
            java.lang.String r2 = com.ironsource.sdk.controller.WebController.JSON_KEY_FAIL
            java.lang.String r0 = r0.d(r2)
            if (r5 == 0) goto L1a
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L22
            goto L23
        L1a:
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 != 0) goto L22
            r1 = r0
            goto L23
        L22:
            r1 = 0
        L23:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L5a
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            if (r5 != 0) goto L3e
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> L3e
            r5.<init>(r4)     // Catch: org.json.JSONException -> L3e
            java.lang.String r0 = "errMsg"
            org.json.JSONObject r5 = r5.put(r0, r6)     // Catch: org.json.JSONException -> L3e
            java.lang.String r4 = r5.toString()     // Catch: org.json.JSONException -> L3e
        L3e:
            boolean r5 = android.text.TextUtils.isEmpty(r7)
            if (r5 != 0) goto L53
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> L53
            r5.<init>(r4)     // Catch: org.json.JSONException -> L53
            java.lang.String r6 = "errCode"
            org.json.JSONObject r5 = r5.put(r6, r7)     // Catch: org.json.JSONException -> L53
            java.lang.String r4 = r5.toString()     // Catch: org.json.JSONException -> L53
        L53:
            java.lang.String r4 = r3.generateJSToInject(r1, r4)
            r3.injectJavascript(r4)
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.WebController.responseBack(java.lang.String, boolean, java.lang.String, java.lang.String):void");
    }

    private void sendProductErrorMessage(SSAEnums$ProductType sSAEnums$ProductType, com.ironsource.sdk.data.d dVar) {
        triggerOnControllerInitProductFail(com.ironsource.sdk.utils.i.a(getErrorCodeByProductType(sSAEnums$ProductType), "Initiating Controller"), sSAEnums$ProductType, dVar);
    }

    private void setDisplayZoomControls(WebSettings webSettings) {
        if (Build.VERSION.SDK_INT > 11) {
            webSettings.setDisplayZoomControls(false);
        }
    }

    @SuppressLint({"NewApi"})
    private void setMediaPlaybackJellyBean(WebSettings webSettings) {
        if (Build.VERSION.SDK_INT >= 17) {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        }
    }

    @SuppressLint({"NewApi"})
    private void setWebDebuggingEnabled() {
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    private void setWebViewSettings() {
        WebSettings settings = getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        settings.setAllowFileAccess(true);
        settings.setBuiltInZoomControls(false);
        settings.setJavaScriptEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath("/data/data/org.itri.html5webview/databases/");
        settings.setDomStorageEnabled(true);
        try {
            setDisplayZoomControls(settings);
            setMediaPlaybackJellyBean(settings);
        } catch (Throwable th) {
            com.ironsource.sdk.utils.f.b(this.TAG, "setWebSettings - " + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWebviewBackground(String str) {
        String strD = new com.ironsource.sdk.data.f(str).d("color");
        setBackgroundColor(!"transparent".equalsIgnoreCase(strD) ? Color.parseColor(strD) : 0);
    }

    private void setWebviewCache(String str) {
        if (str.equalsIgnoreCase("0")) {
            getSettings().setCacheMode(2);
        } else {
            getSettings().setCacheMode(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldNotifyDeveloper(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            com.ironsource.sdk.utils.f.a(this.TAG, "Trying to trigger a listener - no product was found");
            return false;
        }
        if (!str.equalsIgnoreCase(SSAEnums$ProductType.Interstitial.toString()) ? !str.equalsIgnoreCase(SSAEnums$ProductType.RewardedVideo.toString()) ? !str.equalsIgnoreCase(SSAEnums$ProductType.Banner.toString()) ? (str.equalsIgnoreCase(SSAEnums$ProductType.OfferWall.toString()) || str.equalsIgnoreCase(SSAEnums$ProductType.OfferWallCredits.toString())) && this.mOnOfferWallListener != null : this.mDSBannerListener != null : this.mDSRewardedVideoListener != null : this.mDSInterstitialListener != null) {
            z = true;
        }
        if (!z) {
            com.ironsource.sdk.utils.f.a(this.TAG, "Trying to trigger a listener - no listener was found for product " + str);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toastingErrMsg(String str, String str2) {
        String strD = new com.ironsource.sdk.data.f(str2).d("errMsg");
        if (TextUtils.isEmpty(strD)) {
            return;
        }
        runOnUiThread(new RunnableC2402ja(this, str, strD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerOnControllerInitProductFail(String str, SSAEnums$ProductType sSAEnums$ProductType, com.ironsource.sdk.data.d dVar) {
        if (shouldNotifyDeveloper(sSAEnums$ProductType.toString())) {
            runOnUiThread(new RunnableC2421ta(this, sSAEnums$ProductType, dVar, str));
        }
    }

    public void addAdViewsJSInterface(C2385b c2385b) {
        this.mAdViewsJsAdapter = c2385b;
        this.mAdViewsJsAdapter.a(getControllerDelegate());
    }

    public void addBannerJSInterface(C2387c c2387c) {
        this.mBannerJsAdapter = c2387c;
        this.mBannerJsAdapter.a(getControllerDelegate());
    }

    public void addDeviceDataJSInterface(G g2) {
        this.mDeviceDataJsAdapter = g2;
    }

    public void addOmidJSInterface(Y y) {
        this.mOmidJsAdapter = y;
    }

    public void addPermissionsJSInterface(C2388ca c2388ca) {
        this.mPermissionsJsAdapter = c2388ca;
    }

    public void addTokenJSInterface(C2396ga c2396ga) {
        this.mTokenJSAdapter = c2396ga;
    }

    public void assetCached(String str, String str2) {
        injectJavascript(generateJSToInject("assetCached", parseToJson(LibStorageUtils.FILE, str, "path", str2, null, null, null, null, null, false)));
    }

    public void assetCachedFailed(String str, String str2, String str3) {
        injectJavascript(generateJSToInject("assetCachedFailed", parseToJson(LibStorageUtils.FILE, str, "path", str2, "errMsg", str3, null, null, null, false)));
    }

    B createControllerMessageHandler(C2392ea c2392ea) {
        return new B(new C2397h(new c()), c2392ea);
    }

    Handler createMainThreadHandler() {
        return new Handler(Looper.getMainLooper());
    }

    C2390da createSecureMessagingInterface(C2392ea c2392ea) {
        return new C2390da(c2392ea);
    }

    @Override // android.webkit.WebView, com.ironsource.sdk.controller.I
    public void destroy() {
        super.destroy();
        b.f.d.h.a aVar = this.downloadManager;
        if (aVar != null) {
            aVar.d();
        }
        com.ironsource.sdk.service.a aVar2 = this.mConnectivityAdapter;
        if (aVar2 != null) {
            aVar2.a();
        }
        this.mUiHandler = null;
        this.mCurrentActivityContext = null;
    }

    public void downloadController() {
        com.ironsource.sdk.utils.e.a(this.mCacheDirectory, "", "mobileController.html");
        String strE = com.ironsource.sdk.utils.i.e();
        com.ironsource.sdk.data.e eVar = new com.ironsource.sdk.data.e(strE, "");
        if (this.downloadManager.c()) {
            com.ironsource.sdk.utils.f.c(this.TAG, "Download Mobile Controller: already alive");
            return;
        }
        com.ironsource.sdk.utils.f.c(this.TAG, "Download Mobile Controller: " + strE);
        this.downloadManager.b(eVar);
    }

    public void engageEnd(String str) {
        if (str.equals("forceClose")) {
            closeWebView();
        }
        injectJavascript(generateJSToInject("engageEnd", parseToJson("action", str, null, null, null, null, null, null, null, false)));
    }

    @Override // com.ironsource.sdk.controller.I
    public void enterBackground() {
        injectJavascript(generateJSToInject("enterBackground"));
    }

    @Override // com.ironsource.sdk.controller.I
    public void enterForeground() {
        injectJavascript(generateJSToInject("enterForeground"));
    }

    public void failedToStartStoreActivity(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "unknown url";
        }
        String str3 = str2;
        if (TextUtils.isEmpty(str)) {
            str = "activity failed to open with unspecified reason";
        }
        injectJavascript(generateJSToInject("failedToStartStoreActivity", parseToJson("errMsg", str, "url", str3, null, null, null, null, null, false)));
    }

    public Xa getControllerDelegate() {
        if (this.mWebViewMessagingMediator == null) {
            this.mWebViewMessagingMediator = new C2408ma(this);
        }
        return this.mWebViewMessagingMediator;
    }

    public String getControllerKeyPressed() {
        String str = this.mControllerKeyPressed;
        setControllerKeyPressed("interrupt");
        return str;
    }

    public Context getCurrentActivityContext() {
        return ((MutableContextWrapper) this.mCurrentActivityContext).getBaseContext();
    }

    public int getDebugMode() {
        return mDebugMode;
    }

    b.f.d.h.a getDownloadManager() {
        return b.f.d.h.a.a(this.mCacheDirectory);
    }

    public FrameLayout getLayout() {
        return this.mControllerLayout;
    }

    @Override // com.ironsource.sdk.controller.I
    public void getOfferWallCredits(String str, String str2, b.f.d.g.e eVar) {
        this.mApplicationKey = str;
        this.mUserId = str2;
        this.mOnOfferWallListener = eVar;
        initProduct(this.mApplicationKey, this.mUserId, SSAEnums$ProductType.OfferWallCredits, null, new C2417ra(this));
    }

    public String getOrientationState() {
        return this.mOrientationState;
    }

    public com.ironsource.sdk.data.c getSavedState() {
        return this.mSavedState;
    }

    public State getState() {
        return this.mState;
    }

    public boolean handleSearchKeysURLs(String str) {
        List<String> listC = com.ironsource.sdk.utils.d.d().c();
        if (listC == null) {
            return false;
        }
        try {
            if (listC.isEmpty()) {
                return false;
            }
            Iterator<String> it = listC.iterator();
            while (it.hasNext()) {
                if (str.contains(it.next())) {
                    com.ironsource.environment.d.a(getCurrentActivityContext(), str);
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void hideCustomView() {
        this.mWebChromeClient.onHideCustomView();
    }

    public boolean inCustomView() {
        return this.mCustomView != null;
    }

    @Override // com.ironsource.sdk.controller.I
    public void initBanner(String str, String str2, com.ironsource.sdk.data.d dVar, b.f.d.g.a.b bVar) {
        this.mApplicationKey = str;
        this.mUserId = str2;
        this.mDSBannerListener = bVar;
        initProduct(str, str2, SSAEnums$ProductType.Banner, dVar, new C2419sa(this));
    }

    @Override // com.ironsource.sdk.controller.I
    public void initInterstitial(String str, String str2, com.ironsource.sdk.data.d dVar, b.f.d.g.a.c cVar) {
        this.mApplicationKey = str;
        this.mUserId = str2;
        this.mDSInterstitialListener = cVar;
        this.mSavedState.b(this.mApplicationKey);
        this.mSavedState.c(this.mUserId);
        initProduct(this.mApplicationKey, this.mUserId, SSAEnums$ProductType.Interstitial, dVar, new C2414pa(this));
    }

    @Override // com.ironsource.sdk.controller.I
    public void initOfferWall(String str, String str2, Map<String, String> map, b.f.d.g.e eVar) {
        this.mApplicationKey = str;
        this.mUserId = str2;
        this.mOWExtraParameters = map;
        this.mOnOfferWallListener = eVar;
        this.mSavedState.a(this.mOWExtraParameters);
        this.mSavedState.b(true);
        initProduct(this.mApplicationKey, this.mUserId, SSAEnums$ProductType.OfferWall, null, new C2416qa(this));
    }

    @Override // com.ironsource.sdk.controller.I
    public void initRewardedVideo(String str, String str2, com.ironsource.sdk.data.d dVar, b.f.d.g.a.d dVar2) {
        this.mApplicationKey = str;
        this.mUserId = str2;
        this.mDSRewardedVideoListener = dVar2;
        this.mSavedState.d(str);
        this.mSavedState.e(str2);
        initProduct(str, str2, SSAEnums$ProductType.RewardedVideo, dVar, new C2412oa(this));
    }

    String initializeCacheDirectory(Context context) {
        return com.ironsource.sdk.utils.e.b(context.getApplicationContext());
    }

    public void interceptedUrlToStore() {
        injectJavascript(generateJSToInject("interceptedUrlToStore"));
    }

    @Override // com.ironsource.sdk.controller.I
    public boolean isInterstitialAdAvailable(String str) {
        com.ironsource.sdk.data.d dVarA = this.mDemandSourceManager.a(SSAEnums$ProductType.Interstitial, str);
        return dVarA != null && dVarA.b();
    }

    public void load(int i) {
        try {
            loadUrl("about:blank");
        } catch (Throwable th) {
            com.ironsource.sdk.utils.f.b(this.TAG, "WebViewController:: load: " + th.toString());
            new com.ironsource.sdk.utils.b().execute("https://www.supersonicads.com/mobile/sdk5/log?method=webviewLoadBlank");
        }
        String str = "file://" + this.mCacheDirectory + File.separator + "mobileController.html";
        if (!new File(this.mCacheDirectory + File.separator + "mobileController.html").exists()) {
            com.ironsource.sdk.utils.f.c(this.TAG, "load(): Mobile Controller HTML Does not exist");
            new com.ironsource.sdk.utils.b().execute("https://www.supersonicads.com/mobile/sdk5/log?method=htmlControllerDoesNotExistOnFileSystem");
            return;
        }
        JSONObject jSONObjectD = com.ironsource.sdk.utils.i.d();
        setWebDebuggingEnabled(jSONObjectD);
        String requestParameters = getRequestParameters(jSONObjectD);
        Map<String, String> mapF = com.ironsource.sdk.utils.i.f();
        if (mapF != null && mapF.containsKey("sessionid")) {
            requestParameters = String.format("%s&sessionid=%s", requestParameters, mapF.get("sessionid"));
        }
        String str2 = str + "?" + requestParameters;
        this.mLoadControllerTimer = new CountDownTimerC2410na(this, 50000L, 1000L, i).start();
        try {
            loadUrl(str2);
        } catch (Throwable th2) {
            com.ironsource.sdk.utils.f.b(this.TAG, "WebViewController:: load: " + th2.toString());
            new com.ironsource.sdk.utils.b().execute("https://www.supersonicads.com/mobile/sdk5/log?method=webviewLoadWithPath");
        }
        com.ironsource.sdk.utils.f.c(this.TAG, "load(): " + str2);
    }

    @Override // com.ironsource.sdk.controller.I
    public void loadBanner(JSONObject jSONObject, b.f.d.g.a.b bVar) {
        if (jSONObject != null) {
            injectJavascript(generateJSToInject("loadBanner", jSONObject.toString(), "onLoadBannerSuccess", "onLoadBannerFail"));
        }
    }

    @Override // com.ironsource.sdk.controller.I
    public void loadInterstitial(String str, b.f.d.g.a.c cVar) {
        HashMap map = new HashMap();
        map.put("demandSourceName", str);
        String strA = com.ironsource.sdk.utils.i.a(map);
        this.mSavedState.a(str, true);
        injectJavascript(generateJSToInject("loadInterstitial", strA, "onLoadInterstitialSuccess", "onLoadInterstitialFail"));
    }

    public void nativeNavigationPressed(String str) {
        injectJavascript(generateJSToInject("nativeNavigationPressed", parseToJson("action", str, null, null, null, null, null, null, null, false)));
    }

    public void notifyLifeCycle(String str, String str2) {
        injectJavascript(generateJSToInject("onNativeLifeCycleEvent", parseToJson("lifeCycleEvent", str2, "productType", str, null, null, null, null, null, false)));
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        com.ironsource.sdk.utils.f.c(this.TAG, str + " " + str4);
    }

    @Override // b.f.d.h.a.c
    public void onFileDownloadFail(com.ironsource.sdk.data.e eVar) {
        if (!eVar.c().contains("mobileController.html")) {
            assetCachedFailed(eVar.c(), eVar.e(), eVar.b());
            return;
        }
        this.mControllerListener.a("controller failed to download - " + eVar.b());
    }

    @Override // b.f.d.h.a.c
    public void onFileDownloadSuccess(com.ironsource.sdk.data.e eVar) {
        if (eVar.c().contains("mobileController.html")) {
            load(1);
        } else {
            assetCached(eVar.c(), eVar.e());
        }
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.mChangeListener.onBackButtonPressed()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void pageFinished() {
        injectJavascript(generateJSToInject("pageFinished"));
    }

    public void pause() {
        if (Build.VERSION.SDK_INT > 10) {
            try {
                onPause();
            } catch (Throwable th) {
                com.ironsource.sdk.utils.f.c(this.TAG, "WebViewController: pause() - " + th);
                new com.ironsource.sdk.utils.b().execute("https://www.supersonicads.com/mobile/sdk5/log?method=webviewPause");
            }
        }
    }

    @Override // com.ironsource.sdk.controller.I
    public void registerConnectionReceiver(Context context) {
        com.ironsource.sdk.service.a aVar = this.mConnectivityAdapter;
        if (aVar == null) {
            return;
        }
        aVar.b(context);
    }

    public void removeVideoEventsListener() {
        this.mVideoEventsListener = null;
    }

    @Override // com.ironsource.sdk.controller.I
    public void restoreSavedState() {
        restoreState(this.mSavedState);
    }

    public void restoreState(com.ironsource.sdk.data.c cVar) {
        synchronized (this.mSavedStateLocker) {
            if (cVar.k() && this.mIsWebControllerReady) {
                Log.d(this.TAG, "restoreState(state:" + cVar + ")");
                int iC = cVar.c();
                if (iC != -1) {
                    if (iC == SSAEnums$ProductType.RewardedVideo.ordinal()) {
                        Log.d(this.TAG, "onRVAdClosed()");
                        SSAEnums$ProductType sSAEnums$ProductType = SSAEnums$ProductType.RewardedVideo;
                        String strB = cVar.b();
                        b.f.d.g.a.a adProductListenerByProductType = getAdProductListenerByProductType(sSAEnums$ProductType);
                        if (adProductListenerByProductType != null && !TextUtils.isEmpty(strB)) {
                            adProductListenerByProductType.b(sSAEnums$ProductType, strB);
                        }
                    } else if (iC == SSAEnums$ProductType.Interstitial.ordinal()) {
                        Log.d(this.TAG, "onInterstitialAdClosed()");
                        SSAEnums$ProductType sSAEnums$ProductType2 = SSAEnums$ProductType.Interstitial;
                        String strB2 = cVar.b();
                        b.f.d.g.a.a adProductListenerByProductType2 = getAdProductListenerByProductType(sSAEnums$ProductType2);
                        if (adProductListenerByProductType2 != null && !TextUtils.isEmpty(strB2)) {
                            adProductListenerByProductType2.b(sSAEnums$ProductType2, strB2);
                        }
                    } else if (iC == SSAEnums$ProductType.OfferWall.ordinal()) {
                        Log.d(this.TAG, "onOWAdClosed()");
                        if (this.mOnOfferWallListener != null) {
                            this.mOnOfferWallListener.onOWAdClosed();
                        }
                    }
                    cVar.b(-1);
                    cVar.a((String) null);
                } else {
                    Log.d(this.TAG, "No ad was opened");
                }
                String strE = cVar.e();
                String strF = cVar.f();
                for (com.ironsource.sdk.data.d dVar : this.mDemandSourceManager.a(SSAEnums$ProductType.Interstitial)) {
                    if (dVar.c() == 2) {
                        Log.d(this.TAG, "initInterstitial(appKey:" + strE + ", userId:" + strF + ", demandSource:" + dVar.d() + ")");
                        initInterstitial(strE, strF, dVar, this.mDSInterstitialListener);
                    }
                }
                String strH = cVar.h();
                String strI = cVar.i();
                for (com.ironsource.sdk.data.d dVar2 : this.mDemandSourceManager.a(SSAEnums$ProductType.RewardedVideo)) {
                    if (dVar2.c() == 2) {
                        String strD = dVar2.d();
                        Log.d(this.TAG, "onRVNoMoreOffers()");
                        this.mDSRewardedVideoListener.b(strD);
                        Log.d(this.TAG, "initRewardedVideo(appKey:" + strH + ", userId:" + strI + ", demandSource:" + strD + ")");
                        initRewardedVideo(strH, strI, dVar2, this.mDSRewardedVideoListener);
                    }
                }
                cVar.c(false);
            }
            this.mSavedState = cVar;
        }
    }

    public void resume() {
        if (Build.VERSION.SDK_INT > 10) {
            try {
                onResume();
            } catch (Throwable th) {
                com.ironsource.sdk.utils.f.c(this.TAG, "WebViewController: onResume() - " + th);
                new com.ironsource.sdk.utils.b().execute("https://www.supersonicads.com/mobile/sdk5/log?method=webviewResume");
            }
        }
    }

    void runOnUiThread(Runnable runnable) {
        Handler handler = this.mUiHandler;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    @Override // android.webkit.WebView
    public WebBackForwardList saveState(Bundle bundle) {
        return super.saveState(bundle);
    }

    public void sendConnectionInfoChanged(JSONObject jSONObject) {
        com.ironsource.sdk.utils.f.c(this.TAG, "device connection info changed: " + jSONObject.toString());
        injectJavascript(generateJSToInject("connectionInfoChanged", parseToJson("connectionInfo", jSONObject.toString(), null, null, null, null, null, null, null, false)));
    }

    public void sendConnectionTypeChanged(String str) {
        com.ironsource.sdk.utils.f.c(this.TAG, "device status changed, connection type " + str);
        b.f.d.a.c.a(str);
        injectJavascript(generateJSToInject("deviceStatusChanged", parseToJson("connectionType", str, null, null, null, null, null, null, null, false)));
    }

    @Override // com.ironsource.sdk.controller.I
    public void setCommunicationWithAdView(ISNAdView iSNAdView) {
        C2387c c2387c = this.mBannerJsAdapter;
        if (c2387c != null) {
            c2387c.a(iSNAdView);
        }
    }

    public void setControllerKeyPressed(String str) {
        this.mControllerKeyPressed = str;
    }

    public void setDebugMode(int i) {
        mDebugMode = i;
    }

    void setMissProduct(SSAEnums$ProductType sSAEnums$ProductType, com.ironsource.sdk.data.d dVar) {
        if (sSAEnums$ProductType == SSAEnums$ProductType.RewardedVideo || sSAEnums$ProductType == SSAEnums$ProductType.Interstitial || sSAEnums$ProductType == SSAEnums$ProductType.Banner) {
            if (dVar != null) {
                dVar.b(1);
            }
        } else if (sSAEnums$ProductType == SSAEnums$ProductType.OfferWall) {
            this.mOWmiss = true;
        } else if (sSAEnums$ProductType == SSAEnums$ProductType.OfferWallCredits) {
            this.mOWCreditsMiss = true;
        }
        com.ironsource.sdk.utils.f.c(this.TAG, "setMissProduct(" + sSAEnums$ProductType + ")");
    }

    public void setOnWebViewControllerChangeListener(b.f.d.g.g gVar) {
        this.mChangeListener = gVar;
    }

    public void setOrientationState(String str) {
        this.mOrientationState = str;
    }

    public void setState(State state) {
        this.mState = state;
    }

    public void setVideoEventsListener(InterfaceC2398ha interfaceC2398ha) {
        this.mVideoEventsListener = interfaceC2398ha;
    }

    @Override // com.ironsource.sdk.controller.I
    public void showInterstitial(JSONObject jSONObject, b.f.d.g.a.c cVar) {
        injectJavascript(createShowProductJSMethod(SSAEnums$ProductType.Interstitial, jSONObject));
    }

    @Override // com.ironsource.sdk.controller.I
    public void showOfferWall(Map<String, String> map) {
        this.mOWExtraParameters = map;
        injectJavascript(generateJSToInject("showOfferWall", "onShowOfferWallSuccess", "onShowOfferWallFail"));
    }

    @Override // com.ironsource.sdk.controller.I
    public void showRewardedVideo(JSONObject jSONObject, b.f.d.g.a.d dVar) {
        injectJavascript(createShowProductJSMethod(SSAEnums$ProductType.RewardedVideo, jSONObject));
    }

    @Override // com.ironsource.sdk.controller.I
    public void unregisterConnectionReceiver(Context context) {
        com.ironsource.sdk.service.a aVar = this.mConnectivityAdapter;
        if (aVar == null) {
            return;
        }
        aVar.c(context);
    }

    @Override // com.ironsource.sdk.controller.I
    public void updateConsentInfo(JSONObject jSONObject) {
        injectJavascript(generateJSToInject("updateConsentInfo", jSONObject != null ? jSONObject.toString() : null));
    }

    public void viewableChange(boolean z, String str) {
        injectJavascript(generateJSToInject("viewableChange", parseToJson("webview", str, null, null, null, null, null, null, "isViewable", z)));
    }

    public class c {
        public c() {
        }

        private void a(JSONObject jSONObject) {
            try {
                H hB = H.b();
                if (hB.c().isEmpty()) {
                    return;
                }
                jSONObject.put("nativeFeatures", new JSONArray((Collection) hB.c()));
            } catch (Exception e2) {
                b.f.d.a.a aVar = new b.f.d.a.a();
                aVar.a("callfailreason", e2.getMessage());
                b.f.d.a.e.a(b.f.d.a.g.n, aVar.a());
                com.ironsource.sdk.utils.f.a(WebController.this.TAG, "getControllerConfig Error while adding supported features data from FeaturesManager");
            }
        }

        private void b(JSONObject jSONObject) {
            a(jSONObject);
            a(jSONObject, com.ironsource.sdk.utils.i.i());
        }

        @JavascriptInterface
        public void adClicked(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "adClicked(" + str + ")");
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
            String strD = fVar.d("productType");
            String strA = com.ironsource.sdk.utils.i.a(fVar);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            SSAEnums$ProductType stringProductTypeAsEnum = WebController.this.getStringProductTypeAsEnum(strD);
            b.f.d.g.a.a adProductListenerByProductType = WebController.this.getAdProductListenerByProductType(stringProductTypeAsEnum);
            if (stringProductTypeAsEnum == null || adProductListenerByProductType == null) {
                return;
            }
            WebController.this.runOnUiThread(new RunnableC2427wa(this, adProductListenerByProductType, stringProductTypeAsEnum, strA));
        }

        @JavascriptInterface
        public void adCredited(String str) {
            String strD;
            boolean z;
            boolean z2;
            Log.d(WebController.this.PUB_TAG, "adCredited(" + str + ")");
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
            String strD2 = fVar.d("credits");
            boolean z3 = false;
            int i = strD2 != null ? Integer.parseInt(strD2) : 0;
            String strA = com.ironsource.sdk.utils.i.a(fVar);
            String strD3 = fVar.d("productType");
            if (TextUtils.isEmpty(strD3)) {
                Log.d(WebController.this.PUB_TAG, "adCredited | not product NAME !!!!");
            }
            if (SSAEnums$ProductType.Interstitial.toString().equalsIgnoreCase(strD3)) {
                a(strA, i);
                return;
            }
            String strD4 = fVar.d("total");
            int i2 = strD4 != null ? Integer.parseInt(strD4) : 0;
            fVar.c("externalPoll");
            if (!SSAEnums$ProductType.OfferWall.toString().equalsIgnoreCase(strD3)) {
                strD = null;
                z = false;
                z2 = false;
            } else {
                if (fVar.e(InAppPurchaseMetaData.KEY_SIGNATURE) || fVar.e("timestamp") || fVar.e("totalCreditsFlag")) {
                    WebController.this.responseBack(str, false, "One of the keys are missing: signature/timestamp/totalCreditsFlag", null);
                    return;
                }
                if (fVar.d(InAppPurchaseMetaData.KEY_SIGNATURE).equalsIgnoreCase(com.ironsource.sdk.utils.i.d(strD4 + WebController.this.mApplicationKey + WebController.this.mUserId))) {
                    z3 = true;
                } else {
                    WebController.this.responseBack(str, false, "Controller signature is not equal to SDK signature", null);
                }
                boolean zC = fVar.c("totalCreditsFlag");
                strD = fVar.d("timestamp");
                z2 = zC;
                z = z3;
            }
            if (WebController.this.shouldNotifyDeveloper(strD3)) {
                WebController.this.runOnUiThread(new Qa(this, strD3, strA, i, z, i2, z2, strD, str));
            }
        }

        @JavascriptInterface
        public void adUnitsReady(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "adUnitsReady(" + str + ")");
            String strA = com.ironsource.sdk.utils.i.a(new com.ironsource.sdk.data.f(str));
            com.ironsource.sdk.data.a aVar = new com.ironsource.sdk.data.a(str);
            if (!aVar.d()) {
                WebController.this.responseBack(str, false, "Num Of Ad Units Do Not Exist", null);
                return;
            }
            WebController.this.responseBack(str, true, null, null);
            String strC = aVar.c();
            if (SSAEnums$ProductType.RewardedVideo.toString().equalsIgnoreCase(strC) && WebController.this.shouldNotifyDeveloper(strC)) {
                WebController.this.runOnUiThread(new Pa(this, aVar, strA));
            }
        }

        @JavascriptInterface
        public void adViewAPI(String str) {
            try {
                com.ironsource.sdk.utils.f.c(WebController.this.TAG, "adViewAPI(" + str + ")");
                WebController.this.mAdViewsJsAdapter.a(new com.ironsource.sdk.data.f(str).toString(), new a());
            } catch (Exception e2) {
                e2.printStackTrace();
                com.ironsource.sdk.utils.f.c(WebController.this.TAG, "adViewAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void bannerViewAPI(String str) {
            try {
                WebController.this.mBannerJsAdapter.a(str);
            } catch (Exception e2) {
                e2.printStackTrace();
                com.ironsource.sdk.utils.f.b(WebController.this.TAG, "bannerViewAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void deleteFile(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "deleteFile(" + str + ")");
            com.ironsource.sdk.data.e eVar = new com.ironsource.sdk.data.e(str);
            if (!com.ironsource.sdk.utils.e.c(WebController.this.mCacheDirectory, eVar.e())) {
                WebController.this.responseBack(str, false, "File not exist", "1");
            } else {
                WebController.this.responseBack(str, com.ironsource.sdk.utils.e.a(WebController.this.mCacheDirectory, eVar.e(), eVar.c()), null, null);
            }
        }

        @JavascriptInterface
        public void deleteFolder(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "deleteFolder(" + str + ")");
            com.ironsource.sdk.data.e eVar = new com.ironsource.sdk.data.e(str);
            if (!com.ironsource.sdk.utils.e.c(WebController.this.mCacheDirectory, eVar.e())) {
                WebController.this.responseBack(str, false, "Folder not exist", "1");
            } else {
                WebController.this.responseBack(str, com.ironsource.sdk.utils.e.a(WebController.this.mCacheDirectory, eVar.e()), null, null);
            }
        }

        @JavascriptInterface
        public void deviceDataAPI(String str) {
            try {
                com.ironsource.sdk.utils.f.c(WebController.this.TAG, "deviceDataAPI(" + str + ")");
                WebController.this.mDeviceDataJsAdapter.a(new com.ironsource.sdk.data.f(str).toString(), new a());
            } catch (Exception e2) {
                e2.printStackTrace();
                com.ironsource.sdk.utils.f.c(WebController.this.TAG, "deviceDataAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void displayWebView(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "displayWebView(" + str + ")");
            WebController.this.responseBack(str, true, null, null);
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
            boolean zBooleanValue = ((Boolean) fVar.b(ServerProtocol.DIALOG_PARAM_DISPLAY)).booleanValue();
            String strD = fVar.d("productType");
            boolean zC = fVar.c("standaloneView");
            String strD2 = fVar.d("adViewId");
            String strA = com.ironsource.sdk.utils.i.a(fVar);
            if (!zBooleanValue) {
                WebController.this.setState(State.Gone);
                WebController.this.closeWebView();
                return;
            }
            WebController.this.mIsImmersive = fVar.c("immersive");
            boolean zC2 = fVar.c("activityThemeTranslucent");
            State state = WebController.this.getState();
            State state2 = State.Display;
            if (state == state2) {
                com.ironsource.sdk.utils.f.c(WebController.this.TAG, "State: " + WebController.this.mState);
                return;
            }
            WebController.this.setState(state2);
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "State: " + WebController.this.mState);
            Context currentActivityContext = WebController.this.getCurrentActivityContext();
            String orientationState = WebController.this.getOrientationState();
            int iD = com.ironsource.environment.b.d(currentActivityContext);
            if (zC) {
                ControllerView controllerView = new ControllerView(currentActivityContext);
                controllerView.addView(WebController.this.mControllerLayout);
                controllerView.showInterstitial(WebController.this);
                return;
            }
            Intent intent = zC2 ? new Intent(currentActivityContext, (Class<?>) InterstitialActivity.class) : new Intent(currentActivityContext, (Class<?>) ControllerActivity.class);
            if (SSAEnums$ProductType.RewardedVideo.toString().equalsIgnoreCase(strD)) {
                if ("application".equals(orientationState)) {
                    orientationState = com.ironsource.sdk.utils.i.c(com.ironsource.environment.b.b(WebController.this.getCurrentActivityContext()));
                }
                intent.putExtra("productType", SSAEnums$ProductType.RewardedVideo.toString());
                WebController.this.mSavedState.b(SSAEnums$ProductType.RewardedVideo.ordinal());
                WebController.this.mSavedState.a(strA);
                if (WebController.this.shouldNotifyDeveloper(SSAEnums$ProductType.RewardedVideo.toString())) {
                    WebController.this.mDSRewardedVideoListener.a(SSAEnums$ProductType.RewardedVideo, strA);
                }
            } else if (SSAEnums$ProductType.OfferWall.toString().equalsIgnoreCase(strD)) {
                intent.putExtra("productType", SSAEnums$ProductType.OfferWall.toString());
                WebController.this.mSavedState.b(SSAEnums$ProductType.OfferWall.ordinal());
            } else if (SSAEnums$ProductType.Interstitial.toString().equalsIgnoreCase(strD)) {
                if ("application".equals(orientationState)) {
                    orientationState = com.ironsource.sdk.utils.i.c(com.ironsource.environment.b.b(WebController.this.getCurrentActivityContext()));
                }
                intent.putExtra("productType", SSAEnums$ProductType.Interstitial.toString());
            }
            if (strD2 != null) {
                intent.putExtra("adViewId", strD2);
            }
            intent.setFlags(536870912);
            intent.putExtra("immersive", WebController.this.mIsImmersive);
            intent.putExtra("orientation_set_flag", orientationState);
            intent.putExtra("rotation_set_flag", iD);
            currentActivityContext.startActivity(intent);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0062  */
        @android.webkit.JavascriptInterface
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void getApplicationInfo(java.lang.String r5) {
            /*
                r4 = this;
                com.ironsource.sdk.controller.WebController r0 = com.ironsource.sdk.controller.WebController.this
                java.lang.String r0 = com.ironsource.sdk.controller.WebController.access$600(r0)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getApplicationInfo("
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ")"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.ironsource.sdk.utils.f.c(r0, r1)
                com.ironsource.sdk.controller.WebController r0 = com.ironsource.sdk.controller.WebController.this
                java.lang.String r0 = com.ironsource.sdk.controller.WebController.access$1800(r0, r5)
                com.ironsource.sdk.controller.WebController r1 = com.ironsource.sdk.controller.WebController.this
                java.lang.String r1 = com.ironsource.sdk.controller.WebController.access$1900(r1, r5)
                com.ironsource.sdk.data.f r2 = new com.ironsource.sdk.data.f
                r2.<init>(r5)
                java.lang.String r5 = "productType"
                java.lang.String r5 = r2.d(r5)
                java.lang.String r2 = com.ironsource.sdk.utils.i.a(r2)
                r3 = 2
                java.lang.Object[] r3 = new java.lang.Object[r3]
                com.ironsource.sdk.controller.WebController r3 = com.ironsource.sdk.controller.WebController.this
                java.lang.Object[] r5 = com.ironsource.sdk.controller.WebController.access$2600(r3, r5, r2)
                r2 = 0
                r2 = r5[r2]
                java.lang.String r2 = (java.lang.String) r2
                r3 = 1
                r5 = r5[r3]
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L5b
                boolean r5 = android.text.TextUtils.isEmpty(r1)
                if (r5 != 0) goto L62
                r0 = r1
                goto L63
            L5b:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L62
                goto L63
            L62:
                r0 = 0
            L63:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L78
                com.ironsource.sdk.controller.WebController r5 = com.ironsource.sdk.controller.WebController.this
                java.lang.String r1 = "onGetApplicationInfoSuccess"
                java.lang.String r3 = "onGetApplicationInfoFail"
                java.lang.String r5 = com.ironsource.sdk.controller.WebController.access$2100(r5, r0, r2, r1, r3)
                com.ironsource.sdk.controller.WebController r0 = com.ironsource.sdk.controller.WebController.this
                com.ironsource.sdk.controller.WebController.access$500(r0, r5)
            L78:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.WebController.c.getApplicationInfo(java.lang.String):void");
        }

        @JavascriptInterface
        public void getCachedFilesMap(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "getCachedFilesMap(" + str + ")");
            String strExtractSuccessFunctionToCall = WebController.this.extractSuccessFunctionToCall(str);
            if (TextUtils.isEmpty(strExtractSuccessFunctionToCall)) {
                return;
            }
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
            if (!fVar.a("path")) {
                WebController.this.responseBack(str, false, "path key does not exist", null);
                return;
            }
            String str2 = (String) fVar.b("path");
            if (!com.ironsource.sdk.utils.e.c(WebController.this.mCacheDirectory, str2)) {
                WebController.this.responseBack(str, false, "path file does not exist on disk", null);
                return;
            }
            WebController.this.injectJavascript(WebController.this.generateJSToInject(strExtractSuccessFunctionToCall, com.ironsource.sdk.utils.e.b(WebController.this.mCacheDirectory, str2), "onGetCachedFilesMapSuccess", "onGetCachedFilesMapFail"));
        }

        @JavascriptInterface
        public void getConnectivityInfo(String str) {
            String strGenerateJSToInject;
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "getConnectivityInfo(" + str + ")");
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
            String strD = fVar.d(WebController.JSON_KEY_SUCCESS);
            String strD2 = fVar.d(WebController.JSON_KEY_FAIL);
            JSONObject jSONObject = new JSONObject();
            if (WebController.this.mConnectivityAdapter != null) {
                jSONObject = WebController.this.mConnectivityAdapter.a(WebController.this.getContext());
            }
            if (jSONObject.length() > 0) {
                strGenerateJSToInject = WebController.this.generateJSToInject(strD, jSONObject.toString());
            } else {
                strGenerateJSToInject = WebController.this.generateJSToInject(strD2, WebController.this.parseToJson("errMsg", "failed to retrieve connection info", null, null, null, null, null, null, null, false));
            }
            WebController.this.injectJavascript(strGenerateJSToInject);
        }

        @JavascriptInterface
        public void getControllerConfig(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "getControllerConfig(" + str + ")");
            String strD = new com.ironsource.sdk.data.f(str).d(WebController.JSON_KEY_SUCCESS);
            if (TextUtils.isEmpty(strD)) {
                return;
            }
            JSONObject jSONObjectD = com.ironsource.sdk.utils.i.d();
            b(jSONObjectD);
            WebController.this.injectJavascript(WebController.this.generateJSToInject(strD, jSONObjectD.toString()));
        }

        @JavascriptInterface
        public void getDemandSourceState(String str) {
            String strExtractFailFunctionToCall;
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "getMediationState(" + str + ")");
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
            String strD = fVar.d("demandSourceName");
            String strA = com.ironsource.sdk.utils.i.a(fVar);
            String strD2 = fVar.d("productType");
            if (strD2 == null || strD == null) {
                return;
            }
            try {
                SSAEnums$ProductType sSAEnums$ProductTypeE = com.ironsource.sdk.utils.i.e(strD2);
                if (sSAEnums$ProductTypeE != null) {
                    com.ironsource.sdk.data.d dVarA = WebController.this.mDemandSourceManager.a(sSAEnums$ProductTypeE, strA);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("productType", strD2);
                    jSONObject.put("demandSourceName", strD);
                    jSONObject.put("demandSourceId", strA);
                    if (dVarA == null || dVarA.a(-1)) {
                        strExtractFailFunctionToCall = WebController.this.extractFailFunctionToCall(str);
                    } else {
                        strExtractFailFunctionToCall = WebController.this.extractSuccessFunctionToCall(str);
                        jSONObject.put(ServerProtocol.DIALOG_PARAM_STATE, dVarA.h());
                    }
                    a(strExtractFailFunctionToCall, jSONObject.toString());
                }
            } catch (Exception e2) {
                WebController.this.responseBack(str, false, e2.getMessage(), null);
                e2.printStackTrace();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0057  */
        @android.webkit.JavascriptInterface
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void getDeviceStatus(java.lang.String r5) {
            /*
                r4 = this;
                com.ironsource.sdk.controller.WebController r0 = com.ironsource.sdk.controller.WebController.this
                java.lang.String r0 = com.ironsource.sdk.controller.WebController.access$600(r0)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getDeviceStatus("
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ")"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.ironsource.sdk.utils.f.c(r0, r1)
                com.ironsource.sdk.controller.WebController r0 = com.ironsource.sdk.controller.WebController.this
                java.lang.String r0 = com.ironsource.sdk.controller.WebController.access$1800(r0, r5)
                com.ironsource.sdk.controller.WebController r1 = com.ironsource.sdk.controller.WebController.this
                java.lang.String r5 = com.ironsource.sdk.controller.WebController.access$1900(r1, r5)
                r1 = 2
                java.lang.Object[] r1 = new java.lang.Object[r1]
                com.ironsource.sdk.controller.WebController r1 = com.ironsource.sdk.controller.WebController.this
                android.content.Context r2 = r1.getContext()
                java.lang.Object[] r1 = com.ironsource.sdk.controller.WebController.access$2000(r1, r2)
                r2 = 0
                r2 = r1[r2]
                java.lang.String r2 = (java.lang.String) r2
                r3 = 1
                r1 = r1[r3]
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                boolean r1 = r1.booleanValue()
                if (r1 == 0) goto L50
                boolean r0 = android.text.TextUtils.isEmpty(r5)
                if (r0 != 0) goto L57
                r0 = r5
                goto L58
            L50:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L57
                goto L58
            L57:
                r0 = 0
            L58:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L6d
                com.ironsource.sdk.controller.WebController r5 = com.ironsource.sdk.controller.WebController.this
                java.lang.String r1 = "onGetDeviceStatusSuccess"
                java.lang.String r3 = "onGetDeviceStatusFail"
                java.lang.String r5 = com.ironsource.sdk.controller.WebController.access$2100(r5, r0, r2, r1, r3)
                com.ironsource.sdk.controller.WebController r0 = com.ironsource.sdk.controller.WebController.this
                com.ironsource.sdk.controller.WebController.access$500(r0, r5)
            L6d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.WebController.c.getDeviceStatus(java.lang.String):void");
        }

        @JavascriptInterface
        public void getDeviceVolume(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "getDeviceVolume(" + str + ")");
            try {
                float fA = com.ironsource.sdk.utils.a.b(WebController.this.getCurrentActivityContext()).a(WebController.this.getCurrentActivityContext());
                com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
                fVar.a("deviceVolume", String.valueOf(fA));
                WebController.this.responseBack(fVar.toString(), true, null, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @JavascriptInterface
        public void getOrientation(String str) {
            String strExtractSuccessFunctionToCall = WebController.this.extractSuccessFunctionToCall(str);
            String string = com.ironsource.sdk.utils.i.a(WebController.this.getCurrentActivityContext()).toString();
            if (TextUtils.isEmpty(strExtractSuccessFunctionToCall)) {
                return;
            }
            WebController.this.injectJavascript(WebController.this.generateJSToInject(strExtractSuccessFunctionToCall, string, "onGetOrientationSuccess", "onGetOrientationFail"));
        }

        @JavascriptInterface
        public void getUserData(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "getUserData(" + str + ")");
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
            if (!fVar.a("key")) {
                WebController.this.responseBack(str, false, "key does not exist", null);
                return;
            }
            String strExtractSuccessFunctionToCall = WebController.this.extractSuccessFunctionToCall(str);
            String strD = fVar.d("key");
            WebController.this.injectJavascript(WebController.this.generateJSToInject(strExtractSuccessFunctionToCall, WebController.this.parseToJson(strD, com.ironsource.sdk.utils.d.d().b(strD), null, null, null, null, null, null, null, false)));
        }

        @JavascriptInterface
        public void iabTokenAPI(String str) {
            try {
                com.ironsource.sdk.utils.f.c(WebController.this.TAG, "iabTokenAPI(" + str + ")");
                WebController.this.mTokenJSAdapter.a(new com.ironsource.sdk.data.f(str).toString(), new a());
            } catch (Exception e2) {
                e2.printStackTrace();
                com.ironsource.sdk.utils.f.c(WebController.this.TAG, "iabTokenAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void initController(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "initController(" + str + ")");
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
            CountDownTimer countDownTimer = WebController.this.mLoadControllerTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                WebController.this.mLoadControllerTimer = null;
            }
            if (fVar.a("stage")) {
                String strD = fVar.d("stage");
                if ("ready".equalsIgnoreCase(strD)) {
                    WebController.this.mIsWebControllerReady = true;
                    WebController.this.mControllerListener.a();
                    return;
                }
                if ("loaded".equalsIgnoreCase(strD)) {
                    WebController.this.mControllerListener.b();
                    return;
                }
                if (!"failed".equalsIgnoreCase(strD)) {
                    com.ironsource.sdk.utils.f.c(WebController.this.TAG, "No STAGE mentioned! Should not get here!");
                    return;
                }
                String strD2 = fVar.d("errMsg");
                WebController.this.mControllerListener.a("controller failed to initialize : " + strD2);
            }
        }

        @JavascriptInterface
        public void omidAPI(String str) {
            WebController.this.runOnUiThread(new Na(this, str));
        }

        @JavascriptInterface
        public void onAdWindowsClosed(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onAdWindowsClosed(" + str + ")");
            WebController.this.mSavedState.a();
            WebController.this.mSavedState.a((String) null);
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
            String strD = fVar.d("productType");
            String strA = com.ironsource.sdk.utils.i.a(fVar);
            SSAEnums$ProductType stringProductTypeAsEnum = WebController.this.getStringProductTypeAsEnum(strD);
            Log.d(WebController.this.PUB_TAG, "onAdClosed() with type " + stringProductTypeAsEnum);
            if (WebController.this.shouldNotifyDeveloper(strD)) {
                WebController.this.runOnUiThread(new La(this, stringProductTypeAsEnum, strA));
            }
        }

        @JavascriptInterface
        public void onGenericFunctionFail(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onGenericFunctionFail(" + str + ")");
            if (WebController.this.mOnGenericFunctionListener == null) {
                com.ironsource.sdk.utils.f.a(WebController.this.TAG, "genericFunctionListener was not found");
                return;
            }
            WebController.this.runOnUiThread(new Ja(this, new com.ironsource.sdk.data.f(str).d("errMsg")));
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg("onGenericFunctionFail", str);
        }

        @JavascriptInterface
        public void onGenericFunctionSuccess(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onGenericFunctionSuccess(" + str + ")");
            if (WebController.this.mOnGenericFunctionListener == null) {
                com.ironsource.sdk.utils.f.a(WebController.this.TAG, "genericFunctionListener was not found");
            } else {
                WebController.this.runOnUiThread(new Ia(this));
                WebController.this.responseBack(str, true, null, null);
            }
        }

        @JavascriptInterface
        public void onGetApplicationInfoFail(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onGetApplicationInfoFail(" + str + ")");
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg("onGetApplicationInfoFail", str);
        }

        @JavascriptInterface
        public void onGetApplicationInfoSuccess(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onGetApplicationInfoSuccess(" + str + ")");
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg("onGetApplicationInfoSuccess", str);
        }

        @JavascriptInterface
        public void onGetCachedFilesMapFail(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onGetCachedFilesMapFail(" + str + ")");
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg("onGetCachedFilesMapFail", str);
        }

        @JavascriptInterface
        public void onGetCachedFilesMapSuccess(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onGetCachedFilesMapSuccess(" + str + ")");
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg("onGetCachedFilesMapSuccess", str);
        }

        @JavascriptInterface
        public void onGetDeviceStatusFail(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onGetDeviceStatusFail(" + str + ")");
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg("onGetDeviceStatusFail", str);
        }

        @JavascriptInterface
        public void onGetDeviceStatusSuccess(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onGetDeviceStatusSuccess(" + str + ")");
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg("onGetDeviceStatusSuccess", str);
        }

        @JavascriptInterface
        public void onGetUserCreditsFail(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onGetUserCreditsFail(" + str + ")");
            String strD = new com.ironsource.sdk.data.f(str).d("errMsg");
            if (WebController.this.shouldNotifyDeveloper(SSAEnums$ProductType.OfferWall.toString())) {
                WebController.this.runOnUiThread(new Ka(this, strD));
            }
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg("onGetUserCreditsFail", str);
        }

        @JavascriptInterface
        public void onInitBannerFail(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onInitBannerFail(" + str + ")");
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
            String strD = fVar.d("errMsg");
            String strA = com.ironsource.sdk.utils.i.a(fVar);
            if (TextUtils.isEmpty(strA)) {
                com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onInitBannerFail failed with no demand source");
                return;
            }
            com.ironsource.sdk.data.d dVarA = WebController.this.mDemandSourceManager.a(SSAEnums$ProductType.Banner, strA);
            if (dVarA != null) {
                dVarA.b(3);
            }
            if (WebController.this.shouldNotifyDeveloper(SSAEnums$ProductType.Banner.toString())) {
                WebController.this.runOnUiThread(new Fa(this, strD, strA));
            }
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg("onInitBannerFail", str);
        }

        @JavascriptInterface
        public void onInitBannerSuccess(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onInitBannerSuccess()");
            WebController.this.toastingErrMsg("onInitBannerSuccess", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            String strA = com.ironsource.sdk.utils.i.a(new com.ironsource.sdk.data.f(str));
            if (TextUtils.isEmpty(strA)) {
                com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onInitBannerSuccess failed with no demand source");
            } else if (WebController.this.shouldNotifyDeveloper(SSAEnums$ProductType.Banner.toString())) {
                WebController.this.runOnUiThread(new Da(this, strA));
            }
        }

        @JavascriptInterface
        public void onInitInterstitialFail(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onInitInterstitialFail(" + str + ")");
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
            String strD = fVar.d("errMsg");
            String strA = com.ironsource.sdk.utils.i.a(fVar);
            if (TextUtils.isEmpty(strA)) {
                com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onInitInterstitialSuccess failed with no demand source");
                return;
            }
            com.ironsource.sdk.data.d dVarA = WebController.this.mDemandSourceManager.a(SSAEnums$ProductType.Interstitial, strA);
            if (dVarA != null) {
                dVarA.b(3);
            }
            if (WebController.this.shouldNotifyDeveloper(SSAEnums$ProductType.Interstitial.toString())) {
                WebController.this.runOnUiThread(new RunnableC2425va(this, strD, strA));
            }
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg("onInitInterstitialFail", str);
        }

        @JavascriptInterface
        public void onInitInterstitialSuccess(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onInitInterstitialSuccess()");
            WebController.this.toastingErrMsg("onInitInterstitialSuccess", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            String strA = com.ironsource.sdk.utils.i.a(new com.ironsource.sdk.data.f(str));
            if (TextUtils.isEmpty(strA)) {
                com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onInitInterstitialSuccess failed with no demand source");
            } else if (WebController.this.shouldNotifyDeveloper(SSAEnums$ProductType.Interstitial.toString())) {
                WebController.this.runOnUiThread(new RunnableC2423ua(this, strA));
            }
        }

        @JavascriptInterface
        public void onInitOfferWallFail(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onInitOfferWallFail(" + str + ")");
            WebController.this.mSavedState.a(false);
            String strD = new com.ironsource.sdk.data.f(str).d("errMsg");
            if (WebController.this.mSavedState.j()) {
                WebController.this.mSavedState.b(false);
                if (WebController.this.shouldNotifyDeveloper(SSAEnums$ProductType.OfferWall.toString())) {
                    WebController.this.runOnUiThread(new za(this, strD));
                }
            }
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg("onInitOfferWallFail", str);
        }

        @JavascriptInterface
        public void onInitOfferWallSuccess(String str) {
            WebController.this.toastingErrMsg("onInitOfferWallSuccess", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            WebController.this.mSavedState.a(true);
            if (WebController.this.mSavedState.j()) {
                WebController.this.mSavedState.b(false);
                if (WebController.this.shouldNotifyDeveloper(SSAEnums$ProductType.OfferWall.toString())) {
                    WebController.this.runOnUiThread(new ya(this));
                }
            }
        }

        @JavascriptInterface
        public void onInitRewardedVideoFail(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onInitRewardedVideoFail(" + str + ")");
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
            String strD = fVar.d("errMsg");
            String strA = com.ironsource.sdk.utils.i.a(fVar);
            com.ironsource.sdk.data.d dVarA = WebController.this.mDemandSourceManager.a(SSAEnums$ProductType.RewardedVideo, strA);
            if (dVarA != null) {
                dVarA.b(3);
            }
            if (WebController.this.shouldNotifyDeveloper(SSAEnums$ProductType.RewardedVideo.toString())) {
                WebController.this.runOnUiThread(new Sa(this, strD, strA));
            }
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg("onInitRewardedVideoFail", str);
        }

        @JavascriptInterface
        public void onLoadBannerFail(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onLoadBannerFail()");
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
            String strD = fVar.d("errMsg");
            String strA = com.ironsource.sdk.utils.i.a(fVar);
            WebController.this.responseBack(str, true, null, null);
            if (!TextUtils.isEmpty(strA) && WebController.this.shouldNotifyDeveloper(SSAEnums$ProductType.Banner.toString())) {
                WebController.this.runOnUiThread(new Ha(this, strD, strA));
            }
        }

        @JavascriptInterface
        public void onLoadBannerSuccess(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onLoadBannerSuccess()");
            String strA = com.ironsource.sdk.utils.i.a(new com.ironsource.sdk.data.f(str));
            WebController.this.responseBack(str, true, null, null);
            if (WebController.this.shouldNotifyDeveloper(SSAEnums$ProductType.Banner.toString())) {
                WebController.this.runOnUiThread(new Ga(this, strA));
            }
        }

        @JavascriptInterface
        public void onLoadInterstitialFail(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onLoadInterstitialFail(" + str + ")");
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
            String strD = fVar.d("errMsg");
            String strA = com.ironsource.sdk.utils.i.a(fVar);
            WebController.this.responseBack(str, true, null, null);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            a(strA, false);
            if (WebController.this.shouldNotifyDeveloper(SSAEnums$ProductType.Interstitial.toString())) {
                WebController.this.runOnUiThread(new Ba(this, strD, strA));
            }
            WebController.this.toastingErrMsg("onLoadInterstitialFail", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        }

        @JavascriptInterface
        public void onLoadInterstitialSuccess(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onLoadInterstitialSuccess(" + str + ")");
            String strA = com.ironsource.sdk.utils.i.a(new com.ironsource.sdk.data.f(str));
            a(strA, true);
            WebController.this.responseBack(str, true, null, null);
            if (WebController.this.shouldNotifyDeveloper(SSAEnums$ProductType.Interstitial.toString())) {
                WebController.this.runOnUiThread(new Aa(this, strA));
            }
            WebController.this.toastingErrMsg("onLoadInterstitialSuccess", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        }

        @JavascriptInterface
        public void onOfferWallGeneric(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onOfferWallGeneric(" + str + ")");
            if (WebController.this.shouldNotifyDeveloper(SSAEnums$ProductType.OfferWall.toString())) {
                WebController.this.mOnOfferWallListener.onOWGeneric("", "");
            }
        }

        @JavascriptInterface
        public void onShowInterstitialFail(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onShowInterstitialFail(" + str + ")");
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
            String strD = fVar.d("errMsg");
            String strA = com.ironsource.sdk.utils.i.a(fVar);
            WebController.this.responseBack(str, true, null, null);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            a(strA, false);
            if (WebController.this.shouldNotifyDeveloper(SSAEnums$ProductType.Interstitial.toString())) {
                WebController.this.runOnUiThread(new Ca(this, strD, strA));
            }
            WebController.this.toastingErrMsg("onShowInterstitialFail", str);
        }

        @JavascriptInterface
        public void onShowInterstitialSuccess(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onShowInterstitialSuccess(" + str + ")");
            WebController.this.responseBack(str, true, null, null);
            String strA = com.ironsource.sdk.utils.i.a(new com.ironsource.sdk.data.f(str));
            if (TextUtils.isEmpty(strA)) {
                com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onShowInterstitialSuccess called with no demand");
                return;
            }
            WebController.this.mSavedState.b(SSAEnums$ProductType.Interstitial.ordinal());
            WebController.this.mSavedState.a(strA);
            if (WebController.this.shouldNotifyDeveloper(SSAEnums$ProductType.Interstitial.toString())) {
                WebController.this.runOnUiThread(new RunnableC2429xa(this, strA));
                WebController.this.toastingErrMsg("onShowInterstitialSuccess", str);
            }
            a(strA, false);
        }

        @JavascriptInterface
        public void onShowOfferWallFail(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onShowOfferWallFail(" + str + ")");
            String strD = new com.ironsource.sdk.data.f(str).d("errMsg");
            if (WebController.this.shouldNotifyDeveloper(SSAEnums$ProductType.OfferWall.toString())) {
                WebController.this.runOnUiThread(new Va(this, strD));
            }
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg("onShowOfferWallFail", str);
        }

        @JavascriptInterface
        public void onShowOfferWallSuccess(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onShowOfferWallSuccess(" + str + ")");
            WebController.this.mSavedState.b(SSAEnums$ProductType.OfferWall.ordinal());
            String strB = com.ironsource.sdk.utils.i.b(str, "placementId");
            if (WebController.this.shouldNotifyDeveloper(SSAEnums$ProductType.OfferWall.toString())) {
                WebController.this.runOnUiThread(new Ua(this, strB));
            }
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg("onShowOfferWallSuccess", str);
        }

        @JavascriptInterface
        public void onShowRewardedVideoFail(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onShowRewardedVideoFail(" + str + ")");
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
            String strD = fVar.d("errMsg");
            String strA = com.ironsource.sdk.utils.i.a(fVar);
            if (WebController.this.shouldNotifyDeveloper(SSAEnums$ProductType.RewardedVideo.toString())) {
                WebController.this.runOnUiThread(new Ta(this, strD, strA));
            }
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg("onShowRewardedVideoFail", str);
        }

        @JavascriptInterface
        public void onShowRewardedVideoSuccess(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onShowRewardedVideoSuccess(" + str + ")");
            WebController.this.responseBack(str, true, null, null);
            WebController.this.toastingErrMsg("onShowRewardedVideoSuccess", str);
        }

        @JavascriptInterface
        public void onVideoStatusChanged(String str) {
            Log.d(WebController.this.TAG, "onVideoStatusChanged(" + str + ")");
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
            String strD = fVar.d("productType");
            if (WebController.this.mVideoEventsListener == null || TextUtils.isEmpty(strD)) {
                return;
            }
            String strD2 = fVar.d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            if ("started".equalsIgnoreCase(strD2)) {
                WebController.this.mVideoEventsListener.a();
                return;
            }
            if ("paused".equalsIgnoreCase(strD2)) {
                WebController.this.mVideoEventsListener.b();
                return;
            }
            if ("playing".equalsIgnoreCase(strD2)) {
                WebController.this.mVideoEventsListener.d();
                return;
            }
            if ("ended".equalsIgnoreCase(strD2)) {
                WebController.this.mVideoEventsListener.c();
                return;
            }
            if ("stopped".equalsIgnoreCase(strD2)) {
                WebController.this.mVideoEventsListener.onVideoStopped();
                return;
            }
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "onVideoStatusChanged: unknown status: " + strD2);
        }

        @JavascriptInterface
        public void openUrl(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "openUrl(" + str + ")");
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
            String strD = fVar.d("url");
            String strD2 = fVar.d(FirebaseAnalytics.Param.METHOD);
            Context currentActivityContext = WebController.this.getCurrentActivityContext();
            try {
                if (strD2.equalsIgnoreCase("external_browser")) {
                    com.ironsource.environment.d.a(currentActivityContext, strD);
                } else if (strD2.equalsIgnoreCase("webview")) {
                    Intent intent = new Intent(currentActivityContext, (Class<?>) OpenUrlActivity.class);
                    intent.putExtra(WebController.EXTERNAL_URL, strD);
                    intent.putExtra(WebController.SECONDARY_WEB_VIEW, true);
                    intent.putExtra("immersive", WebController.this.mIsImmersive);
                    currentActivityContext.startActivity(intent);
                } else if (strD2.equalsIgnoreCase(TransactionErrorDetailsUtilities.STORE)) {
                    Intent intent2 = new Intent(currentActivityContext, (Class<?>) OpenUrlActivity.class);
                    intent2.putExtra(WebController.EXTERNAL_URL, strD);
                    intent2.putExtra(WebController.IS_STORE, true);
                    intent2.putExtra(WebController.SECONDARY_WEB_VIEW, true);
                    currentActivityContext.startActivity(intent2);
                }
            } catch (Exception e2) {
                WebController.this.responseBack(str, false, e2.getMessage(), null);
                e2.printStackTrace();
            }
        }

        @JavascriptInterface
        public void permissionsAPI(String str) {
            try {
                com.ironsource.sdk.utils.f.c(WebController.this.TAG, "permissionsAPI(" + str + ")");
                WebController.this.mPermissionsJsAdapter.a(new com.ironsource.sdk.data.f(str).toString(), new a());
            } catch (Exception e2) {
                e2.printStackTrace();
                com.ironsource.sdk.utils.f.c(WebController.this.TAG, "permissionsAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void postAdEventNotification(String str) {
            try {
                com.ironsource.sdk.utils.f.c(WebController.this.TAG, "postAdEventNotification(" + str + ")");
                com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
                String strD = fVar.d("eventName");
                if (TextUtils.isEmpty(strD)) {
                    WebController.this.responseBack(str, false, "eventName does not exist", null);
                    return;
                }
                String strD2 = fVar.d("dsName");
                String strA = com.ironsource.sdk.utils.i.a(fVar);
                String str2 = !TextUtils.isEmpty(strA) ? strA : strD2;
                JSONObject jSONObject = (JSONObject) fVar.b("extData");
                String strD3 = fVar.d("productType");
                SSAEnums$ProductType stringProductTypeAsEnum = WebController.this.getStringProductTypeAsEnum(strD3);
                if (!WebController.this.shouldNotifyDeveloper(strD3)) {
                    WebController.this.responseBack(str, false, "productType does not exist", null);
                    return;
                }
                String strExtractSuccessFunctionToCall = WebController.this.extractSuccessFunctionToCall(str);
                if (!TextUtils.isEmpty(strExtractSuccessFunctionToCall)) {
                    WebController.this.injectJavascript(WebController.this.generateJSToInject(strExtractSuccessFunctionToCall, WebController.this.parseToJson("productType", strD3, "eventName", strD, "demandSourceName", strD2, "demandSourceId", str2, null, false), "postAdEventNotificationSuccess", "postAdEventNotificationFail"));
                }
                WebController.this.runOnUiThread(new Ma(this, stringProductTypeAsEnum, str2, strD, jSONObject));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @JavascriptInterface
        public void removeCloseEventHandler(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "removeCloseEventHandler(" + str + ")");
            if (WebController.this.mCloseEventTimer != null) {
                WebController.this.mCloseEventTimer.cancel();
            }
            WebController.this.isRemoveCloseEventHandler = true;
        }

        @JavascriptInterface
        public void removeMessagingInterface(String str) {
            WebController.this.runOnUiThread(new Ea(this));
        }

        @JavascriptInterface
        public void saveFile(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "saveFile(" + str + ")");
            com.ironsource.sdk.data.e eVar = new com.ironsource.sdk.data.e(str);
            if (com.ironsource.environment.b.a(WebController.this.mCacheDirectory) <= 0) {
                WebController.this.responseBack(str, false, "no_disk_space", null);
                return;
            }
            if (!com.ironsource.sdk.utils.i.j()) {
                WebController.this.responseBack(str, false, "sotrage_unavailable", null);
                return;
            }
            if (com.ironsource.sdk.utils.e.a(WebController.this.mCacheDirectory, eVar)) {
                WebController.this.responseBack(str, false, "file_already_exist", null);
                return;
            }
            if (!b.f.c.a.f(WebController.this.getContext())) {
                WebController.this.responseBack(str, false, "no_network_connection", null);
                return;
            }
            WebController.this.responseBack(str, true, null, null);
            String strD = eVar.d();
            if (strD != null) {
                String strValueOf = String.valueOf(strD);
                if (!TextUtils.isEmpty(strValueOf)) {
                    String strE = eVar.e();
                    if (strE.contains("/")) {
                        String[] strArrSplit = eVar.e().split("/");
                        strE = strArrSplit[strArrSplit.length - 1];
                    }
                    com.ironsource.sdk.utils.d.d().a(strE, strValueOf);
                }
            }
            WebController.this.downloadManager.a(eVar);
        }

        @JavascriptInterface
        public void setBackButtonState(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "setBackButtonState(" + str + ")");
            com.ironsource.sdk.utils.d.d().c(new com.ironsource.sdk.data.f(str).d(ServerProtocol.DIALOG_PARAM_STATE));
        }

        @JavascriptInterface
        public void setForceClose(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "setForceClose(" + str + ")");
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
            String strD = fVar.d(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            String strD2 = fVar.d(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            WebController.this.mHiddenForceCloseWidth = Integer.parseInt(strD);
            WebController.this.mHiddenForceCloseHeight = Integer.parseInt(strD2);
            WebController.this.mHiddenForceCloseLocation = fVar.d("position");
        }

        @JavascriptInterface
        public void setMixedContentAlwaysAllow(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "setMixedContentAlwaysAllow(" + str + ")");
            WebController.this.runOnUiThread(new Oa(this));
        }

        @JavascriptInterface
        public void setOrientation(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "setOrientation(" + str + ")");
            String strD = new com.ironsource.sdk.data.f(str).d(AdUnitActivity.EXTRA_ORIENTATION);
            WebController.this.setOrientationState(strD);
            int iD = com.ironsource.environment.b.d(WebController.this.getCurrentActivityContext());
            if (WebController.this.mChangeListener != null) {
                WebController.this.mChangeListener.onOrientationChanged(strD, iD);
            }
        }

        @JavascriptInterface
        public void setStoreSearchKeys(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "setStoreSearchKeys(" + str + ")");
            com.ironsource.sdk.utils.d.d().e(str);
        }

        @JavascriptInterface
        public void setUserData(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "setUserData(" + str + ")");
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(str);
            if (!fVar.a("key")) {
                WebController.this.responseBack(str, false, "key does not exist", null);
                return;
            }
            if (!fVar.a("value")) {
                WebController.this.responseBack(str, false, "value does not exist", null);
                return;
            }
            String strD = fVar.d("key");
            String strD2 = fVar.d("value");
            if (!com.ironsource.sdk.utils.d.d().b(strD, strD2)) {
                WebController.this.responseBack(str, false, "SetUserData failed writing to shared preferences", null);
                return;
            }
            WebController.this.injectJavascript(WebController.this.generateJSToInject(WebController.this.extractSuccessFunctionToCall(str), WebController.this.parseToJson(strD, strD2, null, null, null, null, null, null, null, false)));
        }

        @JavascriptInterface
        public void setWebviewBackgroundColor(String str) {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "setWebviewBackgroundColor(" + str + ")");
            WebController.this.setWebviewBackground(str);
        }

        void b(String str) {
            WebController.this.injectJavascript(WebController.this.generateJSToInject("unauthorizedMessage", str, null, null));
        }

        class a {
            a() {
            }

            void a(boolean z, String str, String str2) {
                com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f();
                fVar.a(z ? WebController.JSON_KEY_SUCCESS : WebController.JSON_KEY_FAIL, str);
                fVar.a("data", str2);
                WebController.this.responseBack(fVar.toString(), z, null, null);
            }

            void a(boolean z, String str, com.ironsource.sdk.data.f fVar) {
                fVar.a(z ? WebController.JSON_KEY_SUCCESS : WebController.JSON_KEY_FAIL, str);
                WebController.this.responseBack(fVar.toString(), z, null, null);
            }

            void a(boolean z, String str, JSONObject jSONObject) {
                try {
                    jSONObject.put(z ? WebController.JSON_KEY_SUCCESS : WebController.JSON_KEY_FAIL, str);
                    WebController.this.responseBack(jSONObject.toString(), z, null, null);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    e2.getMessage();
                }
            }
        }

        private void a(JSONObject jSONObject, String str) {
            if (a(str)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    jSONObject.putOpt("testerABGroup", jSONObject2.get("testerABGroup"));
                    jSONObject.putOpt("testFriendlyName", jSONObject2.get("testFriendlyName"));
                } catch (JSONException unused) {
                    com.ironsource.sdk.utils.f.a(WebController.this.TAG, "getControllerConfig Error while parsing Tester AB Group parameters");
                }
            }
        }

        boolean a(String str) {
            if (TextUtils.isEmpty(str) || str.contains("-1")) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("testerABGroup").isEmpty()) {
                    return false;
                }
                return !jSONObject.getString("testFriendlyName").isEmpty();
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }

        private void a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            WebController.this.injectJavascript(WebController.this.generateJSToInject(str, str2));
        }

        private void a(String str, int i) {
            com.ironsource.sdk.data.d dVarA;
            if (WebController.this.shouldNotifyDeveloper(SSAEnums$ProductType.Interstitial.toString()) && (dVarA = WebController.this.mDemandSourceManager.a(SSAEnums$ProductType.Interstitial, str)) != null && dVarA.i()) {
                WebController.this.runOnUiThread(new Ra(this, str, i));
            }
        }

        private void a(String str, boolean z) {
            com.ironsource.sdk.data.d dVarA = WebController.this.mDemandSourceManager.a(SSAEnums$ProductType.Interstitial, str);
            if (dVarA != null) {
                dVarA.a(z);
            }
        }
    }

    private void setWebDebuggingEnabled(JSONObject jSONObject) {
        if (jSONObject.optBoolean("inspectWebview")) {
            setWebDebuggingEnabled();
        }
    }

    @Override // com.ironsource.sdk.controller.I
    public void showInterstitial(com.ironsource.sdk.data.d dVar, Map<String, String> map, b.f.d.g.a.c cVar) {
        injectJavascript(createShowProductJSMethod(SSAEnums$ProductType.Interstitial, new JSONObject(com.ironsource.sdk.utils.i.a((Map<String, String>[]) new Map[]{map, dVar.a()}))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String generateJSToInject(String str, String str2) {
        return "SSA_CORE.SDKController.runFunction('" + str + "?parameters=" + str2 + "');";
    }

    private String generateJSToInject(String str, String str2, String str3) {
        return "SSA_CORE.SDKController.runFunction('" + str + "','" + str2 + "','" + str3 + "');";
    }

    @Override // com.ironsource.sdk.controller.I
    public void loadInterstitial(com.ironsource.sdk.data.d dVar, Map<String, String> map, b.f.d.g.a.c cVar) {
        handleLoadAd(dVar, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String generateJSToInject(String str, String str2, String str3, String str4) {
        return "SSA_CORE.SDKController.runFunction('" + str + "?parameters=" + str2 + "','" + str3 + "','" + str4 + "');";
    }
}
