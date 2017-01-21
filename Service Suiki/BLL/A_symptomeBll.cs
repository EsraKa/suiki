using Dal;
using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BLL
{
    public class A_symptomeBll
    {
        public a_symptomes GetA_symptome(int id)
        {
            using (A_symptomeDal ctx = new A_symptomeDal())
            {
                return ctx.GetA_symptome(id);
            }
        }

        public List<a_symptomes> GetA_symptome()
        {
            using (A_symptomeDal ctx = new A_symptomeDal())
            {
                return ctx.GetA_symptome();
            }
        }

        public static void AddA_symptome(a_symptomes a_symptome)
        {
            using (A_symptomeDal ctx = new A_symptomeDal())
            {
                ctx.AddA_symptome(a_symptome);
            }
        }
    }
}
