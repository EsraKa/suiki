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
        }
        public List<a_symptomes> GetA_symptome()
        {
            var res = from ex in context.a_symptomes
                      select ex;
            return res.ToList<a_symptomes>();
        }

        public void AddA_symptome(a_symptomes a_symptomes)
        {
            context.a_symptomes.Add(a_symptomes);
        }
    }
}
