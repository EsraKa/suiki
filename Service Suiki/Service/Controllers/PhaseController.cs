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
    public class PhaseController : ApiController
    {
        // GET: api/Phase
        public List<phase> Get()
        {
            PhaseBll bll = new PhaseBll();
            return bll.GetPhase();
        }

        // GET: api/Phase/5
        public phase Get(int id)
        {
            PhaseBll bll = new PhaseBll();
            return bll.GetPhase(id);
        }

        // POST: api/Phase
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Phase/5
        public void Put(string nom, string description)
        {
            phase phase = new phase();

            phase.NOM_PHASE = nom;
            phase.DESCRIPTION =description;
            
            PhaseBll.AddPhase(phase);
        }

        // DELETE: api/Phase/5
        public void Delete(int id)
        {
        }
    }
}
