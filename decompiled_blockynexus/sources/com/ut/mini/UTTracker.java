package com.ut.mini;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.q;
import com.alibaba.mtl.log.model.LogField;
import com.ut.mini.base.UTMIVariables;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public class UTTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Pattern f21353a = Pattern.compile("(\\|\\||[\t\r\n])+");
    private String g;
    private String aq = null;
    private Map<String, String> D = new HashMap();

    private static String b(String str) {
        return d(str);
    }

    private static String d(String str) {
        return (str == null || "".equals(str)) ? str : f21353a.matcher(str).replaceAll("");
    }

    private static void f(Map<String, String> map) {
        if (map != null) {
            if (map.containsKey(LogField.IMEI.toString())) {
                map.remove(LogField.IMEI.toString());
            }
            if (map.containsKey(LogField.IMSI.toString())) {
                map.remove(LogField.IMSI.toString());
            }
            if (map.containsKey(LogField.CARRIER.toString())) {
                map.remove(LogField.CARRIER.toString());
            }
            if (map.containsKey(LogField.ACCESS.toString())) {
                map.remove(LogField.ACCESS.toString());
            }
            if (map.containsKey(LogField.ACCESS_SUBTYPE.toString())) {
                map.remove(LogField.ACCESS_SUBTYPE.toString());
            }
            if (map.containsKey(LogField.CHANNEL.toString())) {
                map.remove(LogField.CHANNEL.toString());
            }
            if (map.containsKey(LogField.LL_USERNICK.toString())) {
                map.remove(LogField.LL_USERNICK.toString());
            }
            if (map.containsKey(LogField.USERNICK.toString())) {
                map.remove(LogField.USERNICK.toString());
            }
            if (map.containsKey(LogField.LL_USERID.toString())) {
                map.remove(LogField.LL_USERID.toString());
            }
            if (map.containsKey(LogField.USERID.toString())) {
                map.remove(LogField.USERID.toString());
            }
            if (map.containsKey(LogField.SDKVERSION.toString())) {
                map.remove(LogField.SDKVERSION.toString());
            }
            if (map.containsKey(LogField.START_SESSION_TIMESTAMP.toString())) {
                map.remove(LogField.START_SESSION_TIMESTAMP.toString());
            }
            if (map.containsKey(LogField.UTDID.toString())) {
                map.remove(LogField.UTDID.toString());
            }
            if (map.containsKey(LogField.SDKTYPE.toString())) {
                map.remove(LogField.SDKTYPE.toString());
            }
            if (map.containsKey(LogField.RESERVE2.toString())) {
                map.remove(LogField.RESERVE2.toString());
            }
            if (map.containsKey(LogField.RESERVE3.toString())) {
                map.remove(LogField.RESERVE3.toString());
            }
            if (map.containsKey(LogField.RESERVE4.toString())) {
                map.remove(LogField.RESERVE4.toString());
            }
            if (map.containsKey(LogField.RESERVE5.toString())) {
                map.remove(LogField.RESERVE5.toString());
            }
            if (map.containsKey(LogField.RESERVES.toString())) {
                map.remove(LogField.RESERVES.toString());
            }
            if (map.containsKey(LogField.RECORD_TIMESTAMP.toString())) {
                map.remove(LogField.RECORD_TIMESTAMP.toString());
            }
        }
    }

    private Map<String, String> g(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        HashMap map2 = new HashMap();
        Iterator<String> it = map.keySet().iterator();
        if (it != null) {
            while (it.hasNext()) {
                String next = it.next();
                if (next != null) {
                    map2.put(next, b(map.get(next)));
                }
            }
        }
        return map2;
    }

    private static void h(Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (map.containsKey(UTFields.TRACK_ID)) {
            String str = map.get(UTFields.TRACK_ID);
            map.remove(UTFields.TRACK_ID);
            if (!TextUtils.isEmpty(str)) {
                map2.put("_tkid", str);
            }
        }
        if (map2.size() > 0) {
            map.put(LogField.RESERVES.toString(), q.d(map2));
        }
        if (map.containsKey(LogField.PAGE.toString())) {
            return;
        }
        map.put(LogField.PAGE.toString(), "UT");
    }

    public synchronized String getGlobalProperty(String str) {
        if (str == null) {
            return null;
        }
        return this.D.get(str);
    }

    public void pageAppear(Object obj) {
        UTPageHitHelper.getInstance().pageAppear(obj);
    }

    public void pageAppearDonotSkip(Object obj) {
        UTPageHitHelper.getInstance().a(obj, null, true);
    }

    public void pageDisAppear(Object obj) {
        UTPageHitHelper.getInstance().pageDisAppear(obj);
    }

    void q(String str) {
        this.aq = str;
    }

    protected void r(String str) {
        this.g = str;
    }

    public synchronized void removeGlobalProperty(String str) {
        if (str != null) {
            if (this.D.containsKey(str)) {
                this.D.remove(str);
            }
        }
    }

    public void send(Map<String, String> map) {
        if (map != null) {
            HashMap map2 = new HashMap();
            map2.putAll(this.D);
            map2.putAll(map);
            if (!TextUtils.isEmpty(this.g)) {
                map2.put(LogField.APPKEY.toString(), this.g);
            }
            Map<String, String> mapG = g((Map<String, String>) map2);
            if (!TextUtils.isEmpty(this.aq)) {
                mapG.put(UTFields.TRACK_ID, this.aq);
            }
            UTMIVariables.getInstance().isAliyunOSPlatform();
            f(mapG);
            d(mapG);
            m109g(mapG);
            h(mapG);
            a.a(mapG.remove(LogField.PAGE.toString()), mapG.remove(LogField.EVENTID.toString()), mapG.remove(LogField.ARG1.toString()), mapG.remove(LogField.ARG2.toString()), mapG.remove(LogField.ARG3.toString()), mapG);
        }
    }

    public synchronized void setGlobalProperty(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            i.a("setGlobalProperty", "key is null or key is empty or value is null,please check it!");
        } else {
            this.D.put(str, str2);
        }
    }

    public void skipPage(Object obj) {
        UTPageHitHelper.getInstance().skipPage(obj);
    }

    public void updateNextPageProperties(Map<String, String> map) {
        UTPageHitHelper.getInstance().updateNextPageProperties(map);
    }

    public void updatePageName(Object obj, String str) {
        UTPageHitHelper.getInstance().updatePageName(obj, str);
    }

    public void updatePageProperties(Object obj, Map<String, String> map) {
        UTPageHitHelper.getInstance().updatePageProperties(obj, map);
    }

    public void updatePageStatus(Object obj, UTPageStatus uTPageStatus) {
        UTPageHitHelper.getInstance().updatePageStatus(obj, uTPageStatus);
    }

    public void updatePageUrl(Object obj, Uri uri) {
        UTPageHitHelper.getInstance().updatePageUrl(obj, uri);
    }

    public void pageAppear(Object obj, String str) {
        UTPageHitHelper.getInstance().pageAppear(obj, str);
    }

    public void pageAppearDonotSkip(Object obj, String str) {
        UTPageHitHelper.getInstance().a(obj, str, true);
    }

    private static void d(Map<String, String> map) {
        if (map != null) {
            if (map.containsKey(UTFields.OS)) {
                String str = map.get(UTFields.OS);
                map.remove(UTFields.OS);
                map.put(LogField.OS.toString(), str);
            }
            if (map.containsKey(UTFields.OS_VERSION)) {
                String str2 = map.get(UTFields.OS_VERSION);
                map.remove(UTFields.OS_VERSION);
                map.put(LogField.OSVERSION.toString(), str2);
            }
        }
    }

    /* JADX INFO: renamed from: g, reason: collision with other method in class */
    private static void m109g(Map<String, String> map) {
        map.put(LogField.SDKTYPE.toString(), "mini");
    }
}
