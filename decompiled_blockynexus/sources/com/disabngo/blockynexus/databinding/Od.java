package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.u.C0928a;
import com.disabngo.blockynexus.view.widget.XEditText;
import com.sandboxol.common.binding.adapter.EditTextBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: FragmentForgetPasswordBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Od extends Nd {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7737b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7738c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f7739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final EditText f7740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EditText f7741f;
    private final Button g;
    private final XEditText h;
    private final XEditText i;
    private final Button j;
    private long k;

    public Od(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f7737b, f7738c));
    }

    public void a(C0928a c0928a) {
        updateRegistration(1, c0928a);
        this.f7708a = c0928a;
        synchronized (this) {
            this.k |= 2;
        }
        notifyPropertyChanged(422);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        Boolean bool;
        ReplyCommand replyCommand;
        ReplyCommand<String> replyCommand2;
        ReplyCommand<String> replyCommand3;
        ReplyCommand<String> replyCommand4;
        ReplyCommand replyCommand5;
        ReplyCommand<String> replyCommand6;
        synchronized (this) {
            j = this.k;
            this.k = 0L;
        }
        C0928a c0928a = this.f7708a;
        long j2 = 7 & j;
        if (j2 != 0) {
            if ((j & 6) == 0 || c0928a == null) {
                replyCommand = null;
                replyCommand2 = null;
                replyCommand3 = null;
                replyCommand4 = null;
                replyCommand5 = null;
                replyCommand6 = null;
            } else {
                ReplyCommand<String> replyCommand7 = c0928a.f10202f;
                replyCommand4 = c0928a.f10200d;
                replyCommand5 = c0928a.f10199c;
                replyCommand6 = c0928a.f10201e;
                ReplyCommand replyCommand8 = c0928a.f10198b;
                replyCommand2 = c0928a.f10197a;
                replyCommand = replyCommand8;
                replyCommand3 = replyCommand7;
            }
            ObservableField<Boolean> observableField = c0928a != null ? c0928a.g : null;
            updateRegistration(0, observableField);
            bool = observableField != null ? observableField.get() : null;
        } else {
            bool = null;
            replyCommand = null;
            replyCommand2 = null;
            replyCommand3 = null;
            replyCommand4 = null;
            replyCommand5 = null;
            replyCommand6 = null;
        }
        if ((j & 6) != 0) {
            EditTextBindingAdapters.editTextCommand(this.f7740e, null, null, replyCommand2);
            EditTextBindingAdapters.editTextCommand(this.f7741f, null, null, replyCommand4);
            ViewBindingAdapters.clickCommand(this.g, replyCommand, false, 0);
            EditTextBindingAdapters.editTextCommand(this.h, null, null, replyCommand6);
            EditTextBindingAdapters.editTextCommand(this.i, null, null, replyCommand3);
            ViewBindingAdapters.clickCommand(this.j, replyCommand5, false, 0);
        }
        if (j2 != 0) {
            EditTextBindingAdapters.requestFocusCommand(this.f7741f, bool);
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
            this.k = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((C0928a) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (422 != i) {
            return false;
        }
        a((C0928a) obj);
        return true;
    }

    private Od(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2);
        this.k = -1L;
        this.f7739d = (LinearLayout) objArr[0];
        this.f7739d.setTag(null);
        this.f7740e = (EditText) objArr[1];
        this.f7740e.setTag(null);
        this.f7741f = (EditText) objArr[2];
        this.f7741f.setTag(null);
        this.g = (Button) objArr[3];
        this.g.setTag(null);
        this.h = (XEditText) objArr[4];
        this.h.setTag(null);
        this.i = (XEditText) objArr[5];
        this.i.setTag(null);
        this.j = (Button) objArr[6];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }

    private boolean a(C0928a c0928a, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }
}
