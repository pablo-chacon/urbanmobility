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
     * @param paymentDetails The payment details.
     * @return Returns payment response.
     */
    @Test
    public String respondToPayment(String paymentDetails) {
        String request = "Payment details";
        String response = createResponse(request);
        return "Payment response " + response;
    }
}


