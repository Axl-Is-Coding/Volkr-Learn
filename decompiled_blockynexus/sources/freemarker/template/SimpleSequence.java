package freemarker.template;

import freemarker.ext.beans.C2867m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SimpleSequence extends M implements L, Serializable {
    protected final List list;
    private List unwrappedList;

    private class SynchronizedSequence extends SimpleSequence {
        private SynchronizedSequence() {
        }

        @Override // freemarker.template.SimpleSequence
        public void add(Object obj) {
            synchronized (SimpleSequence.this) {
                SimpleSequence.this.add(obj);
            }
        }

        @Override // freemarker.template.SimpleSequence, freemarker.template.L
        public E get(int i) throws TemplateModelException {
            E e2;
            synchronized (SimpleSequence.this) {
                e2 = SimpleSequence.this.get(i);
            }
            return e2;
        }

        @Override // freemarker.template.SimpleSequence, freemarker.template.L
        public int size() {
            int size;
            synchronized (SimpleSequence.this) {
                size = SimpleSequence.this.size();
            }
            return size;
        }

        @Override // freemarker.template.SimpleSequence
        public List toList() throws TemplateModelException {
            List list;
            synchronized (SimpleSequence.this) {
                list = SimpleSequence.this.toList();
            }
            return list;
        }
    }

    public SimpleSequence() {
        this((InterfaceC2891l) null);
    }

    public void add(Object obj) {
        this.list.add(obj);
        this.unwrappedList = null;
    }

    @Override // freemarker.template.L
    public E get(int i) throws TemplateModelException {
        try {
            Object obj = this.list.get(i);
            if (obj instanceof E) {
                return (E) obj;
            }
            E eWrap = wrap(obj);
            this.list.set(i, eWrap);
            return eWrap;
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    @Override // freemarker.template.L
    public int size() {
        return this.list.size();
    }

    public SimpleSequence synchronizedWrapper() {
        return new SynchronizedSequence();
    }

    public List toList() throws Throwable {
        if (this.unwrappedList == null) {
            Class<?> cls = this.list.getClass();
            try {
                List list = (List) cls.newInstance();
                C2867m c2867mD = C2867m.d();
                for (int i = 0; i < this.list.size(); i++) {
                    Object objA = this.list.get(i);
                    if (objA instanceof E) {
                        objA = c2867mD.a((E) objA);
                    }
                    list.add(objA);
                }
                this.unwrappedList = list;
            } catch (Exception e2) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Error instantiating an object of type ");
                stringBuffer.append(cls.getName());
                throw new TemplateModelException(stringBuffer.toString(), e2);
            }
        }
        return this.unwrappedList;
    }

    public String toString() {
        return this.list.toString();
    }

    public SimpleSequence(int i) {
        this.list = new ArrayList(i);
    }

    public void add(boolean z) {
        add(z ? r.f21735d : r.f21734c);
    }

    public SimpleSequence(Collection collection) {
        this(collection, (InterfaceC2891l) null);
    }

    public SimpleSequence(s sVar) throws TemplateModelException {
        ArrayList arrayList = new ArrayList();
        G it = sVar.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        arrayList.trimToSize();
        this.list = arrayList;
    }

    public SimpleSequence(InterfaceC2891l interfaceC2891l) {
        super(interfaceC2891l);
        this.list = new ArrayList();
    }

    public SimpleSequence(int i, InterfaceC2891l interfaceC2891l) {
        super(interfaceC2891l);
        this.list = new ArrayList(i);
    }

    public SimpleSequence(Collection collection, InterfaceC2891l interfaceC2891l) {
        super(interfaceC2891l);
        this.list = new ArrayList(collection);
    }
}
