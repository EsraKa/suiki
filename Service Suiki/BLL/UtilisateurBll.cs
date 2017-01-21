using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Dal;
using Model;

namespace BLL
{
    public class UtilisateurBll
    {
        public static int AjouterUtilisateur(utilisateur util)
        {
            using (UtilisateurDal dal = new UtilisateurDal())
            {
                int id =dal.AjouterUtilisateur(util);
                return id;
            }
        }
    }
}
