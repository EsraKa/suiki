using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dal
{
    public class ExerciceDal : BaseDal
    {
        public exercice GetExercice(int id)
        {
            var res = from ex in context.exercices
                      where ex.ID_EXERCICE == id
                      select ex;
            return res.FirstOrDefault();
        }
    }
}
