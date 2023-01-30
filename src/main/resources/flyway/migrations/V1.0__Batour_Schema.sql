DROP TABLE IF EXISTS player_games;
DROP TABLE IF EXISTS states;
DROP TABLE IF EXISTS information;
DROP TABLE IF EXISTS games;
DROP TABLE IF EXISTS player;


CREATE TABLE player (
  player_pk int unsigned NOT NULL AUTO_INCREMENT,
  age int NOT NULL,
  date_birth date NOT NULL,
  username varchar(45) NOT NULL,
  PRIMARY KEY (player_pk)
);

CREATE TABLE games (
  games_pk int unsigned NOT NULL AUTO_INCREMENT,
  games_anotation varchar(2500) NOT NULL,
  games_date date NOT NULL,
  PRIMARY KEY (games_pk)
);


CREATE TABLE states (
  state_pk int unsigned NOT NULL AUTO_INCREMENT,
  player_fk int unsigned,
  state_name varchar(16) NOT NULL,
  PRIMARY KEY (state_pk),
  FOREIGN KEY (player_fk) REFERENCES player (player_pk) ON DELETE CASCADE
);

CREATE TABLE player_games (
  player_fk int unsigned NOT NULL,
  games_fk int unsigned NOT NULL,
  FOREIGN KEY (player_fk) REFERENCES player (player_pk) ON DELETE CASCADE,
  FOREIGN KEY (games_fk) REFERENCES games (games_pk) ON DELETE CASCADE
);
