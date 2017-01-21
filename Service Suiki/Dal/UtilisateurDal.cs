using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dal
{
    public class UtilisateurDal : BaseDal
    {
        public utilisateur GetUtilisateur(int id)
        {
            var res = from ex in context.utilisateurs
                      where ex.ID_USER == id
                      select ex;
            return res.FirstOrDefault();
        }
        public List<utilisateur> GetUtilisateur()
        {
            var res = from ex in context.utilisateurs
                      select ex;
            return res.ToList<utilisateur>();
        }

        public void AddUtilisateur(utilisateur utilisateur)
        {
            context.utilisateurs.Add(utilisateur);
        }
    }
}
