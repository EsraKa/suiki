using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dal
{
    public class BaseDal : IDisposable
    {
        protected suikiEntities context;

        public BaseDal()
        {
            this.context = new suikiEntities();
        }

        //Ferme la connexion avec la base de donnée
        public void Dispose()
        {
            context.Dispose();
        }
    }
}
