package com.disabngo.blockynexus.view.activity.tribesearch;

import android.app.Activity;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: TribeSearchViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f11137a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j f11141e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<String> f11138b = new ObservableField<>("");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f11139c = new ObservableField<>(true);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f11140d = new i();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f11142f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.tribesearch.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f11129a.f();
        }
    });
    public ReplyCommand<String> g = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.view.activity.tribesearch.d
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f11130a.a((String) obj);
        }
    });
    public ReplyCommand h = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.tribesearch.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f11131a.h();
        }
    });

    public k(Activity activity) {
        this.f11137a = activity;
        this.f11141e = new j(activity, R.string.tribe_not_search);
    }

    public /* synthetic */ void a(String str) {
        this.f11138b.set(str);
    }

    public /* synthetic */ void f() {
        Activity activity = this.f11137a;
        if (activity != null) {
            activity.finish();
        }
    }

    public /* synthetic */ void h() {
        this.f11141e.a(this.f11138b.get());
    }
}
