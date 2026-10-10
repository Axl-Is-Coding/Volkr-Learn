package com.disabngo.blockynexus.view.dialog.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.D;
import com.disabngo.blockynexus.databinding.AbstractC0729tc;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.ScrapInfo;
import com.sandboxol.center.router.manager.VipManager;
import com.sandboxol.center.utils.ScrapOutlineViewReturnHelper;
import com.sandboxol.center.web.ScrapApi;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import rx.functions.Action0;

/* JADX INFO: compiled from: ScrapRequestDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScrapInfo f11569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AbstractC0729tc f11573e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h f11574f;
    public j g;
    public ObservableField<String> h;
    public ObservableField<Long> i;
    public ObservableField<Integer> j;
    public ObservableField<String> k;
    public ObservableField<String> l;
    public ReplyCommand m;
    public ReplyCommand n;
    public ReplyCommand o;

    public e(Context context, int i, int i2, ScrapInfo scrapInfo, String str, String str2) {
        super(context);
        this.f11574f = new h();
        this.h = new ObservableField<>();
        this.i = new ObservableField<>(0L);
        this.j = new ObservableField<>(0);
        this.k = new ObservableField<>();
        this.l = new ObservableField<>();
        this.m = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.g.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f11565a.a();
            }
        });
        this.n = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.g.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f11567a.b();
            }
        });
        this.o = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.g.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f11566a.c();
            }
        });
        this.f11569a = scrapInfo;
        this.f11570b = i;
        this.f11571c = i2;
        this.f11572d = str2;
        this.g = new j(context, str, this.i, this.j, this.l, this.h, R.string.no_data);
        initView();
        this.k.set(context.getString(R.string.app_scrap_text_tips_2, a(i), b(i)));
        this.f11573e.g.setResId(ScrapOutlineViewReturnHelper.getScrapBoxResId(i2));
        ReportDataAdapter.onEvent(context, EventConstant.ENTER_PART_PAGE);
    }

    private String a(int i) {
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? "Ⅰ" : "Ⅴ" : "Ⅳ" : "Ⅲ" : "Ⅱ";
    }

    public void initView() {
        this.f11573e = (AbstractC0729tc) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.dialog_scrap_request, (ViewGroup) null, false);
        this.f11573e.a(this);
        setContentView(this.f11573e.getRoot());
        AbstractC0729tc abstractC0729tc = this.f11573e;
        setInnerViews(abstractC0729tc.f8822b, abstractC0729tc.f8826f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Context context = this.context;
        if (context != null) {
            ReportDataAdapter.onEvent(context, EventConstant.CLICK_PART_PLAYGAME);
            D.d(this.context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f11569a == null) {
            return;
        }
        if (this.j.get().intValue() == 3) {
            VipManager.enterVipFragment(this.context);
            return;
        }
        if (this.j.get().intValue() == 1 || this.j.get().intValue() == 2) {
            D.e(this.context);
        } else if (this.i.get().longValue() != 0) {
            ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_PART_HELP);
            ScrapApi.askScrap(this.context, this.i.get().longValue(), this.f11569a.getScrapId(), new d(this));
        }
    }

    public /* synthetic */ void a() {
        dismiss();
    }

    private String b(int i) {
        if (i == 2) {
            return this.context.getString(R.string.app_scrap_week_day_2);
        }
        if (i == 3) {
            return this.context.getString(R.string.app_scrap_week_day_3);
        }
        if (i == 4) {
            return this.context.getString(R.string.app_scrap_week_day_4);
        }
        if (i != 5) {
            return this.context.getString(R.string.app_scrap_week_day_1);
        }
        return this.context.getString(R.string.app_scrap_week_day_5);
    }
}
