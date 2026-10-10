package androidx.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.C0344r;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.s;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements d, g, s, androidx.savedstate.c {
    private int mContentLayoutId;
    private final i mLifecycleRegistry;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final androidx.savedstate.b mSavedStateRegistryController;
    private C0344r mViewModelStore;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        C0344r f173b;

        a() {
        }
    }

    public ComponentActivity() {
        this.mLifecycleRegistry = new i(this);
        this.mSavedStateRegistryController = androidx.savedstate.b.a(this);
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new b(this));
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getLifecycle().a(new e() { // from class: androidx.activity.ComponentActivity.2
                @Override // androidx.lifecycle.e
                public void a(g gVar, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                        if (viewPeekDecorView != null) {
                            viewPeekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
        }
        getLifecycle().a(new e() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.e
            public void a(g gVar, Lifecycle.Event event) {
                if (event != Lifecycle.Event.ON_DESTROY || ComponentActivity.this.isChangingConfigurations()) {
                    return;
                }
                ComponentActivity.this.getViewModelStore().a();
            }
        });
        int i = Build.VERSION.SDK_INT;
        if (19 > i || i > 23) {
            return;
        }
        getLifecycle().a(new ImmLeaksCleaner(this));
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        a aVar = (a) getLastNonConfigurationInstance();
        if (aVar != null) {
            return aVar.f172a;
        }
        return null;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.g
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.d
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // androidx.savedstate.c
    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.a();
    }

    @Override // androidx.lifecycle.s
    public C0344r getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.mViewModelStore == null) {
            a aVar = (a) getLastNonConfigurationInstance();
            if (aVar != null) {
                this.mViewModelStore = aVar.f173b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new C0344r();
            }
        }
        return this.mViewModelStore;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.a();
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSavedStateRegistryController.a(bundle);
        ReportFragment.a(this);
        int i = this.mContentLayoutId;
        if (i != 0) {
            setContentView(i);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        a aVar;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        C0344r c0344r = this.mViewModelStore;
        if (c0344r == null && (aVar = (a) getLastNonConfigurationInstance()) != null) {
            c0344r = aVar.f173b;
        }
        if (c0344r == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        a aVar2 = new a();
        aVar2.f172a = objOnRetainCustomNonConfigurationInstance;
        aVar2.f173b = c0344r;
        return aVar2;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof i) {
            ((i) lifecycle).b(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.b(bundle);
    }

    public ComponentActivity(int i) {
        this();
        this.mContentLayoutId = i;
    }
}
