package com.sandboxol.vip.d.b.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.google.android.material.tabs.TabLayout;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.vip.R;
import com.sandboxol.vip.b.o;
import com.sandboxol.vip.d.a.a.j;
import com.sandboxol.vip.entity.PrivilegeInfo;
import java.util.List;
import me.tatarka.bindingcollectionadapter2.l;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: PrivilegeDetailViewModel.java */
/* JADX INFO: loaded from: classes4.dex */
public class h extends ViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f19081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<PrivilegeInfo> f19082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private o f19083d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f19080a = {R.id.rb_item_1, R.id.rb_item_2, R.id.rb_item_3, R.id.rb_item_4, R.id.rb_item_5, R.id.rb_item_6, R.id.rb_item_7, R.id.rb_item_8, R.id.rb_item_9, R.id.rb_item_10};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Integer> f19084e = new ObservableField<>(1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Boolean> f19085f = new ObservableField<>(false);
    public ObservableField<String> g = new ObservableField<>(BaseApplication.getContext().getString(R.string.vip_privilege_list_item_title_1));
    public ObservableField<Integer> h = new ObservableField<>(Integer.valueOf(R.id.rb_item_1));
    public ObservableList<g> i = new ObservableArrayList();
    public me.tatarka.bindingcollectionadapter2.g<g> j = me.tatarka.bindingcollectionadapter2.g.a(new l() { // from class: com.sandboxol.vip.d.b.a.d
        @Override // me.tatarka.bindingcollectionadapter2.l
        public final void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, Object obj) {
            this.f19077a.a(gVar, i, (g) obj);
        }
    });
    public ReplyCommand<Integer> k = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.vip.d.b.a.b
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f19075a.b(((Integer) obj).intValue());
        }
    });
    public ReplyCommand l = new ReplyCommand(new Action0() { // from class: com.sandboxol.vip.d.b.a.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f19078a.i();
        }
    });

    public h(Context context, int i, boolean z, String str, o oVar) {
        this.f19081b = context;
        this.f19084e.set(Integer.valueOf(i));
        this.f19085f.set(Boolean.valueOf(z));
        this.g.set(str);
        this.f19082c = com.sandboxol.vip.c.a.a(i);
        this.f19083d = oVar;
        h();
        initMessenger();
        this.f19083d.m.post(new Runnable() { // from class: com.sandboxol.vip.d.b.a.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f19076a.j();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, g gVar2) {
        gVar.a(com.sandboxol.vip.a.f18955e, R.layout.vip_content_page_detail_type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.h.set(Integer.valueOf(this.f19080a[i]));
    }

    private void h() {
        List<PrivilegeInfo> list = this.f19082c;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = 0;
        while (i < this.f19082c.size()) {
            ObservableList<g> observableList = this.i;
            Context context = this.f19081b;
            PrivilegeInfo privilegeInfo = this.f19082c.get(i);
            i++;
            observableList.add(new g(context, privilegeInfo, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        new j(this.f19081b, this.f19085f.get().booleanValue(), this.f19084e.get().intValue(), false).show();
        ReportDataAdapter.onEvent(this.f19081b, EventConstant.CLICK_VIP, String.valueOf(this.f19084e.get()));
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, "token.refresh.vip.info", new Action0() { // from class: com.sandboxol.vip.d.b.a.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f19074a.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        List<PrivilegeInfo> list = this.f19082c;
        if (list != null && list.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.f19082c.size(); i2++) {
                TabLayout tabLayout = this.f19083d.m;
                tabLayout.addTab(tabLayout.newTab());
            }
            o oVar = this.f19083d;
            oVar.m.setupWithViewPager(oVar.n);
            for (int i3 = 0; i3 < this.f19083d.m.getTabCount(); i3++) {
                TabLayout.f tabAt = this.f19083d.m.getTabAt(i3);
                if (tabAt != null) {
                    tabAt.d(0);
                    tabAt.a(R.layout.vip_tab_item);
                    tabAt.b(this.f19082c.get(i3).getThumbnailRes());
                }
            }
            int i4 = 0;
            while (true) {
                if (i4 >= this.f19082c.size()) {
                    break;
                }
                String title = this.f19082c.get(i4).getTitle();
                if (!TextUtils.isEmpty(title) && title.equals(this.g.get())) {
                    i = i4;
                    break;
                }
                i4++;
            }
            TabLayout.f tabAt2 = this.f19083d.m.getTabAt(i);
            if (tabAt2 != null) {
                tabAt2.h();
            }
        }
        this.f19083d.m.setSelectedTabIndicatorColor(com.sandboxol.vip.c.b.c(this.f19084e.get().intValue()));
    }

    public /* synthetic */ void f() {
        this.f19085f.set(Boolean.valueOf(com.sandboxol.vip.c.a.d(this.f19084e.get().intValue())));
    }
}
