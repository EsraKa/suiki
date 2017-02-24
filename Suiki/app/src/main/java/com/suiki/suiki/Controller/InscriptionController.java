package com.suiki.suiki.Controller;

import com.suiki.suiki.Dal.InscriptionDal;
import com.suiki.suiki.Model.BddModel.Personne;
import com.suiki.suiki.Model.BddModel.Utilisateur;
import com.suiki.suiki.Model.HttpModel.HttpInscription;

/**
 * Created by Massil on 18/01/2017.
 */

public class InscriptionController {

    public static void Inscrire(HttpInscription utilisateur)
    {
        InscriptionDal inscriptionDal = new InscriptionDal();
        inscriptionDal.Inscrire(utilisateur);
    }
}
