package com.suiki.suiki.Controller;

import com.suiki.suiki.Dal.ConnexionDal;
import com.suiki.suiki.Model.BddModel.Personne;
import com.suiki.suiki.Model.BddModel.Utilisateur;
import com.suiki.suiki.Model.HttpModel.HttpConnexion;
import com.suiki.suiki.Model.HttpModel.HttpReponse;
import com.suiki.suiki.Vue.Connexion;

/**
 * Created by Massil on 23/01/2017.
 */

public class ConnexionController {
    public static Personne Connecter(HttpConnexion identifiant){
        ConnexionDal dal = new ConnexionDal();
        HttpReponse reponse = dal.Connecter(identifiant);
        if(reponse.status)
        {
            return (Personne)reponse.data;
        }
        else
            return null;

    }
}
