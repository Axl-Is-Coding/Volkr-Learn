package com.sandboxol.center.download.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.sandboxol.center.download.entity.MergeBuilder;
import com.sandboxol.center.download.interfaces.Action;
import com.sandboxol.center.download.service.DownloadService;
import com.sandboxol.center.download.service.IDownload;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Func0;

/* JADX INFO: loaded from: classes.dex */
public class DownloadClient {
    private Context mContext;
    private IDownload mDownload = null;
    private List<Func0<Boolean>> tasks = new ArrayList();
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.sandboxol.center.download.client.DownloadClient.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            DownloadClient.this.mDownload = IDownload.Stub.asInterface(iBinder);
            DownloadClient.this.excuteTasksList();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            DownloadClient.this.mDownload = null;
        }
    };

    /* JADX INFO: loaded from: classes3.dex */
    static class DownloadClientAgent {
        static DownloadClient downloadClient = new DownloadClient();

        DownloadClientAgent() {
        }
    }

    private void addTask(Func0 func0) {
        synchronized (DownloadClient.class) {
            this.tasks.add(func0);
        }
    }

    private void excuteTask(Func0 func0) {
        if (this.mDownload != null) {
            func0.call();
        } else {
            addTask(func0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void excuteTasksList() {
        synchronized (DownloadClient.class) {
            ArrayList arrayList = new ArrayList();
            for (Func0<Boolean> func0 : this.tasks) {
                if (func0.call().booleanValue()) {
                    arrayList.add(func0);
                }
            }
            this.tasks.removeAll(arrayList);
        }
    }

    public static DownloadClient getInstance() {
        return DownloadClientAgent.downloadClient;
    }

    public /* synthetic */ Object a(int i, int i2, int i3, MergeBuilder mergeBuilder) {
        try {
            ClientProcess.getProcess(i).process(i2, i3, mergeBuilder, this.mDownload);
            return true;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            Context context = this.mContext;
            if (context != null) {
                onStart(context);
            }
            return false;
        }
    }

    public DownloadClient before(Action action) {
        action.call();
        return this;
    }

    public void onDestroy() {
        try {
            if (this.mContext == null || this.mServiceConnection == null) {
                return;
            }
            this.mContext.unbindService(this.mServiceConnection);
            this.mContext = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onStart(Context context) {
        context.bindService(new Intent(context, (Class<?>) DownloadService.class), this.mServiceConnection, 1);
        this.mContext = context;
    }

    public DownloadClient process(final int i, final int i2, final int i3, final MergeBuilder mergeBuilder) {
        excuteTask(new Func0() { // from class: com.sandboxol.center.download.client.a
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Object call() {
                return this.f16313a.a(i3, i, i2, mergeBuilder);
            }
        });
        return this;
    }

    public DownloadClient process(final int i, final MergeBuilder mergeBuilder) {
        excuteTask(new Func0() { // from class: com.sandboxol.center.download.client.b
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Object call() {
                return this.f16318a.a(i, mergeBuilder);
            }
        });
        return this;
    }

    public /* synthetic */ Object a(int i, MergeBuilder mergeBuilder) {
        try {
            ClientProcess.getProcess(i).process(mergeBuilder, this.mDownload);
            return true;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            Context context = this.mContext;
            if (context != null) {
                onStart(context);
            }
            return false;
        }
    }
}
