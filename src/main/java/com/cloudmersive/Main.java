package com.cloudmersive;

import com.cloudmersive.client.*;
import com.cloudmersive.client.model.*;
import com.cloudmersive.client.invoker.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.addDefaultHeader("Apikey", "14343416-776b-40e8-b6d7-6ffaa0bd70f9");



//        ApiKeyAuth auth = (ApiKeyAuth)client.getAuthentication("key");
//        auth.setApiKey("14343416-776b-40e8-b6d7-6ffaa0bd70f9");

//        ApiKeyAuth auth = new ApiKeyAuth("header", "Apikey");
//        auth.setApiKey("14343416-776b-40e8-b6d7-6ffaa0bd70f9");
//
//        client.getAuthentications().put("Apikey", auth);

        //client.setApiKey("14343416-776b-40e8-b6d7-6ffaa0bd70f9");




        try
        {
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

            // Convert API

            ConvertDocumentApi docApi = new ConvertDocumentApi(client);

            ScreenshotRequest req = new ScreenshotRequest();
            req.setUrl("https://api.cloudmersive.com/csharp-client.asp");

            ConvertWebApi webApi = new ConvertWebApi(client);
            File output = webApi.convertWebUrlToPdf(req);

            System.out.println(output.getPath());
        }
        catch (Exception e)
        {
            System.out.println("Error:" + e.toString() + e.getMessage() );
        }




    }
}
