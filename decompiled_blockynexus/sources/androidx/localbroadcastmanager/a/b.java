package androidx.localbroadcastmanager.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: compiled from: LocalBroadcastManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f1643a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f1644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f1645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<C0027b>> f1646d = new HashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap<String, ArrayList<C0027b>> f1647e = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayList<a> f1648f = new ArrayList<>();
    private final Handler g;

    /* JADX INFO: compiled from: LocalBroadcastManager.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Intent f1649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ArrayList<C0027b> f1650b;

        a(Intent intent, ArrayList<C0027b> arrayList) {
            this.f1649a = intent;
            this.f1650b = arrayList;
        }
    }

    /* JADX INFO: renamed from: androidx.localbroadcastmanager.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LocalBroadcastManager.java */
    private static final class C0027b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final IntentFilter f1651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BroadcastReceiver f1652b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f1653c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1654d;

        C0027b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f1651a = intentFilter;
            this.f1652b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f1652b);
            sb.append(" filter=");
            sb.append(this.f1651a);
            if (this.f1654d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private b(Context context) {
        this.f1645c = context;
        this.g = new androidx.localbroadcastmanager.a.a(this, context.getMainLooper());
    }

    public static b a(Context context) {
        b bVar;
        synchronized (f1643a) {
            if (f1644b == null) {
                f1644b = new b(context.getApplicationContext());
            }
            bVar = f1644b;
        }
        return bVar;
    }

    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f1646d) {
            C0027b c0027b = new C0027b(intentFilter, broadcastReceiver);
            ArrayList<C0027b> arrayList = this.f1646d.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f1646d.put(broadcastReceiver, arrayList);
            }
            arrayList.add(c0027b);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<C0027b> arrayList2 = this.f1647e.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f1647e.put(action, arrayList2);
                }
                arrayList2.add(c0027b);
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f1646d) {
            ArrayList<C0027b> arrayListRemove = this.f1646d.remove(broadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                C0027b c0027b = arrayListRemove.get(size);
                c0027b.f1654d = true;
                for (int i = 0; i < c0027b.f1651a.countActions(); i++) {
                    String action = c0027b.f1651a.getAction(i);
                    ArrayList<C0027b> arrayList = this.f1647e.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            C0027b c0027b2 = arrayList.get(size2);
                            if (c0027b2.f1652b == broadcastReceiver) {
                                c0027b2.f1654d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f1647e.remove(action);
                        }
                    }
                }
            }
        }
    }

    public boolean a(Intent intent) {
        String str;
        ArrayList arrayList;
        int i;
        ArrayList<C0027b> arrayList2;
        String str2;
        synchronized (this.f1646d) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f1645c.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<C0027b> arrayList3 = this.f1647e.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    C0027b c0027b = arrayList3.get(i2);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + c0027b.f1651a);
                    }
                    if (c0027b.f1653c) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i = i2;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = strResolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        str = action;
                        arrayList = arrayList4;
                        i = i2;
                        arrayList2 = arrayList3;
                        str2 = strResolveTypeIfNeeded;
                        int iMatch = c0027b.f1651a.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (iMatch >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(c0027b);
                            c0027b.f1653c = true;
                            i2 = i + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            strResolveTypeIfNeeded = str2;
                        } else if (z) {
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + (iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                        }
                    }
                    arrayList4 = arrayList;
                    i2 = i + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    strResolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                        ((C0027b) arrayList5.get(i3)).f1653c = false;
                    }
                    this.f1648f.add(new a(intent, arrayList5));
                    if (!this.g.hasMessages(1)) {
                        this.g.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    void a() {
        a[] aVarArr;
        while (true) {
            synchronized (this.f1646d) {
                int size = this.f1648f.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new a[size];
                this.f1648f.toArray(aVarArr);
                this.f1648f.clear();
            }
            for (a aVar : aVarArr) {
                int size2 = aVar.f1650b.size();
                for (int i = 0; i < size2; i++) {
                    C0027b c0027b = aVar.f1650b.get(i);
                    if (!c0027b.f1654d) {
                        c0027b.f1652b.onReceive(this.f1645c, aVar.f1649a);
                    }
                }
            }
        }
    }
}
