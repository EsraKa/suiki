package com.suiki.suiki.Controller;

import com.suiki.suiki.Dal.UtilisateurDal;
import com.suiki.suiki.Model.Personne;
import com.suiki.suiki.Model.Utilisateur;

/**
 * Created by Massil on 23/01/2017.
 */

public class ConnexionController {
    public static Personne Connecter(Utilisateur utilisateur){
        UtilisateurDal dal = new UtilisateurDal();
        dal.connexionUtilisateur(utilisateur);
        return dal.getProfile();
    }
}
