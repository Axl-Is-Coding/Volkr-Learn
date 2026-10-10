package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.l;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: NotificationCompatBuilder.java */
/* JADX INFO: loaded from: classes.dex */
class m implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Notification.Builder f1015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l.e f1016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RemoteViews f1017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RemoteViews f1018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<Bundle> f1019e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Bundle f1020f = new Bundle();
    private int g;
    private RemoteViews h;

    m(l.e eVar) {
        ArrayList<String> arrayList;
        this.f1016b = eVar;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1015a = new Notification.Builder(eVar.f1005a, eVar.I);
        } else {
            this.f1015a = new Notification.Builder(eVar.f1005a);
        }
        Notification notification = eVar.P;
        this.f1015a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(eVar.f1008d).setContentText(eVar.f1009e).setContentInfo(eVar.j).setContentIntent(eVar.f1010f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(eVar.g, (notification.flags & 128) != 0).setLargeIcon(eVar.i).setNumber(eVar.k).setProgress(eVar.r, eVar.s, eVar.t);
        if (Build.VERSION.SDK_INT < 21) {
            this.f1015a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1015a.setSubText(eVar.p).setUsesChronometer(eVar.n).setPriority(eVar.l);
            Iterator<l.a> it = eVar.f1006b.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            Bundle bundle = eVar.B;
            if (bundle != null) {
                this.f1020f.putAll(bundle);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (eVar.x) {
                    this.f1020f.putBoolean("android.support.localOnly", true);
                }
                String str = eVar.u;
                if (str != null) {
                    this.f1020f.putString("android.support.groupKey", str);
                    if (eVar.v) {
                        this.f1020f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f1020f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                String str2 = eVar.w;
                if (str2 != null) {
                    this.f1020f.putString("android.support.sortKey", str2);
                }
            }
            this.f1017c = eVar.F;
            this.f1018d = eVar.G;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1015a.setShowWhen(eVar.m);
            if (Build.VERSION.SDK_INT < 21 && (arrayList = eVar.Q) != null && !arrayList.isEmpty()) {
                Bundle bundle2 = this.f1020f;
                ArrayList<String> arrayList2 = eVar.Q;
                bundle2.putStringArray("android.people", (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f1015a.setLocalOnly(eVar.x).setGroup(eVar.u).setGroupSummary(eVar.v).setSortKey(eVar.w);
            this.g = eVar.M;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1015a.setCategory(eVar.A).setColor(eVar.C).setVisibility(eVar.D).setPublicVersion(eVar.E).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = eVar.Q.iterator();
            while (it2.hasNext()) {
                this.f1015a.addPerson(it2.next());
            }
            this.h = eVar.H;
            if (eVar.f1007c.size() > 0) {
                Bundle bundle3 = eVar.b().getBundle("android.car.EXTENSIONS");
                bundle3 = bundle3 == null ? new Bundle() : bundle3;
                Bundle bundle4 = new Bundle();
                for (int i = 0; i < eVar.f1007c.size(); i++) {
                    bundle4.putBundle(Integer.toString(i), n.a(eVar.f1007c.get(i)));
                }
                bundle3.putBundle("invisible_actions", bundle4);
                eVar.b().putBundle("android.car.EXTENSIONS", bundle3);
                this.f1020f.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f1015a.setExtras(eVar.B).setRemoteInputHistory(eVar.q);
            RemoteViews remoteViews = eVar.F;
            if (remoteViews != null) {
                this.f1015a.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = eVar.G;
            if (remoteViews2 != null) {
                this.f1015a.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = eVar.H;
            if (remoteViews3 != null) {
                this.f1015a.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1015a.setBadgeIconType(eVar.J).setShortcutId(eVar.K).setTimeoutAfter(eVar.L).setGroupAlertBehavior(eVar.M);
            if (eVar.z) {
                this.f1015a.setColorized(eVar.y);
            }
            if (!TextUtils.isEmpty(eVar.I)) {
                this.f1015a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1015a.setAllowSystemGeneratedContextualActions(eVar.N);
            this.f1015a.setBubbleMetadata(l.d.a(eVar.O));
        }
    }

    @Override // androidx.core.app.k
    public Notification.Builder a() {
        return this.f1015a;
    }

    public Notification b() {
        Bundle bundleA;
        RemoteViews remoteViewsD;
        RemoteViews remoteViewsB;
        l.f fVar = this.f1016b.o;
        if (fVar != null) {
            fVar.a(this);
        }
        RemoteViews remoteViewsC = fVar != null ? fVar.c(this) : null;
        Notification notificationC = c();
        if (remoteViewsC != null) {
            notificationC.contentView = remoteViewsC;
        } else {
            RemoteViews remoteViews = this.f1016b.F;
            if (remoteViews != null) {
                notificationC.contentView = remoteViews;
            }
        }
        if (Build.VERSION.SDK_INT >= 16 && fVar != null && (remoteViewsB = fVar.b(this)) != null) {
            notificationC.bigContentView = remoteViewsB;
        }
        if (Build.VERSION.SDK_INT >= 21 && fVar != null && (remoteViewsD = this.f1016b.o.d(this)) != null) {
            notificationC.headsUpContentView = remoteViewsD;
        }
        if (Build.VERSION.SDK_INT >= 16 && fVar != null && (bundleA = l.a(notificationC)) != null) {
            fVar.a(bundleA);
        }
        return notificationC;
    }

    protected Notification c() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            return this.f1015a.build();
        }
        if (i >= 24) {
            Notification notificationBuild = this.f1015a.build();
            if (this.g != 0) {
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) != 0 && this.g == 2) {
                    a(notificationBuild);
                }
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) == 0 && this.g == 1) {
                    a(notificationBuild);
                }
            }
            return notificationBuild;
        }
        if (i >= 21) {
            this.f1015a.setExtras(this.f1020f);
            Notification notificationBuild2 = this.f1015a.build();
            RemoteViews remoteViews = this.f1017c;
            if (remoteViews != null) {
                notificationBuild2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f1018d;
            if (remoteViews2 != null) {
                notificationBuild2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.h;
            if (remoteViews3 != null) {
                notificationBuild2.headsUpContentView = remoteViews3;
            }
            if (this.g != 0) {
                if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) != 0 && this.g == 2) {
                    a(notificationBuild2);
                }
                if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) == 0 && this.g == 1) {
                    a(notificationBuild2);
                }
            }
            return notificationBuild2;
        }
        if (i >= 20) {
            this.f1015a.setExtras(this.f1020f);
            Notification notificationBuild3 = this.f1015a.build();
            RemoteViews remoteViews4 = this.f1017c;
            if (remoteViews4 != null) {
                notificationBuild3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f1018d;
            if (remoteViews5 != null) {
                notificationBuild3.bigContentView = remoteViews5;
            }
            if (this.g != 0) {
                if (notificationBuild3.getGroup() != null && (notificationBuild3.flags & 512) != 0 && this.g == 2) {
                    a(notificationBuild3);
                }
                if (notificationBuild3.getGroup() != null && (notificationBuild3.flags & 512) == 0 && this.g == 1) {
                    a(notificationBuild3);
                }
            }
            return notificationBuild3;
        }
        if (i >= 19) {
            SparseArray<Bundle> sparseArrayA = n.a(this.f1019e);
            if (sparseArrayA != null) {
                this.f1020f.putSparseParcelableArray("android.support.actionExtras", sparseArrayA);
            }
            this.f1015a.setExtras(this.f1020f);
            Notification notificationBuild4 = this.f1015a.build();
            RemoteViews remoteViews6 = this.f1017c;
            if (remoteViews6 != null) {
                notificationBuild4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f1018d;
            if (remoteViews7 != null) {
                notificationBuild4.bigContentView = remoteViews7;
            }
            return notificationBuild4;
        }
        if (i < 16) {
            return this.f1015a.getNotification();
        }
        Notification notificationBuild5 = this.f1015a.build();
        Bundle bundleA = l.a(notificationBuild5);
        Bundle bundle = new Bundle(this.f1020f);
        for (String str : this.f1020f.keySet()) {
            if (bundleA.containsKey(str)) {
                bundle.remove(str);
            }
        }
        bundleA.putAll(bundle);
        SparseArray<Bundle> sparseArrayA2 = n.a(this.f1019e);
        if (sparseArrayA2 != null) {
            l.a(notificationBuild5).putSparseParcelableArray("android.support.actionExtras", sparseArrayA2);
        }
        RemoteViews remoteViews8 = this.f1017c;
        if (remoteViews8 != null) {
            notificationBuild5.contentView = remoteViews8;
        }
        RemoteViews remoteViews9 = this.f1018d;
        if (remoteViews9 != null) {
            notificationBuild5.bigContentView = remoteViews9;
        }
        return notificationBuild5;
    }

    private void a(l.a aVar) {
        Notification.Action.Builder builder;
        int i = Build.VERSION.SDK_INT;
        if (i < 20) {
            if (i >= 16) {
                this.f1019e.add(n.a(this.f1015a, aVar));
                return;
            }
            return;
        }
        if (i >= 23) {
            IconCompat iconCompatF = aVar.f();
            builder = new Notification.Action.Builder(iconCompatF == null ? null : iconCompatF.e(), aVar.j(), aVar.a());
        } else {
            builder = new Notification.Action.Builder(aVar.e(), aVar.j(), aVar.a());
        }
        if (aVar.g() != null) {
            for (RemoteInput remoteInput : p.a(aVar.g())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        Bundle bundle = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        if (Build.VERSION.SDK_INT >= 24) {
            builder.setAllowGeneratedReplies(aVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", aVar.h());
        if (Build.VERSION.SDK_INT >= 28) {
            builder.setSemanticAction(aVar.h());
        }
        if (Build.VERSION.SDK_INT >= 29) {
            builder.setContextual(aVar.k());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.i());
        builder.addExtras(bundle);
        this.f1015a.addAction(builder.build());
    }

    private void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
