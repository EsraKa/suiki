using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Model;

namespace Dal
{
    public class UtilisateurDal : BaseDal
    {
        public int AjouterUtilisateur(utilisateur util)
        {
            context.utilisateurs.Add(util);
            return util.ID_USER;
        }
    }
}
