using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace WebApplication1.Controllers
{
    public class PhaseExerciceController : ApiController
    {
        // GET: api/PhaseExercice
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET: api/PhaseExercice/5
        public string Get(int id)
        {
            return "value";
        }

        // POST: api/PhaseExercice
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/PhaseExercice/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/PhaseExercice/5
        public void Delete(int id)
        {
        }
    }
}
