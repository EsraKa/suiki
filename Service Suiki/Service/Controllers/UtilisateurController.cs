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
    public class UtilisateurController : ApiController
    {
        // GET: api/Utilisateur
        public List<utilisateur> Get()
        {
            UtilisateurBll bll = new UtilisateurBll();
            return bll.GetUtilisateur();
        }

        // GET: api/Utilisateur/5
        public utilisateur Get(int id)
        {
            UtilisateurBll bll = new UtilisateurBll();
            return bll.GetUtilisateur(id);
        }


        // POST: api/Utilisateur
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Utilisateur/5
        public void Put(string nom, string mot_de_passe)
        {
            utilisateur utilisateur = new utilisateur();

            utilisateur.NOM_UTILISATEUR = nom;
            utilisateur.MOT_DE_PASSE = mot_de_passe;

            UtilisateurBll.AddUtilisateur(utilisateur);
        }

        // DELETE: api/Utilisateur/5
        public void Delete(int id)
        {
        }
    }
}
