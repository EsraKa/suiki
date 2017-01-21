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
        public List<exercice> Get()
        {
            ExerciceBll bll = new ExerciceBll();
            return bll.GetExercice();
        }

        // GET: api/Exercice/5
        public exercice Get(int id)
        {
            ExerciceBll bll = new ExerciceBll();
            return bll.GetExercice(id);
        }

        // POST: api/Exercice
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/Exercice/5
        public void Put(string nom, string description, string lien)
        {
            exercice exercice = new exercice();

            exercice.NOM = nom;
            exercice.DESCRIPTION = description;
            exercice.LIEN = lien;

            ExerciceBll.AddExercice(exercice);
        }

        // DELETE: api/Exercice/5
        public void Delete(int id)
        {
        }
    }
}
