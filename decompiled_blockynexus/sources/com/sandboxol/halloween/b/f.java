package com.sandboxol.halloween.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.TextViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.halloween.R;
import com.sandboxol.halloween.widget.CenterStrokeTextView;

/* JADX INFO: compiled from: HalloweenDialogRulerBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class f extends e {
    private static final ViewDataBinding.b h = null;
    private static final SparseIntArray i = new SparseIntArray();
    private final ConstraintLayout j;
    private final ImageView k;
    private long l;

    static {
        i.put(R.id.top_guidline, 3);
        i.put(R.id.rule_bg, 4);
        i.put(R.id.bowknot, 5);
        i.put(R.id.title, 6);
        i.put(R.id.bottom_guideline, 7);
    }

    public f(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, h, i));
    }

    @Override // com.sandboxol.halloween.b.e
    public void a(com.sandboxol.halloween.view.dialog.n nVar) {
        this.g = nVar;
        synchronized (this) {
            this.l |= 2;
        }
        notifyPropertyChanged(com.sandboxol.halloween.a.f18578b);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        synchronized (this) {
            j = this.l;
            this.l = 0L;
        }
        com.sandboxol.halloween.view.dialog.n nVar = this.g;
        long j2 = 7 & j;
        String str = null;
        if (j2 != 0) {
            replyCommand = ((j & 6) == 0 || nVar == null) ? null : nVar.f18701b;
            ObservableField<String> observableField = nVar != null ? nVar.f18700a : null;
            updateRegistration(0, observableField);
            if (observableField != null) {
                str = observableField.get();
            }
        } else {
            replyCommand = null;
        }
        if ((6 & j) != 0) {
            ViewBindingAdapters.clickCommand(this.k, replyCommand, false, 0);
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.f18600f, str);
        }
        if ((j & 4) != 0) {
            TextViewBindingAdapters.setMovementMethod(this.f18600f, true);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.l = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a((ObservableField) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, Object obj) {
        if (com.sandboxol.halloween.a.f18578b != i2) {
            return false;
        }
        a((com.sandboxol.halloween.view.dialog.n) obj);
        return true;
    }

    private f(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (View) objArr[7], (View) objArr[5], (View) objArr[4], (CenterStrokeTextView) objArr[6], (Guideline) objArr[3], (TextView) objArr[1]);
        this.l = -1L;
        this.j = (ConstraintLayout) objArr[0];
        this.j.setTag(null);
        this.k = (ImageView) objArr[2];
        this.k.setTag(null);
        this.f18600f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i2) {
        if (i2 != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }
}
