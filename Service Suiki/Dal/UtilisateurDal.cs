using System.Collections.Generic;
using System.Linq;
using Model;

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
            return res.ToList();
        }

        public int AddUtilisateur(utilisateur utilisateur)
        {
            context.utilisateurs.Add(utilisateur);
            context.SaveChanges();
            return utilisateur.ID_USER;
        }
    }
}