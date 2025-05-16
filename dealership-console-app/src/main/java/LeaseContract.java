

public class LeaseContract extends Contract {
    private static final double ENDING_VALUE_RATE = 0.5;
    private static final double LEASE_FEE_RATE = 0.07;

    private static final double INTEREST_RATE = 0.04 / 12;
    private static final int LEASE_TERM_MONTHS = 36;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicle);
    }

    @Override
    public double getTotalPrice() {
        double vehiclePrice = getVehicle().getPrice();
        double leaseFee = vehiclePrice * LEASE_FEE_RATE;
        double endingValue = vehiclePrice * ENDING_VALUE_RATE;

        return leaseFee + endingValue;
    }

    @Override
    public double getMonthlyPayment() {
        double vehiclePrice = getVehicle().getPrice();
        double leaseFee = vehiclePrice * LEASE_FEE_RATE;
        double endingValue = vehiclePrice * ENDING_VALUE_RATE;

        double financedAmount = leaseFee + endingValue;

        return (financedAmount * INTEREST_RATE) /
                (1 - Math.pow(1 + INTEREST_RATE, -LEASE_TERM_MONTHS));
    }
}
