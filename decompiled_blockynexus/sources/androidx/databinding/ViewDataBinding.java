package androidx.databinding;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.CallbackRegistry;
import androidx.databinding.Observable;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;
import androidx.databinding.library.R;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import cn.qqtheme.framework.widget.WheelView;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewDataBinding extends BaseObservable {
    public static final String BINDING_TAG_PREFIX = "binding_";
    private static final a CREATE_LIST_LISTENER;
    private static final a CREATE_LIVE_DATA_LISTENER;
    private static final a CREATE_MAP_LISTENER;
    private static final a CREATE_PROPERTY_LISTENER;
    private static final int HALTED = 2;
    private static final int REBIND = 1;
    private static final CallbackRegistry.NotifierCallback<j, ViewDataBinding, Void> REBIND_NOTIFIER;
    private static final int REBOUND = 3;
    private static final View.OnAttachStateChangeListener ROOT_REATTACHED_LISTENER;
    private static final boolean USE_CHOREOGRAPHER;
    private static final ReferenceQueue<ViewDataBinding> sReferenceQueue;
    protected final androidx.databinding.d mBindingComponent;
    private Choreographer mChoreographer;
    private ViewDataBinding mContainingBinding;
    private final Choreographer.FrameCallback mFrameCallback;
    private boolean mInLiveDataRegisterObserver;
    private boolean mIsExecutingPendingBindings;
    private androidx.lifecycle.g mLifecycleOwner;
    private g[] mLocalFieldObservers;
    private OnStartListener mOnStartListener;
    private boolean mPendingRebind;
    private CallbackRegistry<j, ViewDataBinding, Void> mRebindCallbacks;
    private boolean mRebindHalted;
    private final Runnable mRebindRunnable;
    private final View mRoot;
    private Handler mUIThreadHandler;
    static int SDK_INT = Build.VERSION.SDK_INT;
    private static final int BINDING_NUMBER_START = 8;

    static class OnStartListener implements androidx.lifecycle.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WeakReference<ViewDataBinding> f1332a;

        /* synthetic */ OnStartListener(ViewDataBinding viewDataBinding, l lVar) {
            this(viewDataBinding);
        }

        @androidx.lifecycle.o(Lifecycle.Event.ON_START)
        public void onStart() {
            ViewDataBinding viewDataBinding = this.f1332a.get();
            if (viewDataBinding != null) {
                viewDataBinding.executePendingBindings();
            }
        }

        private OnStartListener(ViewDataBinding viewDataBinding) {
            this.f1332a = new WeakReference<>(viewDataBinding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface a {
        g a(ViewDataBinding viewDataBinding, int i);
    }

    protected static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[][] f1333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[][] f1334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[][] f1335c;

        public b(int i) {
            this.f1333a = new String[i][];
            this.f1334b = new int[i][];
            this.f1335c = new int[i][];
        }

        public void a(int i, String[] strArr, int[] iArr, int[] iArr2) {
            this.f1333a[i] = strArr;
            this.f1334b[i] = iArr;
            this.f1335c[i] = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c implements androidx.lifecycle.n, d<LiveData<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final g<LiveData<?>> f1336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        androidx.lifecycle.g f1337b;

        public c(ViewDataBinding viewDataBinding, int i) {
            this.f1336a = new g<>(viewDataBinding, i, this);
        }

        @Override // androidx.lifecycle.n
        public void c(Object obj) {
            ViewDataBinding viewDataBindingA = this.f1336a.a();
            if (viewDataBindingA != null) {
                g<LiveData<?>> gVar = this.f1336a;
                viewDataBindingA.handleFieldChange(gVar.f1341b, gVar.b(), 0);
            }
        }

        @Override // androidx.databinding.ViewDataBinding.d
        public void a(androidx.lifecycle.g gVar) {
            LiveData<?> liveDataB = this.f1336a.b();
            if (liveDataB != null) {
                if (this.f1337b != null) {
                    liveDataB.a((androidx.lifecycle.n<? super Object>) this);
                }
                if (gVar != null) {
                    liveDataB.a(gVar, this);
                }
            }
            this.f1337b = gVar;
        }

        @Override // androidx.databinding.ViewDataBinding.d
        /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void a(LiveData<?> liveData) {
            liveData.a((androidx.lifecycle.n<? super Object>) this);
        }

        public g<LiveData<?>> a() {
            return this.f1336a;
        }

        @Override // androidx.databinding.ViewDataBinding.d
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void b(LiveData<?> liveData) {
            androidx.lifecycle.g gVar = this.f1337b;
            if (gVar != null) {
                liveData.a(gVar, this);
            }
        }
    }

    private interface d<T> {
        void a(androidx.lifecycle.g gVar);

        void a(T t);

        void b(T t);
    }

    protected static abstract class e extends Observable.a implements androidx.databinding.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f1338a;

        @Override // androidx.databinding.Observable.a
        public void onPropertyChanged(Observable observable, int i) {
            if (i == this.f1338a || i == 0) {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class f extends ObservableList.a implements d<ObservableList> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final g<ObservableList> f1339a;

        public f(ViewDataBinding viewDataBinding, int i) {
            this.f1339a = new g<>(viewDataBinding, i, this);
        }

        @Override // androidx.databinding.ViewDataBinding.d
        public void a(androidx.lifecycle.g gVar) {
        }

        @Override // androidx.databinding.ViewDataBinding.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(ObservableList observableList) {
            observableList.removeOnListChangedCallback(this);
        }

        public g<ObservableList> a() {
            return this.f1339a;
        }

        @Override // androidx.databinding.ViewDataBinding.d
        public void b(ObservableList observableList) {
            observableList.addOnListChangedCallback(this);
        }

        @Override // androidx.databinding.ObservableList.a
        public void c(ObservableList observableList, int i, int i2) {
            a(observableList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.databinding.ObservableList.a
        public void a(ObservableList observableList) {
            ObservableList observableListB;
            ViewDataBinding viewDataBindingA = this.f1339a.a();
            if (viewDataBindingA != null && (observableListB = this.f1339a.b()) == observableList) {
                viewDataBindingA.handleFieldChange(this.f1339a.f1341b, observableListB, 0);
            }
        }

        @Override // androidx.databinding.ObservableList.a
        public void b(ObservableList observableList, int i, int i2) {
            a(observableList);
        }

        @Override // androidx.databinding.ObservableList.a
        public void a(ObservableList observableList, int i, int i2) {
            a(observableList);
        }

        @Override // androidx.databinding.ObservableList.a
        public void a(ObservableList observableList, int i, int i2, int i3) {
            a(observableList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class g<T> extends WeakReference<ViewDataBinding> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d<T> f1340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final int f1341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private T f1342c;

        public g(ViewDataBinding viewDataBinding, int i, d<T> dVar) {
            super(viewDataBinding, ViewDataBinding.sReferenceQueue);
            this.f1341b = i;
            this.f1340a = dVar;
        }

        public void a(androidx.lifecycle.g gVar) {
            this.f1340a.a(gVar);
        }

        public T b() {
            return this.f1342c;
        }

        public boolean c() {
            boolean z;
            T t = this.f1342c;
            if (t != null) {
                this.f1340a.a(t);
                z = true;
            } else {
                z = false;
            }
            this.f1342c = null;
            return z;
        }

        public void a(T t) {
            c();
            this.f1342c = t;
            T t2 = this.f1342c;
            if (t2 != null) {
                this.f1340a.b(t2);
            }
        }

        protected ViewDataBinding a() {
            ViewDataBinding viewDataBinding = (ViewDataBinding) get();
            if (viewDataBinding == null) {
                c();
            }
            return viewDataBinding;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class h extends ObservableMap.a implements d<ObservableMap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final g<ObservableMap> f1343a;

        public h(ViewDataBinding viewDataBinding, int i) {
            this.f1343a = new g<>(viewDataBinding, i, this);
        }

        @Override // androidx.databinding.ViewDataBinding.d
        public void a(androidx.lifecycle.g gVar) {
        }

        public g<ObservableMap> a() {
            return this.f1343a;
        }

        @Override // androidx.databinding.ViewDataBinding.d
        /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void a(ObservableMap observableMap) {
            observableMap.removeOnMapChangedCallback(this);
        }

        @Override // androidx.databinding.ViewDataBinding.d
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void b(ObservableMap observableMap) {
            observableMap.addOnMapChangedCallback(this);
        }

        @Override // androidx.databinding.ObservableMap.a
        public void a(ObservableMap observableMap, Object obj) {
            ViewDataBinding viewDataBindingA = this.f1343a.a();
            if (viewDataBindingA == null || observableMap != this.f1343a.b()) {
                return;
            }
            viewDataBindingA.handleFieldChange(this.f1343a.f1341b, observableMap, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class i extends Observable.a implements d<Observable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final g<Observable> f1344a;

        public i(ViewDataBinding viewDataBinding, int i) {
            this.f1344a = new g<>(viewDataBinding, i, this);
        }

        @Override // androidx.databinding.ViewDataBinding.d
        public void a(androidx.lifecycle.g gVar) {
        }

        @Override // androidx.databinding.Observable.a
        public void onPropertyChanged(Observable observable, int i) {
            ViewDataBinding viewDataBindingA = this.f1344a.a();
            if (viewDataBindingA != null && this.f1344a.b() == observable) {
                viewDataBindingA.handleFieldChange(this.f1344a.f1341b, observable, i);
            }
        }

        @Override // androidx.databinding.ViewDataBinding.d
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void b(Observable observable) {
            observable.addOnPropertyChangedCallback(this);
        }

        public g<Observable> b() {
            return this.f1344a;
        }

        @Override // androidx.databinding.ViewDataBinding.d
        /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void a(Observable observable) {
            observable.removeOnPropertyChangedCallback(this);
        }
    }

    static {
        USE_CHOREOGRAPHER = SDK_INT >= 16;
        CREATE_PROPERTY_LISTENER = new l();
        CREATE_LIST_LISTENER = new m();
        CREATE_MAP_LISTENER = new n();
        CREATE_LIVE_DATA_LISTENER = new o();
        REBIND_NOTIFIER = new CallbackRegistry.NotifierCallback<j, ViewDataBinding, Void>() { // from class: androidx.databinding.ViewDataBinding.5
            @Override // androidx.databinding.CallbackRegistry.NotifierCallback
            public void onNotifyCallback(j jVar, ViewDataBinding viewDataBinding, int i2, Void r4) {
                if (i2 == 1) {
                    if (jVar.c(viewDataBinding)) {
                        return;
                    }
                    viewDataBinding.mRebindHalted = true;
                } else if (i2 == 2) {
                    jVar.b(viewDataBinding);
                } else {
                    if (i2 != 3) {
                        return;
                    }
                    jVar.a(viewDataBinding);
                }
            }
        };
        sReferenceQueue = new ReferenceQueue<>();
        if (Build.VERSION.SDK_INT < 19) {
            ROOT_REATTACHED_LISTENER = null;
        } else {
            ROOT_REATTACHED_LISTENER = new p();
        }
    }

    protected ViewDataBinding(androidx.databinding.d dVar, View view, int i2) {
        this.mRebindRunnable = new q(this);
        this.mPendingRebind = false;
        this.mRebindHalted = false;
        this.mBindingComponent = dVar;
        this.mLocalFieldObservers = new g[i2];
        this.mRoot = view;
        if (Looper.myLooper() == null) {
            throw new IllegalStateException("DataBinding must be created in view's UI Thread");
        }
        if (USE_CHOREOGRAPHER) {
            this.mChoreographer = Choreographer.getInstance();
            this.mFrameCallback = new r(this);
        } else {
            this.mFrameCallback = null;
            this.mUIThreadHandler = new Handler(Looper.myLooper());
        }
    }

    protected static ViewDataBinding bind(Object obj, View view, int i2) {
        return androidx.databinding.e.a(checkAndCastToBindingComponent(obj), view, i2);
    }

    private static androidx.databinding.d checkAndCastToBindingComponent(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof androidx.databinding.d) {
            return (androidx.databinding.d) obj;
        }
        throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
    }

    private void executeBindingsInternal() {
        if (this.mIsExecutingPendingBindings) {
            requestRebind();
            return;
        }
        if (hasPendingBindings()) {
            this.mIsExecutingPendingBindings = true;
            this.mRebindHalted = false;
            CallbackRegistry<j, ViewDataBinding, Void> callbackRegistry = this.mRebindCallbacks;
            if (callbackRegistry != null) {
                callbackRegistry.a(this, 1, null);
                if (this.mRebindHalted) {
                    this.mRebindCallbacks.a(this, 2, null);
                }
            }
            if (!this.mRebindHalted) {
                executeBindings();
                CallbackRegistry<j, ViewDataBinding, Void> callbackRegistry2 = this.mRebindCallbacks;
                if (callbackRegistry2 != null) {
                    callbackRegistry2.a(this, 3, null);
                }
            }
            this.mIsExecutingPendingBindings = false;
        }
    }

    protected static void executeBindingsOn(ViewDataBinding viewDataBinding) {
        viewDataBinding.executeBindingsInternal();
    }

    private static int findIncludeIndex(String str, int i2, b bVar, int i3) {
        CharSequence charSequenceSubSequence = str.subSequence(str.indexOf(47) + 1, str.length() - 2);
        String[] strArr = bVar.f1333a[i3];
        int length = strArr.length;
        while (i2 < length) {
            if (TextUtils.equals(charSequenceSubSequence, strArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private static int findLastMatching(ViewGroup viewGroup, int i2) {
        String str = (String) viewGroup.getChildAt(i2).getTag();
        String strSubstring = str.substring(0, str.length() - 1);
        int length = strSubstring.length();
        int childCount = viewGroup.getChildCount();
        for (int i3 = i2 + 1; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            String str2 = childAt.getTag() instanceof String ? (String) childAt.getTag() : null;
            if (str2 != null && str2.startsWith(strSubstring)) {
                if (str2.length() == str.length() && str2.charAt(str2.length() - 1) == '0') {
                    return i2;
                }
                if (isNumeric(str2, length)) {
                    i2 = i3;
                }
            }
        }
        return i2;
    }

    static ViewDataBinding getBinding(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(R.id.dataBinding);
        }
        return null;
    }

    public static int getBuildSdkInt() {
        return SDK_INT;
    }

    protected static int getColorFromResource(View view, int i2) {
        return Build.VERSION.SDK_INT >= 23 ? view.getContext().getColor(i2) : view.getResources().getColor(i2);
    }

    protected static ColorStateList getColorStateListFromResource(View view, int i2) {
        return Build.VERSION.SDK_INT >= 23 ? view.getContext().getColorStateList(i2) : view.getResources().getColorStateList(i2);
    }

    protected static Drawable getDrawableFromResource(View view, int i2) {
        return Build.VERSION.SDK_INT >= 21 ? view.getContext().getDrawable(i2) : view.getResources().getDrawable(i2);
    }

    protected static <K, T> T getFrom(Map<K, T> map, K k) {
        if (map == null) {
            return null;
        }
        return map.get(k);
    }

    protected static <T> T getFromArray(T[] tArr, int i2) {
        if (tArr == null || i2 < 0 || i2 >= tArr.length) {
            return null;
        }
        return tArr[i2];
    }

    protected static <T> T getFromList(List<T> list, int i2) {
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return list.get(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFieldChange(int i2, Object obj, int i3) {
        if (!this.mInLiveDataRegisterObserver && onFieldChange(i2, obj, i3)) {
            requestRebind();
        }
    }

    protected static <T extends ViewDataBinding> T inflateInternal(LayoutInflater layoutInflater, int i2, ViewGroup viewGroup, boolean z, Object obj) {
        return (T) androidx.databinding.e.a(layoutInflater, i2, viewGroup, z, checkAndCastToBindingComponent(obj));
    }

    private static boolean isNumeric(String str, int i2) {
        int length = str.length();
        if (length == i2) {
            return false;
        }
        while (i2 < length) {
            if (!Character.isDigit(str.charAt(i2))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    protected static Object[] mapBindings(androidx.databinding.d dVar, View view, int i2, b bVar, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i2];
        mapBindings(dVar, view, objArr, bVar, sparseIntArray, true);
        return objArr;
    }

    protected static boolean parse(String str, boolean z) {
        return str == null ? z : Boolean.parseBoolean(str);
    }

    private static int parseTagInt(String str, int i2) {
        int iCharAt = 0;
        while (i2 < str.length()) {
            iCharAt = (iCharAt * 10) + (str.charAt(i2) - '0');
            i2++;
        }
        return iCharAt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processReferenceQueue() {
        while (true) {
            Reference<? extends ViewDataBinding> referencePoll = sReferenceQueue.poll();
            if (referencePoll == null) {
                return;
            }
            if (referencePoll instanceof g) {
                ((g) referencePoll).c();
            }
        }
    }

    protected static int safeUnbox(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    protected static void setBindingInverseListener(ViewDataBinding viewDataBinding, androidx.databinding.f fVar, e eVar) {
        if (fVar != eVar) {
            if (fVar != null) {
                viewDataBinding.removeOnPropertyChangedCallback((e) fVar);
            }
            if (eVar != null) {
                viewDataBinding.addOnPropertyChangedCallback(eVar);
            }
        }
    }

    protected static <T> void setTo(T[] tArr, int i2, T t) {
        if (tArr == null || i2 < 0 || i2 >= tArr.length) {
            return;
        }
        tArr[i2] = t;
    }

    private boolean updateRegistration(int i2, Object obj, a aVar) {
        if (obj == null) {
            return unregisterFrom(i2);
        }
        g gVar = this.mLocalFieldObservers[i2];
        if (gVar == null) {
            registerTo(i2, obj, aVar);
            return true;
        }
        if (gVar.b() == obj) {
            return false;
        }
        unregisterFrom(i2);
        registerTo(i2, obj, aVar);
        return true;
    }

    public void addOnRebindCallback(j jVar) {
        if (this.mRebindCallbacks == null) {
            this.mRebindCallbacks = new CallbackRegistry<>(REBIND_NOTIFIER);
        }
        this.mRebindCallbacks.a(jVar);
    }

    protected void ensureBindingComponentIsNotNull(Class<?> cls) {
        if (this.mBindingComponent != null) {
            return;
        }
        throw new IllegalStateException("Required DataBindingComponent is null in class " + getClass().getSimpleName() + ". A BindingAdapter in " + cls.getCanonicalName() + " is not static and requires an object to use, retrieved from the DataBindingComponent. If you don't use an inflation method taking a DataBindingComponent, use DataBindingUtil.setDefaultComponent or make all BindingAdapter methods static.");
    }

    protected abstract void executeBindings();

    public void executePendingBindings() {
        ViewDataBinding viewDataBinding = this.mContainingBinding;
        if (viewDataBinding == null) {
            executeBindingsInternal();
        } else {
            viewDataBinding.executePendingBindings();
        }
    }

    void forceExecuteBindings() {
        executeBindings();
    }

    public androidx.lifecycle.g getLifecycleOwner() {
        return this.mLifecycleOwner;
    }

    protected Object getObservedField(int i2) {
        g gVar = this.mLocalFieldObservers[i2];
        if (gVar == null) {
            return null;
        }
        return gVar.b();
    }

    public View getRoot() {
        return this.mRoot;
    }

    public abstract boolean hasPendingBindings();

    public abstract void invalidateAll();

    protected abstract boolean onFieldChange(int i2, Object obj, int i3);

    protected void registerTo(int i2, Object obj, a aVar) {
        if (obj == null) {
            return;
        }
        g gVarA = this.mLocalFieldObservers[i2];
        if (gVarA == null) {
            gVarA = aVar.a(this, i2);
            this.mLocalFieldObservers[i2] = gVarA;
            androidx.lifecycle.g gVar = this.mLifecycleOwner;
            if (gVar != null) {
                gVarA.a(gVar);
            }
        }
        gVarA.a(obj);
    }

    public void removeOnRebindCallback(j jVar) {
        CallbackRegistry<j, ViewDataBinding, Void> callbackRegistry = this.mRebindCallbacks;
        if (callbackRegistry != null) {
            callbackRegistry.b(jVar);
        }
    }

    protected void requestRebind() {
        ViewDataBinding viewDataBinding = this.mContainingBinding;
        if (viewDataBinding != null) {
            viewDataBinding.requestRebind();
            return;
        }
        androidx.lifecycle.g gVar = this.mLifecycleOwner;
        if (gVar == null || gVar.getLifecycle().a().isAtLeast(Lifecycle.State.STARTED)) {
            synchronized (this) {
                if (this.mPendingRebind) {
                    return;
                }
                this.mPendingRebind = true;
                if (USE_CHOREOGRAPHER) {
                    this.mChoreographer.postFrameCallback(this.mFrameCallback);
                } else {
                    this.mUIThreadHandler.post(this.mRebindRunnable);
                }
            }
        }
    }

    protected void setContainedBinding(ViewDataBinding viewDataBinding) {
        if (viewDataBinding != null) {
            viewDataBinding.mContainingBinding = this;
        }
    }

    public void setLifecycleOwner(androidx.lifecycle.g gVar) {
        androidx.lifecycle.g gVar2 = this.mLifecycleOwner;
        if (gVar2 == gVar) {
            return;
        }
        if (gVar2 != null) {
            gVar2.getLifecycle().b(this.mOnStartListener);
        }
        this.mLifecycleOwner = gVar;
        if (gVar != null) {
            if (this.mOnStartListener == null) {
                this.mOnStartListener = new OnStartListener(this, null);
            }
            gVar.getLifecycle().a(this.mOnStartListener);
        }
        for (g gVar3 : this.mLocalFieldObservers) {
            if (gVar3 != null) {
                gVar3.a(gVar);
            }
        }
    }

    protected void setRootTag(View view) {
        view.setTag(R.id.dataBinding, this);
    }

    public abstract boolean setVariable(int i2, Object obj);

    public void unbind() {
        for (g gVar : this.mLocalFieldObservers) {
            if (gVar != null) {
                gVar.c();
            }
        }
    }

    protected boolean unregisterFrom(int i2) {
        g gVar = this.mLocalFieldObservers[i2];
        if (gVar != null) {
            return gVar.c();
        }
        return false;
    }

    protected boolean updateLiveDataRegistration(int i2, LiveData<?> liveData) {
        this.mInLiveDataRegisterObserver = true;
        try {
            return updateRegistration(i2, liveData, CREATE_LIVE_DATA_LISTENER);
        } finally {
            this.mInLiveDataRegisterObserver = false;
        }
    }

    protected static byte parse(String str, byte b2) {
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b2;
        }
    }

    protected static long safeUnbox(Long l) {
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    protected void setRootTag(View[] viewArr) {
        for (View view : viewArr) {
            view.setTag(R.id.dataBinding, this);
        }
    }

    protected static boolean getFromArray(boolean[] zArr, int i2) {
        if (zArr == null || i2 < 0 || i2 >= zArr.length) {
            return false;
        }
        return zArr[i2];
    }

    protected static <T> T getFromList(SparseArray<T> sparseArray, int i2) {
        if (sparseArray == null || i2 < 0) {
            return null;
        }
        return sparseArray.get(i2);
    }

    protected static Object[] mapBindings(androidx.databinding.d dVar, View[] viewArr, int i2, b bVar, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i2];
        for (View view : viewArr) {
            mapBindings(dVar, view, objArr, bVar, sparseIntArray, true);
        }
        return objArr;
    }

    protected static short parse(String str, short s) {
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s;
        }
    }

    protected static short safeUnbox(Short sh) {
        if (sh == null) {
            return (short) 0;
        }
        return sh.shortValue();
    }

    protected static void setTo(boolean[] zArr, int i2, boolean z) {
        if (zArr == null || i2 < 0 || i2 >= zArr.length) {
            return;
        }
        zArr[i2] = z;
    }

    @TargetApi(16)
    protected static <T> T getFromList(LongSparseArray<T> longSparseArray, int i2) {
        if (longSparseArray == null || i2 < 0) {
            return null;
        }
        return longSparseArray.get(i2);
    }

    protected static int parse(String str, int i2) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    protected static byte safeUnbox(Byte b2) {
        if (b2 == null) {
            return (byte) 0;
        }
        return b2.byteValue();
    }

    protected static byte getFromArray(byte[] bArr, int i2) {
        if (bArr == null || i2 < 0 || i2 >= bArr.length) {
            return (byte) 0;
        }
        return bArr[i2];
    }

    protected static <T> T getFromList(a.a.f<T> fVar, int i2) {
        if (fVar == null || i2 < 0) {
            return null;
        }
        return fVar.b(i2);
    }

    protected static long parse(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    protected static char safeUnbox(Character ch) {
        if (ch == null) {
            return (char) 0;
        }
        return ch.charValue();
    }

    protected static void setTo(byte[] bArr, int i2, byte b2) {
        if (bArr == null || i2 < 0 || i2 >= bArr.length) {
            return;
        }
        bArr[i2] = b2;
    }

    protected static boolean getFromList(SparseBooleanArray sparseBooleanArray, int i2) {
        if (sparseBooleanArray == null || i2 < 0) {
            return false;
        }
        return sparseBooleanArray.get(i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void mapBindings(androidx.databinding.d r16, android.view.View r17, java.lang.Object[] r18, androidx.databinding.ViewDataBinding.b r19, android.util.SparseIntArray r20, boolean r21) {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.ViewDataBinding.mapBindings(androidx.databinding.d, android.view.View, java.lang.Object[], androidx.databinding.ViewDataBinding$b, android.util.SparseIntArray, boolean):void");
    }

    protected static float parse(String str, float f2) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f2;
        }
    }

    protected static double safeUnbox(Double d2) {
        if (d2 == null) {
            return 0.0d;
        }
        return d2.doubleValue();
    }

    protected static short getFromArray(short[] sArr, int i2) {
        if (sArr == null || i2 < 0 || i2 >= sArr.length) {
            return (short) 0;
        }
        return sArr[i2];
    }

    protected static int getFromList(SparseIntArray sparseIntArray, int i2) {
        if (sparseIntArray == null || i2 < 0) {
            return 0;
        }
        return sparseIntArray.get(i2);
    }

    protected static double parse(String str, double d2) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d2;
        }
    }

    protected static float safeUnbox(Float f2) {
        return f2 == null ? WheelView.DividerConfig.FILL : f2.floatValue();
    }

    protected static void setTo(short[] sArr, int i2, short s) {
        if (sArr == null || i2 < 0 || i2 >= sArr.length) {
            return;
        }
        sArr[i2] = s;
    }

    protected boolean updateRegistration(int i2, Observable observable) {
        return updateRegistration(i2, observable, CREATE_PROPERTY_LISTENER);
    }

    @TargetApi(18)
    protected static long getFromList(SparseLongArray sparseLongArray, int i2) {
        if (sparseLongArray == null || i2 < 0) {
            return 0L;
        }
        return sparseLongArray.get(i2);
    }

    protected static char parse(String str, char c2) {
        return (str == null || str.isEmpty()) ? c2 : str.charAt(0);
    }

    protected static boolean safeUnbox(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    protected boolean updateRegistration(int i2, ObservableList observableList) {
        return updateRegistration(i2, observableList, CREATE_LIST_LISTENER);
    }

    protected static char getFromArray(char[] cArr, int i2) {
        if (cArr == null || i2 < 0 || i2 >= cArr.length) {
            return (char) 0;
        }
        return cArr[i2];
    }

    protected static void setTo(char[] cArr, int i2, char c2) {
        if (cArr == null || i2 < 0 || i2 >= cArr.length) {
            return;
        }
        cArr[i2] = c2;
    }

    protected boolean updateRegistration(int i2, ObservableMap observableMap) {
        return updateRegistration(i2, observableMap, CREATE_MAP_LISTENER);
    }

    protected static int getFromArray(int[] iArr, int i2) {
        if (iArr == null || i2 < 0 || i2 >= iArr.length) {
            return 0;
        }
        return iArr[i2];
    }

    protected static void setTo(int[] iArr, int i2, int i3) {
        if (iArr == null || i2 < 0 || i2 >= iArr.length) {
            return;
        }
        iArr[i2] = i3;
    }

    protected static long getFromArray(long[] jArr, int i2) {
        if (jArr == null || i2 < 0 || i2 >= jArr.length) {
            return 0L;
        }
        return jArr[i2];
    }

    protected static void setTo(long[] jArr, int i2, long j) {
        if (jArr == null || i2 < 0 || i2 >= jArr.length) {
            return;
        }
        jArr[i2] = j;
    }

    protected ViewDataBinding(Object obj, View view, int i2) {
        this(checkAndCastToBindingComponent(obj), view, i2);
    }

    protected static float getFromArray(float[] fArr, int i2) {
        return (fArr == null || i2 < 0 || i2 >= fArr.length) ? WheelView.DividerConfig.FILL : fArr[i2];
    }

    protected static void setTo(float[] fArr, int i2, float f2) {
        if (fArr == null || i2 < 0 || i2 >= fArr.length) {
            return;
        }
        fArr[i2] = f2;
    }

    protected static double getFromArray(double[] dArr, int i2) {
        if (dArr == null || i2 < 0 || i2 >= dArr.length) {
            return 0.0d;
        }
        return dArr[i2];
    }

    protected static void setTo(double[] dArr, int i2, double d2) {
        if (dArr == null || i2 < 0 || i2 >= dArr.length) {
            return;
        }
        dArr[i2] = d2;
    }

    protected static <T> void setTo(List<T> list, int i2, T t) {
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return;
        }
        list.set(i2, t);
    }

    protected static <T> void setTo(SparseArray<T> sparseArray, int i2, T t) {
        if (sparseArray == null || i2 < 0 || i2 >= sparseArray.size()) {
            return;
        }
        sparseArray.put(i2, t);
    }

    @TargetApi(16)
    protected static <T> void setTo(LongSparseArray<T> longSparseArray, int i2, T t) {
        if (longSparseArray == null || i2 < 0 || i2 >= longSparseArray.size()) {
            return;
        }
        longSparseArray.put(i2, t);
    }

    protected static <T> void setTo(a.a.f<T> fVar, int i2, T t) {
        if (fVar == null || i2 < 0 || i2 >= fVar.c()) {
            return;
        }
        fVar.c(i2, t);
    }

    protected static void setTo(SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        if (sparseBooleanArray == null || i2 < 0 || i2 >= sparseBooleanArray.size()) {
            return;
        }
        sparseBooleanArray.put(i2, z);
    }

    protected static void setTo(SparseIntArray sparseIntArray, int i2, int i3) {
        if (sparseIntArray == null || i2 < 0 || i2 >= sparseIntArray.size()) {
            return;
        }
        sparseIntArray.put(i2, i3);
    }

    @TargetApi(18)
    protected static void setTo(SparseLongArray sparseLongArray, int i2, long j) {
        if (sparseLongArray == null || i2 < 0 || i2 >= sparseLongArray.size()) {
            return;
        }
        sparseLongArray.put(i2, j);
    }

    protected static <K, T> void setTo(Map<K, T> map, K k, T t) {
        if (map == null) {
            return;
        }
        map.put(k, t);
    }
}
