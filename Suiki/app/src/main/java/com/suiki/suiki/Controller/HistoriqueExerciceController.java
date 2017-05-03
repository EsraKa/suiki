package com.suiki.suiki.Controller;

import android.app.Activity;

import com.suiki.suiki.Dal.HistoriqueExerciceDal;
import com.suiki.suiki.Model.BddModel.HistoriqueExercice;

/**
 * Created by Massil on 03/05/2017.
 */

public class HistoriqueExerciceController {
    public static void ajoutHistoriqueExercice(HistoriqueExercice historiqueExercice , Activity activity)
    {
        HistoriqueExerciceDal dal = new HistoriqueExerciceDal();
        dal.ajoutHistoriqueExercice(historiqueExercice , activity);
    }
}
