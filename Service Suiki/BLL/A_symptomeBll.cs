using System.Collections.Generic;
using Dal;
using Model;

namespace BLL
{
    public class ASymptomeBll
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

        public static void AddA_symptome(a_symptomes aSymptome)
        {
            using (A_symptomeDal ctx = new A_symptomeDal())
            {
                ctx.AddA_symptome(aSymptome);
            }
        }
    }
}
