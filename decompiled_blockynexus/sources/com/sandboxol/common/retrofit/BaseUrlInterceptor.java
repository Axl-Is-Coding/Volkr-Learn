package com.sandboxol.common.retrofit;

import android.os.Build;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.config.CommonMessageToken;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import java.io.IOException;
import okhttp3.C;
import okhttp3.H;
import okhttp3.Interceptor;

/* JADX INFO: loaded from: classes3.dex */
public class BaseUrlInterceptor implements Interceptor {
    private int appVersion;
    private String newServer;
    private String packageName;
    private int retryCount;
    private String server;

    public BaseUrlInterceptor(String str, String str2) {
        this.retryCount = 3;
        this.server = str;
        this.newServer = str2;
        this.retryCount = 3;
    }

    private H doRequest(Interceptor.Chain chain, C c2) {
        try {
            return chain.proceed(c2);
        } catch (Exception e2) {
            ReportDataAdapter.onEvent(BaseApplication.getContext(), CommonMessageToken.TOKEN_HTTPS_COUNT, e2.getMessage());
            return null;
        }
    }

    private String switchServer(String str) {
        return str.contains(this.server) ? !this.server.equals(this.newServer) ? str.replace(this.server, this.newServer) : str : str.contains(this.newServer) ? str.replace(this.newServer, this.server) : str;
    }

    @Override // okhttp3.Interceptor
    public H intercept(Interceptor.Chain chain) throws IOException {
        C.a aVarF = chain.request().f();
        aVarF.a("userId", BaseApplication.getApp().getUserId() + "");
        aVarF.a("Access-Token", BaseApplication.getApp().getAccessToken() + "");
        aVarF.a("packageName", this.packageName);
        aVarF.a("androidVersion", String.valueOf(Build.VERSION.SDK_INT));
        aVarF.a("OS", "android");
        aVarF.a("appVersion", String.valueOf(this.appVersion));
        C cA = aVarF.a();
        H hDoRequest = doRequest(chain, cA);
        String string = cA.g().toString();
        if (hDoRequest == null || !hDoRequest.q()) {
            aVarF.b(switchServer(string));
            hDoRequest = doRequest(chain, aVarF.a());
            if (hDoRequest == null) {
                ReportDataAdapter.onEvent(BaseApplication.getContext(), CommonMessageToken.TOKEN_HTTPS_COUNT, "0--0--null");
            } else {
                ReportDataAdapter.onEvent(BaseApplication.getContext(), CommonMessageToken.TOKEN_HTTPS_COUNT, "0--" + hDoRequest.g() + "--" + hDoRequest.r());
            }
        }
        if (hDoRequest != null) {
            return hDoRequest;
        }
        throw new IOException();
    }

    public BaseUrlInterceptor(String str, String str2, String str3, int i) {
        this.retryCount = 3;
        this.server = str;
        this.newServer = str2;
        this.packageName = str3;
        this.appVersion = i;
        this.retryCount = 3;
    }

    public BaseUrlInterceptor(String str, String str2, int i) {
        this.retryCount = 3;
        this.server = str;
        this.newServer = str2;
        this.retryCount = i;
    }
}
