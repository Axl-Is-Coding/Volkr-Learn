package com.sandboxol.decorate.c;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.util.ConvertUtils;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;

/* JADX INFO: compiled from: ItemNewDressShopRecommendBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class W extends V {
    private static final ViewDataBinding.b K = null;
    private static final SparseIntArray L = new SparseIntArray();
    private final ConstraintLayout M;
    private final ImageView N;
    private final ImageView O;
    private final ImageView P;
    private final ImageView Q;
    private final ImageView R;
    private final ImageView S;
    private final ImageView T;
    private final ImageView U;
    private long V;
    private long W;
    private long X;

    static {
        L.put(R.id.bgView, 41);
        L.put(R.id.guideline11, 42);
        L.put(R.id.guideline12, 43);
    }

    public W(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 44, K, L));
    }

    private boolean A(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 8;
        }
        return true;
    }

    private boolean B(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 1024;
        }
        return true;
    }

    private boolean C(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 140737488355328L;
        }
        return true;
    }

    private boolean D(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean E(ObservableField<Drawable> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 4398046511104L;
        }
        return true;
    }

    private boolean F(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 2199023255552L;
        }
        return true;
    }

    private boolean G(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 1099511627776L;
        }
        return true;
    }

    private boolean H(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 281474976710656L;
        }
        return true;
    }

    private boolean I(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 65536;
        }
        return true;
    }

    private boolean J(ObservableField<Drawable> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 32;
        }
        return true;
    }

    private boolean K(ObservableField<Drawable> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 35184372088832L;
        }
        return true;
    }

    private boolean L(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 8796093022208L;
        }
        return true;
    }

    private boolean M(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 128;
        }
        return true;
    }

    private boolean N(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 549755813888L;
        }
        return true;
    }

    private boolean O(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 1;
        }
        return true;
    }

    private boolean P(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 8388608;
        }
        return true;
    }

    private boolean Q(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= ConvertUtils.GB;
        }
        return true;
    }

    private boolean R(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= PlaybackStateCompat.ACTION_PREPARE;
        }
        return true;
    }

    private boolean S(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        return true;
    }

    private boolean T(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 256;
        }
        return true;
    }

    private boolean b(ShopRecommendDecorationInfo shopRecommendDecorationInfo, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 16;
        }
        return true;
    }

    private boolean d(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 64;
        }
        return true;
    }

    private boolean e(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 8589934592L;
        }
        return true;
    }

    private boolean f(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 512;
        }
        return true;
    }

    private boolean g(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 134217728;
        }
        return true;
    }

    private boolean h(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 67108864;
        }
        return true;
    }

    private boolean i(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 70368744177664L;
        }
        return true;
    }

    private boolean j(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 4;
        }
        return true;
    }

    private boolean k(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 4294967296L;
        }
        return true;
    }

    private boolean l(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
        return true;
    }

    private boolean m(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 34359738368L;
        }
        return true;
    }

    private boolean n(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 137438953472L;
        }
        return true;
    }

    private boolean o(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 17179869184L;
        }
        return true;
    }

    private boolean p(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 2;
        }
        return true;
    }

    private boolean q(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 562949953421312L;
        }
        return true;
    }

    private boolean r(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 4194304;
        }
        return true;
    }

    private boolean s(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 274877906944L;
        }
        return true;
    }

    private boolean t(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 536870912;
        }
        return true;
    }

    private boolean u(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 33554432;
        }
        return true;
    }

    private boolean v(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        }
        return true;
    }

    private boolean w(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        }
        return true;
    }

    private boolean x(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean y(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean z(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 1048576;
        }
        return true;
    }

    public void a(com.sandboxol.decorate.view.activity.dress.S s) {
        updateRegistration(24, s);
        this.J = s;
        synchronized (this) {
            this.V |= 16777216;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.G);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02bf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0543  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0568 A[PHI: r6
      0x0568: PHI (r6v92 long) = (r6v91 long), (r6v93 long) binds: [B:349:0x0541, B:363:0x0563] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x05c5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x0618  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x0635  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0648  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x067c  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x068c  */
    /* JADX WARN: Removed duplicated region for block: B:459:0x06db  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x06ec  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x0735  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x0748  */
    /* JADX WARN: Removed duplicated region for block: B:500:0x0782  */
    /* JADX WARN: Removed duplicated region for block: B:504:0x0794  */
    /* JADX WARN: Removed duplicated region for block: B:532:0x0815  */
    /* JADX WARN: Removed duplicated region for block: B:536:0x0826  */
    /* JADX WARN: Removed duplicated region for block: B:542:0x0843  */
    /* JADX WARN: Removed duplicated region for block: B:546:0x0856  */
    /* JADX WARN: Removed duplicated region for block: B:562:0x088a  */
    /* JADX WARN: Removed duplicated region for block: B:566:0x089a  */
    /* JADX WARN: Removed duplicated region for block: B:594:0x0916  */
    /* JADX WARN: Removed duplicated region for block: B:598:0x0928  */
    /* JADX WARN: Removed duplicated region for block: B:614:0x095c  */
    /* JADX WARN: Removed duplicated region for block: B:618:0x096c  */
    /* JADX WARN: Removed duplicated region for block: B:635:0x09ab  */
    /* JADX WARN: Removed duplicated region for block: B:638:0x09be  */
    /* JADX WARN: Removed duplicated region for block: B:644:0x09db  */
    /* JADX WARN: Removed duplicated region for block: B:648:0x09ee  */
    /* JADX WARN: Removed duplicated region for block: B:654:0x0a07  */
    /* JADX WARN: Removed duplicated region for block: B:658:0x0a18  */
    /* JADX WARN: Removed duplicated region for block: B:677:0x0a61  */
    /* JADX WARN: Removed duplicated region for block: B:680:0x0a72  */
    /* JADX WARN: Removed duplicated region for block: B:695:0x0aac  */
    /* JADX WARN: Removed duplicated region for block: B:699:0x0abe  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:705:0x0ad7  */
    /* JADX WARN: Removed duplicated region for block: B:709:0x0ae8  */
    /* JADX WARN: Removed duplicated region for block: B:726:0x0b89  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:754:0x0cf8  */
    /* JADX WARN: Removed duplicated region for block: B:762:0x0d1b  */
    /* JADX WARN: Removed duplicated region for block: B:767:0x0d2c  */
    /* JADX WARN: Removed duplicated region for block: B:772:0x0d3d  */
    /* JADX WARN: Removed duplicated region for block: B:775:0x0d47  */
    /* JADX WARN: Removed duplicated region for block: B:791:0x0d7d  */
    /* JADX WARN: Removed duplicated region for block: B:794:0x0d8c  */
    /* JADX WARN: Removed duplicated region for block: B:802:0x0db4  */
    /* JADX WARN: Removed duplicated region for block: B:805:0x0dc2  */
    /* JADX WARN: Removed duplicated region for block: B:821:0x0df2  */
    /* JADX WARN: Removed duplicated region for block: B:826:0x0e08  */
    /* JADX WARN: Removed duplicated region for block: B:831:0x0e1b  */
    /* JADX WARN: Removed duplicated region for block: B:834:0x0e2a  */
    /* JADX WARN: Removed duplicated region for block: B:850:0x0e5e  */
    /* JADX WARN: Removed duplicated region for block: B:853:0x0e6f  */
    /* JADX WARN: Removed duplicated region for block: B:861:0x0e97  */
    /* JADX WARN: Removed duplicated region for block: B:866:0x0ead  */
    /* JADX WARN: Removed duplicated region for block: B:869:0x0eb7  */
    /* JADX WARN: Removed duplicated region for block: B:877:0x0edf  */
    /* JADX WARN: Removed duplicated region for block: B:882:0x0ef5  */
    /* JADX WARN: Removed duplicated region for block: B:885:0x0f02  */
    /* JADX WARN: Removed duplicated region for block: B:891:0x0f1f  */
    /* JADX WARN: Removed duplicated region for block: B:895:0x0f2f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0159 A[PHI: r6
      0x0159: PHI (r6v18 long) = (r6v17 long), (r6v119 long) binds: [B:72:0x0124, B:86:0x0153] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:911:0x0f63  */
    /* JADX WARN: Removed duplicated region for block: B:914:0x0f71  */
    /* JADX WARN: Removed duplicated region for block: B:920:0x0f8a  */
    /* JADX WARN: Removed duplicated region for block: B:924:0x0f98 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:926:0x0f9d  */
    /* JADX WARN: Removed duplicated region for block: B:929:0x0fa7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:935:0x0fbc  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0179  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 5397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.decorate.c.W.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.V == 0 && this.W == 0 && this.X == 0) {
                return false;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.V = 4503599627370496L;
            this.W = 0L;
            this.X = 0L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return O((ObservableField) obj, i2);
            case 1:
                return p((ObservableField) obj, i2);
            case 2:
                return j((ObservableField) obj, i2);
            case 3:
                return A((ObservableField) obj, i2);
            case 4:
                return c((ObservableField<String>) obj, i2);
            case 5:
                return J((ObservableField) obj, i2);
            case 6:
                return d((ObservableField<Integer>) obj, i2);
            case 7:
                return M((ObservableField) obj, i2);
            case 8:
                return T((ObservableField) obj, i2);
            case 9:
                return f((ObservableField) obj, i2);
            case 10:
                return B((ObservableField) obj, i2);
            case 11:
                return D((ObservableField) obj, i2);
            case 12:
                return x((ObservableField) obj, i2);
            case 13:
                return b((ShopRecommendDecorationInfo) obj, i2);
            case 14:
                return R((ObservableField) obj, i2);
            case 15:
                return y((ObservableField) obj, i2);
            case 16:
                return I((ObservableField) obj, i2);
            case 17:
                return l((ObservableField) obj, i2);
            case 18:
                return w((ObservableField) obj, i2);
            case 19:
                return S((ObservableField) obj, i2);
            case 20:
                return z((ObservableField) obj, i2);
            case 21:
                return v((ObservableField) obj, i2);
            case 22:
                return r((ObservableField) obj, i2);
            case 23:
                return P((ObservableField) obj, i2);
            case 24:
                return a((com.sandboxol.decorate.view.activity.dress.S) obj, i2);
            case 25:
                return u((ObservableField) obj, i2);
            case 26:
                return h((ObservableField) obj, i2);
            case 27:
                return g((ObservableField) obj, i2);
            case 28:
                return a((ObservableField<String>) obj, i2);
            case 29:
                return t((ObservableField) obj, i2);
            case 30:
                return Q((ObservableField) obj, i2);
            case 31:
                return c((ShopRecommendDecorationInfo) obj, i2);
            case 32:
                return k((ObservableField) obj, i2);
            case 33:
                return e((ObservableField) obj, i2);
            case 34:
                return o((ObservableField) obj, i2);
            case 35:
                return m((ObservableField) obj, i2);
            case 36:
                return a((ShopRecommendDecorationInfo) obj, i2);
            case 37:
                return n((ObservableField) obj, i2);
            case 38:
                return s((ObservableField) obj, i2);
            case 39:
                return N((ObservableField) obj, i2);
            case 40:
                return G((ObservableField) obj, i2);
            case 41:
                return F((ObservableField) obj, i2);
            case 42:
                return E((ObservableField) obj, i2);
            case 43:
                return L((ObservableField) obj, i2);
            case 44:
                return d((ShopRecommendDecorationInfo) obj, i2);
            case 45:
                return K((ObservableField) obj, i2);
            case 46:
                return i((ObservableField) obj, i2);
            case 47:
                return C((ObservableField) obj, i2);
            case 48:
                return H((ObservableField) obj, i2);
            case 49:
                return q((ObservableField) obj, i2);
            case 50:
                return b((ObservableField<Drawable>) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.G != i) {
            return false;
        }
        a((com.sandboxol.decorate.view.activity.dress.S) obj);
        return true;
    }

    private W(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 51, (View) objArr[1], (View) objArr[2], (View) objArr[3], (View) objArr[4], (View) objArr[25], (View) objArr[28], (View) objArr[31], (View) objArr[34], (View) objArr[26], (View) objArr[29], (View) objArr[32], (View) objArr[35], (View) objArr[41], (Group) objArr[37], (Group) objArr[38], (Group) objArr[39], (Group) objArr[40], (Guideline) objArr[42], (Guideline) objArr[43], (ImageView) objArr[5], (ImageView) objArr[7], (ImageView) objArr[9], (ImageView) objArr[11], (TextView) objArr[13], (TextView) objArr[14], (TextView) objArr[17], (TextView) objArr[20], (TextView) objArr[23], (TextView) objArr[16], (TextView) objArr[19], (TextView) objArr[22], (TextView) objArr[15], (TextView) objArr[18], (TextView) objArr[21], (TextView) objArr[24]);
        this.V = -1L;
        this.W = -1L;
        this.X = -1L;
        this.f17045a.setTag(null);
        this.f17046b.setTag(null);
        this.f17047c.setTag(null);
        this.f17048d.setTag(null);
        this.f17049e.setTag(null);
        this.f17050f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        this.p.setTag(null);
        this.q.setTag(null);
        this.t.setTag(null);
        this.u.setTag(null);
        this.v.setTag(null);
        this.w.setTag(null);
        this.M = (ConstraintLayout) objArr[0];
        this.M.setTag(null);
        this.N = (ImageView) objArr[10];
        this.N.setTag(null);
        this.O = (ImageView) objArr[12];
        this.O.setTag(null);
        this.P = (ImageView) objArr[27];
        this.P.setTag(null);
        this.Q = (ImageView) objArr[30];
        this.Q.setTag(null);
        this.R = (ImageView) objArr[33];
        this.R.setTag(null);
        this.S = (ImageView) objArr[36];
        this.S.setTag(null);
        this.T = (ImageView) objArr[6];
        this.T.setTag(null);
        this.U = (ImageView) objArr[8];
        this.U.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        this.A.setTag(null);
        this.B.setTag(null);
        this.C.setTag(null);
        this.D.setTag(null);
        this.E.setTag(null);
        this.F.setTag(null);
        this.G.setTag(null);
        this.H.setTag(null);
        this.I.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean b(ObservableField<Drawable> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 1125899906842624L;
        }
        return true;
    }

    private boolean c(ShopRecommendDecorationInfo shopRecommendDecorationInfo, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 2147483648L;
        }
        return true;
    }

    private boolean d(ShopRecommendDecorationInfo shopRecommendDecorationInfo, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 17592186044416L;
        }
        return true;
    }

    private boolean a(com.sandboxol.decorate.view.activity.dress.S s, int i) {
        if (i == com.sandboxol.decorate.c.f16979a) {
            synchronized (this) {
                this.V |= 16777216;
            }
            return true;
        }
        if (i != com.sandboxol.decorate.c.I) {
            return false;
        }
        synchronized (this) {
            this.V |= 2251799813685248L;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 268435456;
        }
        return true;
    }

    private boolean a(ShopRecommendDecorationInfo shopRecommendDecorationInfo, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.V |= 68719476736L;
        }
        return true;
    }
}
