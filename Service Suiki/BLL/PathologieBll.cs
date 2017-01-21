using System.Collections.Generic;
using Dal;
using Model;

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
