package androidx.appcompat.d;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R;

/* JADX INFO: compiled from: ContextThemeWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Resources.Theme f360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LayoutInflater f361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Configuration f362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Resources f363e;

    public d() {
        super(null);
    }

    private Resources b() {
        if (this.f363e == null) {
            Configuration configuration = this.f362d;
            if (configuration == null) {
                this.f363e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.f363e = createConfigurationContext(configuration).getResources();
            }
        }
        return this.f363e;
    }

    private void c() {
        boolean z = this.f360b == null;
        if (z) {
            this.f360b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f360b.setTo(theme);
            }
        }
        a(this.f360b, this.f359a, z);
    }

    public int a() {
        return this.f359a;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f361c == null) {
            this.f361c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f361c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f360b;
        if (theme != null) {
            return theme;
        }
        if (this.f359a == 0) {
            this.f359a = R.style.Theme_AppCompat_Light;
        }
        c();
        return this.f360b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f359a != i) {
            this.f359a = i;
            c();
        }
    }

    public d(Context context, int i) {
        super(context);
        this.f359a = i;
    }

    protected void a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f360b = theme;
    }
}
