using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dal
{
    public class SymptomeDal : BaseDal
    {
        public symptome GetSymptome(int id)
        {
            var res = from ex in context.symptomes
                      where ex.ID_SYMPTOME == id
                      select ex;
            return res.FirstOrDefault();
        }
       public List<symptome> GetSymptome()
        {
            var res = from ex in context.symptomes
                      select ex;
            return res.ToList<symptome>();
        }
        public void AddSymptome(symptome symptome)
        {
            context.symptomes.Add(symptome);
        }
    }
}
