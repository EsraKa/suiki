using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace DomainModel
{
    [DataContract]
    public class User
    {
        public string Pseudo { get; set; }
        public string Password { get; set; }
        public int Type { get; set; }

    }
}
