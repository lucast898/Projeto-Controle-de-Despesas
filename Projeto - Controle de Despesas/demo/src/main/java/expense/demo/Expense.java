package expense.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "expense")
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Para o ID ser auto-gerado
    private Long id;
    private String nameExpense;
    private Double valueExpense;
    private Double valueMensalInstallment; // valor mensal das parcelas
    private Integer dayPay;
    private String categoryExpense;
    public Expense(){}
    public Expense(Long id, String nameExpense, Double valueExpense, Integer installmentExpense, Double valueMensalInstallment, Integer dayPay, String categoryExpense) {
        this.id = id;
        this.nameExpense = nameExpense;
        this.valueExpense = valueExpense;
        this.valueMensalInstallment = valueMensalInstallment;
        this.dayPay = dayPay;
        this.categoryExpense = categoryExpense;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNameExpense() {
        return nameExpense;
    }

    public Double getValueExpense() {
        return valueExpense;
    }

    public Double getValueMensalInstallment() {
        return valueMensalInstallment;
    }

    public Integer getDayPay() {
        return dayPay;
    }

    public String getCategoryExpense() {
        return categoryExpense;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNameExpense(String nameExpense) {
        this.nameExpense = nameExpense;
    }

    public void setValueExpense(Double valueExpense) {
        this.valueExpense = valueExpense;
    }

    public void setValueMensalInstallment(Double valueMensalInstallment) {
        this.valueMensalInstallment = valueMensalInstallment;
    }

    public void setDayPay(Integer dayPay) {
        this.dayPay = dayPay;
    }

    public void setCategoryExpense(String categoryExpense) {
        this.categoryExpense = categoryExpense;
    }

    public float setBalance(float balanceAccount){
        balanceAccount -= (valueExpense + valueMensalInstallment);
        return balanceAccount;
    }

}
