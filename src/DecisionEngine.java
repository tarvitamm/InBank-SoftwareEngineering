import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class DecisionEngine {


    public static int maximum_amount(Person person){
        int maximum_loan_amount = 0;
        if (person.isDebt()) return maximum_loan_amount;
        if (person.getLoan_period() > 60 || person.getLoan_period() < 12) return maximum_loan_amount;
        if (person.getRequested_amount() < 2000 || person.getRequested_amount() > 10000) return maximum_loan_amount;

        double credit_score = ((double) person.getCredit_modifier() / person.getRequested_amount()) * person.getLoan_period();
        if (credit_score >= 1){
            maximum_loan_amount = person.getRequested_amount();
            for (int i = person.getRequested_amount(); i <= 10000; i++) {
                double new_credit_score = ((double) person.getCredit_modifier() / i) * person.getLoan_period();
                if (new_credit_score >= 1) maximum_loan_amount = i;
                else break;
            }
        }
        else{
            for (int i = person.getRequested_amount(); i > 2000; i--) {
                double new_credit_score = ((double) person.getCredit_modifier() / i) * person.getLoan_period();
                if (new_credit_score >= 1){
                    maximum_loan_amount = i;
                    break;
                }
            }
        }
        return maximum_loan_amount;
    }

    public static Map<Boolean, Integer> answer(Person person){
        Map<Boolean, Integer> result = new HashMap<>();
        int maximum = maximum_amount(person);
        if (person.isDebt() || maximum == 0) result.put(false, 0);
        else result.put(true, maximum);
        return result;
    }


    public static void main(String[] args) {
        System.out.println(answer(new Person(49002010965L,1000, 1000,12, true)));
        System.out.println(answer(new Person(49002010965L,100, 2800,30, false)));
        System.out.println(answer(new Person(49002010965L,300, 9050,30, false)));
        System.out.println(answer(new Person(49002010965L,1000, 5000,30, false)));
    }
}
