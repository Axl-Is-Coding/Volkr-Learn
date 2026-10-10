package com.disabngo.blockynexus.view.activity.tribeshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeShopPageList;
import com.disabngo.blockynexus.view.widget.TribeDressRadioGroup;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.center.router.manager.DressManager;
import com.sandboxol.center.router.moduleInfo.game.GameMessageToken;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import java.util.ArrayList;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: TribeShopViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class E extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f11159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.disabngo.blockynexus.databinding.E f11160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private A f11161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Integer> f11162d = new ObservableField<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Boolean> f11163e = new ObservableField<>(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Boolean> f11164f = new ObservableField<>(false);
    public ObservableMap<Long, String> g = new ObservableArrayMap();
    public ObservableMap<Long, String> h = new ObservableArrayMap();
    public ObservableMap<Long, TribeShopPageList> i = new ObservableArrayMap();
    public ObservableField<Long> j = new ObservableField<>(0L);
    public ObservableField<Boolean> k = new ObservableField<>(false);
    public ObservableField<TribeDressRadioGroup.Tab> l = new ObservableField<>(TribeDressRadioGroup.Tab.CURRENT);
    public ReplyCommand m = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.u
        @Override // rx.functions.Action0
        public final void call() {
            this.f11185a.f();
        }
    });
    public ReplyCommand n = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.v
        @Override // rx.functions.Action0
        public final void call() {
            this.f11186a.h();
        }
    });
    public ReplyCommand o = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.j
        @Override // rx.functions.Action0
        public final void call() {
            this.f11174a.k();
        }
    });
    public ReplyCommand p = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.l
        @Override // rx.functions.Action0
        public final void call() {
            this.f11176a.l();
        }
    });
    public ReplyCommand q = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.p
        @Override // rx.functions.Action0
        public final void call() {
            this.f11180a.m();
        }
    });
    public ReplyCommand r = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.t
        @Override // rx.functions.Action0
        public final void call() {
            this.f11184a.p();
        }
    });
    public ReplyCommand s = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.r
        @Override // rx.functions.Action0
        public final void call() {
            this.f11182a.u();
        }
    });
    public ReplyCommand t = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.i
        @Override // rx.functions.Action0
        public final void call() {
            this.f11173a.D();
        }
    });
    public ReplyCommand u = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.m
        @Override // rx.functions.Action0
        public final void call() {
            this.f11177a.E();
        }
    });
    public ReplyCommand v = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.g
        @Override // rx.functions.Action0
        public final void call() {
            this.f11171a.F();
        }
    });
    public ReplyCommand w = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.s
        @Override // rx.functions.Action0
        public final void call() {
            this.f11183a.i();
        }
    });
    public ReplyCommand<Boolean> x = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.h
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f11172a.a((Boolean) obj);
        }
    });
    public ReplyCommand<TribeDressRadioGroup.Tab> y = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.f
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f11170a.a((TribeDressRadioGroup.Tab) obj);
        }
    });
    public ObservableField<Integer> z = new ObservableField<>();
    public ReplyCommand<Integer> A = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.c
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f11167a.b((Integer) obj);
        }
    });
    public ObservableList<D> B = new ObservableArrayList();
    public me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<D>> C = me.tatarka.bindingcollectionadapter2.g.a(new me.tatarka.bindingcollectionadapter2.l() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.o
        @Override // me.tatarka.bindingcollectionadapter2.l
        public final void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, Object obj) {
            this.f11179a.bindView(gVar, i, (ListItemViewModel) obj);
        }
    });
    public ReplyCommand D = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.k
        @Override // rx.functions.Action0
        public final void call() {
            this.f11175a.j();
        }
    });

    public E(Activity activity, com.disabngo.blockynexus.databinding.E e2) {
        this.f11159a = activity;
        this.f11160b = e2;
        this.f11161c = new A(activity, this.g, this.h, this.i, this.j, this.z, this.l, this.f11162d);
        for (int i = 1; i < 8; i++) {
            this.B.add(new D(activity, i, this.h, this.g, this.i));
        }
        this.f11161c.a(TribeDressRadioGroup.Tab.CLOTH);
        initMessenger();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindView(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<D> listItemViewModel) {
        gVar.a(299, R.layout.content_tribe_shop_page);
    }

    private void initData() {
        Intent intent = this.f11159a.getIntent();
        if (intent != null) {
            TribeCenter.newInstance().tribeGolds.set(Long.valueOf(intent.getLongExtra("tribe.golds.count", 0L)));
            TribeCenter.newInstance().tribeLevel.set(Integer.valueOf(intent.getIntExtra("tribe.level", 0)));
        }
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_DECORATION_LOADING_FINISH_TYPE, Integer.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.n
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f11178a.a((Integer) obj);
            }
        });
        Messenger.getDefault().register(this, GameMessageToken.TOKEN_SHOP_CHANGE_CLOTHES, String.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f11168a.a((String) obj);
            }
        });
    }

    public /* synthetic */ void D() {
        this.f11161c.a("crown");
    }

    public /* synthetic */ void E() {
        this.f11161c.a("top");
    }

    public /* synthetic */ void F() {
        this.f11161c.a("pants");
    }

    public /* synthetic */ void G() {
        this.f11163e.set(true);
    }

    public /* synthetic */ void H() {
        this.f11161c.a(new Action0() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.e
            @Override // rx.functions.Action0
            public final void call() {
                this.f11169a.G();
            }
        });
    }

    public /* synthetic */ void a(Boolean bool) {
        this.f11161c.a(this.f11160b, bool);
        this.k.set(bool);
    }

    public /* synthetic */ void b(Integer num) {
        this.f11161c.a(num.intValue());
    }

    public /* synthetic */ void f() {
        Activity activity = this.f11159a;
        if (activity != null) {
            activity.finish();
        }
    }

    public /* synthetic */ void h() {
        Activity activity = this.f11159a;
        TemplateUtils.startTemplate(activity, w.class, activity.getString(R.string.description));
    }

    public /* synthetic */ void i() {
        this.f11161c.a("shoes");
    }

    public /* synthetic */ void j() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.i.values());
        Bundle bundle = new Bundle();
        bundle.putSerializable("tribe.shop.car.goods.list", arrayList);
        Activity activity = this.f11159a;
        TemplateUtils.startTemplate(activity, com.disabngo.blockynexus.e.b.ta.e.class, activity.getString(R.string.tribe_shop), bundle);
    }

    public /* synthetic */ void k() {
        Activity activity = this.f11159a;
        TemplateUtils.startTemplate(activity, com.disabngo.blockynexus.e.b.ka.h.class, activity.getString(R.string.tribe_donate));
    }

    public /* synthetic */ void l() {
        this.f11161c.a("hat");
    }

    public /* synthetic */ void m() {
        this.f11161c.a("glass");
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        Messenger.getDefault().unregister(this);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onPause() {
        this.f11163e.set(false);
        DressManager.onPauseByGroupView(this.f11160b.f7406a);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onResume() {
        DressManager.setShowUsingDress(false);
        DressManager.onResumeByViewGroup(this.f11160b.f7406a, new Action0() { // from class: com.disabngo.blockynexus.view.activity.tribeshop.q
            @Override // rx.functions.Action0
            public final void call() {
                this.f11181a.H();
            }
        });
    }

    public /* synthetic */ void p() {
        this.f11161c.a("scarf");
    }

    public /* synthetic */ void u() {
        this.f11161c.a("wing");
    }

    public /* synthetic */ void a(TribeDressRadioGroup.Tab tab) {
        this.f11161c.a(tab);
    }

    public /* synthetic */ void a(Integer num) {
        if (num.intValue() == 1) {
            this.f11164f.set(true);
        } else if (num.intValue() == 2) {
            this.f11164f.set(false);
        }
    }

    public /* synthetic */ void a(String str) {
        DressManager.clothTypes(str);
        this.f11161c.a();
        if (this.k.get().booleanValue()) {
            this.f11161c.a(this.f11160b, false);
            this.k.set(false);
        }
    }
}
