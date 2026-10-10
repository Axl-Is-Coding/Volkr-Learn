package com.just.agentweb;

import android.os.Build;
import android.webkit.JavascriptInterface;
import com.just.agentweb.AgentWeb;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public abstract class JsBaseInterfaceHolder implements JsInterfaceHolder {
    private AgentWeb.SecurityType mSecurityType;

    protected JsBaseInterfaceHolder(AgentWeb.SecurityType securityType) {
        this.mSecurityType = securityType;
    }

    @Override // com.just.agentweb.JsInterfaceHolder
    public boolean checkObject(Object obj) {
        if (Build.VERSION.SDK_INT < 17 || AgentWebConfig.WEBVIEW_TYPE == 2) {
            return true;
        }
        boolean z = false;
        for (Method method : obj.getClass().getMethods()) {
            Annotation[] annotations = method.getAnnotations();
            int length = annotations.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (annotations[i] instanceof JavascriptInterface) {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                break;
            }
        }
        return z;
    }

    protected boolean checkSecurity() {
        return this.mSecurityType != AgentWeb.SecurityType.STRICT_CHECK || AgentWebConfig.WEBVIEW_TYPE == 2 || Build.VERSION.SDK_INT > 17;
    }
}
