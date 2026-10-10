package com.sandboxol.common.base.app;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.sandboxol.common.threadpoollib.PoolThread;
import com.sandboxol.common.threadpoollib.callback.ThreadListener;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.widget.SmartRefreshFooter;
import com.sandboxol.common.widget.SmartRefreshHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.a.f;
import com.scwang.smartrefresh.layout.a.g;
import com.scwang.smartrefresh.layout.a.j;
import com.tencent.tpshell.TPShellApplication;

/* JADX INFO: loaded from: classes.dex */
public class BaseApplication extends TPShellApplication {
    private static BaseApplication application;
    private static Context context;
    private static PoolThread threadPool;
    private String backupBaseUrl;
    private String baseUrl;
    private String rootPath;
    private int versionCode;
    private boolean hasReportMd5 = false;
    private ApplicationInfo appInfo = null;

    public class ThreadPoolLogListener implements ThreadListener {
        private final String TAG = "AppThreadPoolLog";

        public ThreadPoolLogListener() {
        }

        @Override // com.sandboxol.common.threadpoollib.callback.ThreadListener
        public void onError(String str, Throwable th) {
            Log.e("AppThreadPoolLog", "ThreadLog-----" + str + "------onError----" + th.getMessage());
        }

        @Override // com.sandboxol.common.threadpoollib.callback.ThreadListener
        public void onFinished(String str) {
            Log.d("AppThreadPoolLog", "ThreadLog-----" + str + "------onFinished");
        }

        @Override // com.sandboxol.common.threadpoollib.callback.ThreadListener
        public void onStart(String str) {
            Log.d("AppThreadPoolLog", "ThreadLog-----" + str + "------onStart");
        }
    }

    static {
        SmartRefreshLayout.setDefaultRefreshInitializer(new com.scwang.smartrefresh.layout.a.c() { // from class: com.sandboxol.common.base.app.b
            @Override // com.scwang.smartrefresh.layout.a.c
            public final void a(Context context2, j jVar) {
                BaseApplication.a(context2, jVar);
            }
        });
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new com.scwang.smartrefresh.layout.a.b() { // from class: com.sandboxol.common.base.app.a
            @Override // com.scwang.smartrefresh.layout.a.b
            public final g a(Context context2, j jVar) {
                return BaseApplication.b(context2, jVar);
            }
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new com.scwang.smartrefresh.layout.a.a() { // from class: com.sandboxol.common.base.app.c
            @Override // com.scwang.smartrefresh.layout.a.a
            public final f a(Context context2, j jVar) {
                return BaseApplication.c(context2, jVar);
            }
        });
    }

    static /* synthetic */ void a(Context context2, j jVar) {
        jVar.setEnableFooterTranslationContent(true);
        jVar.setEnableNestedScroll(false);
        jVar.setHeaderMaxDragRate(9.0f);
        jVar.setFooterMaxDragRate(9.0f);
        jVar.setDragRate(0.5f);
    }

    static /* synthetic */ g b(Context context2, j jVar) {
        return new SmartRefreshHeader(context2);
    }

    static /* synthetic */ f c(Context context2, j jVar) {
        return new SmartRefreshFooter(context2);
    }

    public static BaseApplication getApp() {
        return application;
    }

    private ApplicationInfo getAppInfo() {
        try {
            if (this.appInfo == null) {
                this.appInfo = getPackageManager().getApplicationInfo(getPackageName(), 128);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        return this.appInfo;
    }

    public static Context getContext() {
        return context;
    }

    public static PoolThread getThreadPool() {
        return threadPool;
    }

    private void initThreadPool() {
        threadPool = PoolThread.Builder.createFixed(2).setPriority(19).setListener(new ThreadPoolLogListener()).build();
    }

    @Override // com.tencent.tpshell.TPShellApplication, android.content.ContextWrapper
    protected void attachBaseContext(Context context2) {
        super.attachBaseContext(context2);
    }

    public String getAccessToken() {
        return SharedUtils.getString(this, "Access-Token");
    }

    public int getMetaDataAppVersion() {
        return this.versionCode;
    }

    public String getMetaDataBackupBaseUrl() {
        String str = this.backupBaseUrl;
        return str == null ? "http://127.0.0.1:18080" : str;
    }

    public String getMetaDataBaseUrl() {
        String str = this.baseUrl;
        return str == null ? "http://127.0.0.1:18080" : str;
    }

    public String getMetaDataRootPath() {
        String str = this.rootPath;
        return str == null ? "SandboxOL" : str;
    }

    public long getUserId() {
        return SharedUtils.getLong(this, "userId");
    }

    public boolean isHasReportMd5() {
        return this.hasReportMd5;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        context = this;
        application = this;
        initThreadPool();
    }

    public void setAccessToken(String str) {
        SharedUtils.putString(this, "Access-Token", str);
    }

    public void setBackupBaseUrl(String str) {
        this.backupBaseUrl = str;
    }

    public void setBaseUrl(String str) {
        this.baseUrl = str;
    }

    public void setHasReportMd5(boolean z) {
        this.hasReportMd5 = z;
    }

    public void setRootPath(String str) {
        this.rootPath = str;
    }

    public void setUserId(long j) {
        SharedUtils.putLong(this, "userId", j);
    }

    public void setVersionCode(int i) {
        this.versionCode = i;
    }
}
