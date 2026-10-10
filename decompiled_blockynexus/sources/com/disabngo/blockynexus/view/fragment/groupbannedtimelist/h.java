package com.disabngo.blockynexus.view.fragment.groupbannedtimelist;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import rx.functions.Action0;

/* JADX INFO: compiled from: GroupBannedTimeViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f11731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f11732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11733d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f11735f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f11734e = new d();
    private ObservableField<String> g = new ObservableField<>();
    public ReplyCommand h = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.groupbannedtimelist.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f11720a.f();
        }
    });

    public h(Context context, long j, long j2, String str) {
        this.f11730a = context;
        this.f11731b = j;
        this.f11732c = j2;
        this.f11733d = str;
        this.g.set(context.getString(R.string.new_group_ban_10m));
        this.f11735f = new e(context, R.string.no_data, this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        new g().a(this.f11730a, this.f11731b, this.f11732c, this.f11733d, this.g.get());
    }
}
