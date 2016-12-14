--
-- Base de données :  sui-ki
-- Modifié par KADI Massil

-- --------------------------------------------------------

--
-- Structure de la table a_symptomes
--

CREATE TABLE a_symptomes (
  ID_SYMPTOME int not null,
  ID_PERSONNE int not null
) ;

--
-- Contenu de la table a_symptomes
--

INSERT INTO a_symptomes (ID_SYMPTOME, ID_PERSONNE) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table exercice
--

CREATE TABLE exercice (
  ID_EXERCICE int NOT NULL,
  NOM varchar(50) NOT NULL,
  DESCRIPTION varchar(200) NOT NULL,
  LIEN varchar(200) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Structure de la table fiche_medical
--

CREATE TABLE fiche_medical (
  ID_FICHE int NOT NULL,
  ID_PATHOLOGIE int NOT NULL,
  ID_PERSONNE int NOT NULL,
  ID_PHASE int NOT NULL
) ;

-- --------------------------------------------------------

--
-- Structure de la table pathologie
--

CREATE TABLE pathologie (
  ID_PATHOLOGIE int NOT NULL,
  NOM varchar(50) NOT NULL,
  DESCRIPTION varchar(200) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Structure de la table personne
--

CREATE TABLE personne (
  ID_PERSONNE int NOT NULL,
  ID_USER int NOT NULL,
  NOM_PERSONNE varchar(50) NOT NULL,
  PRENOM_PERSONNE varchar(50) NOT NULL,
  MAIL varchar(50) NOT NULL,
  PATIENT_MEDECIN varchar(1) NOT NULL
) ;

--
-- Contenu de la table personne
--

INSERT INTO personne (ID_PERSONNE, ID_USER, NOM_PERSONNE, PRENOM_PERSONNE, MAIL, PATIENT_MEDECIN) VALUES
(1, 1, 'Zidane', 'Zinedine', 'zz@gmail.com', 'P'),
(2, 2, 'Leboeuf', 'Franck', 'franckie@hotmail.fr', 'P'),
(3, 3, 'Jacquet', 'Aimé', 'campeones@free.fr', 'M');

-- --------------------------------------------------------

--
-- Structure de la table phase
--

CREATE TABLE phase (
  ID_PHASE int NOT NULL,
  NOM_PHASE varchar(15) NOT NULL,
  DESCRIPTION varchar(200) NOT NULL
) ;

--
-- Contenu de la table phase
--

INSERT INTO phase (ID_PHASE, NOM_PHASE, DESCRIPTION) VALUES
(1, 'Algique', 'Phase de douleur'),
(2, 'Rééducation', 'Phase de rééducation'),
(3, 'Consolidation', 'Phase de consolidation, renforcement');

-- --------------------------------------------------------

--
-- Structure de la table phase_exercice
--

CREATE TABLE phase_exercice (
  ID_PHASE int NOT NULL,
  ID_EXERCICE int NOT NULL
) ;

-- --------------------------------------------------------

--
-- Structure de la table symptomes
--

CREATE TABLE symptomes (
  ID_SYMPTOME int NOT NULL,
  NOM varchar(50) NOT NULL,
  DESCRIPTION varchar(200) NOT NULL
) ;

--
-- Contenu de la table symptomes
--

INSERT INTO symptomes (ID_SYMPTOME, NOM, DESCRIPTION) VALUES(1, 'Mal dos ', 'Douleur dans le dos'),
(2, 'Mal cervical', 'Douleur aux cervicales'),
(3, 'Entorse cheville', 'Aie j ai mal à la cheville');

-- --------------------------------------------------------

--
-- Structure de la table user
--

CREATE TABLE utilisateur (
  ID_USER int NOT NULL,
  NOM_UTILISATEUR varchar(30) NOT NULL,
  MOT_DE_PASSE varchar(15) NOT NULL
) ;

--
-- Index pour les tables exportées
--

--
-- Index pour la table fiche_medical
--
ALTER TABLE fiche_medical
  ADD PRIMARY KEY (ID_FICHE);

--
-- Index pour la table pathologie
--
ALTER TABLE pathologie
  ADD PRIMARY KEY (ID_PATHOLOGIE);

--
-- Index pour la table personne
--
ALTER TABLE personne
  ADD PRIMARY KEY (ID_PERSONNE);

--
-- Index pour la table phase
--
ALTER TABLE phase
  ADD PRIMARY KEY (ID_PHASE);

--
-- Index pour la table symptomes
--
ALTER TABLE symptomes
  ADD PRIMARY KEY (ID_SYMPTOME);

--
-- Index pour la table user
--
ALTER TABLE Users
  ADD PRIMARY KEY (ID_USER);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
