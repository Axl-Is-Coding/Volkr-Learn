package io.rong.imlib.navigation;

import io.rong.common.RLog;
import io.rong.common.fwlog.FwLog;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class DNSResolve {
    private static final String TAG = "DNSResolve";
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();
    private InetAddress address = null;
    private CountDownLatch cdl = new CountDownLatch(1);
    private String host;

    DNSResolve(String str) {
        this.host = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void set(InetAddress inetAddress) {
        this.address = inetAddress;
    }

    public String getIP() {
        try {
            if (this.cdl.await(500L, TimeUnit.MILLISECONDS)) {
                RLog.i(TAG, "getIP countDownLatch is success");
            } else {
                RLog.i(TAG, "getIP countDownLatch is timeout");
            }
        } catch (InterruptedException e2) {
            RLog.e(TAG, "getIP", e2);
            Thread.currentThread().interrupt();
        }
        InetAddress inetAddress = this.address;
        if (inetAddress != null) {
            return inetAddress.getHostAddress();
        }
        return null;
    }

    void resolveHost() {
        executorService.execute(new Runnable() { // from class: io.rong.imlib.navigation.DNSResolve.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (DNSResolve.this.host.toLowerCase().startsWith("http") || DNSResolve.this.host.toLowerCase().startsWith("https")) {
                        DNSResolve.this.host = new URL(DNSResolve.this.host).getHost();
                    }
                    DNSResolve.this.set(InetAddress.getByName(DNSResolve.this.host));
                    DNSResolve.this.cdl.countDown();
                } catch (MalformedURLException e2) {
                    FwLog.write(1, 1, FwLog.LogTag.L_DNS_PARSE_F.getTag(), "catch", "MalformedURLException");
                    RLog.e(DNSResolve.TAG, "MalformedURLException ", e2);
                } catch (UnknownHostException e3) {
                    FwLog.write(1, 1, FwLog.LogTag.L_DNS_PARSE_F.getTag(), "catch", "UnknownHostException");
                    RLog.e(DNSResolve.TAG, "UnknownHostException ", e3);
                } catch (Exception e4) {
                    FwLog.write(1, 1, FwLog.LogTag.L_DNS_PARSE_F.getTag(), "catch|stacks", "Exception", FwLog.stackToString(e4));
                }
            }
        });
    }
}
