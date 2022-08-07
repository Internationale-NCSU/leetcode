package TemplateMethodPattern;

public class TransferMoneyTask extends Task{
    private AuditTrail auditTrail;

    // implement a concrete task;

    public TransferMoneyTask(AuditTrail auditTrail) {
        super(auditTrail);
    }


    @Override
    public void doExecute() {
        System.out.println("Transfer Money");
    }
}
