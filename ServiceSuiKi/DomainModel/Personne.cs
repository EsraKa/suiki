using System.Net.Mail;

namespace DomainModel
{
    public class Personne
    {
        public int Id_Perso { get; set; }
        public int Id_User { get; set; }
        public string Nom_Personne { get; set; }
        public string Prenom_Personne { get; set; }
        public MailAddress Mail { get; set; }
        public string Patient_Medecin { get; set; }
    }
}