package io.rong.imlib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.just.agentweb.DefaultWebClient;
import io.rong.common.RLog;
import io.rong.imlib.common.DeviceUtils;
import io.rong.imlib.navigation.NavigationCacheHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class CMPStrategy {
    private static final String TAG = "CMPStrategy";
    private Context context;
    private volatile boolean isConnectedState;
    private String connectNetInfo = "";
    private List<String> cmpList = new ArrayList();

    private static class SingletonHolder {

        @SuppressLint({"StaticFieldLeak"})
        private static final CMPStrategy sIns = new CMPStrategy();

        private SingletonHolder() {
        }
    }

    public static CMPStrategy getInstance() {
        return SingletonHolder.sIns;
    }

    void clearCache(Context context) {
        synchronized (this) {
            this.cmpList.clear();
            NavigationCacheHelper.clearCache(context);
        }
    }

    public List<String> getCmpList() {
        List<String> list;
        synchronized (this) {
            new ArrayList();
            if (!DeviceUtils.getNetworkType(this.context).equals(this.connectNetInfo) || this.cmpList == null || this.cmpList.size() <= 0) {
                RLog.d(TAG, "getCmpEntries from SP.");
                this.cmpList = NavigationCacheHelper.getConnectionCmpList(this.context);
            } else {
                RLog.d(TAG, "getCmpEntries from cache.");
            }
            list = this.cmpList;
        }
        return list;
    }

    public boolean isCMPValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("http")) {
            str = DefaultWebClient.HTTP_SCHEME + str;
        }
        try {
            URL url = new URL(str);
            if (url.getHost() != null) {
                if (url.getPort() >= 0) {
                    return true;
                }
            }
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
        return false;
    }

    void onConnected() {
        this.connectNetInfo = DeviceUtils.getNetworkType(this.context);
        this.isConnectedState = true;
    }

    public void onGetCmpEntriesFromNavi() {
        synchronized (this) {
            this.cmpList = NavigationCacheHelper.getConnectionCmpList(this.context);
            RLog.d(TAG, "get cmp list from navi:" + this.cmpList.toString());
        }
    }

    void setEnvironment(Context context) {
        synchronized (this) {
            this.context = context;
            this.cmpList = NavigationCacheHelper.getConnectionCmpList(context);
        }
    }

    void setMainCMP(String str) {
        if (this.cmpList.size() <= 1) {
            return;
        }
        synchronized (this) {
            List<String> list = this.cmpList;
            for (int i = 0; i < list.size(); i++) {
                if (str.equals(list.get(i))) {
                    if (i == 0) {
                        return;
                    }
                    this.cmpList.remove(i);
                    this.cmpList.add(0, str);
                    return;
                }
            }
        }
    }

    void updateCmpList() {
        synchronized (this) {
            if (this.cmpList.size() > 1) {
                this.cmpList.add(this.cmpList.remove(0));
            }
        }
    }
}
