using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace WebApplication1.Models
{
    [DataContract]
    public class Personne
    {
        [DataMember]
        public string nom { get; set; }
        [DataMember]
        public string prenom { get; set; }
    }
}