package com.cloudmersive;

import com.cloudmersive.client.*;
import com.cloudmersive.client.invoker.auth.ApiKeyAuth;
import com.cloudmersive.client.model.*;
import com.cloudmersive.client.invoker.*;
import org.springframework.web.client.RestClientException;

public class Main {

    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.addDefaultHeader("Apikey", "14343416-776b-40e8-b6d7-6ffaa0bd70f9");



        EmailApi api = new EmailApi(client);

        try
        {
            FullEmailValidationResponse result = api.emailFullValidation("support@cloudmersive.com");
            System.out.println("Result: " + result.getValidAddress().toString() + " - " + result.getMailServerUsedForValidation());
        }
        catch (RestClientException e)
        {
            System.out.println("Error:" + e.toString() + e.getMessage() );
        }
    }
}
