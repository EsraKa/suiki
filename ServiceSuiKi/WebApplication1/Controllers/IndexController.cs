using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Dal;
using DomainModel;

namespace WebApplication1.Controllers
{
    public class IndexController : ApiController
    {
        // GET: api/Index
        public Personne Get()
        {            
            Context context = new Context();
            return context.Personnes.FirstOrDefault(x => x.Id_Perso == 1);
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
