using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dal
{
    public class PathologieDal : BaseDal
    {
        public pathologie GetPathologie(int id)
        {
            var res = from ex in context.pathologies
                      where ex.ID_PATHOLOGIE== id
                      select ex;
            return res.FirstOrDefault();
        }
        public List<pathologie> GetPathologie()
        {
            var res = from ex in context.pathologies
                      select ex;
            return res.ToList<pathologie>();
        }

        public void AddPathologie(pathologie pathologie)
        {
            context.pathologies.Add(pathologie);
        }
    }
}
