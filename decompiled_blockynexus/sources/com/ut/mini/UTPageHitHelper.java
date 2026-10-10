package com.ut.mini;

import android.app.Activity;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.log.c;
import com.alibaba.mtl.log.d.i;
import com.ut.mini.UTHitBuilders;
import com.ut.mini.base.UTMIVariables;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: loaded from: classes5.dex */
public class UTPageHitHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static UTPageHitHelper f21350a = new UTPageHitHelper();
    private boolean O = false;
    private Map<String, String> z = new HashMap();
    private Map<String, UTPageEventObject> A = new HashMap();
    private String al = null;
    private Map<String, String> B = new HashMap();
    private String am = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Queue<UTPageEventObject> f120a = new LinkedList();
    private Map<Object, String> C = new HashMap();

    public static class UTPageEventObject {
        private Map<String, String> z = new HashMap();
        private long A = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Uri f21351a = null;
        private String an = null;
        private String ao = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private UTPageStatus f121a = null;
        private boolean P = false;
        private boolean Q = false;
        private boolean R = false;
        private String ap = null;

        public String getCacheKey() {
            return this.ap;
        }

        public String getPageName() {
            return this.an;
        }

        public Map<String, String> getPageProperties() {
            return this.z;
        }

        public UTPageStatus getPageStatus() {
            return this.f121a;
        }

        public long getPageStayTimstamp() {
            return this.A;
        }

        public Uri getPageUrl() {
            return this.f21351a;
        }

        public String getRefPage() {
            return this.ao;
        }

        public boolean isH5Called() {
            return this.R;
        }

        public boolean isPageAppearCalled() {
            return this.P;
        }

        public boolean isSkipPage() {
            return this.Q;
        }

        public void resetPropertiesWithoutSkipFlagAndH5Flag() {
            this.z = new HashMap();
            this.A = 0L;
            this.f21351a = null;
            this.an = null;
            this.ao = null;
            UTPageStatus uTPageStatus = this.f121a;
            if (uTPageStatus == null || uTPageStatus != UTPageStatus.UT_H5_IN_WebView) {
                this.f121a = null;
            }
            this.P = false;
            this.R = false;
        }

        public void setCacheKey(String str) {
            this.ap = str;
        }

        public void setH5Called() {
            this.R = true;
        }

        public void setPageAppearCalled() {
            this.P = true;
        }

        public void setPageName(String str) {
            this.an = str;
        }

        public void setPageProperties(Map<String, String> map) {
            this.z = map;
        }

        public void setPageStatus(UTPageStatus uTPageStatus) {
            this.f121a = uTPageStatus;
        }

        public void setPageStayTimstamp(long j) {
            this.A = j;
        }

        public void setPageUrl(Uri uri) {
            this.f21351a = uri;
        }

        public void setRefPage(String str) {
            this.ao = str;
        }

        public void setToSkipPage() {
            this.Q = true;
        }
    }

    private synchronized void b(UTPageEventObject uTPageEventObject) {
        if (this.A.containsKey(uTPageEventObject.getCacheKey())) {
            this.A.remove(uTPageEventObject.getCacheKey());
        }
    }

    public static UTPageHitHelper getInstance() {
        return f21350a;
    }

    synchronized void a(UTPageEventObject uTPageEventObject) {
        uTPageEventObject.resetPropertiesWithoutSkipFlagAndH5Flag();
        if (!this.f120a.contains(uTPageEventObject)) {
            this.f120a.add(uTPageEventObject);
        }
        if (this.f120a.size() > 200) {
            for (int i = 0; i < 100; i++) {
                UTPageEventObject uTPageEventObjectPoll = this.f120a.poll();
                if (uTPageEventObjectPoll != null && this.A.containsKey(uTPageEventObjectPoll.getCacheKey())) {
                    this.A.remove(uTPageEventObjectPoll.getCacheKey());
                }
            }
        }
    }

    synchronized Map<String, String> c() {
        if (this.B == null || this.B.size() <= 0) {
            return null;
        }
        HashMap map = new HashMap();
        map.putAll(this.B);
        this.B.clear();
        return map;
    }

    public String getCurrentPageName() {
        return this.am;
    }

    @Deprecated
    public synchronized void pageAppear(Object obj) {
        a(obj, null, false);
    }

    void pageAppearByAuto(Activity activity) {
        if (this.O) {
            return;
        }
        pageAppear(activity);
    }

    @Deprecated
    public synchronized void pageDisAppear(Object obj) {
        if (obj == null) {
            i.a("pageDisAppear", "The page object should not be null");
        } else {
            if (this.al == null) {
                return;
            }
            UTPageEventObject uTPageEventObjectA = a(obj);
            if (!uTPageEventObjectA.isPageAppearCalled()) {
                i.a("UT", "Please call pageAppear first(" + b(obj) + ").");
            } else {
                if (uTPageEventObjectA.getPageStatus() != null && UTPageStatus.UT_H5_IN_WebView == uTPageEventObjectA.getPageStatus() && uTPageEventObjectA.isH5Called()) {
                    a(uTPageEventObjectA);
                    return;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime() - uTPageEventObjectA.getPageStayTimstamp();
                if (uTPageEventObjectA.getPageUrl() == null && (obj instanceof Activity) && ((Activity) obj).getIntent() != null) {
                    uTPageEventObjectA.setPageUrl(((Activity) obj).getIntent().getData());
                }
                String pageName = uTPageEventObjectA.getPageName();
                String refPage = uTPageEventObjectA.getRefPage();
                if (refPage == null || refPage.length() == 0) {
                    refPage = "-";
                }
                Map<String, String> map = this.z;
                if (map == null) {
                    map = new HashMap<>();
                }
                if (uTPageEventObjectA.getPageProperties() != null) {
                    map.putAll(uTPageEventObjectA.getPageProperties());
                }
                if (obj instanceof IUTPageTrack) {
                    IUTPageTrack iUTPageTrack = (IUTPageTrack) obj;
                    String referPage = iUTPageTrack.getReferPage();
                    if (!TextUtils.isEmpty(referPage)) {
                        refPage = referPage;
                    }
                    Map<String, String> pageProperties = iUTPageTrack.getPageProperties();
                    if (pageProperties != null && pageProperties.size() > 0) {
                        this.z.putAll(pageProperties);
                        map = this.z;
                    }
                    String pageName2 = iUTPageTrack.getPageName();
                    if (!TextUtils.isEmpty(pageName2)) {
                        pageName = pageName2;
                    }
                }
                Uri pageUrl = uTPageEventObjectA.getPageUrl();
                if (pageUrl != null) {
                    try {
                        HashMap map2 = new HashMap();
                        String queryParameter = pageUrl.getQueryParameter("spm");
                        if (TextUtils.isEmpty(queryParameter)) {
                            try {
                                pageUrl = Uri.parse(URLDecoder.decode(pageUrl.toString(), "UTF-8"));
                                queryParameter = pageUrl.getQueryParameter("spm");
                            } catch (UnsupportedEncodingException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (!TextUtils.isEmpty(queryParameter)) {
                            boolean z = false;
                            if (this.C.containsKey(obj) && queryParameter.equals(this.C.get(obj))) {
                                z = true;
                            }
                            if (!z) {
                                map2.put("spm", queryParameter);
                                this.C.put(obj, queryParameter);
                            }
                        }
                        String queryParameter2 = pageUrl.getQueryParameter("scm");
                        if (!TextUtils.isEmpty(queryParameter2)) {
                            map2.put("scm", queryParameter2);
                        }
                        String strA = a(pageUrl);
                        if (!TextUtils.isEmpty(strA)) {
                            c.a().e(strA);
                        }
                        if (map2.size() > 0) {
                            map.putAll(map2);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                UTHitBuilders.UTPageHitBuilder uTPageHitBuilder = new UTHitBuilders.UTPageHitBuilder(pageName);
                uTPageHitBuilder.setReferPage(refPage).setDurationOnPage(jElapsedRealtime).setProperties(map);
                UTMIVariables.getInstance().setRefPage(pageName);
                UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
                if (defaultTracker != null) {
                    defaultTracker.send(uTPageHitBuilder.build());
                } else {
                    i.a("Record page event error", "Fatal Error,must call setRequestAuthentication method first.");
                }
            }
            this.z = new HashMap();
            if (uTPageEventObjectA.isSkipPage()) {
                a(uTPageEventObjectA);
            } else if (uTPageEventObjectA.getPageStatus() == null || UTPageStatus.UT_H5_IN_WebView != uTPageEventObjectA.getPageStatus()) {
                m106b(obj);
            } else {
                a(uTPageEventObjectA);
            }
            this.al = null;
            this.am = null;
        }
    }

    void pageDisAppearByAuto(Activity activity) {
        if (this.O) {
            return;
        }
        pageDisAppear(activity);
    }

    synchronized void skipPage(Object obj) {
        if (obj == null) {
            return;
        }
        a(obj).setToSkipPage();
    }

    @Deprecated
    public synchronized void turnOffAutoPageTrack() {
        this.O = true;
    }

    synchronized void updateNextPageProperties(Map<String, String> map) {
        if (map != null) {
            HashMap map2 = new HashMap();
            map2.putAll(map);
            this.B = map2;
        }
    }

    synchronized void updatePageName(Object obj, String str) {
        if (obj != null) {
            if (!TextUtils.isEmpty(str)) {
                a(obj).setPageName(str);
                this.am = str;
            }
        }
    }

    @Deprecated
    public synchronized void updatePageProperties(Map<String, String> map) {
        if (map != null) {
            this.z.putAll(map);
        }
    }

    synchronized void updatePageStatus(Object obj, UTPageStatus uTPageStatus) {
        if (obj == null || uTPageStatus == null) {
            return;
        }
        a(obj).setPageStatus(uTPageStatus);
    }

    synchronized void updatePageUrl(Object obj, Uri uri) {
        if (obj == null || uri == null) {
            return;
        }
        Log.i("url", "url" + uri.toString());
        a(obj).setPageUrl(uri);
    }

    synchronized void pageAppear(Object obj, String str) {
        a(obj, str, false);
    }

    synchronized void updatePageProperties(Object obj, Map<String, String> map) {
        if (obj != null && map != null) {
            if (map.size() != 0) {
                HashMap map2 = new HashMap();
                map2.putAll(map);
                UTPageEventObject uTPageEventObjectA = a(obj);
                Map<String, String> pageProperties = uTPageEventObjectA.getPageProperties();
                if (pageProperties == null) {
                    uTPageEventObjectA.setPageProperties(map2);
                } else {
                    HashMap map3 = new HashMap();
                    map3.putAll(pageProperties);
                    map3.putAll(map2);
                    uTPageEventObjectA.setPageProperties(map3);
                }
                return;
            }
        }
        i.a("updatePageProperties", "failed to update project, parameters should not be null and the map should not be empty");
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private synchronized void m106b(Object obj) {
        String strM105a = m105a(obj);
        if (this.A.containsKey(strM105a)) {
            this.A.remove(strM105a);
        }
    }

    private static String b(Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        return (simpleName == null || !simpleName.toLowerCase().endsWith("activity")) ? simpleName : simpleName.substring(0, simpleName.length() - 8);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private String m105a(Object obj) {
        String simpleName;
        if (obj instanceof String) {
            simpleName = (String) obj;
        } else {
            simpleName = obj.getClass().getSimpleName();
        }
        return simpleName + obj.hashCode();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    synchronized boolean m108a(Object obj) {
        if (obj != null) {
            UTPageEventObject uTPageEventObjectA = a(obj);
            if (uTPageEventObjectA.getPageStatus() != null) {
                if (uTPageEventObjectA.getPageStatus() == UTPageStatus.UT_H5_IN_WebView) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    synchronized void m107a(Object obj) {
        if (obj != null) {
            UTPageEventObject uTPageEventObjectA = a(obj);
            if (uTPageEventObjectA.getPageStatus() != null) {
                uTPageEventObjectA.setH5Called();
            }
        }
    }

    private synchronized UTPageEventObject a(Object obj) {
        String strM105a = m105a(obj);
        if (this.A.containsKey(strM105a)) {
            return this.A.get(strM105a);
        }
        UTPageEventObject uTPageEventObject = new UTPageEventObject();
        this.A.put(strM105a, uTPageEventObject);
        uTPageEventObject.setCacheKey(strM105a);
        return uTPageEventObject;
    }

    private synchronized void a(String str, UTPageEventObject uTPageEventObject) {
        this.A.put(str, uTPageEventObject);
    }

    synchronized void a(Object obj, String str, boolean z) {
        if (obj != null) {
            String strM105a = m105a(obj);
            if (strM105a != null && strM105a.equals(this.al)) {
                return;
            }
            if (this.al != null) {
                i.a("lost 2001", "Last page requires leave(" + this.al + ").");
            }
            UTPageEventObject uTPageEventObjectA = a(obj);
            if (!z && uTPageEventObjectA.isSkipPage()) {
                i.a("skip page[pageAppear]", "page name:" + obj.getClass().getSimpleName());
                return;
            }
            String h5Url = UTMIVariables.getInstance().getH5Url();
            if (h5Url != null) {
                try {
                    this.z.put("spm", Uri.parse(h5Url).getQueryParameter("spm"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                UTMIVariables.getInstance().setH5Url(null);
            }
            String strB = b(obj);
            if (TextUtils.isEmpty(str)) {
                str = strB;
            }
            if (!TextUtils.isEmpty(uTPageEventObjectA.getPageName())) {
                str = uTPageEventObjectA.getPageName();
            }
            this.am = str;
            uTPageEventObjectA.setPageName(str);
            uTPageEventObjectA.setPageStayTimstamp(SystemClock.elapsedRealtime());
            uTPageEventObjectA.setRefPage(UTMIVariables.getInstance().getRefPage());
            uTPageEventObjectA.setPageAppearCalled();
            if (this.B != null) {
                Map<String, String> pageProperties = uTPageEventObjectA.getPageProperties();
                if (pageProperties == null) {
                    uTPageEventObjectA.setPageProperties(this.B);
                } else {
                    HashMap map = new HashMap();
                    map.putAll(pageProperties);
                    map.putAll(this.B);
                    uTPageEventObjectA.setPageProperties(map);
                }
            }
            this.B = null;
            this.al = m105a(obj);
            b(uTPageEventObjectA);
            a(m105a(obj), uTPageEventObjectA);
        } else {
            i.a("pageAppear", "The page object should not be null");
        }
    }

    private static String a(Uri uri) {
        List<String> queryParameters;
        if (uri == null || (queryParameters = uri.getQueryParameters("ttid")) == null) {
            return null;
        }
        for (String str : queryParameters) {
            if (!str.contains("@") && !str.contains("%40")) {
                return str;
            }
        }
        return null;
    }
}
