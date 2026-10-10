package b.d.a;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: BasicContainer.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements b.b.a.a.d, Iterator<b.b.a.a.b>, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b.b.a.a.b f2535a = new d("eof ");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b.d.a.b.g f2536b = b.d.a.b.g.a(e.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected b.b.a.a f2537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected f f2538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    b.b.a.a.b f2539e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f2540f = 0;
    long g = 0;
    long h = 0;
    private List<b.b.a.a.b> i = new ArrayList();

    public void a(b.b.a.a.b bVar) {
        if (bVar != null) {
            this.i = new ArrayList(b());
            bVar.setParent(this);
            this.i.add(bVar);
        }
    }

    public List<b.b.a.a.b> b() {
        return (this.f2538d == null || this.f2539e == f2535a) ? this.i : new b.d.a.b.f(this.i, this);
    }

    public void close() throws IOException {
        this.f2538d.close();
    }

    protected long d() {
        long size = 0;
        for (int i = 0; i < b().size(); i++) {
            size += this.i.get(i).getSize();
        }
        return size;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        b.b.a.a.b bVar = this.f2539e;
        if (bVar == f2535a) {
            return false;
        }
        if (bVar != null) {
            return true;
        }
        try {
            this.f2539e = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.f2539e = f2535a;
            return false;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.i.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.i.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public b.b.a.a.b next() {
        b.b.a.a.b bVarA;
        b.b.a.a.b bVar = this.f2539e;
        if (bVar != null && bVar != f2535a) {
            this.f2539e = null;
            return bVar;
        }
        f fVar = this.f2538d;
        if (fVar == null || this.f2540f >= this.h) {
            this.f2539e = f2535a;
            throw new NoSuchElementException();
        }
        try {
            synchronized (fVar) {
                this.f2538d.position(this.f2540f);
                bVarA = this.f2537c.a(this.f2538d, this);
                this.f2540f = this.f2538d.position();
            }
            return bVarA;
        } catch (EOFException unused) {
            throw new NoSuchElementException();
        } catch (IOException unused2) {
            throw new NoSuchElementException();
        }
    }

    public final void a(WritableByteChannel writableByteChannel) throws IOException {
        Iterator<b.b.a.a.b> it = b().iterator();
        while (it.hasNext()) {
            it.next().getBox(writableByteChannel);
        }
    }
}
