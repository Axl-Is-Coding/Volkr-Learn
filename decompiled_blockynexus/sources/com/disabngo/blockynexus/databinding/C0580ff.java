package com.disabngo.blockynexus.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.widget.ItemView;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ff, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentSafeSettingBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0580ff extends AbstractC0569ef {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8333b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8334c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f8335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ItemView f8336e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ItemView f8337f;
    private long g;

    public C0580ff(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f8333b, f8334c));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 8;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0569ef
    public void a(com.disabngo.blockynexus.e.b.ca.g gVar) {
        updateRegistration(2, gVar);
        this.f8303a = gVar;
        synchronized (this) {
            this.g |= 4;
        }
        notifyPropertyChanged(336);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        boolean zEquals;
        boolean zEquals2;
        ReplyCommand replyCommand;
        ReplyCommand replyCommand2;
        String string;
        int i;
        int i2;
        boolean z;
        String string2;
        int i3;
        String str2;
        String str3;
        long j2;
        long j3;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        com.disabngo.blockynexus.e.b.ca.g gVar = this.f8303a;
        long j4 = j & 18;
        if (j4 != 0) {
            ObservableField<String> observableField = AccountCenter.newInstance().email;
            updateRegistration(1, observableField);
            str = observableField != null ? observableField.get() : null;
            if (str != null) {
                zEquals = str.equals("");
                zEquals2 = str.equals("");
            } else {
                zEquals = false;
                zEquals2 = false;
            }
            if (j4 != 0) {
                j |= zEquals ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            if ((j & 18) != 0) {
                j |= zEquals2 ? 65536L : PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
        } else {
            str = null;
            zEquals = false;
            zEquals2 = false;
        }
        if ((j & 20) == 0 || gVar == null) {
            replyCommand = null;
            replyCommand2 = null;
        } else {
            replyCommand2 = gVar.f9693f;
            replyCommand = gVar.g;
        }
        long j5 = j & 24;
        int i4 = R.color.floatBgColor;
        if (j5 != 0) {
            ObservableField<Boolean> observableField2 = AccountCenter.newInstance().isFinishSecretQuestion;
            updateRegistration(3, observableField2);
            boolean zSafeUnbox = ViewDataBinding.safeUnbox(observableField2 != null ? observableField2.get() : null);
            if (j5 != 0) {
                if (zSafeUnbox) {
                    j2 = j | 64;
                    j3 = PlaybackStateCompat.ACTION_PREPARE;
                } else {
                    j2 = j | 32;
                    j3 = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                }
                j = j2 | j3;
            }
            string = zSafeUnbox ? this.f8337f.getResources().getString(R.string.question_finish) : this.f8337f.getResources().getString(R.string.question_unfinished);
            i = zSafeUnbox ? R.color.floatBgColor : R.color.itemRechargePriceColor;
        } else {
            string = null;
            i = 0;
        }
        boolean z2 = (j & 34816) != 0 && str == null;
        long j6 = j & 18;
        if (j6 != 0) {
            z = zEquals ? true : z2;
            if (zEquals2) {
                z2 = true;
            }
            if (j6 != 0) {
                j = z ? j | 1024 : j | 512;
            }
            if ((j & 18) != 0) {
                j |= z2 ? 256L : 128L;
            }
            if (z2) {
                i4 = R.color.itemRechargePriceColor;
            }
            i2 = i4;
        } else {
            i2 = 0;
            z = false;
        }
        if ((j & 512) != 0) {
            String[] strArrSplit = str != null ? str.split("@") : null;
            if (strArrSplit != null) {
                str3 = (String) ViewDataBinding.getFromArray(strArrSplit, 1);
                i3 = 0;
                str2 = (String) ViewDataBinding.getFromArray(strArrSplit, 0);
            } else {
                i3 = 0;
                str2 = null;
                str3 = null;
            }
            Object[] objArr = new Object[2];
            objArr[i3] = str2 != null ? str2.substring(i3, 4) : null;
            objArr[1] = str3;
            string2 = String.format("%s*****@%s", objArr);
        } else {
            string2 = null;
        }
        long j7 = 18 & j;
        if (j7 == 0) {
            string2 = null;
        } else if (z) {
            string2 = this.f8336e.getResources().getString(R.string.question_unfinished);
        }
        if (j7 != 0) {
            com.disabngo.blockynexus.binding.adapter.j.a(this.f8336e, string2);
            com.disabngo.blockynexus.binding.adapter.j.a(this.f8336e, i2);
        }
        if ((20 & j) != 0) {
            ViewBindingAdapters.clickCommand(this.f8336e, replyCommand, false, 0);
            ViewBindingAdapters.clickCommand(this.f8337f, replyCommand2, false, 0);
        }
        if ((j & 24) != 0) {
            com.disabngo.blockynexus.binding.adapter.j.a(this.f8337f, string);
            com.disabngo.blockynexus.binding.adapter.j.a(this.f8337f, i);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.g = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((AccountCenter) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<String>) obj, i2);
        }
        if (i == 2) {
            return a((com.disabngo.blockynexus.e.b.ca.g) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (336 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ca.g) obj);
        return true;
    }

    private C0580ff(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4);
        this.g = -1L;
        this.f8335d = (LinearLayout) objArr[0];
        this.f8335d.setTag(null);
        this.f8336e = (ItemView) objArr[1];
        this.f8336e.setTag(null);
        this.f8337f = (ItemView) objArr[2];
        this.f8337f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.ca.g gVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 4;
        }
        return true;
    }
}
