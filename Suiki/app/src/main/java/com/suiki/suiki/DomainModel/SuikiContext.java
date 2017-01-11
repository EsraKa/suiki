package com.suiki.suiki.DomainModel;

import retrofit2.Retrofit;

/**
 * Created by Massil on 11/01/2017.
 */

public class SuikiContext {
    private Retrofit context;
    public PersonneService personneService;

    public SuikiContext()
    {
        context = new Retrofit.Builder()
                .baseUrl("10.0.0.2/api/")
                .build();
        personneService = context.create(PersonneService.class);
    }
}
