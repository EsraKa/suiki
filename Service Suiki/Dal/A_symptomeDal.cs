using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dal
{
   public class A_symptomeDal : BaseDal
    {
        public a_symptomes GetA_symptome(int id)
        {
            //TODO
            return null;
        }
        public List<a_symptomes> GetA_symptome()
        {
            var res = from ex in context.a_symptomes
                      select ex;
            return res.ToList<a_symptomes>();
        }

        public void AddA_symptome(a_symptomes symptomes)
        {
            context.a_symptomes.Add(symptomes);
        }
    }
}
