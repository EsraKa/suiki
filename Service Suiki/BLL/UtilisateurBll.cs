<<<<<<< HEAD
﻿using System;
=======
﻿using Dal;
using Model;
using System;
>>>>>>> ec8dde9144140a75b12680a73099caa336270b9e
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
<<<<<<< HEAD
using Dal;
using Model;
=======
>>>>>>> ec8dde9144140a75b12680a73099caa336270b9e

namespace BLL
{
    public class UtilisateurBll
    {
<<<<<<< HEAD
        public static int AjouterUtilisateur(utilisateur util)
        {
            using (UtilisateurDal dal = new UtilisateurDal())
            {
                int id =dal.AjouterUtilisateur(util);
                return id;
=======
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
>>>>>>> ec8dde9144140a75b12680a73099caa336270b9e
            }
        }
    }
}
