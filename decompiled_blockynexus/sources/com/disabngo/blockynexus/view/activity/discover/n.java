package com.disabngo.blockynexus.view.activity.discover;

import android.app.Activity;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0563e;
import com.disabngo.blockynexus.view.widget.gameRank.GameTypeRankingPupupWindow;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import rx.functions.Action0;

/* JADX INFO: compiled from: DiscoverViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class n extends ViewModel {
    private Activity g;
    public m h;
    private com.disabngo.blockynexus.e.b.X.d j;
    private AbstractC0563e n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10596a = StringConstant.GAME_ORDER_TYPE_COMPLEX;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f10597b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f10598c = new ObservableField<>(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f10599d = new ObservableField<>(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<String> f10600e = new ObservableField<>("");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ObservableList<String> f10601f = new ObservableArrayList();
    public f i = new f();
    public ReplyCommand k = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.discover.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f10567a.f();
        }
    });
    public ReplyCommand l = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.discover.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f10565a.j();
        }
    });
    public ReplyCommand m = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.discover.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f10568a.k();
        }
    });

    public n(Activity activity, AbstractC0563e abstractC0563e) {
        this.g = activity;
        this.n = abstractC0563e;
        this.h = new m(activity, R.string.category_no_data, this.f10596a, this.f10597b);
        initData();
    }

    private void initData() {
        if (this.j == null) {
            this.j = new com.disabngo.blockynexus.e.b.X.d();
        }
        l();
        com.disabngo.blockynexus.view.widget.gameRank.a.d.a(this.g, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        new GameTypeRankingPupupWindow(this, this.g, this.f10596a, new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.discover.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f10564a.h();
            }
        })).showLocation(this.n.f8283a);
        this.f10598c.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        new GameTypeRankingPupupWindow(this, this.g, this.f10597b, new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.discover.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f10566a.i();
            }
        })).showLocation(this.n.f8283a);
        this.f10599d.set(true);
    }

    private void l() {
        if (this.f10596a.equals(StringConstant.GAME_ORDER_TYPE_ONLINE)) {
            this.f10600e.set(this.g.getString(R.string.dicover_rang_item1));
            ReportDataAdapter.onEvent(this.g, EventConstant.EXPLORE_MOST_CLICK);
        } else if (this.f10596a.equals("new")) {
            this.f10600e.set(this.g.getString(R.string.dicover_rang_item2));
            ReportDataAdapter.onEvent(this.g, EventConstant.EXPLORE_NEWEST_CLICK);
        } else if (this.f10596a.equals(StringConstant.GAME_ORDER_TYPE_APPRECIATE)) {
            this.f10600e.set(this.g.getString(R.string.dicover_rang_item3));
            ReportDataAdapter.onEvent(this.g, EventConstant.EXPLORE_LIKE_CLICK);
        } else {
            this.f10600e.set(this.g.getString(R.string.dicover_rang_item0));
            ReportDataAdapter.onEvent(this.g, EventConstant.EXPLORE_COMPRE_CLICK);
        }
    }

    public void a(String str) {
        this.f10596a = str;
        l();
        this.h.a(this.f10596a, this.f10597b);
    }

    public /* synthetic */ void f() {
        this.g.finish();
    }

    public /* synthetic */ void h() {
        this.f10598c.set(false);
    }

    public /* synthetic */ void i() {
        this.f10599d.set(false);
    }

    public void a(long j) {
        this.f10597b = j;
        this.h.a(this.f10596a, j);
    }
}
