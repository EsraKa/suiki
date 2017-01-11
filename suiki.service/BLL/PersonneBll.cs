using Dal;
using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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

        public static void AddPersonne(personne personne)
        {
            using (PersonneDal ctx = new PersonneDal())
            {
                ctx.AddPersonne(personne);
            }
        }
    }
}
