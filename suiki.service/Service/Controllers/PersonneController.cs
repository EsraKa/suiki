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
    public class PersonneController : ApiController
    {
        // GET: api/Personne
        public List<personne> Get()
        {
            PersonneBll bll = new PersonneBll();
            return bll.GetPersonne();
        }

        // GET: api/Personne/5
        public personne Get(int id)
        {
            PersonneBll bll = new PersonneBll();
            return bll.GetPersonne(id);
        }

        // POST: api/Personne
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Personne/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Personne/5
        public void Delete(int id)
        {
        }
    }
}
