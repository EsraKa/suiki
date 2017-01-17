using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace labo.Controllers
{
    public class InscriptionController : ApiController
    {
        // GET: api/Inscription
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET: api/Inscription/5
        public string Get(int id)
        {
            return "value";
        }

        // POST: api/Inscription
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Inscription/5
        public void Put(string pseudo, string password, string nom, string prenom, string mail, string patient_medecin)
        {

        }

        // DELETE: api/Inscription/5
        public void Delete(int id)
        {
        }
    }
}
