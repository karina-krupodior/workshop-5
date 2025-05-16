
public class SalesContract extends Contract {
    //    Sales Tax Amount (5%)
    private static final double SALES_TAX_RATE = 0.05;
    private static final double RECORDING_FEE = 100.0;
    private static final double PROCESSING_FEE_UNDER_10000 = 295.0;
    private static final double PROCESSING_FEE_OVER_10000 = 495.0;

    private boolean isFinanced;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicle);
        this.isFinanced = isFinanced;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    @Override
    public double getTotalPrice() {
        double price = getVehicle().getPrice();
        double salesTax = price * SALES_TAX_RATE;
        double processingFee = price < 10000 ? PROCESSING_FEE_UNDER_10000 : PROCESSING_FEE_OVER_10000;
        return price + salesTax + RECORDING_FEE + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!isFinanced) return 0.0;

        double loanAmount = getTotalPrice();
        double rate;
        int months;

        if (loanAmount >= 10000) {
            rate = 0.0425 / 12;
            months = 48;
        } else {
            rate = 0.0525 / 12;
            months = 24;
        }

        return (loanAmount * rate) / (1 - Math.pow(1 + rate, -months));
    }
}
