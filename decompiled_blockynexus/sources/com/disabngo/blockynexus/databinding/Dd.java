package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.widget.NestRadioGroup;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;

/* JADX INFO: compiled from: FragmentCreatePartyBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Dd extends Cd {
    private static final ViewDataBinding.b r = null;
    private static final SparseIntArray s = new SparseIntArray();
    private final RelativeLayout t;
    private final ImageView u;
    private final Button v;
    private long w;

    static {
        s.put(R.id.rl_edit_text, 7);
        s.put(R.id.input_name, 8);
        s.put(R.id.v_line1, 9);
        s.put(R.id.tv_choose_game, 10);
        s.put(R.id.v_line2, 11);
        s.put(R.id.tv_choose_mode, 12);
        s.put(R.id.rb_public_game, 13);
        s.put(R.id.tv_public_game, 14);
        s.put(R.id.iv_public_game, 15);
        s.put(R.id.rb_private_game, 16);
        s.put(R.id.tv_private_game, 17);
        s.put(R.id.iv_private_game, 18);
    }

    public Dd(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 19, r, s));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.w |= 2;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.w |= 4;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Cd
    public void a(com.disabngo.blockynexus.e.b.S.v vVar) {
        updateRegistration(3, vVar);
        this.q = vVar;
        synchronized (this) {
            this.w |= 8;
        }
        notifyPropertyChanged(280);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a6  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Dd.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.w != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.w = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableField<Integer>) obj, i2);
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
        return a((com.disabngo.blockynexus.e.b.S.v) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (280 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.S.v) obj);
        return true;
    }

    private Dd(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (PageRecyclerView) objArr[3], (TextInputEditText) objArr[1], (TextInputLayout) objArr[8], (ImageView) objArr[18], (ImageView) objArr[15], (LinearLayout) objArr[4], (AppCompatRadioButton) objArr[16], (AppCompatRadioButton) objArr[13], (NestRadioGroup) objArr[5], (RelativeLayout) objArr[7], (TextView) objArr[10], (TextView) objArr[12], (TextView) objArr[17], (TextView) objArr[14], (View) objArr[9], (View) objArr[11]);
        this.w = -1L;
        this.f7343a.setTag(null);
        this.f7344b.setTag(null);
        this.f7348f.setTag(null);
        this.t = (RelativeLayout) objArr[0];
        this.t.setTag(null);
        this.u = (ImageView) objArr[2];
        this.u.setTag(null);
        this.v = (Button) objArr[6];
        this.v.setTag(null);
        this.i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.w |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.S.v vVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.w |= 8;
        }
        return true;
    }
}
