package com.disabngo.blockynexus.databinding;

import android.content.res.Resources;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.q.C0907h;
import com.sandboxol.common.binding.adapter.CheckBoxBindingAdapters;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: FragmentDiskGameManageBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Fd extends Ed {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f7445e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f7446f = null;
    private final ConstraintLayout g;
    private final TextView h;
    private final DataRecyclerView i;
    private final ImageView j;
    private final TextView k;
    private long l;

    public Fd(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, f7445e, f7446f));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 4;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Ed
    public void a(com.disabngo.blockynexus.e.b.q.n nVar) {
        updateRegistration(0, nVar);
        this.f7427d = nVar;
        synchronized (this) {
            this.l |= 1;
        }
        notifyPropertyChanged(286);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        ReplyCommand replyCommand;
        int i3;
        ReplyCommand<Boolean> replyCommand2;
        boolean zSafeUnbox;
        String string;
        int i4;
        C0907h c0907h;
        com.disabngo.blockynexus.e.b.q.k kVar;
        ReplyCommand replyCommand3;
        C0907h c0907h2;
        com.disabngo.blockynexus.e.b.q.k kVar2;
        int i5;
        int i6;
        Resources resources;
        int i7;
        long j2;
        long j3;
        synchronized (this) {
            j = this.l;
            this.l = 0L;
        }
        com.disabngo.blockynexus.e.b.q.n nVar = this.f7427d;
        if ((31 & j) != 0) {
            if ((j & 17) == 0 || nVar == null) {
                replyCommand3 = null;
                c0907h2 = null;
                kVar2 = null;
                replyCommand2 = null;
            } else {
                ReplyCommand<Boolean> replyCommand4 = nVar.i;
                c0907h2 = nVar.l;
                ReplyCommand replyCommand5 = nVar.h;
                kVar2 = nVar.m;
                replyCommand2 = replyCommand4;
                replyCommand3 = replyCommand5;
            }
            long j4 = j & 19;
            if (j4 != 0) {
                ObservableField<Boolean> observableField = nVar != null ? nVar.n : null;
                i4 = 1;
                updateRegistration(1, observableField);
                boolean zSafeUnbox2 = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
                if (j4 != 0) {
                    if (zSafeUnbox2) {
                        j2 = j | 256 | 1024;
                        j3 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    } else {
                        j2 = j | 128 | 512;
                        j3 = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    }
                    j = j2 | j3;
                }
                i5 = zSafeUnbox2 ? 8 : 0;
                i6 = zSafeUnbox2 ? 0 : 8;
                if (zSafeUnbox2) {
                    i4 = R.anim.app_clean_cache_loading_rotate_anim;
                }
            } else {
                i4 = 0;
                i5 = 0;
                i6 = 0;
            }
            long j5 = j & 21;
            if (j5 != 0) {
                ObservableField<Boolean> observableField2 = nVar != null ? nVar.k : null;
                updateRegistration(2, observableField2);
                zSafeUnbox = ViewDataBinding.safeUnbox(observableField2 != null ? observableField2.get() : null);
                if (j5 != 0) {
                    j |= zSafeUnbox ? 64L : 32L;
                }
                if (zSafeUnbox) {
                    resources = this.f7424a.getResources();
                    i7 = R.string.app_disk_game_manage_all_unselect;
                } else {
                    resources = this.f7424a.getResources();
                    i7 = R.string.app_disk_game_manage_all_select;
                }
                string = resources.getString(i7);
            } else {
                zSafeUnbox = false;
                string = null;
            }
            long j6 = j & 25;
            if (j6 != 0) {
                ObservableField<Boolean> observableField3 = nVar != null ? nVar.o : null;
                updateRegistration(3, observableField3);
                boolean zSafeUnbox3 = ViewDataBinding.safeUnbox(observableField3 != null ? observableField3.get() : null);
                if (j6 != 0) {
                    j |= zSafeUnbox3 ? PlaybackStateCompat.ACTION_PREPARE : PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                }
                int i8 = zSafeUnbox3 ? 8 : 0;
                c0907h = c0907h2;
                kVar = kVar2;
                i = i5;
                i3 = i8;
            } else {
                c0907h = c0907h2;
                kVar = kVar2;
                i = i5;
                i3 = 0;
            }
            replyCommand = replyCommand3;
            i2 = i6;
        } else {
            i = 0;
            i2 = 0;
            replyCommand = null;
            i3 = 0;
            replyCommand2 = null;
            zSafeUnbox = false;
            string = null;
            i4 = 0;
            c0907h = null;
            kVar = null;
        }
        if ((21 & j) != 0) {
            androidx.databinding.a.a.a(this.f7424a, zSafeUnbox);
            androidx.databinding.a.e.a(this.f7424a, string);
        }
        if ((19 & j) != 0) {
            this.f7424a.setVisibility(i);
            this.f7425b.setVisibility(i2);
            ImageViewBindingAdapters.isStartAnimByXml(this.f7425b, i4);
            this.i.setVisibility(i);
            this.j.setVisibility(i);
            this.k.setVisibility(i2);
            this.f7426c.setVisibility(i);
        }
        if ((17 & j) != 0) {
            CheckBoxBindingAdapters.onCheckedChangeListener(this.f7424a, replyCommand2, false);
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.i, c0907h, kVar, null, true, null, false, 0, false);
            ViewBindingAdapters.clickCommand(this.j, replyCommand, false, 0);
        }
        if ((j & 25) != 0) {
            this.h.setVisibility(i3);
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
            this.l = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.e.b.q.n) obj, i2);
        }
        if (i == 1) {
            return b((ObservableField) obj, i2);
        }
        if (i == 2) {
            return c((ObservableField) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return a((ObservableField<Boolean>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (286 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.q.n) obj);
        return true;
    }

    private Fd(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (CheckBox) objArr[4], (ImageView) objArr[6], (View) objArr[3]);
        this.l = -1L;
        this.f7424a.setTag(null);
        this.f7425b.setTag(null);
        this.g = (ConstraintLayout) objArr[0];
        this.g.setTag(null);
        this.h = (TextView) objArr[1];
        this.h.setTag(null);
        this.i = (DataRecyclerView) objArr[2];
        this.i.setTag(null);
        this.j = (ImageView) objArr[5];
        this.j.setTag(null);
        this.k = (TextView) objArr[7];
        this.k.setTag(null);
        this.f7426c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.q.n nVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 8;
        }
        return true;
    }
}
