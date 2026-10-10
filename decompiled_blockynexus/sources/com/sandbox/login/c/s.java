package com.sandbox.login.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandbox.login.R;
import com.sandboxol.common.binding.adapter.EditTextBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: LoginDialogRegisterBindingImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class s extends r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f15677e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f15678f = new SparseIntArray();
    private final LinearLayout g;
    private final TextView h;
    private final Button i;
    private final ImageView j;
    private long k;

    static {
        f15678f.put(R.id.tvTitle, 6);
    }

    public s(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f15677e, f15678f));
    }

    public void a(com.sandbox.login.view.dialog.e eVar) {
        this.f15676d = eVar;
        synchronized (this) {
            this.k |= 2;
        }
        notifyPropertyChanged(com.sandbox.login.g.f15906c);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        ReplyCommand<String> replyCommand;
        ReplyCommand replyCommand2;
        ReplyCommand<String> replyCommand3;
        ReplyCommand replyCommand4;
        ReplyCommand replyCommand5;
        synchronized (this) {
            j = this.k;
            this.k = 0L;
        }
        com.sandbox.login.view.dialog.e eVar = this.f15676d;
        long j2 = 7 & j;
        if (j2 != 0) {
            if ((j & 6) == 0 || eVar == null) {
                replyCommand = null;
                replyCommand2 = null;
                replyCommand3 = null;
                replyCommand4 = null;
                replyCommand5 = null;
            } else {
                ReplyCommand<String> replyCommand6 = eVar.f15984d;
                replyCommand3 = eVar.f15983c;
                replyCommand4 = eVar.f15981a;
                replyCommand5 = eVar.f15985e;
                replyCommand2 = eVar.f15982b;
                replyCommand = replyCommand6;
            }
            ObservableField<String> observableField = eVar != null ? eVar.f15986f : null;
            updateRegistration(0, observableField);
            str = observableField != null ? observableField.get() : null;
        } else {
            str = null;
            replyCommand = null;
            replyCommand2 = null;
            replyCommand3 = null;
            replyCommand4 = null;
            replyCommand5 = null;
        }
        if ((j & 6) != 0) {
            EditTextBindingAdapters.editTextCommand(this.f15673a, null, null, replyCommand);
            EditTextBindingAdapters.editTextCommand(this.f15674b, null, null, replyCommand3);
            ViewBindingAdapters.clickCommand(this.g, replyCommand5, false, 0);
            ViewBindingAdapters.clickCommand(this.i, replyCommand2, false, 0);
            ViewBindingAdapters.clickCommand(this.j, replyCommand4, false, 0);
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.h, str);
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
        if (i != 0) {
            return false;
        }
        return a((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandbox.login.g.f15906c != i) {
            return false;
        }
        a((com.sandbox.login.view.dialog.e) obj);
        return true;
    }

    private s(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (EditText) objArr[3], (EditText) objArr[2], (TextView) objArr[6]);
        this.k = -1L;
        this.f15673a.setTag(null);
        this.f15674b.setTag(null);
        this.g = (LinearLayout) objArr[0];
        this.g.setTag(null);
        this.h = (TextView) objArr[1];
        this.h.setTag(null);
        this.i = (Button) objArr[4];
        this.i.setTag(null);
        this.j = (ImageView) objArr[5];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }
}
