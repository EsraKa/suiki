using System.Collections.Generic;
using Dal;
using Model;

namespace BLL
{
    public class PersonneBll
    {
        public personne GetPersonne(int id)
        {
            using (PersonneDal ctx = new PersonneDal())
            {
                return ctx.GetPersonne(id);
            }
        }

        public List<personne> GetPersonne()
        {
            using (PersonneDal ctx = new PersonneDal())
            {
                return ctx.GetPersonne();
            }
        }

        public static int AddPersonne(personne personne)
        {
            using (PersonneDal ctx = new PersonneDal())
            {
                int id = ctx.AddPersonne(personne);
                return id;
            }
        }
    }
}
