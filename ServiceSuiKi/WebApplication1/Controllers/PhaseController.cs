using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Script.Serialization;
using System.Web.Script.Services;
using System.Web.Services;
using DomainModel;

namespace WebApplication1.Controllers
{
    [WebService]
    public class PhaseController : ApiController
    {
        // GET: api/Phase
        [Route("api/Phase/{nom}")]
        [HttpGet]
        [WebMethod]
        [ScriptMethod(ResponseFormat = ResponseFormat.Json)]
        public string Get(string nom)
        {
            using (var ctx = new suikiEntities())
            {
                var res = from phase in ctx.phases
                    where phase.NOM_PHASE == nom
                    select phase;
                return new JavaScriptSerializer().Serialize(res);
            }
            
        }

        // GET: api/Phase/5
        [Route("api/phase")]
        [HttpGet]
        [WebMethod]
        [ScriptMethod(ResponseFormat = ResponseFormat.Json)]
        public string Get()
        {
            using (var ctx = new suikiEntities())
            {
                var res = from phase in ctx.phases
                    select phase;
                return new JavaScriptSerializer().Serialize(res);
            }
        }

        // POST: api/Phase
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Phase/5
        
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Phase/5
        public void Delete(int id)
        {
        }
    }
}
