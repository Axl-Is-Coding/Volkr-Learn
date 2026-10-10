package io.rong.imlib;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import io.rong.common.rlog.RLog;
import io.rong.imlib.httpdns.HttpDnsCompletion;
import io.rong.imlib.httpdns.RongHttpDns;
import io.rong.imlib.httpdns.RongHttpDnsResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class HttpDnsManager {
    private static final String NAVIGATION_HOST_SUFFIX = "ronghub.com";
    private static final String TAG = "HttpDnsManager";
    private static final int TIMEOUT = 3000;
    private CountDownLatch countDownLatch;
    private boolean enableHttpDns;
    private ArrayList<String> hosts;

    private static class HttpDnsManagerHolder {
        private static final HttpDnsManager instance = new HttpDnsManager();

        private HttpDnsManagerHolder() {
        }
    }

    public static HttpDnsManager getInstance() {
        return HttpDnsManagerHolder.instance;
    }

    void asyncSolveDnsIp(Context context, String str, RongHttpDns.CompletionHandler completionHandler, HttpDnsCompletion httpDnsCompletion) {
        RongHttpDns.getService(context).asyncResolve(str, completionHandler, httpDnsCompletion);
    }

    public HashMap<String, String> getHttpDnsIps(Context context, String str) {
        HashMap<String, String> map = new HashMap<>();
        if (!this.enableHttpDns) {
            map.put("resolveIp", "");
            map.put("clientIp", "");
            return map;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        RongHttpDnsResult rongHttpDnsResultSyncResolve = RongHttpDns.getService(context).syncResolve(str);
        ArrayList<String> ipv4List = rongHttpDnsResultSyncResolve.getIpv4List();
        final String[] strArr = new String[1];
        String clientIp = rongHttpDnsResultSyncResolve.getClientIp();
        RLog.i(TAG, "host = " + str + ", + ipv4List = " + ipv4List + ", clientIp = " + clientIp);
        if (ipv4List == null || ipv4List.isEmpty()) {
            RongHttpDns.getService(context).asyncResolve(str, new RongHttpDns.CompletionHandler() { // from class: io.rong.imlib.HttpDnsManager.2
                @Override // io.rong.imlib.httpdns.RongHttpDns.CompletionHandler
                public void completionHandler(RongHttpDnsResult rongHttpDnsResult) {
                }
            }, new HttpDnsCompletion(context) { // from class: io.rong.imlib.HttpDnsManager.1
                @Override // io.rong.imlib.httpdns.HttpDnsCompletion
                protected void onFailed(int i) {
                    strArr[0] = "";
                    RLog.i(HttpDnsManager.TAG, "resolveIp fail = " + strArr[0]);
                    countDownLatch.countDown();
                }

                @Override // io.rong.imlib.httpdns.HttpDnsCompletion
                protected void onSuccess(ArrayList<String> arrayList) {
                    strArr[0] = arrayList.get(0);
                    RLog.i(HttpDnsManager.TAG, "resolveIp success = " + strArr[0]);
                    countDownLatch.countDown();
                }
            });
            try {
                if (countDownLatch.await(3000L, TimeUnit.MILLISECONDS)) {
                    RLog.i(TAG, "request dns ip countDownLatch is success");
                    clientIp = RongHttpDns.getService(context).syncResolve(str).getClientIp();
                    RLog.i(TAG, "request clientIp = " + clientIp);
                } else {
                    RLog.i(TAG, "request dns ip countDownLatch is timeout");
                }
            } catch (InterruptedException e2) {
                RLog.e(TAG, "request dns ip", e2);
                Thread.currentThread().interrupt();
            }
        } else {
            strArr[0] = ipv4List.get(0);
        }
        map.put("resolveIp", strArr[0]);
        map.put("clientIp", clientIp);
        return map;
    }

    public void initHttpDns(Context context, NativeObject nativeObject) {
        RongHttpDns service = RongHttpDns.getService(context);
        service.setLogEnable(true);
        try {
            service.setAccountID(nativeObject.GetHttpDnsAccountId());
            service.setSecret(nativeObject.GetHttpDnsSecret());
        } catch (IllegalArgumentException e2) {
            RLog.e(TAG, "initHttpDns", e2);
        }
        service.setHttpsRequestEnable(true);
        service.setNetworkSwitchPolicy(true, false);
        service.setCachePolicy(RongHttpDns.CachePolicy.POLICY_TOLERANT);
    }

    public void shouldEnableHttpDns(List<String> list) {
        String host;
        this.enableHttpDns = false;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && (host = Uri.parse(str).getHost()) != null && host.endsWith(NAVIGATION_HOST_SUFFIX)) {
                this.enableHttpDns = true;
                return;
            }
        }
    }

    private HttpDnsManager() {
        this.hosts = new ArrayList<>();
        this.countDownLatch = new CountDownLatch(1);
        this.enableHttpDns = true;
    }
}
