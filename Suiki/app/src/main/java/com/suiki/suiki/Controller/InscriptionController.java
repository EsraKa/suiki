package com.suiki.suiki.Controller;

import com.suiki.suiki.Dal.InscriptionDal;
import com.suiki.suiki.Dal.PersonneDal;
import com.suiki.suiki.Dal.UtilisateurDal;
import com.suiki.suiki.Model.Personne;
import com.suiki.suiki.Model.Utilisateur;
import com.suiki.suiki.Vue.Inscription;

import okhttp3.internal.Util;

/**
 * Created by Massil on 18/01/2017.
 */

public class InscriptionController {

    public static void Inscrire(Utilisateur utilisateur , Personne personne)
    {
        InscriptionDal inscriptionDal = new InscriptionDal();
        inscriptionDal.Inscrire(utilisateur , personne);
    }
}
