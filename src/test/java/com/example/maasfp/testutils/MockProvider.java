package com.example.maasfp.testutils;


import org.junit.jupiter.api.Test;

public class MockProvider {
    /**
     * Create payment response.
     * @param request parameters.
     * @return Return response.
     */

    @Test
    public String createResponse(String request) {
        if (request.equals("Payment details")) {
            return "Payment successful " + request;
        } else {
            return "Payment failed " + request;
        }
    }

    /**
     * @return Returns payment response.
     */
    @Test
    public void respondToPayment() {
        String request = "Payment details";
        String response = createResponse(request);

        if (response.equals("Payment successful " + request)) {
            System.out.println("Payment successful");
        } else {
            System.out.println("Payment failed");
        }
    }
}


