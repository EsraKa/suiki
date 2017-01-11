using BLL;
using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace labo.Controllers
{
    public class PersonneController : ApiController
    {
        // GET: api/Personne
        public List<personne> Get()
        {
            PersonneBll bll = new PersonneBll();
            return bll.GetPersonne();
        }

        // GET: api/Personne/5
        public personne Get(int id)
        {
            PersonneBll bll = new PersonneBll();
            return bll.GetPersonne(id);
        }

        // POST: api/Personne
        public void Post([FromBody]string value)
        {
        }

        //Ajouter une Personne.
        // PUT: api/Personne/5
        public void Put(int user, string nom, string prenom, string mail, string patient_medecin)
        {
            personne personne = new personne();

            personne.ID_USER = user;
            personne.MAIL = mail;
            personne.NOM_PERSONNE = nom;
            personne.PATIENT_MEDECIN = patient_medecin;
            personne.PRENOM_PERSONNE = prenom;

            PersonneBll.AddPersonne(personne);
        }

        // DELETE: api/Personne/5
        public void Delete(int id)
        {
        }
    }
}
