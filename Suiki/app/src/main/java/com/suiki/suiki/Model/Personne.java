package com.suiki.suiki.Model;

import org.simpleframework.xml.Element;

/**
 * Created by Massil on 11/01/2017.
 */

public class Personne {
    @Element(name = "ID_PERSONNE")
    public int ID_PERSONNE ;
    @Element(name = "ID_USER")
    public int ID_USER ;
    @Element(name = "NOM_PERSONNE")
    public String NOM_PERSONNE ;
    @Element(name = "PRENOM_PERSONNE")
    public String PRENOM_PERSONNE ;
    @Element(name = "MAIL")
    public String MAIL ;
    @Element(name = "PATIENT_MEDECIN")
    public String PATIENT_MEDECIN ;
}
