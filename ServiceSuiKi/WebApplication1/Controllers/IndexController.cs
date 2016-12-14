using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using DomainModel;

namespace WebApplication1.Controllers
{
    public class IndexController : ApiController
    {
        // GET: api/Index
        public List<personne> Get()
        {
            suikiEntities context = new suikiEntities();
            var personnes = context.personnes.ToList();
            return personnes;
        }

        // GET: api/Index/5
        public string Get(int id)
        {
            return "value";
        }

        // POST: api/Index
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Index/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Index/5
        public void Delete(int id)
        {
        }
    }
}
