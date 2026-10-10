package com.disabngo.blockynexus.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: ContentTribeTaskPageBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ia extends Ha {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f7540d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f7541e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f7542f;
    private final ImageView g;
    private final ImageView h;
    private final TextView i;
    private final DataRecyclerView j;
    private long k;

    public Ia(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f7540d, f7541e));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 8;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }

    private boolean d(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 4;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.e.b.ua.r rVar) {
        updateRegistration(4, rVar);
        this.f7511c = rVar;
        synchronized (this) {
            this.k |= 16;
        }
        notifyPropertyChanged(332);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String strValueOf;
        int i;
        Drawable drawableC;
        boolean zSafeUnbox;
        String strValueOf2;
        ReplyCommand replyCommand;
        String str;
        com.disabngo.blockynexus.e.b.ua.i iVar;
        com.disabngo.blockynexus.e.b.ua.p pVar;
        com.disabngo.blockynexus.e.b.ua.p pVar2;
        com.disabngo.blockynexus.e.b.ua.i iVar2;
        ObservableField<Boolean> observableField;
        ObservableField<String> observableField2;
        Context context;
        int i2;
        long j2;
        long j3;
        synchronized (this) {
            j = this.k;
            this.k = 0L;
        }
        com.disabngo.blockynexus.e.b.ua.r rVar = this.f7511c;
        if ((127 & j) != 0) {
            long j4 = j & 81;
            if (j4 != 0) {
                ObservableField<Integer> observableField3 = rVar != null ? rVar.f10236e : null;
                updateRegistration(0, observableField3);
                boolean z = ViewDataBinding.safeUnbox(observableField3 != null ? observableField3.get() : null) == 1;
                if (j4 != 0) {
                    if (z) {
                        j2 = j | 256;
                        j3 = 1024;
                    } else {
                        j2 = j | 128;
                        j3 = 512;
                    }
                    j = j2 | j3;
                }
                i = z ? 8 : 0;
                if (z) {
                    context = getRoot().getContext();
                    i2 = R.mipmap.ic_diamond_all;
                } else {
                    context = getRoot().getContext();
                    i2 = R.mipmap.ic_gold;
                }
                drawableC = androidx.core.content.b.c(context, i2);
            } else {
                i = 0;
                drawableC = null;
            }
            if ((j & 114) != 0) {
                if (rVar != null) {
                    observableField = rVar.h;
                    observableField2 = rVar.i;
                } else {
                    observableField = null;
                    observableField2 = null;
                }
                updateRegistration(1, observableField);
                updateRegistration(5, observableField2);
                Boolean bool = observableField != null ? observableField.get() : null;
                str = observableField2 != null ? observableField2.get() : null;
                zSafeUnbox = ViewDataBinding.safeUnbox(bool);
            } else {
                zSafeUnbox = false;
                str = null;
            }
            if ((j & 84) != 0) {
                ObservableField<Integer> observableField4 = rVar != null ? rVar.g : null;
                updateRegistration(2, observableField4);
                strValueOf2 = String.valueOf(ViewDataBinding.safeUnbox(observableField4 != null ? observableField4.get() : null));
            } else {
                strValueOf2 = null;
            }
            if ((j & 80) == 0 || rVar == null) {
                replyCommand = null;
                pVar2 = null;
                iVar2 = null;
            } else {
                replyCommand = rVar.j;
                iVar2 = rVar.f10235d;
                pVar2 = rVar.f10234c;
            }
            if ((j & 88) != 0) {
                ObservableField<Integer> observableField5 = rVar != null ? rVar.f10237f : null;
                updateRegistration(3, observableField5);
                strValueOf = String.valueOf(ViewDataBinding.safeUnbox(observableField5 != null ? observableField5.get() : null));
                pVar = pVar2;
                iVar = iVar2;
            } else {
                pVar = pVar2;
                iVar = iVar2;
                strValueOf = null;
            }
        } else {
            strValueOf = null;
            i = 0;
            drawableC = null;
            zSafeUnbox = false;
            strValueOf2 = null;
            replyCommand = null;
            str = null;
            iVar = null;
            pVar = null;
        }
        if ((j & 80) != 0) {
            ViewBindingAdapters.clickCommand(this.f7509a, replyCommand, false, 0);
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.j, iVar, pVar, null, false, null, false, 0, false);
        }
        if ((114 & j) != 0) {
            ImageViewBindingAdapters.imageAnim(this.g, zSafeUnbox, str);
        }
        if ((81 & j) != 0) {
            androidx.databinding.a.b.a(this.h, drawableC);
            this.f7510b.setVisibility(i);
        }
        if ((88 & j) != 0) {
            androidx.databinding.a.e.a(this.i, strValueOf);
        }
        if ((j & 84) != 0) {
            androidx.databinding.a.e.a(this.f7510b, strValueOf2);
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
            this.k = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return c((ObservableField) obj, i2);
        }
        if (i == 1) {
            return e((ObservableField) obj, i2);
        }
        if (i == 2) {
            return d((ObservableField) obj, i2);
        }
        if (i == 3) {
            return b((ObservableField) obj, i2);
        }
        if (i == 4) {
            return a((com.disabngo.blockynexus.e.b.ua.r) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return a((ObservableField<String>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (332 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ua.r) obj);
        return true;
    }

    private Ia(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 6, (LinearLayout) objArr[2], (TextView) objArr[1]);
        this.k = -1L;
        this.f7509a.setTag(null);
        this.f7542f = (LinearLayout) objArr[0];
        this.f7542f.setTag(null);
        this.g = (ImageView) objArr[3];
        this.g.setTag(null);
        this.h = (ImageView) objArr[4];
        this.h.setTag(null);
        this.i = (TextView) objArr[5];
        this.i.setTag(null);
        this.j = (DataRecyclerView) objArr[6];
        this.j.setTag(null);
        this.f7510b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.ua.r rVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 16;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 32;
        }
        return true;
    }
}
