package kotlin.jvm.internal;

/* JADX INFO: compiled from: ReflectionFactory.java */
/* JADX INFO: loaded from: classes5.dex */
public class l {
    public kotlin.reflect.e a(Class cls, String str) {
        return new j(cls, str);
    }

    public kotlin.reflect.f a(FunctionReference functionReference) {
        return functionReference;
    }

    public kotlin.reflect.h a(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public kotlin.reflect.i a(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public kotlin.reflect.c a(Class cls) {
        return new d(cls);
    }

    public String a(Lambda lambda) {
        return a((g) lambda);
    }

    public String a(g gVar) {
        String string = gVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
