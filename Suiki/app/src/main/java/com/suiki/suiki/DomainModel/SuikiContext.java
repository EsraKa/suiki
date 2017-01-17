package com.suiki.suiki.DomainModel;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Massil on 11/01/2017.
 */

public class SuikiContext {
    private Retrofit context;
    public PersonneService personneService;

    public SuikiContext()
    {
        context = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3120/api/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        personneService = context.create(PersonneService.class);
    }
}
