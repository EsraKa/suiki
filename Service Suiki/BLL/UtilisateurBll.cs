using System;
using Model;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Dal;

namespace BLL
{
    public class UtilisateurBll
    {
        public static int AjouterUtilisateur(utilisateur util)
        {
            using (UtilisateurDal dal = new UtilisateurDal())
            {
                int id = dal.AddUtilisateur(util);
                return id;
            }
        }

        public
            utilisateur GetUtilisateur(int id)
        {
            using (UtilisateurDal ctx = new UtilisateurDal())
            {
                return ctx.GetUtilisateur(id);
            }
        }

        public List<utilisateur> GetUtilisateur()
        {
            using (UtilisateurDal ctx = new UtilisateurDal())
            {
                return ctx.GetUtilisateur();
            }
        }

        public static void AddUtilisateur(utilisateur utilisateur)
        {
            using (UtilisateurDal ctx = new UtilisateurDal())
            {
                ctx.AddUtilisateur(utilisateur);
            }
        }
    }
}
