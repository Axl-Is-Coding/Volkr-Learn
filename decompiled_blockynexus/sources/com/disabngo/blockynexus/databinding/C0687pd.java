package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.EditTextBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.pd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentCashApplyBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0687pd extends AbstractC0676od {
    private static final ViewDataBinding.b s = null;
    private static final SparseIntArray t = new SparseIntArray();
    private final NestedScrollView u;
    private long v;

    static {
        t.put(R.id.tv_title, 9);
        t.put(R.id.tv_detail, 10);
        t.put(R.id.tv_first_name, 11);
        t.put(R.id.tv_last_name, 12);
        t.put(R.id.tv_email, 13);
        t.put(R.id.tv_country, 14);
        t.put(R.id.tv_city, 15);
        t.put(R.id.tv_ic_bank_name, 16);
        t.put(R.id.tv_ic_card, 17);
    }

    public C0687pd(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 18, s, t));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0676od
    public void a(com.disabngo.blockynexus.e.b.j.k kVar) {
        updateRegistration(0, kVar);
        this.r = kVar;
        synchronized (this) {
            this.v |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        ReplyCommand<String> replyCommand2;
        ReplyCommand<String> replyCommand3;
        ReplyCommand<String> replyCommand4;
        ReplyCommand<String> replyCommand5;
        ReplyCommand<String> replyCommand6;
        ReplyCommand<String> replyCommand7;
        ReplyCommand<String> replyCommand8;
        synchronized (this) {
            j = this.v;
            this.v = 0L;
        }
        com.disabngo.blockynexus.e.b.j.k kVar = this.r;
        long j2 = j & 3;
        if (j2 == 0 || kVar == null) {
            replyCommand = null;
            replyCommand2 = null;
            replyCommand3 = null;
            replyCommand4 = null;
            replyCommand5 = null;
            replyCommand6 = null;
            replyCommand7 = null;
            replyCommand8 = null;
        } else {
            replyCommand2 = kVar.f9856f;
            replyCommand3 = kVar.k;
            replyCommand4 = kVar.g;
            replyCommand5 = kVar.h;
            replyCommand6 = kVar.i;
            replyCommand7 = kVar.j;
            replyCommand8 = kVar.f9855e;
            replyCommand = kVar.f9854d;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.f8655a, replyCommand, false, 0);
            EditTextBindingAdapters.editTextCommand(this.f8656b, null, null, replyCommand5);
            EditTextBindingAdapters.editTextCommand(this.f8657c, null, null, replyCommand6);
            EditTextBindingAdapters.editTextCommand(this.f8658d, null, null, replyCommand4);
            EditTextBindingAdapters.editTextCommand(this.f8659e, null, null, replyCommand8);
            EditTextBindingAdapters.editTextCommand(this.f8660f, null, null, replyCommand3);
            EditTextBindingAdapters.editTextCommand(this.g, null, null, replyCommand7);
            EditTextBindingAdapters.editTextCommand(this.h, null, null, replyCommand2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.v != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.v = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.j.k) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.j.k) obj);
        return true;
    }

    private C0687pd(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (Button) objArr[8], (EditText) objArr[5], (EditText) objArr[4], (EditText) objArr[3], (EditText) objArr[1], (EditText) objArr[6], (EditText) objArr[7], (EditText) objArr[2], (TextView) objArr[15], (TextView) objArr[14], (TextView) objArr[10], (TextView) objArr[13], (TextView) objArr[11], (TextView) objArr[16], (TextView) objArr[17], (TextView) objArr[12], (TextView) objArr[9]);
        this.v = -1L;
        this.f8655a.setTag(null);
        this.f8656b.setTag(null);
        this.f8657c.setTag(null);
        this.f8658d.setTag(null);
        this.f8659e.setTag(null);
        this.f8660f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.u = (NestedScrollView) objArr[0];
        this.u.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.j.k kVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.v |= 1;
        }
        return true;
    }
}
