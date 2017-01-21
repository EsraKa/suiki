using Dal;
using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BLL
{
    public class SymptomeBll
    {
        public symptome GetSymptome(int id)
        {
            using (SymptomeDal ctx = new SymptomeDal())
            {
                return ctx.GetSymptome(id);
            }
        }
        public List<symptome> GetPersonne()
        {
            using (SymptomeDal ctx = new SymptomeDal())
            {
                return ctx.GetSymptome();
            }
        }

        public List<symptome> GetSymptome()
        {
            throw new NotImplementedException();
        }

        public static void AddSymptome(symptome symptome)
        {
            using (SymptomeDal ctx = new SymptomeDal())
            {
                ctx.AddSymptome(symptome);
            }
        }
    }
}
