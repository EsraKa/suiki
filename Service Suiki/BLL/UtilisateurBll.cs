using Dal;
using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BLL
{
    public class UtilisateurBll
    {
        public utilisateur GetUtilisateur(int id)
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
