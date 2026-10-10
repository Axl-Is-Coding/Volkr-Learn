package com.sandboxol.messager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.sandboxol.messager.a.c;
import com.sandboxol.messager.a.d;
import com.sandboxol.messager.a.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MessagerClient {
    private static final String MESSAGE_CLASS = "message.class";
    private static final String PACKAGE_NAME = "package.name";
    private static final String TAG = "com.sandboxol.messager.MessagerClient";
    private static final String TAG_DATA = "data";
    private Context mContext;
    private List<c> mList0 = new ArrayList();
    private List<d> mList1 = new ArrayList();
    private a messageBroadcastReceiver;

    /* JADX INFO: loaded from: classes4.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null || !action.equalsIgnoreCase(context.getPackageName())) {
                return;
            }
            String stringExtra = intent.getStringExtra(MessagerClient.MESSAGE_CLASS);
            f fVar = (f) intent.getParcelableExtra("data");
            if (stringExtra == null || stringExtra.length() <= 0) {
                return;
            }
            if (fVar != null) {
                ArrayList arrayList = new ArrayList();
                synchronized (MessagerClient.class) {
                    for (d dVar : MessagerClient.this.mList1) {
                        if (dVar.b() != null && dVar.b().equalsIgnoreCase(stringExtra)) {
                            arrayList.add(dVar.a());
                        }
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((com.sandboxol.messager.a.b) it.next()).onCall(fVar);
                }
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            synchronized (MessagerClient.class) {
                for (c cVar : MessagerClient.this.mList0) {
                    if (cVar.b() != null && cVar.b().equalsIgnoreCase(stringExtra)) {
                        arrayList2.add(cVar.a());
                    }
                }
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                ((com.sandboxol.messager.a.a) it2.next()).onCall();
            }
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final MessagerClient f18784a = new MessagerClient();
    }

    public static MessagerClient getIns() {
        return b.f18784a;
    }

    public void init(Context context) {
        this.mContext = context;
        this.messageBroadcastReceiver = new a();
        context.registerReceiver(this.messageBroadcastReceiver, new IntentFilter(context.getPackageName()));
    }

    public <T> void registerMsg0(Class<T> cls, String str, com.sandboxol.messager.a.a aVar) {
        if (this.messageBroadcastReceiver == null) {
            return;
        }
        synchronized (MessagerClient.class) {
            this.mList0.add(new c(cls, str, aVar));
        }
    }

    public <T> void registerMsg1(Class<T> cls, String str, com.sandboxol.messager.a.b bVar) {
        if (this.messageBroadcastReceiver == null) {
            return;
        }
        synchronized (MessagerClient.class) {
            this.mList1.add(new d(cls, str, bVar));
        }
    }

    public void sendMsg0(String str) {
        Context context;
        if (this.messageBroadcastReceiver == null || (context = this.mContext) == null) {
            return;
        }
        Intent intent = new Intent(context.getPackageName());
        intent.putExtra(MESSAGE_CLASS, str);
        this.mContext.sendBroadcast(intent);
    }

    public void sendMsg1(String str, f fVar) {
        Context context;
        if (this.messageBroadcastReceiver == null || (context = this.mContext) == null) {
            return;
        }
        Intent intent = new Intent(context.getPackageName());
        intent.putExtra(MESSAGE_CLASS, str);
        intent.putExtra("data", fVar);
        this.mContext.sendBroadcast(intent);
    }

    public void unInit(Context context) {
        a aVar = this.messageBroadcastReceiver;
        if (aVar != null) {
            context.unregisterReceiver(aVar);
            this.messageBroadcastReceiver = null;
        }
        this.mContext = null;
    }

    public void unRegisterAll() {
        synchronized (MessagerClient.class) {
            this.mList0.clear();
            this.mList1.clear();
        }
    }

    public <T> void unRegisterMsg(Class<T> cls) {
        synchronized (MessagerClient.class) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (c cVar : this.mList0) {
                if (cVar.c() != null && cVar.c() == cls) {
                    arrayList.add(cVar);
                }
            }
            for (d dVar : this.mList1) {
                if (dVar.c() != null && dVar.c() == cls) {
                    arrayList2.add(dVar);
                }
            }
            this.mList0.removeAll(arrayList);
            this.mList1.removeAll(arrayList2);
        }
    }
}
