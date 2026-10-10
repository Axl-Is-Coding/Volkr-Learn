package com.disabngo.blockynexus.e.b.m;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.User;
import rx.functions.Action1;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.m.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChangeDetailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0873e extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9931a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand<String> f9933c = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.m.a
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9928a.a((String) obj);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private User f9932b = new User();

    public C0873e(Context context) {
        this.f9931a = context;
    }

    public void f() {
        new C0871c(this.f9932b).loadData(this.f9931a, new C0872d(this));
    }

    public /* synthetic */ void a(String str) {
        this.f9932b.setDetails(str);
    }
}
