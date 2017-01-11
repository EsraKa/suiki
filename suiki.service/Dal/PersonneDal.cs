using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dal
{
    public class PersonneDal : BaseDal
    {
        public personne GetPersonne(int id)
        {
            var res = from ex in context.personnes
                      where ex.ID_PERSONNE == id
                      select ex;
            return res.FirstOrDefault();
        }
        public List<personne> GetPersonne()
        {
            var res = from ex in context.personnes
                      select ex;
            return res.ToList<personne>();
        }

    }
}
