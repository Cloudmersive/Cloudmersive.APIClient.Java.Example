package com.cloudmersive;

import com.cloudmersive.client.*;
import com.cloudmersive.client.model.*;
import com.cloudmersive.client.invoker.*;
import com.cloudmersive.client.invoker.auth.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.addDefaultHeader("Apikey", "14343416-776b-40e8-b6d7-6ffaa0bd70f9");

        client.setReadTimeout(300000);
        client.setWriteTimeout(300000);
        client.setConnectTimeout(300000);

//        ApiKeyAuth auth = (ApiKeyAuth)client.getAuthentication("key");
//        auth.setApiKey("14343416-776b-40e8-b6d7-6ffaa0bd70f9");

//        ApiKeyAuth auth = new ApiKeyAuth("header", "Apikey");
//        auth.setApiKey("14343416-776b-40e8-b6d7-6ffaa0bd70f9");
//
//        client.getAuthentications().put("Apikey", auth);

        //client.setApiKey("14343416-776b-40e8-b6d7-6ffaa0bd70f9");




        try
        {
            // Customer

            ApiClient defaultClient = Configuration.getDefaultApiClient();

            // Configure API key authorization: Apikey
            ApiKeyAuth Apikey = (ApiKeyAuth) defaultClient.getAuthentication("Apikey");
            Apikey.setApiKey("f0c513bc-8c00-4491-830e-3e83b015feb6");

            ConvertDocumentApi apiInstance = new ConvertDocumentApi();
            File inputFile = new File("C:\\temp\\input.docx"); // File | Input file to perform the operation on.
            try {
                Object result = apiInstance.convertDocumentDocxToPdf(inputFile);
                System.out.println(result);
            } catch (ApiException e) {
                System.err.println("Exception when calling ConvertDocumentApi#convertDocumentDocxToPdf");
                e.printStackTrace();
            }



            // Email API

            EmailApi api = new EmailApi(client);


            FullEmailValidationResponse result = api.emailFullValidation("support@cloudmersive.com");
            System.out.println("Result: " + result.isValidAddress().toString() + " - " + result.getMailServerUsedForValidation());

            // Barcode API

            BarcodeLookupApi barcodeLookup = new BarcodeLookupApi(client);

            BarcodeLookupResponse result2 = barcodeLookup.barcodeLookupEanLookup("4011200296908");
            System.out.println(result2.toString());

            GenerateBarcodeApi generate = new GenerateBarcodeApi(client);
            generate.generateBarcodeEAN8("96385074");


        }
        catch (Exception e)
        {
            System.out.println("Error:" + e.toString() + e.getMessage() );
        }




    }
}
