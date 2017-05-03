package com.suiki.suiki.Controller;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

import com.suiki.suiki.Dal.ConnexionDal;
import com.suiki.suiki.Model.BddModel.Patient;
import com.suiki.suiki.Model.BddModel.Personne;
import com.suiki.suiki.Model.BddModel.Utilisateur;
import com.suiki.suiki.Model.HttpModel.HttpConnexion;
import com.suiki.suiki.Model.HttpModel.HttpReponse;
import com.suiki.suiki.Vue.Connexion;

/**
 * Created by Massil on 23/01/2017.
 */

public class ConnexionController {
    private static ConnexionDal dal;
    public static void Connecter(HttpConnexion identifiant , Intent intentConnexion ,
                                 Connexion connexionVue , SharedPreferences.Editor editSession){
        dal = new ConnexionDal(intentConnexion , connexionVue);
        dal.Connecter(identifiant , editSession);
    }
}
