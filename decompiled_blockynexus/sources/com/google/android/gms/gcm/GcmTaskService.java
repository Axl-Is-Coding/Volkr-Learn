package com.google.android.gms.gcm;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public abstract class GcmTaskService extends Service {
    public static final String SERVICE_ACTION_EXECUTE_TASK = "com.google.android.gms.gcm.ACTION_TASK_READY";
    public static final String SERVICE_ACTION_INITIALIZE = "com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE";
    public static final String SERVICE_PERMISSION = "com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE";
    private ComponentName componentName;
    private final Object lock = new Object();
    private int zzt;
    private ExecutorService zzu;
    private Messenger zzv;
    private GcmNetworkManager zzw;

    @VisibleForTesting
    @TargetApi(21)
    class zzd extends Handler {
        zzd(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Messenger messenger;
            if (!UidVerifier.uidHasPackageName(GcmTaskService.this, message.sendingUid, "com.google.android.gms")) {
                Log.e("GcmTaskService", "unable to verify presence of Google Play Services");
                return;
            }
            int i = message.what;
            if (i == 1) {
                Bundle data = message.getData();
                if (data.isEmpty() || (messenger = message.replyTo) == null) {
                    return;
                }
                String string = data.getString("tag");
                ArrayList parcelableArrayList = data.getParcelableArrayList("triggered_uris");
                if (GcmTaskService.this.zzg(string)) {
                    return;
                }
                GcmTaskService.this.zzd(GcmTaskService.this.new zze(string, messenger, data.getBundle("extras"), parcelableArrayList));
                return;
            }
            if (i == 2) {
                if (Log.isLoggable("GcmTaskService", 3)) {
                    String strValueOf = String.valueOf(message);
                    StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 45);
                    sb.append("ignoring unimplemented stop message for now: ");
                    sb.append(strValueOf);
                    Log.d("GcmTaskService", sb.toString());
                    return;
                }
                return;
            }
            if (i == 4) {
                GcmTaskService.this.onInitializeTasks();
                return;
            }
            String strValueOf2 = String.valueOf(message);
            StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 31);
            sb2.append("Unrecognized message received: ");
            sb2.append(strValueOf2);
            Log.e("GcmTaskService", sb2.toString());
        }
    }

    class zze implements Runnable {
        private final Bundle extras;
        private final String tag;
        private final zzg zzaa;
        private final Messenger zzab;
        private final List<Uri> zzz;

        zze(String str, IBinder iBinder, Bundle bundle, List<Uri> list) {
            zzg zzhVar;
            this.tag = str;
            if (iBinder == null) {
                zzhVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gcm.INetworkTaskCallback");
                zzhVar = iInterfaceQueryLocalInterface instanceof zzg ? (zzg) iInterfaceQueryLocalInterface : new zzh(iBinder);
            }
            this.zzaa = zzhVar;
            this.extras = bundle;
            this.zzz = list;
            this.zzab = null;
        }

        zze(String str, Messenger messenger, Bundle bundle, List<Uri> list) {
            this.tag = str;
            this.zzab = messenger;
            this.extras = bundle;
            this.zzz = list;
            this.zzaa = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(int i) {
            GcmTaskService gcmTaskService;
            int i2;
            synchronized (GcmTaskService.this.lock) {
                try {
                    try {
                    } catch (RemoteException unused) {
                        String strValueOf = String.valueOf(this.tag);
                        Log.e("GcmTaskService", strValueOf.length() != 0 ? "Error reporting result of operation to scheduler for ".concat(strValueOf) : new String("Error reporting result of operation to scheduler for "));
                        GcmTaskService.this.zzw.zze(this.tag, GcmTaskService.this.componentName.getClassName());
                        if (!zzf() && !GcmTaskService.this.zzw.zzf(GcmTaskService.this.componentName.getClassName())) {
                            gcmTaskService = GcmTaskService.this;
                            i2 = GcmTaskService.this.zzt;
                        }
                    }
                    if (GcmTaskService.this.zzw.zzf(this.tag, GcmTaskService.this.componentName.getClassName())) {
                        return;
                    }
                    if (zzf()) {
                        Messenger messenger = this.zzab;
                        Message messageObtain = Message.obtain();
                        messageObtain.what = 3;
                        messageObtain.arg1 = i;
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("component", GcmTaskService.this.componentName);
                        bundle.putString("tag", this.tag);
                        messageObtain.setData(bundle);
                        messenger.send(messageObtain);
                    } else {
                        this.zzaa.zzf(i);
                    }
                    GcmTaskService.this.zzw.zze(this.tag, GcmTaskService.this.componentName.getClassName());
                    if (!zzf() && !GcmTaskService.this.zzw.zzf(GcmTaskService.this.componentName.getClassName())) {
                        gcmTaskService = GcmTaskService.this;
                        i2 = GcmTaskService.this.zzt;
                        gcmTaskService.stopSelf(i2);
                    }
                } finally {
                    GcmTaskService.this.zzw.zze(this.tag, GcmTaskService.this.componentName.getClassName());
                    if (!zzf() && !GcmTaskService.this.zzw.zzf(GcmTaskService.this.componentName.getClassName())) {
                        GcmTaskService.this.stopSelf(GcmTaskService.this.zzt);
                    }
                }
            }
        }

        private final boolean zzf() {
            return this.zzab != null;
        }

        @Override // java.lang.Runnable
        public final void run() {
            zze(GcmTaskService.this.onRunTask(new TaskParams(this.tag, this.extras, this.zzz)));
        }
    }

    private final void zzd(int i) {
        synchronized (this.lock) {
            this.zzt = i;
            if (!this.zzw.zzf(this.componentName.getClassName())) {
                stopSelf(this.zzt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(zze zzeVar) {
        try {
            this.zzu.execute(zzeVar);
        } catch (RejectedExecutionException e2) {
            Log.e("GcmTaskService", "Executor is shutdown. onDestroy was called but main looper had an unprocessed start task message. The task will be retried with backoff delay.", e2);
            zzeVar.zze(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzg(String str) {
        boolean z;
        synchronized (this.lock) {
            z = !this.zzw.zzd(str, this.componentName.getClassName());
            if (z) {
                String packageName = getPackageName();
                StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 44 + String.valueOf(str).length());
                sb.append(packageName);
                sb.append(" ");
                sb.append(str);
                sb.append(": Task already running, won't start another");
                Log.w("GcmTaskService", sb.toString());
            }
        }
        return z;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent != null && PlatformVersion.isAtLeastLollipop() && SERVICE_ACTION_EXECUTE_TASK.equals(intent.getAction())) {
            return this.zzv.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.zzw = GcmNetworkManager.getInstance(this);
        this.zzu = Executors.newFixedThreadPool(2, new com.google.android.gms.gcm.zze(this));
        this.zzv = new Messenger(new zzd(Looper.getMainLooper()));
        this.componentName = new ComponentName(this, (Class<?>) GcmTaskService.class);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        List<Runnable> listShutdownNow = this.zzu.shutdownNow();
        if (listShutdownNow.isEmpty()) {
            return;
        }
        int size = listShutdownNow.size();
        StringBuilder sb = new StringBuilder(79);
        sb.append("Shutting down, but not all tasks are finished executing. Remaining: ");
        sb.append(size);
        Log.e("GcmTaskService", sb.toString());
    }

    public void onInitializeTasks() {
    }

    public abstract int onRunTask(TaskParams taskParams);

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return 2;
        }
        try {
            intent.setExtrasClassLoader(PendingCallback.class.getClassLoader());
            String action = intent.getAction();
            if (SERVICE_ACTION_EXECUTE_TASK.equals(action)) {
                String stringExtra = intent.getStringExtra("tag");
                Parcelable parcelableExtra = intent.getParcelableExtra("callback");
                Bundle bundleExtra = intent.getBundleExtra("extras");
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("triggered_uris");
                if (!(parcelableExtra instanceof PendingCallback)) {
                    String packageName = getPackageName();
                    StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 47 + String.valueOf(stringExtra).length());
                    sb.append(packageName);
                    sb.append(" ");
                    sb.append(stringExtra);
                    sb.append(": Could not process request, invalid callback.");
                    Log.e("GcmTaskService", sb.toString());
                    return 2;
                }
                if (zzg(stringExtra)) {
                    return 2;
                }
                zzd(new zze(stringExtra, ((PendingCallback) parcelableExtra).zzal, bundleExtra, parcelableArrayListExtra));
            } else if (SERVICE_ACTION_INITIALIZE.equals(action)) {
                onInitializeTasks();
            } else {
                StringBuilder sb2 = new StringBuilder(String.valueOf(action).length() + 37);
                sb2.append("Unknown action received ");
                sb2.append(action);
                sb2.append(", terminating");
                Log.e("GcmTaskService", sb2.toString());
            }
            return 2;
        } finally {
            zzd(i2);
        }
    }
}
