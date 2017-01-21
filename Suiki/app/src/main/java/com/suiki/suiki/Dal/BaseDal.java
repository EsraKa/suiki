package com.suiki.suiki.Dal;

import com.suiki.suiki.DomainModel.SuikiContext;

/**
 * Created by Massil on 11/01/2017.
 */

public class BaseDal {
    protected SuikiContext context;

    public BaseDal()
    {
        context = new SuikiContext();
    }
}
