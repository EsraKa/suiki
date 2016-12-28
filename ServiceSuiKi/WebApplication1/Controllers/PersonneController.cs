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
    public class PersonneController : ApiController
    {
        // GET: api/Personne/nom/prenom
        [Route("api/Personne/{nom}/{prenom}")]
        [HttpGet]
        [WebMethod]
        [ScriptMethod(ResponseFormat = ResponseFormat.Json)]
        public string Get(string nom , string prenom)
        {
            using (var ctx = new suikiEntities())
            {
                var res = from personnes in ctx.personnes
                    where   personnes.NOM_PERSONNE == nom 
                            && personnes.PRENOM_PERSONNE == prenom
                    select  personnes;
                return new JavaScriptSerializer().Serialize(res.FirstOrDefault());
            }
        }

        // GET: api/Personne
        [Route("api/Personne/")]
        [WebMethod]
        [ScriptMethod(ResponseFormat = ResponseFormat.Json)]
        public string Get()
        {
            using (var ctx = new suikiEntities())
            {
                var res = from personnes in ctx.personnes
                    select personnes;
                return (new JavaScriptSerializer()).Serialize(res.ToArray());
            }
        }

        // POST: api/Personne
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Personne/5
        [Route("api/Personne/{nom}/{prenom}/{mail}/{patientMedecin}")]
        [HttpPut]
        [WebMethod]
        public void Put(string nom, string prenom, string mail, string patientMedecin)
        {
            using (var ctx = new suikiEntities())
            {
                try
                {
                    personne pers = new personne();
                    pers.NOM_PERSONNE = nom;
                    pers.PRENOM_PERSONNE = prenom;
                    pers.MAIL = mail;
                    pers.PATIENT_MEDECIN = patientMedecin;
                    ctx.personnes.Add(pers);
                }
                catch (Exception e)
                {
                }
            }
        }

        // DELETE: api/Personne/5
        public void Delete(int id)
        {
            using (var ctx = new suikiEntities())
            {
                personne pers = ctx.personnes.FirstOrDefault(x => x.ID_PERSONNE == id);
                ctx.personnes.Remove(pers);
            }
        }
    }
}
