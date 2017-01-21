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
    public class A_symptomeController : ApiController
    {
        // GET: api/A_symptome
        public List<a_symptomes> Get()
        {
            ASymptomeBll bll = new ASymptomeBll();
            return bll.GetA_symptome();
        }

        // GET: api/A_symptome/5
        public a_symptomes Get(int id)
        {
            ASymptomeBll bll = new ASymptomeBll();
            return bll.GetA_symptome(id);
        }

        // POST: api/A_symptome
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/A_symptome/5
        public void Put()
        {
            //TODO
        }

        // DELETE: api/A_symptome/5
        public void Delete(int id)
        {
        }
    }
}
