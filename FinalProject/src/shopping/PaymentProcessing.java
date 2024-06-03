package shopping;

public class PaymentProcessing {

    public PaymentProcessing() {

    }

    public boolean processPayment(double amount) {
	if (amount <= 0) {
	    System.out.println("Invalid amount.");
	    return false;
	}

	boolean isSuccess = simulatePaymentGateway(amount);

	if (isSuccess) {
	    System.out.println("Payment processed successfully.");
	} else {
	    System.out.println("Payment processing failed.");
	}

	return isSuccess;
    }

    protected boolean simulatePaymentGateway(double amount) {
	// Placeholder for real payment gateway logic

	return Math.random() > 0.4;
    }

}
