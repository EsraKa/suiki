using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.UI;
using BLL;
using Model;

namespace labo.Controllers
{
    public class InscriptionController : ApiController
    {
        // POST: api/Inscription
        public void Post(KeyValuePair<utilisateur , personne> pair )
        {
            int idUtilisateur = UtilisateurBll.AjouterUtilisateur(pair.Key);
            pair.Value.ID_USER = idUtilisateur;
            PersonneBll.AddPersonne(pair.Value);
        }

    }
}
