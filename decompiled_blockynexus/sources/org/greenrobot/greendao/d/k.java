package org.greenrobot.greendao.d;

import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.DaoException;

/* JADX INFO: compiled from: WhereCondition.java */
/* JADX INFO: loaded from: classes5.dex */
public interface k {

    /* JADX INFO: compiled from: WhereCondition.java */
    public static class c extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final String f23625d;

        public c(String str, Object... objArr) {
            super(objArr);
            this.f23625d = str;
        }

        @Override // org.greenrobot.greendao.d.k
        public void a(StringBuilder sb, String str) {
            sb.append(this.f23625d);
        }
    }

    void a(StringBuilder sb, String str);

    void a(List<Object> list);

    /* JADX INFO: compiled from: WhereCondition.java */
    public static abstract class a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final boolean f23620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final Object f23621b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final Object[] f23622c;

        public a(Object obj) {
            this.f23621b = obj;
            this.f23620a = true;
            this.f23622c = null;
        }

        @Override // org.greenrobot.greendao.d.k
        public void a(List<Object> list) {
            if (this.f23620a) {
                list.add(this.f23621b);
                return;
            }
            Object[] objArr = this.f23622c;
            if (objArr != null) {
                for (Object obj : objArr) {
                    list.add(obj);
                }
            }
        }

        public a(Object[] objArr) {
            this.f23621b = null;
            this.f23620a = false;
            this.f23622c = objArr;
        }
    }

    /* JADX INFO: compiled from: WhereCondition.java */
    public static class b extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final org.greenrobot.greendao.f f23623d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f23624e;

        public b(org.greenrobot.greendao.f fVar, String str, Object obj) {
            super(a(fVar, obj));
            this.f23623d = fVar;
            this.f23624e = str;
        }

        private static Object a(org.greenrobot.greendao.f fVar, Object obj) {
            if (obj != null && obj.getClass().isArray()) {
                throw new DaoException("Illegal value: found array, but simple object required");
            }
            Class<?> cls = fVar.f23631b;
            if (cls == Date.class) {
                if (obj instanceof Date) {
                    return Long.valueOf(((Date) obj).getTime());
                }
                if (obj instanceof Long) {
                    return obj;
                }
                throw new DaoException("Illegal date value: expected java.util.Date or Long for value " + obj);
            }
            if (cls == Boolean.TYPE || cls == Boolean.class) {
                if (obj instanceof Boolean) {
                    return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
                }
                if (obj instanceof Number) {
                    int iIntValue = ((Number) obj).intValue();
                    if (iIntValue != 0 && iIntValue != 1) {
                        throw new DaoException("Illegal boolean value: numbers must be 0 or 1, but was " + obj);
                    }
                } else if (obj instanceof String) {
                    String str = (String) obj;
                    if ("TRUE".equalsIgnoreCase(str)) {
                        return 1;
                    }
                    if ("FALSE".equalsIgnoreCase(str)) {
                        return 0;
                    }
                    throw new DaoException("Illegal boolean value: Strings must be \"TRUE\" or \"FALSE\" (case insensitive), but was " + obj);
                }
            }
            return obj;
        }

        @Override // org.greenrobot.greendao.d.k
        public void a(StringBuilder sb, String str) {
            org.greenrobot.greendao.c.d.a(sb, str, this.f23623d);
            sb.append(this.f23624e);
        }
    }
}
