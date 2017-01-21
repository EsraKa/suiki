using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.UI;
using BLL;
using Model;
using Model.modelService;

namespace labo.Controllers
{
    public class InscriptionController : ApiController
    {
        // POST: api/Inscription
        public string Post(Inscription inscription)
        {
            try
            {
                int idUtilisateur = UtilisateurBll.AjouterUtilisateur(inscription.Utilisateur);
                inscription.Personne.ID_USER = idUtilisateur;
                PersonneBll.AddPersonne(inscription.Personne);
                return "status:true";
            }
            catch (Exception e)
            {
                return "status:false";
            }
            
        }

    }
}
