using System.Data.Entity;
using DomainModel;

namespace Dal
{
    public class Context : DbContext
    {
        public DbSet<Personne> Personnes { get; set; }
        public DbSet<A_Symptome> A_Symptomes { get; set; }
        public DbSet<Exercice> Exercices { get; set; }

        public Context()
        {
            
        }
    }


}
