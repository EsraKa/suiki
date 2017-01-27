package com.suiki.suiki.Controller;

import com.suiki.suiki.Dal.InscriptionDal;
import com.suiki.suiki.Model.BddModel.Personne;
import com.suiki.suiki.Model.BddModel.Utilisateur;

/**
 * Created by Massil on 18/01/2017.
 */

public class InscriptionController {

    public static void Inscrire(Utilisateur utilisateur)
    {
        InscriptionDal inscriptionDal = new InscriptionDal();
        inscriptionDal.Inscrire(utilisateur);
    }
}
