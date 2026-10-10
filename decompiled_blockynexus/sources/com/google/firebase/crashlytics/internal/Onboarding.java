package com.google.firebase.crashlytics.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.SettingsCacheBehavior;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.settings.model.AppRequestData;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.network.CreateAppSpiCall;
import com.google.firebase.crashlytics.internal.settings.network.UpdateAppSpiCall;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class Onboarding {
    static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private final FirebaseApp f14083app;
    private String applicationLabel;
    private final Context context;
    private DataCollectionArbiter dataCollectionArbiter;
    private IdManager idManager;
    private String installerPackageName;
    private PackageInfo packageInfo;
    private PackageManager packageManager;
    private String packageName;
    private final HttpRequestFactory requestFactory = new HttpRequestFactory();
    private String targetAndroidSdkVersion;
    private String versionCode;
    private String versionName;

    public Onboarding(FirebaseApp firebaseApp, Context context, IdManager idManager, DataCollectionArbiter dataCollectionArbiter) {
        this.f14083app = firebaseApp;
        this.context = context;
        this.idManager = idManager;
        this.dataCollectionArbiter = dataCollectionArbiter;
    }

    private AppRequestData buildAppRequest(String str, String str2) {
        return new AppRequestData(str, str2, getIdManager().getAppIdentifier(), this.versionName, this.versionCode, CommonUtils.createInstanceIdFrom(CommonUtils.getMappingFileId(getContext()), str2, this.versionName, this.versionCode), this.applicationLabel, DeliveryMechanism.determineFrom(this.installerPackageName).getId(), this.targetAndroidSdkVersion, "0");
    }

    private IdManager getIdManager() {
        return this.idManager;
    }

    private static String getVersion() {
        return CrashlyticsCore.getVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performAutoConfigure(AppSettingsData appSettingsData, String str, SettingsController settingsController, Executor executor, boolean z) {
        if ("new".equals(appSettingsData.status)) {
            if (performCreateApp(appSettingsData, str, z)) {
                settingsController.loadSettingsData(SettingsCacheBehavior.SKIP_CACHE_LOOKUP, executor);
                return;
            } else {
                Logger.getLogger().e("Failed to create app with Crashlytics service.", null);
                return;
            }
        }
        if (AppSettingsData.STATUS_CONFIGURED.equals(appSettingsData.status)) {
            settingsController.loadSettingsData(SettingsCacheBehavior.SKIP_CACHE_LOOKUP, executor);
        } else if (appSettingsData.updateRequired) {
            Logger.getLogger().d("Server says an update is required - forcing a full App update.");
            performUpdateApp(appSettingsData, str, z);
        }
    }

    private boolean performCreateApp(AppSettingsData appSettingsData, String str, boolean z) {
        return new CreateAppSpiCall(getOverridenSpiEndpoint(), appSettingsData.url, this.requestFactory, getVersion()).invoke(buildAppRequest(appSettingsData.organizationId, str), z);
    }

    private boolean performUpdateApp(AppSettingsData appSettingsData, String str, boolean z) {
        return new UpdateAppSpiCall(getOverridenSpiEndpoint(), appSettingsData.url, this.requestFactory, getVersion()).invoke(buildAppRequest(appSettingsData.organizationId, str), z);
    }

    public void doOnboarding(final Executor executor, final SettingsController settingsController) {
        final String applicationId = this.f14083app.getOptions().getApplicationId();
        this.dataCollectionArbiter.waitForDataCollectionPermission().onSuccessTask(executor, new SuccessContinuation<Void, AppSettingsData>() { // from class: com.google.firebase.crashlytics.internal.Onboarding.2
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public Task<AppSettingsData> then(Void r1) throws Exception {
                return settingsController.getAppSettings();
            }
        }).onSuccessTask(executor, new SuccessContinuation<AppSettingsData, Void>() { // from class: com.google.firebase.crashlytics.internal.Onboarding.1
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public Task<Void> then(AppSettingsData appSettingsData) throws Exception {
                try {
                    Onboarding.this.performAutoConfigure(appSettingsData, applicationId, settingsController, executor, true);
                    return null;
                } catch (Exception e2) {
                    Logger.getLogger().e("Error performing auto configuration.", e2);
                    throw e2;
                }
            }
        });
    }

    public Context getContext() {
        return this.context;
    }

    String getOverridenSpiEndpoint() {
        return CommonUtils.getStringsFileValue(this.context, CRASHLYTICS_API_ENDPOINT);
    }

    public boolean onPreExecute() {
        try {
            this.installerPackageName = this.idManager.getInstallerPackageName();
            this.packageManager = this.context.getPackageManager();
            this.packageName = this.context.getPackageName();
            this.packageInfo = this.packageManager.getPackageInfo(this.packageName, 0);
            this.versionCode = Integer.toString(this.packageInfo.versionCode);
            this.versionName = this.packageInfo.versionName == null ? IdManager.DEFAULT_VERSION_NAME : this.packageInfo.versionName;
            this.applicationLabel = this.packageManager.getApplicationLabel(this.context.getApplicationInfo()).toString();
            this.targetAndroidSdkVersion = Integer.toString(this.context.getApplicationInfo().targetSdkVersion);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            Logger.getLogger().e("Failed init", e2);
            return false;
        }
    }

    public SettingsController retrieveSettingsData(Context context, FirebaseApp firebaseApp, Executor executor) {
        SettingsController settingsControllerCreate = SettingsController.create(context, firebaseApp.getOptions().getApplicationId(), this.idManager, this.requestFactory, this.versionCode, this.versionName, getOverridenSpiEndpoint(), this.dataCollectionArbiter);
        settingsControllerCreate.loadSettingsData(executor).continueWith(executor, new Continuation<Void, Object>() { // from class: com.google.firebase.crashlytics.internal.Onboarding.3
            @Override // com.google.android.gms.tasks.Continuation
            public Object then(Task<Void> task) throws Exception {
                if (task.isSuccessful()) {
                    return null;
                }
                Logger.getLogger().e("Error fetching settings.", task.getException());
                return null;
            }
        });
        return settingsControllerCreate;
    }
}
