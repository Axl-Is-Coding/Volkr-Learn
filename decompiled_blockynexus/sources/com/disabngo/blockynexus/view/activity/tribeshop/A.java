package com.disabngo.blockynexus.view.activity.tribeshop;

import android.app.Activity;
import android.widget.LinearLayout;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableMap;
import com.disabngo.blockynexus.d.K;
import com.disabngo.blockynexus.entity.TribeShopPageList;
import com.disabngo.blockynexus.view.widget.TribeDressRadioGroup;
import com.sandboxol.center.router.manager.DressManager;
import rx.functions.Action0;

/* JADX INFO: compiled from: TribeShopModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f11143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ObservableMap<Long, String> f11144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObservableMap<Long, String> f11145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ObservableMap<Long, TribeShopPageList> f11146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ObservableField<Long> f11147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Integer> f11148f;
    public ObservableField<TribeDressRadioGroup.Tab> g;
    public ObservableField<Integer> h;

    public A(Activity activity, ObservableMap<Long, String> observableMap, ObservableMap<Long, String> observableMap2, ObservableMap<Long, TribeShopPageList> observableMap3, ObservableField<Long> observableField, ObservableField<Integer> observableField2, ObservableField<TribeDressRadioGroup.Tab> observableField3, ObservableField<Integer> observableField4) {
        this.f11144b = new ObservableArrayMap();
        this.f11145c = new ObservableArrayMap();
        this.f11146d = new ObservableArrayMap();
        this.f11147e = new ObservableField<>(0L);
        this.f11148f = new ObservableField<>();
        this.g = new ObservableField<>();
        this.h = new ObservableField<>();
        this.f11143a = activity;
        this.f11144b = observableMap;
        this.f11145c = observableMap2;
        this.f11146d = observableMap3;
        this.f11147e = observableField;
        this.f11148f = observableField2;
        this.g = observableField3;
        this.h = observableField4;
    }

    private void b() {
        if (this.g.get() == TribeDressRadioGroup.Tab.CLOTH) {
            this.h.set(1);
        } else if (this.g.get() == TribeDressRadioGroup.Tab.ORNAMENTS) {
            this.h.set(2);
        } else {
            this.h.set(0);
        }
    }

    public void a(String str) {
        for (String str2 : this.f11144b.values()) {
            if (str2 != null && str2.contains(str)) {
                String strA = K.a(str2);
                Long lA = K.a(this.f11144b, str2);
                if (lA != null) {
                    if (strA == null || !strA.endsWith("1")) {
                        this.f11145c.remove(lA);
                    } else {
                        this.f11145c.put(lA, strA);
                    }
                    this.f11144b.put(lA, "empty");
                    this.f11146d.remove(lA);
                }
                DressManager.clothTypes(strA);
            }
        }
        a();
    }

    public void a() {
        long price = 0;
        for (TribeShopPageList tribeShopPageList : this.f11146d.values()) {
            if (tribeShopPageList.getQuantity() != -1 && tribeShopPageList.getHasPurchase() == 0) {
                price += (long) tribeShopPageList.getPrice();
            }
        }
        this.f11147e.set(Long.valueOf(price));
    }

    public void a(TribeDressRadioGroup.Tab tab) {
        this.g.set(tab);
        this.f11148f.set(Integer.valueOf(tab.position - 1));
        b();
    }

    public void a(int i) {
        this.f11148f.set(Integer.valueOf(i));
        this.g.set(TribeDressRadioGroup.Tab.getTabByPosition(i + 1));
        b();
    }

    public void a(Action0 action0) {
        com.sandboxol.decorate.web.t.c(this.f11143a, new z(this, action0));
    }

    public void a(com.disabngo.blockynexus.databinding.E e2, Boolean bool) {
        LinearLayout linearLayout = e2.g;
        linearLayout.startAnimation(new com.sandboxol.decorate.b.a(linearLayout, bool.booleanValue() ? com.sandboxol.decorate.b.a.f16974b : com.sandboxol.decorate.b.a.f16973a));
    }
}
