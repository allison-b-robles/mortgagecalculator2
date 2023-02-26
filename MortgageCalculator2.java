package edu.moorparkcollege.mortgagecalculator2;

import java.util.Scanner;

/**
 *
 * @author Allison Bernal
 */
public class MortgageCalculator2 {

    public static void main(String[] args) {
        calculatePayment();
    }
    
    static void calculatePayment(){
        /* Calculate Monthly Payment */
        MortgageTerms mortgateTerms = getMortgageTerms();
        var monthlyPayment = mortgateTerms.principal * mortgateTerms.rate / (1.0 - Math.pow(mortgateTerms.rate+1, -mortgateTerms.term));

        /* Show Monthly Payment */
        System.out.print("The Monthly Payment is $"+monthlyPayment);
    }
    
    private static MortgageTerms getMortgageTerms(){
        /* Initialize MortgageTerms Object */
        MortgageTerms mortgateTerms = new MortgageTerms();
        
        /* Initialize Scanner Class */
        Scanner data = new Scanner(System.in);

        /* Save Mortgage Amount */
        while (mortgateTerms.getPrincipal() <= 0){
            /* Ask User For Mortgage Amount */
            System.out.print("Enter a Positive Mortgage Amount: ");
            mortgateTerms.setPrincipal(data.nextInt());
            while (mortgateTerms.getPrincipal() <= 100000 || mortgateTerms.getPrincipal() >= 1000000) {
                System.out.print("Enter a Mortgage Amount Between $100,000 and $1,000,000: ");
                mortgateTerms.setPrincipal(data.nextInt());
            }
        }
        
        /* Save Rate */
        while (mortgateTerms.getRate() <= 0){
            /* Ask User For Rate */
            System.out.print("Enter a Positive Rate: ");
            mortgateTerms.setRate(data.nextDouble()) ;
        }
        
        /* Save Term */
        while (mortgateTerms.getTerm() <= 0){
            /* Ask User For Term */ 
            System.out.print("Enter a Positive Term: "); 
            mortgateTerms.setTerm(data.nextInt()) ;
        }

        /* Set The Term */ 
        mortgateTerms.setTerm(mortgateTerms.getTerm() * 12);

        /* Set The Rate */
        mortgateTerms.setRate(mortgateTerms.getRate() / 1200.0);
        
        return mortgateTerms;
    }

    private static class MortgageTerms {
        int principal;
        public double getPrincipal() {
           return this.principal;
        }
        public void setPrincipal(int number) {
           this.principal = number;
        }

        double rate; 
        public double getRate() {
           return this.rate;
        }
        public void setRate(double number) {
           this.rate = number;
        }

        int term;
        public int getTerm() {
           return this.term;
        }
        public void setTerm(int number) {
           this.term = number;
        }
    }
}
