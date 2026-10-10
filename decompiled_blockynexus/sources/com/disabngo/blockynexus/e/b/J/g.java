package com.disabngo.blockynexus.e.b.J;

import android.content.Context;
import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.HelpDetailInfo;
import com.disabngo.blockynexus.view.dialog.Ba;
import com.google.gson.j;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import java.util.ArrayList;
import rx.functions.Action0;

/* JADX INFO: compiled from: HelpViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f9318b = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.J.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f9315a.h();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f9319c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.J.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9313a.f();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f9320d = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.J.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f9312a.k();
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f9321e = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.J.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f9314a.j();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f9322f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.J.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f9316a.i();
        }
    });

    public g(Context context) {
        this.f9317a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_account_bug_q1), this.f9317a.getString(R.string.help_account_bug_a1)));
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_account_bug_q2), this.f9317a.getString(R.string.help_account_bug_a2)));
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_account_bug_q3), this.f9317a.getString(R.string.help_account_bug_a3)));
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_account_bug_q4), this.f9317a.getString(R.string.help_account_bug_a4)));
        bundle.putString(StringConstant.HELP_DETAIL_INFO_DES, new j().a(arrayList));
        Context context = this.f9317a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.K.d.class, context.getString(R.string.help_account_bug), bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_game_bug_q1), this.f9317a.getString(R.string.help_game_bug_a1)));
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_game_bug_q2), this.f9317a.getString(R.string.help_game_bug_a2)));
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_game_bug_q3), this.f9317a.getString(R.string.help_game_bug_a3)));
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_game_bug_q4), this.f9317a.getString(R.string.help_game_bug_a4)));
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_game_bug_q5), this.f9317a.getString(R.string.help_game_bug_a5)));
        bundle.putString(StringConstant.HELP_DETAIL_INFO_DES, new j().a(arrayList));
        Context context = this.f9317a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.K.d.class, context.getString(R.string.help_game_bug), bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        new Ba(this.f9317a, false).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_tribe_bug_q1), this.f9317a.getString(R.string.help_tribe_bug_a1)));
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_tribe_bug_q2), this.f9317a.getString(R.string.help_tribe_bug_a2)));
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_tribe_bug_q3), this.f9317a.getString(R.string.help_tribe_bug_a3)));
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_tribe_bug_q4), this.f9317a.getString(R.string.help_tribe_bug_a4)));
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_tribe_bug_q5), this.f9317a.getString(R.string.help_tribe_bug_a5)));
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_tribe_bug_q6), this.f9317a.getString(R.string.help_tribe_bug_a6)));
        bundle.putString(StringConstant.HELP_DETAIL_INFO_DES, new j().a(arrayList));
        Context context = this.f9317a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.K.d.class, context.getString(R.string.help_tribe_bug), bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_vip_bug_q1), this.f9317a.getString(R.string.help_vip_bug_a1)));
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_vip_bug_q2), this.f9317a.getString(R.string.help_vip_bug_a2)));
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_vip_bug_q3), this.f9317a.getString(R.string.help_vip_bug_a3)));
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_vip_bug_q4), this.f9317a.getString(R.string.help_vip_bug_a4)));
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_vip_bug_q5), this.f9317a.getString(R.string.help_vip_bug_a5)));
        arrayList.add(new HelpDetailInfo(this.f9317a.getString(R.string.help_vip_bug_q6), this.f9317a.getString(R.string.help_vip_bug_a6)));
        bundle.putString(StringConstant.HELP_DETAIL_INFO_DES, new j().a(arrayList));
        Context context = this.f9317a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.K.d.class, context.getString(R.string.help_vip_bug), bundle);
    }
}
