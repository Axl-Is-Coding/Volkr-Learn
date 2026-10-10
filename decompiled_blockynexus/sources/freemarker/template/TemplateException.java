package freemarker.template;

import com.umeng.umcrash.UMCustomLogInfoBuilder;
import freemarker.core.Environment;
import freemarker.core.Hb;
import freemarker.core.Xb;
import freemarker.core.Yb;
import freemarker.core.bc;
import freemarker.core.kc;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes5.dex */
public class TemplateException extends Exception {
    private static final String FTL_INSTRUCTION_STACK_TRACE_TITLE = "FTL stack trace (\"~\" means nesting-related):";
    private static final int FTL_STACK_TOP_FEW_MAX_LINES = 6;
    private final transient Hb blamedExpression;
    private String blamedExpressionString;
    private boolean blamedExpressionStringCalculated;
    private Integer columnNumber;
    private String description;
    private transient kc descriptionBuilder;
    private Integer endColumnNumber;
    private Integer endLineNumber;
    private final transient Environment env;
    private transient Xb[] ftlInstructionStackSnapshot;
    private Integer lineNumber;
    private transient Object lock;
    private transient String message;
    private transient ThreadLocal messageWasAlreadyPrintedForThisTrace;
    private transient String messageWithoutStackTop;
    private boolean positionsCalculated;
    private String renderedFtlInstructionStackSnapshot;
    private String renderedFtlInstructionStackSnapshotTop;
    private String templateName;
    private String templateSourceName;

    private static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PrintStream f21723a;

        a(PrintStream printStream) {
            this.f21723a = printStream;
        }

        @Override // freemarker.template.TemplateException.c
        public void a(Object obj) {
            this.f21723a.print(obj);
        }

        @Override // freemarker.template.TemplateException.c
        public void b(Object obj) {
            this.f21723a.println(obj);
        }

        @Override // freemarker.template.TemplateException.c
        public void a() {
            this.f21723a.println();
        }

        @Override // freemarker.template.TemplateException.c
        public void a(Throwable th) {
            if (th instanceof TemplateException) {
                ((TemplateException) th).printStandardStackTrace(this.f21723a);
            } else {
                th.printStackTrace(this.f21723a);
            }
        }
    }

    private static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PrintWriter f21724a;

        b(PrintWriter printWriter) {
            this.f21724a = printWriter;
        }

        @Override // freemarker.template.TemplateException.c
        public void a(Object obj) {
            this.f21724a.print(obj);
        }

        @Override // freemarker.template.TemplateException.c
        public void b(Object obj) {
            this.f21724a.println(obj);
        }

        @Override // freemarker.template.TemplateException.c
        public void a() {
            this.f21724a.println();
        }

        @Override // freemarker.template.TemplateException.c
        public void a(Throwable th) {
            if (th instanceof TemplateException) {
                ((TemplateException) th).printStandardStackTrace(this.f21724a);
            } else {
                th.printStackTrace(this.f21724a);
            }
        }
    }

    private interface c {
        void a();

        void a(Object obj);

        void a(Throwable th);

        void b(Object obj);
    }

    public TemplateException(Environment environment) {
        this((String) null, (Exception) null, environment);
    }

    private void calculatePosition() {
        synchronized (this.lock) {
            if (!this.positionsCalculated) {
                Yb yb = this.blamedExpression != null ? this.blamedExpression : (this.ftlInstructionStackSnapshot == null || this.ftlInstructionStackSnapshot.length == 0) ? null : this.ftlInstructionStackSnapshot[0];
                if (yb != null && yb.d() > 0) {
                    Template templateL = yb.l();
                    this.templateName = templateL != null ? templateL.f() : null;
                    this.templateSourceName = templateL != null ? templateL.g() : null;
                    this.lineNumber = new Integer(yb.d());
                    this.columnNumber = new Integer(yb.c());
                    this.endLineNumber = new Integer(yb.g());
                    this.endColumnNumber = new Integer(yb.f());
                }
                this.positionsCalculated = true;
                deleteFTLInstructionStackSnapshotIfNotNeeded();
            }
        }
    }

    private void deleteFTLInstructionStackSnapshotIfNotNeeded() {
        if (this.renderedFtlInstructionStackSnapshot == null || this.renderedFtlInstructionStackSnapshotTop == null) {
            return;
        }
        if (this.positionsCalculated || this.blamedExpression != null) {
            this.ftlInstructionStackSnapshot = null;
        }
    }

    private String getDescription() {
        String str;
        synchronized (this.lock) {
            if (this.description == null && this.descriptionBuilder != null) {
                this.description = this.descriptionBuilder.a(getFailingInstruction(), this.env != null ? this.env.c() : true);
                this.descriptionBuilder = null;
            }
            str = this.description;
        }
        return str;
    }

    private String getFTLInstructionStackTopFew() {
        String string;
        synchronized (this.lock) {
            if (this.ftlInstructionStackSnapshot == null && this.renderedFtlInstructionStackSnapshotTop == null) {
                return null;
            }
            if (this.renderedFtlInstructionStackSnapshotTop == null) {
                if (this.ftlInstructionStackSnapshot.length == 0) {
                    string = "";
                } else {
                    StringWriter stringWriter = new StringWriter();
                    bc.a(this.ftlInstructionStackSnapshot, true, stringWriter);
                    string = stringWriter.toString();
                }
                if (this.renderedFtlInstructionStackSnapshotTop == null) {
                    this.renderedFtlInstructionStackSnapshotTop = string;
                    deleteFTLInstructionStackSnapshotIfNotNeeded();
                }
            }
            return this.renderedFtlInstructionStackSnapshotTop.length() != 0 ? this.renderedFtlInstructionStackSnapshotTop : null;
        }
    }

    private Xb getFailingInstruction() {
        Xb[] xbArr = this.ftlInstructionStackSnapshot;
        if (xbArr == null || xbArr.length <= 0) {
            return null;
        }
        return xbArr[0];
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        this.lock = new Object();
        objectInputStream.defaultReadObject();
    }

    private void renderMessages() {
        String description = getDescription();
        if (description != null && description.length() != 0) {
            this.messageWithoutStackTop = description;
        } else if (getCause() != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No error description was specified for this error; low-level message: ");
            stringBuffer.append(getCause().getClass().getName());
            stringBuffer.append(": ");
            stringBuffer.append(getCause().getMessage());
            this.messageWithoutStackTop = stringBuffer.toString();
        } else {
            this.messageWithoutStackTop = "[No error description was available.]";
        }
        String fTLInstructionStackTopFew = getFTLInstructionStackTopFew();
        if (fTLInstructionStackTopFew == null) {
            this.message = this.messageWithoutStackTop;
            return;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(this.messageWithoutStackTop);
        stringBuffer2.append("\n\n");
        stringBuffer2.append("----");
        stringBuffer2.append(UMCustomLogInfoBuilder.LINE_SEP);
        stringBuffer2.append(FTL_INSTRUCTION_STACK_TRACE_TITLE);
        stringBuffer2.append(UMCustomLogInfoBuilder.LINE_SEP);
        stringBuffer2.append(fTLInstructionStackTopFew);
        stringBuffer2.append("----");
        this.message = stringBuffer2.toString();
        this.messageWithoutStackTop = this.message.substring(0, this.messageWithoutStackTop.length());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException, ClassNotFoundException {
        getFTLInstructionStack();
        getFTLInstructionStackTopFew();
        getDescription();
        calculatePosition();
        getBlamedExpressionString();
        objectOutputStream.defaultWriteObject();
    }

    public String getBlamedExpressionString() {
        String str;
        synchronized (this.lock) {
            if (!this.blamedExpressionStringCalculated) {
                if (this.blamedExpression != null) {
                    this.blamedExpressionString = this.blamedExpression.e();
                }
                this.blamedExpressionStringCalculated = true;
            }
            str = this.blamedExpressionString;
        }
        return str;
    }

    public Exception getCauseException() {
        if (getCause() instanceof Exception) {
            return (Exception) getCause();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Wrapped to Exception: ");
        stringBuffer.append(getCause());
        return new Exception(stringBuffer.toString(), getCause());
    }

    public Integer getColumnNumber() {
        Integer num;
        synchronized (this.lock) {
            if (!this.positionsCalculated) {
                calculatePosition();
            }
            num = this.columnNumber;
        }
        return num;
    }

    public Integer getEndColumnNumber() {
        Integer num;
        synchronized (this.lock) {
            if (!this.positionsCalculated) {
                calculatePosition();
            }
            num = this.endColumnNumber;
        }
        return num;
    }

    public Integer getEndLineNumber() {
        Integer num;
        synchronized (this.lock) {
            if (!this.positionsCalculated) {
                calculatePosition();
            }
            num = this.endLineNumber;
        }
        return num;
    }

    public Environment getEnvironment() {
        return this.env;
    }

    public String getFTLInstructionStack() {
        synchronized (this.lock) {
            if (this.ftlInstructionStackSnapshot == null && this.renderedFtlInstructionStackSnapshot == null) {
                return null;
            }
            if (this.renderedFtlInstructionStackSnapshot == null) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                bc.a(this.ftlInstructionStackSnapshot, false, printWriter);
                printWriter.close();
                if (this.renderedFtlInstructionStackSnapshot == null) {
                    this.renderedFtlInstructionStackSnapshot = stringWriter.toString();
                    deleteFTLInstructionStackSnapshotIfNotNeeded();
                }
            }
            return this.renderedFtlInstructionStackSnapshot;
        }
    }

    public Integer getLineNumber() {
        Integer num;
        synchronized (this.lock) {
            if (!this.positionsCalculated) {
                calculatePosition();
            }
            num = this.lineNumber;
        }
        return num;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str;
        ThreadLocal threadLocal = this.messageWasAlreadyPrintedForThisTrace;
        if (threadLocal != null && threadLocal.get() == Boolean.TRUE) {
            return "[... Exception message was already printed; see it above ...]";
        }
        synchronized (this.lock) {
            if (this.message == null) {
                renderMessages();
            }
            str = this.message;
        }
        return str;
    }

    public String getMessageWithoutStackTop() {
        String str;
        synchronized (this.lock) {
            if (this.messageWithoutStackTop == null) {
                renderMessages();
            }
            str = this.messageWithoutStackTop;
        }
        return str;
    }

    public String getTemplateName() {
        String str;
        synchronized (this.lock) {
            if (!this.positionsCalculated) {
                calculatePosition();
            }
            str = this.templateName;
        }
        return str;
    }

    public String getTemplateSourceName() {
        String str;
        synchronized (this.lock) {
            if (!this.positionsCalculated) {
                calculatePosition();
            }
            str = this.templateSourceName;
        }
        return str;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStackTrace(printStream, true, true, true);
    }

    public void printStandardStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
    }

    public TemplateException(String str, Environment environment) {
        this(str, (Exception) null, environment);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace(printWriter, true, true, true);
    }

    public void printStandardStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
    }

    public TemplateException(Exception exc, Environment environment) {
        this((String) null, exc, environment);
    }

    public void printStackTrace(PrintWriter printWriter, boolean z, boolean z2, boolean z3) {
        synchronized (printWriter) {
            printStackTrace(new b(printWriter), z, z2, z3);
        }
    }

    public TemplateException(Throwable th, Environment environment) {
        this((String) null, th, environment);
    }

    public TemplateException(String str, Exception exc, Environment environment) {
        this(str, exc, environment, null, null);
    }

    public TemplateException(String str, Throwable th, Environment environment) {
        this(str, th, environment, null, null);
    }

    public void printStackTrace(PrintStream printStream, boolean z, boolean z2, boolean z3) {
        synchronized (printStream) {
            printStackTrace(new a(printStream), z, z2, z3);
        }
    }

    protected TemplateException(Throwable th, Environment environment, Hb hb, kc kcVar) {
        this(null, th, environment, hb, kcVar);
    }

    private TemplateException(String str, Throwable th, Environment environment, Hb hb, kc kcVar) {
        super(th);
        this.lock = new Object();
        environment = environment == null ? Environment.d() : environment;
        this.env = environment;
        this.blamedExpression = hb;
        this.descriptionBuilder = kcVar;
        this.description = str;
        if (environment != null) {
            this.ftlInstructionStackSnapshot = bc.a(environment);
        }
    }

    private void printStackTrace(c cVar, boolean z, boolean z2, boolean z3) {
        synchronized (cVar) {
            if (z) {
                try {
                    cVar.b("FreeMarker template error:");
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z2) {
                String fTLInstructionStack = getFTLInstructionStack();
                if (fTLInstructionStack != null) {
                    cVar.b(getMessageWithoutStackTop());
                    cVar.a();
                    cVar.b("----");
                    cVar.b(FTL_INSTRUCTION_STACK_TRACE_TITLE);
                    cVar.a(fTLInstructionStack);
                    cVar.b("----");
                } else {
                    z2 = false;
                    z3 = true;
                }
            }
            if (z3) {
                if (z2) {
                    cVar.a();
                    cVar.b("Java stack trace (for programmers):");
                    cVar.b("----");
                    synchronized (this.lock) {
                        if (this.messageWasAlreadyPrintedForThisTrace == null) {
                            this.messageWasAlreadyPrintedForThisTrace = new ThreadLocal();
                        }
                        this.messageWasAlreadyPrintedForThisTrace.set(Boolean.TRUE);
                    }
                    try {
                        cVar.a((Throwable) this);
                        this.messageWasAlreadyPrintedForThisTrace.set(Boolean.FALSE);
                    } catch (Throwable th2) {
                        this.messageWasAlreadyPrintedForThisTrace.set(Boolean.FALSE);
                        throw th2;
                    }
                } else {
                    cVar.a((Throwable) this);
                }
                if (getCause() != null && getCause().getCause() == null) {
                    try {
                        Throwable th3 = (Throwable) getCause().getClass().getMethod("getRootCause", freemarker.template.utility.b.f21744b).invoke(getCause(), freemarker.template.utility.b.f21743a);
                        if (th3 != null) {
                            cVar.b("ServletException root cause: ");
                            cVar.a(th3);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }
}
