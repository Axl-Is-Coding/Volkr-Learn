package com.disabngo.blockynexus.view.fragment.tribeno;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeRecommendation;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.TribeBanner;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: TribeNoCreateItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends ListItemViewModel<TribeRecommendation> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableList<String> f12031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Integer> f12032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<String> f12033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f12034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand<Integer> f12035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f12036f;

    public h(Context context, TribeRecommendation tribeRecommendation) {
        super(context, tribeRecommendation);
        this.f12031a = new ObservableArrayList();
        this.f12032b = new ObservableField<>(0);
        this.f12033c = new ObservableField<>("");
        this.f12034d = new ArrayList();
        this.f12035e = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.view.fragment.tribeno.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f12024a.a((Integer) obj);
            }
        });
        this.f12036f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribeno.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f12025a.f();
            }
        });
        h();
    }

    private void h() {
        List<TribeBanner> tribeIntroduction = AppInfoCenter.newInstance().getAppConfig().getTribeIntroduction();
        if (tribeIntroduction != null) {
            for (TribeBanner tribeBanner : tribeIntroduction) {
                this.f12031a.add(tribeBanner.getImage());
                this.f12034d.add(tribeBanner.getTitle());
            }
        }
    }

    public /* synthetic */ void a(Integer num) {
        this.f12032b.set(num);
        if (this.f12034d.size() > num.intValue()) {
            this.f12033c.set(this.f12034d.get(num.intValue()));
        }
    }

    public /* synthetic */ void f() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("tribe.is.create", true);
        Context context = this.context;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.la.h.class, context.getString(R.string.tribe_create), bundle);
        ReportDataAdapter.onEvent(this.context, EventConstant.CLAN_BUILD_CLAN);
        ReportDataAdapter.onEvent(this.context, EventConstant.CLAN_BUILD_CLICK_OUTSIDE);
    }
}
