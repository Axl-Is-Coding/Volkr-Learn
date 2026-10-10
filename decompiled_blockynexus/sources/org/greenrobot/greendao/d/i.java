package org.greenrobot.greendao.d;

import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.DaoException;

/* JADX INFO: compiled from: QueryBuilder.java */
/* JADX INFO: loaded from: classes5.dex */
public class i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f23611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f23612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j<T> f23613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private StringBuilder f23614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<Object> f23615e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<f<T, ?>> f23616f;
    private final org.greenrobot.greendao.a<T, ?> g;
    private final String h;
    private Integer i;
    private Integer j;
    private boolean k;
    private String l;

    protected i(org.greenrobot.greendao.a<T, ?> aVar) {
        this(aVar, "T");
    }

    public static <T2> i<T2> a(org.greenrobot.greendao.a<T2, ?> aVar) {
        return new i<>(aVar);
    }

    private void d() {
        StringBuilder sb = this.f23614d;
        if (sb == null) {
            this.f23614d = new StringBuilder();
        } else if (sb.length() > 0) {
            this.f23614d.append(",");
        }
    }

    private StringBuilder e() {
        StringBuilder sb = new StringBuilder(org.greenrobot.greendao.c.d.a(this.g.getTablename(), this.h, this.g.getAllColumns(), this.k));
        a(sb, this.h);
        StringBuilder sb2 = this.f23614d;
        if (sb2 != null && sb2.length() > 0) {
            sb.append(" ORDER BY ");
            sb.append((CharSequence) this.f23614d);
        }
        return sb;
    }

    public i<T> b(org.greenrobot.greendao.f... fVarArr) {
        a(" DESC", fVarArr);
        return this;
    }

    public List<T> c() {
        return a().c();
    }

    protected i(org.greenrobot.greendao.a<T, ?> aVar, String str) {
        this.g = aVar;
        this.h = str;
        this.f23615e = new ArrayList();
        this.f23616f = new ArrayList();
        this.f23613c = new j<>(aVar, str);
        this.l = " COLLATE NOCASE";
    }

    private int b(StringBuilder sb) {
        if (this.j == null) {
            return -1;
        }
        if (this.i == null) {
            throw new IllegalStateException("Offset cannot be set without limit");
        }
        sb.append(" OFFSET ?");
        this.f23615e.add(this.j);
        return this.f23615e.size() - 1;
    }

    public i<T> a(k kVar, k... kVarArr) {
        this.f23613c.a(kVar, kVarArr);
        return this;
    }

    public k a(k kVar, k kVar2, k... kVarArr) {
        return this.f23613c.a(" AND ", kVar, kVar2, kVarArr);
    }

    public i<T> a(org.greenrobot.greendao.f... fVarArr) {
        a(" ASC", fVarArr);
        return this;
    }

    private void a(String str, org.greenrobot.greendao.f... fVarArr) {
        String str2;
        for (org.greenrobot.greendao.f fVar : fVarArr) {
            d();
            a(this.f23614d, fVar);
            if (String.class.equals(fVar.f23631b) && (str2 = this.l) != null) {
                this.f23614d.append(str2);
            }
            this.f23614d.append(str);
        }
    }

    public e<T> b() {
        if (this.f23616f.isEmpty()) {
            String tablename = this.g.getTablename();
            StringBuilder sb = new StringBuilder(org.greenrobot.greendao.c.d.a(tablename, (String[]) null));
            a(sb, this.h);
            String strReplace = sb.toString().replace(this.h + ".\"", '\"' + tablename + "\".\"");
            a(strReplace);
            return e.a(this.g, strReplace, this.f23615e.toArray());
        }
        throw new DaoException("JOINs are not supported for DELETE queries");
    }

    protected StringBuilder a(StringBuilder sb, org.greenrobot.greendao.f fVar) {
        this.f23613c.a(fVar);
        sb.append(this.h);
        sb.append('.');
        sb.append('\'');
        sb.append(fVar.f23634e);
        sb.append('\'');
        return sb;
    }

    public h<T> a() {
        StringBuilder sbE = e();
        int iA = a(sbE);
        int iB = b(sbE);
        String string = sbE.toString();
        a(string);
        return h.a(this.g, string, this.f23615e.toArray(), iA, iB);
    }

    private int a(StringBuilder sb) {
        if (this.i == null) {
            return -1;
        }
        sb.append(" LIMIT ?");
        this.f23615e.add(this.i);
        return this.f23615e.size() - 1;
    }

    private void a(String str) {
        if (f23611a) {
            org.greenrobot.greendao.d.a("Built SQL for query: " + str);
        }
        if (f23612b) {
            org.greenrobot.greendao.d.a("Values for query: " + this.f23615e);
        }
    }

    private void a(StringBuilder sb, String str) {
        this.f23615e.clear();
        for (f<T, ?> fVar : this.f23616f) {
            sb.append(" JOIN ");
            sb.append(fVar.f23604b.getTablename());
            sb.append(' ');
            sb.append(fVar.f23607e);
            sb.append(" ON ");
            org.greenrobot.greendao.c.d.a(sb, fVar.f23603a, fVar.f23605c);
            sb.append('=');
            org.greenrobot.greendao.c.d.a(sb, fVar.f23607e, fVar.f23606d);
        }
        boolean z = !this.f23613c.a();
        if (z) {
            sb.append(" WHERE ");
            this.f23613c.a(sb, str, this.f23615e);
        }
        for (f<T, ?> fVar2 : this.f23616f) {
            if (!fVar2.f23608f.a()) {
                if (!z) {
                    sb.append(" WHERE ");
                    z = true;
                } else {
                    sb.append(" AND ");
                }
                fVar2.f23608f.a(sb, fVar2.f23607e, this.f23615e);
            }
        }
    }
}
