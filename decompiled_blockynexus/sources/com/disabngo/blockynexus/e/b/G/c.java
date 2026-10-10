package com.disabngo.blockynexus.e.b.G;

import android.app.Activity;
import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import java.util.ArrayList;
import me.iwf.photopicker.f;
import rx.functions.Action0;

/* JADX INFO: compiled from: GroupNoticeItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends ListItemViewModel<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<String> f9285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<String> f9286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f9287c;

    public c(Context context, String str, ArrayList<String> arrayList) {
        super(context, str);
        this.f9286b = new ObservableField<>();
        this.f9287c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.G.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f9284a.f();
            }
        });
        if (str != null) {
            this.f9286b.set(str);
        }
        this.f9285a = arrayList;
    }

    public /* synthetic */ void f() {
        f.a aVarA = me.iwf.photopicker.f.a();
        aVarA.a(this.f9285a);
        aVarA.a(this.f9285a.indexOf(this.f9286b.get()));
        aVarA.a(false);
        aVarA.a((Activity) this.context);
    }
}
