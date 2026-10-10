package com.sandboxol.gamedetail.a;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.gamedetail.R;
import com.sandboxol.gamedetail.c.a.a.ba;
import com.sandboxol.gamedetail.view.widget.CenterRadioButton;
import com.sandboxol.gamedetail.view.widget.GameDetailRelativeLayout;
import com.sandboxol.gamedetail.view.widget.MaxLayout;
import com.sandboxol.greendao.entity.BannerEntity;
import com.sandboxol.greendao.entity.Game;
import com.youth.banner.Banner;

/* JADX INFO: compiled from: FragmentGameDetailBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class p extends o {
    private static final ViewDataBinding.b k = new ViewDataBinding.b(27);
    private static final SparseIntArray l;
    private final CheckBox A;
    private final TextView B;
    private final RadioGroup C;
    private final View D;
    private long E;
    private final Banner m;
    private final MaxLayout n;
    private final TextView o;
    private final ImageView p;
    private final TextView q;
    private final MaxLayout r;
    private final ProgressBar s;
    private final TextView t;
    private final RelativeLayout u;
    private final Button v;
    private final TextView w;
    private final ImageView x;
    private final TextView y;
    private final LinearLayout z;

    static {
        k.a(10, new String[]{"content_game_hall"}, new int[]{23}, new int[]{R.layout.content_game_hall});
        l = new SparseIntArray();
        l.put(R.id.tab_introduction, 24);
        l.put(R.id.flGameDetail, 25);
        l.put(R.id.iv_flashes, 26);
    }

    public p(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 27, k, l));
    }

    private boolean b(ObservableList<String> observableList, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.E |= PlaybackStateCompat.ACTION_PREPARE;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.E |= 2;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.E |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean e(ObservableField<Game> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.E |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean f(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.E |= 65536;
        }
        return true;
    }

    private boolean g(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.E |= 16;
        }
        return true;
    }

    private boolean h(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.E |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean i(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.E |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        }
        return true;
    }

    private boolean j(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.E |= 4;
        }
        return true;
    }

    private boolean k(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.E |= 1;
        }
        return true;
    }

    private boolean l(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.E |= 256;
        }
        return true;
    }

    private boolean m(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.E |= 64;
        }
        return true;
    }

    private boolean n(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.E |= 32;
        }
        return true;
    }

    private boolean o(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.E |= 512;
        }
        return true;
    }

    @Override // com.sandboxol.gamedetail.a.o
    public void a(ba baVar) {
        updateRegistration(3, baVar);
        this.j = baVar;
        synchronized (this) {
            this.E |= 8;
        }
        notifyPropertyChanged(com.sandboxol.gamedetail.a.h);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a9 A[PHI: r2
      0x00a9: PHI (r2v44 long) = (r2v0 long), (r2v81 long) binds: [B:31:0x0076, B:45:0x00a3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0158  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 1646
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.gamedetail.a.p.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.E != 0) {
                return true;
            }
            return this.f17861e.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.E = 1048576L;
        }
        this.f17861e.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return k((ObservableField) obj, i2);
            case 1:
                return c((ObservableField<Integer>) obj, i2);
            case 2:
                return j((ObservableField) obj, i2);
            case 3:
                return a((ba) obj, i2);
            case 4:
                return g((ObservableField) obj, i2);
            case 5:
                return n((ObservableField) obj, i2);
            case 6:
                return m((ObservableField) obj, i2);
            case 7:
                return a((ObservableList<BannerEntity>) obj, i2);
            case 8:
                return l((ObservableField) obj, i2);
            case 9:
                return o((ObservableField) obj, i2);
            case 10:
                return c((ObservableList<String>) obj, i2);
            case 11:
                return d((ObservableField) obj, i2);
            case 12:
                return e((ObservableField) obj, i2);
            case 13:
                return a((ObservableField<Drawable>) obj, i2);
            case 14:
                return b((ObservableList<String>) obj, i2);
            case 15:
                return h((ObservableField) obj, i2);
            case 16:
                return f((ObservableField) obj, i2);
            case 17:
                return b((ObservableField<Integer>) obj, i2);
            case 18:
                return i((ObservableField) obj, i2);
            case 19:
                return a((AbstractC2676e) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(androidx.lifecycle.g gVar) {
        super.setLifecycleOwner(gVar);
        this.f17861e.setLifecycleOwner(gVar);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.gamedetail.a.h != i) {
            return false;
        }
        a((ba) obj);
        return true;
    }

    private p(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 20, (FrameLayout) objArr[25], (ImageView) objArr[26], (ImageView) objArr[22], (LinearLayout) objArr[10], (AbstractC2676e) objArr[23], (GameDetailRelativeLayout) objArr[0], (CenterRadioButton) objArr[24], (CenterRadioButton) objArr[8], (CenterRadioButton) objArr[7]);
        this.E = -1L;
        this.f17859c.setTag(null);
        this.f17860d.setTag(null);
        this.m = (Banner) objArr[1];
        this.m.setTag(null);
        this.n = (MaxLayout) objArr[11];
        this.n.setTag(null);
        this.o = (TextView) objArr[12];
        this.o.setTag(null);
        this.p = (ImageView) objArr[13];
        this.p.setTag(null);
        this.q = (TextView) objArr[14];
        this.q.setTag(null);
        this.r = (MaxLayout) objArr[15];
        this.r.setTag(null);
        this.s = (ProgressBar) objArr[16];
        this.s.setTag(null);
        this.t = (TextView) objArr[17];
        this.t.setTag(null);
        this.u = (RelativeLayout) objArr[18];
        this.u.setTag(null);
        this.v = (Button) objArr[19];
        this.v.setTag(null);
        this.w = (TextView) objArr[2];
        this.w.setTag(null);
        this.x = (ImageView) objArr[20];
        this.x.setTag(null);
        this.y = (TextView) objArr[21];
        this.y.setTag(null);
        this.z = (LinearLayout) objArr[3];
        this.z.setTag(null);
        this.A = (CheckBox) objArr[4];
        this.A.setTag(null);
        this.B = (TextView) objArr[5];
        this.B.setTag(null);
        this.C = (RadioGroup) objArr[6];
        this.C.setTag(null);
        this.D = (View) objArr[9];
        this.D.setTag(null);
        this.f17862f.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.E |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
        return true;
    }

    private boolean c(ObservableList<String> observableList, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.E |= 1024;
        }
        return true;
    }

    private boolean a(ba baVar, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.E |= 8;
        }
        return true;
    }

    private boolean a(ObservableList<BannerEntity> observableList, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.E |= 128;
        }
        return true;
    }

    private boolean a(ObservableField<Drawable> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.E |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        return true;
    }

    private boolean a(AbstractC2676e abstractC2676e, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.E |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        return true;
    }
}
