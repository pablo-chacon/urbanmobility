package com.example.maasfp.testutils;


public class MockProvider {
    /**
     * Create payment response.
     * @param request parameters.
     * @return Return response.
     */
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
    public String respondToPayment(String paymentDetails) {
        String request = "Payment details";
        String response = createResponse(request);
        return "Payment response " + response;
    }
}


