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
    public class ExerciceController : ApiController
    {
        // GET: api/Exercice
        public exercice Get()
        {
            ExerciceBll bll = new ExerciceBll();
            return bll.GetExercice(1);
        }

        // GET: api/Exercice/5
        public string Get(int id)
        {
            return "value";
        }

        // POST: api/Exercice
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Exercice/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Exercice/5
        public void Delete(int id)
        {
        }
    }
}
