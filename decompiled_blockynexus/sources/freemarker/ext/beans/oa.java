package freemarker.ext.beans;

import freemarker.template.TemplateModelException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: StaticModel.java */
/* JADX INFO: loaded from: classes5.dex */
final class oa implements freemarker.template.B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d.b.b f21624a = d.b.b.d("freemarker.beans");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class f21625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C2867m f21626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f21627d = new HashMap();

    oa(Class cls, C2867m c2867m) throws Throwable {
        this.f21625b = cls;
        this.f21626c = c2867m;
        a();
    }

    private void a() throws Throwable {
        if (!Modifier.isPublic(this.f21625b.getModifiers())) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Can't wrap the non-public class ");
            stringBuffer.append(this.f21625b.getName());
            throw new TemplateModelException(stringBuffer.toString());
        }
        if (this.f21626c.e() == 3) {
            return;
        }
        for (Field field : this.f21625b.getFields()) {
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                if (Modifier.isFinal(modifiers)) {
                    try {
                        this.f21627d.put(field.getName(), this.f21626c.g().a(field.get(null)));
                    } catch (IllegalAccessException unused) {
                    }
                } else {
                    this.f21627d.put(field.getName(), field);
                }
            }
        }
        if (this.f21626c.e() < 2) {
            for (Method method : this.f21625b.getMethods()) {
                int modifiers2 = method.getModifiers();
                if (Modifier.isPublic(modifiers2) && Modifier.isStatic(modifiers2) && this.f21626c.b().a(method)) {
                    String name = method.getName();
                    Object obj = this.f21627d.get(name);
                    if (obj instanceof Method) {
                        aa aaVar = new aa(this.f21626c.i());
                        aaVar.a((Method) obj);
                        aaVar.a(method);
                        this.f21627d.put(name, aaVar);
                    } else if (obj instanceof aa) {
                        ((aa) obj).a(method);
                    } else {
                        if (obj != null && f21624a.b()) {
                            d.b.b bVar = f21624a;
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append("Overwriting value [");
                            stringBuffer2.append(obj);
                            stringBuffer2.append("] for ");
                            stringBuffer2.append(" key '");
                            stringBuffer2.append(name);
                            stringBuffer2.append("' with [");
                            stringBuffer2.append(method);
                            stringBuffer2.append("] in static model for ");
                            stringBuffer2.append(this.f21625b.getName());
                            bVar.e(stringBuffer2.toString());
                        }
                        this.f21627d.put(name, method);
                    }
                }
            }
            for (Map.Entry entry : this.f21627d.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof Method) {
                    Method method2 = (Method) value;
                    entry.setValue(new na(null, method2, method2.getParameterTypes(), this.f21626c));
                } else if (value instanceof aa) {
                    entry.setValue(new ba(null, (aa) value, this.f21626c));
                }
            }
        }
    }

    @Override // freemarker.template.A
    public freemarker.template.E get(String str) throws TemplateModelException {
        Object obj = this.f21627d.get(str);
        if (obj instanceof freemarker.template.E) {
            return (freemarker.template.E) obj;
        }
        if (!(obj instanceof Field)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No such key: ");
            stringBuffer.append(str);
            stringBuffer.append(" in class ");
            stringBuffer.append(this.f21625b.getName());
            throw new TemplateModelException(stringBuffer.toString());
        }
        try {
            return this.f21626c.g().a(((Field) obj).get(null));
        } catch (IllegalAccessException unused) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Illegal access for field ");
            stringBuffer2.append(str);
            stringBuffer2.append(" of class ");
            stringBuffer2.append(this.f21625b.getName());
            throw new TemplateModelException(stringBuffer2.toString());
        }
    }

    @Override // freemarker.template.A
    public boolean isEmpty() {
        return this.f21627d.isEmpty();
    }

    @Override // freemarker.template.B
    public freemarker.template.s keys() throws TemplateModelException {
        return (freemarker.template.s) this.f21626c.g().a(this.f21627d.keySet());
    }

    @Override // freemarker.template.B
    public int size() {
        return this.f21627d.size();
    }
}
