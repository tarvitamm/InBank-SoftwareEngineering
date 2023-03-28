public class Person {
    private long id;

    private int credit_modifier;
    private int requested_amount;
    private int loan_period;
    private boolean debt;

    public Person(long id,int credit_modifier, int requested_amount, int loan_period, boolean debt) {
        this.id = id;
        this.credit_modifier = credit_modifier;
        this.requested_amount = requested_amount;
        this.loan_period = loan_period;
        this.debt = debt;
    }

    public long getId() {
        return id;
    }

    public int getCredit_modifier() {
        return credit_modifier;
    }

    public int getRequested_amount() {
        return requested_amount;
    }

    public int getLoan_period() {
        return loan_period;
    }

    public boolean isDebt() {
        return debt;
    }
}
