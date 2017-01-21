<<<<<<< HEAD
﻿using System;
=======
﻿using Model;
using System;
>>>>>>> ec8dde9144140a75b12680a73099caa336270b9e
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
<<<<<<< HEAD
using Model;
=======
>>>>>>> ec8dde9144140a75b12680a73099caa336270b9e

namespace Dal
{
    public class UtilisateurDal : BaseDal
    {
<<<<<<< HEAD
        public int AjouterUtilisateur(utilisateur util)
        {
            context.utilisateurs.Add(util);
            return util.ID_USER;
=======
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
>>>>>>> ec8dde9144140a75b12680a73099caa336270b9e
        }
    }
}
