using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace WebApplication1.Controllers
{
    public class UtilisateurController : ApiController
    {
        // GET: api/Utilisateur
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET: api/Utilisateur/5
        public string Get(int id)
        {
            return "value";
        }

        // POST: api/Utilisateur
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Utilisateur/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Utilisateur/5
        public void Delete(int id)
        {
        }
    }
}
