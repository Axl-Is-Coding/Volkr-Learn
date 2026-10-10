package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.widget.MeItemView;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ue, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentHelpBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0742ue extends AbstractC0731te {
    private static final ViewDataBinding.b h = null;
    private static final SparseIntArray i = new SparseIntArray();
    private final ConstraintLayout j;
    private long k;

    static {
        i.put(R.id.textView17, 6);
    }

    public C0742ue(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, h, i));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0731te
    public void a(com.disabngo.blockynexus.e.b.J.g gVar) {
        updateRegistration(0, gVar);
        this.g = gVar;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(267);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        ReplyCommand replyCommand2;
        ReplyCommand replyCommand3;
        ReplyCommand replyCommand4;
        synchronized (this) {
            j = this.k;
            this.k = 0L;
        }
        com.disabngo.blockynexus.e.b.J.g gVar = this.g;
        long j2 = j & 3;
        ReplyCommand replyCommand5 = null;
        if (j2 == 0 || gVar == null) {
            replyCommand = null;
            replyCommand2 = null;
            replyCommand3 = null;
            replyCommand4 = null;
        } else {
            replyCommand5 = gVar.f9319c;
            replyCommand2 = gVar.f9320d;
            replyCommand3 = gVar.f9321e;
            replyCommand4 = gVar.f9322f;
            replyCommand = gVar.f9318b;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.f8832a, replyCommand, false, 0);
            ViewBindingAdapters.clickCommand(this.f8833b, replyCommand5, false, 0);
            ViewBindingAdapters.clickCommand(this.f8834c, replyCommand2, false, 0);
            ViewBindingAdapters.clickCommand(this.f8835d, replyCommand3, false, 0);
            ViewBindingAdapters.clickCommand(this.f8837f, replyCommand4, false, 0);
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
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.J.g) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, Object obj) {
        if (267 != i2) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.J.g) obj);
        return true;
    }

    private C0742ue(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (MeItemView) objArr[1], (MeItemView) objArr[2], (MeItemView) objArr[3], (MeItemView) objArr[4], (TextView) objArr[6], (TextView) objArr[5]);
        this.k = -1L;
        this.j = (ConstraintLayout) objArr[0];
        this.j.setTag(null);
        this.f8832a.setTag(null);
        this.f8833b.setTag(null);
        this.f8834c.setTag(null);
        this.f8835d.setTag(null);
        this.f8837f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.J.g gVar, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }
}
