package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.disabngo.blockynexus.view.widget.GroupNoticeEditText;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ne, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentGroupNameBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0666ne extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f8618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Button f8619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GroupNoticeEditText f8620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f8621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.disabngo.blockynexus.e.b.C.l f8622e;

    protected AbstractC0666ne(Object obj, View view, int i, Button button, Button button2, GroupNoticeEditText groupNoticeEditText, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f8618a = button;
        this.f8619b = button2;
        this.f8620c = groupNoticeEditText;
        this.f8621d = recyclerView;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.C.l lVar);
}
