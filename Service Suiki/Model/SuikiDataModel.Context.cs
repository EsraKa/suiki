﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Ce code a été généré à partir d'un modèle.
//
//     Des modifications manuelles apportées à ce fichier peuvent conduire à un comportement inattendu de votre application.
//     Les modifications manuelles apportées à ce fichier sont remplacées si le code est régénéré.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Model
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    
    public partial class suikiEntities : DbContext
    {
        public suikiEntities()
            : base("name=suikiEntities")
        {
        }
    
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            throw new UnintentionalCodeFirstException();
        }
    
        public virtual DbSet<fiche_medical> fiche_medical { get; set; }
        public virtual DbSet<pathologie> pathologies { get; set; }
        public virtual DbSet<personne> personnes { get; set; }
        public virtual DbSet<phase> phases { get; set; }
        public virtual DbSet<symptome> symptomes { get; set; }
        public virtual DbSet<utilisateur> utilisateurs { get; set; }
        public virtual DbSet<a_symptomes> a_symptomes { get; set; }
        public virtual DbSet<exercice> exercices { get; set; }
        public virtual DbSet<phase_exercice> phase_exercice { get; set; }
    }
}