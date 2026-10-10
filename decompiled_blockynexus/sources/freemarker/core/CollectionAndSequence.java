package freemarker.core;

import freemarker.template.TemplateModelException;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class CollectionAndSequence implements freemarker.template.L, freemarker.template.s, Serializable {
    private freemarker.template.s collection;
    private ArrayList data;
    private freemarker.template.L sequence;

    private static class a implements freemarker.template.G {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final freemarker.template.L f21476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f21477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f21478c = 0;

        a(freemarker.template.L l) throws TemplateModelException {
            this.f21476a = l;
            this.f21477b = l.size();
        }

        @Override // freemarker.template.G
        public boolean hasNext() {
            return this.f21478c < this.f21477b;
        }

        @Override // freemarker.template.G
        public freemarker.template.E next() throws TemplateModelException {
            freemarker.template.L l = this.f21476a;
            int i = this.f21478c;
            this.f21478c = i + 1;
            return l.get(i);
        }
    }

    public CollectionAndSequence(freemarker.template.s sVar) {
        this.collection = sVar;
    }

    private void initSequence() throws TemplateModelException {
        if (this.data == null) {
            this.data = new ArrayList();
            freemarker.template.G it = this.collection.iterator();
            while (it.hasNext()) {
                this.data.add(it.next());
            }
        }
    }

    @Override // freemarker.template.L
    public freemarker.template.E get(int i) throws TemplateModelException {
        freemarker.template.L l = this.sequence;
        if (l != null) {
            return l.get(i);
        }
        initSequence();
        return (freemarker.template.E) this.data.get(i);
    }

    @Override // freemarker.template.s
    public freemarker.template.G iterator() throws TemplateModelException {
        freemarker.template.s sVar = this.collection;
        return sVar != null ? sVar.iterator() : new a(this.sequence);
    }

    @Override // freemarker.template.L
    public int size() throws TemplateModelException {
        freemarker.template.L l = this.sequence;
        if (l != null) {
            return l.size();
        }
        initSequence();
        return this.data.size();
    }

    public CollectionAndSequence(freemarker.template.L l) {
        this.sequence = l;
    }
}
