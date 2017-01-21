using Dal;
using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BLL
{
    public class PathologieBll
    {
        public pathologie GetPathologie(int id)
        {
            using (PathologieDal ctx = new PathologieDal())
            {
                return ctx.GetPathologie(id);
            }
        }

        public List<pathologie> GetPathologie()
        {
            using (PathologieDal ctx = new PathologieDal())
            {
                return ctx.GetPathologie();
            }
        }

        public static void AddPathologie(pathologie pathologie)
        {
            using (PathologieDal ctx = new PathologieDal())
            {
                ctx.AddPathologie(pathologie);
            }
        }
    }
}
