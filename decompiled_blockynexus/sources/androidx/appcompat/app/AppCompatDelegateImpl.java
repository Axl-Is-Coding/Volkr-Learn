package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.C0281a;
import androidx.appcompat.d.b;
import androidx.appcompat.d.f;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C0305s;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.H;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ia;
import androidx.appcompat.widget.sa;
import androidx.appcompat.widget.ta;
import androidx.core.app.ActivityCompat;
import androidx.core.view.C0317e;
import androidx.core.view.C0318f;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import cn.qqtheme.framework.widget.WheelView;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
class AppCompatDelegateImpl extends l implements LayoutInflater.Factory2, MenuBuilder.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<Class<?>, Integer> f212d = new a.a.b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final boolean f213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f214f;
    private static boolean g;
    private static final boolean h;
    private ViewGroup A;
    private TextView B;
    private View C;
    private boolean D;
    private boolean E;
    boolean F;
    boolean G;
    boolean H;
    boolean I;
    boolean J;
    private boolean K;
    private i[] L;
    private i M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    boolean R;
    private int S;
    private int T;
    private boolean U;
    private boolean V;
    private f W;
    private f X;
    boolean Y;
    int Z;
    private final Runnable aa;
    private boolean ba;
    private Rect ca;
    private Rect da;
    private AppCompatViewInflater ea;
    final Object i;
    final Context j;
    Window k;
    private d l;
    final k m;
    ActionBar n;
    MenuInflater o;
    private CharSequence p;
    private DecorContentParent q;
    private b r;
    private j s;
    androidx.appcompat.d.b t;
    ActionBarContextView u;
    PopupWindow v;
    Runnable w;
    androidx.core.view.F x;
    private boolean y;
    private boolean z;

    private class a implements C0281a.InterfaceC0002a {
        a() {
        }
    }

    class c implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b.a f217a;

        public c(b.a aVar) {
            this.f217a = aVar;
        }

        @Override // androidx.appcompat.d.b.a
        public boolean a(androidx.appcompat.d.b bVar, Menu menu) {
            return this.f217a.a(bVar, menu);
        }

        @Override // androidx.appcompat.d.b.a
        public boolean b(androidx.appcompat.d.b bVar, Menu menu) {
            return this.f217a.b(bVar, menu);
        }

        @Override // androidx.appcompat.d.b.a
        public boolean a(androidx.appcompat.d.b bVar, MenuItem menuItem) {
            return this.f217a.a(bVar, menuItem);
        }

        @Override // androidx.appcompat.d.b.a
        public void a(androidx.appcompat.d.b bVar) {
            this.f217a.a(bVar);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.v != null) {
                appCompatDelegateImpl.k.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.w);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.u != null) {
                appCompatDelegateImpl2.n();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                androidx.core.view.F fA = ViewCompat.a(appCompatDelegateImpl3.u);
                fA.a(WheelView.DividerConfig.FILL);
                appCompatDelegateImpl3.x = fA;
                AppCompatDelegateImpl.this.x.a(new u(this));
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            k kVar = appCompatDelegateImpl4.m;
            if (kVar != null) {
                kVar.onSupportActionModeFinished(appCompatDelegateImpl4.t);
            }
            AppCompatDelegateImpl.this.t = null;
        }
    }

    private class e extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final PowerManager f220c;

        e(Context context) {
            super();
            this.f220c = (PowerManager) context.getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.f
        IntentFilter b() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.f
        public int c() {
            return (Build.VERSION.SDK_INT < 21 || !this.f220c.isPowerSaveMode()) ? 1 : 2;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.f
        public void d() {
            AppCompatDelegateImpl.this.l();
        }
    }

    abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private BroadcastReceiver f222a;

        f() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.f222a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.j.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f222a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.f222a == null) {
                this.f222a = new v(this);
            }
            AppCompatDelegateImpl.this.j.registerReceiver(this.f222a, intentFilterB);
        }
    }

    private class g extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final D f224c;

        g(D d2) {
            super();
            this.f224c = d2;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.f
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.f
        public int c() {
            return this.f224c.a() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.f
        public void d() {
            AppCompatDelegateImpl.this.l();
        }
    }

    private class h extends ContentFrameLayout {
        public h(Context context) {
            super(context);
        }

        private boolean a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.e(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
        }
    }

    static {
        boolean z = false;
        f213e = Build.VERSION.SDK_INT < 21;
        f214f = new int[]{R.attr.windowBackground};
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21 && i2 <= 25) {
            z = true;
        }
        h = z;
        if (!f213e || g) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new m(Thread.getDefaultUncaughtExceptionHandler()));
        g = true;
    }

    AppCompatDelegateImpl(Activity activity, k kVar) {
        this(activity, null, kVar, activity);
    }

    private void A() {
        if (this.k == null) {
            Object obj = this.i;
            if (obj instanceof Activity) {
                a(((Activity) obj).getWindow());
            }
        }
        if (this.k == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private f B() {
        if (this.X == null) {
            this.X = new e(this.j);
        }
        return this.X;
    }

    private void C() {
        z();
        if (this.F && this.n == null) {
            Object obj = this.i;
            if (obj instanceof Activity) {
                this.n = new WindowDecorActionBar((Activity) obj, this.G);
            } else if (obj instanceof Dialog) {
                this.n = new WindowDecorActionBar((Dialog) obj);
            }
            ActionBar actionBar = this.n;
            if (actionBar != null) {
                actionBar.c(this.ba);
            }
        }
    }

    private boolean D() {
        if (!this.V && (this.i instanceof Activity)) {
            PackageManager packageManager = this.j.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.j, this.i.getClass()), 0);
                this.U = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.U = false;
            }
        }
        this.V = true;
        return this.U;
    }

    private void E() {
        if (this.z) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private AppCompatActivity F() {
        for (Context baseContext = this.j; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof AppCompatActivity) {
                return (AppCompatActivity) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private int l(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i2 != 9) {
            return i2;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    private void v() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.A.findViewById(R.id.content);
        View decorView = this.k.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.j.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private int w() {
        int i2 = this.S;
        return i2 != -100 ? i2 : l.a();
    }

    private void x() {
        f fVar = this.W;
        if (fVar != null) {
            fVar.a();
        }
        f fVar2 = this.X;
        if (fVar2 != null) {
            fVar2.a();
        }
    }

    private ViewGroup y() {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.j.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        if (!typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowNoTitle, false)) {
            b(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar, false)) {
            b(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            b(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            b(10);
        }
        this.I = typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        A();
        this.k.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.j);
        if (this.J) {
            viewGroup = this.H ? (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.abc_screen_simple, (ViewGroup) null);
            if (Build.VERSION.SDK_INT >= 21) {
                ViewCompat.a(viewGroup, new o(this));
            } else {
                ((H) viewGroup).setOnFitSystemWindowsListener(new p(this));
            }
        } else if (this.I) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.G = false;
            this.F = false;
        } else if (this.F) {
            TypedValue typedValue = new TypedValue();
            this.j.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            viewGroup = (ViewGroup) LayoutInflater.from(i2 != 0 ? new androidx.appcompat.d.d(this.j, i2) : this.j).inflate(androidx.appcompat.R.layout.abc_screen_toolbar, (ViewGroup) null);
            this.q = (DecorContentParent) viewGroup.findViewById(androidx.appcompat.R.id.decor_content_parent);
            this.q.setWindowCallback(getWindowCallback());
            if (this.G) {
                this.q.initFeature(109);
            }
            if (this.D) {
                this.q.initFeature(2);
            }
            if (this.E) {
                this.q.initFeature(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.F + ", windowActionBarOverlay: " + this.G + ", android:windowIsFloating: " + this.I + ", windowActionModeOverlay: " + this.H + ", windowNoTitle: " + this.J + " }");
        }
        if (this.q == null) {
            this.B = (TextView) viewGroup.findViewById(androidx.appcompat.R.id.title);
        }
        ta.b(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(androidx.appcompat.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.k.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.k.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new q(this));
        return viewGroup;
    }

    private void z() {
        if (this.z) {
            return;
        }
        this.A = y();
        CharSequence charSequenceQ = q();
        if (!TextUtils.isEmpty(charSequenceQ)) {
            DecorContentParent decorContentParent = this.q;
            if (decorContentParent != null) {
                decorContentParent.setWindowTitle(charSequenceQ);
            } else if (t() != null) {
                t().b(charSequenceQ);
            } else {
                TextView textView = this.B;
                if (textView != null) {
                    textView.setText(charSequenceQ);
                }
            }
        }
        v();
        a(this.A);
        this.z = true;
        i iVarA = a(0, false);
        if (this.R) {
            return;
        }
        if (iVarA == null || iVarA.j == null) {
            k(108);
        }
    }

    @Override // androidx.appcompat.app.l
    public void a(Context context) {
        b(false);
        this.O = true;
    }

    void a(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.l
    public void b(Bundle bundle) {
        z();
    }

    @Override // androidx.appcompat.app.l
    public void c(int i2) {
        z();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.j).inflate(i2, viewGroup);
        this.l.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.l
    public MenuInflater d() {
        if (this.o == null) {
            C();
            ActionBar actionBar = this.n;
            this.o = new androidx.appcompat.d.g(actionBar != null ? actionBar.i() : this.j);
        }
        return this.o;
    }

    @Override // androidx.appcompat.app.l
    public ActionBar e() {
        C();
        return this.n;
    }

    @Override // androidx.appcompat.app.l
    public void f() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.j);
        if (layoutInflaterFrom.getFactory() == null) {
            C0318f.a(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof AppCompatDelegateImpl) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.l
    public void g() {
        ActionBar actionBarE = e();
        if (actionBarE == null || !actionBarE.j()) {
            k(0);
        }
    }

    final Window.Callback getWindowCallback() {
        return this.k.getCallback();
    }

    @Override // androidx.appcompat.app.l
    public void h() {
        l.b(this);
        if (this.Y) {
            this.k.getDecorView().removeCallbacks(this.aa);
        }
        this.Q = false;
        this.R = true;
        ActionBar actionBar = this.n;
        if (actionBar != null) {
            actionBar.k();
        }
        x();
    }

    @Override // androidx.appcompat.app.l
    public void i() {
        ActionBar actionBarE = e();
        if (actionBarE != null) {
            actionBarE.h(true);
        }
    }

    @Override // androidx.appcompat.app.l
    public void j() {
        this.Q = true;
        l();
        l.a(this);
    }

    @Override // androidx.appcompat.app.l
    public void k() {
        this.Q = false;
        l.b(this);
        ActionBar actionBarE = e();
        if (actionBarE != null) {
            actionBarE.h(false);
        }
        if (this.i instanceof Dialog) {
            x();
        }
    }

    void m() {
        MenuBuilder menuBuilder;
        DecorContentParent decorContentParent = this.q;
        if (decorContentParent != null) {
            decorContentParent.dismissPopups();
        }
        if (this.v != null) {
            this.k.getDecorView().removeCallbacks(this.w);
            if (this.v.isShowing()) {
                try {
                    this.v.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.v = null;
        }
        n();
        i iVarA = a(0, false);
        if (iVarA == null || (menuBuilder = iVarA.j) == null) {
            return;
        }
        menuBuilder.close();
    }

    void n() {
        androidx.core.view.F f2 = this.x;
        if (f2 != null) {
            f2.a();
        }
    }

    final Context o() {
        ActionBar actionBarE = e();
        Context contextI = actionBarE != null ? actionBarE.i() : null;
        return contextI == null ? this.j : contextI;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return a(view, str, context, attributeSet);
    }

    final f p() {
        if (this.W == null) {
            this.W = new g(D.a(this.j));
        }
        return this.W;
    }

    final CharSequence q() {
        Object obj = this.i;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.p;
    }

    public boolean r() {
        return this.y;
    }

    boolean s() {
        androidx.appcompat.d.b bVar = this.t;
        if (bVar != null) {
            bVar.a();
            return true;
        }
        ActionBar actionBarE = e();
        return actionBarE != null && actionBarE.f();
    }

    final ActionBar t() {
        return this.n;
    }

    final boolean u() {
        ViewGroup viewGroup;
        return this.z && (viewGroup = this.A) != null && ViewCompat.C(viewGroup);
    }

    private final class b implements MenuPresenter.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.a
        public boolean a(MenuBuilder menuBuilder) {
            Window.Callback windowCallback = AppCompatDelegateImpl.this.getWindowCallback();
            if (windowCallback == null) {
                return true;
            }
            windowCallback.onMenuOpened(108, menuBuilder);
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.a
        public void a(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImpl.this.b(menuBuilder);
        }
    }

    AppCompatDelegateImpl(Dialog dialog, k kVar) {
        this(dialog.getContext(), dialog.getWindow(), kVar, dialog);
    }

    @Override // androidx.appcompat.app.l
    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        z();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.l.a().onContentChanged();
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    protected static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f229c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f230d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f231e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f232f;
        ViewGroup g;
        View h;
        View i;
        MenuBuilder j;
        ListMenuPresenter k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        i(int i) {
            this.f227a = i;
        }

        public boolean a() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.c().getCount() > 0;
        }

        void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(androidx.appcompat.R.attr.actionBarPopupTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                themeNewTheme.applyStyle(i, true);
            }
            themeNewTheme.resolveAttribute(androidx.appcompat.R.attr.panelMenuListTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                themeNewTheme.applyStyle(i2, true);
            } else {
                themeNewTheme.applyStyle(androidx.appcompat.R.style.Theme_AppCompat_CompactMenu, true);
            }
            androidx.appcompat.d.d dVar = new androidx.appcompat.d.d(context, 0);
            dVar.getTheme().setTo(themeNewTheme);
            this.l = dVar;
            TypedArray typedArrayObtainStyledAttributes = dVar.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
            this.f228b = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTheme_panelBackground, 0);
            this.f232f = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        void a(MenuBuilder menuBuilder) {
            ListMenuPresenter listMenuPresenter;
            MenuBuilder menuBuilder2 = this.j;
            if (menuBuilder == menuBuilder2) {
                return;
            }
            if (menuBuilder2 != null) {
                menuBuilder2.b(this.k);
            }
            this.j = menuBuilder;
            if (menuBuilder == null || (listMenuPresenter = this.k) == null) {
                return;
            }
            menuBuilder.a(listMenuPresenter);
        }

        androidx.appcompat.view.menu.k a(MenuPresenter.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new ListMenuPresenter(this.l, androidx.appcompat.R.layout.abc_list_menu_item_layout);
                this.k.setCallback(aVar);
                this.j.a(this.k);
            }
            return this.k.a(this.g);
        }
    }

    private AppCompatDelegateImpl(Context context, Window window, k kVar, Object obj) {
        Integer num;
        AppCompatActivity appCompatActivityF;
        this.x = null;
        this.y = true;
        this.S = -100;
        this.aa = new n(this);
        this.j = context;
        this.m = kVar;
        this.i = obj;
        if (this.S == -100 && (this.i instanceof Dialog) && (appCompatActivityF = F()) != null) {
            this.S = appCompatActivityF.getDelegate().c();
        }
        if (this.S == -100 && (num = f212d.get(this.i.getClass())) != null) {
            this.S = num.intValue();
            f212d.remove(this.i.getClass());
        }
        if (window != null) {
            a(window);
        }
        C0305s.c();
    }

    @Override // androidx.appcompat.app.l
    public void a(Bundle bundle) {
        this.O = true;
        b(false);
        A();
        Object obj = this.i;
        if (obj instanceof Activity) {
            String strB = null;
            try {
                strB = androidx.core.app.j.b((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (strB != null) {
                ActionBar actionBarT = t();
                if (actionBarT == null) {
                    this.ba = true;
                } else {
                    actionBarT.c(true);
                }
            }
        }
        this.P = true;
    }

    void e(int i2) {
        a(a(i2, true), true);
    }

    void i(int i2) {
        if (i2 == 108) {
            ActionBar actionBarE = e();
            if (actionBarE != null) {
                actionBarE.b(false);
                return;
            }
            return;
        }
        if (i2 == 0) {
            i iVarA = a(i2, true);
            if (iVarA.o) {
                a(iVarA, false);
            }
        }
    }

    public boolean l() {
        return b(true);
    }

    class d extends androidx.appcompat.d.j {
        d(Window.Callback callback) {
            super(callback);
        }

        final ActionMode a(ActionMode.Callback callback) {
            f.a aVar = new f.a(AppCompatDelegateImpl.this.j, callback);
            androidx.appcompat.d.b bVarA = AppCompatDelegateImpl.this.a(aVar);
            if (bVarA != null) {
                return aVar.b(bVarA);
            }
            return null;
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.b(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImpl.this.h(i);
            return true;
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImpl.this.i(i);
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.c(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.c(false);
            }
            return zOnPreparePanel;
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            MenuBuilder menuBuilder;
            i iVarA = AppCompatDelegateImpl.this.a(0, true);
            if (iVarA == null || (menuBuilder = iVarA.j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, menuBuilder, i);
            }
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return AppCompatDelegateImpl.this.r() ? a(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (AppCompatDelegateImpl.this.r() && i == 0) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean e(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            androidx.appcompat.d.b r0 = r3.t
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            androidx.appcompat.app.AppCompatDelegateImpl$i r2 = r3.a(r4, r0)
            if (r4 != 0) goto L43
            androidx.appcompat.widget.DecorContentParent r4 = r3.q
            if (r4 == 0) goto L43
            boolean r4 = r4.canShowOverflowMenu()
            if (r4 == 0) goto L43
            android.content.Context r4 = r3.j
            android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r4)
            boolean r4 = r4.hasPermanentMenuKey()
            if (r4 != 0) goto L43
            androidx.appcompat.widget.DecorContentParent r4 = r3.q
            boolean r4 = r4.isOverflowMenuShowing()
            if (r4 != 0) goto L3c
            boolean r4 = r3.R
            if (r4 != 0) goto L63
            boolean r4 = r3.b(r2, r5)
            if (r4 == 0) goto L63
            androidx.appcompat.widget.DecorContentParent r4 = r3.q
            boolean r4 = r4.showOverflowMenu()
            goto L6a
        L3c:
            androidx.appcompat.widget.DecorContentParent r4 = r3.q
            boolean r4 = r4.hideOverflowMenu()
            goto L6a
        L43:
            boolean r4 = r2.o
            if (r4 != 0) goto L65
            boolean r4 = r2.n
            if (r4 == 0) goto L4c
            goto L65
        L4c:
            boolean r4 = r2.m
            if (r4 == 0) goto L63
            boolean r4 = r2.r
            if (r4 == 0) goto L5b
            r2.m = r1
            boolean r4 = r3.b(r2, r5)
            goto L5c
        L5b:
            r4 = 1
        L5c:
            if (r4 == 0) goto L63
            r3.a(r2, r5)
            r4 = 1
            goto L6a
        L63:
            r4 = 0
            goto L6a
        L65:
            boolean r4 = r2.o
            r3.a(r2, r0)
        L6a:
            if (r4 == 0) goto L83
            android.content.Context r5 = r3.j
            java.lang.String r0 = "audio"
            java.lang.Object r5 = r5.getSystemService(r0)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L7c
            r5.playSoundEffect(r1)
            goto L83
        L7c:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r0 = "Couldn't get audio manager"
            android.util.Log.w(r5, r0)
        L83:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.e(int, android.view.KeyEvent):boolean");
    }

    int g(int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 == -1) {
            return i2;
        }
        if (i2 == 0) {
            if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) this.j.getSystemService(UiModeManager.class)).getNightMode() != 0) {
                return p().c();
            }
            return -1;
        }
        if (i2 == 1 || i2 == 2) {
            return i2;
        }
        if (i2 == 3) {
            return B().c();
        }
        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
    }

    int j(int i2) {
        boolean z;
        boolean z2;
        ActionBarContextView actionBarContextView = this.u;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.u.getLayoutParams();
            if (this.u.isShown()) {
                if (this.ca == null) {
                    this.ca = new Rect();
                    this.da = new Rect();
                }
                Rect rect = this.ca;
                Rect rect2 = this.da;
                rect.set(0, i2, 0, 0);
                ta.a(this.A, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i2 : 0)) {
                    marginLayoutParams.topMargin = i2;
                    View view = this.C;
                    if (view == null) {
                        this.C = new View(this.j);
                        this.C.setBackgroundColor(this.j.getResources().getColor(androidx.appcompat.R.color.abc_input_method_navigation_guard));
                        this.A.addView(this.C, -1, new ViewGroup.LayoutParams(-1, i2));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i2) {
                            layoutParams.height = i2;
                            this.C.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = this.C != null;
                if (!this.H && z) {
                    i2 = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = false;
            }
            if (z2) {
                this.u.setLayoutParams(marginLayoutParams);
            }
        }
        View view2 = this.C;
        if (view2 != null) {
            view2.setVisibility(z ? 0 : 8);
        }
        return i2;
    }

    private final class j implements MenuPresenter.a {
        j() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.a
        public void a(MenuBuilder menuBuilder, boolean z) {
            MenuBuilder menuBuilderM = menuBuilder.m();
            boolean z2 = menuBuilderM != menuBuilder;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                menuBuilder = menuBuilderM;
            }
            i iVarA = appCompatDelegateImpl.a((Menu) menuBuilder);
            if (iVarA != null) {
                if (!z2) {
                    AppCompatDelegateImpl.this.a(iVarA, z);
                } else {
                    AppCompatDelegateImpl.this.a(iVarA.f227a, iVarA, menuBuilderM);
                    AppCompatDelegateImpl.this.a(iVarA, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.a
        public boolean a(MenuBuilder menuBuilder) {
            Window.Callback windowCallback;
            if (menuBuilder != null) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.F || (windowCallback = appCompatDelegateImpl.getWindowCallback()) == null || AppCompatDelegateImpl.this.R) {
                return true;
            }
            windowCallback.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    @Override // androidx.appcompat.app.l
    public void c(Bundle bundle) {
        if (this.S != -100) {
            f212d.put(this.i.getClass(), Integer.valueOf(this.S));
        }
    }

    @Override // androidx.appcompat.app.l
    public void d(int i2) {
        this.T = i2;
    }

    void f(int i2) {
        i iVarA;
        i iVarA2 = a(i2, true);
        if (iVarA2.j != null) {
            Bundle bundle = new Bundle();
            iVarA2.j.c(bundle);
            if (bundle.size() > 0) {
                iVarA2.s = bundle;
            }
            iVarA2.j.s();
            iVarA2.j.clear();
        }
        iVarA2.r = true;
        iVarA2.q = true;
        if ((i2 != 108 && i2 != 0) || this.q == null || (iVarA = a(0, false)) == null) {
            return;
        }
        iVarA.m = false;
        b(iVarA, (KeyEvent) null);
    }

    private boolean d(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        i iVarA = a(i2, true);
        if (iVarA.o) {
            return false;
        }
        return b(iVarA, keyEvent);
    }

    private void k(int i2) {
        this.Z = (1 << i2) | this.Z;
        if (this.Y) {
            return;
        }
        ViewCompat.a(this.k.getDecorView(), this.aa);
        this.Y = true;
    }

    @Override // androidx.appcompat.app.l
    public boolean b(int i2) {
        int iL = l(i2);
        if (this.J && iL == 108) {
            return false;
        }
        if (this.F && iL == 1) {
            this.F = false;
        }
        if (iL == 1) {
            E();
            this.J = true;
            return true;
        }
        if (iL == 2) {
            E();
            this.D = true;
            return true;
        }
        if (iL == 5) {
            E();
            this.E = true;
            return true;
        }
        if (iL == 10) {
            E();
            this.H = true;
            return true;
        }
        if (iL == 108) {
            E();
            this.F = true;
            return true;
        }
        if (iL != 109) {
            return this.k.requestFeature(iL);
        }
        E();
        this.G = true;
        return true;
    }

    boolean c(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z = this.N;
            this.N = false;
            i iVarA = a(0, false);
            if (iVarA != null && iVarA.o) {
                if (!z) {
                    a(iVarA, true);
                }
                return true;
            }
            if (s()) {
                return true;
            }
        } else if (i2 == 82) {
            e(0, keyEvent);
            return true;
        }
        return false;
    }

    void h(int i2) {
        ActionBar actionBarE;
        if (i2 != 108 || (actionBarE = e()) == null) {
            return;
        }
        actionBarE.b(true);
    }

    @Override // androidx.appcompat.app.l
    public void a(Toolbar toolbar) {
        if (this.i instanceof Activity) {
            ActionBar actionBarE = e();
            if (!(actionBarE instanceof WindowDecorActionBar)) {
                this.o = null;
                if (actionBarE != null) {
                    actionBarE.k();
                }
                if (toolbar != null) {
                    ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, q(), this.l);
                    this.n = toolbarActionBar;
                    this.k.setCallback(toolbarActionBar.getWrappedWindowCallback());
                } else {
                    this.n = null;
                    this.k.setCallback(this.l);
                }
                g();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    private boolean c(i iVar) {
        Context context = this.j;
        int i2 = iVar.f227a;
        if ((i2 == 0 || i2 == 108) && this.q != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
            Resources.Theme themeNewTheme = null;
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                androidx.appcompat.d.d dVar = new androidx.appcompat.d.d(context, 0);
                dVar.getTheme().setTo(themeNewTheme);
                context = dVar;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.setCallback(this);
        iVar.a(menuBuilder);
        return true;
    }

    @Override // androidx.appcompat.app.l
    public <T extends View> T a(int i2) {
        z();
        return (T) this.k.findViewById(i2);
    }

    androidx.appcompat.d.b b(b.a aVar) {
        androidx.appcompat.d.b bVarOnWindowStartingSupportActionMode;
        Context dVar;
        k kVar;
        n();
        androidx.appcompat.d.b bVar = this.t;
        if (bVar != null) {
            bVar.a();
        }
        if (!(aVar instanceof c)) {
            aVar = new c(aVar);
        }
        k kVar2 = this.m;
        if (kVar2 == null || this.R) {
            bVarOnWindowStartingSupportActionMode = null;
        } else {
            try {
                bVarOnWindowStartingSupportActionMode = kVar2.onWindowStartingSupportActionMode(aVar);
            } catch (AbstractMethodError unused) {
                bVarOnWindowStartingSupportActionMode = null;
            }
        }
        if (bVarOnWindowStartingSupportActionMode != null) {
            this.t = bVarOnWindowStartingSupportActionMode;
        } else {
            if (this.u == null) {
                if (this.I) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.j.getTheme();
                    theme.resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.j.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new androidx.appcompat.d.d(this.j, 0);
                        dVar.getTheme().setTo(themeNewTheme);
                    } else {
                        dVar = this.j;
                    }
                    this.u = new ActionBarContextView(dVar);
                    this.v = new PopupWindow(dVar, (AttributeSet) null, androidx.appcompat.R.attr.actionModePopupWindowStyle);
                    androidx.core.widget.k.a(this.v, 2);
                    this.v.setContentView(this.u);
                    this.v.setWidth(-1);
                    dVar.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarSize, typedValue, true);
                    this.u.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.v.setHeight(-2);
                    this.w = new s(this);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.A.findViewById(androidx.appcompat.R.id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(o()));
                        this.u = (ActionBarContextView) viewStubCompat.inflate();
                    }
                }
            }
            if (this.u != null) {
                n();
                this.u.killMode();
                androidx.appcompat.d.e eVar = new androidx.appcompat.d.e(this.u.getContext(), this.u, aVar, this.v == null);
                if (aVar.a(eVar, eVar.c())) {
                    eVar.i();
                    this.u.initForMode(eVar);
                    this.t = eVar;
                    if (u()) {
                        this.u.setAlpha(WheelView.DividerConfig.FILL);
                        androidx.core.view.F fA = ViewCompat.a(this.u);
                        fA.a(1.0f);
                        this.x = fA;
                        this.x.a(new t(this));
                    } else {
                        this.u.setAlpha(1.0f);
                        this.u.setVisibility(0);
                        this.u.sendAccessibilityEvent(32);
                        if (this.u.getParent() instanceof View) {
                            ViewCompat.H((View) this.u.getParent());
                        }
                    }
                    if (this.v != null) {
                        this.k.getDecorView().post(this.w);
                    }
                } else {
                    this.t = null;
                }
            }
        }
        androidx.appcompat.d.b bVar2 = this.t;
        if (bVar2 != null && (kVar = this.m) != null) {
            kVar.onSupportActionModeStarted(bVar2);
        }
        return this.t;
    }

    @Override // androidx.appcompat.app.l
    public void a(Configuration configuration) {
        ActionBar actionBarE;
        if (this.F && this.z && (actionBarE = e()) != null) {
            actionBarE.a(configuration);
        }
        C0305s.b().a(this.j);
        b(false);
    }

    @Override // androidx.appcompat.app.l
    public void a(View view) {
        z();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.l.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.l
    public int c() {
        return this.S;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c(int i2, boolean z) {
        Resources resources = this.j.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.uiMode = i2 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration, null);
        if (Build.VERSION.SDK_INT < 26) {
            z.a(resources);
        }
        int i3 = this.T;
        if (i3 != 0) {
            this.j.setTheme(i3);
            if (Build.VERSION.SDK_INT >= 23) {
                this.j.getTheme().applyStyle(this.T, true);
            }
        }
        if (z) {
            Object obj = this.i;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.g) {
                    if (((androidx.lifecycle.g) activity).getLifecycle().a().isAtLeast(Lifecycle.State.STARTED)) {
                        activity.onConfigurationChanged(configuration);
                    }
                } else if (this.Q) {
                    activity.onConfigurationChanged(configuration);
                }
            }
        }
    }

    @Override // androidx.appcompat.app.l
    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        z();
        ((ViewGroup) this.A.findViewById(R.id.content)).addView(view, layoutParams);
        this.l.a().onContentChanged();
    }

    private void a(Window window) {
        if (this.k == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof d)) {
                this.l = new d(callback);
                window.setCallback(this.l);
                ia iaVarA = ia.a(this.j, (AttributeSet) null, f214f);
                Drawable drawableC = iaVarA.c(0);
                if (drawableC != null) {
                    window.setBackgroundDrawable(drawableC);
                }
                iaVarA.a();
                this.k = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    @Override // androidx.appcompat.app.l
    public final void a(CharSequence charSequence) {
        this.p = charSequence;
        DecorContentParent decorContentParent = this.q;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
            return;
        }
        if (t() != null) {
            t().b(charSequence);
            return;
        }
        TextView textView = this.B;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.a
    public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
        i iVarA;
        Window.Callback windowCallback = getWindowCallback();
        if (windowCallback == null || this.R || (iVarA = a((Menu) menuBuilder.m())) == null) {
            return false;
        }
        return windowCallback.onMenuItemSelected(iVarA.f227a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.a
    public void a(MenuBuilder menuBuilder) {
        a(menuBuilder, true);
    }

    @Override // androidx.appcompat.app.l
    public androidx.appcompat.d.b a(b.a aVar) {
        k kVar;
        if (aVar != null) {
            androidx.appcompat.d.b bVar = this.t;
            if (bVar != null) {
                bVar.a();
            }
            c cVar = new c(aVar);
            ActionBar actionBarE = e();
            if (actionBarE != null) {
                this.t = actionBarE.a(cVar);
                androidx.appcompat.d.b bVar2 = this.t;
                if (bVar2 != null && (kVar = this.m) != null) {
                    kVar.onSupportActionModeStarted(bVar2);
                }
            }
            if (this.t == null) {
                this.t = b(cVar);
            }
            return this.t;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    boolean a(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.i;
        if (((obj instanceof C0317e.a) || (obj instanceof x)) && (decorView = this.k.getDecorView()) != null && C0317e.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.l.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? a(keyCode, keyEvent) : c(keyCode, keyEvent);
    }

    boolean a(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.N = (keyEvent.getFlags() & 128) != 0;
        } else if (i2 == 82) {
            d(0, keyEvent);
            return true;
        }
        return false;
    }

    boolean b(int i2, KeyEvent keyEvent) {
        ActionBar actionBarE = e();
        if (actionBarE != null && actionBarE.a(i2, keyEvent)) {
            return true;
        }
        i iVar = this.M;
        if (iVar != null && a(iVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            i iVar2 = this.M;
            if (iVar2 != null) {
                iVar2.n = true;
            }
            return true;
        }
        if (this.M == null) {
            i iVarA = a(0, true);
            b(iVarA, keyEvent);
            boolean zA = a(iVarA, keyEvent.getKeyCode(), keyEvent, 1);
            iVarA.m = false;
            if (zA) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean zA = false;
        if (this.ea == null) {
            String string = this.j.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme).getString(androidx.appcompat.R.styleable.AppCompatTheme_viewInflaterClass);
            if (string != null && !AppCompatViewInflater.class.getName().equals(string)) {
                try {
                    this.ea = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.ea = new AppCompatViewInflater();
                }
            } else {
                this.ea = new AppCompatViewInflater();
            }
        }
        if (f213e) {
            if (attributeSet instanceof XmlPullParser) {
                if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    zA = true;
                }
            } else {
                zA = a((ViewParent) view);
            }
            z = zA;
        } else {
            z = false;
        }
        return this.ea.createView(view, str, context, attributeSet, z, f213e, true, sa.b());
    }

    private boolean b(i iVar) {
        iVar.a(o());
        iVar.g = new h(iVar.l);
        iVar.f229c = 81;
        return true;
    }

    private boolean b(i iVar, KeyEvent keyEvent) {
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        DecorContentParent decorContentParent3;
        if (this.R) {
            return false;
        }
        if (iVar.m) {
            return true;
        }
        i iVar2 = this.M;
        if (iVar2 != null && iVar2 != iVar) {
            a(iVar2, false);
        }
        Window.Callback windowCallback = getWindowCallback();
        if (windowCallback != null) {
            iVar.i = windowCallback.onCreatePanelView(iVar.f227a);
        }
        int i2 = iVar.f227a;
        boolean z = i2 == 0 || i2 == 108;
        if (z && (decorContentParent3 = this.q) != null) {
            decorContentParent3.setMenuPrepared();
        }
        if (iVar.i == null && (!z || !(t() instanceof ToolbarActionBar))) {
            if (iVar.j == null || iVar.r) {
                if (iVar.j == null && (!c(iVar) || iVar.j == null)) {
                    return false;
                }
                if (z && this.q != null) {
                    if (this.r == null) {
                        this.r = new b();
                    }
                    this.q.setMenu(iVar.j, this.r);
                }
                iVar.j.s();
                if (!windowCallback.onCreatePanelMenu(iVar.f227a, iVar.j)) {
                    iVar.a((MenuBuilder) null);
                    if (z && (decorContentParent = this.q) != null) {
                        decorContentParent.setMenu(null, this.r);
                    }
                    return false;
                }
                iVar.r = false;
            }
            iVar.j.s();
            Bundle bundle = iVar.s;
            if (bundle != null) {
                iVar.j.a(bundle);
                iVar.s = null;
            }
            if (!windowCallback.onPreparePanel(0, iVar.i, iVar.j)) {
                if (z && (decorContentParent2 = this.q) != null) {
                    decorContentParent2.setMenu(null, this.r);
                }
                iVar.j.r();
                return false;
            }
            iVar.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            iVar.j.setQwertyMode(iVar.p);
            iVar.j.r();
        }
        iVar.m = true;
        iVar.n = false;
        this.M = iVar;
        return true;
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.k.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ViewCompat.B((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private void a(i iVar, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (iVar.o || this.R) {
            return;
        }
        if (iVar.f227a == 0) {
            if ((this.j.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback windowCallback = getWindowCallback();
        if (windowCallback != null && !windowCallback.onMenuOpened(iVar.f227a, iVar.j)) {
            a(iVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.j.getSystemService("window");
        if (windowManager != null && b(iVar, keyEvent)) {
            if (iVar.g != null && !iVar.q) {
                View view = iVar.i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i2 = -1;
                }
                iVar.n = false;
                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i2, -2, iVar.f230d, iVar.f231e, 1002, 8519680, -3);
                layoutParams2.gravity = iVar.f229c;
                layoutParams2.windowAnimations = iVar.f232f;
                windowManager.addView(iVar.g, layoutParams2);
                iVar.o = true;
            }
            ViewGroup viewGroup = iVar.g;
            if (viewGroup == null) {
                if (!b(iVar) || iVar.g == null) {
                    return;
                }
            } else if (iVar.q && viewGroup.getChildCount() > 0) {
                iVar.g.removeAllViews();
            }
            if (!a(iVar) || !iVar.a()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = iVar.h.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
            }
            iVar.g.setBackgroundResource(iVar.f228b);
            ViewParent parent = iVar.h.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(iVar.h);
            }
            iVar.g.addView(iVar.h, layoutParams3);
            if (!iVar.h.hasFocus()) {
                iVar.h.requestFocus();
            }
            i2 = -2;
            iVar.n = false;
            WindowManager.LayoutParams layoutParams22 = new WindowManager.LayoutParams(i2, -2, iVar.f230d, iVar.f231e, 1002, 8519680, -3);
            layoutParams22.gravity = iVar.f229c;
            layoutParams22.windowAnimations = iVar.f232f;
            windowManager.addView(iVar.g, layoutParams22);
            iVar.o = true;
        }
    }

    void b(MenuBuilder menuBuilder) {
        if (this.K) {
            return;
        }
        this.K = true;
        this.q.dismissPopups();
        Window.Callback windowCallback = getWindowCallback();
        if (windowCallback != null && !this.R) {
            windowCallback.onPanelClosed(108, menuBuilder);
        }
        this.K = false;
    }

    private void a(MenuBuilder menuBuilder, boolean z) {
        DecorContentParent decorContentParent = this.q;
        if (decorContentParent != null && decorContentParent.canShowOverflowMenu() && (!ViewConfiguration.get(this.j).hasPermanentMenuKey() || this.q.isOverflowMenuShowPending())) {
            Window.Callback windowCallback = getWindowCallback();
            if (this.q.isOverflowMenuShowing() && z) {
                this.q.hideOverflowMenu();
                if (this.R) {
                    return;
                }
                windowCallback.onPanelClosed(108, a(0, true).j);
                return;
            }
            if (windowCallback == null || this.R) {
                return;
            }
            if (this.Y && (this.Z & 1) != 0) {
                this.k.getDecorView().removeCallbacks(this.aa);
                this.aa.run();
            }
            i iVarA = a(0, true);
            MenuBuilder menuBuilder2 = iVarA.j;
            if (menuBuilder2 == null || iVarA.r || !windowCallback.onPreparePanel(0, iVarA.i, menuBuilder2)) {
                return;
            }
            windowCallback.onMenuOpened(108, iVarA.j);
            this.q.showOverflowMenu();
            return;
        }
        i iVarA2 = a(0, true);
        iVarA2.q = true;
        a(iVarA2, false);
        a(iVarA2, (KeyEvent) null);
    }

    private boolean b(boolean z) {
        if (this.R) {
            return false;
        }
        int iW = w();
        boolean zB = b(g(iW), z);
        if (iW == 0) {
            p().e();
        } else {
            f fVar = this.W;
            if (fVar != null) {
                fVar.a();
            }
        }
        if (iW == 3) {
            B().e();
        } else {
            f fVar2 = this.X;
            if (fVar2 != null) {
                fVar2.a();
            }
        }
        return zB;
    }

    private boolean b(int i2, boolean z) {
        int i3 = this.j.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        boolean z2 = true;
        int i4 = i2 != 1 ? i2 != 2 ? i3 : 32 : 16;
        boolean zD = D();
        boolean z3 = false;
        if ((h || i4 != i3) && !zD && Build.VERSION.SDK_INT >= 17 && !this.O && (this.i instanceof ContextThemeWrapper)) {
            Configuration configuration = new Configuration();
            configuration.uiMode = (configuration.uiMode & (-49)) | i4;
            try {
                ((ContextThemeWrapper) this.i).applyOverrideConfiguration(configuration);
                z3 = true;
            } catch (IllegalStateException e2) {
                Log.e("AppCompatDelegate", "updateForNightMode. Calling applyOverrideConfiguration() failed with an exception. Will fall back to using Resources.updateConfiguration()", e2);
            }
        }
        int i5 = this.j.getResources().getConfiguration().uiMode & 48;
        if (!z3 && i5 != i4 && z && !zD && this.O && (Build.VERSION.SDK_INT >= 17 || this.P)) {
            Object obj = this.i;
            if (obj instanceof Activity) {
                ActivityCompat.d((Activity) obj);
                z3 = true;
            }
        }
        if (z3 || i5 == i4) {
            z2 = z3;
        } else {
            c(i4, zD);
        }
        if (z2) {
            Object obj2 = this.i;
            if (obj2 instanceof AppCompatActivity) {
                ((AppCompatActivity) obj2).onNightModeChanged(i2);
            }
        }
        return z2;
    }

    private boolean a(i iVar) {
        View view = iVar.i;
        if (view != null) {
            iVar.h = view;
            return true;
        }
        if (iVar.j == null) {
            return false;
        }
        if (this.s == null) {
            this.s = new j();
        }
        iVar.h = (View) iVar.a(this.s);
        return iVar.h != null;
    }

    @Override // androidx.appcompat.app.l
    public final C0281a.InterfaceC0002a b() {
        return new a();
    }

    void a(i iVar, boolean z) {
        ViewGroup viewGroup;
        DecorContentParent decorContentParent;
        if (z && iVar.f227a == 0 && (decorContentParent = this.q) != null && decorContentParent.isOverflowMenuShowing()) {
            b(iVar.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.j.getSystemService("window");
        if (windowManager != null && iVar.o && (viewGroup = iVar.g) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                a(iVar.f227a, iVar, null);
            }
        }
        iVar.m = false;
        iVar.n = false;
        iVar.o = false;
        iVar.h = null;
        iVar.q = true;
        if (this.M == iVar) {
            this.M = null;
        }
    }

    void a(int i2, i iVar, Menu menu) {
        if (menu == null) {
            if (iVar == null && i2 >= 0) {
                i[] iVarArr = this.L;
                if (i2 < iVarArr.length) {
                    iVar = iVarArr[i2];
                }
            }
            if (iVar != null) {
                menu = iVar.j;
            }
        }
        if ((iVar == null || iVar.o) && !this.R) {
            this.l.a().onPanelClosed(i2, menu);
        }
    }

    i a(Menu menu) {
        i[] iVarArr = this.L;
        int length = iVarArr != null ? iVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            i iVar = iVarArr[i2];
            if (iVar != null && iVar.j == menu) {
                return iVar;
            }
        }
        return null;
    }

    protected i a(int i2, boolean z) {
        i[] iVarArr = this.L;
        if (iVarArr == null || iVarArr.length <= i2) {
            i[] iVarArr2 = new i[i2 + 1];
            if (iVarArr != null) {
                System.arraycopy(iVarArr, 0, iVarArr2, 0, iVarArr.length);
            }
            this.L = iVarArr2;
            iVarArr = iVarArr2;
        }
        i iVar = iVarArr[i2];
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(i2);
        iVarArr[i2] = iVar2;
        return iVar2;
    }

    private boolean a(i iVar, int i2, KeyEvent keyEvent, int i3) {
        MenuBuilder menuBuilder;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((iVar.m || b(iVar, keyEvent)) && (menuBuilder = iVar.j) != null) {
            zPerformShortcut = menuBuilder.performShortcut(i2, keyEvent, i3);
        }
        if (zPerformShortcut && (i3 & 1) == 0 && this.q == null) {
            a(iVar, true);
        }
        return zPerformShortcut;
    }
}
