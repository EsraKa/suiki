using BLL;
using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace labo.Controllers
{
    public class PathologieController : ApiController
    {
        // GET: api/Pathologie
        public List<pathologie> Get()
        {
            PathologieBll bll = new PathologieBll();
            return bll.GetPathologie();
        }

        // GET: api/Pathologie/5
        public pathologie Get(int id)
        {
            PathologieBll bll = new PathologieBll();
            return bll.GetPathologie(id);
        }

        // POST: api/Pathologie
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Pathologie/5
        public void Put(string nom, string description)
        {
            pathologie pathologie = new pathologie();

            pathologie.NOM = nom;
            pathologie.DESCRIPTION = description;

            PathologieBll.AddPathologie(pathologie);
        }

        // DELETE: api/Pathologie/5
        public void Delete(int id)
        {
        }
    }
}
