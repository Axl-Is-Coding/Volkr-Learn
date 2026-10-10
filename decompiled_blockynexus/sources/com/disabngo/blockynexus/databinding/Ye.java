package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: FragmentReminderBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ye extends Xe {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8060c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8061d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinearLayout f8062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CheckBox f8063f;
    private final CheckBox g;
    private final CheckBox h;
    private final CheckBox i;
    private long j;

    public Ye(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f8060c, f8061d));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 8;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 2;
        }
        return true;
    }

    private boolean d(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 32;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 4;
        }
        return true;
    }

    private boolean f(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 16;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Xe
    public void a(com.disabngo.blockynexus.e.b.Y.l lVar) {
        updateRegistration(6, lVar);
        this.f8032b = lVar;
        synchronized (this) {
            this.j |= 64;
        }
        notifyPropertyChanged(490);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        ReplyCommand replyCommand2;
        ReplyCommand replyCommand3;
        ReplyCommand replyCommand4;
        ReplyCommand replyCommand5;
        boolean zSafeUnbox;
        boolean zSafeUnbox2;
        boolean zSafeUnbox3;
        boolean zSafeUnbox4;
        boolean zSafeUnbox5;
        boolean zSafeUnbox6;
        synchronized (this) {
            j = this.j;
            this.j = 0L;
        }
        com.disabngo.blockynexus.e.b.Y.l lVar = this.f8032b;
        if ((255 & j) != 0) {
            if ((j & 193) != 0) {
                ObservableField<Boolean> observableField = lVar != null ? lVar.f9602e : null;
                updateRegistration(0, observableField);
                zSafeUnbox3 = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            } else {
                zSafeUnbox3 = false;
            }
            if ((j & 192) == 0 || lVar == null) {
                replyCommand = null;
                replyCommand2 = null;
                replyCommand3 = null;
                replyCommand4 = null;
                replyCommand5 = null;
            } else {
                replyCommand = lVar.l;
                replyCommand3 = lVar.k;
                replyCommand4 = lVar.j;
                replyCommand5 = lVar.n;
                replyCommand2 = lVar.m;
            }
            if ((j & 194) != 0) {
                ObservableField<Boolean> observableField2 = lVar != null ? lVar.f9601d : null;
                updateRegistration(1, observableField2);
                zSafeUnbox4 = ViewDataBinding.safeUnbox(observableField2 != null ? observableField2.get() : null);
            } else {
                zSafeUnbox4 = false;
            }
            if ((j & 196) != 0) {
                ObservableField<Boolean> observableField3 = lVar != null ? lVar.i : null;
                updateRegistration(2, observableField3);
                zSafeUnbox6 = ViewDataBinding.safeUnbox(observableField3 != null ? observableField3.get() : null);
            } else {
                zSafeUnbox6 = false;
            }
            if ((j & 200) != 0) {
                ObservableField<Boolean> observableField4 = lVar != null ? lVar.h : null;
                updateRegistration(3, observableField4);
                zSafeUnbox5 = ViewDataBinding.safeUnbox(observableField4 != null ? observableField4.get() : null);
            } else {
                zSafeUnbox5 = false;
            }
            if ((j & 208) != 0) {
                ObservableField<Boolean> observableField5 = lVar != null ? lVar.f9603f : null;
                updateRegistration(4, observableField5);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(observableField5 != null ? observableField5.get() : null);
            } else {
                zSafeUnbox2 = false;
            }
            if ((j & 224) != 0) {
                ObservableField<Boolean> observableField6 = lVar != null ? lVar.g : null;
                updateRegistration(5, observableField6);
                zSafeUnbox = ViewDataBinding.safeUnbox(observableField6 != null ? observableField6.get() : null);
            } else {
                zSafeUnbox = false;
            }
        } else {
            replyCommand = null;
            replyCommand2 = null;
            replyCommand3 = null;
            replyCommand4 = null;
            replyCommand5 = null;
            zSafeUnbox = false;
            zSafeUnbox2 = false;
            zSafeUnbox3 = false;
            zSafeUnbox4 = false;
            zSafeUnbox5 = false;
            zSafeUnbox6 = false;
        }
        if ((j & 194) != 0) {
            androidx.databinding.a.a.a(this.f8031a, zSafeUnbox4);
        }
        if ((j & 193) != 0) {
            this.f8031a.setClickable(zSafeUnbox3);
        }
        if ((j & 192) != 0) {
            ViewBindingAdapters.clickCommand(this.f8031a, replyCommand4, true, 0);
            ViewBindingAdapters.clickCommand(this.f8063f, replyCommand3, true, 0);
            ViewBindingAdapters.clickCommand(this.g, replyCommand, true, 0);
            ViewBindingAdapters.clickCommand(this.h, replyCommand2, true, 0);
            ViewBindingAdapters.clickCommand(this.i, replyCommand5, true, 0);
        }
        if ((208 & j) != 0) {
            androidx.databinding.a.a.a(this.f8063f, zSafeUnbox2);
        }
        if ((224 & j) != 0) {
            androidx.databinding.a.a.a(this.g, zSafeUnbox);
        }
        if ((200 & j) != 0) {
            androidx.databinding.a.a.a(this.h, zSafeUnbox5);
        }
        if ((j & 196) != 0) {
            androidx.databinding.a.a.a(this.i, zSafeUnbox6);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.j = 128L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((ObservableField<Boolean>) obj, i2);
            case 1:
                return c((ObservableField) obj, i2);
            case 2:
                return e((ObservableField) obj, i2);
            case 3:
                return b((ObservableField) obj, i2);
            case 4:
                return f((ObservableField) obj, i2);
            case 5:
                return d((ObservableField) obj, i2);
            case 6:
                return a((com.disabngo.blockynexus.e.b.Y.l) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (490 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.Y.l) obj);
        return true;
    }

    private Ye(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 7, (CheckBox) objArr[1]);
        this.j = -1L;
        this.f8031a.setTag(null);
        this.f8062e = (LinearLayout) objArr[0];
        this.f8062e.setTag(null);
        this.f8063f = (CheckBox) objArr[2];
        this.f8063f.setTag(null);
        this.g = (CheckBox) objArr[3];
        this.g.setTag(null);
        this.h = (CheckBox) objArr[4];
        this.h.setTag(null);
        this.i = (CheckBox) objArr[5];
        this.i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.Y.l lVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 64;
        }
        return true;
    }
}
