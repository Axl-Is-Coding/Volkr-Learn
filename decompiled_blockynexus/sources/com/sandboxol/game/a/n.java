package com.sandboxol.game.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.StrokeTextView;
import com.sandboxol.game.R;

/* JADX INFO: compiled from: DialogRechargeTipBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class n extends m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f17699d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f17700e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RelativeLayout f17701f;
    private final ImageView g;
    private final Button h;
    private final Button i;
    private final TextView j;
    private long k;

    static {
        f17700e.put(R.id.tvTitle, 5);
        f17700e.put(R.id.llBtn, 6);
    }

    public n(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f17699d, f17700e));
    }

    public void a(b.h.c.a.a aVar) {
        this.f17698c = aVar;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(com.sandboxol.game.a.f17629d);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        String str;
        synchronized (this) {
            j = this.k;
            this.k = 0L;
        }
        b.h.c.a.a aVar = this.f17698c;
        long j2 = j & 3;
        ReplyCommand replyCommand2 = null;
        if (j2 == 0 || aVar == null) {
            replyCommand = null;
            str = null;
        } else {
            replyCommand2 = aVar.f2809c;
            str = aVar.f2807a;
            replyCommand = aVar.f2808b;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.g, replyCommand, false, 0);
            ViewBindingAdapters.clickCommand(this.h, replyCommand, false, 0);
            ViewBindingAdapters.clickCommand(this.i, replyCommand2, false, 0);
            androidx.databinding.a.e.a(this.j, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.game.a.f17629d != i) {
            return false;
        }
        a((b.h.c.a.a) obj);
        return true;
    }

    private n(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (LinearLayout) objArr[6], (StrokeTextView) objArr[5]);
        this.k = -1L;
        this.f17701f = (RelativeLayout) objArr[0];
        this.f17701f.setTag(null);
        this.g = (ImageView) objArr[1];
        this.g.setTag(null);
        this.h = (Button) objArr[2];
        this.h.setTag(null);
        this.i = (Button) objArr[3];
        this.i.setTag(null);
        this.j = (TextView) objArr[4];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
