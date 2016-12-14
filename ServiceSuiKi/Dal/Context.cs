using System.Data.Entity;
using WebApplication1.Models;

namespace Dal
{
    public class Context : DbContext
    {
        public DbSet<Personne> Personnes { get; set; }

        static Context() 
        {
            Personnes.AddRange()
            Personne p = new Personne();
            p.nom = "KADI";
            p.prenom = "Massil";
        }
    }


}
