using BLL;
using Dal;
using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BLL
{
    public class ExerciceBll
    {
        public exercice GetExercice(int id)
        {
            using (ExerciceDal ctx = new ExerciceDal())
            {
                return ctx.GetExercice(id);
            }
        }
    }
}
