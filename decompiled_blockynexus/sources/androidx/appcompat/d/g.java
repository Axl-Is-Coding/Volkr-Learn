package androidx.appcompat.d;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.F;
import androidx.appcompat.widget.ia;
import androidx.core.view.AbstractC0314b;
import androidx.core.view.C0320h;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: SupportMenuInflater.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends MenuInflater {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Class<?>[] f374a = {Context.class};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Class<?>[] f375b = f374a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Object[] f376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Object[] f377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Context f378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f379f;

    /* JADX INFO: compiled from: SupportMenuInflater.java */
    private static class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Class<?>[] f380a = {MenuItem.class};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Object f381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Method f382c;

        public a(Object obj, String str) {
            this.f381b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f382c = cls.getMethod(str, f380a);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f382c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f382c.invoke(this.f381b, menuItem)).booleanValue();
                }
                this.f382c.invoke(this.f381b, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public g(Context context) {
        super(context);
        this.f378e = context;
        this.f376c = new Object[]{context};
        this.f377d = this.f376c;
    }

    private void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        int next = eventType;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (next == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (next != 2) {
                if (next == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z2 && name2.equals(str)) {
                        str = null;
                        z2 = false;
                    } else if (name2.equals("group")) {
                        bVar.d();
                    } else if (name2.equals("item")) {
                        if (!bVar.c()) {
                            AbstractC0314b abstractC0314b = bVar.A;
                            if (abstractC0314b == null || !abstractC0314b.a()) {
                                bVar.a();
                            } else {
                                bVar.b();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z = true;
                    }
                }
            } else if (!z2) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.a(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.b(attributeSet);
                } else if (name3.equals("menu")) {
                    a(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z2 = true;
                }
            }
            next = xmlPullParser.next();
        }
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof androidx.core.b.a.a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f378e.getResources().getLayout(i);
                    a(layout, Xml.asAttributeSet(layout), menu);
                } catch (XmlPullParserException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (IOException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } finally {
            if (layout != null) {
                layout.close();
            }
        }
    }

    /* JADX INFO: compiled from: SupportMenuInflater.java */
    private class b {
        AbstractC0314b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Menu f383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f384b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f385c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f386d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f387e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f388f;
        private boolean g;
        private boolean h;
        private int i;
        private int j;
        private CharSequence k;
        private CharSequence l;
        private int m;
        private char n;
        private int o;
        private char p;
        private int q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;

        public b(Menu menu) {
            this.f383a = menu;
            d();
        }

        public void a(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.f378e.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.f384b = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.f385c = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.f386d = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.f387e = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.f388f = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.g = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void b(AttributeSet attributeSet) {
            ia iaVarA = ia.a(g.this.f378e, attributeSet, R.styleable.MenuItem);
            this.i = iaVarA.g(R.styleable.MenuItem_android_id, 0);
            this.j = (iaVarA.d(R.styleable.MenuItem_android_menuCategory, this.f385c) & (-65536)) | (iaVarA.d(R.styleable.MenuItem_android_orderInCategory, this.f386d) & 65535);
            this.k = iaVarA.e(R.styleable.MenuItem_android_title);
            this.l = iaVarA.e(R.styleable.MenuItem_android_titleCondensed);
            this.m = iaVarA.g(R.styleable.MenuItem_android_icon, 0);
            this.n = a(iaVarA.d(R.styleable.MenuItem_android_alphabeticShortcut));
            this.o = iaVarA.d(R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.p = a(iaVarA.d(R.styleable.MenuItem_android_numericShortcut));
            this.q = iaVarA.d(R.styleable.MenuItem_numericModifiers, 4096);
            if (iaVarA.g(R.styleable.MenuItem_android_checkable)) {
                this.r = iaVarA.a(R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.r = this.f387e;
            }
            this.s = iaVarA.a(R.styleable.MenuItem_android_checked, false);
            this.t = iaVarA.a(R.styleable.MenuItem_android_visible, this.f388f);
            this.u = iaVarA.a(R.styleable.MenuItem_android_enabled, this.g);
            this.v = iaVarA.d(R.styleable.MenuItem_showAsAction, -1);
            this.z = iaVarA.d(R.styleable.MenuItem_android_onClick);
            this.w = iaVarA.g(R.styleable.MenuItem_actionLayout, 0);
            this.x = iaVarA.d(R.styleable.MenuItem_actionViewClass);
            this.y = iaVarA.d(R.styleable.MenuItem_actionProviderClass);
            boolean z = this.y != null;
            if (z && this.w == 0 && this.x == null) {
                this.A = (AbstractC0314b) a(this.y, g.f375b, g.this.f377d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = iaVarA.e(R.styleable.MenuItem_contentDescription);
            this.C = iaVarA.e(R.styleable.MenuItem_tooltipText);
            if (iaVarA.g(R.styleable.MenuItem_iconTintMode)) {
                this.E = F.a(iaVarA.d(R.styleable.MenuItem_iconTintMode, -1), this.E);
            } else {
                this.E = null;
            }
            if (iaVarA.g(R.styleable.MenuItem_iconTint)) {
                this.D = iaVarA.a(R.styleable.MenuItem_iconTint);
            } else {
                this.D = null;
            }
            iaVarA.a();
            this.h = false;
        }

        public boolean c() {
            return this.h;
        }

        public void d() {
            this.f384b = 0;
            this.f385c = 0;
            this.f386d = 0;
            this.f387e = 0;
            this.f388f = true;
            this.g = true;
        }

        private char a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private void a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i = this.v;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.z != null) {
                if (!g.this.f378e.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(g.this.a(), this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            boolean z2 = menuItem instanceof MenuItemImpl;
            if (z2) {
            }
            if (this.r >= 2) {
                if (z2) {
                    ((MenuItemImpl) menuItem).c(true);
                } else if (menuItem instanceof androidx.appcompat.view.menu.h) {
                    ((androidx.appcompat.view.menu.h) menuItem).a(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) a(str, g.f374a, g.this.f376c));
                z = true;
            }
            int i2 = this.w;
            if (i2 > 0) {
                if (!z) {
                    menuItem.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            AbstractC0314b abstractC0314b = this.A;
            if (abstractC0314b != null) {
                C0320h.a(menuItem, abstractC0314b);
            }
            C0320h.a(menuItem, this.B);
            C0320h.b(menuItem, this.C);
            C0320h.a(menuItem, this.n, this.o);
            C0320h.b(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                C0320h.a(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                C0320h.a(menuItem, colorStateList);
            }
        }

        public SubMenu b() {
            this.h = true;
            SubMenu subMenuAddSubMenu = this.f383a.addSubMenu(this.f384b, this.i, this.j, this.k);
            a(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public void a() {
            this.h = true;
            a(this.f383a.add(this.f384b, this.i, this.j, this.k));
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f378e.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }
    }

    Object a() {
        if (this.f379f == null) {
            this.f379f = a(this.f378e);
        }
        return this.f379f;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }
}
