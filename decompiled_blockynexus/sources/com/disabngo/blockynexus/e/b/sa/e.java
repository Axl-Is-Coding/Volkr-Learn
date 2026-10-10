package com.disabngo.blockynexus.e.b.sa;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import rx.functions.Action1;

/* JADX INFO: compiled from: TribeSettingViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Boolean> f10173b = new ObservableField<>(true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand<Boolean> f10174c = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.sa.a
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f10168a.a((Boolean) obj);
        }
    });

    public e(Context context) {
        this.f10172a = context;
    }

    public /* synthetic */ void a(Boolean bool) {
        d dVar = new d();
        Context context = this.f10172a;
        boolean zBooleanValue = bool.booleanValue();
        dVar.a(context, zBooleanValue ? 1 : 0, this.f10173b);
    }
}
