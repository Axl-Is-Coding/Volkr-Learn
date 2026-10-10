package com.disabngo.blockynexus.e.b.oa;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.x.C0935C;
import com.disabngo.blockynexus.view.fragment.tribehas.L;
import com.sandboxol.common.base.viewmodel.ViewModel;

/* JADX INFO: compiled from: TribeMemberManageViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0935C f10028b = new C0935C();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public L f10029c;

    public b(Context context) {
        this.f10027a = context;
        this.f10029c = new L(context, R.string.tribe_member_exist, true);
    }
}
