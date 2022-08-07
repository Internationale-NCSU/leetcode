package TemplateMethodPattern;

public abstract class Task {
    private AuditTrail auditTrail;

    public Task(AuditTrail auditTrail) {
        this.auditTrail = auditTrail;
    }
    public void execute(){

    }
    public abstract void doExecute();
}
