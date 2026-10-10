package com.sandboxol.decorate.manager;

import android.content.Context;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: UserDressInfoHolder.java */
/* JADX INFO: loaded from: classes3.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f17212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableMap<Long, String> f17213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableMap<Long, Long> f17214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableList<Long> f17215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<Long, SingleDressInfo> f17216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableMap<Long, ShopRecommendDecorationInfo> f17217f;
    public Map<Long, Integer> g;
    public Map<Long, SingleDressInfo> h;
    public Map<Long, SuitDressInfo> i;

    /* JADX INFO: compiled from: UserDressInfoHolder.java */
    public interface a {
        void a();
    }

    /* JADX INFO: compiled from: UserDressInfoHolder.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final v f17218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final v f17219b;

        static {
            t tVar = null;
            f17218a = new v(tVar);
            f17219b = new v(tVar);
        }
    }

    /* synthetic */ v(t tVar) {
        this();
    }

    public static void a(long j, SingleDressInfo singleDressInfo) {
        if (singleDressInfo != null) {
            if (b().h == null) {
                b().h = new LinkedHashMap();
            }
            b().h.put(Long.valueOf(j), singleDressInfo);
        }
    }

    public static void f() {
        Iterator<Long> it = a().f17213b.keySet().iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            g.a(a().f17213b.get(Long.valueOf(jLongValue)));
            Messenger.getDefault().send(a().c(jLongValue), MessageToken.TOKEN_DRESS_RADIO_GROUP_MODIFY_ITEM_URL);
            if (a().f17216e.get(Long.valueOf(jLongValue)) != null && n.a(a().f17216e.get(Long.valueOf(jLongValue)))) {
                Iterator<Long> it2 = a().f17216e.get(Long.valueOf(jLongValue)).getOccupyPosition().iterator();
                while (it2.hasNext()) {
                    Messenger.getDefault().send(new SingleDressInfo(it2.next().longValue(), a().c(jLongValue).getIconUrl()), MessageToken.TOKEN_DRESS_RADIO_GROUP_MODIFY_ITEM_URL);
                }
            }
        }
    }

    public void b(SingleDressInfo singleDressInfo) {
        this.f17213b.put(Long.valueOf(singleDressInfo.getTypeId()), singleDressInfo.getResourceId());
        this.f17214c.put(Long.valueOf(singleDressInfo.getTypeId()), Long.valueOf(singleDressInfo.getId()));
    }

    public boolean c() {
        return this.f17212a;
    }

    public void d(long j) {
        this.f17213b.put(Long.valueOf(j), com.sandboxol.decorate.f.j.a(j));
        this.f17214c.remove(Long.valueOf(j));
    }

    public void e(long j) {
        this.f17213b.put(Long.valueOf(j), com.sandboxol.decorate.f.j.b(j));
        this.f17214c.remove(Long.valueOf(j));
        g(j);
    }

    public void g(long j) {
        this.f17216e.remove(Long.valueOf(j));
    }

    private v() {
        this.f17212a = false;
        this.f17213b = new ObservableArrayMap();
        this.f17214c = new ObservableArrayMap();
        this.f17215d = new ObservableArrayList();
        this.f17216e = new HashMap();
        this.f17217f = new ObservableArrayMap();
        this.g = new HashMap();
    }

    public SingleDressInfo c(long j) {
        return this.f17216e.get(Long.valueOf(j)) != null ? this.f17216e.get(Long.valueOf(j)) : new SingleDressInfo(j);
    }

    public long b(long j) {
        try {
            if (this.f17214c.containsKey(Long.valueOf(j)) && this.f17214c.get(Long.valueOf(j)) != null) {
                return this.f17214c.get(Long.valueOf(j)).longValue();
            }
            return 0L;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public boolean d() {
        Iterator<Long> it = this.g.keySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            if (this.g.get(Long.valueOf(jLongValue)) != null) {
                iIntValue += this.g.get(Long.valueOf(jLongValue)).intValue();
            }
        }
        return iIntValue > 0;
    }

    public static void a(long j, SuitDressInfo suitDressInfo) {
        if (suitDressInfo != null) {
            if (b().i == null) {
                b().i = new LinkedHashMap();
            }
            b().i.put(Long.valueOf(j), suitDressInfo);
        }
    }

    public static void e() {
        b().f17214c.clear();
        b().f17215d.clear();
        b().f17213b.clear();
        b().f17217f.clear();
        b().f17213b.putAll(a().f17213b);
        b().f17214c.putAll(a().f17214c);
        b().f17215d.addAll(a().f17215d);
    }

    public static v b() {
        return b.f17219b;
    }

    public static void a(Context context) {
        boolean z = b().i != null && b().i.size() > 0;
        boolean z2 = b().h != null && b().h.size() > 0;
        if (z) {
            Iterator<Map.Entry<Long, SuitDressInfo>> it = b().i.entrySet().iterator();
            Map.Entry<Long, SuitDressInfo> next = null;
            while (it.hasNext()) {
                next = it.next();
            }
            if (next != null) {
                next.getValue().setDecorationInfoList(next.getValue().getShopDecorationInfos());
                f.e().b().a(context, next.getValue());
                b().i.clear();
            }
        }
        if (z2) {
            Iterator<Map.Entry<Long, SingleDressInfo>> it2 = b().h.entrySet().iterator();
            while (it2.hasNext()) {
                f.e().a().a(context, it2.next().getValue());
            }
            b().h.clear();
        }
        if (z || z2) {
            new t(500L, 1000L).start();
        }
    }

    public void f(long j) {
        if (!this.g.containsKey(Long.valueOf(j)) || this.g.get(Long.valueOf(j)) == null || this.g.get(Long.valueOf(j)).intValue() == 0) {
            return;
        }
        this.g.put(Long.valueOf(j), Integer.valueOf(this.g.get(Long.valueOf(j)).intValue() - 1));
    }

    public static void a(Context context, a aVar) {
        com.sandboxol.decorate.web.t.c(context, new u(aVar, context));
    }

    public void a(boolean z) {
        this.f17212a = z;
    }

    public void a(List<SingleDressInfo> list) {
        for (SingleDressInfo singleDressInfo : list) {
            this.f17216e.put(Long.valueOf(singleDressInfo.getTypeId()), singleDressInfo);
        }
    }

    public void a(SingleDressInfo singleDressInfo) {
        this.f17216e.put(Long.valueOf(singleDressInfo.getTypeId()), singleDressInfo);
    }

    public void a(long j) {
        if (this.g.containsKey(Long.valueOf(j))) {
            int iIntValue = this.g.get(Long.valueOf(j)).intValue();
            if (iIntValue == 0) {
                this.g.put(Long.valueOf(j), Integer.valueOf(iIntValue + 1));
                return;
            }
            return;
        }
        this.g.put(Long.valueOf(j), 1);
    }

    public static v a() {
        return b.f17218a;
    }
}
