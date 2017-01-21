using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dal
{
    public class PhaseDal : BaseDal
    {
        public phase GetPhase(int id)
        {
            var res = from ex in context.phases
                      where ex.ID_PHASE == id
                      select ex;
            return res.FirstOrDefault();
        }
        public List<phase> GetPhase()
        {
            var res = from ex in context.phases
                      select ex;
            return res.ToList<phase>();
        }

        public void AddPhase(phase phase)
        {
            context.phases.Add(phase);
        }
    }
}
