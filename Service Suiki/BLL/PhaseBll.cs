using Dal;
using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BLL
{
    public class PhaseBll
    {
        public phase GetPhase(int id)
        {
            using (PhaseDal ctx = new PhaseDal())
            {
                return ctx.GetPhase(id);
            }
        }

        public List<phase> GetPhase()
        {
            using (PhaseDal ctx = new PhaseDal())
            {
                return ctx.GetPhase();
            }
        }

        public static void AddPhase(phase phase)
        {
            using (PhaseDal ctx = new PhaseDal())
            {
                ctx.AddPhase(phase);
            }
        }
    }
}
