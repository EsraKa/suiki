using BLL;
using Dal;
using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace labo.Controllers
{
    public class SymptomesController : ApiController
    {
        // GET: api/Symptomes
        public List<symptome> Get()
        {
            SymptomeBll bll  = new SymptomeBll();
            return bll.GetSymptome();
        }
        // GET: api/Symptomes/5
        public symptome Get(int id)
        {
            SymptomeBll bll = new SymptomeBll();
            return bll.GetSymptome(id);
        }

        // POST: api/Symptomes
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Symptomes/5
        public void Put(string nom, string description)
        {
            symptome symptome = new symptome();

            symptome.NOM = nom;
            symptome.DESCRIPTION = description;
            

            SymptomeBll.AddSymptome(symptome);
        }

        // DELETE: api/Symptomes/5
        public void Delete(int id)
        {
        }
    }
}
