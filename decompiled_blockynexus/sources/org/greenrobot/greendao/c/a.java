package org.greenrobot.greendao.c;

import java.lang.reflect.Field;
import java.util.ArrayList;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.f;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

/* JADX INFO: compiled from: DaoConfig.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.greenrobot.greendao.b.a f23569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f[] f23571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f23572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f23573e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String[] f23574f;
    public final f g;
    public final boolean h;
    public final e i;
    private org.greenrobot.greendao.identityscope.a<?, ?> j;

    public a(org.greenrobot.greendao.b.a aVar, Class<? extends org.greenrobot.greendao.a<?, ?>> cls) {
        this.f23569a = aVar;
        try {
            this.f23570b = (String) cls.getField("TABLENAME").get(null);
            f[] fVarArrA = a(cls);
            this.f23571c = fVarArrA;
            this.f23572d = new String[fVarArrA.length];
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            f fVar = null;
            for (int i = 0; i < fVarArrA.length; i++) {
                f fVar2 = fVarArrA[i];
                String str = fVar2.f23634e;
                this.f23572d[i] = str;
                if (fVar2.f23633d) {
                    arrayList.add(str);
                    fVar = fVar2;
                } else {
                    arrayList2.add(str);
                }
            }
            this.f23574f = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
            this.f23573e = (String[]) arrayList.toArray(new String[arrayList.size()]);
            boolean z = true;
            this.g = this.f23573e.length == 1 ? fVar : null;
            this.i = new e(aVar, this.f23570b, this.f23572d, this.f23573e);
            if (this.g == null) {
                this.h = false;
                return;
            }
            Class<?> cls2 = this.g.f23631b;
            if (!cls2.equals(Long.TYPE) && !cls2.equals(Long.class) && !cls2.equals(Integer.TYPE) && !cls2.equals(Integer.class) && !cls2.equals(Short.TYPE) && !cls2.equals(Short.class) && !cls2.equals(Byte.TYPE) && !cls2.equals(Byte.class)) {
                z = false;
            }
            this.h = z;
        } catch (Exception e2) {
            throw new DaoException("Could not init DAOConfig", e2);
        }
    }

    private static f[] a(Class<? extends org.greenrobot.greendao.a<?, ?>> cls) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException {
        Field[] declaredFields = Class.forName(cls.getName() + "$Properties").getDeclaredFields();
        ArrayList<f> arrayList = new ArrayList();
        for (Field field : declaredFields) {
            if ((field.getModifiers() & 9) == 9) {
                Object obj = field.get(null);
                if (obj instanceof f) {
                    arrayList.add((f) obj);
                }
            }
        }
        f[] fVarArr = new f[arrayList.size()];
        for (f fVar : arrayList) {
            int i = fVar.f23630a;
            if (fVarArr[i] != null) {
                throw new DaoException("Duplicate property ordinals");
            }
            fVarArr[i] = fVar;
        }
        return fVarArr;
    }

    public void b() {
        org.greenrobot.greendao.identityscope.a<?, ?> aVar = this.j;
        if (aVar != null) {
            aVar.clear();
        }
    }

    public org.greenrobot.greendao.identityscope.a<?, ?> c() {
        return this.j;
    }

    public a clone() {
        return new a(this);
    }

    public void a(IdentityScopeType identityScopeType) {
        if (identityScopeType == IdentityScopeType.None) {
            this.j = null;
            return;
        }
        if (identityScopeType == IdentityScopeType.Session) {
            if (this.h) {
                this.j = new org.greenrobot.greendao.identityscope.b();
                return;
            } else {
                this.j = new org.greenrobot.greendao.identityscope.c();
                return;
            }
        }
        throw new IllegalArgumentException("Unsupported type: " + identityScopeType);
    }

    public a(a aVar) {
        this.f23569a = aVar.f23569a;
        this.f23570b = aVar.f23570b;
        this.f23571c = aVar.f23571c;
        this.f23572d = aVar.f23572d;
        this.f23573e = aVar.f23573e;
        this.f23574f = aVar.f23574f;
        this.g = aVar.g;
        this.i = aVar.i;
        this.h = aVar.h;
    }
}
