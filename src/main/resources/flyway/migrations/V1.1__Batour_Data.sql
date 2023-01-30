-- players
INSERT INTO player (username, age, date_birth) VALUES('liono', 24, '1999-01-01');
INSERT INTO player (username, age, date_birth) VALUES('excaliber', 23, '1999-11-14');
INSERT INTO player (username, age, date_birth) VALUES('Kaitlyn09', 20, '2002-12-09');
INSERT INTO player (username, age, date_birth) VALUES('MagnusCarlsen', 32, '1990-11-30');
INSERT INTO player (username, age, date_birth) VALUES('hikaru', 35, '1987-12-09');
INSERT INTO player (username, age, date_birth) VALUES('dingliren', 30, '1992-10-24');
INSERT INTO player (username, age, date_birth) VALUES('fabiano', 30, '1992-06-30');



-- states
INSERT INTO states (state_name, player_fk) VALUES('ALABAMA', NULL);
INSERT INTO states (state_name, player_fk) VALUES('ALASKA', NULL);
INSERT INTO states (state_name, player_fk) VALUES('ARIZONA', 1);
INSERT INTO states (state_name, player_fk) VALUES('ARKANSAS', 1);
INSERT INTO states (state_name, player_fk) VALUES('CALIFORNIA', 2);
INSERT INTO states (state_name, player_fk) VALUES('COLORAD0', 3);
INSERT INTO states (state_name, player_fk) VALUES('CONNECTICUT', 3);
INSERT INTO states (state_name, player_fk) VALUES('DELAWARE', 4);
INSERT INTO states (state_name, player_fk) VALUES('FLORIDA', NULL);
INSERT INTO states (state_name, player_fk) VALUES('GEORGIA', NULL);
INSERT INTO states (state_name, player_fk) VALUES('HAWAII', NULL);
INSERT INTO states (state_name, player_fk) VALUES('IDAHO', NULL);
INSERT INTO states (state_name, player_fk) VALUES('ILLINOIS', NULL);
INSERT INTO states (state_name, player_fk) VALUES('INDIANA', 5);
INSERT INTO states (state_name, player_fk) VALUES('IOWA', 5);
INSERT INTO states (state_name, player_fk) VALUES('KANSAS', 5);
INSERT INTO states (state_name, player_fk) VALUES('KENTUCKY', NULL);
INSERT INTO states (state_name, player_fk) VALUES('LOUISIANA', NULL);
INSERT INTO states (state_name, player_fk) VALUES('MAINE', NULL);
INSERT INTO states (state_name, player_fk) VALUES('MARYLAND', NULL);
INSERT INTO states (state_name, player_fk) VALUES('MASSACHUSETTS', 6);
INSERT INTO states (state_name, player_fk) VALUES('MICHIGAN', NULL);
INSERT INTO states (state_name, player_fk) VALUES('MINNESOTA', NULL);
INSERT INTO states (state_name, player_fk) VALUES('MISSISSIPPI', NULL);
INSERT INTO states (state_name, player_fk) VALUES('MISSOURI', NULL);
INSERT INTO states (state_name, player_fk) VALUES('MONTANA', 7);
INSERT INTO states (state_name, player_fk) VALUES('NEBRASKA', NULL);
INSERT INTO states (state_name, player_fk) VALUES('NEVADA', NULL);
INSERT INTO states (state_name, player_fk) VALUES('NEW HAMPSHIRE', NULL);
INSERT INTO states (state_name, player_fk) VALUES('NEW JERSEY', NULL);
INSERT INTO states (state_name, player_fk) VALUES('NEW MEXICO', NULL);
INSERT INTO states (state_name, player_fk) VALUES('NEW YORK', NULL);
INSERT INTO states (state_name, player_fk) VALUES('NORTH CAROLINA', NULL);
INSERT INTO states (state_name, player_fk) VALUES('NORTH DAKOTA', NULL);
INSERT INTO states (state_name, player_fk) VALUES('OHIO', NULL);
INSERT INTO states (state_name, player_fk) VALUES('OKLAHOMA', NULL);
INSERT INTO states (state_name, player_fk) VALUES('OREGON', NULL);
INSERT INTO states (state_name, player_fk) VALUES('PENNSYLVANIA', NULL);
INSERT INTO states (state_name, player_fk) VALUES('RHODE ISLAND', NULL);
INSERT INTO states (state_name, player_fk) VALUES('SOUTH CAROLINA', NULL);
INSERT INTO states (state_name, player_fk) VALUES('SOUTH DAKOTA', NULL);
INSERT INTO states (state_name, player_fk) VALUES('TENNESSEE', NULL);
INSERT INTO states (state_name, player_fk) VALUES('TEXAS', NULL);
INSERT INTO states (state_name, player_fk) VALUES('UTAH', NULL);
INSERT INTO states (state_name, player_fk) VALUES('VERMONT', NULL);
INSERT INTO states (state_name, player_fk) VALUES('VIRGINIA', NULL);
INSERT INTO states (state_name, player_fk) VALUES('WASHINGTON', NULL);
INSERT INTO states (state_name, player_fk) VALUES('WEST VIRGINIA', NULL);
INSERT INTO states (state_name, player_fk) VALUES('WISCONSIN', NULL);
INSERT INTO states (state_name, player_fk) VALUES('WYOMING', NULL);
INSERT INTO states (state_name, player_fk) VALUES('WASHINGTON DC', NULL);


-- games
INSERT INTO games (games_anotation, games_date) VALUES('queens gambit', '2023-01-01');
INSERT INTO games (games_anotation, games_date) VALUES('kings gambit', '2023-01-01');
INSERT INTO games (games_anotation, games_date) VALUES('ruy lopez', '2023-01-01');
INSERT INTO games (games_anotation, games_date) VALUES('the barcza system', '2023-01-01');
INSERT INTO games (games_anotation, games_date) VALUES('the london system', '2023-01-01');
INSERT INTO games (games_anotation, games_date) VALUES('bird-larsen attack', '2023-01-01');
INSERT INTO games (games_anotation, games_date) VALUES('blackmar-diemer gambit', '2023-01-01');
INSERT INTO games (games_anotation, games_date) VALUES('the colle system', '2023-01-01');
INSERT INTO games (games_anotation, games_date) VALUES('the english opening', '2023-01-01');
INSERT INTO games (games_anotation, games_date) VALUES('the stonewall attack', '2023-01-01');

-- player_games
INSERT INTO player_games (games_fk, player_fk) VALUES(1, 1);
INSERT INTO player_games (games_fk, player_fk) VALUES(1, 2);
INSERT INTO player_games (games_fk, player_fk) VALUES(2, 2);
INSERT INTO player_games (games_fk, player_fk) VALUES(2, 3);
INSERT INTO player_games (games_fk, player_fk) VALUES(3, 3);
INSERT INTO player_games (games_fk, player_fk) VALUES(3, 4);
INSERT INTO player_games (games_fk, player_fk) VALUES(4, 4);
INSERT INTO player_games (games_fk, player_fk) VALUES(4, 5);
INSERT INTO player_games (games_fk, player_fk) VALUES(5, 5);
INSERT INTO player_games (games_fk, player_fk) VALUES(5, 6);
INSERT INTO player_games (games_fk, player_fk) VALUES(6, 6);
INSERT INTO player_games (games_fk, player_fk) VALUES(6, 7);
INSERT INTO player_games (games_fk, player_fk) VALUES(7, 7);
INSERT INTO player_games (games_fk, player_fk) VALUES(7, 3);
INSERT INTO player_games (games_fk, player_fk) VALUES(8, 2);
INSERT INTO player_games (games_fk, player_fk) VALUES(8, 5);
INSERT INTO player_games (games_fk, player_fk) VALUES(9, 1);
INSERT INTO player_games (games_fk, player_fk) VALUES(9, 4);
INSERT INTO player_games (games_fk, player_fk) VALUES(10, 3);
INSERT INTO player_games (games_fk, player_fk) VALUES(10, 7);

