package freemarker.core;

import freemarker.template.C2881b;
import freemarker.template.InterfaceC2891l;
import freemarker.template.Version;
import freemarker.template.utility.NullArgumentException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes5.dex */
public class Configurable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f21479a = {"api_builtin_enabled", "arithmetic_engine", "auto_flush", "boolean_format", "classic_compatible", "date_format", "datetime_format", "locale", "log_template_exceptions", "new_builtin_class_resolver", "number_format", "object_wrapper", "output_encoding", "show_error_tips", "sql_date_and_time_time_zone", "strict_bean_models", "template_exception_handler", "time_format", "time_zone", "url_escaping_charset"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f21480b = {"apiBuiltinEnabled", "arithmeticEngine", "autoFlush", "booleanFormat", "classicCompatible", "dateFormat", "datetimeFormat", "locale", "logTemplateExceptions", "newBuiltinClassResolver", "numberFormat", "objectWrapper", "outputEncoding", "showErrorTips", "sqlDateAndTimeTimeZone", "strictBeanModels", "templateExceptionHandler", "timeFormat", "timeZone", "urlEscapingCharset"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Configurable f21481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Properties f21482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap f21483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Locale f21484f;
    private String g;
    private String h;
    private String i;
    private String j;
    private TimeZone k;
    private TimeZone l;
    private String m;
    private String n;
    private String o;
    private Integer p;
    private freemarker.template.z q;
    private AbstractC2778a r;
    private InterfaceC2891l s;
    private Boolean t;
    private Wb u;
    private Boolean v;
    private Boolean w;
    private Boolean x;

    public static class SettingValueAssignmentException extends _MiscTemplateException {
        private SettingValueAssignmentException(Environment environment, String str, String str2, Throwable th) {
            super(th, environment, new Object[]{"Failed to set FreeMarker configuration setting ", new gc(str), " to value ", new gc(str2), "; see cause exception."});
        }
    }

    public static class UnknownSettingException extends _MiscTemplateException {
        /* JADX WARN: Illegal instructions before constructor call */
        private UnknownSettingException(Environment environment, String str, String str2) {
            Object[] objArr = new Object[3];
            objArr[0] = "Unknown FreeMarker configuration setting: ";
            objArr[1] = new gc(str);
            objArr[2] = str2 == null ? "" : new Object[]{". You may meant: ", new gc(str2)};
            super(environment, objArr);
        }
    }

    public Configurable() {
        this(C2881b.H);
    }

    public void a(String str) {
        NullArgumentException.check("booleanFormat", str);
        int iIndexOf = str.indexOf(44);
        if (iIndexOf == -1) {
            throw new IllegalArgumentException("Setting value must be string that contains two comma-separated values for true and false, respectively.");
        }
        this.m = str;
        this.f21482d.setProperty("boolean_format", str);
        if (str.equals("true,false")) {
            this.n = null;
            this.o = null;
        } else {
            this.n = str.substring(0, iIndexOf);
            this.o = str.substring(iIndexOf + 1);
        }
    }

    public final Configurable b() {
        return this.f21481c;
    }

    public boolean c() {
        Boolean bool = this.v;
        if (bool != null) {
            return bool.booleanValue();
        }
        Configurable configurable = this.f21481c;
        if (configurable != null) {
            return configurable.c();
        }
        return true;
    }

    protected Object clone() throws CloneNotSupportedException {
        Configurable configurable = (Configurable) super.clone();
        configurable.f21482d = new Properties(this.f21482d);
        configurable.f21483e = (HashMap) this.f21483e.clone();
        return configurable;
    }

    protected Configurable(Version version) {
        freemarker.template.N.a(version);
        this.f21481c = null;
        this.f21482d = new Properties();
        this.f21484f = Locale.getDefault();
        this.f21482d.setProperty("locale", this.f21484f.toString());
        this.k = TimeZone.getDefault();
        this.f21482d.setProperty("time_zone", this.k.getID());
        this.l = null;
        this.f21482d.setProperty("sql_date_and_time_time_zone", String.valueOf(this.l));
        this.g = "number";
        this.f21482d.setProperty("number_format", this.g);
        this.h = "";
        this.f21482d.setProperty("time_format", this.h);
        this.i = "";
        this.f21482d.setProperty("date_format", this.i);
        this.j = "";
        this.f21482d.setProperty("datetime_format", this.j);
        this.p = new Integer(0);
        this.f21482d.setProperty("classic_compatible", this.p.toString());
        this.q = freemarker.template.N.c(version);
        this.f21482d.setProperty("template_exception_handler", this.q.getClass().getName());
        this.r = AbstractC2778a.f21507a;
        this.f21482d.setProperty("arithmetic_engine", this.r.getClass().getName());
        this.s = C2881b.b(version);
        this.t = Boolean.TRUE;
        this.f21482d.setProperty("auto_flush", this.t.toString());
        this.u = Wb.f21495a;
        this.f21482d.setProperty("new_builtin_class_resolver", this.u.getClass().getName());
        this.v = Boolean.TRUE;
        this.f21482d.setProperty("show_error_tips", this.v.toString());
        this.w = Boolean.FALSE;
        this.f21482d.setProperty("api_builtin_enabled", this.w.toString());
        this.x = Boolean.valueOf(freemarker.template.N.b(version));
        this.f21482d.setProperty("log_template_exceptions", this.x.toString());
        a("true,false");
        this.f21483e = new HashMap();
    }

    Object a(Object obj, C2848xb c2848xb) {
        Object objA;
        synchronized (this.f21483e) {
            objA = this.f21483e.get(obj);
            if (objA == null && !this.f21483e.containsKey(obj)) {
                objA = c2848xb.a();
                this.f21483e.put(obj, objA);
            }
        }
        return objA;
    }
}
