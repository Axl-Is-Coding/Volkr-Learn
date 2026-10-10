package c.t.m.g;

import android.content.SharedPreferences;
import java.util.Observable;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
class Ja extends Observable implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2933a = "cc_c_t_m_l_";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Ja f2934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile SharedPreferences f2935c;

    private Ja() {
        f2935c = _a.a(f2933a);
    }

    protected static void a(String str) {
        f2933a = "cc_c_t_m_l_".concat(String.valueOf(str));
    }

    protected final synchronized SharedPreferences b() {
        if (f2935c == null) {
            f2935c = _a.a(f2933a);
        }
        return f2935c;
    }

    protected final synchronized void c() {
        if (f2935c != null) {
            addObserver(Ha.a());
            f2935c.registerOnSharedPreferenceChangeListener(this);
        }
    }

    protected final synchronized void d() {
        if (f2935c != null) {
            f2935c.unregisterOnSharedPreferenceChangeListener(this);
            deleteObserver(Ha.a());
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        setChanged();
        notifyObservers(str);
    }

    protected static synchronized Ja a() {
        if (f2934b == null) {
            synchronized (Ja.class) {
                f2934b = new Ja();
            }
        }
        return f2934b;
    }
}
