package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.EditTextBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.bf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentReportDetailBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0534bf extends AbstractC0522af {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f8196f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final ScrollView h;
    private final TextView i;
    private final Button j;
    private long k;

    static {
        g.put(R.id.textView2, 4);
        g.put(R.id.recyclerView, 5);
        g.put(R.id.textView3, 6);
    }

    public C0534bf(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f8196f, g));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0522af
    public void a(com.disabngo.blockynexus.e.b.aa.i iVar) {
        updateRegistration(1, iVar);
        this.f8171e = iVar;
        synchronized (this) {
            this.k |= 2;
        }
        notifyPropertyChanged(446);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        ReplyCommand<String> replyCommand;
        ReplyCommand replyCommand2;
        synchronized (this) {
            j = this.k;
            this.k = 0L;
        }
        com.disabngo.blockynexus.e.b.aa.i iVar = this.f8171e;
        long j2 = 7 & j;
        if (j2 != 0) {
            if ((j & 6) == 0 || iVar == null) {
                replyCommand = null;
                replyCommand2 = null;
            } else {
                replyCommand = iVar.f9647f;
                replyCommand2 = iVar.f9646e;
            }
            ObservableField<String> observableField = iVar != null ? iVar.f9645d : null;
            updateRegistration(0, observableField);
            str = observableField != null ? observableField.get() : null;
        } else {
            str = null;
            replyCommand = null;
            replyCommand2 = null;
        }
        if ((j & 6) != 0) {
            EditTextBindingAdapters.editTextCommand(this.f8167a, null, null, replyCommand);
            ViewBindingAdapters.clickCommand(this.j, replyCommand2, false, 0);
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.i, str);
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
            return a((ObservableField<String>) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.aa.i) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (446 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.aa.i) obj);
        return true;
    }

    private C0534bf(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (EditText) objArr[1], (RecyclerView) objArr[5], (TextView) objArr[4], (TextView) objArr[6]);
        this.k = -1L;
        this.f8167a.setTag(null);
        this.h = (ScrollView) objArr[0];
        this.h.setTag(null);
        this.i = (TextView) objArr[2];
        this.i.setTag(null);
        this.j = (Button) objArr[3];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.aa.i iVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }
}
