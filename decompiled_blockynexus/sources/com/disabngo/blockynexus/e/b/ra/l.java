package com.disabngo.blockynexus.e.b.ra;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeRank;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: TribeRankPageViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends ListItemViewModel<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f10142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<String> f10143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<List<TribeRank>> f10144c;
    private Context context;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.disabngo.blockynexus.view.activity.tribesearch.i f10145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f10146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f10147f;
    public ReplyCommand g;
    public ReplyCommand h;

    public l(Context context, String str) {
        super(context, str);
        this.f10143b = new ObservableField<>();
        this.f10144c = new ObservableField<>(new ArrayList());
        this.f10145d = new com.disabngo.blockynexus.view.activity.tribesearch.i();
        this.f10146e = "";
        this.f10147f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ra.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f10129a.f();
            }
        });
        this.g = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ra.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f10130a.h();
            }
        });
        this.h = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ra.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f10131a.i();
            }
        });
        this.context = context;
        this.f10142a = new k(context, R.string.tribe_rank_not, str, this.f10144c, this.f10143b);
    }

    private void b(int i) {
        Bundle bundle = new Bundle();
        bundle.putLong("tribe.clan.id", i);
        Context context = this.context;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ma.e.class, context.getString(R.string.tribe_detail), bundle);
    }

    public /* synthetic */ void f() {
        if (this.f10144c.get().size() > 0) {
            b(this.f10144c.get().get(0).getClanId());
        }
    }

    public /* synthetic */ void h() {
        if (this.f10144c.get().size() > 1) {
            b(this.f10144c.get().get(1).getClanId());
        }
    }

    public /* synthetic */ void i() {
        if (this.f10144c.get().size() > 2) {
            b(this.f10144c.get().get(2).getClanId());
        }
    }
}
