INSERT INTO countries (name, continent)
VALUES ('Macedonia', 'Europe'),
       ('Serbia', 'Europe'),
       ('Croatia', 'Europe'),
       ('Germany', 'Europe'),
       ('France', 'Europe'),
       ('Italy', 'Europe');

INSERT INTO hosts (created_at, updated_at, name, surname, country_id)
VALUES (NOW(), NOW(), 'Aleksandar', 'Petrov', 1),
       (NOW(), NOW(), 'Marija', 'Jovanovska', 1),
       (NOW(), NOW(), 'Ivan', 'Nikolic', 2),
       (NOW(), NOW(), 'Stefan', 'Müller', 4),
       (NOW(), NOW(), 'Sophie', 'Dubois', 5),
       (NOW(), NOW(), 'Luca', 'Rossi', 6);

INSERT INTO accommodations (created_at, updated_at, name, category, condition, rented, num_rooms, host_id)
VALUES (NOW(), NOW(), 'Cozy Room in Skopje Center', 'ROOM', 'GOOD', FALSE, 1, 1),
       (NOW(), NOW(), 'Modern Flat near City Park', 'FLAT', 'GOOD', FALSE, 2, 1),
       (NOW(), NOW(), 'Family House in Aerodrom', 'HOUSE', 'GOOD', FALSE, 4, 2),
       (NOW(), NOW(), 'Studio Apartment Vodno View', 'APARTMENT', 'GOOD', FALSE, 1, 2),
       (NOW(), NOW(), 'Budget Room Belgrade', 'ROOM', 'BAD', FALSE, 1, 3),
       (NOW(), NOW(), 'Luxury Hotel Suite Zagreb', 'HOTEL', 'GOOD', TRUE, 3, 3),
       (NOW(), NOW(), 'Mountain Motel Kopaonik', 'MOTEL', 'GOOD', FALSE, 2, 3),
       (NOW(), NOW(), 'Berlin City Apartment', 'APARTMENT', 'GOOD', FALSE, 2, 4),
       (NOW(), NOW(), 'Paris Studio Flat', 'FLAT', 'GOOD', TRUE, 1, 5),
       (NOW(), NOW(), 'Rome Holiday House', 'HOUSE', 'GOOD', FALSE, 5, 6);