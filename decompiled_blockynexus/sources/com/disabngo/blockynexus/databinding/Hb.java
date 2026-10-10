package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: DialogHelpContactBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Hb extends Gb {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k = new SparseIntArray();
    private final ConstraintLayout l;
    private final TextView m;
    private final TextView n;
    private long o;

    static {
        k.put(R.id.textView20, 5);
        k.put(R.id.view20, 6);
        k.put(R.id.textView22, 7);
        k.put(R.id.view21, 8);
        k.put(R.id.textView23, 9);
        k.put(R.id.view19, 10);
    }

    public Hb(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 11, j, k));
    }

    @Override // com.disabngo.blockynexus.databinding.Gb
    public void a(com.disabngo.blockynexus.view.dialog.Ba ba) {
        this.i = ba;
        synchronized (this) {
            this.o |= 1;
        }
        notifyPropertyChanged(487);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j2;
        ReplyCommand replyCommand;
        ReplyCommand replyCommand2;
        int i;
        ReplyCommand replyCommand3;
        boolean z;
        synchronized (this) {
            j2 = this.o;
            this.o = 0L;
        }
        com.disabngo.blockynexus.view.dialog.Ba ba = this.i;
        long j3 = j2 & 3;
        ReplyCommand replyCommand4 = null;
        if (j3 != 0) {
            if (ba != null) {
                z = ba.f11262a;
                replyCommand2 = ba.f11264c;
                replyCommand3 = ba.f11263b;
                replyCommand = ba.f11265d;
            } else {
                replyCommand = null;
                replyCommand2 = null;
                replyCommand3 = null;
                z = false;
            }
            if (j3 != 0) {
                j2 |= z ? 8L : 4L;
            }
            i = z ? 0 : 8;
            replyCommand4 = replyCommand3;
        } else {
            replyCommand = null;
            replyCommand2 = null;
            i = 0;
        }
        if ((j2 & 3) != 0) {
            this.m.setVisibility(i);
            ViewBindingAdapters.clickCommand(this.n, replyCommand, false, 0);
            ViewBindingAdapters.clickCommand(this.f7485d, replyCommand4, false, 0);
            ViewBindingAdapters.clickCommand(this.f7486e, replyCommand2, false, 0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.o != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.o = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (487 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.Ba) obj);
        return true;
    }

    private Hb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (LinearLayout) objArr[5], (TextView) objArr[7], (TextView) objArr[9], (ConstraintLayout) objArr[2], (ConstraintLayout) objArr[3], (View) objArr[10], (View) objArr[6], (View) objArr[8]);
        this.o = -1L;
        this.l = (ConstraintLayout) objArr[0];
        this.l.setTag(null);
        this.m = (TextView) objArr[1];
        this.m.setTag(null);
        this.n = (TextView) objArr[4];
        this.n.setTag(null);
        this.f7485d.setTag(null);
        this.f7486e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
