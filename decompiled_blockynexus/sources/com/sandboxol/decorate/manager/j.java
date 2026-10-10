package com.sandboxol.decorate.manager;

import android.content.Context;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;
import com.sandboxol.decorate.widget.DressMenuButton;
import com.sandboxol.decorate.widget.DressRadioGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DressStrategyManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<DressMenuButton.MenuItem, com.sandboxol.decorate.e.a> f17182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<Integer, Boolean> f17183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f17184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private DressMenuButton.MenuItem f17185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private DressRadioGroup.Tab f17186e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<Integer, List<SingleDressInfo>> f17187f;
    private List<SuitDressInfo> g;
    private List<ShopRecommendDecorationInfo> h;
    private Map<Integer, Boolean> i;
    private boolean j;

    /* JADX INFO: compiled from: DressStrategyManager.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final j f17188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final j f17189b;

        static {
            i iVar = null;
            f17188a = new j(iVar);
            f17189b = new j(iVar);
        }
    }

    /* synthetic */ j(i iVar) {
        this();
    }

    private void b(Context context, com.sandboxol.decorate.manager.a.c cVar, DressMenuButton.MenuItem menuItem) {
        com.sandboxol.decorate.e.a aVar = this.f17182a.get(menuItem);
        aVar.getClass();
        aVar.b(context, cVar);
    }

    public static j c() {
        return a.f17188a;
    }

    public static j d() {
        return a.f17189b;
    }

    public static void l() {
        c().f17187f.clear();
        c().g.clear();
        c().h.clear();
        d().f17187f.clear();
        d().g.clear();
        d().h.clear();
    }

    private void m() {
        this.f17183b = new HashMap();
        this.f17183b.put(0, false);
        this.f17183b.put(30, false);
        this.f17183b.put(31, false);
        this.f17183b.put(16, false);
        this.f17183b.put(8, false);
        this.f17183b.put(9, false);
        this.f17183b.put(10, false);
        this.f17183b.put(2, false);
        this.f17183b.put(4, false);
        this.f17183b.put(11, false);
        this.f17183b.put(12, false);
        this.f17183b.put(13, false);
        this.f17183b.put(14, false);
        this.f17183b.put(15, false);
        this.f17183b.put(5, false);
        this.f17183b.put(6, false);
        this.f17183b.put(7, false);
        this.f17183b.put(32, false);
    }

    public void a(DressMenuButton.MenuItem menuItem, com.sandboxol.decorate.e.a aVar) {
        this.f17182a.put(menuItem, aVar);
    }

    public boolean e() {
        return this.f17184c;
    }

    public void f() {
        Iterator<Integer> it = c().i.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (c().b(iIntValue)) {
                if (this.j) {
                    c().i.put(Integer.valueOf(iIntValue), false);
                } else {
                    c().i.put(Integer.valueOf(iIntValue), true);
                }
            }
        }
        if (this.j) {
            this.j = false;
        }
    }

    public void g() {
        Iterator<Integer> it = d().i.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (d().b(iIntValue)) {
                d().i.put(Integer.valueOf(iIntValue), true);
            }
        }
    }

    public void h() {
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.decoration.type0");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.decoration.type31");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.decoration.type16");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.decoration.type8");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.decoration.type9");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.decoration.type10");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.decoration.type2");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.decoration.type4");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.decoration.type11");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.decoration.type12");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.decoration.type13");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.decoration.type14");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.decoration.type15");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.decoration.type5");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.decoration.type6");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.decoration.type7");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.decoration.type32");
    }

    public void i() {
        f();
        Messenger.getDefault().sendNoMsg("token.refresh.dress.list.check0");
        Messenger.getDefault().sendNoMsg("token.refresh.dress.list.check31");
        Messenger.getDefault().sendNoMsg("token.refresh.dress.list.check16");
        Messenger.getDefault().sendNoMsg("token.refresh.dress.list.check8");
        Messenger.getDefault().sendNoMsg("token.refresh.dress.list.check9");
        Messenger.getDefault().sendNoMsg("token.refresh.dress.list.check10");
        Messenger.getDefault().sendNoMsg("token.refresh.dress.list.check2");
        Messenger.getDefault().sendNoMsg("token.refresh.dress.list.check4");
        Messenger.getDefault().sendNoMsg("token.refresh.dress.list.check11");
        Messenger.getDefault().sendNoMsg("token.refresh.dress.list.check12");
        Messenger.getDefault().sendNoMsg("token.refresh.dress.list.check13");
        Messenger.getDefault().sendNoMsg("token.refresh.dress.list.check14");
        Messenger.getDefault().sendNoMsg("token.refresh.dress.list.check15");
        Messenger.getDefault().sendNoMsg("token.refresh.dress.list.check5");
        Messenger.getDefault().sendNoMsg("token.refresh.dress.list.check6");
        Messenger.getDefault().sendNoMsg("token.refresh.dress.list.check7");
        Messenger.getDefault().sendNoMsg("token.refresh.dress.list.check32");
    }

    public void j() {
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.shop.list30");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.shop.list31");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.shop.list16");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.shop.list8");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.shop.list9");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.shop.list10");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.shop.list2");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.shop.list4");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.shop.list11");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.shop.list12");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.shop.list13");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.shop.list14");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.shop.list15");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.shop.list5");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.shop.list6");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.shop.list7");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.shop.list32");
    }

    public void k() {
        g();
        Messenger.getDefault().sendNoMsg("token.refresh.shop.list.check0");
        Messenger.getDefault().sendNoMsg("token.refresh.shop.list.check31");
        Messenger.getDefault().sendNoMsg("token.refresh.shop.list.check16");
        Messenger.getDefault().sendNoMsg("token.refresh.shop.list.check8");
        Messenger.getDefault().sendNoMsg("token.refresh.shop.list.check9");
        Messenger.getDefault().sendNoMsg("token.refresh.shop.list.check10");
        Messenger.getDefault().sendNoMsg("token.refresh.shop.list.check2");
        Messenger.getDefault().sendNoMsg("token.refresh.shop.list.check4");
        Messenger.getDefault().sendNoMsg("token.refresh.shop.list.check11");
        Messenger.getDefault().sendNoMsg("token.refresh.shop.list.check12");
        Messenger.getDefault().sendNoMsg("token.refresh.shop.list.check13");
        Messenger.getDefault().sendNoMsg("token.refresh.shop.list.check14");
        Messenger.getDefault().sendNoMsg("token.refresh.shop.list.check15");
        Messenger.getDefault().sendNoMsg("token.refresh.shop.list.check5");
        Messenger.getDefault().sendNoMsg("token.refresh.shop.list.check6");
        Messenger.getDefault().sendNoMsg("token.refresh.shop.list.check7");
        Messenger.getDefault().sendNoMsg("token.refresh.shop.list.check32");
    }

    private j() {
        this.f17185d = DressMenuButton.MenuItem.CLOTH;
        this.f17186e = DressRadioGroup.Tab.ALL;
        this.f17182a = new HashMap<>();
        this.f17187f = new HashMap();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new HashMap();
        m();
    }

    public void a(Context context, com.sandboxol.decorate.manager.a.c cVar, DressMenuButton.MenuItem menuItem) {
        if (this.f17182a.containsKey(menuItem)) {
            com.sandboxol.decorate.e.a aVar = this.f17182a.get(menuItem);
            aVar.getClass();
            aVar.a(context, cVar);
            b(context, cVar, menuItem);
        }
    }

    public void b(DressMenuButton.MenuItem menuItem) {
        this.f17185d = menuItem;
    }

    public boolean c(int i) {
        Boolean bool = this.i.get(Integer.valueOf(i));
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean b(int i) {
        return this.f17183b.get(Integer.valueOf(i)).booleanValue();
    }

    private void b(DressRadioGroup.Tab tab, String str) {
        Messenger.getDefault().send(RefreshMsg.create(), str + b(tab));
    }

    private int b(DressRadioGroup.Tab tab) {
        switch (i.f17181b[tab.ordinal()]) {
        }
        return 0;
    }

    public void a(DressRadioGroup.Tab tab) {
        this.f17186e = tab;
    }

    public void a(DressRadioGroup.Tab tab, String str) {
        if (this.f17183b.get(Integer.valueOf(b(tab))).booleanValue()) {
            return;
        }
        this.f17183b.put(Integer.valueOf(b(tab)), true);
        b(tab, str);
    }

    public void b(boolean z) {
        this.f17184c = z;
    }

    public void b(List<ShopRecommendDecorationInfo> list) {
        this.i.put(30, false);
        this.h.clear();
        this.h.addAll(list);
    }

    public void a(DressMenuButton.MenuItem menuItem) {
        int i = i.f17180a[menuItem.ordinal()];
        if (i == 2) {
            this.f17183b.put(11, false);
            this.f17183b.put(12, false);
            this.f17183b.put(13, false);
            this.f17183b.put(14, false);
            this.f17183b.put(15, false);
            return;
        }
        if (i == 3) {
            this.f17183b.put(5, false);
            this.f17183b.put(6, false);
            this.f17183b.put(7, false);
        } else {
            if (i != 4) {
                this.f17183b.put(0, false);
                this.f17183b.put(30, false);
                this.f17183b.put(31, false);
                this.f17183b.put(16, false);
                this.f17183b.put(8, false);
                this.f17183b.put(9, false);
                this.f17183b.put(10, false);
                this.f17183b.put(2, false);
                this.f17183b.put(4, false);
                return;
            }
            this.f17183b.put(32, false);
        }
    }

    public List<SuitDressInfo> b() {
        List<SuitDressInfo> list = this.g;
        return list == null ? new ArrayList() : list;
    }

    public void a(int i, List<SingleDressInfo> list) {
        this.i.put(Integer.valueOf(i), false);
        this.f17187f.put(Integer.valueOf(i), list);
    }

    public void a(List<SuitDressInfo> list) {
        this.i.put(31, false);
        this.g.clear();
        this.g.addAll(list);
    }

    public List<SingleDressInfo> a(int i) {
        return this.f17187f.get(Integer.valueOf(i)) == null ? new ArrayList() : this.f17187f.get(Integer.valueOf(i));
    }

    public List<ShopRecommendDecorationInfo> a() {
        List<ShopRecommendDecorationInfo> list = this.h;
        return list == null ? new ArrayList() : list;
    }

    public void a(int i, boolean z) {
        this.i.put(Integer.valueOf(i), Boolean.valueOf(z));
    }

    public void a(boolean z) {
        this.j = z;
    }

    public DressRadioGroup.Tab a(DressMenuButton.MenuItem menuItem, int i) {
        int i2 = i.f17180a[menuItem.ordinal()];
        if (i2 == 1) {
            if (i == 0) {
                return DressRadioGroup.Tab.SUIT;
            }
            if (i != 1) {
                return DressRadioGroup.Tab.ALL;
            }
            return DressRadioGroup.Tab.RECOMMEND;
        }
        if (i2 == 2) {
            return DressRadioGroup.Tab.FACEDEC;
        }
        if (i2 == 3) {
            return DressRadioGroup.Tab.ACTION;
        }
        if (i2 != 4) {
            return DressRadioGroup.Tab.ALL;
        }
        return DressRadioGroup.Tab.HISTORY;
    }
}
